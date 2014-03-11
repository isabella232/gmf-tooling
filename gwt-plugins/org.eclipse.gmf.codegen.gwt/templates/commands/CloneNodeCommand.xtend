package commands

import com.google.inject.Inject
import common.CommandTemplate
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet

class CloneNodeCommand extends CommandTemplate<GenNode> {

	@Inject CommandCommon commandCommon

	override body(GenNode it) '''
		«attributes»
		«ctors»
		«createCommand»
		«createAfterCopyCommand»
		«execute»
		«canUndo»
		«undo»
		«redo»
		«dispose»
		«additions»
	'''	

	override commandName(GenNode it) 
		'''Clone«commandCommon.commandNameInfix(it)»Command'''

	override supertypes(GenNode it) 
		'''extends org.eclipse.emf.common.command.CommandWrapper'''
	
	def attributes(GenNode it) '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.View parentView;

		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.Node childNode;

		«generatedMemberComment»
		private final org.eclipse.draw2d.geometry.Rectangle constraint;

		«generatedMemberComment»
		private final org.eclipse.emf.edit.domain.EditingDomain editingDomain;

		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command afterCopyCommand;
	'''
	
	def ctors(GenNode it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.View parentView, org.eclipse.gmf.runtime.notation.Node childNode, org.eclipse.draw2d.geometry.Rectangle constraint) {
			this.parentView = parentView;
			this.childNode = childNode;
			this.constraint = constraint;
			this.editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(childNode.getDiagram().getElement());
		}
	'''
	
	def createCommand(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.common.command.Command createCommand() {
			«modelFacet.checkFeatures»
			org.eclipse.emf.ecore.EObject element = childNode.getElement();
			//We are being optimistic here about whether further commands can be executed.
			//Otherwise, we would have to execute the CopyCommand on every mouse move, which could be much too expensive.
			return org.eclipse.emf.edit.command.CopyCommand.create(editingDomain, element);
		}
	'''
	
	def execute(GenNode it) '''
		«generatedMemberComment»
		public void execute() {
			super.execute();
			afterCopyCommand = createAfterCopyCommand();
			if (afterCopyCommand.canExecute()) {
				afterCopyCommand.execute();
			} else {
				assert false;
			}
		}
	'''
	
	def createAfterCopyCommand(GenNode it) '''
		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command createAfterCopyCommand() {
			final java.util.Collection copyResults = super.getResult();
			assert copyResults.size() == 1;
			org.eclipse.emf.ecore.EObject copyResult = (org.eclipse.emf.ecore.EObject) copyResults.iterator().next();
			org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
			«modelFacet.plugFeatures»
			«commandCommon.adjustConstraint(it)»
			result.append(new org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand(parentView, copyResult, constraint, «getNotationViewFactoryQualifiedClassName()».INSTANCE));
			return result;
		}
	'''
	
	def canUndo(GenNode it) '''
		«generatedMemberComment»
		public boolean canUndo() {
			return super.canUndo() && afterCopyCommand != null && afterCopyCommand.canUndo();
		}	
	'''
	
	def undo(GenNode it) '''
		«generatedMemberComment»
		public void undo() {
			afterCopyCommand.undo();
			super.undo();
		}
	'''
	
	def redo(GenNode it) '''
		«generatedMemberComment»
		public void redo() {
			super.redo();
			afterCopyCommand.redo();
		}
	'''
	
	def dispose(GenNode it) '''
		«generatedMemberComment»
		public void dispose() {
			super.dispose();
			if (afterCopyCommand != null) {
				afterCopyCommand.dispose();
			}
		}
	'''
	
	def checkFeatures(TypeModelFacet it) {
		val addChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		'''
			«containmentMetaFeature.checkFeature('parentView.getElement()', null)»
			«IF addChild»
			«childMetaFeature.checkFeature('parentView.getElement()', null)»
			«ENDIF»
		'''
	}

	def plugFeatures(TypeModelFacet it) {
		val addChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		'''
			«IF addChild»
			result.append(«commandCommon.plugFeatureCommand(childMetaFeature, 'editingDomain', 'parentView.getElement()', 'copyResult')»);
			«ENDIF»
			«IF containmentMetaFeature == null»
			result.append(new org.eclipse.emf.edit.command.AddCommand(editingDomain, «commandCommon.getPhantomContainmentResource('parentView')».getContents(), copyResult));
			«ELSE»
			result.append(«commandCommon.plugFeatureCommand(containmentMetaFeature, 'editingDomain', 'parentView.getElement()', 'copyResult')»);
			«ENDIF»
		'''		
	}

	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («commandCommon.featureMultiplicityComparator(it, containerVar, containerClass)») {
			return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
		}
		«ENDIF»
	'''

}
