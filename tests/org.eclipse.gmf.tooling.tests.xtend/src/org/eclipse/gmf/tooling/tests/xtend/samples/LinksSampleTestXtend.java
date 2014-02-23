package org.eclipse.gmf.tooling.tests.xtend.samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.tests.samples.LinksSampleTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class LinksSampleTestXtend extends LinksSampleTest {

	public LinksSampleTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}
	
	public void testCustomExtension() throws Exception {
		GenEditorGenerator editorGen = prepareCustomEditorGen("custom", false);
		editorGen.getExtensions().add(createCustomExtension(editorGen));
		genAndCompile(editorGen, getGenerationConfiguration());
		IProject aspectsProject = ResourcesPlugin.getWorkspace().getRoot().getProject(editorGen.getPluginDirectory().split("/")[1]);
		assertTrue(aspectsProject.exists());
		IFile file = aspectsProject.getFile(new Path("src/custom/CustomClass.java"));
		assertTrue(file.exists());
		BufferedReader classToTest = new BufferedReader(new InputStreamReader(file.getContents(), file.getCharset()));
		String pluginID = null;
		String line;
		while ((line = classToTest.readLine()) != null) {
			if (line.trim().startsWith("private static String SOME_VAR = \"TEST_PLUGIN_NAME = ")) {
				pluginID = line.trim().replaceFirst("private static String SOME_VAR = \"TEST_PLUGIN_NAME = ", "").replace("\";", "");
			}
		}
		assertEquals(pluginID, editorGen.getPlugin().getName());
	}
}
