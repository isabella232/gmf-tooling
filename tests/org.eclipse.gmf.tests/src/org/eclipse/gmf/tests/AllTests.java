/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.util.Enumeration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.gmf.tests.gef.DiagramNodeTest;
import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.gen.FigureCodegenTest;
import org.eclipse.gmf.tests.gen.HandcodedImplTest;
import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.TestSetupTest;
import org.eclipse.gmf.tests.tr.EPNamingStrategyTest;
import org.eclipse.gmf.tests.tr.GenModelTransformerBasicRTTest;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf, tooling side");
		//$JUnit-BEGIN$
		
		final SessionSetup sessionSetup = SessionSetup.newInstance();
		final LinksSessionSetup sessionSetup2 = (LinksSessionSetup) LinksSessionSetup.newInstance();
		SessionSetup.disallowSingleTestCaseUse();
		
		
		suite.addTestSuite(TestSetupTest.class); // first, check sources/setups we use for rest of the tests
		suite.addTest(feed(HandcodedImplTest.class, sessionSetup)); // then, check handcoded implementations are in place

		suite.addTestSuite(FigureCodegenTest.class);
		// fires new runtime workbench initialization
		suite.addTestSuite(CompilationTest.class);

		suite.addTest(feed(DiagramNodeTest.class, sessionSetup));
		suite.addTest(feed(EPNamingStrategyTest.class, sessionSetup));
		suite.addTest(feed(GenModelTransformerBasicRTTest.class, sessionSetup));

//		suite.addTestSuite(RunTimeModelTransformerTest.class); #113966
//		suite.addTestSuite(PropertiesTest.class); #113965 
//		suite.addTestSuite(CanvasTest.class); Nothing there yet
//		suite.addTestSuite(SpecificRTPropertiesTest.class); #113965 
		
		suite.addTest(feed(LinkCreationConstraintsTest.class, sessionSetup2));
		//$JUnit-END$
		suite.addTest(new TestCase("testCleanup") {
			protected void runTest() throws Throwable {
				try {
					sessionSetup.cleanup();
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

	private static TestSuite feed(Class theClass, SessionSetup setup) {
		TestSuite suite = new TestSuite(theClass);
		for (Enumeration en = suite.tests(); en.hasMoreElements(); ) {
			Object nextTest = en.nextElement();
			if (nextTest instanceof NeedsSetup) {
				((NeedsSetup) nextTest).setSetup(setup);
			}
		}
		return suite;
	}
}
