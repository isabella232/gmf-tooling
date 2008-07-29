/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.expression.ast;

import java.util.Formatter;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionLexer;
import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionParser;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;

public abstract class AbstractExpressionTest extends TestCase {

    protected final Expression parse(final String expression) {
        final ExpressionLexer scanner = new ExpressionLexer(expression.toCharArray(), "none");
        final ExpressionParser parser = new ExpressionParser(scanner);
        scanner.lexer(parser);
        try {
            Expression rv = parser.parser();
            for (ErrorLocationInfo l : scanner.getErrors()) {
            	System.out.println("Scanner:" + locationInfo(l) + l.message);
            }
            for (ErrorLocationInfo l : parser.getErrors()) {
            	System.out.println("Parser:" + locationInfo(l) + l.message);
            }
            return rv;
        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String locationInfo(ErrorLocationInfo l) {
    	return new Formatter(new StringBuilder()).format("%d:%d:%d:%d:", l.startLine, l.startColumn, l.endLine, l.endColumn).out().toString();
    }
}
