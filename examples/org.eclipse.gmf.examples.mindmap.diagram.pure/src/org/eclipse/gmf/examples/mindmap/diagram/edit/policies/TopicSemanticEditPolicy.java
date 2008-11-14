package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.mindmap.diagram.commands.SubtopicCreateCommand;
import org.eclipse.gmf.examples.mindmap.diagram.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public class TopicSemanticEditPolicy extends SemanticEditPolicy {

	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		if (request instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) request);
		}
		return super.getSemanticCommand(request);
	}
	
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : null;
	}

	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MindmapElementTypes.SUBTOPIC == req.getElementType()) {
			return new ICommandProxy(new SubtopicCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MindmapElementTypes.SUBTOPIC == req.getElementType()) {
			return new ICommandProxy(new SubtopicCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

}
