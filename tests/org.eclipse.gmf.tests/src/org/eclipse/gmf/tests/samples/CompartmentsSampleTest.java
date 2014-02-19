package org.eclipse.gmf.tests.samples;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class CompartmentsSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.compartments/model/compartments.gmfgen";
	
	public CompartmentsSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public CompartmentsSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
