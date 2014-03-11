package diagram.parts

import com.google.inject.Inject
import common.Common
import diagram.Helper
import org.eclipse.gmf.codegen.gmfgen.Behaviour
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour
import org.eclipse.gmf.codegen.gmfgen.SharedBehaviour
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class PartCommon {

	extension Helper= new Helper
	extension Common = new Common
	extension CommonHelper = new CommonHelper
//	extension LinkNotationModelRefresherHelper = new LinkNotationModelRefresherHelper
	extension NotationModelRefresherHelper = new NotationModelRefresherHelper

//	@Inject extension LinkNotationModelRefresher linkModelRefresher
	@Inject extension NotationModelRefresher modelRefresher
	@Inject extension LabelController labelController 

	def visualIDConstant(GenCommonBase base) 
	'''
		«generatedMemberComment»
		public static final int VISUAL_ID = «base.visualID»;
	'''

	def modelIDConstant(GenDiagram diagram) 
	'''
		«generatedMemberComment»
		public static String MODEL_ID = "«diagram.editorGen.modelID»";
	'''
	
	def clientFactoryAttribute(GenCommonBase it)
	'''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory;
	'''

	def registerModel(GenCommonBase it) '''
		«generatedMemberComment»
		protected void registerModel() {
			super.registerModel();
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getModel();
			if (view != null && view.isSetElement() && view.getElement() != null) {
				getViewer().getEditPartRegistry().put(view.getElement(), this);
			}
		}

		«generatedMemberComment»
		protected void unregisterModel() {
			super.unregisterModel();
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getModel();
			if (view != null && view.isSetElement() && view.getElement() != null) {
				if(getViewer().getEditPartRegistry().get(view.getElement()) == this) {
					getViewer().getEditPartRegistry().remove(view.getElement());
				}
			}
		}
	'''

	def getAdapter(GenCommonBase it) '''
		«generatedMemberComment»
		@Override
		public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
			«snapToAdapter»
			«externalChildPositionTrackerAdapter»
			«getAdapterAdditions»
			return super.getAdapter(key);
		}
	'''
	
	def getAdapterAdditions(GenCommonBase it) ''''''
	
	def dispatch snapToAdapter(GenCommonBase it) ''''''
	
	def dispatch snapToAdapter(GenContainerBase it) '''
		«IF needsXYLayout»
		if (org.eclipse.gef.SnapToHelper.class == key) {
			return new org.eclipse.gef.SnapToGrid(this);
		}
		«ENDIF»
	'''
	
	def dispatch externalChildPositionTrackerAdapter(GenCommonBase it) ''''''
	
	def dispatch externalChildPositionTrackerAdapter(GenChildSideAffixedNode it) '''
		if (org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker.class == key) {
			return getPositionTracker();
		}
	'''

	def dispatch externalChildPositionTracker(GenCommonBase it) ''''''

	def dispatch externalChildPositionTracker(GenChildSideAffixedNode it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker myPositionTracker;

		«generatedMemberComment»
		public org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker getPositionTracker() {
			if (myPositionTracker == null) {
				myPositionTracker = new org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker(this);
			}
			return myPositionTracker;
		}
	'''
	
	def dispatch CharSequence behaviour(GenCommonBase it) '''«FOR b: behaviour»«b.behaviour»«ENDFOR»'''
	
	def dispatch CharSequence behaviour(Behaviour it) ''''''
	
	def dispatch CharSequence behaviour(SharedBehaviour it) '''«delegate.behaviour»'''
	
	def dispatch CharSequence behaviour(CustomBehaviour it) '''
		installEditPolicy(«key», new «getEditPolicyQualifiedClassName()»());
	'''

	def dispatch CharSequence behaviour(OpenDiagramBehaviour it) '''
		installEditPolicy(org.eclipse.gmf.runtime.gwt.edit.policies.EditPolicyRoles.OPEN_ROLE, new «getEditPolicyQualifiedClassName()»());
	'''
	
	def dispatch CharSequence viewmap(Viewmap it) ''''''
	
	def dispatch CharSequence viewmap(InnerClassViewmap it) '''
		«classBody»
		«mapModeWorkaround»
	'''
	
	def mapModeWorkaround(InnerClassViewmap it) '''
		«IF classBody.matches('.*[DL]Pto[LD]P.*')»
		«generatedClassComment»
		private static class MapModeWorkaround {
		
			«generatedMemberComment»
			public int DPtoLP(int dp) {
				return dp;
			}

			«generatedMemberComment»
			public int LPtoDP(int lp) {
				return lp;
			}

			«generatedMemberComment»
			public static MapModeWorkaround INSTANCE = new MapModeWorkaround();
		}
		
		«generatedMemberComment»
		private MapModeWorkaround getMapMode() {
			return MapModeWorkaround.INSTANCE;
		}
		«ENDIF»
	'''
	
	def dispatch declareViewCode(GenCommonBase it) '''«declareViewCode("org.eclipse.gmf.runtime.notation.Node")»'''
	def dispatch declareViewCode(GenDiagram it) '''«declareViewCode("org.eclipse.gmf.runtime.notation.Diagram")»'''
	def dispatch declareViewCode(GenLink it) '''«declareViewCode("org.eclipse.gmf.runtime.notation.Edge")»'''

	def declareViewCode(GenCommonBase it, String expectedModelType) '''
		«generatedMemberComment»
		public «expectedModelType» «getViewCode» {
			return («expectedModelType») getModel();
		}
	'''

	def contentPane(GenChildContainer it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure contentPane;

		«generatedMemberComment»
		public org.eclipse.draw2d.IFigure getContentPane() {
			if (contentPane == null) {
				return super.getContentPane();
			}
			return contentPane;
		}
	'''

	def dispatch ctors(GenCommonBase it) 
	'''
		«ctors('org.eclipse.gmf.runtime.notation.Node')»
	'''

	def dispatch ctors(GenLink it) 
	'''
		«ctors('org.eclipse.gmf.runtime.notation.Edge')»
	'''
	
	def ctors(GenCommonBase it, String expectedModelType) 
	'''
		«generatedClassComment»
		public «editPartClassName»(org.eclipse.gmf.runtime.notation.View model, org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory) {
			assert model instanceof «expectedModelType»;
			setModel(model);
			this.clientFactory = clientFactory;
		}

	'''

	def dispatch ctors(GenDiagram it) '''
		«generatedClassComment»
		public «editPartClassName»(org.eclipse.gmf.runtime.notation.Diagram model, org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory) {
			setModel(model);
			this.clientFactory = clientFactory;
		}
	'''

	def dispatch ctors(GenLinkLabel it) 
	'''
		«invokeSuperCtor»
	'''

	def dispatch ctors(GenExternalNodeLabel it)  
	'''
		«invokeSuperCtor»
	'''

	def invokeSuperCtor(GenCommonBase it) 
	'''
		«generatedClassComment»
		public «editPartClassName»(org.eclipse.gmf.runtime.notation.View model, org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory) {
			super(model);
			this.clientFactory = clientFactory;
		}
	'''
	
	def dispatch getViewCode(GenCommonBase it) '''getDiagramNode()'''

	def dispatch getViewCode(GenDiagram it) '''getDiagram()'''

	def dispatch getViewCode(GenLink it) '''getDiagramEdge()'''

	def dispatch getDiagramCode(GenCommonBase it) '''«getViewCode».getDiagram()'''

	def dispatch getDiagramCode(GenDiagram it) '''«getViewCode»'''

	def getDiagramElementCode(GenCommonBase it) '''«getDiagramCode».getElement()'''

	def dispatch getModelChildren(GenCommonBase it) '''
		«generatedMemberComment»
		protected java.util.List getModelChildren() {
			return «getViewCode».getVisibleChildren();
		}
	'''
	
	def getModelSourceConnections(GenCommonBase it) '''
		«generatedMemberComment»
		protected java.util.List getModelSourceConnections() {
			return «getViewCode».getSourceEdges();
		}
	'''

	def dispatch getModelTargetConnections(GenCommonBase it) '''
		«generatedMemberComment»
		protected java.util.List getModelTargetConnections() {
			return «getViewCode».getTargetEdges();
		}
	'''

	def dispatch getModelChildren(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected java.util.List getModelChildren() {
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def dispatch getModelTargetConnections(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected java.util.List getModelTargetConnections() {
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def notSelectable(GenCommonBase it) '''
		«IF !isSelectable()»
		«generatedMemberComment»
		public boolean isSelectable() {
			return false;
		}
		«ENDIF»
	'''

	def CharSequence activate(GenCommonBase it) '''
		«generatedMemberComment»
		public void activate() {
			super.activate();
			«activateAdditions»
		}
	'''

	def dispatch activateAdditions(GenCommonBase it) ''''''

	def dispatch activateAdditions(GenContainerBase it) '''
		«activateRefreshers»
	'''
	
	def dispatch activateAdditions(GenDiagram it) '''
		«activateRefreshers»
	'''
	
	def dispatch activateAdditions(GenLabel it) '''
		«labelController.activateAdditions(it)»
	'''

	def dispatch activateAdditions(GenChildLabelNode it) '''
		installRefresher(getLabelRefresher());
	'''

	def dispatch activateRefreshers(GenDiagram it) ''''''

	def dispatch activateRefreshers(GenContainerBase it) '''
«««		«IF needsLinkNotationModelRefresher»
«««			«linkModelRefresher.install(it)»
«««		«ENDIF»
		«IF needsNotationModelRefresher»
			«modelRefresher.install(it)»
		«ENDIF»
«««		«domainModelRefresher::activate»
«««		«NotationModelRefresher::installClause»
«««		«LinkNotationModelRefresher::installClause»
	'''

	def deactivate(GenCommonBase it) '''
		«generatedMemberComment»
		public void deactivate() {
			«deactivateAdditions»
			super.deactivate();
		}
	'''
	
	def dispatch deactivateAdditions(GenCommonBase it) ''''''
	
	def dispatch deactivateAdditions(GenContainerBase it) '''
«««		«deactivateRefreshers»
	'''
	
	def dispatch deactivateAdditions(GenDiagram it) ''''''

	def dispatch deactivateAdditions(GenLabel it) '''
		«labelController.deactivateAdditions(it)»
	'''

	def dispatch deactivateAdditions(GenChildLabelNode it) '''
		uninstallRefresher(getLabelRefresher());
	'''

}
