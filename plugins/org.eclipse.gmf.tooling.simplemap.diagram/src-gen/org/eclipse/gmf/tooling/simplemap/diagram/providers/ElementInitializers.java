package org.eclipse.gmf.tooling.simplemap.diagram.providers;

import org.eclipse.gmf.tooling.simplemap.diagram.part.SimplemapDiagramEditorPlugin;

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
		ElementInitializers cached = SimplemapDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			SimplemapDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
