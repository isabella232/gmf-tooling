package org.eclipse.gmf.tooling.codegen.launcher.utils;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;

/**
 * code copied from Generator
 */
public class GMFGeneratorUtil {

	public static final String SEPARATOR = File.separator;

	public static GenEditorGenerator loadEditorGen(String projectLocation, String gmfgenLocation) {
		IPath gmfgenProjectPath = new Path(projectLocation);
		String gmfgenProjectName = gmfgenProjectPath.lastSegment();

		StringBuilder uri = new StringBuilder(SEPARATOR);
		uri.append(gmfgenProjectName);
		if (!gmfgenLocation.startsWith(SEPARATOR)) {
			uri.append(SEPARATOR);
		}
		uri.append(gmfgenLocation);

		URI gmfgenFileURI = URI.createPlatformResourceURI(uri.toString(), true);
		return GMFGeneratorUtil.loadEditorGen(gmfgenFileURI);
	}

	public static GenEditorGenerator loadEditorGen(org.eclipse.emf.common.util.URI u) {
		GenEditorGenerator result = null;
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(u, true);
		for (Object o: r.getContents()) {
			if (o instanceof GenEditorGenerator) {
				result = (GenEditorGenerator)o;
				break;
			}
		}
		return result;
	}
}
