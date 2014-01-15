package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class SubjectReferenceBasedLinkTargetItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SubjectReferenceBasedLinkTargetItemSemanticEditPolicy() {
		super(LesscodeElementTypes.SubjectReferenceBasedLinkTarget_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
