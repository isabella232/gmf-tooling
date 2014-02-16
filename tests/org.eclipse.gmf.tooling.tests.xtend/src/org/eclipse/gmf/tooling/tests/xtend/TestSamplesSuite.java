package org.eclipse.gmf.tooling.tests.xtend;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tooling.tests.xtend.sapmles.AffixedSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.sapmles.CompartmentsSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.sapmles.LinksSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.sapmles.PinsSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.sapmles.SVGSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.sapmles.ShourtcutSampleTestXtend;


public class TestSamplesSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.tooling.gmf samples");
		suite.addTestSuite(PinsSampleTestXtend.class);
		suite.addTestSuite(CompartmentsSampleTestXtend.class);
		suite.addTestSuite(LinksSampleTestXtend.class);
		suite.addTestSuite(SVGSampleTestXtend.class);
		suite.addTestSuite(ShourtcutSampleTestXtend.class);
		suite.addTestSuite(AffixedSampleTestXtend.class);
		return suite;
	}
}
