package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class EclipseconCreationWizard extends EditorCreationWizard {

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new EclipseconCreationWizardPage(getWorkbench(),
					getSelection());
		}
		addPage(page);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Eclipsecon Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin
				.getBundledImageDescriptor("icons/full/wizban/NewEclipsecon.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
}
