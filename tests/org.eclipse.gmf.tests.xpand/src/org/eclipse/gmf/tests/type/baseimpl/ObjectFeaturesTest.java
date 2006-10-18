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
package org.eclipse.gmf.tests.type.baseimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ObjectFeaturesTest extends TestCase {

    private ExpressionFacade ef;

    private ArrayList<String> vals;

    @Override
    protected void setUp() throws Exception {
        vals = new ArrayList<String>();
        vals.add("1");
        vals.add("2");
        vals.add("3");
        vals.add("4");
        vals.add("5");
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testEquals() {
        final Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("var1", "test");
        vars.put("var2", "test");
        vars.put("var3", null);
        assertEquals(Boolean.TRUE, ef.evaluate("var1 == var1", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var1 == var2", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var1 == var3", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var2 == var1", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var2 == var3", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var3 == var3", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var3 == var1", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var3 == var2", vars));
    }

    public final void testNotEquals() {
        final Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("var1", "test");
        vars.put("var2", "test");
        vars.put("var3", null);
        assertEquals(Boolean.FALSE, ef.evaluate("var1 != var1", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var1 != var2", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var3 != var3", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var1 != var3", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var3 != var1", vars));

    }

/*
 * XXX DON'T feel that operations like >, >=, <, <= are essential for objects    
    public final void testGreaterThan() {
        final Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("var1", "test1");
        vars.put("var2", "test2");
        vars.put("var3", null);
        assertEquals(Boolean.FALSE, ef.evaluate("var1 > var1", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var1 > var2", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var1 > var3", vars));
        assertEquals(Boolean.TRUE, ef.evaluate("var2 > var1", vars));
        assertEquals(Boolean.FALSE, ef.evaluate("var3 > var1", vars));
    }
*/
}
