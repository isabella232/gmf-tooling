package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import diagram.policies.LayoutEditPolicy
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

class DiagramEditPart extends EditPartTemplate<GenDiagram> {

	@Inject extension LayoutEditPolicy layoutEditPolicy

	override body(GenDiagram it) '''
		«modelIDConstant»
		«visualIDConstant»
		«clientFactoryAttribute»
		«ctors»
		«declareViewCode»
		«createEditPolicies»
		«createFigure»
		«getDragTracker»
		«getAdapter»
		«activate»
		«deactivate»
		«additions»
	'''

	override supertypes(GenDiagram it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.BaseDiagramEditPart'''
	
	def createFigure(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFigure() {
			org.eclipse.draw2d.IFigure f = new org.eclipse.draw2d.ScalableFreeformLayeredPane();
			f.setBorder(new org.eclipse.draw2d.MarginBorder(5));
			f.setOpaque(true);
			f.setBackgroundColor(new org.eclipse.swt.graphics.Color(null, 254, 254, 254));
			f.setLayoutManager(new org.eclipse.draw2d.FreeformLayout());
			return f;
		}
	'''

	def getDragTracker(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.gef.DragTracker getDragTracker(org.eclipse.gef.Request request) {
			return new org.eclipse.gef.tools.MarqueeDragTracker() {
				protected boolean handleButtonDown(int button) {
					if (super.handleButtonDown(button)) {
						getViewer().setSelection(org.eclipse.jface.viewers.StructuredSelection.EMPTY);
						getViewer().setFocus(null);
						return true;
					}
					return false;
				}
			};
		}
	'''
	
	def createEditPolicies(GenDiagram it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			installEditPolicy(org.eclipse.gef.EditPolicy.COMPONENT_ROLE, new org.eclipse.gef.editpolicies.RootComponentEditPolicy());
			installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new «layoutEditPolicy.qualifiedClassName(it)»());
			«behaviour(it)»
«««			«new NotationModelRefresher().installClause(it)»
«««			«new LinkNotationModelRefresher().installClause(it)»
		}
	'''

}