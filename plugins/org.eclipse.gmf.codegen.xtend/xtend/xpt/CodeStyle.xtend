package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

@com.google.inject.Singleton class CodeStyle {
	@Inject extension GenEditorGenerator_qvto
	@Inject extension Common;
	/**
	 * FIXME: [MG] inline this, we now safely assume everywhere that it is > 4
	 */
	def overrideC(GenCommonBase xptSelf) ''' 
		«IF xptSelf.jdkComplianceLevel() > 4»
			@Override
		«ENDIF»
	'''

	def overrideI(GenCommonBase xptSelf) '''
		«IF xptSelf.jdkComplianceLevel() > 5»
			@Override
		«ELSE»
			«extraLineBreak»
		«ENDIF»
	'''

	/**
	 * FIXME: [MG] inline this, we now safely assume everywhere that it is > 4
	 */
	def SuppressWarnings(GenEditorGenerator xptSelf, String warnToken) '''«SuppressWarnings(xptSelf.diagram, warnToken)»'''

	/**
	 * FIXME: [MG] inline this, we now safely assume everywhere that it is > 4
	 */
	def SuppressWarnings(GenCommonBase xptSelf, String warnToken) '''
		«IF xptSelf.jdkComplianceLevel() > 4»
			@SuppressWarnings(«warnToken»)
		«ENDIF»
	'''
}
