package org.eclipse.gmf.ecore.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.providers.EcoreSemanticHints;

/**
 * @generated
 */
public class EReference_nameViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("VisualID");
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("value", "4018");
		getViewService().createNode(semanticAdapter, view, EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
