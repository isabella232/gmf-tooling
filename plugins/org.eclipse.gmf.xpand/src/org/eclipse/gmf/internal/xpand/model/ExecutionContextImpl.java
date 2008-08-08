/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.util.PolymorphicResolver;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.gmf.internal.xpand.xtend.ast.GenericExtension;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreFactory;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public final class ExecutionContextImpl implements ExecutionContext {

    private final Map<String, Variable> variables = new HashMap<String, Variable> ();

    // never null
    private final Scope scope;

    private final ResourceMarker currentResource;

    public ExecutionContextImpl(Scope rootScope) {
        this (rootScope, null, (Collection<Variable>) null);
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

    public Variable getVariable(final String name) {
        return variables.get(name);
    }


	public ExecutionContext cloneWithVariable(final Variable... vars) {
        final ExecutionContextImpl result = new ExecutionContextImpl(scope, currentResource, variables.values());
        result.envFactory = envFactory;
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
        final ExecutionContextImpl result = new ExecutionContextImpl(scope, ns, variables.values());
    	result.envFactory = null; // need to make sure resource's imports are read into registry.
    	result.environment = null;
        return result;
    }

    public ResourceMarker currentResource() {
        return currentResource;
    }

    private Set<GenericExtension> allExtensions = null;

    private String[] getImportedExtensions() {
    	return currentResource == null ? new String[0] : currentResource.getImportedExtensions();
    }

	public Set<? extends GenericExtension> getAllExtensions() {
        if (allExtensions == null) {
            allExtensions = new HashSet<GenericExtension>();
            final String[] extensions = getImportedExtensions();
            for (String extension : extensions) {
            	final QvtResource qvtResource = getScope().findExtension(extension);
            	if (qvtResource != null) {
            		final ExecutionContext ctx = cloneWithResource(qvtResource);
                    final List<? extends GenericExtension> extensionList = qvtResource.getExtensions();
                    for (GenericExtension element : extensionList) {
                        element.init(ctx);
                        allExtensions.add(element);
                    }
            	} else {
            		// XXX ask Vano - used to be exception
            		//throw new RuntimeException("Unable to load extension file : " + extension);
            	}
            }
        }
        return allExtensions;
    }

    public GenericExtension getExtension(final String functionName, final EClassifier[] parameterTypes) {
        return PolymorphicResolver.getExtension(getAllExtensions(), functionName, Arrays.asList(parameterTypes), getOCLEnvironment());
    }

    public XpandDefinition findDefinition(String name, EClassifier target, EClassifier[] paramTypes) {
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
     */
    private static XpandDefinition findDefinition(final XpandDefinition[] definitions, final String name, final EClassifier target,
            EClassifier[] paramTypes, final ExecutionContext ctx) {
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

    private EcoreEnvironmentFactory envFactory; // null-ified when context's resource is changed
    private EcoreEnvironment environment;

    public EcoreEnvironment getOCLEnvironment() {
    	if (environment != null) {
    		return environment;
    	}
    	if (envFactory == null) {
    		envFactory = new EcoreEnvironmentFactory(getAllVisibleModels());
    	}
    	environment = (EcoreEnvironment) envFactory.createEnvironment();
    	for (Variable v : variables.values()) {
    		if (!IMPLICIT_VARIABLE.equals(v.getName())) {
    			// XXX alternative: environment.getOCLFactory().createVariable()
    			org.eclipse.ocl.ecore.Variable oclVar = EcoreFactory.eINSTANCE.createVariable();
    			oclVar.setName(v.getName());
    			if (v.getType() == null) {
    				oclVar.setType(BuiltinMetaModel.getType(v.getValue()));
    			} else {
    				oclVar.setType(v.getType());
    			}
    			environment.addElement(oclVar.getName(), oclVar, true);
    		}
    	}
		Variable v = variables.get(ExecutionContext.IMPLICIT_VARIABLE);
		if (v != null) {
			EClassifier type = v.getType() == null ? BuiltinMetaModel.getType(v.getValue()) : v.getType();
			environment = (EcoreEnvironment) envFactory.createClassifierContext(environment, type);
		}
    	return environment;
    }
    
    public void populate(EcoreEvaluationEnvironment ee) {
    	for (Variable v : variables.values()) {
    		if (!IMPLICIT_VARIABLE.equals(v.getName())) {
    			ee.add(v.getName(), v.getValue());
    		}
    	}
	}

    private String[] getImportedNamespaces() {
    	return currentResource == null ? new String[0] : currentResource.getImportedNamespaces();
    }

    private EPackage.Registry getAllVisibleModels() {
		String[] importedNamespaces = getImportedNamespaces();
		assert importedNamespaces != null;
		// TODO respect meta-models imported not only with nsURI
		EPackage.Registry result = new EPackageRegistryImpl();
		for (String namespace : importedNamespaces) {
			EPackage pkg = Activator.findMetaModel(namespace);
			if (pkg != null) {
				result.put(namespace, pkg);
			}
		}
		if (result.isEmpty()) {
			// hack for tests
			result.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		return result;
	}

}
