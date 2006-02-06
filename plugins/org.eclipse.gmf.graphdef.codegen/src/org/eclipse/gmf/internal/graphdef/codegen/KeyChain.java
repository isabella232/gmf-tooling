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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Key extraction and prioritization. <code>null</code> keys are not supported (useing null as eol indicator)
 * TODO add absract #reset()?
 * @author artem
 */
public abstract class KeyChain/*<T>*/ implements Iterator/*<E>*/ {
	private final Object/*<T>*/ myOrigin;
	private Object/*<E>*/ myNextValue;
	private boolean myIsInitialized = false;
	
	public KeyChain(Object origin) {
		myOrigin = origin;
	}

	public final Object getOrigin() {
		return myOrigin;
	}

	public boolean hasNext() {
		if (!myIsInitialized) {
			myNextValue = advance();
			myIsInitialized = true;
		}
		return myNextValue != null;
	}

	/**
	 * @return <code>null</code> to indicate EOL
	 */
	protected abstract Object/*<E>*/ advance();

	public Object next() {
		if (hasNext()) {
			myIsInitialized = false;
			return myNextValue;
		}
		throw new NoSuchElementException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
