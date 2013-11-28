package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.TopNodeACreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.TopNodeBCreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
* @generated
*/
public class CanvasItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public CanvasItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.Canvas_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.TopNodeA_2001 == req.getElementType()) {
			return getGEFWrapper(new TopNodeACreateCommand(req));
		}
		if (CompartmentsElementTypes.TopNodeB_2002 == req.getElementType()) {
			return getGEFWrapper(new TopNodeBCreateCommand(req));
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
