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

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.AquatoryCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.AquatoryItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.notation.Node;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands.TaiPanCreateShortcutDecorationsCommand;

/**
 * @generated
 */
public class AquatoryEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public static final String MODEL_ID = "TaiPan"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public AquatoryEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AquatoryItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new AquatoryCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DiagramDragDropEditPolicy() {

			public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
				List viewDescriptors = new ArrayList();
				for (Iterator it = dropRequest.getObjects().iterator(); it.hasNext();) {
					viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) it.next()), Node.class, null, getDiagramPreferencesHint()));
				}
				return createShortcutsCommand(dropRequest, viewDescriptors);
			}

			private Command createShortcutsCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
				Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
				if (command != null) {
					return command.chain(new ICommandProxy(new TaiPanCreateShortcutDecorationsCommand(getEditingDomain(), (View) getModel(), viewDescriptors)));
				}
				return null;
			}
		});
	}
}
