package diagram.policies

import org.eclipse.gmf.codegen.gmfgen.GenNode

class SideAffixedLayoutEditPolicy extends AbstractLayoutEditPolicy<GenNode> {
	
	override body(GenNode it) '''
		«getCreateCommand(getSideAffixedChildren)»
		«createAddCommand(getSideAffixedChildren)»
		«createCloneCommand(getSideAffixedChildren)»
		«createChangeSideAffixedConstraintCommand(getSideAffixedChildren)»
		«IF null != getDiagram().palette»
		«showSizeOnDropFeedback»
		«adjustConstraint(getSideAffixedChildren)»
		«getExternalLabelsContainer»
		«ENDIF»
		«additions»
	'''

	override editPolicyName(GenNode it) 
		'''«getSideAffixedLayoutEditPolicyClassName»'''

	override supertypes(GenNode it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.policies.SideAffixedLayoutEditPolicy'''
	
}