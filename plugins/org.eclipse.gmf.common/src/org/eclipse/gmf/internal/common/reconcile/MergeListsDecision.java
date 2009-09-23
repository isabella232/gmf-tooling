/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.common.reconcile;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * Combines unique values from old and new attribute with multiplicity [*]
 * @author artem
 */
public class MergeListsDecision extends Decision {
	
	/**
	 * @param attr should be of multiplicity [*].
	 */
	public MergeListsDecision(EAttribute attr) {
		super(attr);
		assert attr.isMany();
	}

	@Override
	public void apply(EObject current, EObject old) {
		@SuppressWarnings("unchecked")
		List<Object> presentValues = (List<Object>) current.eGet(getFeature());
		List<?> oldValues = (List<?>) old.eGet(getFeature());
		LinkedList<Object> toAdd = new LinkedList<Object>();
		for (Object o : oldValues) {
			if (!presentValues.contains(o)) { // perhaps, just rely on EMF's isUnique check here
				toAdd.add(o); // intermediate list to keep values not to check twice.
			}
		}
		presentValues.addAll(toAdd); // do it as a single step
	}

}
