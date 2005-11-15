/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.editor;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * @generated
 */
public class CreationWizardPage extends EditorWizardPage {

	/**
	 * @generated
	 */
	public CreationWizardPage(IWorkbench workbench, IStructuredSelection selection) {
		super("CreationWizardPage", workbench, selection); //$NON-NLS-1$
		setTitle("Create TaiPan Diagram"); //$NON-NLS-1$
		setDescription("Create a new TaiPan diagram."); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public IFile createAndOpenDiagram(IPath containerPath, String fileName, InputStream initialContents, String kind,
			IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean saveDiagram) {
		return DiagramEditorUtil.createAndOpenDiagram(getDiagramFileCreator(), containerPath, fileName, initialContents, kind,
				dWindow, progressMonitor, isOpenNewlyCreatedDiagramEditor(), saveDiagram);
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
		return DiagramFileCreatorBis.getInstance();
	}

	/**
	 * @generated
	 */
	protected String getDiagramKind() {
		return "TaiPan"; //$NON-NLS-1$
	}
}
