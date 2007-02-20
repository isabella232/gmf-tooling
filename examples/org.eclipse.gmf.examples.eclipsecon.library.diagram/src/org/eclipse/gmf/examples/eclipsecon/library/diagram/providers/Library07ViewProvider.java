package org.eclipse.gmf.examples.eclipsecon.library.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.AuthorNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.BookEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.LibraryEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfBooksCompartmentEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.ShelfNameEditPart;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.AuthorNameViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.AuthorViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.BookViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.EmployeeNameViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.EmployeeShelvesViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.EmployeeViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.LibraryViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.ShelfBooksCompartmentViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.ShelfNameViewFactory;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories.ShelfViewFactory;

/**
 * @generated
 */
public class Library07ViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (LibraryEditPart.MODEL_ID.equals(diagramKind)
				&& Library07VisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return LibraryViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !Library07ElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = Library07VisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case AuthorEditPart.VISUAL_ID:
			return AuthorViewFactory.class;
		case AuthorNameEditPart.VISUAL_ID:
			return AuthorNameViewFactory.class;
		case ShelfEditPart.VISUAL_ID:
			return ShelfViewFactory.class;
		case ShelfNameEditPart.VISUAL_ID:
			return ShelfNameViewFactory.class;
		case EmployeeEditPart.VISUAL_ID:
			return EmployeeViewFactory.class;
		case EmployeeNameEditPart.VISUAL_ID:
			return EmployeeNameViewFactory.class;
		case BookEditPart.VISUAL_ID:
			return BookViewFactory.class;
		case ShelfBooksCompartmentEditPart.VISUAL_ID:
			return ShelfBooksCompartmentViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !Library07ElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		if (Library07ElementTypes.EmployeeShelves_3001.equals(elementType)) {
			return EmployeeShelvesViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = Library07VisualIDRegistry.getLinkWithClassVisualID(
				semanticElement, semanticType);
		switch (linkVID) {
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
