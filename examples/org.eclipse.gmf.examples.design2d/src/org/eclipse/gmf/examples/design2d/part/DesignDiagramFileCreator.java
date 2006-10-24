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
package org.eclipse.gmf.examples.design2d.part;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @generated
 */
public class DesignDiagramFileCreator {

	/**
	 * @generated
	 */
	public static IFile createNewFile(IPath containerPath, String fileName, Shell shell) {
		IPath newFilePath = containerPath.append(fileName);
		IFile newFileHandle = ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
		try {
			createFile(newFileHandle);
		} catch (CoreException e) {
			ErrorDialog.openError(shell, "Creation Problems", null, e.getStatus());
			return null;
		}
		return newFileHandle;
	}

	/**
	 * @generated
	 */
	protected static void createFile(IFile fileHandle) throws CoreException {
		try {
			fileHandle.create(new ByteArrayInputStream(new byte[0]), false, new NullProgressMonitor());
		} catch (CoreException e) {
			// If the file already existed locally, just refresh to get contents
			if (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED) {
				fileHandle.refreshLocal(IResource.DEPTH_ZERO, null);
			} else {
				throw e;
			}
		}
	}
}