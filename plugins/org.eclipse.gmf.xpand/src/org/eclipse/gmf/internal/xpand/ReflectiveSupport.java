/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public abstract class ReflectiveSupport {
	protected static ReflectiveSupport anInstance;

	protected abstract Object doInvoke(Method m, Object instance, Object ... args) throws IllegalAccessException, InvocationTargetException;

	public static Object invoke(Object instance, String methodName, Collection<?> arguments) {
		return anInstance.internalInvoke(instance, methodName, arguments);
	}

	private Object internalInvoke(Object instance, String methodName, Collection<?> arguments) {
		Class[] paramTypes = new Class[arguments.size()];
		int i = 0;
		for (Object p : arguments) {
			paramTypes[i++] = extractType(p);
		}
		try {
			Method m = instance.getClass().getMethod(methodName, paramTypes);
			return doInvoke(m, instance, arguments.toArray());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Class<?> extractType(Object p) {
		// EObject - hack to make it work with FQNSwitch
		return p == null ? Object.class : p instanceof EObject ? EObject.class : p.getClass();
	}
}
