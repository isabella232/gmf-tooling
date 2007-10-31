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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.AddThreadItem3002Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CloneThreadItem3002Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateThreadItem3002Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadItemEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.policies.ListLayoutEditPolicy;
import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @generated
 */
public class ThreadThreadItemCompartmentLayoutEditPolicy extends
		ListLayoutEditPolicy {
	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateRequest request) {
		if (request instanceof CreateRequestEx) {
			CreateRequestEx requestEx = (CreateRequestEx) request;
			if (!MapEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}
			int[] visualIds = requestEx.getVisualIds();
			CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
				case ThreadItemEditPart.VISUAL_ID:
					result.append(new CreateThreadItem3002Command(
							(Node) getHost().getModel(), requestEx));
					break;
				}
			}
			return new WrappingCommand(TransactionUtil
					.getEditingDomain(((Node) getHost().getModel())
							.getDiagram().getElement()), result);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command createAddCommand(EditPart child, Object constraint) {
		if (child.getModel() instanceof Node) {
			Node childNode = (Node) child.getModel();
			String modelID = MindmapVisualIDRegistry.getModelID(childNode);
			if (MapEditPart.MODEL_ID.equals(modelID)) {
				int newVisualID = MindmapVisualIDRegistry.getNodeVisualID(
						(Node) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
				case ThreadItemEditPart.VISUAL_ID:
					command = new AddThreadItem3002Command((Node) getHost()
							.getModel(), childNode, newVisualID, null);
					break;
				}
				if (command != null) {
					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(childNode.getDiagram()
									.getElement());
					return new WrappingCommand(editingDomain, command);
				}
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command createCloneCommand(EditPart child, Object constraint) {
		if (child.getModel() instanceof Node) {
			Node childNode = (Node) child.getModel();
			String modelID = MindmapVisualIDRegistry.getModelID(childNode);
			if (MapEditPart.MODEL_ID.equals(modelID)) {
				int newVisualID = MindmapVisualIDRegistry.getNodeVisualID(
						(Node) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
				case ThreadItemEditPart.VISUAL_ID:
					command = new CloneThreadItem3002Command((Node) getHost()
							.getModel(), childNode, null);
					break;
				}
				if (command != null) {
					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(childNode.getDiagram()
									.getElement());
					return new WrappingCommand(editingDomain, command);
				}
			}
		}
		return null;
	}
}
