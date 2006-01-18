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
package org.eclipse.gmf.internal.bridge.naming;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author artem
 */
public class CollectingDispenser implements UniqueValueDispenser {

	private final Collection myHistory;

	public CollectingDispenser() {
		this(new HashSet());
	}

	public CollectingDispenser(Collection collection) {
		assert collection != null;
		myHistory = collection;
	}

	public boolean isUnique(Object obj) {
		return !myHistory.contains(obj);
	}

	public void remember(Object obj) {
		myHistory.add(obj);
	}

	public void forget() {
		myHistory.clear();
	}
}
