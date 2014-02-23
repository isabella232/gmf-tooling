package custom

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class CustomTemplate {
	
	def packageName(GenEditorGenerator it) '''custom'''
	
	def className(GenEditorGenerator it) '''CustomClass'''
	
	def qualifiedClassName(GenEditorGenerator it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenEditorGenerator it) '''«qualifiedClassName(it)»'''
	
	def CustomTemplate(GenEditorGenerator it) '''
		package «packageName(it)»;
		
		public class «className(it)» {
			
			private static String SOME_VAR = "TEST_PLUGIN_NAME = «it.plugin.name»";
			
			public void customClassMethod() {}
		}
	'''
}