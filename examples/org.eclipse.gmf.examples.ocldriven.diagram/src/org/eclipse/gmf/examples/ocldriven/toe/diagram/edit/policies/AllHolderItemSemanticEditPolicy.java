package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.DepartmentCreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.EmployeeCreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.ManagerCreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands.ProjectCreateCommand;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.providers.TOEElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
* @generated
*/
public class AllHolderItemSemanticEditPolicy extends TOEBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public AllHolderItemSemanticEditPolicy() {
		super(TOEElementTypes.AllHolder_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (TOEElementTypes.Employee_2001 == req.getElementType()) {
			return getGEFWrapper(new EmployeeCreateCommand(req));
		}
		if (TOEElementTypes.Department_2002 == req.getElementType()) {
			return getGEFWrapper(new DepartmentCreateCommand(req));
		}
		if (TOEElementTypes.Project_2003 == req.getElementType()) {
			return getGEFWrapper(new ProjectCreateCommand(req));
		}
		if (TOEElementTypes.Manager_2004 == req.getElementType()) {
			return getGEFWrapper(new ManagerCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
