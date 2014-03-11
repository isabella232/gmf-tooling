package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import diagram.policies.LayoutEditPolicy
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class CompartmentEditPart extends EditPartTemplate<GenCompartment> {

	@Inject extension Requests requests
	@Inject extension LayoutEditPolicy layoutEditPolicy
	@Inject extension NotationModelRefresher notationModelRefresher

	override body(GenCompartment it) '''
		«visualIDConstant»
		«clientFactoryAttribute»
		«ctors»
		«notSelectable»
		«getModelChildren»
		«declareViewCode»
		«createEditPolicies»
		«createSelectionHandles»
		«performRequest»
		«getTitleName»
		«createFigure»
		«getAdapter»
		«contentPane»
		«setupCompartmentHolder»
		«activate»
		«deactivate»
		«notationModelRefresher.all(it)»
		«additions»
	'''

	override supertypes(GenCompartment it) 
//		'''extends org.eclipse.gef.editparts.AbstractGraphicalEditPart implements org.eclipse.gmf.runtime.gwt.edit.parts.update.IUpdatableEditPart'''
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart'''

	def getModelChildren(GenCompartment it) '''
		«generatedMemberComment»
		@SuppressWarnings("unchecked")
		protected java.util.List<org.eclipse.gmf.runtime.notation.View> getModelChildren() {
			org.eclipse.gmf.runtime.notation.DrawerStyle style = (org.eclipse.gmf.runtime.notation.DrawerStyle) «getViewCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getDrawerStyle());
			if (style != null && style.isCollapsed()) {
				return Collections.<org.eclipse.gmf.runtime.notation.View> emptyList();
			}
			return (java.util.List<org.eclipse.gmf.runtime.notation.View>) «getViewCode».getVisibleChildren();
		}
	'''

	def createEditPolicies(GenCompartment it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new «layoutEditPolicy.qualifiedClassName(it)»());
			«behaviour(it)»
«««			«xpt::diagram::parts::NotationModelRefresher::installClause»
		}
	'''

	def createSelectionHandles(GenCompartment it) '''
		«generatedMemberComment('Returns the selection handles that should be contributed to the parent when it becomes selected.')»
		public java.util.List<? extends org.eclipse.gef.handles.AbstractHandle> createSelectionHandles() {
			«IF canCollapse»
			return java.util.Collections.singletonList(new org.eclipse.gmf.runtime.gwt.handles.CompartmentCollapseHandle(this, getTitleName()));
			«ELSE»
			return java.util.Collections.singletonList(new org.eclipse.gmf.runtime.gwt.handles.CompartmentNameHandle(this, getTitleName()));
			«ENDIF»
		}
	'''

	def getTitleName(GenCompartment it) '''
		«generatedMemberComment»
		protected String getTitleName() {
			«IF needsTitle»
			return "«title»";	
			«ELSE»
			return "";	
			«ENDIF»
		}
	'''

	def createFigure(GenCompartment it) '''
		«generatedMemberComment»
		public org.eclipse.draw2d.IFigure createFigure() {
			org.eclipse.draw2d.Figure result = new org.eclipse.gmf.runtime.gwt.figures.CompartmentFigure();
			result.setLayoutManager(new org.eclipse.draw2d.StackLayout());
			org.eclipse.draw2d.ScrollPane scrollPane = new org.eclipse.draw2d.ScrollPane();
			result.add(scrollPane);
			«IF listLayout»
			org.eclipse.draw2d.Viewport viewport = new org.eclipse.draw2d.Viewport();
			contentPane = new org.eclipse.draw2d.Figure();
			contentPane.setLayoutManager(new org.eclipse.draw2d.ToolbarLayout());
			«ELSE»
			org.eclipse.draw2d.Viewport viewport = new org.eclipse.draw2d.FreeformViewport();
			contentPane = new org.eclipse.draw2d.FreeformLayer();
			contentPane.setLayoutManager(new org.eclipse.draw2d.FreeformLayout());
			«ENDIF»
			viewport.setContents(contentPane);
			scrollPane.setViewport(viewport);
			return result;
		}
	'''

	def dispatch CharSequence setupCompartmentHolder(GenCompartment it) '''
		«viewmap.setupCompartmentHolder»
	'''

	def dispatch CharSequence setupCompartmentHolder(Viewmap it) ''''''

	def dispatch CharSequence setupCompartmentHolder(ParentAssignedViewmap it) '''
		«generatedMemberComment»
		public void setupCompartmentHolder(org.eclipse.draw2d.IFigure shape) {
			if (shape.getLayoutManager() == null) {
				shape.setLayoutManager(new org.eclipse.draw2d.StackLayout());
			}
		}
	'''

}
