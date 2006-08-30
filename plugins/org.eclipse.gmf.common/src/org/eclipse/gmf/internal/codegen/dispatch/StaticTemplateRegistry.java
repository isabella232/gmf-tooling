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

import java.util.HashMap;
import java.util.Map;

/**
 * @author artem
 */
public class StaticTemplateRegistry implements TemplateRegistry {
	private final Map<Object,String> pathMap = new HashMap<Object, String>();
	private final Map<Object,Class> classMap = new HashMap<Object,Class>();
	private final Map<Object, ClassLoader> classLoaderMap = new HashMap<Object, ClassLoader>();
	private final ClassLoader myDefaultClassLoader;
	
	public StaticTemplateRegistry(ClassLoader defaultClassLoader) {
		assert defaultClassLoader != null;
		myDefaultClassLoader = defaultClassLoader;
	}

	public void put(Object key, String templatePath, Class generatorClass) {
		put(key, templatePath, generatorClass, null);
	}
	
	public void put(Object key, String templatePath, Class generatorClass, ClassLoader templateClassLoader) {
		assert key != null && templatePath != null;
		pathMap.put(key, templatePath);
		if (generatorClass != null) {
			classMap.put(key, generatorClass);
		}
		if (templateClassLoader != null) {
			classLoaderMap.put(key, templateClassLoader);
		}
	}

	public String getTemplatePath(Object key) {
		return pathMap.get(key);
	}
	
	public ClassLoader getTemplateClassLoader(Object key) {
		if (classLoaderMap.containsKey(key)) {
			return classLoaderMap.get(key);
		}
		return myDefaultClassLoader;
	}

	public boolean hasGeneratorClass(Object key) {
		return classMap.containsKey(key);
	}

	public Class getGeneratorClass(Object key) {
		return classMap.get(key);
	}

	public void clean() {
		pathMap.clear();
		classMap.clear();
		classLoaderMap.clear();
	}
}
