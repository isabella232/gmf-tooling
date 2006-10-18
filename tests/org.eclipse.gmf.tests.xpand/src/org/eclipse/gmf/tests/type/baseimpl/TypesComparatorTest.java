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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.TypesComparator;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class TypesComparatorTest extends TestCase {
    ExecutionContextImpl ec;

    EClass aType;
    EClass bType;

    @SuppressWarnings("unchecked")
	@Override
    protected void setUp() throws Exception {
        ec = new ExecutionContextImpl(null);
        aType = EcoreFactory.eINSTANCE.createEClass();
        aType.setName("TypeA");
        bType = EcoreFactory.eINSTANCE.createEClass();
        bType.setName("TypeB");
        bType.getESuperTypes().add(aType);
    }

    public final void testNullParams() {
        final Comparator<List<? extends EClassifier>> c = new TypesComparator();
        try {
            c.compare(null, null);
            fail();
        } catch (final Exception e) {
        }
        try {
            c.compare(null, l(aType));
            fail();
        } catch (final Exception e) {
        }
        try {
            c.compare(l(aType), null);
            fail();
        } catch (final Exception e) {
        }
    }

    public final void testSimple() {
        final Comparator<List<? extends EClassifier>> c = new TypesComparator();

        assertTrue(c.compare(l(aType), l(aType)) == 0);
        assertTrue(c.compare(l(aType), l(bType)) > 0);
        assertTrue(c.compare(l(bType), l(aType)) < 0);
    }

    public final void testComplex() {
        final Comparator<List<? extends EClassifier>> c = new TypesComparator();

        assertTrue(c.compare(l(aType, aType), l(aType, aType)) == 0);

        assertTrue(c.compare(l(aType, aType), l(bType, aType)) > 0);
        assertTrue(c.compare(l(aType, aType), l(aType, bType)) > 0);

        assertTrue(c.compare(l(bType, aType), l(aType, aType)) < 0);
        assertTrue(c.compare(l(aType, bType), l(aType, aType)) < 0);
    }

    private static List<? extends EClassifier> l(final EClassifier a) {
        return Collections.singletonList(a);
    }

    private static List<? extends EClassifier> l(final EClassifier a, final EClassifier b) {
        return Arrays.asList(new EClassifier[] {a, b});
    }

}