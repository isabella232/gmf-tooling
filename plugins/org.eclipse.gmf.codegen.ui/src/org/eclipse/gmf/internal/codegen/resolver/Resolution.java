/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.resolver;

/**
 * @author dstadnik
 */
public class Resolution {

	public static final Resolution NODE = new Resolution("Node");

	public static final Resolution LINK = new Resolution("Link");

	public static final Resolution LABEL = new Resolution("Label");

	private final String name;

	private Resolution(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Resolution getByName(String name) {
		if (NODE.name.equals(name)) {
			return NODE;
		} else if (LINK.name.equals(name)) {
			return LINK;
		} else if (LABEL.name.equals(name)) {
			return LABEL;
		}
		return null;
	}
}
