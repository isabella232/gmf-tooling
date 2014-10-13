package org.eclipse.gmf.tests.samples;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCustomGeneratorExtension;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocation;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;

public class LinksSampleTest extends LinksSampleTestBase {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.links/model/links.gmfgen";

	public LinksSampleTest(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration());
	}

	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}

	public void testAspects() throws Exception {
		GenEditorGenerator editorGen = prepareCustomEditorGen("aspects", true);
		doTestAspects(editorGen);
	}
	
	public void failTestCustomExtension() throws Exception {
		GenEditorGenerator editorGen = prepareCustomEditorGen("custom", false);		
		editorGen.getExtensions().add(createCustomExtension(editorGen));		
		doTestCustomExtension(editorGen, "src/custom/CustomClass.java");		
	}

	protected GenEditorGenerator prepareCustomEditorGen(String suffix, boolean useDynamicTemplates) throws Exception {
		GenEditorGenerator editorGen = loadGMFGENModel(getRelativeGMFGENPath());
		editorGen.setPackageNamePrefix(createPackageNamePrefix(editorGen, suffix));
		editorGen.setPluginDirectory(createPluginDirectory(editorGen, suffix));
		editorGen.getPlugin().setID(editorGen.getPlugin().getID() + "." + suffix);
		editorGen.setTemplateDirectory("platform:/plugin/org.eclipse.gmf.tooling.examples.links/xtend/");
		editorGen.setDynamicTemplates(useDynamicTemplates);
		return editorGen;
	}

	protected GenCustomGeneratorExtension createCustomExtension(GenEditorGenerator self) {
		GenCustomGeneratorExtension result = GMFGenFactory.eINSTANCE.createGenCustomGeneratorExtension();
		result.setRootInput(self);
		GenTemplateInvocation t = GMFGenFactory.eINSTANCE.createGenTemplateInvocation();
		t.setOclExpression("self");
		t.setTemplateFqn("custom::CustomTemplate::CustomTemplate");
		result.getInvocations().add(t);
		return result;
	}

	private String createPackageNamePrefix(GenEditorGenerator editorGen, String suffix) {
		return editorGen.getPackageNamePrefix() + "." + suffix;
	}

	private String createPluginDirectory(GenEditorGenerator editorGen, String suffix) {
		String pluginDirectory = editorGen.getPluginDirectory();
		if (pluginDirectory.startsWith("/")) {
			pluginDirectory = pluginDirectory.substring(1);
		}
		String[] pluginDirectoryParts = pluginDirectory.split("/");
		StringBuilder result = new StringBuilder("/").append(pluginDirectoryParts[0]);
		result.append(".").append(suffix).append("/");
		for (int i = 1; i < pluginDirectoryParts.length; i++) {
			result.append(pluginDirectoryParts[i]).append("/");
		}
		return result.toString();
	}
}
