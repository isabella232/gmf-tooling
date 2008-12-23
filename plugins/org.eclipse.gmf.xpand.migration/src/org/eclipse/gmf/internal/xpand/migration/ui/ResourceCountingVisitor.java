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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class ResourceCountingVisitor extends AbstractMigrationVisitor {

	// Steps necessary for creation native extensions source folder
	private int numberOfFiles = 2;

	public ResourceCountingVisitor(IProgressMonitor progressMonitor) {
		super(progressMonitor);
	}

	public int getNumberOfFiles() {
		return numberOfFiles;
	}

	@Override
	protected void visitFolder(IFolder resource) throws CoreException {
		numberOfFiles++;
	}

	@Override
	protected void visitXpandResource(IFile resource) throws CoreException {
		numberOfFiles++;
	}
	
	@Override
	protected void visitOtherResource(IFile resource) throws CoreException {
		numberOfFiles++;
	}

	@Override
	protected void visitXtendResource(IFile resource) throws CoreException {
		// each xtend resource will be migrated in two steps
		numberOfFiles += 2;
	}

}
