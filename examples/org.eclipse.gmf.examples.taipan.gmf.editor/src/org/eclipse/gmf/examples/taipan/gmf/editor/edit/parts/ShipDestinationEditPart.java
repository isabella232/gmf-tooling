/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.Connection;

import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipDestinationItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanReferenceConnectionEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.figures.ArrowConnection;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

/**
 * @generated
 */
public class ShipDestinationEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public ShipDestinationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new TaiPanReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ShipDestinationItemSemanticEditPolicy());

	}

	protected Connection createConnectionFigure() {
		return new ArrowConnection();
	}

	/**
	 * @generated
	 */
	public class ShipDestinationFigure extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ShipDestinationFigure() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolylineDecoration createTargetDecoration() {
			org.eclipse.draw2d.PolylineDecoration df = new org.eclipse.draw2d.PolylineDecoration();
			// dispatchNext?

			return df;
		}

	}
}
