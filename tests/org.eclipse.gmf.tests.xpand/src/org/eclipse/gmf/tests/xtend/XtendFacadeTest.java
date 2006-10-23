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
package org.eclipse.gmf.tests.xtend;

import java.util.Arrays;
import java.util.HashSet;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.xtend.ast.XtendResource;
import org.eclipse.gmf.tests.xpand.TestsResourceManager;

public class XtendFacadeTest extends TestCase {

	private ResourceManager resourceManager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceManager = new TestsResourceManager();
	}

    public final void testEval() {
        final XtendFacade f = XtendFacade.create(resourceManager, qualified("Extensions"));
        assertEquals("_Stuff", f.call("appendStuff", new Object[] { "_" }));
    }

    public final void testEval1() {
        final XtendFacade f = XtendFacade.create(resourceManager, qualified("AnotherExt"));
        assertEquals("XXStuff", f.call("doStuff", new Object[] { "X" }));
    }

    public final void testReExported() {
        final XtendFacade f = XtendFacade.create(resourceManager, qualified("AnotherExt"));
        assertEquals("_Stuff", f.call("appendStuff", new Object[] { "_" }));
    }

    public final void testAnalyze() {
        final XtendFacade f = XtendFacade.create(resourceManager, qualified("AnotherExt"));
        final EClassifier t = f.analyze("doStuff", new Object[] { "X" }, new HashSet<AnalysationIssue>());
        assertEquals("EString", t.getName());
    }

    public void testGlobalVar() {
    	XtendResource xres = resourceManager.loadXtendResource(qualified("globalvarExt"));
    	Variable v1 = new Variable("xy", new Short((short) 17));
		ExecutionContext ctx = new ExecutionContextImpl(resourceManager, xres, null, Arrays.asList(v1));
        final XtendFacade f = new XtendFacade(ctx);
    	Object result = f.call("abc");
		assertEquals(v1.getValue(), result);
    }

    private static String qualified(String extensionFileName) {
    	return "org::eclipse::gmf::tests::xtend::" + extensionFileName;
    }
}
