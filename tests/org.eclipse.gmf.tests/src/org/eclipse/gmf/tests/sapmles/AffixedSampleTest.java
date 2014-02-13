package org.eclipse.gmf.tests.sapmles;

import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class AffixedSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/affixed/org.eclipse.gmf.tooling.examples.affixednode/model/affixednode.gmfgen"; 
	
	public AffixedSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public AffixedSampleTest(String name, RuntimeBasedGeneratorConfiguration genCongif) {
		super(name, genCongif);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
}
