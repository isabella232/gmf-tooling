package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

import org.eclipse.core.resources.ResourcesPlugin;

/**
 * @generated
 */
public class EclipseconCreationWizardPage extends EditorWizardPage {

	/**
	 * @generated
	 */
	public EclipseconCreationWizardPage(IWorkbench workbench,
			IStructuredSelection selection) {
		super("CreationWizardPage", workbench, selection); //$NON-NLS-1$
		setTitle("Create Eclipsecon Diagram"); //$NON-NLS-1$
		setDescription("Create a new Eclipsecon diagram."); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IFile createAndOpenDiagram(IPath containerPath, String fileName,
			InputStream initialContents, String kind, IWorkbenchWindow dWindow,
			IProgressMonitor progressMonitor, boolean saveDiagram) {
		return EclipseconDiagramEditorUtil.createAndOpenDiagram(
				getDiagramFileCreator(), containerPath, fileName,
				initialContents, kind, dWindow, progressMonitor,
				isOpenNewlyCreatedDiagramEditor(), saveDiagram);
	}

	/**
	 * @generated
	 */
	protected String getDefaultFileName() {
		return "default"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public DiagramFileCreator getDiagramFileCreator() {
		return EclipseconDiagramFileCreator.getInstance();
	}

	/**
	 * @generated
	 */
	protected String getDiagramKind() {
		return "Eclipsecon"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		if (super.validatePage()) {
			String fileName = getFileName();
			if (fileName == null) {
				return false;
			}
			// appending file extension to correctly process file names including "." symbol
			IPath path = getContainerFullPath()
					.append(
							getDiagramFileCreator().appendExtensionToFileName(
									fileName));
			path = path.removeFileExtension().addFileExtension("eclipsecon"); //$NON-NLS-1$
			if (ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
				setErrorMessage("Model File already exists: "
						+ path.lastSegment());
				return false;
			}
			return true;
		}
		return false;
	}

}
