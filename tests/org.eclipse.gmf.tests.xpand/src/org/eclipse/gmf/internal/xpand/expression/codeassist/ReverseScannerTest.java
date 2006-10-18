/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionParsersym;

public class ReverseScannerTest extends TestCase {
    public final void testPreviousToken() {
        final ReverseScanner s = new ReverseScanner("test");
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testPreviousToken1() {
        final ReverseScanner s = new ReverseScanner("test test");
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    // TODO test fails
    // public final void testPreviousToken2() throws TokenStreamException {
    // ReverseScanner s = new ReverseScanner("test 4.3");
    // assertEquals(ExpressionParsersym.TK_REAL,
    // s.previousToken().getKind());
    // assertEquals(ExpressionParsersym.TK_IDENT,
    // s.previousToken().getKind());
    // assertNull(s.previousToken());
    // }

    public final void testPreviousToken3() {
        final ReverseScanner s = new ReverseScanner("test");
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testPreviousToken4() {
        final ReverseScanner s = new ReverseScanner("test.typeSelect(Stuff,'test bla stuff').size() / 5 * {x,x}.size()");
        assertEquals(ExpressionParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_RCURLY, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_COMMA, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_LCURLY, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_MULTI, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_INT_CONST, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_DIV, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_STRING, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_COMMA, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_typeSelect, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testNextToken() {
        final ReverseScanner s = new ReverseScanner("test 3 4");
        assertEquals(ExpressionParsersym.TK_INT_CONST, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_INT_CONST, s.previousToken().getKind());
        assertEquals(ExpressionParsersym.TK_IDENT, s.previousToken().getKind());
        assertNull(s.previousToken());
        assertEquals(ExpressionParsersym.TK_IDENT, s.nextToken().getKind());
        assertEquals(ExpressionParsersym.TK_INT_CONST, s.nextToken().getKind());
        assertEquals(ExpressionParsersym.TK_INT_CONST, s.nextToken().getKind());
        assertNull(s.nextToken());

    }

    public final void testGetString() {
        final ReverseScanner s = new ReverseScanner("");

        assertEquals("'test'", s.getString("'test'"));
        assertEquals("\"test\"", s.getString("\"test\""));
        assertEquals("'test'", s.getString("'test'  "));
        assertEquals("'test'", s.getString("  'test'"));
        assertEquals("'te\\'\"st'", s.getString("hallo 'te\\'\"st'"));

    }
}
