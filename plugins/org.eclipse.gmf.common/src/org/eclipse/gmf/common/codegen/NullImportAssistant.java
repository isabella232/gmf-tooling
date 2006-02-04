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
package org.eclipse.gmf.common.codegen;

/**
 * NO-OP implementation of import assistant. Just keeps all qualified names fully-qualified.
 * @author artem
 */
public class NullImportAssistant implements ImportAssistant {

	/*
	 * NO-OP
	 */
	public void markImportLocation(StringBuffer stringBuffer) {
	}

	/*
	 * NO-OP
	 */
	public void emitSortedImports() {
	}

	/**
	 * Simply returns argument
	 * @return unmodified argument
	 */
	public String getImportedName(String qualifiedName) {
		return qualifiedName;
	}

	/*
	 * NO-OP
	 */
	public void addImport(String qualifiedName) {
	}

}
