package org.eclipse.gmf.tooling.examples.affixednode.diagram.providers;

import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeDiagramEditorPlugin;

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
		ElementInitializers cached = AffixednodeDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			AffixednodeDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
