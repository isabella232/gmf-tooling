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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.DestinationItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanReferenceConnectionEditPolicy;

/**
 * @generated
 */
public class DestinationEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public DestinationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new TaiPanReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DestinationItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new line();
	}

	/**
	 * @generated
	 */
	public class line extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public line() {

		}

	}
}
