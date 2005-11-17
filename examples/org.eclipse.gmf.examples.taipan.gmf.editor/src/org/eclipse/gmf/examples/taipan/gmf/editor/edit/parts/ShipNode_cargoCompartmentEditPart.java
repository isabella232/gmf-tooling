/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.Compartment_cargoContainerItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ShipNode_cargoCompartmentEditPart extends ListCompartmentEditPart {

	/**
	 * @generated
	 */
	public ShipNode_cargoCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return "cargo";
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Compartment_cargoContainerItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ShipNode_cargoCompartmentEditPartCanonicalEditPolicy());
		//installEditPolicy(EditPolicy.NODE_ROLE, null);
	}

	/**
	 * @generated
	 */
	private class ShipNode_cargoCompartmentEditPartCanonicalEditPolicy extends CanonicalEditPolicy {

		/**
		 * @generated
		 */
		protected List getSemanticChildrenList() {
			Ship modelElement = (Ship) ((View) getHost().getModel()).getElement();
			List result = new LinkedList();

			Collection featureValues = modelElement.getCargo();
			for (Iterator it = featureValues.iterator(); it.hasNext();) {
				EObject nextValue = (EObject) it.next();
				if (nextValue != null) {
					EClass nextEClass = nextValue.eClass();
					if (TaiPanPackage.eINSTANCE.getItem().equals(nextEClass)) {
						result.add(nextValue);
					}
				}
			}
			return result;
		}
	}
}
