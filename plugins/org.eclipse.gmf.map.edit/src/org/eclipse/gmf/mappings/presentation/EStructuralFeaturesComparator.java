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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeReference;
import org.eclipse.gmf.mappings.TopNodeReference;

public class EStructuralFeaturesComparator extends ENamedElementsComparator {

	private EClass myProposedContainerEClass = null;

	public static List getSortedList(Collection eStructuralFeatures, MappingEntry mappingEntry) {
		List validStructuralFeatures = getValidStructuralFeatures(eStructuralFeatures);
		Collections.sort(validStructuralFeatures, new EStructuralFeaturesComparator(mappingEntry.getDomainMetaElement()));
		return validStructuralFeatures;
	}

	public static List getSortedList(Collection eStructuralFeatures, LabelMapping labelMapping) {
		return getSortedList(eStructuralFeatures, labelMapping.getMapEntry());
	}

	public static List getSortedList(Collection eStructuralFeatures, NodeReference nodeReference) {
		if (nodeReference instanceof ChildReference) {
			return getSortedList(eStructuralFeatures, ((ChildReference) nodeReference).getParentNode());
		}
		List validStructuralFeatures = getValidStructuralFeatures(eStructuralFeatures);

		EClass domainMetaElement = null;
		if (nodeReference instanceof TopNodeReference) {
			CanvasMapping diagram = ((Mapping) nodeReference.eContainer()).getDiagram();
			if (diagram != null) {
				domainMetaElement = diagram.getDomainMetaElement();
			}
		}
		Collections.sort(validStructuralFeatures, new EStructuralFeaturesComparator(domainMetaElement));
		return validStructuralFeatures;
	}

	private static List getValidStructuralFeatures(Collection structuralFeatures) {
		List result = new ArrayList();
		for (Iterator it = structuralFeatures.iterator(); it.hasNext();) {
			EStructuralFeature nextChild = (EStructuralFeature) it.next();
			if (nextChild != null && nextChild.getEContainingClass() == null) {
				continue;
			}
			result.add(nextChild);
		}
		return result;
	}

	private EStructuralFeaturesComparator(EClass proposedContainerEClass) {
		myProposedContainerEClass = proposedContainerEClass;
	}

	public int compare(Object o1, Object o2) {
		EStructuralFeature eStructuralFeature1 = (EStructuralFeature) o1;
		EStructuralFeature eStructuralFeature2 = (EStructuralFeature) o2;
		int result = getValue(eStructuralFeature1) - getValue(eStructuralFeature2);
		if (result != 0) {
			return result;
		}
		return super.compare(o1, o2);
	}

	private int getValue(EStructuralFeature eStructuralFeature) {
		if (myProposedContainerEClass != null && eStructuralFeature != null) {
			if (eStructuralFeature.getEContainingClass().isSuperTypeOf(myProposedContainerEClass)) {
				return 0;
			} else {
				return 1;
			}
		}
		return -1;
	}

}
