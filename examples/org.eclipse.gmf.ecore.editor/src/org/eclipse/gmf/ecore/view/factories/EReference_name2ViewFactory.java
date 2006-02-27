package org.eclipse.gmf.ecore.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.providers.EcoreSemanticHints;

/**
 * @generated
 */
public class EReference_name2ViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Ecore"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "4016"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4016_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
