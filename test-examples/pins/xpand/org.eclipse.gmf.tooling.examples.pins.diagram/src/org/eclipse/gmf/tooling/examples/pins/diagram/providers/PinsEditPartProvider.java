package org.eclipse.gmf.tooling.examples.pins.diagram.providers;

import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.PinsEditPartFactory;
import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class PinsEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public PinsEditPartProvider() {
		super(new PinsEditPartFactory(), PinsVisualIDRegistry.TYPED_INSTANCE, DiagramEditPart.MODEL_ID);
	}

}
