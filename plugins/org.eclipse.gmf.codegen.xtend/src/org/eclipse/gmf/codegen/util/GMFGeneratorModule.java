package org.eclipse.gmf.codegen.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class GMFGeneratorModule extends AbstractGenericResourceRuntimeModule {

	public static String GMF_GEN = "org.eclipse.gmf.codegen.gmfgen";

	public static String GMF_GEN_EXT = "gmfgen";

	@Override
	protected String getLanguageName() {
		return GMF_GEN;
	}

	@Override
	protected String getFileExtensions() {
		return GMF_GEN_EXT;
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return GMFGenGenerator.class;
	}

	public Class<? extends ResourceSet> bindResourceSet() {
		return ResourceSetImpl.class;
	}

	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	public org.eclipse.core.resources.IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	}
}
