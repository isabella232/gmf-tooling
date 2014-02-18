package org.eclipse.gmf.tooling.tests.xtend.samples;

import org.eclipse.gmf.tests.samples.AffixedSampleTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class AffixedSampleTestXtend extends AffixedSampleTest {

	public AffixedSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}
}
