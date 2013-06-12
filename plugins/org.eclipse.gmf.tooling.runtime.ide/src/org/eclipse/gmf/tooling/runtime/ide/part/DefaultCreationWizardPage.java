/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Svyatoslav Kovalsky (Montages) - #410477 "same-generated" code extracted to GMFT-runtime
 */
package org.eclipse.gmf.tooling.runtime.ide.part;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.tooling.runtime.ide.i18n.Messages;
import org.eclipse.gmf.tooling.runtime.part.DefaultDiagramEditorUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class DefaultCreationWizardPage extends WizardNewFileCreationPage {

	private final String fileExtension;

	public DefaultCreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
	}

	/**
	 * Override to create files with this extension.
	 */
	protected String getExtension() {
		return fileExtension;
	}

	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		setFileName(computeUniqueFileName(getContainerFullPath(), getFileName(), getExtension()));
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(getWrongExtensionErrorMessage(extension));
			return false;
		}
		return true;
	}

	/**
	 * By default relies on implementation in {@link DefaultDiagramEditorUtil}.
	 * Subclass may override inplace or by delegating to generated (and possibly modified) XXXDiagramEditorUtil 
	 */
	protected String computeUniqueFileName(IPath containerFullPath, String fileName, String extension) {
		return DefaultDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), getFileName(), getExtension());
	}

	/**
	 * Subclass may override, especially to use custom message replaced the one generated prior to 3.1 
	 */
	protected String getWrongExtensionErrorMessage(String actualExtension) {
		return NLS.bind(Messages.DefaultCreationWizardPageExtensionError, actualExtension);
	}
}
