package org.eclipse.gmf.tooling.examples.compartments.diagram.providers;

import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.CompartmentsEditPartFactory;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class CompartmentsEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public CompartmentsEditPartProvider() {
		super(new CompartmentsEditPartFactory(), CompartmentsVisualIDRegistry.TYPED_INSTANCE, CanvasEditPart.MODEL_ID);
	}

}
