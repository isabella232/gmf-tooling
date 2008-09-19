/*
 * <copyright>
 *
 * Copyright (c) 2005-2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Alexander Shatalin (Borland)
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.expression.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.migration.ExpressionAnalyzeTrace;
import org.eclipse.gmf.internal.xpand.migration.FeatureCallTrace;
import org.eclipse.gmf.internal.xpand.migration.MigrationExecutionContext;
import org.eclipse.gmf.internal.xpand.migration.FeatureCallTrace.Type;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class FeatureCall extends Expression {

    private Expression target;

    private final Identifier name;

    public FeatureCall(final int start, final int end, final int line, final int startOffset, final int endOffset, final Identifier name, final Expression target) {
        super(start, end, line, startOffset, endOffset);
        this.target = target;
        this.name = name;
    }

    public Expression getTarget() {
        return target;
    }

    public void setTarget(final Expression target) {
        this.target = target;
    }

    public Identifier getName() {
        return name;
    }

    public EEnumLiteral getEnumLiteral(final ExecutionContext ctx) {
        if (name.getValue().indexOf(SyntaxConstants.NS_DELIM) != -1) {
            String typeName = name.getValue();
            typeName = typeName.substring(0, typeName.lastIndexOf(SyntaxConstants.NS_DELIM));
            final EClassifier type = ctx.getTypeForName(typeName);
            if (type != null) {
            	if (false == (type instanceof EEnum)) {
            		return null;
            	}
                final String litName = name.getValue().substring(
                        name.getValue().lastIndexOf(SyntaxConstants.NS_DELIM) + SyntaxConstants.NS_DELIM.length());
                return ((EEnum) type).getEEnumLiteral(litName);
            }
        }
        return null;
    }

    /**
     * evaluates in the following order if (target==null) 1) enumeration literal
     * 2) variable 3) implicite var (e.g. this) 4) type literal
     * 
     * otherwise it's a property
     */
    @Override
    public Object evaluateInternal(final ExecutionContext ctx) {
        Object targetObj = null;
        if (target == null) {
            final EEnumLiteral staticProp = getEnumLiteral(ctx);
            if (staticProp != null) {
            	// XXX write tests to make sure
            	// switch (enumField) case EnumName::LITERAL1 
            	// works
				return staticProp.getInstance();
			}
            Variable var = ctx.getVariable(getName().getValue());
            if (var != null) {
				return var.getValue();
			}

            var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
            if (var != null) {
                targetObj = var.getValue();
                if (targetObj == null) {
					return null;
				}
            }
        } else {
            targetObj = getTarget().evaluate(ctx);
            if (targetObj == null) {
				return null;
			}
        }
        if (targetObj != null) {
    		EClassifier targetObjType = BuiltinMetaModel.getType(targetObj);
            final EStructuralFeature p = BuiltinMetaModel.getAttribute(targetObjType, getName().getValue());
            if ((p == null) && (targetObj instanceof Collection)) {
                return handleCollection(ctx, (Collection) targetObj);
            }
            if (p != null) {
				return BuiltinMetaModel.getValue(p, targetObj);
			}
        }
        if (target == null) {
            // type literal ?
            final EClassifier type = ctx.getTypeForName(getName().getValue());
            if (type != null) {
				return type;
			}
        }
        if (getName().getValue().indexOf(SyntaxConstants.NS_DELIM) != -1) {
			throw new EvaluationException("Couldn't find enum literal or type '" + getName().getValue() + "'", this);
		}
        if (target == null) {
			throw new EvaluationException("Couldn't find type or property '" + getName().getValue() + "'", this);
		} else {
			throw new EvaluationException("Couldn't find property '" + getName().getValue() + "' for type "
                    + findEClassifier(targetObj, ctx).getName(), this);
		}
    }

	private Object handleCollection(final ExecutionContext ctx, final Collection col) {
		final List<Object> result = new ArrayList<Object>();
		for (final Iterator iter = col.iterator(); iter.hasNext();) {
		    final Object element = iter.next();
	        final EClassifier type = BuiltinMetaModel.getType(element);
		    final EStructuralFeature prop = BuiltinMetaModel.getAttribute(type, getName().getValue());
		    if (prop == null) {
		        throw new EvaluationException("Couldn't find property '" + getName().getValue()
		                + "' for inner type " + type + "'", this);
		    } else {
		        final Object r = BuiltinMetaModel.getValue(prop, element);
		        if (r instanceof Collection) {
		            result.addAll((Collection<?>) r);
		        } else {
		            result.add(r);
		        }
		    }
		}
		return result;
	}

    /**
     * analyzes in the following order if (target==null) 1) enumeration literal
     * 2) variable 3) implicite var (e.g. this) 4) type literal
     * 
     * otherwise it's a property
     */
    public EClassifier analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        EClassifier targetType = null;
        // XXX hmm, all visible invocations of createFeatureCall always pass null 
        // as target. Perhaps, some subclasses pass non-null, though needs some investigation
        if (target == null) {
            // enum literal
            final EEnumLiteral staticProp = getEnumLiteral(ctx);
            if (staticProp != null) {
				return createAnalyzeTrace(ctx, new FeatureCallTrace(BuiltinMetaModel.getReturnType(staticProp), staticProp));
			}

            // variable
            Variable var = ctx.getVariable(getName().getValue());
			if (var != null) {
            	assert var.getValue() == null || var.getValue() instanceof EClassifier : "variable should hold EClassifier";
            	return createAnalyzeTrace(ctx, new FeatureCallTrace((EClassifier) var.getValue(), Type.ENV_VAR_REF));
			}

            // implicite variable 'this'
            var = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
            if (var != null) {
                targetType = (EClassifier) var.getValue();
            }

        } else {
            targetType = analyzeTarget(ctx, issues);
            if (targetType == null) {
            	return createAnalyzeTrace(ctx, new FeatureCallTrace(null, Type.UNDESOLVED_TARGET_TYPE));
			}
        }

        String additionalMsg = "";
        // simple property
        if (targetType != null) {
            EStructuralFeature p = BuiltinMetaModel.getAttribute(targetType, getName().getValue());
            if (p != null) {
				return createAnalyzeTrace(ctx, new FeatureCallTrace(BuiltinMetaModel.getTypedElementType(p), p, targetType));
			}

            if ((p == null) && BuiltinMetaModel.isParameterizedType(targetType)) {
                final EClassifier innerEClassifier = BuiltinMetaModel.getInnerType(targetType);
                p = BuiltinMetaModel.getAttribute(innerEClassifier, getName().getValue());
                if (p != null) {
                    EClassifier rt = BuiltinMetaModel.getTypedElementType(p);
                    if (BuiltinMetaModel.isParameterizedType(rt)) {
                        rt = BuiltinMetaModel.getInnerType(rt);
                    }
                    return createAnalyzeTrace(ctx, new FeatureCallTrace(BuiltinMetaModel.getListType(rt), targetType));
                }
                additionalMsg = " or inner type '" + innerEClassifier + "'";
            }
        }
        if (target == null) {
            final EClassifier type = ctx.getTypeForName(getName().getValue());
            if (type != null) {
            	createAnalyzeTrace(ctx, new FeatureCallTrace(null, Type.UNSUPPORTED_CLASSIFIER_REF));
                return EcorePackage.eINSTANCE.getEClass();
            }
        }

        if (target == null) {
            String txt = "";
            if (targetType != null) {
                txt = targetType.getName() + " property, ";
            }
            issues.add(new AnalysationIssue(AnalysationIssue.Type.FEATURE_NOT_FOUND, "Unknown " + txt
                    + "variable, type or enumeration literal '" + getName().getValue() + "'", this));
            return null;
        }

        issues.add(new AnalysationIssue(AnalysationIssue.Type.FEATURE_NOT_FOUND, "Couldn't find property '"
                + getName().getValue() + "' for type '" + targetType.getName() + "'" + additionalMsg, this));
        return null;

    }
    
    protected EClassifier createAnalyzeTrace(ExecutionContext ctx, ExpressionAnalyzeTrace trace) {
    	if (ctx instanceof MigrationExecutionContext) {
    		((MigrationExecutionContext) ctx).getTraces().put(this, trace);
    	}
    	return trace.getResultType();
    }

    protected EClassifier analyzeTarget(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        return getTarget().analyze(ctx, issues);
    }

    protected EClassifier findEClassifier(final Object value, final ExecutionContext ctx) {
        final EClassifier t = BuiltinMetaModel.getType(value);
        if (t == null) {
            throw new EvaluationException("Unkown object type : " + value.getClass().getName(), this);
        }
        return t;
    }

    @Override
    public String toString() {
        return (getTarget() != null ? getTarget().toString() + "." : "") + name.getValue();
    }
    
    @Override
    public int getStartOffset() {
    	if (getTarget() != null && super.getStartOffset() > getTarget().getStartOffset()) {
    		return getTarget().getStartOffset();
    	}
    	return super.getStartOffset();
    }

}
