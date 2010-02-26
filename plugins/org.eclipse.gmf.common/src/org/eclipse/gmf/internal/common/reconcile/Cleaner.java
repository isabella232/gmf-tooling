/*
 * Copyright (c) 2010 Artem Tikhomirov and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (independent) - initial API and implementation
 */
package org.eclipse.gmf.internal.common.reconcile;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Handler for {@link Reconciler#handleNotMatchedCurrent(EObject)} case, when there's an object in the new tree that didn't match
 * any object in old tree. For example, clients may want to remove objects that are always created by map-to-gen transformation when
 * their modified (a.k.a. old) model has these objects removed by user. 
 *  
 * @author artem
 */
public class Cleaner {
	/**
	 * Gets a chance to react to an element of a new tree that didn't match any element in the old tree.
	 * This method intentionally does nothing by default. 
	 * @param notMatchedCurrent element of the new tree.
	 */
	public void clear(EObject notMatchedCurrent) {
		// no-op
	}

	/**
	 * Straightforward object removal implementation.
	 */
	public static class Remove extends Cleaner {
		@Override
		public void clear(EObject notMatchedCurrent) {
			EcoreUtil.remove(notMatchedCurrent);
		}
	}
}
