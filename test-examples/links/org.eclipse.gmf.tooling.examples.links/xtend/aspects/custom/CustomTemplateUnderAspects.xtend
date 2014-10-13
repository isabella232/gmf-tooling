package aspects.custom

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class CustomTemplateUnderAspects {

	def packageName(GenEditorGenerator it) '''custom'''

	def className(GenEditorGenerator it) '''CustomClassUnderAspects'''

	def qualifiedClassName(GenEditorGenerator it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenEditorGenerator it) '''«qualifiedClassName(it)»'''

	def CustomTemplateUnderAspects(GenEditorGenerator it) '''
		package «packageName(it)»;
		
		public class «className(it)» {
			
			private static String SOME_VAR = "TEST_PLUGIN_NAME = «it.plugin.name»";
			
			public void customClassMethod() {}
		}
	'''
}
