package org.eclipse.gmf.tooling.examples.linklf.diagram.providers;

import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.CanvasEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LinklfEditPartFactory;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class LinklfEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public LinklfEditPartProvider() {
		super(new LinklfEditPartFactory(), LinklfVisualIDRegistry.TYPED_INSTANCE, CanvasEditPart.MODEL_ID);
	}

}
