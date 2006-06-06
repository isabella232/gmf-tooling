package org.eclipse.gmf.examples.mindmap.diagram.part;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class MindmapCreationWizard extends EditorCreationWizard {

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new MindmapCreationWizardPage(getWorkbench(), getSelection());
		}
		addPage(page);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Mindmap Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(MindmapDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewMindmapWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
}
