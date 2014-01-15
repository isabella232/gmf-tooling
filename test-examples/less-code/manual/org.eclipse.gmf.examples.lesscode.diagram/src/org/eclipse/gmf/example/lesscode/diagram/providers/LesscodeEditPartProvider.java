package org.eclipse.gmf.example.lesscode.diagram.providers;

import org.eclipse.gmf.example.lesscode.diagram.edit.parts.LesscodeEditPartFactory;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class LesscodeEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public LesscodeEditPartProvider() {
		super(new LesscodeEditPartFactory(), LesscodeVisualIDRegistry.TYPED_INSTANCE, RootContainerEditPart.MODEL_ID);
	}
}
