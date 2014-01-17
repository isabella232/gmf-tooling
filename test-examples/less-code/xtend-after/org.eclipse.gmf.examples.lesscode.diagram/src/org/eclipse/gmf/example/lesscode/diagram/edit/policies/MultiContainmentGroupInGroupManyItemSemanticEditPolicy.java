package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.SubjectCreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class MultiContainmentGroupInGroupManyItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MultiContainmentGroupInGroupManyItemSemanticEditPolicy() {
		super(LesscodeElementTypes.MultiContainmentGroup_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LesscodeElementTypes.Subject_2001 == req.getElementType()) {
			return getGEFWrapper(new SubjectCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
