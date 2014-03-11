package diagram.policies

import com.google.inject.Inject
import commands.DomainModelRemoveCommand
import common.EditPolicyTemplate
import diagram.LinkFinder
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode

class ComponentEditPolicy extends EditPolicyTemplate<GenCommonBase> {

	extension LinkFinder = new LinkFinder

	@Inject extension DomainModelRemoveCommand

	override body(GenCommonBase it) '''		
		«createDeleteCommand»
		«getDeleteViewCommand»
		«canDeleteView»
		«IF needsGetGraphicalEditPart»
		«getGraphicalEditPart»
		«ENDIF»
		«domainModelRemoveCommand»
		«getDiagramElement»
		«additions»
	'''

	override editPolicyName(GenCommonBase it) 
		'''«getComponentEditPolicyClassName»'''

	override supertypes(GenCommonBase it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.policies.ComponentEditPolicyEx'''

	def dispatch CharSequence domainModelRemoveCommand(GenCommonBase it) {
		throw new IllegalStateException('Unexpected type!')
	}
	
	def dispatch CharSequence domainModelRemoveCommand(GenNode it) 
		'''«domainModelRemoveCommand('getDiagramNode()')»'''
	
	def dispatch CharSequence domainModelRemoveCommand(GenLink it) 
		'''«domainModelRemoveCommand('getDiagramEdge()')»'''

	def dispatch getDiagramElement(GenCommonBase it) {
		throw new IllegalStateException('Unexpected type!')
	}
	
	def dispatch getDiagramElement(GenNode it) '''«getDiagramNode»'''
	
	def dispatch getDiagramElement(GenLink it) '''«getDiagramEdge»'''

	def createDeleteCommand(GenCommonBase it) {
		val incomingTypeLinks = incomingTypeLinks
		val outgoingLinks = outgoingNonPhantomLinks
		'''
			«generatedMemberComment»
			protected org.eclipse.gef.commands.Command createDeleteCommand(org.eclipse.gef.requests.GroupRequest deleteRequest) {
				org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(«getDiagramElementMethodName»().getDiagram().getElement());
				«IF incomingTypeLinks.size() > 0 || outgoingLinks.size() > 0»
				org.eclipse.gmf.runtime.gwt.commands.CompositeWrappingCommand result = new org.eclipse.gmf.runtime.gwt.commands.CompositeWrappingCommand(editingDomain, "Delete Element");
				«ENDIF»

				«deleteIncomingLinks(incomingTypeLinks, true)»

				«deleteOutgoingLinks(outgoingLinks, true)»

				«createDeleteCommandPrim(true)»
				«IF incomingTypeLinks.size() > 0 || outgoingLinks.size() > 0»
				result.add(cc);
				return result;
				«ELSE»
				return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(editingDomain, cc);
				«ENDIF»
			}
		'''	
	}
	
	def deleteIncomingLinks(GenCommonBase it, Iterable<GenLink> incomingLinks, Boolean deleteFromModel) '''
		«IF incomingLinks.size() > 0»
		for(Object next: getGraphicalEditPart().getTargetConnections()) {
			org.eclipse.gef.EditPart nextEditPart = (org.eclipse.gef.EditPart) next;
			org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) nextEditPart.getModel();
			int visualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(nextEdge);
			switch (visualID) {
				«FOR nextLink: incomingLinks»
				case «nextLink.getEditPartQualifiedClassName()».VISUAL_ID:
				«ENDFOR»
				«deleteDependentLinks(deleteFromModel)»
			}
		}
		«ENDIF»
	'''
	
	def deleteOutgoingLinks(GenCommonBase it, Iterable<GenLink> outgoingLinks, Boolean deleteFromModel) '''
		«IF outgoingLinks.size() > 0»
		for(Object next: getGraphicalEditPart().getSourceConnections()) {
			org.eclipse.gef.EditPart nextEditPart = (org.eclipse.gef.EditPart) next;
			org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) nextEditPart.getModel();
			int visualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(nextEdge);
			switch (visualID) {
				«FOR nextLink: outgoingLinks»
				case «nextLink.getEditPartQualifiedClassName()».VISUAL_ID:
				«ENDFOR»
				«deleteDependentLinks(deleteFromModel)»
			}
		}
		«ENDIF»
	'''
	
	def deleteDependentLinks(GenCommonBase it, Boolean deleteFromModel) '''
	{
		org.eclipse.gef.requests.GroupRequest deleteLinkRequest = new org.eclipse.gef.requests.GroupRequest(«IF deleteFromModel»org.eclipse.gef.RequestConstants.REQ_DELETE«ELSE»org.eclipse.gmf.runtime.gwt.requests.RequestConstants.REQ_FORCED_DELETE_VIEW«ENDIF»);
		deleteLinkRequest.setEditParts(nextEditPart);
		result.add(nextEditPart.getCommand(deleteLinkRequest));
		break;
	}
	'''
	
	def getGraphicalEditPart(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.GraphicalEditPart getGraphicalEditPart() {
			return (org.eclipse.gef.GraphicalEditPart) getHost();
		}
	'''

	def dispatch createDeleteCommandPrim(GenCommonBase it, Boolean deleteFromModel) {
		throw new IllegalStateException('UnexpectedType')
	}
	
	def dispatch createDeleteCommandPrim(GenNode it, Boolean deleteFromModel) '''
		final org.eclipse.emf.common.command.CompoundCommand cc = new org.eclipse.emf.common.command.CompoundCommand();
		«IF deleteFromModel»
		cc.append(createDomainModelRemoveCommand(editingDomain));
		«ENDIF»
		cc.append(new org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand((org.eclipse.gmf.runtime.notation.View) «getDiagramElementMethodName»().eContainer(), «getDiagramElementMethodName»()));
	'''
	
	def dispatch createDeleteCommandPrim(GenLink it, Boolean deleteFromModel) '''
		final org.eclipse.emf.common.command.CompoundCommand cc = new org.eclipse.emf.common.command.CompoundCommand();
		«IF deleteFromModel»
		cc.append(createDomainModelRemoveCommand(editingDomain));
		«ENDIF»
		cc.append(new org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalEdgeCommand(«getDiagramElementMethodName»().getDiagram(), «getDiagramElementMethodName»()));
	'''
	
	def dispatch getDiagramElementMethodName(GenCommonBase it) {
		throw new IllegalStateException('Unexpected type: ' + it)
	}
	
	def dispatch getDiagramElementMethodName(GenNode it) '''getDiagramNode'''
	
	def dispatch getDiagramElementMethodName(GenLink it) '''getDiagramEdge'''
	
	def getDiagramNode(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.notation.Node «getDiagramElementMethodName»() {
			return (org.eclipse.gmf.runtime.notation.Node) getHost().getModel();
		}
	'''

	def getDiagramEdge(GenLink it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.notation.Edge «getDiagramElementMethodName»() {
			return (org.eclipse.gmf.runtime.notation.Edge) getHost().getModel();
		}
	'''
	
	def getDeleteViewCommand(GenCommonBase it) {
		val incomingLinks = incomingLinks
		val outgoingLinks = outgoingLinks
		'''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getDeleteViewCommand(org.eclipse.gef.requests.GroupRequest deleteRequest, boolean isForced) {
			if (!isForced && !canDeleteView()) {
				return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
			}
			org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(«getDiagramElementMethodName»().getDiagram().getElement());
			«IF incomingLinks.size() > 0 || outgoingLinks.size() > 0»
			org.eclipse.gmf.runtime.gwt.commands.CompositeWrappingCommand result = new org.eclipse.gmf.runtime.gwt.commands.CompositeWrappingCommand(editingDomain, null);
			«ENDIF»
			«deleteIncomingLinks(incomingLinks, false)»
			«deleteOutgoingLinks(outgoingLinks, false)»
			«createDeleteCommandPrim(false)»
			«IF incomingLinks.size() > 0 || outgoingLinks.size() > 0»
			result.add(cc);
			return result;
			«ELSE»
			return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(editingDomain, cc);
			«ENDIF»
		}
		'''
	}
	
	def dispatch CharSequence canDeleteView(GenCommonBase it) {
		throw new IllegalStateException('Unexpected Type: ' + it)
	}

	def dispatch CharSequence canDeleteView(GenNode it) '''
		«generatedMemberComment»
		private boolean canDeleteView() {
			if («getDiagramElementMethodName»().getEAnnotation("Shortcut") != null) {
				return true;
			}
			org.eclipse.gmf.runtime.notation.View parentView = (org.eclipse.gmf.runtime.notation.View) «getDiagramElementMethodName»().eContainer();
			if (parentView == null) {
				return true;
			}
			org.eclipse.gmf.runtime.notation.CanonicalStyle canonicalStyle = (org.eclipse.gmf.runtime.notation.CanonicalStyle) parentView.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getCanonicalStyle());
			if (canonicalStyle != null) {
				return !canonicalStyle.isCanonical();
			}
			return «!getDiagram().synchronized»;
		}
	'''

	def dispatch CharSequence canDeleteView(GenLink it) '''
		«generatedMemberComment»
		private boolean canDeleteView() {
			return false;
		}
	'''

	private def needsGetGraphicalEditPart(GenCommonBase it) {
		outgoingLinks.size() > 0 || incomingLinks.size() > 0
	}

}
