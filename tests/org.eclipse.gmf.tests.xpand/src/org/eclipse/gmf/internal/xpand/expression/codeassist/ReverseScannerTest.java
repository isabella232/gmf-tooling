/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import org.eclipse.gmf.internal.xpand.parser.XpandParsersym;

import junit.framework.TestCase;

public class ReverseScannerTest extends TestCase {
    public final void testPreviousToken() {
        final ReverseScanner s = new ReverseScanner("test");
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testPreviousToken1() {
        final ReverseScanner s = new ReverseScanner("test test");
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    // TODO test fails
    // public final void testPreviousToken2() throws TokenStreamException {
    // ReverseScanner s = new ReverseScanner("test 4.3");
    // assertEquals(XpandParsersym.TK_REAL,
    // s.previousToken().getKind());
    // assertEquals(XpandParsersym.TK_IDENT,
    // s.previousToken().getKind());
    // assertNull(s.previousToken());
    // }

    public final void testPreviousToken3() {
        final ReverseScanner s = new ReverseScanner("test");
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testPreviousToken4() {
        final ReverseScanner s = new ReverseScanner("test.typeSelect(Stuff,'test bla stuff').size() / 5 * {x,x}.size()");
        assertEquals(XpandParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_RBRACE, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_COMMA, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_LBRACE, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_MULTIPLY, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_INTEGER_LITERAL, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_DIVIDE, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_RPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_STRING_LITERAL, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_COMMA, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_LPAREN, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_DOT, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertNull(s.previousToken());
    }

    public final void testNextToken() {
        final ReverseScanner s = new ReverseScanner("test 3 4");
        assertEquals(XpandParsersym.TK_INTEGER_LITERAL, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_INTEGER_LITERAL, s.previousToken().getKind());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.previousToken().getKind());
        assertNull(s.previousToken());
        assertEquals(XpandParsersym.TK_IDENTIFIER, s.nextToken().getKind());
        assertEquals(XpandParsersym.TK_INTEGER_LITERAL, s.nextToken().getKind());
        assertEquals(XpandParsersym.TK_INTEGER_LITERAL, s.nextToken().getKind());
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
