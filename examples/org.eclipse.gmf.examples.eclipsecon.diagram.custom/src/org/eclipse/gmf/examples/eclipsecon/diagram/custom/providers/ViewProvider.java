package org.eclipse.gmf.examples.eclipsecon.diagram.custom.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.factories.PresenterWithStyleFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;



public class ViewProvider
	extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
			containerView, semanticElement, semanticType, semanticHint);
		if (nodeVID == 1001)
			return PresenterWithStyleFactory.class;
	
		return null;
	}
}
