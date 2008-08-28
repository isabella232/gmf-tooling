/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand.ast;

import org.eclipse.gmf.internal.xpand.expression.ast.StringLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;

public class NamespaceImport extends SyntaxElement {
	private final String importString;
	private StringLiteral stringLiteral;

	public NamespaceImport(int start, int end, int line, final int startOffset, final int endOffset, StringLiteral importString) {
		super(start, end, line, startOffset, endOffset);
		this.importString = importString.getValue();
		this.stringLiteral = importString;
	}

	public String getImportString() {
		return importString;
	}
	
	public StringLiteral getStringLiteral() {
		return stringLiteral;
	}

}
