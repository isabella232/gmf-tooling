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
package org.eclipse.gmf.tests.expression.ast;

import junit.framework.TestCase;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.gmf.internal.xpand.expression.parser.ExpressionLexer;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ScannerTest extends TestCase {

    public PrsStream scan(final String txt) {
    	ExpressionLexer scanner = new ExpressionLexer(txt.toCharArray(), "nofile");;
    	scanner.lexer(new PrsStream(scanner));
    	return scanner.getPrsStream();
    }

    public final void testString() {
        doTest("\"test\"");
//        test("\"te\nst\"");
        doTest("\"te\\nst\"");
        doTest("'test'");
  //      test("'te\nst'");
        doTest("'te\\nst'");
        assertEquals("Token with kind == bad should be detected on unterminated string quoted with '", 0, scan("'unterminated").getTokenAt(1).getKind());
        assertEquals("Token with kind == bad should be detected on unterminated string quoted with \"", 0, scan("\"test").getTokenAt(1).getKind());
    }

    private void doTest(final String txt) {
    	PrsStream scan = scan(txt);
    	// there are start and eof tokens
        assertEquals(txt, scan.getTokenText(1));
    }
}
