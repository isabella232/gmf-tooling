/*
 * Copyright (c) 2005, 2010 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.util.PolymorphicResolver;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtExtension;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTParsingOptions;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ImportToNonTransformCtxHelper;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.OCLEnvironmentWithQVTAccessFactory;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.options.ParsingOptions;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
@SuppressWarnings("restriction")
public final class ExecutionContextImpl implements ExecutionContext {

    private final Map<String, Variable> variables = new HashMap<String, Variable> ();

    // never null
    private final Scope scope;

    private final ResourceMarker currentResource;

    private Set<QvtExtension> allExtensions;

//	private ImportToNonTransformCtxHelper modulesImportHelper;

    public ExecutionContextImpl(Scope rootScope) {
        this (rootScope, null, null);
    }

    public ExecutionContextImpl(Scope rootScope, ResourceMarker resource, Collection<Variable> variables) {
    	assert rootScope != null;
		this.scope = rootScope;
		this.currentResource = resource;
		if (variables != null) {
			for (Variable v : variables) {
				this.variables.put(v.getName(), v);
			}
		}
    }

    public Scope getScope() {
    	return scope;
    }

    public Variable getImplicitVariable() {
        return variables.get(IMPLICIT_VARIABLE);
    }


	public ExecutionContext cloneWithVariable(final Variable... vars) {
        final ExecutionContextImpl result = new ExecutionContextImpl(scope, currentResource, variables.values());
        // cached values that depend on resource only may be kept
        result.envFactory = envFactory;
        result.allExtensions = allExtensions;
//        result.modulesImportHelper = modulesImportHelper;
    	result.environment = null; // XXX or create new, delegating?
        for (Variable v : vars) {
        	// adding to the set of original variables because of e.g. nested let statements
        	result.variables.put(v.getName(), v);
        }
        return result;
    }

    public ExecutionContext cloneWithResource(final ResourceMarker ns) {
        if (ns == currentResource) {
        	return this;
        }
        // XXX is it reasonable to pass variables if it's another resource?
        final ExecutionContextImpl result = new ExecutionContextImpl(scope, ns, variables.values());
    	result.envFactory = null; // need to make sure resource's imports are read into registry.
    	result.environment = null;
    	result.allExtensions = null;
//    	result.modulesImportHelper = null;
        return result;
    }

    public ResourceMarker currentResource() {
        return currentResource;
    }

    private String[] getImportedExtensions() {
    	return currentResource == null ? new String[0] : currentResource.getImportedExtensions();
    }

	public Set<QvtExtension> getAllExtensions() {
        if (allExtensions == null) {
            allExtensions = new HashSet<QvtExtension>();
            final String[] extensions = getImportedExtensions();
            for (String extension : extensions) {
            	final QvtResource qvtResource = getScope().findExtension(extension);
            	if (qvtResource == null) {
   					continue;
            	}
        		final ExecutionContext ctx = cloneWithResource(qvtResource);
                final List<QvtExtension> extensionList = qvtResource.getExtensions();
                if (extensionList == null) {
                	continue;
                }
                for (QvtExtension element : extensionList) {
                    element.init(ctx);
                    allExtensions.add(element);
                }
            }
        }
        return allExtensions;
    }

    public XpandDefinition findDefinition(String name, EClassifier target, EClassifier[] paramTypes) throws AmbiguousDefinitionException {
        String templateName;
        boolean localCall = !TypeNameUtil.isQualifiedName(name);
        if (localCall) {
        	// [artem] the reason can't just use currentResource() as it might be part of composite?
        	// otherwise, see no reason to load it once again in findTemplate()
        	templateName = ((XpandResource) currentResource()).getFullyQualifiedName(); // need an enclosing resource in case of composite	
        } else {
        	templateName = TypeNameUtil.withoutLastSegment(name);
        }
        XpandResource tpl = findTemplate(templateName);
        if (tpl == null) {
        	if (localCall) {
        		tpl = (XpandResource) currentResource();
        	} else {
        		return null;
        	}
		}
        final ExecutionContext ctx = cloneWithResource(tpl);
        XpandDefinition def = findDefinition(tpl.getDefinitions(), name, target, paramTypes, ctx);
        if (def == null) {
        	return null;
        }
        XpandAdvice[] advicesInResource = tpl.getAdvices();
        for (int x = advicesInResource.length - 1; x >= 0; x--) {
            final XpandAdvice adv = advicesInResource[x];
            if (adv.matches(def, this)) {
                def = new AdvicedDefinition(adv, def);
            }
        }
        for (int x = scope.getAdvices().size() - 1; x >= 0; x--) {
            final XpandAdvice adv = scope.getAdvices().get(x);
            if (adv.matches(def, this)) {
                def = new AdvicedDefinition(adv, def);
            }
        }
        return def;
    }

    // XXX completely rewritten, NEEDS TESTS!
    // getPossibleNames(getImportedNamespaces()), along with FQN added in #getImportedNamespaces(), was stupid hack anyway.
    private XpandResource findTemplate(final String templateName) {
    	if (currentResource() instanceof XpandResource) {
    		String contextTemplate = ((XpandResource) currentResource()).getFullyQualifiedName();
    		return scope.findTemplate(templateName, contextTemplate);
    	} else {
    		return scope.findTemplate(templateName);
    	}
    }

    /**
     * resolves the correct definition (using parametric polymorphism)
	 * XXX: get rid of the ctx argument and redeclare as non-static?
     * @param definitions
     * @param target
     * @param paramTypes
     * @return
     * @throws AmbiguousDefinitionException 
     */
    private static XpandDefinition findDefinition(final XpandDefinition[] definitions, final String name, final EClassifier target,
            EClassifier[] paramTypes, final ExecutionContext ctx) throws AmbiguousDefinitionException {
        if (paramTypes == null) {
            paramTypes = new EClassifier[0];
        }
        final String unqualifiedName = TypeNameUtil.getLastSegment(name);
        // XXX Instead of using map as a mere pair storage, do it like Extension does with init(ctx)
        // to resolve and keep typed arguments
        HashMap<XpandDefinition, List<EClassifier>> resolvedDefs = new HashMap<XpandDefinition, List<EClassifier>>();
        for (final XpandDefinition def : definitions) {
        	if (!def.getName().equals(unqualifiedName)) {
        		continue;
        	}
            if (def.getParams().length == paramTypes.length) {
                final LinkedList<EClassifier> defsParamTypes = new LinkedList<EClassifier>();
                EClassifier t = null;
                boolean complete = true;
                for (int j = 0; (j < paramTypes.length) && complete; j++) {
                    t = def.getParams()[j].getTypeForName(ctx);
                    if (t == null) {
                        complete = false;
                    }
                    defsParamTypes.add(t);
                }
                t = def.getTargetType().getTypeForName(ctx);
                if (t == null) {
                    complete = false;
                } else {
                	defsParamTypes.addFirst(t);
                }
                if (complete) {
                	resolvedDefs.put(def, defsParamTypes);
                }
            }
        }
		return PolymorphicResolver.filterDefinition(resolvedDefs, target, Arrays.asList(paramTypes), ctx.getOCLEnvironment());
    }

    private OCLEnvironmentWithQVTAccessFactory envFactory; // null-ified when context's resource is changed

    private EcoreEnvironment environment;

    public EcoreEnvironment getOCLEnvironment() {
    	if (environment != null) {
    		return environment;
    	}
    	if (envFactory == null) {
    		envFactory = new OCLEnvironmentWithQVTAccessFactory(getImportedModules(), getAllVisibleModels());
    	}
		environment = (EcoreEnvironment) envFactory.createEnvironment();
		ParsingOptions.setOption(environment, QVTParsingOptions.ENFORCE_EXPLICIT_SELF_VARIABLE, Boolean.FALSE);
		ParsingOptions.setOption(environment, ParsingOptions.implicitRootClass(environment), EcorePackage.Literals.EOBJECT);
		Variable that = getImplicitVariable();
    	for (Variable v : variables.values()) {
    		if (that != v) {
    			// XXX alternative: environment.getOCLFactory().createVariable()
    			org.eclipse.ocl.ecore.Variable oclVar = EcoreFactory.eINSTANCE.createVariable();
    			oclVar.setName(v.getName());
    			if (v.getType() == null) {
					oclVar.setType(BuiltinMetaModel.getType(this, v.getValue()));
    			} else {
    				oclVar.setType(v.getType());
    			}
    			environment.addElement(oclVar.getName(), oclVar, true);
    		}
    	}
		if (that != null) {
			EClassifier type = that.getType() == null ? BuiltinMetaModel.getType(this, that.getValue()) : that.getType();
			environment = (EcoreEnvironment) envFactory.createClassifierContext(environment, type);
		}
    	return environment;
    }

	public QvtOperationalEvaluationVisitor createEvaluationVisitor() {
		QvtOperationalEvaluationEnv evaluationEnv = (QvtOperationalEvaluationEnv) createEvaluationEnvironment();
		ImportToNonTransformCtxHelper importsHelper = scope.getImportsHelper();
		for (Module module : getImportedModules()) {
			importsHelper.addImportedModule(module);
		}
		return QvtOperationalEvaluationVisitorImpl.createNonTransformationExecutionContextVisitor(QvtOperationalEnvFactory.INSTANCE.createEnvironment(), evaluationEnv, importsHelper);
	}

	private Set<Module> getImportedModules() {
		LinkedHashSet<Module> importedModules = new LinkedHashSet<Module>();
		final String[] extensions = getImportedExtensions();
		for (String extension : extensions) {
			final QvtResource qvtResource = getScope().findExtension(extension);
			if (qvtResource != null) {
				importedModules.addAll(qvtResource.getModules());
			}
		}
		return importedModules;
	}

	private EcoreEvaluationEnvironment createEvaluationEnvironment() {
    	if (envFactory == null) {
    		getOCLEnvironment();
    	}
    	EcoreEvaluationEnvironment ee = QvtOperationalEnvFactory.INSTANCE.createEvaluationEnvironment(new Context(), null);
    	Variable that = getImplicitVariable();
    	for (Variable v : variables.values()) {
    		if (that != v) {
    			ee.add(v.getName(), v.getValue());
    		}
    	}
    	if (that != null) {
    		ee.add(Environment.SELF_VARIABLE_NAME, that.getValue());
    	}
    	return ee;
	}
	
	private String[] getImportedNamespaces() {
		return currentResource == null ? new String[0] : currentResource.getImportedNamespaces();
	}

	public EPackage.Registry getAllVisibleModels() {
		return getScope().createPackageRegistry(getImportedNamespaces());
	}
}
