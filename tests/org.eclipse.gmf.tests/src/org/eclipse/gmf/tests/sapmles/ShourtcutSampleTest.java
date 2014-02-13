package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class ShourtcutSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/shortcut/org.eclipse.gmf.tooling.examples.shortcut/model/shortcut.gmfgen"; 
	
	public static final String GIT_EMF_PROJECT_PATH = "test-examples/shortcut/org.eclipse.gmf.tooling.examples.shortcut"; 
	
	public ShourtcutSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public ShourtcutSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
