/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;

/**
 * @generated
 */
public class TaiPanCreationWizard extends BasicNewResourceWizard {

	/**
	 * @generated
	 */
	protected TaiPanCreationWizardPage page;

	/**
	 * @generated
	 */
	protected IFile diagramFile;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New TaiPan Diagram");
		setDefaultPageImageDescriptor(TaiPanDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewTaiPanWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		page = new TaiPanCreationWizardPage("CreationWizardPage", getSelection()); //$NON-NLS-1$
		page.setTitle("Create TaiPan Diagram");
		page.setDescription("Create a new TaiPan diagram.");
		addPage(page);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagramFile = TaiPanDiagramEditorUtil.createAndOpenDiagram(page.getDiagramFileCreator(), page.getContainerFullPath(), page.getFileName(), page.getInitialContents(),
						AquatoryEditPart.MODEL_ID, getWorkbench().getActiveWorkbenchWindow(), monitor, isOpenNewlyCreatedDiagramEditor(), true);
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(), "Creation Problems", null, ((CoreException) e.getTargetException()).getStatus());
			} else {
				TaiPanDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException());
			}
			return false;
		}
		return diagramFile != null;
	}

	/**
	 * @generated
	 */
	public final IFile getDiagramFile() {
		return diagramFile;
	}
}
