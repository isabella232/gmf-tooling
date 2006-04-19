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

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.RouteItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.figures.ArrowConnection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class RouteEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static String VISUAL_ID = "3002";

	/**
	 * @generated
	 */
	public RouteEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RouteItemSemanticEditPolicy());
	}

	protected Connection createConnectionFigure() {
		return new ArrowConnection();
	}
}
