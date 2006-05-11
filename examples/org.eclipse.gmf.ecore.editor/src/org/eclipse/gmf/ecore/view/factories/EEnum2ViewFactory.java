package org.eclipse.gmf.ecore.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.ecore.edit.parts.EEnum_enumannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_literalsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EEnum2ViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = EcoreVisualIDRegistry.getType(org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", EPackageEditPart.MODEL_ID);
			view.getEAnnotations().add(shortcutAnnotation);
		}
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EEnum_nameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EEnum_literalsEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EEnum_enumannotationsEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}
}
