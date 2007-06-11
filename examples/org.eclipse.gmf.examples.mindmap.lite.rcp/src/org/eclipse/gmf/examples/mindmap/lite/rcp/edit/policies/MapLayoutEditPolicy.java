package org.eclipse.gmf.examples.mindmap.lite.rcp.edit.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.AddResource2002Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.AddTopic2001Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.CloneResource2002Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.CloneTopic2001Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.CreateResource2002Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.commands.CreateTopic2001Command;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.MapEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.ResourceEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.lite.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.policies.XYLayoutEditPolicyEx;
import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * @generated
 */
public class MapLayoutEditPolicy extends XYLayoutEditPolicyEx {
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
				case TopicEditPart.VISUAL_ID:
					result.append(new CreateTopic2001Command(
							(Diagram) getHost().getModel(), requestEx,
							(Rectangle) getConstraintFor(request)));
					break;
				case ResourceEditPart.VISUAL_ID:
					result.append(new CreateResource2002Command(
							(Diagram) getHost().getModel(), requestEx,
							(Rectangle) getConstraintFor(request)));
					break;
				}
			}
			return new WrappingCommand(TransactionUtil
					.getEditingDomain(((Diagram) getHost().getModel())
							.getElement()), result);
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
						(Diagram) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
				case TopicEditPart.VISUAL_ID:
					command = new AddTopic2001Command((Diagram) getHost()
							.getModel(), childNode, newVisualID,
							(Rectangle) constraint);
					break;
				case ResourceEditPart.VISUAL_ID:
					command = new AddResource2002Command((Diagram) getHost()
							.getModel(), childNode, newVisualID,
							(Rectangle) constraint);
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
						(Diagram) getHost().getModel(), childNode.getElement());
				org.eclipse.emf.common.command.Command command = null;
				switch (newVisualID) {
				case TopicEditPart.VISUAL_ID:
					command = new CloneTopic2001Command((Diagram) getHost()
							.getModel(), childNode, (Rectangle) constraint);
					break;
				case ResourceEditPart.VISUAL_ID:
					command = new CloneResource2002Command((Diagram) getHost()
							.getModel(), childNode, (Rectangle) constraint);
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
