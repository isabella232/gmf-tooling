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
		LinkedHashSet<Class> result = new LinkedHashSet<Class>(Arrays.asList(immediateInterfaces));
		LinkedList<Class> l = new LinkedList<Class>(result);
		while (!l.isEmpty()) {
			Class iface = l.removeFirst();
			result.add(iface);
			l.addAll(0, Arrays.asList(iface.getInterfaces()));
		}
		return new ArrayKeyChain(keyClass, result.toArray());
	}
}
