package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class CompartmentsSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/compartments/org.eclipse.gmf.tooling.examples.compartments/model/compartments.gmfgen"; 
	
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
