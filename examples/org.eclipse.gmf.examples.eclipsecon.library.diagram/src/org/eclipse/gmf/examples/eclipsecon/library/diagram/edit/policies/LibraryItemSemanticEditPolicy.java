package org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.commands.AuthorCreateCommand;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.commands.EmployeeCreateCommand;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.commands.ShelfCreateCommand;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.providers.Library07ElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class LibraryItemSemanticEditPolicy extends
		Library07BaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Library07ElementTypes.Author_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(LibraryPackage.eINSTANCE
						.getLibrary_Authors());
			}
			return getMSLWrapper(new AuthorCreateCommand(req));
		}
		if (Library07ElementTypes.Shelf_1002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(LibraryPackage.eINSTANCE
						.getLibrary_Shelves());
			}
			return getMSLWrapper(new ShelfCreateCommand(req));
		}
		if (Library07ElementTypes.Employee_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(LibraryPackage.eINSTANCE
						.getLibrary_Employees());
			}
			return getMSLWrapper(new EmployeeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getMSLWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}
	}
}
