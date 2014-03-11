package diagram.policies

import org.eclipse.gmf.codegen.gmfgen.GenContainerBase

class LayoutEditPolicy extends AbstractLayoutEditPolicy<GenContainerBase> {

	override body(GenContainerBase it) '''
		«getCreateCommand(getDirectChildren)»
		«createAddCommand(getDirectChildren)»
		«createCloneCommand(getDirectChildren)»
		«createChangeConstraintCommand(getDirectChildren)»
		«IF needsXYLayout() && (null != getDiagram().palette && getDirectChildren().size() > 0)»
		«showSizeOnDropFeedback»
		«adjustConstraint(getDirectChildren)»
		«ENDIF»
		«additions»
	'''

	override editPolicyName(GenContainerBase it) 
		'''«getLayoutEditPolicyClassName»'''

	override supertypes(GenContainerBase it) '''
		«IF needsXYLayout()»extends org.eclipse.gmf.runtime.gwt.edit.policies.XYLayoutEditPolicyEx«ELSE»extends org.eclipse.gmf.runtime.gwt.edit.policies.ListLayoutEditPolicy«ENDIF»
	'''

}