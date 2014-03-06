package org.eclipse.gmf.tests.samples;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class LabelsSampleTest extends BaseSampleTest {
	
	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.labels/model/labels.gmfgen";
	
	public LabelsSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}

	public LabelsSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
