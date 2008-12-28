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
package org.eclipse.gmf.tests.xpand.impl;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.TypeNameUtil;

/**
 * *
 * 
 * @author Sven Efftinge *
 */
public class NameUtilTest extends TestCase {

	// TODO TypeNameUtil.getFullNamespace, etc

    public final void testGetLastSegment() {
        assertEquals("File", TypeNameUtil.getLastSegment("org" + SyntaxConstants.NS_DELIM + "test" + SyntaxConstants.NS_DELIM + "File"));
    }

    public final void testGetNamespace() {
        assertEquals("org" + SyntaxConstants.NS_DELIM + "test", TypeNameUtil.withoutLastSegment("org" + SyntaxConstants.NS_DELIM + "test" + SyntaxConstants.NS_DELIM + "File"));
    }
}
