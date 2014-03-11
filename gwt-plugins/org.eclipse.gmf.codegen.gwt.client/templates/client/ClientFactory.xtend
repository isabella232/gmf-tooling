package client

import common.Common
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class ClientFactory extends ClientClassTemplate {

	extension Common = new Common

	override generate(GenEditorGenerator it) '''
		package «baseClientPackage»;

		«generatedClassComment»
		public class «className» extends org.eclipse.gmf.runtime.gwt.client.DefaultClientFactory {
			«body»
		}
	'''

	override protected body(GenEditorGenerator it) 
	'''
		«composedAdapterFactory»

		«resourceSet»
	'''
	
	protected def composedAdapterFactory(GenEditorGenerator it) '''
		«generatedMemberComment»
		@Override
		public org.eclipse.emf.edit.provider.ComposedAdapterFactory getComposedAdapterFactory() {
			org.eclipse.emf.edit.provider.ComposedAdapterFactory factory = super.getComposedAdapterFactory();
			«FOR p: domainGenModel.genPackages»
			factory.addAdapterFactory(new «p.qualifiedItemProviderAdapterFactoryClassName»());
			«ENDFOR»
			return factory;
		}
	'''
	
	protected def resourceSet() '''
		«generatedMemberComment»
		@Override
		public void setupResourceSet(org.eclipse.emf.ecore.resource.ResourceSet resourceSet) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl() {
				@Override
				public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
					return new org.eclipselabs.emfjson.gwt.resource.JsResourceImpl(uri);
				}
			});
			resourceSet.getURIConverter().getURIHandlers().add(0, new org.eclipselabs.emfjson.gwt.handlers.LocalStorageHandler());
		}
	'''

	override className(GenEditorGenerator it) '''AppClientFactory'''

}