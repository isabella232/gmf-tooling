package org.eclipse.gmf.examples.eclipsecon.library.diagram.part;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.library.Author;
import org.eclipse.gmf.examples.eclipsecon.library.Book;
import org.eclipse.gmf.examples.eclipsecon.library.Employee;
import org.eclipse.gmf.examples.eclipsecon.library.Library;
import org.eclipse.gmf.examples.eclipsecon.library.LibraryPackage;
import org.eclipse.gmf.examples.eclipsecon.library.Shelf;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.BookEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.LibraryEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfBooksCompartmentEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfNameEditPart;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class Library07VisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = Library07DiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (LibraryEditPart.MODEL_ID.equals(view.getType())) {
				return LibraryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				Library07DiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (LibraryPackage.eINSTANCE.getLibrary().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramLibrary_79((Library) domainElement)) {
			return LibraryEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!LibraryEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (LibraryEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = LibraryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case AuthorEditPart.VISUAL_ID:
			if (AuthorNameEditPart.VISUAL_ID == nodeVisualID) {
				return AuthorNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedAuthor_1001ChildNodeID(domainElement,
					semanticHint);
		case ShelfEditPart.VISUAL_ID:
			if (ShelfNameEditPart.VISUAL_ID == nodeVisualID) {
				return ShelfNameEditPart.VISUAL_ID;
			}
			if (ShelfBooksCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ShelfBooksCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedShelf_1002ChildNodeID(domainElement,
					semanticHint);
		case EmployeeEditPart.VISUAL_ID:
			if (EmployeeNameEditPart.VISUAL_ID == nodeVisualID) {
				return EmployeeNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedEmployee_1003ChildNodeID(domainElement,
					semanticHint);
		case BookEditPart.VISUAL_ID:
			return getUnrecognizedBook_2001ChildNodeID(domainElement,
					semanticHint);
		case ShelfBooksCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || BookEditPart.VISUAL_ID == nodeVisualID)
					&& LibraryPackage.eINSTANCE.getBook().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeBook_2001((Book) domainElement))) {
				return BookEditPart.VISUAL_ID;
			}
			return getUnrecognizedShelfBooksCompartment_5001ChildNodeID(
					domainElement, semanticHint);
		case LibraryEditPart.VISUAL_ID:
			if ((semanticHint == null || AuthorEditPart.VISUAL_ID == nodeVisualID)
					&& LibraryPackage.eINSTANCE.getAuthor().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeAuthor_1001((Author) domainElement))) {
				return AuthorEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ShelfEditPart.VISUAL_ID == nodeVisualID)
					&& LibraryPackage.eINSTANCE.getShelf().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeShelf_1002((Shelf) domainElement))) {
				return ShelfEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EmployeeEditPart.VISUAL_ID == nodeVisualID)
					&& LibraryPackage.eINSTANCE.getEmployee().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeEmployee_1003((Employee) domainElement))) {
				return EmployeeEditPart.VISUAL_ID;
			}
			return getUnrecognizedLibrary_79ChildNodeID(domainElement,
					semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		{
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramLibrary_79(Library element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeAuthor_1001(Author element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeShelf_1002(Shelf element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEmployee_1003(Employee element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeBook_2001(Book element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAuthor_1001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShelf_1002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEmployee_1003ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedBook_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShelfBooksCompartment_5001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLibrary_79ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}
}
