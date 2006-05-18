/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.common.codegen;

import org.eclipse.gmf.common.codegen.ImportAssistant;

/**
 * @author artem
 */
public class DelegateImportManager implements ImportAssistant {
	private ImportAssistant myDelegate;

	public DelegateImportManager() {
	}

	public DelegateImportManager(ImportAssistant delegate) {
		assert delegate != null;
		setDelegate(delegate);
	}

	public void setDelegate(ImportAssistant delegate) {
		myDelegate = delegate;
	}

	protected final ImportAssistant getDelegate() {
		return myDelegate;
	}

	public void addImport(String qualifiedName) {
		if (myDelegate != null) {
			myDelegate.addImport(qualifiedName);
		}
	}

	public void emitPackageStatement(StringBuffer stringBuffer) {
		if (myDelegate != null) {
			myDelegate.emitPackageStatement(stringBuffer);
		}
	}

	public void emitSortedImports() {
		if (myDelegate != null) {
			myDelegate.emitSortedImports();
		}
	}

	public String getCompilationUnitName() {
		if (myDelegate != null) {
			return myDelegate.getCompilationUnitName();
		}
		throw new IllegalStateException();
	}

	public String getImportedName(String qualifiedName) {
		if (myDelegate != null) {
			return myDelegate.getImportedName(qualifiedName);
		}
		return qualifiedName;
	}

	public void markImportLocation(StringBuffer stringBuffer) {
		if (myDelegate != null) {
			myDelegate.markImportLocation(stringBuffer);
		}
	}

	public void registerInnerClass(String innerClassName) {
		if (myDelegate != null) {
			myDelegate.registerInnerClass(innerClassName);
		}
	}
}
