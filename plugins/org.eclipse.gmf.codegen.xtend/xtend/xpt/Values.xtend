package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class Values {
	
	@Inject Externalizer ext;
	
	def qualifiedClassName(GenEditorGenerator it) '''messages.properties'''
	def fullPath(GenEditorGenerator it) '''«qualifiedClassName(it)»'''
	
	def Values(GenEditorGenerator it) '''«ext.Values(it)»'''
	
}