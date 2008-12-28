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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.ExpressionFacade;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.gmf.tests.expression.ast.ATypeModel;

/**
 * XXX null.last(), null.first() and similar seem to work regardless of the fact there's no
 * support for this ops in {@link BuiltinMetaModel} - as a matter of very end of {@link OperationCall#evaluateInternal(org.eclipse.gmf.internal.xpand.expression.ExecutionContext)}
 * where targetObj is null
 *
 */
public class CollectionTypeTest extends TestCase {
	
	private final static String REFERECE_NAME = "refC";
	
	private final static String REFERECE_CONTAINER_NAME = "containerA";

    private ExpressionFacade ef;

    @Override
    protected void setUp() throws Exception {
        ef = new ExpressionFacade(new ExecutionContextImpl(null));
    }

    public final void testStuff() {
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

    public final void testWithoutKeepsOrder() {
        final Set result = (Set) ef.evaluate("{1,2,3}.without({2})");
        assertEquals(2, result.size());// 1,3
        Iterator it = result.iterator();
        assertEquals(new Integer(1), it.next());
        assertEquals(new Integer(3), it.next());

        final Set result2 = (Set) ef.evaluate("{1,2,3,1}.without({2})");
        assertEquals(2, result2.size());// 1,3
        it = result2.iterator();
        assertEquals(new Integer(1), it.next());
        assertEquals(new Integer(3), it.next());
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

    public final void testWithoutFirstLastAreImmutable() {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        List<Integer> masterCopy = new ArrayList<Integer>(l);
        assertEquals("Immutable withoutFirst", masterCopy, ef.evaluate("x.withoutFirst()->x", Collections.singletonMap("x", l)));
        assertEquals("Immutable withoutLast", masterCopy, ef.evaluate("x.withoutLast()->x", Collections.singletonMap("x", l)));
    }

    public final void testPurgeDups() {
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("a");
        List<String> masterCopy = new ArrayList<String>(l);
        List<String> noDupsList = new ArrayList<String>(l);
        noDupsList.remove(2);
        assertEquals("Immutable purgeDups", masterCopy, ef.evaluate("x.purgeDups()->x", Collections.singletonMap("x", l)));
        assertEquals(new Integer(2), ef.evaluate("x.purgeDups().size()", Collections.singletonMap("x", l)));
        assertEquals(Boolean.TRUE, ef.evaluate("x.purgeDups().get(1) == \"b\"", Collections.singletonMap("x", l)));
        assertEquals("purgeDups should remove duplicates", noDupsList, ef.evaluate("x.purgeDups()", Collections.singletonMap("x", l)));
    }

    public final void testSetType() {
    	analyzeCollectionExpression(false, true, "Set");
    }
    
    public final void testListType() {
    	analyzeCollectionExpression(true, false, "List");
    }
    
    public final void testOrderedSetType() {
    	analyzeCollectionExpression(true, true, "List");
    }
    
    private void analyzeCollectionExpression(boolean isOrdered, boolean isUnique, String requiredCollectionName) {
    	EClass containerEClass = createCollectionReferenceMetainfo(isOrdered, isUnique);
    	ExpressionFacade facade = new ExpressionFacade(new ExecutionContextImpl(null, null, Collections.singleton(new Variable(REFERECE_CONTAINER_NAME, containerEClass)), null));
    	Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
    	String expression = REFERECE_CONTAINER_NAME + "." + REFERECE_NAME;
    	EClassifier analyzationResut = facade.analyze(expression, issues);
    	assertTrue(issues.size() == 0);
    	assertTrue(analyzationResut instanceof EClass);
    	EClass eClass = (EClass) analyzationResut;
    	assertEquals(requiredCollectionName, eClass.eClass().getName());
    }
    
    private EClass createCollectionReferenceMetainfo(boolean isOrdered, boolean isUnique) {
    	ATypeModel typeModel = new ATypeModel();
    	EClass aClass = typeModel.getMetaType();
    	EClass cClass = typeModel.getMetaTypeC();
    	
    	EReference reference = EcoreFactory.eINSTANCE.createEReference();
		reference.setName(REFERECE_NAME);
    	reference.setEType(cClass);
    	reference.setOrdered(isOrdered);
    	reference.setUnique(isUnique);
    	reference.setUpperBound(-1);
    	aClass.getEStructuralFeatures().add(reference);
    	return aClass;
    }

}
