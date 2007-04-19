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

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Ship;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class ShipSmallCargoCanonicalEditPolicy extends CanonicalEditPolicy {

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
			switch (TaiPanVisualIDRegistry.getNodeVisualID(viewObject, nextValue)) {
			case SmallItemsEditPart.VISUAL_ID:
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
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

}
