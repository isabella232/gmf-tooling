package borders.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import borders.diagram.edit.parts.BordersEditPartFactory;
import borders.diagram.edit.parts.DiagramEditPart;
import borders.diagram.part.BordersVisualIDRegistry;

/**
 * @generated
 */
public class BordersEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public BordersEditPartProvider() {
		super(new BordersEditPartFactory(), BordersVisualIDRegistry.TYPED_INSTANCE, DiagramEditPart.MODEL_ID);
	}

}
