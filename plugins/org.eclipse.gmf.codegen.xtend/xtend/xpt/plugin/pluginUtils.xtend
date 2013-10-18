package xpt.plugin

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class pluginUtils {
	
	
	@Inject extension xpt.ConstraintProviders
	
	def extensionsConstraintProviders (GenEditorGenerator it) '''
		«extensions(it)»
	'''
}