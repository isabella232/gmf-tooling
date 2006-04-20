/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    vano - initial API and implementation
 */
package org.eclipse.gmf.mappings.presentation;

import java.util.Comparator;

import org.eclipse.emf.ecore.ENamedElement;

public class ENamedElementsComparator implements Comparator {
	
	public int compare(Object o1, Object o2) {
		if (o1 instanceof ENamedElement && o2 instanceof ENamedElement) {
			ENamedElement firstNamedElement = (ENamedElement) o1;
			ENamedElement secondNamedElement = (ENamedElement) o2;
			return compareNames(firstNamedElement, secondNamedElement);
		}
		return compareObjects(o1, o2);
	}

	private int compareObjects(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null ? 0 : 1;
		} else {
			return o2 == null ? -1 : 0;
		}
	}

	private int compareNames(ENamedElement firstEClass, ENamedElement secondEClass) {
		String firstName = firstEClass.getName();
		String secondName = secondEClass.getName();
		return firstName == null ? (secondName == null ? 0 : 1) : (secondName == null ? -1 : firstName.compareTo(secondName));
	}

}
