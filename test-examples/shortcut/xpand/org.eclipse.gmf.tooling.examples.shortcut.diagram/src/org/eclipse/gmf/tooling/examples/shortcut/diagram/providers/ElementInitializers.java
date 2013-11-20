package org.eclipse.gmf.tooling.examples.shortcut.diagram.providers;

import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = ShortcutDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			ShortcutDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
