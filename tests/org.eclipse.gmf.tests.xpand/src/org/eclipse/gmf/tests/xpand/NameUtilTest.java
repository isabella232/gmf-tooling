/*
 * Copyright (c) 2005, 2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.tests.xpand;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;

/**
 * *
 * 
 * @author Sven Efftinge *
 */
public class NameUtilTest extends TestCase {

	// TODO TypeNameUtil.getFullNamespace, etc

    public final void testGetLastSegment() {
        assertEquals("File", TypeNameUtil.getLastSegment("org" + TypeNameUtil.NS_DELIM + "test" + TypeNameUtil.NS_DELIM + "File"));
    }

    public final void testGetNamespace() {
        assertEquals("org" + TypeNameUtil.NS_DELIM + "test", TypeNameUtil.withoutLastSegment("org" + TypeNameUtil.NS_DELIM + "test" + TypeNameUtil.NS_DELIM + "File"));
    }
}
