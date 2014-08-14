package org.eclipse.gmf.tests.samples;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class LinklfSampleTest extends BaseSampleTest {
	
	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.linklf/model/linklf.gmfgen"; 

	public LinklfSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public LinklfSampleTest(String name, RuntimeBasedGeneratorConfiguration genCongif) {
		super(name, genCongif);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
}
