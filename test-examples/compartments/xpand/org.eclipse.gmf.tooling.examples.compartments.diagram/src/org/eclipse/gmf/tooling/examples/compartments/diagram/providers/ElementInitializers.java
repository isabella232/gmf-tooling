package org.eclipse.gmf.tooling.examples.compartments.diagram.providers;

import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsDiagramEditorPlugin;

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
		ElementInitializers cached = CompartmentsDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			CompartmentsDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
