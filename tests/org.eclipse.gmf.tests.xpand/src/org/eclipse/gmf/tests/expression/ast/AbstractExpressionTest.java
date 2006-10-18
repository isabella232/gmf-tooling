/*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.gmf.tests.expression.ast;

import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionLexer;
import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionParser;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;

import junit.framework.TestCase;

public abstract class AbstractExpressionTest extends TestCase {

    protected final Expression parse(final String expression) {
        final ExpressionLexer scanner = new ExpressionLexer(expression.toCharArray(), "none");
        final ExpressionParser parser = new ExpressionParser(scanner);
        scanner.lexer(parser);
        try {
            return (Expression) parser.parser();
        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
