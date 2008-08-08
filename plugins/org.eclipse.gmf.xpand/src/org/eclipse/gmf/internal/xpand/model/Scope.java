/*
 * Copyright (c) 2008 Borland Software Corporation
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

import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.eval.EvaluationListener;
import org.eclipse.gmf.internal.xpand.util.ClassLoadContext;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;

/**
 * @author artem
 */
public class Scope {

    private final Map<String, Variable> globalVars = new HashMap<String, Variable> ();

	private final ResourceManager resourceManager;

    private final Output output;

    private final List<XpandAdvice> registeredAdvices = new LinkedList<XpandAdvice>();

    private ClassLoadContext contextClassLoader;

    private EvaluationListener evaluationListener;
    
    public Scope(ResourceManager resourceManager, Collection<Variable> globalVars, Output output) {
    	assert resourceManager != null;
    	assert output != null;
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

    // never null
    private ResourceManager getResourceManager() {
    	return resourceManager;
    }

    // never null
    public Output getOutput() {
        return output;
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
			if (!TypeNameUtil.isQualifiedName(templateName)) {
				// unqualified name, try relative to current template first
				possibleNames[0] = possibleNames[1];
				possibleNames[1] = templateName;
			}
		}
        for (String name : possibleNames) {
            final XpandResource tpl = getResourceManager().loadXpandResource(name);
            if (tpl != null) {
				return tpl;
			}
        }
        return null;
    }

	public XpandResource findTemplate(String templateName) {
		return getResourceManager().loadXpandResource(templateName);
	}

	public QvtResource findExtension(String extensionName) {
		return getResourceManager().loadQvtResource(extensionName);
	}
}
