package org.eclipse.gmf.ecore.editor;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class EcoreCreationWizard extends EditorCreationWizard {

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new EcoreCreationWizardPage(getWorkbench(), getSelection());
		}
		addPage(page);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Ecore Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(org.eclipse.gmf.ecore.editor.EcoreDiagramEditorPlugin.getBundledImageDescriptor("icons/full/wizban/NewEcore.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
}
