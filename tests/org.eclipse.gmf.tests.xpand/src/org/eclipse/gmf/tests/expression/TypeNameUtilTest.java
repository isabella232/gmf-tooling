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
package org.eclipse.gmf.tests.expression;

import org.eclipse.gmf.internal.xpand.expression.TypeNameUtil;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class TypeNameUtilTest extends TestCase {
    public final void testGetTypeName() {

        assertEquals("de::test::Bla", TypeNameUtil.getTypeName("de::test::Bla"));
        assertEquals("de::test::Bla", TypeNameUtil.getTypeName("MM!de::test::Bla"));
        assertEquals("de::test::Bla", TypeNameUtil.getTypeName("List[de::test::Bla]"));
        assertEquals("Bla", TypeNameUtil.getTypeName("List[Test!Bla]"));
        assertEquals("List", TypeNameUtil.getTypeName("List"));
    }

    public final void testGetMetaModelName() {

        assertEquals(null, TypeNameUtil.getMetaModelName("de::test::Bla"));
        assertEquals("MM", TypeNameUtil.getMetaModelName("MM!de::test::Bla"));
        assertEquals(null, TypeNameUtil.getMetaModelName("List[de::test::Bla]"));
        assertEquals("MM", TypeNameUtil.getMetaModelName("List[MM!de::test::Bla]"));
        assertEquals("MM", TypeNameUtil.getMetaModelName("List[MM!Bla]"));
    }

    public final void testGetCollectionTypeName() {

        assertEquals(null, TypeNameUtil.getCollectionTypeName("de::test::Bla"));
        assertEquals(null, TypeNameUtil.getCollectionTypeName("MM!de::test::Bla"));
        assertEquals("List", TypeNameUtil.getCollectionTypeName("List[TEST!de::test::Bla]"));
        assertEquals("Set", TypeNameUtil.getCollectionTypeName("Set[de::test::Bla]"));
        assertEquals("List", TypeNameUtil.getCollectionTypeName("List[Bla]"));
    }
}
