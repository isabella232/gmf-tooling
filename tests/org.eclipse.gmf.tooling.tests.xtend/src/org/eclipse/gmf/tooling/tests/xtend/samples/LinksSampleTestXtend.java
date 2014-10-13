package org.eclipse.gmf.tooling.tests.xtend.samples;

import org.eclipse.gmf.tests.samples.LinksSampleTest;
import org.eclipse.gmf.tests.samples.LinksSampleTestBase;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class LinksSampleTestXtend extends LinksSampleTestBase {

	public LinksSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}

	@Override
	protected String getRelativeGMFGENPath() {
		return LinksSampleTest.GIT_GMFGEN_PATH;
	}
}
