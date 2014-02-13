package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class LinksSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/links/org.eclipse.gmf.tooling.examples.links/model/links.gmfgen"; 
	
	public LinksSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public LinksSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
