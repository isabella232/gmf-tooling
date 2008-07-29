/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand;

import java.util.Formatter;

import org.eclipse.gmf.internal.xpand.parser.XpandLexer;
import org.eclipse.gmf.internal.xpand.parser.XpandParser;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.tests.expression.ast.AbstractExpressionTest;

import junit.framework.TestCase;

public abstract class AbstractXpandTest extends TestCase {

	private final char LG = '\u00AB';
	private final char RG = '\u00BB';

	protected Template parse(final String expr) throws Exception {
	    System.out.println("Parsing:" + expr);
	    final XpandLexer scanner = new XpandLexer(expr.toCharArray(), "nofile");
	    final XpandParser parser = new XpandParser(scanner);
	    scanner.lexer(parser);
        for (ErrorLocationInfo l : scanner.getErrors()) {
        	System.out.println("Scanner:" + locationInfo(l) + l.message);
        }
	    Template rv = parser.parser();
        for (ErrorLocationInfo l : parser.getErrors()) {
        	System.out.println("Parser:" + locationInfo(l) + l.message);
        }
        return rv;
	}

	protected String tag(final String str) {
	    return LG + str + RG;
	}

	/**
	 * copy from {@link AbstractExpressionTest}
	 */
	private static String locationInfo(ErrorLocationInfo l) {
    	return new Formatter(new StringBuilder()).format("%d:%d:%d:%d:", l.startLine, l.startColumn, l.endLine, l.endColumn).out().toString();
    }
}