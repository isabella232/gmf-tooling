package org.eclipse.gmf.codegen.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.service.AbstractGenericModule;

public class GMFGeneratorModule extends AbstractGenericModule {

	//private final IExtensionTemplatesProvider myExtensionTemplatesProvider;

	//	public GMFGeneratorModule(IExtensionTemplatesProvider extProvider) {
	//		myExtensionTemplatesProvider = extProvider;
	//	}

	public GMFGeneratorModule() {
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

	public void configure(com.google.inject.Binder binder) {
		//		if (getExtensionTemplateProvider() != null) {
		//			if (getExtensionTemplateProvider().hasDynamicTemplates()) {
		//				List<Class<?>> dynamicTemplates = getExtensionTemplateProvider().getDynamicTemplateClasses();
		//				for (Class _class : dynamicTemplates) {
		//					Class<?> superClass = getExtensionTemplateProvider().getSuperClassForDynamic(_class);
		//					binder.bind(superClass).to(_class);
		//				}
		//			}
		//			if (getExtensionTemplateProvider().hasCustomTemplates()) {
		//				List<Class<?>> cusomTemplates = getExtensionTemplateProvider().getCustomTemplateClasses();
		//				for (Class _class : cusomTemplates) {
		//					binder.bind(_class); // I'm not sure that this worked
		//				}
		//			}
		//		}
	}

	//	public IExtensionTemplatesProvider getExtensionTemplateProvider() {
	//		return myExtensionTemplatesProvider;
	//	}
}
