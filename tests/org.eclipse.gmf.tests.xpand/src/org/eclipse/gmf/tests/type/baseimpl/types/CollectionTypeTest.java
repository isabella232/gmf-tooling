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
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;

/**
 * XXX null.last(), null.first() and similar seem to work regardless of the fact there's no
 * support for this ops in {@link BuiltinMetaModel} - as a matter of very end of {@link OperationCall#evaluateInternal(org.eclipse.gmf.internal.xpand.expression.ExecutionContext)}
 * where targetObj is null
 *
 */
public class CollectionTypeTest extends TestCase {

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testStuff() {
        final List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        try {
            ef.evaluate("{Object.newInstance()} + 'b'");
            fail("EvaluationException expected");
        } catch (final EvaluationException e) {
        }
        assertTrue(((Set) ef.evaluate("{'a'}.union({'b'})")).contains("a"));
    }

    public final void testUnion() {
        final Set result = (Set) ef.evaluate("{1,2}.union({2,3})");
        assertEquals(3, result.size());

        final Number l = (Number) ef.evaluate("{1,2}.union({2,3}).size()");
        assertEquals(3, l.intValue());
    }

    public final void testIntersect() {
        final Set result = (Set) ef.evaluate("{1,2,3}.intersect({2,3,4})");
        assertEquals(2, result.size());
    }

    public final void testWithout() {
        final Set result = (Set) ef.evaluate("{1,2,3}.without({2})");
        assertEquals(2, result.size());
        assertFalse(result.contains(2));
    }

    public final void testToSet() {
        final Set result = (Set) ef.evaluate("{1,2,3}.toSet()");
        assertEquals(3, result.size());
        assertTrue(result.contains(2));

        final Set result2 = (Set) ef.evaluate("{1,2,2,3}.toSet()");
        assertEquals(3, result2.size());
        assertTrue(result2.contains(2));
    }

    public final void testSize() {
        assertEquals(Boolean.TRUE, ef.evaluate("{1,2,3}.size() == 3"));
    }

    public final void testIsEmpty() {
        assertEquals(Boolean.FALSE, ef.evaluate("{1,2,3}.isEmpty()"));
        assertEquals(Boolean.TRUE, ef.evaluate("{}.isEmpty()"));
    }

    public final void testContains() {
        assertEquals(Boolean.TRUE, ef.evaluate("{1,2,3}.contains(2)"));
        assertEquals(Boolean.FALSE, ef.evaluate("{1,2,3}.contains('2')"));
        assertEquals(Boolean.FALSE, ef.evaluate("{1,2,3}.contains(42)"));
    }

    public final void testContainsAll() {
        assertEquals(Boolean.TRUE, ef.evaluate("{1,2,3}.containsAll({2})"));
        assertEquals(Boolean.FALSE, ef.evaluate("{1,2,3}.containsAll({'2',2})"));
        assertEquals(Boolean.FALSE, ef.evaluate("{1,2,3}.containsAll({42,1})"));
        assertEquals(Boolean.TRUE, ef.evaluate("{1,2,3}.containsAll({3,2,1})"));
    }
    public final void testFirst() {
        assertEquals(1, ef.evaluate("{1,2,3}.first()"));
        assertEquals(null, ef.evaluate("{}.first()"));
        assertEquals(null, ef.evaluate("null.first()"));
    }
    public final void testLast() {
        assertEquals(3, ef.evaluate("{1,2,3}.last()"));
        assertNull(ef.evaluate("{}.last()"));
        assertNull(ef.evaluate("null.last()"));
    }
    
    public final void testWithoutFirst() {
        List<Integer> list2and3 = new ArrayList<Integer>();
        list2and3.add(2);
        list2and3.add(3);
        assertEquals(list2and3, ef.evaluate("{1,2,3}.withoutFirst()"));
        assertEquals(Collections.EMPTY_LIST, ef.evaluate("{1}.withoutFirst()"));
        assertEquals(Collections.EMPTY_LIST, ef.evaluate("{}.withoutFirst()"));
        assertEquals(null, ef.evaluate("null.withoutFirst()"));
    }
    
    public final void testWithoutLast() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        assertEquals(l, ef.evaluate("{1,2,3}.withoutLast()"));
        assertEquals(Collections.EMPTY_LIST, ef.evaluate("{1}.withoutLast()"));
        assertEquals(Collections.EMPTY_LIST, ef.evaluate("{}.withoutLast()"));
        assertEquals(null, ef.evaluate("null.withoutLast()"));
    }
    

}
