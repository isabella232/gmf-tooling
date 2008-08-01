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
package org.eclipse.gmf.tests.xpand.migration;

import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;


public class ImportResolver implements IImportResolver {

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver#getPackageName(org.eclipse.m2m.internal.qvt.oml.compiler.CFolder)
	 */
	public String getPackageName(CFolder folder) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver#resolveImport(java.lang.String)
	 */
	public CFile resolveImport(String importedUnitName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver#resolveImport(org.eclipse.m2m.internal.qvt.oml.compiler.CFile, java.lang.String)
	 */
	public CFile resolveImport(CFile parentFile, String importedUnitName) {
		// TODO Auto-generated method stub
		return null;
	}

}
