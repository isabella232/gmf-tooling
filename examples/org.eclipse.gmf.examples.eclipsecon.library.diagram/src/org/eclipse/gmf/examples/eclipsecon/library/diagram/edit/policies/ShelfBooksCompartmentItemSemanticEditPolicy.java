package org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.commands.BookCreateCommand;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.providers.Library07ElementTypes;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ShelfBooksCompartmentItemSemanticEditPolicy extends
		Library07BaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Library07ElementTypes.Book_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(LibraryPackage.eINSTANCE
						.getShelf_Books());
			}
			return getMSLWrapper(new BookCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
