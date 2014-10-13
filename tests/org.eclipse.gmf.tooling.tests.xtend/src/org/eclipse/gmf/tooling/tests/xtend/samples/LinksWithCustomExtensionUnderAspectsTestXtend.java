package org.eclipse.gmf.tooling.tests.xtend.samples;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.tests.samples.LinksSampleTestBase;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class LinksWithCustomExtensionUnderAspectsTestXtend extends LinksSampleTestBase {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.links/model/links-with-custom-extension-under-aspects.gmfgen";

	public LinksWithCustomExtensionUnderAspectsTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}

	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}

	public void testCustomExtension() throws Exception {
		GenEditorGenerator editorGen = loadGMFGENModel(getRelativeGMFGENPath());
		doTestCustomExtension(editorGen, "src/custom/CustomClassUnderAspects.java");
	}
}
