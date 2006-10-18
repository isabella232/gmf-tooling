/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.tests.type.baseimpl.types;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;

public class ObjectTypeTest extends TestCase {

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testCompareTo() {
        assertEquals(-1, ef.evaluate("'a'.compareTo('b')"));
        assertEquals(0, ef.evaluate("'xyz'.compareTo('xyz')"));
        assertEquals(1, ef.evaluate("'a2'.compareTo('a1')"));
        assertEquals(-1, ef.evaluate("null.compareTo('23')"));
        assertEquals(1, ef.evaluate("'23'.compareTo(null)"));
        assertEquals(0, ef.evaluate("null.compareTo(null)"));
    }

    public final void testToString() {
        assertEquals("3", ef.evaluate("3.toString()"));
        assertEquals("3.0", ef.evaluate("3.0.toString()"));
        assertEquals("true", ef.evaluate("true.toString()"));
        assertEquals("Test", ef.evaluate("'Test'.toString()"));

    }
}
