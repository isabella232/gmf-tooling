package org.eclipse.gmf.ecore.editor;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;
import org.eclipse.ui.IEditorInput;

/**
 * @generated
 */
public class EcoreDiagramEditor extends FileDiagramEditorWithFlyoutPalette {

	/**
	 * @generated
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		existingPaletteRoot = super.createPaletteRoot(existingPaletteRoot);
		EcorePaletteFactory.fillPalette(existingPaletteRoot, getDiagram());
		return existingPaletteRoot;
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		setDocumentProvider(new EcoreDocumentProvider());
	}
}
