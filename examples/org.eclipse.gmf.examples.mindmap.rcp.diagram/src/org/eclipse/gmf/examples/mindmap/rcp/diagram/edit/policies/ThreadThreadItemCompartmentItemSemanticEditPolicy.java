package org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.commands.ThreadItemCreateCommand;

import org.eclipse.gmf.examples.mindmap.rcp.diagram.providers.MindmapElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ThreadThreadItemCompartmentItemSemanticEditPolicy extends
		MindmapBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MindmapElementTypes.ThreadItem_3002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(MindmapPackage.eINSTANCE
						.getThread_Items());
			}
			return getMSLWrapper(new ThreadItemCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
