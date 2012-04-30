package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEDiagramEditorPlugin;

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
		ElementInitializers cached = TOEDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			TOEDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
