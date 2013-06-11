package xpt.editor

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.MetaDef

//XXX: [MG] decide what to do with methods
class VisualIDRegistry {

	@MetaDef def getVisualIdMethodName(GenDiagram xptSelf) '''getVisualID'''

	@MetaDef def getModelIDMethodName(GenDiagram xptSelf) '''getModelID'''

	@MetaDef def getVisualIDMethodCall(GenDiagram it) '''«getVisualIDRegistryQualifiedClassName()».«getVisualIdMethodName()»'''

	@MetaDef def getModelIDMethodCall(GenDiagram it) '''«getVisualIDRegistryQualifiedClassName()».«getModelIDMethodName()»'''

	/**
	 * FIXME: static because its used from xpt.Common (also imported here), to avoid cyclic injection 
	 */
	@MetaDef static def visualID(GenCommonBase xptSelf) '''«xptSelf.editPartQualifiedClassName».VISUAL_ID'''

	/**
	 * FIXME: static because its used from xpt.Common (also imported here), to avoid cyclic injection  
	 */
	@MetaDef static def modelID(GenDiagram xptSelf) '''«xptSelf.editPartQualifiedClassName».MODEL_ID'''

	/**
	 * XXX looks like these methods would produce incorrect result for visualID of GenDiagram itself 
	 * check if getType() method shouldn't be fixed similar to getVisualID, i.e. map diagram's visual id to MODEL_ID instead plain String.valueOf() 
	 */
	@MetaDef def /*!dispatch*/ typeMethodCall(GenCommonBase xptSelf, CharSequence visualIdVar) '''«xptSelf.diagram.
		visualIDRegistryQualifiedClassName».«getTypeMethodName(xptSelf.diagram)»(«visualIdVar»)'''

	@MetaDef def /*!dispatch*/ typeMethodCall(GenCommonBase xptSelf) '''«typeMethodCall(xptSelf, visualID(xptSelf))»'''

	@MetaDef def getTypeMethodName(GenDiagram xptSelf) '''getType'''

	@MetaDef def runtimeTypedInstanceName(GenDiagram it) '''TYPED_INSTANCE'''

	@MetaDef def runtimeTypedInstanceCall(GenDiagram it) '''«visualIDRegistryQualifiedClassName».«runtimeTypedInstanceName»'''

}
