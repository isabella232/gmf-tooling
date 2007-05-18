/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.layout.PortLayoutProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Port"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	private PortLayoutProvider layoutProvider = new PortLayoutProvider();

	/**
	 * @generated
	 */
	public PortEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPoliciesGen() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PortItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PortCanonicalEditPolicy());
	}

	protected void createDefaultEditPolicies() {
		createDefaultEditPoliciesGen();
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {

			protected Command getArrangeCommand(ArrangeRequest request) {
				if (layoutProvider.isWorking()) {
					return null;
				}
				return super.getArrangeCommand(request);
			}

			public Runnable layoutNodes(List nodes, boolean offsetFromBoundingBox, IAdaptable layoutHint) {
				return layoutProvider.layoutLayoutNodes(nodes, offsetFromBoundingBox, layoutHint);
			}
		});
	}

	public Command getCommand(Request request) {
		Command command = super.getCommand(request);
		if (request.getType().equals(REQ_CREATE) || request.getType().equals(REQ_MOVE_CHILDREN) || request.getType().equals(REQ_RESIZE_CHILDREN)) {
			ArrangeRequest layoutRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			List editParts = request instanceof GroupRequest ? ((GroupRequest) request).getEditParts() : getChildren();
			layoutRequest.setViewAdaptersToArrange(new ArrayList(editParts));
			Command layoutCommand = super.getCommand(layoutRequest);
			if (layoutCommand != null) {
				command = command.chain(layoutCommand);
			}
		}
		return command;
	}
}
