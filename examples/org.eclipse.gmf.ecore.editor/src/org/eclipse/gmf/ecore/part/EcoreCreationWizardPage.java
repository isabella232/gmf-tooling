/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.part;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class EcoreCreationWizardPage extends WizardNewFileCreationPage {

	/**
	 * @generated
	 */
	public EcoreCreationWizardPage(String pageName, IStructuredSelection selection) {
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
			fileName = getDiagramFileCreator().appendExtensionToFileName(fileName);
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
	public DiagramFileCreator getDiagramFileCreator() {
		return EcoreDiagramFileCreator.getInstance();
	}

	/**
	 * @generated
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		IPath path = getContainerFullPath();
		if (path != null) {
			String fileName = getDiagramFileCreator().getUniqueFileName(path, getDefaultFileName());
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
			IPath path = getContainerFullPath().append(getDiagramFileCreator().appendExtensionToFileName(fileName));
			path = path.removeFileExtension().addFileExtension("ecore"); //$NON-NLS-1$
			if (ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
				setErrorMessage("Model file already exists: " + path.lastSegment());
				return false;
			}
			return true;
		}
		return false;
	}
}
