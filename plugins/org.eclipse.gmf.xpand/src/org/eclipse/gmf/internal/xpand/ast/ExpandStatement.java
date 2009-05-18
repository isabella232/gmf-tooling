/*
 * Copyright (c) 2005, 2009 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.ast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.model.AmbiguousDefinitionException;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.EvaluationException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;
import org.eclipse.gmf.internal.xpand.ocl.TypeHelper;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.ecore.CollectionType;

/**
 * @author Sven Efftinge
 */
public class ExpandStatement extends Statement {

    private final boolean isForeach;

    private final ExpressionHelper[] parameters;

    private final ExpressionHelper separator;

    private final ExpressionHelper target;

    private final String definition;

    public ExpandStatement(final int start, final int end, final int line, final PathNameCS definition,
            final OCLExpressionCS target, final OCLExpressionCS separator, final OCLExpressionCS[] parameters, final boolean foreach) {
        super(start, end, line);
        this.definition = TypeHelper.toString(definition);
        this.target = target == null ? null : new ExpressionHelper(target, this);
        this.separator = separator == null ? null : new ExpressionHelper(separator, this);
        if (parameters == null) {
        	this.parameters = new ExpressionHelper[0];
        } else {
        	this.parameters = new ExpressionHelper[parameters.length];
        	for (int i = 0; i < parameters.length; i++) {
        		this.parameters[i] = new ExpressionHelper(parameters[i], this);
        	}
        }
        this.isForeach = foreach;
    }

    public void analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        final EClassifier[] paramTypes = new EClassifier[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            paramTypes[i] = parameters[i].analyze(ctx, issues);

        }
        EClassifier targetType = null;
        if (isForeach) {
            targetType = target.analyze(ctx, issues);
            if (targetType instanceof CollectionType) {
                targetType = ((CollectionType) targetType).getElementType();
            } else {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.INCOMPATIBLE_TYPES, "Collection type expected!", target));
                return;
            }
        } else {
            final Variable var = ctx.getImplicitVariable();
            if (var == null) {
                issues.add(new AnalysationIssue(AnalysationIssue.Type.INTERNAL_ERROR, "No implicite variable 'this/self' could be found!", target));
                return;
            }
            targetType = var.getType();
            if (target != null) {
                targetType = target.analyze(ctx, issues);
            }
        }
        if ((targetType == null) || Arrays.asList(paramTypes).contains(null)) {
			return;
		}
        try {
	        final XpandDefinition def = ctx.findDefinition(definition, targetType, paramTypes);
	        if (def == null) {
	            issues.add(new AnalysationIssue(AnalysationIssue.Type.DEFINITION_NOT_FOUND,
	                    "Couldn't find definition " + definition + getParamTypeString(paramTypes)
	                            + " for type " + targetType.getName(), this));
	        }
        } catch (AmbiguousDefinitionException e) {
			issues.add(new AnalysationIssue(AnalysationIssue.Type.DEFINITION_NOT_FOUND, e.getMessage(), this));
        }
    }

    @Override
    public void evaluateInternal(final ExecutionContext ctx) {
        final Object[] params = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            params[i] = parameters[i].evaluate(ctx);
        }
        final String sep = (String) (separator != null ? separator.evaluate(ctx) : null);
        Object targetObject = null;
        XpandFacade xpandFacade = new XpandFacade(ctx);
        try {
	        if (isForeach) {
	            targetObject = target.evaluate(ctx);
	            if (!(targetObject instanceof Collection)) {
					throw new EvaluationException("Collection expected (was: " + targetObject.getClass().getName() + ")!", target);
				}
	
	            final Collection<?> col = (Collection<?>) targetObject;
	            for (final Iterator<?> iter = col.iterator(); iter.hasNext();) {
	                
					xpandFacade.evaluate(definition, iter.next(), params);
	                if ((sep != null) && iter.hasNext()) {
	                    ctx.getScope().getOutput().write(sep);
	                }
	            }
	
	        } else {
	            if (target != null) {
	                targetObject = target.evaluate(ctx);
	            } else {
	                final Variable var = ctx.getImplicitVariable();
	                targetObject = var.getValue();
	            }
	            if (targetObject != null) {
					xpandFacade.evaluate(definition, targetObject, params);
	            } else {
	            	// XXX logInfo that feature value is null or conditionally fail?
	            	// perhaps, could check if target is feature and multiplicity of the feature is at least 1 and fail then?
	            	// though all these checks are not template's tasks
	            }
	        }
		} catch (AmbiguousDefinitionException e) {
			throw new EvaluationException(e.getMessage(), this);
		}

    }

    private String getParamTypeString(final EClassifier[] paramTypes) {
        if (paramTypes.length == 0) {
			return "";
		}
        final StringBuffer buff = new StringBuffer("(");
        for (int i = 0; i < paramTypes.length; i++) {
            final EClassifier type = paramTypes[i];
            buff.append(type.getName());
            if (i + 1 < paramTypes.length) {
                buff.append(", ");
            }
        }
        return buff.append(")").toString();
    }

    private String getParamString() {
        if (parameters.length == 0) {
			return "";
		}
        final StringBuffer buff = new StringBuffer("(");
        for (int i = 0; i < parameters.length; i++) {
            buff.append(parameters[i]);
            if (i + 1 < parameters.length) {
                buff.append(", ");
            }
        }
        return buff.append(")").toString();
    }

    @Override
    public String toString() {
        return "EXPAND " + definition + getParamString()
                + (target != null ? (isForeach ? " FOREACH " : " FOR ") + target : "")
                + (separator != null ? " SEPARATOR " + separator : "");
    }
    
    ExpressionHelper getTarget() {
    	return target;
    }
    
    ExpressionHelper getSeparator() {
    	return separator;
    }
    
    ExpressionHelper[] getParameters() {
    	return parameters;
    }

}
