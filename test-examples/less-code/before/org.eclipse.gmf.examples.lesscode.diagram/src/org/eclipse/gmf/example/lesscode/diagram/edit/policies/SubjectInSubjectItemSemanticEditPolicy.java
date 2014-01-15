package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.Subject2CreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
* @generated
*/
public class SubjectInSubjectItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public SubjectInSubjectItemSemanticEditPolicy() {
		super(LesscodeElementTypes.Subject_2001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LesscodeElementTypes.Subject_3001 == req.getElementType()) {
			return getGEFWrapper(new Subject2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
