package diagram.parts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import common.Common

class Requests {

	extension CommonHelper = new CommonHelper
	extension Common = new Common
	extension LabelControllerHelper = new LabelControllerHelper

	@Inject extension PartCommon

	def performRequest(GenCommonBase it) '''
		«generatedMemberComment»
		public void performRequest(org.eclipse.gef.Request req) {
			«performOpen»
			«performDirectEdit»
			super.performRequest(req);
		}
	'''

	def dispatch performOpen(GenCommonBase it) '''
		if (org.eclipse.gef.RequestConstants.REQ_OPEN.equals(req.getType())) {
			org.eclipse.gef.commands.Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
	'''

	def dispatch performOpen(GenDiagram it) ''''''

	def dispatch CharSequence performDirectEdit(GenCommonBase it) ''''''

	def dispatch CharSequence performDirectEdit(GenLabel it) '''
		«IF !isReadOnly()»
		«performLabelDirectEdit»
		«ENDIF»
	'''

	def dispatch CharSequence performDirectEdit(GenChildLabelNode it) '''
		«IF !isReadOnly()»
		«performLabelDirectEdit»
		«ENDIF»
	'''
	
	def dispatch CharSequence performDirectEdit(GenNode it) '''
		«performDelegatingDirectEdit»
	'''

	def dispatch CharSequence performDirectEdit(GenLink it) '''
		«performDelegatingDirectEdit»
	'''

	def performLabelDirectEdit(GenCommonBase it) '''
		if (org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT.equals(req.getType()) && understandsRequest(req)) {
			performDirectEdit();
			return;
		}
	'''

	def performDelegatingDirectEdit(GenCommonBase it) '''
		«IF getPrimaryLabel() != null»
		if (org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())) {
			org.eclipse.gef.EditPart labelToEdit;
			if (req instanceof org.eclipse.gef.requests.DirectEditRequest) {
				labelToEdit = getLabelEditPart((org.eclipse.gef.requests.DirectEditRequest) req);
			} else {
				labelToEdit = getPrimaryLabelEditPart();
			}
			if (labelToEdit != null) {
				labelToEdit.performRequest(req);
			}
		}
		«ENDIF»
	'''

	def getLabelEditPart(GenCommonBase it) '''
		«IF getPrimaryLabel() != null»
		«generatedMemberComment»
		private org.eclipse.gef.EditPart getLabelEditPart(org.eclipse.gef.requests.DirectEditRequest req) {
			org.eclipse.gef.EditPart result = getViewer().findObjectAt(req.getLocation());
			if (result != null) {
				if («getViewCode».getChildren().contains(result.getModel())) {
					org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) result.getModel();
					int visualId = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(view);
					switch (visualId) {
					«FOR l: getAllLabels.filter(e | !e.readOnly)»«l.returnLabelEditPart»«ENDFOR»
					}
				}
			}
			return getPrimaryLabelEditPart();
		}
		«ENDIF»
	'''

	def returnLabelEditPart(GenLabel it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			return result;
	'''

	def getPrimaryLabelEditPart(GenCommonBase it) '''
		«IF getPrimaryLabel() != null»
		«generatedMemberComment('Returns the label which should be direct-edited by default.')»
		private org.eclipse.gef.EditPart getPrimaryLabelEditPart() {
			for(java.util.Iterator<?> it = «getViewCode».getChildren().iterator(); it.hasNext(); ) {
				org.eclipse.gmf.runtime.notation.View nextChild = (org.eclipse.gmf.runtime.notation.View)it.next();
				if («getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(nextChild) == «getPrimaryLabel().getEditPartQualifiedClassName()».VISUAL_ID) {
					return (org.eclipse.gef.EditPart) getViewer().getEditPartRegistry().get(nextChild);
				}
			}
			return null;
		}
		«ENDIF»
	'''
}
