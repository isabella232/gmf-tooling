package org.eclipse.gmf.ecore.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReferencesViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.eclipse.gmf.ecore.edit.parts.ReferencesEditPart.VISUAL_ID;
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", EPackageEditPart.MODEL_ID);
		}
	}
}
