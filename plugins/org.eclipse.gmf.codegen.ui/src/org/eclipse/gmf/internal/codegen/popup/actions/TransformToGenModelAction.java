/*
 * Copyright (c) 2005,2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * .gmfmap to .gmfgen
 * 
 * @author artem
 */
public class TransformToGenModelAction implements IObjectActionDelegate {

	private IWorkbenchPart myPart;

	private IFile mapFile;

	private IFile genFile;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		mapFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
	}

	public void run(IAction action) {
		initDestinationFile();
		if (genFile == null) {
			return;
		}
		TransformToGenModelOperation op = new TransformToGenModelOperation();
		op.setName(action.getText());
		op.setShell(getShell());
		op.setMapModelURI(URI.createPlatformResourceURI(mapFile.getFullPath().toString()));
		op.setGenModelURI(URI.createPlatformResourceURI(genFile.getFullPath().toString()));
		//Temporary fix for https://bugs.eclipse.org/bugs/show_bug.cgi?id=163358
		if (Platform.getBundle("org.eclipse.gmf.codegen.lite") == null) {
			op.setUseRuntimeFigures(Boolean.TRUE);
			op.setUseMapMode(Boolean.TRUE);
		}
		op.run();
	}

	private void initDestinationFile() {
		genFile = null;
		final IPath destPath = mapFile.getFullPath().removeFileExtension().addFileExtension("gmfgen"); //$NON-NLS-1$
		final IPath destLocation = destPath.removeLastSegments(1);
		final String defFileName = destPath.lastSegment();
		InputDialog dlg = new InputDialog(getShell(), "Target model file", "Please specify name of the file to save diagram genmodel to", defFileName, new IInputValidator() {

			public String isValid(String newText) {
				IStatus s = ResourcesPlugin.getWorkspace().validatePath(destLocation.append(newText).toOSString(), IResource.FILE);
				return s.isOK() ? null : s.getMessage();
			}
		});
		if (dlg.open() != InputDialog.OK) {
			return;
		}
		genFile = ResourcesPlugin.getWorkspace().getRoot().getFile(destLocation.append(dlg.getValue()));
	}

	public IFile getGenModelFile() {
		return genFile;
	}

	private Shell getShell() {
		return myPart.getSite().getShell();
	}
}
