package org.eclipse.gmf.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.gmf.tests.sapmles.AffixedSampleTest;
import org.eclipse.gmf.tests.sapmles.BorderSampleTest;
import org.eclipse.gmf.tests.sapmles.CompartmentsSampleTest;
import org.eclipse.gmf.tests.sapmles.LinksSampleTest;
import org.eclipse.gmf.tests.sapmles.PinsSampleTest;
import org.eclipse.gmf.tests.sapmles.SVGSampleTest;
import org.eclipse.gmf.tests.sapmles.ShourtcutSampleTest;


public class TestSamples {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf samples");
		suite.addTestSuite(PinsSampleTest.class);
		suite.addTestSuite(CompartmentsSampleTest.class);
		suite.addTestSuite(LinksSampleTest.class);
		suite.addTestSuite(SVGSampleTest.class);
		suite.addTestSuite(ShourtcutSampleTest.class);
		suite.addTestSuite(AffixedSampleTest.class);
		suite.addTestSuite(BorderSampleTest.class);
		return suite;
	}
	
}
