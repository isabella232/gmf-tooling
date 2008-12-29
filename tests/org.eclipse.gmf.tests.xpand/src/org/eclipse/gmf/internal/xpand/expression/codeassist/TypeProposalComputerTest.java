/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import org.eclipse.gmf.internal.xpand.codeassist.ProposalFactoryImpl;

import junit.framework.TestCase;

public class TypeProposalComputerTest extends TestCase {
    private TypeProposalComputer tpc;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        tpc = new TypeProposalComputer(new ProposalFactoryImpl(0, null));
    }

    public final void testGetPrefix() {
        assertEquals("Str", tpc.findPrefix("tedfc fer 34r30f3nf fe[Str"));
    }
}
