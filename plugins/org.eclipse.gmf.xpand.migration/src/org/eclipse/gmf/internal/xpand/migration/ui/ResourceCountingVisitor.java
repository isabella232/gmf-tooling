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

public class ResourceCountingVisitor extends AbstractMigrationVisitor {

	// Steps necessary for creation native extensions source folder
	private int numberOfFiles = 2;

	public int getNumberOfFiles() {
		return numberOfFiles;
	}

	@Override
	protected void visitFolder(IFolder resource) {
		numberOfFiles++;
	}

	@Override
	protected void visitXpandResource(IFile resource) {
		numberOfFiles++;
	}

	@Override
	protected void visitXtendResource(IFile resource) {
		// each xtend resource will be migrated in two steps
		numberOfFiles += 2;
	}

}
