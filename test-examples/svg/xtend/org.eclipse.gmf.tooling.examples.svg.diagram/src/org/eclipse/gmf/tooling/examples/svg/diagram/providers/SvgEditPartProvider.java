package org.eclipse.gmf.tooling.examples.svg.diagram.providers;

import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.PlaygroundEditPart;
import org.eclipse.gmf.tooling.examples.svg.diagram.edit.parts.SvgEditPartFactory;
import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class SvgEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public SvgEditPartProvider() {
		super(new SvgEditPartFactory(), SvgVisualIDRegistry.TYPED_INSTANCE, PlaygroundEditPart.MODEL_ID);
	}

}
