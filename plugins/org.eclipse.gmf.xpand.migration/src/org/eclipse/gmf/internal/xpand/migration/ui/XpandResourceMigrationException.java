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
import org.eclipse.gmf.internal.xpand.migration.MigrationException;

public class XpandResourceMigrationException extends Exception {

	private static final long serialVersionUID = 6611875129898090099L;

	private MigrationException migrationException;

	private IFile templateFile;

	public XpandResourceMigrationException(MigrationException ex, IFile templateFile) {
		migrationException = ex;
		this.templateFile = templateFile;
	}

	public MigrationException getMigrationException() {
		return migrationException;
	}

	public IFile getTemplateFile() {
		return templateFile;
	}

}
