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

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.layout.PortLayoutProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.providers.LeftRightProvider;
import org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeProvider;
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

			public Runnable layoutNodes(List nodes, boolean offsetFromBoundingBox, IAdaptable layoutHint) {
				ILayoutNodeProvider provider = new PortLayoutProvider();
				return provider.layoutLayoutNodes(nodes, offsetFromBoundingBox, layoutHint);
			}
		});
	}
}
