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

import java.text.MessageFormat;

/**
 * Treat key as (part of) template path to allow <%=dispatcher.dispatch("../AnotherTemplate.javajet")%> use
 * Note, braces (<em>{</em> or <em>}</em>) within keys should be escaped, see {@link MessageFormat} class for details  
 * @author artem
 */
public class DynamicTemplateRegistry implements TemplateRegistry {
	private final String myPattern;
	private ClassLoader myClassLoader;

	/**
	 * Uses simple pattern <code>"{0}"</code> (i.e. leave key as is) to initialize instance. 
	 */
	public DynamicTemplateRegistry(ClassLoader classLoader) {
		this("{0}", classLoader);
	}

	/**
	 * Allows to add some prefix/suffix to the value of passed key. E.g. <code>"/templates-new/{0}.javajet"</code>
	 * @param pattern string to pass to {@link MessageFormat}
	 */
	public DynamicTemplateRegistry(String pattern, ClassLoader classLoader) {
		myPattern = pattern;
		myClassLoader = classLoader;
	}

	/**
	 * Treats key as (part of) template path
	 */
	public String getTemplatePath(Object key) {
		return MessageFormat.format(myPattern, new Object[] { key });
	}
	
	/**
	 * Return classloader of the key or own classloader if key is null
	 */
	public ClassLoader getTemplateClassLoader(Object key) {
		return myClassLoader;
	}

	/**
	 * @return always false
	 */
	public boolean hasGeneratorClass(Object key) {
		return false;
	}

	/**
	 * @return always <code>null</code>
	 */
	public Class getGeneratorClass(Object key) {
		return null;
	}

	/**
	 * NO-OP
	 */
	public void clean() {
	}
}
