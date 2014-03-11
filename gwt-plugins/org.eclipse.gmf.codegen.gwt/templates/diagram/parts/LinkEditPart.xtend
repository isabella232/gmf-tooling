package diagram.parts

import com.google.inject.Inject
import common.Common
import common.EditPartTemplate
import diagram.policies.ComponentEditPolicy
import diagram.policies.ConnectionEndpointEditPolicy
import diagram.policies.GraphicalNodeEditPolicy
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class LinkEditPart extends EditPartTemplate<GenLink> {

	extension CommonHelper = new CommonHelper
	extension Common = new Common

	@Inject extension PartCommon
	@Inject extension ComponentEditPolicy componentEditPolicy
	@Inject extension ConnectionEndpointEditPolicy connectionEndpointEditPolicy
	@Inject extension GraphicalNodeEditPolicy graphicalNodeEditPolicy
	@Inject extension Requests requests
	@Inject extension Decorations decorations

	override body(GenLink it) '''
		«visualIDConstant»
		«clientFactoryAttribute»
		«ctors»
«««		«getModelChildren»
«««		«getModelSourceConnections»
«««		«getModelTargetConnections»
«««		«connectionAnchors»
		«decorationManager»
		«createEditPolicies»
		«getPrimaryLabelEditPart»
		«performRequest»
		«getLabelEditPart»
		«getAdapter»
		«activate»
		«deactivate»
		«new Refresh().refreshVisuals(it)»
		«addNotify»
		«createFigure»
		«createDecorationManager»
		«primCreateFigure»
		«viewmap.viewmap»
		«additions»
	'''
	
	override supertypes(GenLink it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.BaseConnectionNodeEditPart'''

	def createEditPolicies(GenLink it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			installEditPolicy(org.eclipse.gef.EditPolicy.COMPONENT_ROLE, new «componentEditPolicy.qualifiedClassName(it)»());
			installEditPolicy(org.eclipse.gef.EditPolicy.CONNECTION_ENDPOINTS_ROLE, «IF labels.size() > 0»new «connectionEndpointEditPolicy.qualifiedClassName(it)»()«ELSE»new org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy()«ENDIF»);
			installEditPolicy(org.eclipse.gef.EditPolicy.CONNECTION_BENDPOINTS_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.BendpointEditPolicy());
			«IF getPrimaryLabel != null»
			installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy());
			«ENDIF»
			installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new «graphicalNodeEditPolicy.qualifiedClassName(it)»());
			«behaviour(it)»
«««			«LinkNotationModelRefresher::installClause»
		}
	'''

	def addNotify(GenLink it) '''
		«generatedMemberComment»
		public void addNotify() {
			super.addNotify();
			getConnectionFigure().setConnectionRouter(«instantiateConnectionRouter»);
		}
	'''
	
	def instantiateConnectionRouter(GenLink it) '''new org.eclipse.draw2d.BendpointConnectionRouter()'''
	
	def createFigure(GenLink it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFigure() {
			org.eclipse.draw2d.Connection result = primCreateFigure();
			myDecorationManager = createDecorationManager(result);
			return result;
		}
	'''
	
	def dispatch CharSequence primCreateFigure(GenLink it) '''
«««		«xpt::Common::generatedMemberComment('Creates figure for this edit part.\n\n' + 
«««		'Body of this method does not depend on settings in generation model\n' + 
«««		'so you may safely remove <i>generated</i> tag and modify it.\n')»
		private org.eclipse.draw2d.Connection primCreateFigure() {
			«viewmap.primCreateFigure»
		}
	'''

	def dispatch CharSequence primCreateFigure(Viewmap it) { throw new IllegalStateException('Unexpected viewmap type ' + it) }

	def dispatch CharSequence primCreateFigure(FigureViewmap it) '''
		return new «if (figureQualifiedClassName == null) 'org.eclipse.draw2d.PolylineConnection' else figureQualifiedClassName»();
	'''

	def dispatch CharSequence primCreateFigure(SnippetViewmap it) '''
		return «body»;
	'''

	def dispatch CharSequence primCreateFigure(InnerClassViewmap it) '''
		return new «className»();
	'''
	
	def connectionAnchors(GenLink it) '''
		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
			return new org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor(getConnectionFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.Request request) {
			return new org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor(getConnectionFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
			return new org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor(getConnectionFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getTargetConnectionAnchor(org.eclipse.gef.Request request) {
			return new org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor(getConnectionFigure());
		}
	'''

}
