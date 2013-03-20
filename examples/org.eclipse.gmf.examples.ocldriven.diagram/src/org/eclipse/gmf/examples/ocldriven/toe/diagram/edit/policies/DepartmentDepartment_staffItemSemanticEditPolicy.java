package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.Department2CreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.Employee2CreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
* @generated
*/
public class DepartmentDepartment_staffItemSemanticEditPolicy extends TOEBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public DepartmentDepartment_staffItemSemanticEditPolicy() {
		super(TOEElementTypes.Department_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (TOEElementTypes.Employee_3001 == req.getElementType()) {
			return getGEFWrapper(new Employee2CreateCommand(req));
		}
		if (TOEElementTypes.Department_3002 == req.getElementType()) {
			return getGEFWrapper(new Department2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
