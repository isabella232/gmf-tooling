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
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4002Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4002StartCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4003Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4003StartCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4004Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateRelationship4004StartCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateTopic_Subtopics4001Command;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.CreateTopic_Subtopics4001StartCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4002SourceCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4002TargetCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4003SourceCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4003TargetCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4004SourceCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectRelationship4004TargetCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectTopic_Subtopics4001SourceCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.commands.ReconnectTopic_Subtopics4001TargetCommand;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship2EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship3EditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @generated
 */
public class TopicGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
	/**
	 * @generated
	 */
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (request instanceof CreateConnectionRequestEx) {
			CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
			if (!MapEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}
			int[] visualIds = requestEx.getVisualIds();
			CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
				case TopicSubtopicsEditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateTopic_Subtopics4001StartCommand(
									requestEx));
					break;
				case RelationshipEditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4002StartCommand(
									requestEx));
					break;
				case Relationship2EditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4003StartCommand(
									requestEx));
					break;
				case Relationship3EditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4004StartCommand(
									requestEx));
					break;
				}
			}
			if (!result.canExecute()) {
				return null;
			}
			Command wrappedResult = new WrappingCommand(TransactionUtil
					.getEditingDomain(((Node) getHost().getModel())
							.getDiagram().getElement()), result);
			request.setStartCommand(wrappedResult);
			return wrappedResult;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConnectionCompleteCommand(
			CreateConnectionRequest request) {
		if (request instanceof CreateConnectionRequestEx) {
			if (request.getStartCommand() == null
					|| !request.getStartCommand().canExecute()) {
				return UnexecutableCommand.INSTANCE;
			}
			CreateConnectionRequestEx requestEx = (CreateConnectionRequestEx) request;
			if (!MapEditPart.MODEL_ID.equals(requestEx.getModelID())) {
				return null;
			}
			int[] visualIds = requestEx.getVisualIds();
			CompoundCommand result = new CompoundCommand();
			for (int i = 0; i < visualIds.length; i++) {
				int nextVisualId = visualIds[i];
				switch (nextVisualId) {
				case TopicSubtopicsEditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateTopic_Subtopics4001Command(
									requestEx));
					break;
				case RelationshipEditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4002Command(
									requestEx));
					break;
				case Relationship2EditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4003Command(
									requestEx));
					break;
				case Relationship3EditPart.VISUAL_ID:
					result
							.appendIfCanExecute(new CreateRelationship4004Command(
									requestEx));
					break;
				}
			}
			if (result.getCommandList().size() != 1 || !result.canExecute()) {
				//Cannot create several connections at once.
				return UnexecutableCommand.INSTANCE;
			}
			return request.getStartCommand().chain(
					new WrappingCommand(TransactionUtil
							.getEditingDomain(((Node) getHost().getModel())
									.getDiagram().getElement()), result));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		if (connection.getModel() instanceof Edge == false) {
			return null;
		}
		Edge edge = (Edge) connection.getModel();
		String modelID = MindmapVisualIDRegistry.getModelID(edge);
		if (!MapEditPart.MODEL_ID.equals(modelID)) {
			return null;
		}
		org.eclipse.emf.common.command.Command result = null;
		int visualID = MindmapVisualIDRegistry.getVisualID(edge);
		switch (visualID) {
		case TopicSubtopicsEditPart.VISUAL_ID:
			result = new ReconnectTopic_Subtopics4001SourceCommand(request);
			break;
		case RelationshipEditPart.VISUAL_ID:
			result = new ReconnectRelationship4002SourceCommand(request);
			break;
		case Relationship2EditPart.VISUAL_ID:
			result = new ReconnectRelationship4003SourceCommand(request);
			break;
		case Relationship3EditPart.VISUAL_ID:
			result = new ReconnectRelationship4004SourceCommand(request);
			break;
		}
		if (result == null || !result.canExecute()) {
			return null;
		}
		return new WrappingCommand(TransactionUtil
				.getEditingDomain(((Node) getHost().getModel()).getDiagram()
						.getElement()), result);
	}

	/**
	 * @generated
	 */
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		if (connection.getModel() instanceof Edge == false) {
			return null;
		}
		Edge edge = (Edge) connection.getModel();
		String modelID = MindmapVisualIDRegistry.getModelID(edge);
		if (!MapEditPart.MODEL_ID.equals(modelID)) {
			return null;
		}
		org.eclipse.emf.common.command.Command result = null;
		int visualID = MindmapVisualIDRegistry.getVisualID(edge);
		switch (visualID) {
		case TopicSubtopicsEditPart.VISUAL_ID:
			result = new ReconnectTopic_Subtopics4001TargetCommand(request);
			break;
		case RelationshipEditPart.VISUAL_ID:
			result = new ReconnectRelationship4002TargetCommand(request);
			break;
		case Relationship2EditPart.VISUAL_ID:
			result = new ReconnectRelationship4003TargetCommand(request);
			break;
		case Relationship3EditPart.VISUAL_ID:
			result = new ReconnectRelationship4004TargetCommand(request);
			break;
		}
		if (result == null || !result.canExecute()) {
			return null;
		}
		return new WrappingCommand(TransactionUtil
				.getEditingDomain(((Node) getHost().getModel()).getDiagram()
						.getElement()), result);
	}
}
