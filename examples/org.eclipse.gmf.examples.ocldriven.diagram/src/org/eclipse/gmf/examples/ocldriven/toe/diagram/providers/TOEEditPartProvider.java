package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.AllHolderEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.TOEEditPartFactory;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class TOEEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public TOEEditPartProvider() {
		super(new TOEEditPartFactory(), TOEVisualIDRegistry.TYPED_INSTANCE, AllHolderEditPart.MODEL_ID);
	}

}
