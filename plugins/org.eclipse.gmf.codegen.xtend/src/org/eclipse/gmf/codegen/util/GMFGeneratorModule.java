package org.eclipse.gmf.codegen.util;

import java.util.List;

import org.eclipse.xtext.service.AbstractGenericModule;

public class GMFGeneratorModule extends AbstractGenericModule {

	private final IExtensionTemplatesProvider myExtensionTemplatesProvider;

	public GMFGeneratorModule(IExtensionTemplatesProvider extProvider) {
		myExtensionTemplatesProvider = extProvider;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void configure(com.google.inject.Binder binder) {
		if (getExtensionTemplateProvider() != null) {
			if (getExtensionTemplateProvider().getDynamicTemplateClasses().size() > 0) {
				List<Class<?>> dynamicTemplates = getExtensionTemplateProvider().getDynamicTemplateClasses();
				for (Class _class : dynamicTemplates) {
					Class<?> superClass = getExtensionTemplateProvider().getSuperClassForDynamic(_class);
					binder.bind(superClass).to(_class);
				}
			}
			if (getExtensionTemplateProvider().getCustomTemplateClasses().size() > 0) {
				List<Class<?>> cusomTemplates = getExtensionTemplateProvider().getCustomTemplateClasses();
				for (Class _class : cusomTemplates) {
					binder.bind(_class); // I'm not sure that this worked
				}
			}
		}
	}

	public IExtensionTemplatesProvider getExtensionTemplateProvider() {
		return myExtensionTemplatesProvider;
	}
}
