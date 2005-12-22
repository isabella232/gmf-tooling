package org.eclipse.gmf.ecore.editor;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;

/**
 * @generated
 */
public class EcoreDiagramFileCreator extends IDEEditorFileCreator {

	/**
	 * @generated
	 */
	private static EcoreDiagramFileCreator INSTANCE = new EcoreDiagramFileCreator();

	/**
	 * @generated
	 */
	public static DiagramFileCreator getInstance() {
		return INSTANCE;
	}

	/**
	 * @generated
	 */
	public String getExtension() {
		return ".ecore_diagram"; //$NON-NLS-1$
	}
}
