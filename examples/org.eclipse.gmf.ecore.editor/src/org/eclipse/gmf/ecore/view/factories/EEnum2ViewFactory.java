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
public class EEnum2ViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Ecore"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "1005"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EEnum_1005Labels.EENUMNAME_4014_TEXT, ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EEnum_1005Compartments.LITERALS_5011, ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EEnum_1005Compartments.ENUM_ANNOTATIONS_5012, ViewUtil.APPEND, true, getPreferencesHint());
	}
}
