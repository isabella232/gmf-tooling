/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xtend;

import org.eclipse.gmf.internal.xpand.xtend.parser.XtendLexer;
import org.eclipse.gmf.internal.xpand.xtend.parser.XtendParser;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;

import junit.framework.TestCase;

/**
 * @author artem
 */
public abstract class AbstractXtendTest extends TestCase {

	public AbstractXtendTest() {
		super();
	}

	protected ExtensionFile parse(final String expression) {
	    final XtendLexer scanner = new XtendLexer(expression.toCharArray(), "none");
	    final XtendParser parser = new XtendParser(scanner);
	    scanner.lexer(parser);
	    try {
	        return parser.parser();
	    } catch (final Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}

}