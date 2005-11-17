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
package org.eclipse.gmf.dev.insider;

import java.lang.reflect.Field;

/**
 * @author dstadnik
 */
public class ReflectionUtil {

	private ReflectionUtil() {}

	public static Object getFieldValue(Object object, String name, Class clazz) {
		try {
			if (clazz == null) {
				clazz = object.getClass();
			}
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(object);
		} catch (Throwable t) {
			t.printStackTrace();
			// ignore
		}
		return null;
	}
}
