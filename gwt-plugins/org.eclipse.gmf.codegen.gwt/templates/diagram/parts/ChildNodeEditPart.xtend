package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import diagram.policies.ComponentEditPolicy
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode

class ChildNodeEditPart extends EditPartTemplate<GenChildLabelNode> {

	extension LabelControllerHelper = new LabelControllerHelper

	@Inject LabelController labelController
	@Inject Requests requests
	@Inject Refresh refresh
	@Inject ComponentEditPolicy componentEditPolicy

	override supertypes(GenChildLabelNode it) 
		'''extends org.eclipse.gef.editparts.AbstractGraphicalEditPart implements org.eclipse.gmf.runtime.gwt.edit.parts.update.IUpdatableEditPart, org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart, org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController'''

	override protected body(GenChildLabelNode it) '''
		«visualIDConstant»

		«clientFactoryAttribute»

		«ctors»

		«isSelectable»

		«declareViewCode»

		«registerModel»

		«createEditPolicies»

		«requests.performRequest(it)»

		«getModelChildren»

		«getModelSourceConnections»

		«getModelTargetConnections»
		
		«getAdapter»

		«activate»

		«deactivate»

		«refresh.refresher(it)»

		«refresh.externalRefreshers(it)»
		
		«labelController.directEditManager(it)»

		«labelController.performDirectEdit(it)»

		«labelController.labelDisplayer(it)»

		«labelController.labelText(it)»

		«labelController.labelIcon(it)»

		«labelController.labelFigure(viewmap, it)»
		
		«viewmap.viewmap»

		«additions»
	'''

	def isSelectable(GenChildLabelNode it) '''
		«generatedMemberComment»
		public boolean isSelectable() {
			if (!super.isSelectable()) {
				return false;
			}
			if (!isActive()) {
				return false;
			}
			if (getViewer().getContents().equals(getViewer().getFocusEditPart())) {
				return false;
			}
			return true;
		}
	'''
	
	def createEditPolicies(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
		«IF !isReadOnly()»
			installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.LabelDirectEditPolicy());
		«ENDIF»
			installEditPolicy(org.eclipse.gef.EditPolicy.COMPONENT_ROLE, new «componentEditPolicy.qualifiedClassName(it)»());
			installEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE, new org.eclipse.gef.editpolicies.SelectionEditPolicy() {
				@Override
				protected void showSelection() {
					clientFactory.getEventBus().fireEvent(new org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent(«qualifiedClassName».this));
				}
				@Override
				protected void hideSelection() {
					clientFactory.getEventBus().fireEvent(new org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent(«qualifiedClassName».this));
				}
			});
			«behaviour(it)»
		}
	'''

}