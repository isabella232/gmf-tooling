package org.eclipse.gmf.example.lesscode.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.MultiContainmentGroupCreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.OneContainmentGroupCreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.edit.commands.SubjectCreateCommand;
import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
* @generated
*/
public class RootContainerItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public RootContainerItemSemanticEditPolicy() {
		super(LesscodeElementTypes.RootContainer_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (LesscodeElementTypes.Subject_2001 == req.getElementType()) {
			return getGEFWrapper(new SubjectCreateCommand(req));
		}
		if (LesscodeElementTypes.OneContainmentGroup_2002 == req.getElementType()) {
			return getGEFWrapper(new OneContainmentGroupCreateCommand(req));
		}
		if (LesscodeElementTypes.MultiContainmentGroup_2003 == req.getElementType()) {
			return getGEFWrapper(new MultiContainmentGroupCreateCommand(req));
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
