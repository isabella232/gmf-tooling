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
	private final Map pathMap = new HashMap/*<Object, String>*/();
	private final Map classMap = new HashMap/*<Object,Class>*/();

	public void put(Object key, String templatePath, Class generatorClass) {
		assert key != null && templatePath != null;
		pathMap.put(key, templatePath);
		if (generatorClass != null) {
			classMap.put(key, generatorClass);
		}
	}

	public String getTemplatePath(Object key) {
		return (String) pathMap.get(key);
	}

	public boolean hasGeneratorClass(Object key) {
		return classMap.containsKey(key);
	}

	public Class getGeneratorClass(Object key) {
		return (Class) classMap.get(key);
	}

	public void clean() {
		pathMap.clear();
		classMap.clear();
	}
}
