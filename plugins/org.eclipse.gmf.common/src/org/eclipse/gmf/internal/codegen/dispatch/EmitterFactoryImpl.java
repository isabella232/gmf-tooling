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
import java.util.Arrays;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.gmf.common.UnexpectedBehaviourException;

/**
 * Yet Another Emitter Factory.
 * This factory is expected to slip away from JET templates to some abstract emitters so we could
 * substitute template engine.
 * 
 * @author artem
 */
public class EmitterFactoryImpl implements EmitterFactory {

	private final TemplateRegistry myTemplates;

	private final boolean myUsePrecompiled;

	private final String[] myVariables;

	private String[] myTemplatePath;

	public EmitterFactoryImpl(String[] templatePath, TemplateRegistry templates) {
		this(templatePath, templates, true, null);
	}

	/**
	 * @param templatePath paths to the templates - allows loading external templates
	 * @param templates registry with templates
	 * @param usePrecompiled whether or not respect class from TemplateRegistry (if there's one specified)
	 * @param variables dependencies (plugin identifiers) of code generators
	 */
	public EmitterFactoryImpl(String[] templatePath, TemplateRegistry templates, boolean usePrecompiled, String[] variables) {
		assert templatePath != null && templatePath.length > 0 && templates != null;
		assert variables == null || !Arrays.asList(variables).contains(null);
		myTemplatePath = templatePath;
		myTemplates = templates;
		myUsePrecompiled = usePrecompiled;
		myVariables = variables == null ? new String[0] : variables;
	}

	/**
	 * @param key
	 * @return <code>true</code> if template for the key passed is known to this factory
	 */
	public boolean checkEmitter(Object key) {
		return myTemplates.getTemplatePath(key) != null;
	}

	/**
	 * This is primary way to get emitters from this factory. 
	 * Checks cache (if there's one) first. Produces new emitter (with {@link #newEmitter(Object)}), caches and returns its outcome.
	 */
	public JETEmitter acquireEmitter(Object key) throws NoSuchTemplateException, UnexpectedBehaviourException {
		JETEmitter em;
		String relativePath = constructPath(key);
		ClassLoader cl;
		if (precompiledInUse(key)) {
			cl = myTemplates.getGeneratorClass(key).getClassLoader();
		} else {
			cl = myTemplates.getTemplateClassLoader(key);
		}

		em = new JETEmitter(myTemplatePath, relativePath, cl);
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
		String path = myTemplates.getTemplatePath(key);
		if (path == null) {
			throw new NoSuchTemplateException(String.valueOf(key));
		}
		return path;
	}

	private void feedVariables(JETEmitter em) throws UnexpectedBehaviourException {
		try {
			for (int i = 0; i < myVariables.length; i++) {
				em.addVariable(null, myVariables[i]);
			}
		} catch (JETException ex) {
			throw new UnexpectedBehaviourException(ex.getMessage(), ex);
		}
	}
}
