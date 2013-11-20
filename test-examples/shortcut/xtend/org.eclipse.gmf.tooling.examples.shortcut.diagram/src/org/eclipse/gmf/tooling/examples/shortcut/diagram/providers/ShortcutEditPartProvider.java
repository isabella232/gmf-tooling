package org.eclipse.gmf.tooling.examples.shortcut.diagram.providers;

import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.DiagramEditPart;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts.ShortcutEditPartFactory;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class ShortcutEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public ShortcutEditPartProvider() {
		super(new ShortcutEditPartFactory(), ShortcutVisualIDRegistry.TYPED_INSTANCE, DiagramEditPart.MODEL_ID);
	}

}
