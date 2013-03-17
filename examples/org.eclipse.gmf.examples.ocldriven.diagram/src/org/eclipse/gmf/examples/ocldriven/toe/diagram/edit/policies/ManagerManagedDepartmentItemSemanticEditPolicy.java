package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class ManagerManagedDepartmentItemSemanticEditPolicy extends TOEBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ManagerManagedDepartmentItemSemanticEditPolicy() {
		super(TOEElementTypes.ManagerManagedDepartment_4001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
