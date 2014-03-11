package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel

class LinkLabelEditPart extends EditPartTemplate<GenLinkLabel> {

	@Inject extension PartCommon
	@Inject extension Refresh
	@Inject extension Requests
	@Inject extension LabelController labelController

	override body(GenLinkLabel it) '''
		«visualIDConstant»
		«clientFactoryAttribute»
		«ctors»
		«declareViewCode»
		«createEditPolicies»
		«refresher»
		«performRequest»
		«directEditManager»
		«labelController.performDirectEdit(it)»
		«labelDisplayer»
		«labelText»
		«labelIcon»
		«viewmap.labelFigure(it)»
		«getUpdatableParent»
		«activate»
		«deactivate»
		«getAlignment(it)»
		«viewmap.viewmap»
		«additions»
	'''
	
	override supertypes(GenLinkLabel it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.labels.BaseLinkLabelEditPart implements org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController'''
	
	def createEditPolicies(GenLinkLabel it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			super.createEditPolicies();
			«IF !isReadOnly()»
			installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.LabelDirectEditPolicy());
			«ENDIF»
			«behaviour(it)»
		}
	'''
	
	def getAlignment(GenLinkLabel it) '''
		«generatedMemberComment»
		protected int getAlignment() {
			return org.eclipse.draw2d.ConnectionLocator.«alignment»;
		}
	'''

}
