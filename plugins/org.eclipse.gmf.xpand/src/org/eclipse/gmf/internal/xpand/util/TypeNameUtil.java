/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.util;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class TypeNameUtil {

	public final static String NS_DELIM = "::";

	public static String withoutLastSegment(final String fqn) {
		if (fqn.lastIndexOf(TypeNameUtil.NS_DELIM) == -1) {
			return null;
		}
		return fqn.substring(0, fqn.lastIndexOf(TypeNameUtil.NS_DELIM));
	}

	public static boolean isQualifiedName(String name) {
		assert name != null;
		return name.indexOf(TypeNameUtil.NS_DELIM) != -1;
	}

	public static String getLastSegment(final String fqn) {
		if (fqn.lastIndexOf(TypeNameUtil.NS_DELIM) == -1) {
			return fqn;
		}
		return fqn.substring(fqn.lastIndexOf(TypeNameUtil.NS_DELIM) + TypeNameUtil.NS_DELIM.length());
	}
}
