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
package org.eclipse.gmf.internal.graphdef.codegen;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * XXX cache hierarchies?
 * @author artem
 */
public class HierarchyKeyMap extends KeyMap {

	public HierarchyKeyMap() {
	}

	/**
	 * Processes instances of {@link java.lang.Class} only, delegates to superclass otherwise
	 */
	public KeyChain map(Object key) {
		if (false == key instanceof Class) {
			return super.map(key);
		}
		Class keyClass = (Class) key;
		Class[] immediateInterfaces = keyClass.getInterfaces();
		// make sure immediate interfaces are considered first in the key chain
		LinkedHashSet result = new LinkedHashSet(Arrays.asList(immediateInterfaces));
		LinkedList l = new LinkedList(result);
		while (!l.isEmpty()) {
			Class iface = (Class) l.removeFirst();
			result.add(iface);
			l.addAll(0, Arrays.asList(iface.getInterfaces()));
		}
		return new ArrayKeyChain(keyClass, result.toArray());
	}
}
