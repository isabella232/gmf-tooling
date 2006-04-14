package org.eclipse.gmf.graphdef.gmfEditor.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CanvasEditPart;

import org.eclipse.gmf.graphdef.gmfEditor.part.GMFGraphVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FigureGallery_FiguresViewFactory extends ListCompartmentViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.eclipse.gmf.graphdef.gmfEditor.edit.parts.FigureGallery_FiguresEditPart.VISUAL_ID;
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!CanvasEditPart.MODEL_ID.equals(GMFGraphVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", CanvasEditPart.MODEL_ID);
		}
	}
}
