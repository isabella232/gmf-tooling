package org.eclipse.gmf.ecore.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

/**
 * @generated
 */
public class EClassViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Ecore"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "1001"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4001_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EClass_1001Compartments.ATTRIBUTES_5001, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EClass_1001Compartments.OPERATIONS_5002, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EClass_1001Compartments.CLASS_ANNOTATIONS_5003, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
