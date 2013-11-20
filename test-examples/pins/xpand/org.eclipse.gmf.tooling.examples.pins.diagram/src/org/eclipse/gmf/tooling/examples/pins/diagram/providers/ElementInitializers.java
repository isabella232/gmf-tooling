package org.eclipse.gmf.tooling.examples.pins.diagram.providers;

import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsDiagramEditorPlugin;

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
		ElementInitializers cached = PinsDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			PinsDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
