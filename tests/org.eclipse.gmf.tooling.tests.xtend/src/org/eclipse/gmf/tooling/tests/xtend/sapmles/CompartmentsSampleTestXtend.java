package org.eclipse.gmf.tooling.tests.xtend.sapmles;

import org.eclipse.gmf.tests.sapmles.CompartmentsSampleTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfiguration;


public class CompartmentsSampleTestXtend extends CompartmentsSampleTest {

	public static final String GIT_GMFGEN_PATH = "test-examples/compartments/org.eclipse.gmf.tooling.examples.compartments/model/compartments.gmfgen"; 
	
	public CompartmentsSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration());
	}
	
}
