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
import java.util.StringTokenizer;

/**
 * @author dstadnik
 */
public class DevUtils {

	private DevUtils() {
	}

	/**
	 * Replaces all fully qualified class names with simple names.
	 */
	public static String replaceWithSimpleNames(String s) {
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(s, " \t\n\r\f", true); //$NON-NLS-1$
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			int pos = token.lastIndexOf('.');
			if (pos > 0 && pos < token.length() - 1 && !Character.isDigit(token.charAt(pos + 1))) {
				sb.append(token.substring(pos + 1));
			} else {
				sb.append(token);
			}
		}
		return sb.toString();
	}

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
