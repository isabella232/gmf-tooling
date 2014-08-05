package org.eclipse.gmf.tooling.tests.xtend;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tooling.tests.xtend.samples.AffixedSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.CompartmentsSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LabelsSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LinkLabelsTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.LinksSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.PinsSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.SVGSampleTestXtend;
import org.eclipse.gmf.tooling.tests.xtend.samples.ShourtcutSampleTestXtend;


public class TestSamplesSuiteXtend {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.tooling.gmf samples");
		suite.addTestSuite(PinsSampleTestXtend.class);
		suite.addTestSuite(CompartmentsSampleTestXtend.class);
		suite.addTestSuite(LinksSampleTestXtend.class);
		suite.addTestSuite(SVGSampleTestXtend.class);
		suite.addTestSuite(ShourtcutSampleTestXtend.class);
		suite.addTestSuite(AffixedSampleTestXtend.class);
		suite.addTestSuite(LabelsSampleTestXtend.class);
		suite.addTestSuite(LinkLabelsTestXtend.class);
		return suite;
	}
}
