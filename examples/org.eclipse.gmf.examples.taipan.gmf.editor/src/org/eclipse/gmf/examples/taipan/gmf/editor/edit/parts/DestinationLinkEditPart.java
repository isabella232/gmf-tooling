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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.PolylineDecoration;

import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ShipDestinationLinkItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanReferenceConnectionEditPolicy;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * @generated
 */
public class DestinationLinkEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public DestinationLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new TaiPanReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ShipDestinationLinkItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		PolylineConnectionEx connection = new PolylineConnectionEx();
		RotatableDecoration sourceDecoration = createSourceDecoration();
		if (sourceDecoration != null) {
			connection.setSourceDecoration(sourceDecoration);
		}
		RotatableDecoration targetDecoration = createTargetDecoration();
		if (targetDecoration != null) {
			connection.setTargetDecoration(targetDecoration);
		}

		connection.setLineStyle(Graphics.LINE_SOLID);
		return connection;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createSourceDecoration() {

		return null;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createTargetDecoration() {

		PolylineDecoration decoration = new PolylineDecoration();
		decoration.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
		return decoration;
	}
}
