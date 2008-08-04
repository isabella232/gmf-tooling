/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tests.CleanupTest;
import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.lite.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.lite.gef.DiagramEditorMatchingStrategyTest;
import org.eclipse.gmf.tests.lite.gef.DiagramEditorOutlineTest;
import org.eclipse.gmf.tests.lite.gef.DiagramElementDeleteTest;
import org.eclipse.gmf.tests.lite.gef.DiagramElementTest;
import org.eclipse.gmf.tests.lite.gef.DiagramLinksTest;
import org.eclipse.gmf.tests.lite.gef.DiagramNodeCloneMoveTest;
import org.eclipse.gmf.tests.lite.gef.ExternalNodeLabelsTest;
import org.eclipse.gmf.tests.lite.gef.NotationRefreshTest;
import org.eclipse.gmf.tests.lite.gen.LiteCompilationTestWithImportConflicts;
import org.eclipse.gmf.tests.lite.multi.ShortcutCreationTest;
import org.eclipse.gmf.tests.lite.rt.ElementInitializerTest;
import org.eclipse.gmf.tests.lite.rt.svg.SVGFigureTest;
import org.eclipse.gmf.tests.lite.setup.LibraryConstrainedSetup;
import org.eclipse.gmf.tests.lite.setup.LiteLinksSessionSetup;
import org.eclipse.gmf.tests.lite.setup.LiteSessionSetup;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.MultiSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

public class AllTests {
	public static Test suite() throws Exception {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side, lite mode");

		suite.addTestSuite(LiteCompilationTestWithImportConflicts.class);

		final SessionSetup sessionSetup = LiteSessionSetup.getInstance();
		final LinksSessionSetup sessionSetup2 = LiteLinksSessionSetup.getInstance();
		final LibraryConstrainedSetup sessionSetup3 = LibraryConstrainedSetup.getInstance();
		final MultiSetup multiSetup = new MultiSetup(sessionSetup2, sessionSetup3);

		SessionSetup.disallowSingleTestCaseUse();

		suite.addTest(feed(DiagramEditorMatchingStrategyTest.class, sessionSetup3));
		suite.addTest(feed(DiagramEditorOutlineTest.class, sessionSetup3));
		suite.addTest(feed(DiagramElementDeleteTest.class, sessionSetup3));
		suite.addTest(feed(ExternalNodeLabelsTest.class, sessionSetup3));
		suite.addTest(feed(DiagramNodeTest.class, sessionSetup));
		suite.addTest(feed(DiagramNodeCloneMoveTest.class, sessionSetup3));
		suite.addTest(feed(DiagramElementTest.class, sessionSetup2));
		suite.addTest(feed(DiagramLinksTest.class, sessionSetup2));
		suite.addTest(feed(ElementInitializerTest.class, sessionSetup2));
		suite.addTest(feed(LinkCreationConstraintsTest.class, sessionSetup2));
		suite.addTest(feed(NotationRefreshTest.class, sessionSetup3));
		suite.addTest(feed(ShortcutCreationTest.class, multiSetup));
		suite.addTestSuite(SVGFigureTest.class);
		suite.addTest(new CleanupTest("testCleanup") {
			protected void performCleanup() throws Exception {
				sessionSetup.cleanup();
				sessionSetup2.cleanup();
				sessionSetup3.cleanup();
			}
		});
		return suite;
	}

	private static Test feed(Class<?> theClass, TestConfiguration config) {
		return org.eclipse.gmf.tests.AllTests.feed(theClass, config);
	}
}
