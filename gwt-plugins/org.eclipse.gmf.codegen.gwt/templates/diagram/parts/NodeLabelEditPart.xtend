package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel

class NodeLabelEditPart extends EditPartTemplate<GenNodeLabel> {

	@Inject LabelController labelController
	@Inject Requests requests
	@Inject Refresh refresh

    override body(GenNodeLabel it) '''
		«visualIDConstant»
		«clientFactoryAttribute»
		«ctors»
		«notSelectable»
		«declareViewCode»
		«createEditPolicies»
		«refresh.labelRefresher(it)»
		«refresh.refreshVisuals(it)»
		«refresh.refreshLabel(it)»
		«requests.performRequest(it)»
		«labelController.directEditManager(it)»
		«labelController.performDirectEdit(it)»
		«labelController.labelDisplayer(it)»
		«labelController.labelText(it)»
		«labelController.labelIcon(it)»
		«labelController.labelFigure(viewmap, it)»
		«labelController.getUpdatableParent(it)»
		«activate»
		«deactivate»
		«viewmap.viewmap»
		«additions»
	'''

	def dispatch supertypes(GenNodeLabel it) 
		'''extends org.eclipse.gef.editparts.AbstractGraphicalEditPart implements org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController'''

	def dispatch supertypes(GenExternalNodeLabel it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.labels.BaseExternalNodeLabelEditPart implements org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController'''
	
	def createEditPolicies(GenNodeLabel it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			«createSuperEditPolicies»
			«IF !isReadOnly()»
			installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.LabelDirectEditPolicy());
			«ENDIF»
			«behaviour(it)»
		}
	'''

	def dispatch createSuperEditPolicies(GenNodeLabel it) ''''''
	
	def dispatch createSuperEditPolicies(GenExternalNodeLabel it) '''
		super.createEditPolicies();
	'''
}