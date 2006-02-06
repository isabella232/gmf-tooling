/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.dispatch;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.common.UnexpectedBehaviourException;

/**
 * Yet Another Emitter Factory
 * 
 * @author artem
 */
public class EmitterFactory {

	private final URL myBaseURL;

	private final TemplateRegistry myTemplates;

	private final boolean myUsePrecompiled;

	private final String[] myVariables;

	private final Map myCache;

	public EmitterFactory(URL baseURL, TemplateRegistry templates) {
		this(baseURL, templates, true, null, true);
	}

	/**
	 * XXX perhaps, baseURL should be URL[] to handle external/dynamic templates?
	 * @param baseURL base location to resolve template path taken from TemplateRegistry
	 * @param templates registry with templates
	 * @param usePrecompiled whether or not respect class from TemplateRegistry (if there's one specified)
	 * @param variables dependencies (plugin identifiers) of code generators
	 * @param cache when <code>true</code>, remembers JETEmitter for key
	 */
	public EmitterFactory(URL baseURL, TemplateRegistry templates, boolean usePrecompiled, String[] variables, boolean cache) {
		assert baseURL != null && templates != null;
		assert variables == null || !Arrays.asList(variables).contains(null);
		myBaseURL = baseURL;
		myTemplates = templates;
		myUsePrecompiled = usePrecompiled;
		myVariables = variables == null ? new String[0] : variables;
		if (cache) {
			myCache = createCache();
		} else {
			myCache = null;
		}
	}

	/**
	 * Instantiates {@link HashMap} by default. NOTE, this method is invoked
	 * from constructor, object may not be fully initialized, don't use this
	 * method for anything but cache instantiation.
	 */
	protected Map/*<Object, JETEmitter>*/ createCache() {
		return new HashMap();
	}

	/**
	 * @param key
	 * @return <code>true</code> if template for the key passes is known to this factory
	 */
	public boolean checkEmitter(Object key) {
		return checkCache(key) != null || myTemplates.getTemplatePath(key) != null;
	}

	/**
	 * This is primary way to get emitters from this factory. 
	 * Checks cache (if there's one) first. Produces new emitter (with {@link #newEmitter(Object)}), caches and returns its outcome.
	 */
	public JETEmitter acquireEmitter(Object key) throws JETException, NoSuchTemplateException, UnexpectedBehaviourException {
		JETEmitter em = checkCache(key);
		if (em != null) {
			return em;
		}
		em = newEmitter(key);
		cache(key, em);
		return em;
	}

	/**
	 * Explicit way to produce new instance of emitter, passing over cache (if any).
	 */
	public JETEmitter newEmitter(Object key) throws UnexpectedBehaviourException, NoSuchTemplateException, JETException {
		JETEmitter em;
		String fullPath = constructPath(key);
		ClassLoader cl;
		if (precompiledInUse(key)) {
			cl = myTemplates.getGeneratorClass(key).getClassLoader();
		} else {
			cl = getClass().getClassLoader();
		}
		em = new JETEmitter(fullPath, cl);
		feedVariables(em);
		initPrecompiled(key, em);
		return em;
	}

	private boolean precompiledInUse(Object key) {
		return myUsePrecompiled && myTemplates.hasGeneratorClass(key);
	}

	private void initPrecompiled(Object key, JETEmitter em) throws UnexpectedBehaviourException {
		try {
			if (precompiledInUse(key)) {
				Method m = myTemplates.getGeneratorClass(key).getMethod("generate", new Class[] { Object.class });
				em.setMethod(m);
			}
		} catch (NoSuchMethodException ex) {
			throw new UnexpectedBehaviourException("Bad template class", ex);
		}
	}

	private String constructPath(Object key) throws UnexpectedBehaviourException, NoSuchTemplateException {
		try {
			String path = myTemplates.getTemplatePath(key);
			if (path == null) {
				throw new NoSuchTemplateException(String.valueOf(key));
			}
			return new URL(myBaseURL, path).toString();
		} catch (MalformedURLException ex) {
			throw new UnexpectedBehaviourException(ex);
		}
	}

	private void feedVariables(JETEmitter em) throws JETException {
		for (int i = 0; i < myVariables.length; i++) {
			em.addVariable(null, myVariables[i]);
		}
	}

	private JETEmitter checkCache(Object key) {
		if (myCache != null) {
			return (JETEmitter) myCache.get(key);
		}
		return null;
	}

	private void cache(Object key, JETEmitter emitter) {
		if (myCache != null) {
			myCache.put(key, emitter);
		}
	}
}
