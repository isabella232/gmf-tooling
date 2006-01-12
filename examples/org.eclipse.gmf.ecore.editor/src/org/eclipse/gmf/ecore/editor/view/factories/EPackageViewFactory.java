package org.eclipse.gmf.ecore.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackageViewFactory extends DiagramViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View view, IAdaptable semanticAdapter, String diagramKind) {
		super.decorateView(view, semanticAdapter, diagramKind);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "Ecore"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "79"); //$NON-NLS-1$
	}
}
