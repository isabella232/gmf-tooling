package org.eclipse.gmf.tests.samples;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;

public class PhantomSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.phantoms/model/phantoms.gmfgen"; 

	public PhantomSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public PhantomSampleTest(String name, RuntimeBasedGeneratorConfiguration genCongif) {
		super(name, genCongif);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
