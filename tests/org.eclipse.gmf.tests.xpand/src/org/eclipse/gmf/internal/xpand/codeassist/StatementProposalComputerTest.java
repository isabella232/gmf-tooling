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
package org.eclipse.gmf.internal.xpand.codeassist;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;

public class StatementProposalComputerTest extends TestCase {

    private ProposalFactoryImpl f;

    private StatementProposalComputer kpc;

    @Override
    protected void setUp() throws Exception {
        kpc = new StatementProposalComputer();
        f = new ProposalFactoryImpl(100) {
        	@Override
        	protected Image getExtensionImage() {
        		return null;
        	}
        	@Override
        	protected Image getOperationImage() {
        		return null;
        	}
        	@Override
        	protected Image getPropertyImage() {
        		return null;
        	}
        	@Override
        	protected Image getStatementImage() {
        		return null;
        	}
        	@Override
        	protected Image getTypeImage() {
        		return null;
        	}
        };
        super.setUp();
    }

    public final void testComputeProposals1() {
        final String txt = tag("DEFINE test FOR this") + "  ";
        final List<ICompletionProposal> p = kpc.computeProposals(txt, null, f);
        assertTrue(p.get(0).getDisplayString().startsWith(XpandTokens.ENDDEFINE));

        assertFalse(contains(p, XpandTokens.ELSE));
        assertFalse(contains(p, XpandTokens.ELSEIF));
        assertTrue(contains(p, XpandTokens.FILE));
        assertTrue(contains(p, XpandTokens.PROTECT));
        assertTrue(contains(p, XpandTokens.IF));
        assertTrue(contains(p, XpandTokens.LET));
        assertTrue(contains(p, XpandTokens.FOREACH));
        assertTrue(contains(p, XpandTokens.EXPAND));
    }

    public final void testComputeProposals2() {
        final String txt = tag("DEFINE test FOR this") + "  " + tag("FILE test") + tag("IF x");
        final List<ICompletionProposal> p = kpc.computeProposals(txt, null, f);
        assertTrue(p.get(0).getDisplayString().startsWith(XpandTokens.ENDIF));

        assertTrue(contains(p, XpandTokens.ELSE));
        assertTrue(contains(p, XpandTokens.ELSEIF));
        assertFalse(contains(p, XpandTokens.FILE));
        assertTrue(contains(p, XpandTokens.PROTECT));
        assertTrue(contains(p, XpandTokens.IF));
        assertTrue(contains(p, XpandTokens.LET));
        assertTrue(contains(p, XpandTokens.FOREACH));
        assertTrue(contains(p, XpandTokens.EXPAND));
    }

    public final void testComputeProposals3() {
        final String txt = tag("DEFINE test FOR this") + "  " + tag("FILE test") + tag("IF x") + tag("ENDIF")
                + tag("ENDFILE") + tag("PROTECT CSTART x CEND y ENABLED");
        final List<ICompletionProposal> p = kpc.computeProposals(txt, null, f);
        assertTrue(p.get(0).getDisplayString().startsWith(XpandTokens.ENDPROTECT));

        assertFalse(contains(p, XpandTokens.ELSE));
        assertFalse(contains(p, XpandTokens.ELSEIF));
        assertTrue(contains(p, XpandTokens.FILE));
        assertFalse(contains(p, XpandTokens.PROTECT));
        assertTrue(contains(p, XpandTokens.IF));
        assertTrue(contains(p, XpandTokens.LET));
        assertTrue(contains(p, XpandTokens.FOREACH));
        assertTrue(contains(p, XpandTokens.EXPAND));
    }

    public final void testComputeProposals4() {
        final String txt = tag("IMPORT xyz") + "  ";
        final List<ICompletionProposal> p = kpc.computeProposals(txt, null, f);
        assertFalse(contains(p, XpandTokens.DEFINE));
        assertFalse(contains(p, XpandTokens.AROUND));

        assertEquals(4, p.size());
    }

    private static boolean contains(final List<ICompletionProposal> proposals, final String keyword) {
        for (ICompletionProposal element : proposals) {
            if (element.getDisplayString().startsWith(keyword))
                return true;
        }
        return false;
    }

    private static String tag(final String txt) {
        return XpandTokens.LT + txt + XpandTokens.RT;
    }
}
