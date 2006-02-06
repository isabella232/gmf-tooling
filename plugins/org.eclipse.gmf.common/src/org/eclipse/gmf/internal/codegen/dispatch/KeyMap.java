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
 * Logic of key extraction and prioritization.
 * @author artem
 * @see KeyChain
 */
public class KeyMap/*<T,E>*/ {

	/**
	 * Default implementation just returns the key itself as sole item in the chain 
	 * @param key
	 * @return key chain with sole item that is key itself.
	 */
	public KeyChain/*<T,E>*/ map(Object/*<T>*/ key) {
		return new ArrayKeyChain(key, key);
	}
}
