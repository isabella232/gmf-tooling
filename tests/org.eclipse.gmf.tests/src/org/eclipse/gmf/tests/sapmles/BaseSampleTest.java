package org.eclipse.gmf.tests.sapmles;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.GenProjectBaseSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public abstract class BaseSampleTest extends TestCase {
	
	public final static String BASE_PATH = Plugin.getBundleContext().getBundle().getLocation().replaceFirst("reference:file:", "").replaceFirst("tests/org.eclipse.gmf.tests/", "");
	
	private final RuntimeBasedGeneratorConfiguration myGenConfiguration;
	
	public BaseSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name);
		myGenConfiguration = genConfig;
	}

	protected abstract String getRelativeGMFGENPath();
	
	public void genAndCompile(String relativePath, RuntimeBasedGeneratorConfiguration genConfig) throws Exception {
		GenEditorGenerator editorGen = loadGMFGENModel(relativePath);
		new GenProjectBaseSetup(genConfig).generateAndCompile(editorGen);
	}
	
	protected GenEditorGenerator loadGMFGENModel(String relativePath) throws Exception {
		return loadEditorGen(URI.createURI(getRelativeGMFGENPath())); //$NON-NLS-1$);
	}
	
	private GenEditorGenerator loadEditorGen(String path) throws URISyntaxException, IOException {
		GenEditorGenerator result = null;
		File file = new File(path);
		if (file.exists()) {
			URI uriEditorGen = URI.createFileURI(file.getAbsolutePath());
			if (uriEditorGen != null) {
				result = loadEditorGen(uriEditorGen);
			}
		}
		return result;
	}
	
	private GenEditorGenerator loadEditorGen(URI u) {
		GenEditorGenerator result = null;
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(u, true);
		if (!r.getContents().isEmpty()) {
			result = (GenEditorGenerator) r.getContents().get(0);
		}
		return result;
	}
	
	public void testGenModel() throws Exception {
		assertNotNull(loadGMFGENModel(getRelativeGMFGENPath()));
	}
	
	public void testGenerateAndCompile() throws Exception {
		genAndCompile(getRelativeGMFGENPath(), myGenConfiguration);
	}
	
}
