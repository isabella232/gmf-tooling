/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Ship;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class ShipSmallCargoCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		View viewObject = (View) getHost().getModel();
		Ship modelObject = (Ship) viewObject.getElement();
		List allValues = new LinkedList();
		allValues.addAll(modelObject.getCargo());
		for (Iterator valuesIterator = allValues.iterator(); valuesIterator.hasNext();) {
			EObject nextValue = (EObject) valuesIterator.next();
			if (isDomainMetaChild(TaiPanVisualIDRegistry.getNodeVisualID(viewObject, nextValue))) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = TaiPanVisualIDRegistry.getVisualID(view);
		return isDomainMetaChild(visualID) && (!semanticChildren.contains(view.getElement()) || visualID != TaiPanVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement()));
	}

	/**
	 * @generated
	 */
	private boolean isDomainMetaChild(int visualID) {
		switch (visualID) {
		case SmallItemsEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(TaiPanPackage.eINSTANCE.getShip_Cargo());
		}
		return myFeaturesToSynchronize;
	}

}
