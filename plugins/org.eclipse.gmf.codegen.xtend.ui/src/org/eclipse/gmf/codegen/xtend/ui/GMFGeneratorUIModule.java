package org.eclipse.gmf.codegen.xtend.ui;

import org.eclipse.gmf.codegen.util.GMFGeneratorModule;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;

public class GMFGeneratorUIModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return GMFGeneratorModule.GMF_GEN;
	}

	@Override
	protected String getFileExtensions() {
		return GMFGeneratorModule.GMF_GEN_EXT;
	}

	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return SimpleResourceSetProvider.class;
	}

}
