package org.eclipse.gmf.graphdef.gmfEditor.part;

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

import org.eclipse.gmf.graphdef.gmfEditor.edit.parts.CanvasEditPart;

/**
 * @generated
 */
public class GMFGraphCreationWizardPage extends EditorWizardPage {

	/**
	 * @generated
	 */
	public GMFGraphCreationWizardPage(IWorkbench workbench, IStructuredSelection selection) {
		super("CreationWizardPage", workbench, selection); //$NON-NLS-1$
		setTitle("Create GMFGraph Diagram"); //$NON-NLS-1$
		setDescription("Create a new GMFGraph diagram."); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IFile createAndOpenDiagram(IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean saveDiagram) {
		return GMFGraphDiagramEditorUtil.createAndOpenDiagram(getDiagramFileCreator(), containerPath, fileName, initialContents, kind, dWindow, progressMonitor, isOpenNewlyCreatedDiagramEditor(),
				saveDiagram);
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
		return GMFGraphDiagramFileCreator.getInstance();
	}

	/**
	 * @generated
	 */
	protected String getDiagramKind() {
		return CanvasEditPart.MODEL_ID;
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
			IPath path = getContainerFullPath().append(getDiagramFileCreator().appendExtensionToFileName(fileName));
			path = path.removeFileExtension().addFileExtension("gmfgraph"); //$NON-NLS-1$
			if (ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
				setErrorMessage("Model File already exists: " + path.lastSegment());
				return false;
			}
			return true;
		}
		return false;
	}

}
