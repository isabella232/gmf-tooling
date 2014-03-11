package client

import common.BaseClassTemplate
import common.Common
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

abstract class ClientClassTemplate extends BaseClassTemplate<GenEditorGenerator> {

	protected extension QualifiedNamesHelper = new QualifiedNamesHelper
	protected extension Common = new Common

	def className(GenEditorGenerator it) '''«this.class.simpleName»'''

	def packageName(GenEditorGenerator it) '''«baseClientPackage»'''

	override qualifiedClassName(GenEditorGenerator it) '''«packageName».«className»'''

	override generate(GenEditorGenerator it) '''
		package «packageName»;

		«getImports»

		«generatedClassComment»
		public «IF abstract»abstract«ENDIF» «IF interface»interface«ELSE»class«ENDIF» «className»«extends»«implements» {

			«body»

		}
	'''

	protected def isAbstract() { false }

	protected def isInterface() { false }

	protected def getImports(GenEditorGenerator it) ''''''

	private def getExtends(GenEditorGenerator it) 
		'''«IF extendDefinition.length != 0» extends «extendDefinition»«ENDIF»'''

	private def getImplements(GenEditorGenerator it) 
		'''«IF implementDefinition.length != 0» implements «implementDefinition»«ENDIF»'''

	protected def extendDefinition(GenEditorGenerator it) ''''''

	protected def implementDefinition(GenEditorGenerator it) ''''''

}