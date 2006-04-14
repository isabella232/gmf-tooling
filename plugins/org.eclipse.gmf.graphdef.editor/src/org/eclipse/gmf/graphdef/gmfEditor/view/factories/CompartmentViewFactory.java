package org.eclipse.gmf.graphdef.gmfEditor.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CanvasEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Compartment_VisualFacetsEditPart;
import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.Compartment_nameEditPart;

import org.eclipse.gmf.graphdef.gmfEditor.part.GMFGraphVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CompartmentViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CompartmentEditPart.VISUAL_ID;
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!CanvasEditPart.MODEL_ID.equals(GMFGraphVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", CanvasEditPart.MODEL_ID);
		}
		getViewService().createNode(semanticAdapter, view, Compartment_nameEditPart.VISUAL_ID, ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, Compartment_VisualFacetsEditPart.VISUAL_ID, ViewUtil.APPEND, true, getPreferencesHint());
	}
}
