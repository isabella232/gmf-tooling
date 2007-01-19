package org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.commands.ThreadCreateCommand;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class TopicThreadCompartmentItemSemanticEditPolicy extends
		MindmapBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MindmapElementTypes.Thread_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MindmapPackage.eINSTANCE
						.getTopic_Comments());
			}
			return getMSLWrapper(new ThreadCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
