/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
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
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.lite.gef.DiagramEditorMatchingStrategyTest;
import org.eclipse.gmf.tests.lite.gef.DiagramEditorOutlineTest;
import org.eclipse.gmf.tests.lite.gef.DiagramElementDeleteTest;
import org.eclipse.gmf.tests.lite.gef.DiagramElementTest;
import org.eclipse.gmf.tests.lite.gef.DiagramLinksTest;
import org.eclipse.gmf.tests.lite.gef.DiagramNodeCloneMoveTest;
import org.eclipse.gmf.tests.lite.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.lite.gef.ExternalNodeLabelsTest;
import org.eclipse.gmf.tests.lite.gef.NotationRefreshTest;
import org.eclipse.gmf.tests.lite.gen.LiteCompilationTest;
import org.eclipse.gmf.tests.lite.multi.ShortcutCreationTest;
import org.eclipse.gmf.tests.lite.rt.ElementInitializerTest;
import org.eclipse.gmf.tests.lite.setup.LibraryConstrainedSetup;
import org.eclipse.gmf.tests.lite.setup.LiteLinksSessionSetup;
import org.eclipse.gmf.tests.lite.setup.LiteSessionSetup;
import org.eclipse.gmf.tests.lite.svg.GeneratedSVGFigureTest;
import org.eclipse.gmf.tests.lite.svg.SVGFigureTest;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.MultiSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;

public class AllTests {
	public static Test suite() throws Exception {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side, lite mode");

		suite.addTestSuite(LiteCompilationTest.class);

		final SessionSetup sessionSetup = LiteSessionSetup.getInstance();
		final LinksSessionSetup sessionSetup2 = LiteLinksSessionSetup.getInstance();
		final LibraryConstrainedSetup sessionSetup3 = LibraryConstrainedSetup.getInstance();
		final MultiSetup multiSetup = new MultiSetup(sessionSetup2, sessionSetup3);

		SessionSetup.disallowSingleTestCaseUse();
		
		Plugin.getConfig().register(DiagramEditorMatchingStrategyTest.class, sessionSetup3);
		Plugin.getConfig().register(DiagramEditorOutlineTest.class, sessionSetup3);	// myDefaultSetup = LibraryConstrainedSetup.getInstance();
		Plugin.getConfig().register(DiagramElementDeleteTest.class, sessionSetup3);
		Plugin.getConfig().register(ExternalNodeLabelsTest.class, sessionSetup3); // myDefaultSetup = ... 
		Plugin.getConfig().register(DiagramNodeTest.class, sessionSetup);
		Plugin.getConfig().register(DiagramNodeCloneMoveTest.class, sessionSetup3); // myDefaultSetup = ...
		Plugin.getConfig().register(DiagramElementTest.class, sessionSetup2);
		Plugin.getConfig().register(DiagramLinksTest.class, sessionSetup2);
		Plugin.getConfig().register(ElementInitializerTest.class, sessionSetup2);
		Plugin.getConfig().register(LinkCreationConstraintsTest.class, sessionSetup2);
		Plugin.getConfig().register(NotationRefreshTest.class, sessionSetup3); // myDefaultSetup = LibraryConstrainedSetup.getInstance();
		Plugin.getConfig().register(ShortcutCreationTest.class, multiSetup);

		suite.addTestSuite(DiagramEditorMatchingStrategyTest.class);
		suite.addTestSuite(DiagramEditorOutlineTest.class);
		suite.addTestSuite(DiagramElementDeleteTest.class);
		suite.addTestSuite(ExternalNodeLabelsTest.class);
		suite.addTestSuite(DiagramNodeTest.class);
		suite.addTestSuite(DiagramNodeCloneMoveTest.class);
		suite.addTestSuite(DiagramElementTest.class);
		suite.addTestSuite(DiagramLinksTest.class);
		suite.addTestSuite(ElementInitializerTest.class);
		suite.addTestSuite(LinkCreationConstraintsTest.class);
		suite.addTestSuite(NotationRefreshTest.class);
		suite.addTestSuite(ShortcutCreationTest.class);
		suite.addTestSuite(SVGFigureTest.class);
		suite.addTestSuite(GeneratedSVGFigureTest.class);
		suite.addTest(new CleanupTest("testCleanup") {
			protected void performCleanup() throws Exception {
				sessionSetup.cleanup();
				sessionSetup2.cleanup();
				sessionSetup3.cleanup();
			}
		});
		return suite;
	}
}
