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
package org.eclipse.gmf.examples.design2d.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.Connection;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.design2d.edit.policies.SolidLineItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;

import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @generated
 */
public class SolidLineEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public SolidLineEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ViewComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SolidLineItemSemanticEditPolicy() {

			protected Command getSemanticCommand(IEditCommandRequest editRequest) {
				if (editRequest instanceof DestroyElementRequest && getHost() instanceof GraphicalEditPart) {
					return new EtoolsProxyCommand(new DeleteCommand(editRequest.getEditingDomain(), ((GraphicalEditPart) getHost()).getPrimaryView()));
				}
				return super.getSemanticCommand(editRequest);
			}

			public Command getCommand(Request request) {
				if (REQ_RECONNECT_SOURCE.equals(request.getType()) || REQ_RECONNECT_TARGET.equals(request.getType())) {
					return null;
				}
				return super.getCommand(request);
			}
		});
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
		return new SolidLineFigure();
	}

	/**
	 * @generated
	 */
	public class SolidLineFigure extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SolidLineFigure() {

		}

	}
}
