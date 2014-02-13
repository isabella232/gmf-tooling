package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class SVGSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/svg/org.eclipse.gmf.tooling.examples.svg/model/svg.gmfgen"; 
	
	public SVGSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public SVGSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
