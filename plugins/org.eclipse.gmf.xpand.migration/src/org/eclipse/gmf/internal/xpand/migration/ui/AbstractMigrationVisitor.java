/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.migration.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.internal.xpand.migration.Activator;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;

public abstract class AbstractMigrationVisitor implements IResourceVisitor {

	private IProgressMonitor progressMonitor;

	public AbstractMigrationVisitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
	}

	protected static CoreException createCoreException(Throwable th) {
		return new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Exception during migration", th));
	}

	public boolean visit(IResource resource) throws CoreException {
		if (progressMonitor.isCanceled()) {
			throw createCoreException(new InterruptedException());
		}
		if (resource.getType() == IResource.PROJECT) {
			return true;
		}
		if (resource instanceof IFolder) {
			visitFolder((IFolder) resource);
			return true;
		}
		if (resource instanceof IFile) {
			String extension = resource.getProjectRelativePath().getFileExtension();
			if (XpandResource.TEMPLATE_EXTENSION.equals(extension)) {
				visitXpandResource((IFile) resource);
			} else if (XtendResource.FILE_EXTENSION.equals(extension)) {
				visitXtendResource((IFile) resource);
			}
		}
		return false;
	}

	protected IProgressMonitor getProgressMonitor() {
		return progressMonitor;
	}

	protected abstract void visitXtendResource(IFile resource) throws CoreException;

	protected abstract void visitXpandResource(IFile resource) throws CoreException;

	protected abstract void visitFolder(IFolder resource) throws CoreException;
}
