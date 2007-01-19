package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import org.eclipse.emf.common.util.URI;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class MindmapCreationWizard extends Wizard implements INewWizard {
	/**
	 * @generated
	 */
	private URI diagramFileURI;

	/**
	 * @generated
	 */
	private MindmapCreationWizardPage page;

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new MindmapCreationWizardPage();
		}
		addPage(page);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New Mindmap Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(MindmapDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewMindmapWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		boolean retVal = page.finish();
		diagramFileURI = page.getCreatedDiagramFileURI();
		return retVal;
	}

	/**
	 * returns the diagram file 
	 * @return URI the diagram file
	 * @generated
	 */
	public final URI getDiagramFileURI() {
		return diagramFileURI;
	}
}
