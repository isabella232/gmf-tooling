package org.eclipse.gmf.examples.mindmap.diagram.wizards;

import org.eclipse.gmf.examples.mindmap.diagram.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

public class MindmapDiagramCreationWizard extends EditorCreationWizard {

	@Override
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new MindmapDiagramWizardPage(getWorkbench(), getSelection());
		}
		addPage(page);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection sel) {
		super.init(workbench, sel);
		setWindowTitle(Messages.getString("MindmapDiagramCreationWizard.NewDiagramWizardTitle")); //$NON-NLS-1$
		setDefaultPageImageDescriptor(MindmapDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewMindmapWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

}
