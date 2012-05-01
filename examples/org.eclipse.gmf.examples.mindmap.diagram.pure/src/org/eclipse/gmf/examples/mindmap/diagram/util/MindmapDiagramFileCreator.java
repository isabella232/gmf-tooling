package org.eclipse.gmf.examples.mindmap.diagram.util;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;

public class MindmapDiagramFileCreator extends IDEEditorFileCreator {

	private static MindmapDiagramFileCreator INSTANCE = new MindmapDiagramFileCreator();

	static public MindmapDiagramFileCreator getInstance() {
		return INSTANCE;
	}

	@Override
	public String getExtension() {
		return ".mmd"; //$NON-NLS-1$
	}

}
