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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;

import junit.framework.TestCase;

public class IntegerTypeTest extends TestCase {

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testUpTo1() {
        final Map<String, ?> emptyMap = Collections.emptyMap();
		final List r = (List) ef.evaluate("1.upTo(5)", emptyMap);
        final List<Integer> c = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            c.add(i);
        }
        assertEquals(c, r);
    }

    public void testComparisonOps() {
    	final Map<String, ?> emptyMap = Collections.emptyMap();
    	assertTrue((Boolean) ef.evaluate("1 > 0", emptyMap));
    	assertTrue((Boolean) ef.evaluate("2 >= 2", emptyMap));
    	assertTrue((Boolean) ef.evaluate("1 < 4", emptyMap));
    	assertTrue((Boolean) ef.evaluate("1 <= 3", emptyMap));
    	assertTrue((Boolean) ef.evaluate("1 != 2", emptyMap));
    	assertTrue((Boolean) ef.evaluate("2 == 2", emptyMap));

    	assertFalse((Boolean) ef.evaluate("1 < 0", emptyMap));
    	assertFalse((Boolean) ef.evaluate("1 >= 2", emptyMap));
    	assertFalse((Boolean) ef.evaluate("1 > 4", emptyMap));
    	assertFalse((Boolean) ef.evaluate("3 <= 1", emptyMap));
    	assertFalse((Boolean) ef.evaluate("2 != 2", emptyMap));
    	assertFalse((Boolean) ef.evaluate("1 == 0", emptyMap));

    }

    public void testCompareNonLiterals() {
    	final Map<String, ?> emptyMap = Collections.emptyMap();
    	assertTrue((Boolean) ef.evaluate("\"sdf \".trim().length() > 0", emptyMap));
    	assertTrue((Boolean) ef.evaluate("\"sdf \".trim().length() == 3", emptyMap));

    	assertTrue((Boolean) ef.evaluate("a.trim().length() == 3", Collections.singletonMap("a", "sdf ")));
    	assertTrue((Boolean) ef.evaluate("\" sdf\".trim().length() == b", Collections.singletonMap("b", 3)));
    }
}
