/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.lite;

import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.lite.gef.DiagramElementTest;
import org.eclipse.gmf.tests.lite.gef.DiagramLinksTest;
import org.eclipse.gmf.tests.lite.gef.DiagramNodeCloneMoveTest;
import org.eclipse.gmf.tests.lite.gef.ExternalNodeLabelsTest;
import org.eclipse.gmf.tests.lite.gef.NotationRefreshTest;
import org.eclipse.gmf.tests.lite.gen.LiteCompilationTest;
import org.eclipse.gmf.tests.lite.gen.RCPLiteCompilationTest;
import org.eclipse.gmf.tests.lite.rt.ElementInitializerTest;
import org.eclipse.gmf.tests.lite.setup.LibraryConstrainedSetup;
import org.eclipse.gmf.tests.lite.setup.LiteLinksSessionSetup;
import org.eclipse.gmf.tests.lite.setup.LiteSessionSetup;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends org.eclipse.gmf.tests.AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side, lite mode");
		suite.addTestSuite(LiteCompilationTest.class);
		suite.addTestSuite(RCPLiteCompilationTest.class);

		final SessionSetup sessionSetup = LiteSessionSetup.getInstance();
		final LinksSessionSetup sessionSetup2 = LiteLinksSessionSetup.getInstance();
		final LibraryConstrainedSetup sessionSetup3 = LibraryConstrainedSetup.getInstance();
		SessionSetup.disallowSingleTestCaseUse();

		suite.addTest(feed(ExternalNodeLabelsTest.class, sessionSetup3));
		suite.addTest(feed(DiagramNodeTest.class, sessionSetup));
		suite.addTest(feed(DiagramNodeCloneMoveTest.class, sessionSetup3));
		suite.addTest(feed(DiagramElementTest.class, sessionSetup2));
		suite.addTest(feed(DiagramLinksTest.class, sessionSetup2));
		suite.addTest(feed(ElementInitializerTest.class, sessionSetup2));
		suite.addTest(feed(LinkCreationConstraintsTest.class, sessionSetup2));
		suite.addTest(feed(NotationRefreshTest.class, sessionSetup3));

		suite.addTest(new TestCase("testCleanup") {
			protected void runTest() throws Throwable {
				try {
					sessionSetup.cleanup();
					sessionSetup2.cleanup();
					sessionSetup3.cleanup();
				} catch (RuntimeException ex) {
					throw ex;
				} catch (Exception ex) {
					Plugin.logError("cleanup failed", ex);
					fail(ex.getMessage());
				}
			}
		});
		return suite;
	}
}
