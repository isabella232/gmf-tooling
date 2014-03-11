package commands

import com.google.inject.Inject
import common.CommandTemplate
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.ecore.EReference
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet

class ReconnectLinkTargetCommand extends CommandTemplate<GenLink> {

	@Inject extension CommandCommon
	@Inject extension DomainModelRemoveCommand

	override body(GenLink it) '''
		«attributes»
		«ctors»
		«prepare»
		«canReconnect»
		«createCommand»
		«IF creationConstraints != null»
		«domainModelRemoveCommand('edge')»
		«ENDIF»
		«additions»
	'''

	override commandName(GenLink it) 
		'''Reconnect«commandNameInfix»TargetCommand'''

	override supertypes(GenLink it) 
		'''extends org.eclipse.emf.common.command.CommandWrapper'''

	def attributes(GenLink it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.Edge edge;

		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View newTarget;

		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View oldTarget;
	'''

	def ctors(GenLink it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gef.requests.ReconnectRequest request) {
			this((org.eclipse.gmf.runtime.notation.Edge)request.getConnectionEditPart().getModel(), (org.eclipse.gmf.runtime.notation.View)request.getTarget().getModel());
		}

		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.Edge edge, org.eclipse.gmf.runtime.notation.View newTarget) {
			this.edge = edge;
			this.newTarget = newTarget;
			this.oldTarget = edge.getTarget();
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
			«creationConstraints.checkLinkConstraints('edge.getSource().getElement()', 'newTarget.getElement()')»
			«modelFacet.canReconnect»
		}
	'''

	def dispatch CharSequence canReconnect(LinkModelFacet it) '''
		return false;
	'''

	def dispatch CharSequence canReconnect(TypeLinkModelFacet it) { 
		val setChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		val d = if (setChild) (targetMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature
		val c = (targetMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature && d
		val b = targetMetaFeature.referenceType && c
		val a = !targetMetaFeature.ecoreFeature.derived && b
		val setTarget = targetMetaFeature != null && a
		val targetReverseFeature = targetMetaFeature.reverse

		'''
«««			Need to check the opposite of the target feature
			«IF setTarget»
				«IF targetReverseFeature != null && !targetReverseFeature.ecoreFeature.derived»
				«targetReverseFeature.checkFeature('newTarget.getElement()', null)»
				«ENDIF»
			«ENDIF»
			return true;
		'''
	}

	def dispatch CharSequence canReconnect(FeatureLinkModelFacet it) '''
		«««	Need to check the opposite of the meta feature
		«IF metaFeature.reverse != null && !metaFeature.reverse.ecoreFeature.derived»
			«metaFeature.reverse.checkFeature('newTarget.getElement()', null)»
		«ENDIF»	
		return true;
	'''

	def createCommand(GenLink it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.common.command.Command createCommand() {
			org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(oldTarget.getDiagram().getElement());
			org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
			result.append(new org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeTargetCommand(edge, newTarget));
			«modelFacet.appendDomainModelCommand»
			return result;
		}
	'''

	def dispatch CharSequence appendDomainModelCommand(LinkModelFacet it) '''
		result.append(org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE);
	'''

	def dispatch CharSequence appendDomainModelCommand(TypeLinkModelFacet it) {
		val setChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		val d = if (setChild) (targetMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature else false
		val c = (targetMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature && d
		val b = targetMetaFeature.referenceType && c
		val a = !targetMetaFeature.ecoreFeature.derived && b
		val setTarget = targetMetaFeature != null && a

	'''
		«IF setTarget»
			«IF targetMetaFeature.ecoreFeature.many»
			result.append(«targetMetaFeature.unplugFeatureCommand('editingDomain', 'edge.getElement()', 'oldTarget.getElement()')»);
			«ENDIF»
			result.append(«targetMetaFeature.plugFeatureCommand('editingDomain', 'edge.getElement()', 'newTarget.getElement()')»);
		«ELSE»
«««			No command may be generated here. Probably, this situation is impossible, but we'd better warn the user.
			//XXX: Command should be added manually here. 
		«ENDIF»
	'''
	}

	def dispatch CharSequence appendDomainModelCommand(FeatureLinkModelFacet it) '''
		«IF metaFeature.referenceType && (metaFeature.ecoreFeature as EReference).containment»
		if (newTarget.getElement().eContainer() != null) {
			result.append(org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE);
		}
		«ENDIF»
		«IF metaFeature.ecoreFeature.many»
		result.append(«metaFeature.unplugFeatureCommand('editingDomain', 'edge.getSource().getElement()', 'oldTarget.getElement()')»);
		«ENDIF»
		«IF metaFeature.referenceType && (metaFeature.ecoreFeature as EReference).containment»
		result.append(new org.eclipse.emf.edit.command.AddCommand(editingDomain, «'edge'.getPhantomContainmentResource».getContents(), oldTarget.getElement()));
		if (oldTarget.getElement().eResource() != null) {
			result.append(new org.eclipse.emf.edit.command.RemoveCommand(editingDomain, newTarget.getElement().eResource().getContents(), newTarget.getElement()));
		}
		«ENDIF»
		result.append(«metaFeature.plugFeatureCommand('editingDomain', 'edge.getSource().getElement()', 'newTarget.getElement()')»);
	'''

	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («featureMultiplicityComparator(containerVar, containerClass)») {
			return false;
		}
		«ENDIF»
	'''

}
