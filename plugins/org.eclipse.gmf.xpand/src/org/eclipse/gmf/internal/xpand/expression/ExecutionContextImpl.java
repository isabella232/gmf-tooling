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
package org.eclipse.gmf.internal.xpand.expression;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.gmf.internal.xpand.util.ClassLoadContext;
import org.eclipse.gmf.internal.xpand.xtend.ast.GenericExtension;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ExecutionContextImpl implements ExecutionContext {

    private final Map<String, Variable> variables = new HashMap<String, Variable> ();

    private final Map<String, Variable> globalVars = new HashMap<String, Variable> ();

    private ClassLoadContext contextClassLoader;

    private EvaluationListener evaluationListener;

    /**
     * this field is conceptually final, i.e. it is set only at object construction time. To simplify implementation, it is however technically not
     *  final. This is done so that the cloneWith/WithoutResource methods can delegate to cloneContext and afterwards modify the instance. That 
     *  provides cloneContext as a single method for subclasses to override.
     */
    private ResourceMarker currentResource;

	private final ResourceManager resourceManager;

    public ExecutionContextImpl(ResourceManager resourceManager) {
        this (resourceManager, (Collection<Variable>) null);
    }
    
    public ExecutionContextImpl(ResourceManager resourceManager, Collection<Variable> globalVars) {
        this (resourceManager, null, null, globalVars);
    }

    public ExecutionContextImpl(ResourceManager resourceManager, ResourceMarker resource, Collection<Variable> variables, Collection<Variable> globalVars) {
        this.resourceManager = resourceManager;
		this.currentResource = resource;
		if (variables != null) {
			for (Variable v : variables) {
				this.variables.put(v.getName(), v);
			}
		}
        if (globalVars != null) {
        	for (Variable v : globalVars) {
        		this.globalVars.put(v.getName(), v);
        	}
		}
    }

    // copy constuctor
    protected ExecutionContextImpl(ExecutionContextImpl original) {
    	this.resourceManager = original.resourceManager;
    	this.currentResource = original.currentResource;
    	this.variables.putAll(original.variables);
    	this.globalVars.putAll(original.globalVars);
    	this.contextClassLoader = original.contextClassLoader;
    	this.evaluationListener = original.evaluationListener;
    	this.envFactory = original.envFactory;
    	this.environment = original.environment;
    }

    /**
     * {@link ClassLoadContext} to use in {@link #loadClass(String)}.
     * @param classLoader loader to use or null to use default system-wide
     */
    public void setContextClassLoader(ClassLoadContext classLoadContext) {
    	this.contextClassLoader = classLoadContext;
    }

    public Class<?> loadClass(String value) {
    	// FIXME delegate to resourcemanager or Environment
    	try {
    		if (contextClassLoader != null) {
    			Class<?> c = contextClassLoader.load(value);
    			if (c != null) {
    				return c;
    			}
    		}
    		return Class.forName(value);
    	} catch (ClassNotFoundException ex) {
    		ex.getMessage();
    		// IGNORE?
    	}
    	return null;
    }

    protected String[] getImportedNamespaces() {
    	return new String[0];
    }

    protected String[] getImportedExtensions() {
    	return new String[0];
    }

    public ExecutionContext cloneContext() {
        return new ExecutionContextImpl(this);
    }

    protected final ResourceManager getResourceManager() {
    	return resourceManager;
    }

    public Variable getVariable(final String name) {
        return variables.get(name);
    }

    public Variable getGlobalVariable(String name) {
    	return globalVars.get(name);
    }

	@SuppressWarnings("unchecked")
	public ExecutionContext cloneWithVariable(final Variable... vars) {
        final ExecutionContextImpl result = (ExecutionContextImpl) cloneContext();
    	result.environment = null; // XXX or create new, delegating?
        for (Variable v : vars) {
        	result.variables.put(v.getName(), v);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public ExecutionContext cloneWithoutVariables() {
        final ExecutionContextImpl result = (ExecutionContextImpl) cloneContext();
        result.variables.clear();
    	result.environment = null;
        return result;
    }

    @SuppressWarnings("unchecked")
    public ExecutionContext cloneWithResource(final ResourceMarker ns) {
        if (ns == currentResource) {
        	return this;
        }
        final ExecutionContextImpl ctx = (ExecutionContextImpl) cloneContext();
        ctx.currentResource = ns;
    	ctx.envFactory = null; // need to make sure resource's imports are read into registry.
    	ctx.environment = null;
        return ctx;
    }

    public ResourceMarker currentResource() {
        return currentResource;
    }

    private Set<GenericExtension> allExtensions = null;

	public Set<? extends GenericExtension> getAllExtensions() {
        if (allExtensions == null) {
            allExtensions = new HashSet<GenericExtension>();
            final String[] extensions = getImportedExtensions();
            for (String extension : extensions) {
            	final QvtResource qvtResource = resourceManager.loadQvtResource(extension);
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
        return PolymorphicResolver.getExtension(getAllExtensions(), functionName, Arrays.asList(parameterTypes), null/*FIXME*/);
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
    	return environment;
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

    public EvaluationListener getEvaluationListener() {
    	return evaluationListener;
    }

    public void setEvaluationListener(EvaluationListener listener) {
    	this.evaluationListener = listener;
    }
}
