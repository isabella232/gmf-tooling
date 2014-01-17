package org.eclipse.gmf.example.lesscode.diagram.providers;

import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeDiagramEditorPlugin;

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
		ElementInitializers cached = LesscodeDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			LesscodeDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
