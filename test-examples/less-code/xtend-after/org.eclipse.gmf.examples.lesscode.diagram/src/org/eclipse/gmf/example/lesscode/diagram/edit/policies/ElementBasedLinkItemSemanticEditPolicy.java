package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class ElementBasedLinkItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ElementBasedLinkItemSemanticEditPolicy() {
		super(LesscodeElementTypes.ElementBasedLink_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
