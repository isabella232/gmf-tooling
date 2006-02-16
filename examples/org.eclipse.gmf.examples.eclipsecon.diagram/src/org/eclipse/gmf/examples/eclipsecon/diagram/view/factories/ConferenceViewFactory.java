package org.eclipse.gmf.examples.eclipsecon.diagram.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;

/**
 * @generated
 */
public class ConferenceViewFactory extends DiagramViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View view, IAdaptable semanticAdapter,
			String diagramKind) {
		super.decorateView(view, semanticAdapter, diagramKind);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Eclipsecon"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "79"); //$NON-NLS-1$
	}

	protected MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit.PIXEL_LITERAL;
	}
}
