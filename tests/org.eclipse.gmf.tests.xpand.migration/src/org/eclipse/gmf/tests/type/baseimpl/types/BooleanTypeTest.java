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

public class BooleanTypeTest extends TestCase {

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testNull() {
        assertNull(ef.evaluate("true && null"));
        assertNull(ef.evaluate("null && null"));
        assertNull(ef.evaluate("null && true"));
        assertEquals(Boolean.TRUE, ef.evaluate("true || null"));
        assertEquals(Boolean.FALSE, ef.evaluate("false && null"));
        assertNull(ef.evaluate("null || null"));
        assertNull(ef.evaluate("null || true"));
        assertNull(ef.evaluate("!null"));
    }

    public final void testStuff() {
        assertEquals(Boolean.TRUE, ef.evaluate("!'name'.startsWith('a')"));
        assertEquals(Boolean.FALSE, ef.evaluate("!'aname'.startsWith('a')"));
    }
}
