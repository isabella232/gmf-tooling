package org.eclipse.gmf.tests;

import org.eclipse.gmf.tests.sapmles.*;

import junit.framework.Test;
import junit.framework.TestSuite;


public class TestSamples {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.gmf samples");
		suite.addTestSuite(PinsSampleTest.class);
		suite.addTestSuite(CompartmentsSampleTest.class);
		suite.addTestSuite(LinksSampleTest.class);
		suite.addTestSuite(SVGSampleTest.class);
		suite.addTestSuite(ShourtcutSampleTest.class);
		suite.addTestSuite(AffixedSampleTest.class);
		return suite;
	}
	
}
