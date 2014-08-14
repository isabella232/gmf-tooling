package org.eclipse.gmf.tooling.tests.xtend.samples;

import org.eclipse.gmf.tests.samples.LinklfSampleTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;


public class LinklfSampleTestXtend extends LinklfSampleTest {

	public LinklfSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}
}
