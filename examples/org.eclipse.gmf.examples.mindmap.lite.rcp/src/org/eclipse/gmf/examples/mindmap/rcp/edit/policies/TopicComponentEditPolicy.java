/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		CompoundCommand result = new CompoundCommand();
		for (Iterator it = getGraphicalEditPart().getTargetConnections()
				.iterator(); it.hasNext();) {
			EditPart nextEditPart = (EditPart) it.next();
			Edge nextEdge = (Edge) nextEditPart.getModel();
			int visualID = MindmapVisualIDRegistry.getVisualID(nextEdge);
			switch (visualID) {
			case RelationshipEditPart.VISUAL_ID:
			case Relationship2EditPart.VISUAL_ID:
			case Relationship3EditPart.VISUAL_ID: {
				GroupRequest deleteLinkRequest = new GroupRequest(
						RequestConstants.REQ_DELETE);
				deleteLinkRequest.setEditParts(nextEditPart);
				result.add(nextEditPart.getCommand(deleteLinkRequest));
				break;
			}
			}
		}
		for (Iterator it = getGraphicalEditPart().getSourceConnections()
				.iterator(); it.hasNext();) {
			EditPart nextEditPart = (EditPart) it.next();
			Edge nextEdge = (Edge) nextEditPart.getModel();
			int visualID = MindmapVisualIDRegistry.getVisualID(nextEdge);
			switch (visualID) {
			case TopicSubtopicsEditPart.VISUAL_ID:
			case RelationshipEditPart.VISUAL_ID:
			case Relationship2EditPart.VISUAL_ID:
			case Relationship3EditPart.VISUAL_ID: {
				GroupRequest deleteLinkRequest = new GroupRequest(
						RequestConstants.REQ_DELETE);
				deleteLinkRequest.setEditParts(nextEditPart);
				result.add(nextEditPart.getCommand(deleteLinkRequest));
				break;
			}
			}
		}
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(getDiagramNode().getDiagram().getElement());
		org.eclipse.emf.common.command.CompoundCommand cc = new org.eclipse.emf.common.command.CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalElementCommand((View) getDiagramNode()
				.eContainer(), getDiagramNode()));
		result.add(new WrappingCommand(editingDomain, cc));
		return result.unwrap();
	}

	/**
	 * @generated
	 */
	protected GraphicalEditPart getGraphicalEditPart() {
		return (GraphicalEditPart) getHost();
	}

	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			TransactionalEditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramNode()
				.getElement());
	}

	/**
	 * @generated
	 */
	protected Node getDiagramNode() {
		return (Node) getHost().getModel();
	}
}
