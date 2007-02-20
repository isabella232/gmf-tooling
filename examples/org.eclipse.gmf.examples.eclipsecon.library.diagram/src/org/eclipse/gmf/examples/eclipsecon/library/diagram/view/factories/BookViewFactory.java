package org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.BookEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.LibraryEditPart;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class BookViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated 
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = Library07VisualIDRegistry
					.getType(BookEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		if (!LibraryEditPart.MODEL_ID.equals(Library07VisualIDRegistry
				.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE
					.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(
					"modelID", LibraryEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
	}

}
