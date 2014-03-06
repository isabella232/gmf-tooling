package org.eclipse.gmf.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tests.samples.AffixedSampleTest;
import org.eclipse.gmf.tests.samples.CompartmentsSampleTest;
import org.eclipse.gmf.tests.samples.LabelsSampleTest;
import org.eclipse.gmf.tests.samples.LinksSampleTest;
import org.eclipse.gmf.tests.samples.PinsSampleTest;
import org.eclipse.gmf.tests.samples.SVGSampleTest;
import org.eclipse.gmf.tests.samples.ShourtcutSampleTest;

public class TestSamplesSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf samples");
		suite.addTestSuite(PinsSampleTest.class);
		suite.addTestSuite(CompartmentsSampleTest.class);
		suite.addTestSuite(LinksSampleTest.class);
		suite.addTestSuite(SVGSampleTest.class);
		suite.addTestSuite(ShourtcutSampleTest.class);
		suite.addTestSuite(AffixedSampleTest.class);
		suite.addTestSuite(LabelsSampleTest.class);
		//suite.addTestSuite(BorderSampleTest.class);
		return suite;
	}

}
