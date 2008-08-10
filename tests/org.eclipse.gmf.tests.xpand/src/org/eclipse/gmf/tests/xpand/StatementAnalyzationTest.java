/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.tests.xpand;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;

/**
 * *
 * 
 * @author Sven Efftinge *
 */
public class StatementAnalyzationTest extends TestCase {

    private ExecutionContextImpl execCtx;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        execCtx = new ExecutionContextImpl(new Scope(new TestsResourceManager(), null, new BufferOutput(new StringBuilder())));
        // ADDED encoding
        // XXX? execCtx.setFileEncoding("ISO-8859-1");
    }

    public final void testAnalyzation() {
        final String id = "org::eclipse::gmf::tests::xpand::evaluate::EvaluateStart";
        final AnalysationIssue[] issues = new XpandFacade(execCtx).analyze(id);
        dumpIssues(issues);
        assertEquals(0, issues.length);
    }

    private void dumpIssues(final AnalysationIssue[] issues) {
        for (int i = 0; i < issues.length; i++) {
            final AnalysationIssue issue = issues[i];
            String buffer = issue.getType() + " : " + issue.getMessage() + " on line " + (issue.getElement() != null ? issue.getElement().getLine()  : "");
            System.out.println(buffer);
        }

    }
}
