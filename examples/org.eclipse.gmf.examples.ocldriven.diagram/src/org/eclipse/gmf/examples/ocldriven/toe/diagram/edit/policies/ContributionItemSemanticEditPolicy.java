package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * @generated
 */
public class ContributionItemSemanticEditPolicy extends TOEBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ContributionItemSemanticEditPolicy() {
		super(TOEElementTypes.Contribution_4003);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
