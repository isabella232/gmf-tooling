package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.Subject3CreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
* @generated
*/
public class OneContainmentGroupInGroupOneItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public OneContainmentGroupInGroupOneItemSemanticEditPolicy() {
		super(LesscodeElementTypes.OneContainmentGroup_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LesscodeElementTypes.Subject_3002 == req.getElementType()) {
			return getGEFWrapper(new Subject3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
