package org.eclipse.gmf.tooling.examples.svg.diagram.providers;

import org.eclipse.gmf.tooling.examples.svg.diagram.part.SvgDiagramEditorPlugin;

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
		ElementInitializers cached = SvgDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			SvgDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
