/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev;

import java.lang.reflect.Field;

/**
 * @author dstadnik
 */
public class DevUtils {

	private DevUtils() {}

	public static String getFullClassName(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.getClass().getName();
	}

	public static String getSimpleClassName(Object obj) {
		if (obj == null) {
			return null;
		}
		return getSimpleName(obj.getClass().getName());
	}

	public static String getSimpleName(String fqn) {
		return fqn.substring(fqn.lastIndexOf('.') + 1);
	}

	/**
	 * Returns <code>null</code> if field does not exist.
	 */
	public static Object getFieldValue(Object obj, String name) {
		try {
			Field f = obj.getClass().getDeclaredField(name);
			f.setAccessible(true);
			return f.get(obj);
		} catch (Throwable t) {
			DevPlugin.logError("Unable to retrieve field value : " + name, t);
		}
		return null;
	}

	/**
	 * Returns <code>null</code> if field does not exist.
	 */
	public static Object getStaticFieldValue(Class clazz, String name) {
		try {
			Field f = clazz.getDeclaredField(name);
			f.setAccessible(true);
			return f.get(null);
		} catch (Throwable t) {
			DevPlugin.logError("Unable to retrieve static field value : " + name, t);
		}
		return null;
	}
}
