package org.eclipse.gmf.examples.mindmap.diagram.editor;

import org.eclipse.gmf.examples.mindmap.diagram.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;

public class MindmapDiagramEditor extends DiagramDocumentEditor {

	public MindmapDiagramEditor() {
		super(true);
	}

	public static final String ID = "org.eclipse.amalgam.examples.mindmap.diagram.editor.MindmapDiagramEditorID"; //$NON-NLS-1$
//	private static final String EDITING_DOMAIN_ID = "org.eclipse.amalgam.examples.mindmap.diagram.mindmapEditingDomain"; //$NON-NLS-1$

	@Override
	public String getContributorId() {
		return MindmapDiagramEditorPlugin.ID;
	}

//	@Override
//	protected String getEditingDomainID() {
//		return EDITING_DOMAIN_ID;
//	}

}
