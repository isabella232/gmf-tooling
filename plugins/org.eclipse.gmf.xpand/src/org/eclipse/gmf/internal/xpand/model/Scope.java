/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ImportToNonTransformCtxHelper;

/**
 * @author artem
 */
public class Scope {

    private final Map<String, Variable> globalVars = new HashMap<String, Variable> ();

	private final ResourceManager resourceManager;

    private final Output output;

    private final List<XpandAdvice> registeredAdvices = new LinkedList<XpandAdvice>();

    private EvaluationListener evaluationListener;

    public Scope(ResourceManager resourceManager, Collection<Variable> globalVars, Output output) {
    	assert resourceManager != null;
    	// FIXME output != null is only important for evaluation cases, for analyze, null is perfectly ok
    	// assert output != null;
        this.resourceManager = resourceManager;
		this.output = output;
        if (globalVars != null) {
        	for (Variable v : globalVars) {
        		this.globalVars.put(v.getName(), v);
        	}
		}
    }

    // FIXME next two are for tests 
    protected Scope() {
    	resourceManager = null;
    	output = null;
    }

    protected Scope(Output out) {
    	resourceManager = null;
    	output = out;
    }

	// [artem] if not null, should be notified about entering/leaving xpand ast elements
    public EvaluationListener getEvaluationListener() {
    	return evaluationListener;
    }

    public void setEvaluationListener(EvaluationListener listener) {
    	this.evaluationListener = listener;
    }

    public Variable getGlobalVariable(String name) {
    	return globalVars.get(name);
    }
    
    public Collection<String> getGlobalVarNames() {
    	return globalVars.keySet();
    }

    // never null
    private ResourceManager getResourceManager() {
    	return resourceManager;
    }

    // never null
    public Output getOutput() {
        return output;
    }

	public List<XpandAdvice> getAdvices() {
		return registeredAdvices;
	}

	public void registerAdvices(final String fullyQualifiedName) {
        final XpandResource tpl = findTemplate(fullyQualifiedName);
        if (tpl == null) {
			throw new RuntimeException("Couldn't find template : " + fullyQualifiedName);
		}
        final XpandAdvice[] as = tpl.getAdvices();
        for (final XpandAdvice advice : as) {
            if (registeredAdvices.contains(advice)) {
                Activator.logWarn("advice " + advice.toString() + " allready registered!");
            } else {
                registeredAdvices.add(advice);
            }
        }
    }

    public XpandResource findTemplate(String templateName, String contextTemplate) {
    	assert templateName != null;
    	assert contextTemplate != null;
    	if (getResourceManager() == null) {
    		// HACK for tests
    		// FIXME once dealt with Scope with null rm, should remove this. (fix tests to use RM)
    		return null;
    	}
    	String[] possibleNames;
		if (!TypeNameUtil.isQualifiedName(contextTemplate)) {
			possibleNames = new String[] { templateName };
		} else {
			String contextNS = TypeNameUtil.withoutLastSegment(contextTemplate);
			possibleNames = new String[] { templateName, contextNS + TypeNameUtil.NS_DELIM + templateName };
		}
        for (String name : possibleNames) {
            final XpandResource tpl = findTemplate(name);
            if (tpl != null) {
				return tpl;
			}
        }
        return null;
    }

	public XpandResource findTemplate(String templateName) {
		XpandResource resource = getResourceManager().loadXpandResource(templateName);
		if (resource instanceof StatefulResource && !((StatefulResource) resource).isInitialized()) {
			((StatefulResource) resource).initialize(this);
		}
		return resource;
	}

	public QvtResource findExtension(String extensionName) {
		return getResourceManager().loadQvtResource(extensionName);
	}

    public EPackage.Registry createPackageRegistry(String[] metamodelURIs) {
		assert metamodelURIs != null;
		// TODO respect meta-models imported not only with nsURI
		EPackage.Registry result = new EPackageRegistryImpl();
		for (String namespace : metamodelURIs) {
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

	private ImportToNonTransformCtxHelper modulesImportHelper;
	/*package-local*/ ImportToNonTransformCtxHelper getImportsHelper() {
		if (modulesImportHelper == null) {
			modulesImportHelper = new ImportToNonTransformCtxHelper();
		}
		return modulesImportHelper;
	}

}
