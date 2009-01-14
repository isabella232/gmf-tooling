/*
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Artem Tikhomirov (Borland) - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.util;

/**
 * @deprecated Not used with QVT-based Xpand. There is no replacement, QVT internally handles class loading for native operations.
 */
@Deprecated
public abstract class ClassLoadContext {

	public abstract Class<?> load(String qualifiedName);

	public static class Naive extends ClassLoadContext {
		private final ClassLoader[] myClassLoaders;

		public Naive(ClassLoader... classLoaders) {
			this.myClassLoaders = classLoaders;
		}

		@Override
		public Class<?> load(String qualifiedName) {
			for (ClassLoader cl : myClassLoaders) {
				try {
					return cl.loadClass(qualifiedName);
				} catch (Exception ex) {
					// IGNORE
				}
			}
			return null;
		}
	}
}
