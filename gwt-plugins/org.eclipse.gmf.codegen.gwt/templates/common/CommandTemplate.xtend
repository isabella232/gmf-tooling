package common

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase

abstract class CommandTemplate<T extends GenCommonBase> extends BaseClassTemplate<T> {

	override generate(T it) '''
		package «packageName»;

		«generatedClassComment»
		public class «commandName» «supertypes» {
			«body»
		}
	'''

	def packageName(T it) { diagram.editCommandsPackageName }

	abstract def CharSequence commandName(T it)
	
	override qualifiedClassName(T it) { packageName + "." + commandName }

}
