package pins.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import pins.diagram.edit.parts.DiagramEditPart;
import pins.diagram.edit.parts.PinsEditPartFactory;
import pins.diagram.part.PinsVisualIDRegistry;

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
