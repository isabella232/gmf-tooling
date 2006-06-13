/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.internal.common.reconcile;

public abstract class AbstractPool {
	private final Object[] myPairs;
	private int myNextIndex;
	
	protected abstract Object createNew();
	
	public AbstractPool(int capacity){
		myPairs = new Object[capacity];
	}
	
	public final int capacity(){
		return myPairs.length;
	}
	
	protected final Object internalAcquire(){
		Object result = null;
		if (myNextIndex < myPairs.length){
			result = myPairs[myNextIndex];
			myPairs[myNextIndex] = null;
			myNextIndex++;
		}
		if (result == null){
			result = createNew();
		}
		return result;
	}
	
	protected final void internalRelease(Object pair){
		if (myNextIndex > 0){
			myNextIndex--;
			if (myPairs[myNextIndex] != null){
				throw new IllegalStateException("FIXME: should be assert here");
			}
			myPairs[myNextIndex] = pair;
		}
	}
	
	/**
	 * For testing purposes only
	 */
	protected final int internalCountNulls(){
		int result = 0;
		for (int i = 0; i < myPairs.length; i++){
			if (myPairs[i] == null){
				result++;
			}
		}
		return result;
	}
}
