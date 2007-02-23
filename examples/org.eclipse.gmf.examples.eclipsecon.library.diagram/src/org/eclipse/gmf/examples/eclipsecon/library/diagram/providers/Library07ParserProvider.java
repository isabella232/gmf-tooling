package org.eclipse.gmf.examples.eclipsecon.library.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.BookEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfNameEditPart;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

/**
 * @generated
 */
public class Library07ParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser authorAuthorName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getAuthorAuthorName_4001Parser() {
		if (authorAuthorName_4001Parser == null) {
			authorAuthorName_4001Parser = createAuthorAuthorName_4001Parser();
		}
		return authorAuthorName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAuthorAuthorName_4001Parser() {
		Library07StructuralFeatureParser parser = new Library07StructuralFeatureParser(
				LibraryPackage.eINSTANCE.getAuthor_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shelfShelfName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getShelfShelfName_4002Parser() {
		if (shelfShelfName_4002Parser == null) {
			shelfShelfName_4002Parser = createShelfShelfName_4002Parser();
		}
		return shelfShelfName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShelfShelfName_4002Parser() {
		Library07StructuralFeatureParser parser = new Library07StructuralFeatureParser(
				LibraryPackage.eINSTANCE.getShelf_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser employeeEmployeeName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getEmployeeEmployeeName_4003Parser() {
		if (employeeEmployeeName_4003Parser == null) {
			employeeEmployeeName_4003Parser = createEmployeeEmployeeName_4003Parser();
		}
		return employeeEmployeeName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEmployeeEmployeeName_4003Parser() {
		Library07StructuralFeatureParser parser = new Library07StructuralFeatureParser(
				LibraryPackage.eINSTANCE.getEmployee_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AuthorNameEditPart.VISUAL_ID:
			return getAuthorAuthorName_4001Parser();
		case ShelfNameEditPart.VISUAL_ID:
			return getShelfShelfName_4002Parser();
		case EmployeeNameEditPart.VISUAL_ID:
			return getEmployeeEmployeeName_4003Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(Library07VisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(Library07VisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (Library07ElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}
