package org.eclipse.gmf.examples.eclipsecon.library.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.EmployeeShelvesEditPart;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts.LibraryEditPart;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.part.Library07VisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EmployeeShelvesViewFactory extends ConnectionViewFactory {

	/**
	 * @generated 
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createRoutingStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		styles.add(NotationFactory.eINSTANCE.createLineStyle());
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
					.getType(EmployeeShelvesEditPart.VISUAL_ID);
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
