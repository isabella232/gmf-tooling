package xpt

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import com.google.inject.Inject

class Access {
	
	@Inject Externalizer ext;
	
	def className(GenEditorGenerator it) '''«ext.accessClassName(it)»'''
	
	def packageName(GenEditorGenerator it) '''«ext.accessPackageName(it)»'''
	
	def qualifiedClassName(GenEditorGenerator it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenEditorGenerator it) '''«qualifiedClassName(it)»'''
	
	def Access(GenEditorGenerator it) '''«ext.Access(it)»'''
}