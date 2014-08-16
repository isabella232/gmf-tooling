package org.eclipse.gmf.tooling.examples.linklf.diagram.providers;

import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfDiagramEditorPlugin;

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
		ElementInitializers cached = LinklfDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			LinklfDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
