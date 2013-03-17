package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class ManagerLeadsItemSemanticEditPolicy extends TOEBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ManagerLeadsItemSemanticEditPolicy() {
		super(TOEElementTypes.ManagerLeads_4002);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
