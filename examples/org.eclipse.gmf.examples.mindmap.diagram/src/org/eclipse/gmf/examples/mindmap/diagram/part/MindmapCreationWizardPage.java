package org.eclipse.gmf.examples.mindmap.diagram.part;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class MindmapCreationWizardPage extends WizardNewFileCreationPage {

	/**
	 * @generated
	 */
	public MindmapCreationWizardPage(String pageName,
			IStructuredSelection selection) {
		super(pageName, selection);
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
	public String getFileName() {
		String fileName = super.getFileName();
		if (fileName != null) {
			fileName = getDiagramFileCreator().appendExtensionToFileName(
					fileName);
		}
		return fileName;
	}

	/**
	 * @generated
	 */
	public InputStream getInitialContents() {
		return new ByteArrayInputStream(new byte[0]);
	}

	/**
	 * @generated
	 */
	public MindmapDiagramFileCreator getDiagramFileCreator() {
		return MindmapDiagramFileCreator.getInstance();
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		IPath path = getContainerFullPath();
		if (path != null) {
			String fileName = getDiagramFileCreator().getUniqueFileName(path,
					getDefaultFileName());
			setFileName(fileName);
		}
		setPageComplete(validatePage());
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
			path = path.removeFileExtension().addFileExtension("mindmap"); //$NON-NLS-1$
			if (MindmapDiagramFileCreator.exists(path)) {
				setErrorMessage("Model file already exists: "
						+ path.lastSegment());
				return false;
			}
			return true;
		}
		return false;
	}
}
