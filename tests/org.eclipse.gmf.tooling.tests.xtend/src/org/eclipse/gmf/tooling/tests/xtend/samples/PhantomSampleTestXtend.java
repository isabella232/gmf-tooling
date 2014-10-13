package org.eclipse.gmf.tooling.tests.xtend.samples;

import org.eclipse.gmf.tests.samples.PhantomSampleTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class PhantomSampleTestXtend extends PhantomSampleTest {

	public PhantomSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}
	
}
