/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand;

import org.eclipse.gmf.internal.xpand.parser.XpandLexer;
import org.eclipse.gmf.internal.xpand.parser.XpandParser;
import org.eclipse.gmf.internal.xpand.ast.Template;

import junit.framework.TestCase;

public abstract class AbstractXpandTest extends TestCase {

	private final char LG = '\u00AB';
	private final char RG = '\u00BB';

	protected Template parse(final String expr) throws Exception {
	    System.out.println("Parsing:" + expr);
	    final XpandLexer scanner = new XpandLexer(expr.toCharArray(), "nofile");
	    final XpandParser parser = new XpandParser(scanner);
	    scanner.lexer(parser);
	    return parser.parser();
	}

	public AbstractXpandTest() {
		super();
	}

	protected String tag(final String str) {
	    return LG + str + RG;
	}

}