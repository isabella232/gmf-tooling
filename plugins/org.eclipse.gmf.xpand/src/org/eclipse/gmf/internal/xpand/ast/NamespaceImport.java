/*
 * Copyright (c) 2006, 2008 committers of openArchitectureWare and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.internal.xpand.ast;

import org.eclipse.gmf.internal.xpand.expression.ast.SyntaxElement;
import org.eclipse.ocl.cst.StringLiteralExpCS;

// XXX XpandAnalyzable to check if metamodel is accessible
public class NamespaceImport extends SyntaxElement {
	private final String importString;

	public NamespaceImport(int start, int end, int line, StringLiteralExpCS importCS) {
		super(start, end, line);
		// FIXME for complete care, look at AbstractOCLAnalyzer#processStringEscapes
		importString = importCS.getUnescapedStringSymbol();
	}

	public String getImportString() {
		return importString;
	}

}
