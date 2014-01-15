package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.Subject4CreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.Subject5CreateCommand;
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
		if (LesscodeElementTypes.Subject_3003 == req.getElementType()) {
			return getGEFWrapper(new Subject4CreateCommand(req));
		}
		if (LesscodeElementTypes.Subject_3004 == req.getElementType()) {
			return getGEFWrapper(new Subject5CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
