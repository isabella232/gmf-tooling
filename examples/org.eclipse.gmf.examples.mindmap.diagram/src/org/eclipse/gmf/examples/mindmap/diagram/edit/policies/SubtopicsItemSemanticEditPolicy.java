package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class SubtopicsItemSemanticEditPolicy extends
		MindmapBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getMSLWrapper(new DestroyReferenceCommand(req));
	}
}
