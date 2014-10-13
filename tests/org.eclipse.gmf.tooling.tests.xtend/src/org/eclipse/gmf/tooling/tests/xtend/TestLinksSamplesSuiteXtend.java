package org.eclipse.gmf.tooling.tests.xtend;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tooling.tests.xtend.samples.LinksSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LinksWithAspectsTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LinksWithCustomExtensionTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LinksWithCustomExtensionUnderAspectsTestXtend;

public class TestLinksSamplesSuiteXtend {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf.tooling.examples.links");
		suite.addTestSuite(LinksSampleTestXtend.class);
		suite.addTestSuite(LinksWithAspectsTestXtend.class);
		suite.addTestSuite(LinksWithCustomExtensionTestXtend.class);
		suite.addTestSuite(LinksWithCustomExtensionUnderAspectsTestXtend.class);
		return suite;
	}
}
