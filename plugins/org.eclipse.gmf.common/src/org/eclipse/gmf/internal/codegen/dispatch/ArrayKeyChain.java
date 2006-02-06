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

/**
 * Although it's more straightforward just to override hasNext/next then to perform checks in advance, 
 * did it that way for now to verify implementation in super. FIXME - refactor. 
 * @author artem
 */
public class ArrayKeyChain extends KeyChain {
	private final Object[] myKeys;
	private int myIndex = 0;

	public ArrayKeyChain(Object origin, Object singleKey) {
		this(origin, new Object[] {singleKey});
	}

	public ArrayKeyChain(Object origin, Object[] mappedKeys) {
		super(origin);
		myKeys = mappedKeys;
	}

	protected Object advance() {
		if (myIndex < myKeys.length) {
			return myKeys[myIndex++];
		}
		return null;
	}
}
