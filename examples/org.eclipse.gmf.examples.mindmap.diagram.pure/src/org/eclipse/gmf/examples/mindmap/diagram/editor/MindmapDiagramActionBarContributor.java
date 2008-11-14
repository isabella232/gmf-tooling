package org.eclipse.gmf.examples.mindmap.diagram.editor;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;

public class MindmapDiagramActionBarContributor extends DiagramActionBarContributor {

	@Override
	protected Class<MindmapDiagramEditor> getEditorClass() {
		return MindmapDiagramEditor.class;
	}

	@Override
	protected String getEditorId() {
		return MindmapDiagramEditor.ID;
	}
}
