package org.eclipse.gmf.examples.eclipsecon.diagram.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

/**
 * @generated
 */
public class ScheduleViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Eclipsecon"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "1003"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view,
				EclipseconSemanticHints.Schedule_1003Labels.SCHEDULEDAYNO_4005,
				ViewUtil.APPEND, true, getPreferencesHint());
	}
}
