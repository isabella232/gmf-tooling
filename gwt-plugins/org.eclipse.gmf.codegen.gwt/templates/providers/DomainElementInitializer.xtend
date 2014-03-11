package providers

import org.eclipse.gmf.codegen.gmfgen.GenDiagram

/*
 * «IMPORT 'http://www.eclipse.org/gmf/2009/GenModel'»

«DEFINE className FOR gmfgen::GenDiagram»DomainElementInitializer«ENDDEFINE»

«DEFINE qualifiedClassName FOR gmfgen::GenDiagram»«notationViewFactoriesPackageName».«EXPAND className»«ENDDEFINE»

«DEFINE DomainElementInitializer FOR gmfgen::GenDiagram-»
«EXPAND xpt::Common::copyright FOR editorGen-»
package «notationViewFactoriesPackageName»;

«EXPAND xpt::Common::generatedClassComment»
public class «EXPAND className» «EXPAND supertypes» {
	«EXPAND xpt::providers::ElementInitializers::Initializers»
	«EXPAND xpt::providers::ElementInitializers::JavaSupport»

	«EXPAND xpt::diagram::editpolicies::BaseItemSemanticEditPolicy::linkConstraints-»

	«EXPAND additions-»
}
«ENDDEFINE»

«DEFINE supertypes FOR gmfgen::GenDiagram»«ENDDEFINE»

«DEFINE additions FOR gmfgen::GenDiagram»«ENDDEFINE»
 */
class DomainElementInitializer {
	
//	extension ElementInitializers = new ElementInitializers
	
	def className(GenDiagram it) '''DomainElementInitializer'''
	
	def qualifiedClassName(GenDiagram it) '''«notationViewFactoriesPackageName».«className»'''
	
	def generate(GenDiagram it) '''
		package «notationViewFactoriesPackageName»;

		public class «className» {
«««		«EXPAND xpt::providers::ElementInitializers::Initializers»
«««		«EXPAND xpt::providers::ElementInitializers::JavaSupport»

«««		«EXPAND xpt::diagram::editpolicies::BaseItemSemanticEditPolicy::linkConstraints-»

		«additions»
		}
	'''
	
	def additions() ''''''
}