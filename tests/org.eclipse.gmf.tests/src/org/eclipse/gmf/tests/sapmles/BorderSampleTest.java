package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;

public class BorderSampleTest extends BaseSampleTest {

	public static final String GIT_PROJECT_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.border/model/borders.gmfgen"; 
	
	public BorderSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}

	
	public BorderSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	protected String getRelativeGMFGENPath() {
		return GIT_PROJECT_PATH;
	}
	
}
