package org.eclipse.gmf.internal.codegen.wizards.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewMappingFileCreationPage extends WizardNewFileCreationPage {
	private final IFile[] resultContainer = new IFile[1];

	public NewMappingFileCreationPage(IStructuredSelection selection) {
		super("newMappingFileCreationPage", selection);
		setFileName("Theirs.gmfmap");
	}

	protected boolean validatePage() {
		if (super.validatePage()) {
			IPath p = getContainerFullPath().append(getFileName());
			resultContainer[0] = ResourcesPlugin.getWorkspace().getRoot().getFile(p);
			return true;
		}
		return false;
	}
	
	public IFile[] getResultContainer() {
		return resultContainer;
	}
}
