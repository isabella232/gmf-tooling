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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class CollectionFeaturesTest extends TestCase {
    ExecutionContextImpl ec;

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
        ec = new ExecutionContextImpl(null);
        ef = new ExpressionFacade(ec);
    }

    public final void testSelect() {
        final Collection result = (Collection) ef.evaluate("vals.select(s| s.compareTo(\"3\") >= 0)", Collections.singletonMap("vals", vals));
        assertEquals(3, result.size());
        assertTrue(result.contains("3"));
        assertTrue(result.contains("4"));
        assertTrue(result.contains("5"));
    }

    public final void testCollect() {
        final Collection result = (Collection) ef.evaluate("vals.collect( s| s.length())", Collections.singletonMap("vals", vals));
        assertEquals(5, result.size());
        for (final Iterator iter = result.iterator(); iter.hasNext();) {
            assertEquals(1, iter.next());
        }
    }

    public final void testExists() {
        assertEquals(Boolean.TRUE, ef.evaluate("vals.exists(s| s == \"3\")", Collections.singletonMap("vals", vals)));
        assertEquals(Boolean.FALSE, ef.evaluate("vals.exists(s| s == \"33\")", Collections.singletonMap("vals", vals)));
    }

    public final void testForAll() {
        assertEquals(Boolean.TRUE, ef.evaluate("vals.forAll(s| s.length() == 1)", Collections.singletonMap("vals", vals)));
        assertEquals(Boolean.FALSE, ef.evaluate("vals.forAll(s| s == \"3\")", Collections.singletonMap("vals", vals)));
    }

}
