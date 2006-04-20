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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeReference;

public class EClassComparator extends ENamedElementsComparator {

	private EClass myProposedSuperType;

	public static List getSortedList(Collection eStructuralFeatures, MappingEntry mappingEntry) {
		EClass proposedSuperType = null;
		if (mappingEntry.eContainer() instanceof NodeReference) {
			NodeReference nodeReference = (NodeReference) mappingEntry.eContainer();
			EReference modelReference = nodeReference.getChildrenFeature() != null ? nodeReference.getChildrenFeature() : nodeReference.getContainmentFeature();
			if (modelReference != null) {
				proposedSuperType = modelReference.getEReferenceType();
			}
		}
		List validStructuralFeatures = new ArrayList(eStructuralFeatures);
		Collections.sort(validStructuralFeatures, new EClassComparator(proposedSuperType));
		return validStructuralFeatures;
	}

	private EClassComparator(EClass proposedSuperType) {
		myProposedSuperType = proposedSuperType;
	}

	public int compare(Object o1, Object o2) {
		EClass firstEClass = (EClass) o1;
		EClass secondEClass = (EClass) o2;
		int result = getValue(firstEClass) - getValue(secondEClass);
		if (result != 0) {
			return result;
		}
		return super.compare(o1, o2);
	}

	private int getValue(EClass eClass) {
		if (eClass == null || myProposedSuperType == null) {
			return -1;
		}
		return myProposedSuperType.isSuperTypeOf(eClass) ? 0 : 1;
	}

}
