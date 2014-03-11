package commands

import com.google.inject.Inject
import common.CommandTemplate
import diagram.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.ecore.EReference
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet

class ReconnectLinkSourceCommand extends CommandTemplate<GenLink> {
	
	extension MetaModel = new MetaModel

	@Inject extension CommandCommon
	@Inject extension DomainModelRemoveCommand

	override body(GenLink it) '''
		«attributes»
		«ctors»
		«prepare»
		«canReconnect»
		«createCommand»
		«modelFacet.getRelationshipContainer»
		«IF creationConstraints != null»
		«domainModelRemoveCommand('edge')»
		«ENDIF»
		«additions»
	'''
	
	override commandName(GenLink it) 
		'''Reconnect«commandNameInfix»SourceCommand'''

	override supertypes(GenLink it) 
		'''extends org.eclipse.emf.common.command.CommandWrapper'''

	def attributes(GenLink it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.Edge edge;

		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View newSource;

		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View oldSource;
	'''
	
	def ctors(GenLink it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gef.requests.ReconnectRequest request) {
			this((org.eclipse.gmf.runtime.notation.Edge)request.getConnectionEditPart().getModel(), (org.eclipse.gmf.runtime.notation.View)request.getTarget().getModel());
		}

		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.Edge edge, org.eclipse.gmf.runtime.notation.View newSource) {
			this.edge = edge;
			this.newSource = newSource;
			this.oldSource = edge.getSource();
		}
	'''

	def prepare(GenLink it) '''
		«generatedMemberComment»
		protected boolean prepare() {
			«IF creationConstraints == null»
			if (!canReconnect()) {
				return false;
			}
			return super.prepare();
			«ELSE»
			final boolean[] resultHolder = new boolean[1];

			//To validate the reconnection against constraints, the current link should be deleted. Of course, we must then undo its deletion.
			final org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(oldTarget.getDiagram().getElement());
			org.eclipse.emf.common.command.Command command = new org.eclipse.emf.common.command.AbstractCommand() {
				private org.eclipse.emf.common.command.Command deleteCommand = createDomainModelRemoveCommand(editingDomain);
				public boolean canExecute() {
					return deleteCommand.canExecute();
				}
				public boolean canUndo() {
					return true;
				}
				public void redo() {
				}
				public void undo() {
				}
				public void execute() {
					deleteCommand.execute();
					try {
						resultHolder[0] = canReconnect();
					} finally {
						deleteCommand.undo();
					}
				}
			};
			if (!command.canExecute()) {
				return false;
			}
			new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(editingDomain, command).execute();
			if (!resultHolder[0]) {
				return false;
			}

			return super.prepare();
			«ENDIF»
		}
	'''
	
	def dispatch CharSequence canReconnect(GenLink it) '''
		«generatedMemberComment»
		private boolean canReconnect() {
			«creationConstraints.checkLinkConstraints('newSource.getElement()', 'edge.getTarget().getElement()')»
			«modelFacet.canReconnect»
		}
	'''
	
	def dispatch CharSequence canReconnect(LinkModelFacet it) '''
		return false;
	'''
	
	def dispatch CharSequence canReconnect(TypeLinkModelFacet it) {
		val setChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		val d = if (setChild) (sourceMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature 
		val c = (sourceMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature && d
		val b = (sourceMetaFeature.referenceType && c) 
		val a = (!sourceMetaFeature.ecoreFeature.derived && b)
		val setSource = sourceMetaFeature != null && a
		val sourceReverseFeature = sourceMetaFeature.reverse

		'''
			«IF containmentMetaFeature == null»
			return false;
			«ELSE»
			org.eclipse.emf.ecore.EObject containerEObj = getRelationshipContainer(newSource.getElement(), «containmentMetaFeature.genClass.metaClass»);
			«containmentMetaFeature.genClass.declareAndAssign('container', 'containerEObj')»
			if (container == null) {
				return false;
			}
			«containmentMetaFeature.checkFeature('container', containmentMetaFeature.genClass)»
			
			«IF setChild»
			«childMetaFeature.checkFeature('container', containmentMetaFeature.genClass)»
			«ENDIF»
«««			No need to check the size of the source or target features: their size does not change
«««			Still need to check the eOpposite() of the source feature
			
			«IF setSource»
				«IF sourceReverseFeature != null && (!sourceReverseFeature.ecoreFeature.derived && (sourceReverseFeature != containmentMetaFeature && sourceReverseFeature != childMetaFeature))»
				«sourceReverseFeature.checkFeature('newSource.getElement()', null)»
				«ENDIF»
			«ENDIF»
			return true;
			«ENDIF»
		'''			
	}
	
	def dispatch CharSequence canReconnect(FeatureLinkModelFacet it) '''
		«metaFeature.checkFeature('newSource.getElement()', null)»
		return true;
	'''
	
	def createCommand(GenLink it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.common.command.Command createCommand() {
			final org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(oldSource.getDiagram().getElement());
			org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
			result.append(new org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeSourceCommand(edge, newSource));
			«modelFacet.appendDomainModelCommand»
			return result;
		}
	'''
	
	def dispatch appendDomainModelCommand(LinkModelFacet it) '''
		result.append(org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE);
	'''

	def dispatch appendDomainModelCommand(TypeLinkModelFacet it) { 
		val setChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		val d = if (setChild) (sourceMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature else false
		val c = (sourceMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature && d
		val b = sourceMetaFeature.referenceType && c
		val a = !sourceMetaFeature.ecoreFeature.derived && b
		val setSource = sourceMetaFeature != null && a

		'''
			«IF containmentMetaFeature == null»
			result.append(org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE);
			«ELSE»
			org.eclipse.emf.ecore.EObject container = getRelationshipContainer(newSource.getElement(), «containmentMetaFeature.genClass.metaClass»);
			if (container == null) {
				return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
			}
			org.eclipse.emf.ecore.EObject oldContainer = edge.getElement().eContainer();
			if (oldContainer == null) {
				return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
			}
			if (oldContainer != container) {
				result.append(«containmentMetaFeature.unplugFeatureCommand('editingDomain', 'oldContainer', 'edge.getElement()')»);
				result.append(«containmentMetaFeature.plugFeatureCommand('editingDomain', 'container', 'edge.getElement()')»);
			«IF setChild»
				result.append(«childMetaFeature.unplugFeatureCommand('editingDomain', 'oldContainer', 'edge.getElement()')»);
				result.append(«childMetaFeature.plugFeatureCommand('editingDomain', 'container', 'edge.getElement()')»);
			«ENDIF»
			}
			«IF setSource»
			«IF sourceMetaFeature.ecoreFeature.many»
			result.append(«sourceMetaFeature.unplugFeatureCommand('editingDomain', 'edge.getElement()', 'oldSource.getElement()')»);
			«ENDIF»
			result.append(«sourceMetaFeature.plugFeatureCommand('editingDomain', 'edge.getElement()', 'newSource.getElement()')»);
			«ENDIF»
			«ENDIF»
		'''
	}

	def dispatch appendDomainModelCommand(FeatureLinkModelFacet it) '''
		result.append(«metaFeature.unplugFeatureCommand('editingDomain', 'oldSource.getElement()', 'edge.getTarget().getElement()')»);
		result.append(«metaFeature.plugFeatureCommand('editingDomain', 'newSource.getElement()', 'edge.getTarget().getElement()')»);
	'''

	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («featureMultiplicityComparator(containerVar, containerClass)») {
			return false;
		}
		«ENDIF»
	'''

}
