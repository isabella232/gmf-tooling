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
public class TimeSlotViewFactory extends AbstractShapeViewFactory {

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
		annotation.getDetails().put("visualID", "2001"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view,
				EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTSTART_4003,
				ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view,
				EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTEND_4004,
				ViewUtil.APPEND, true, getPreferencesHint());
	}
}
