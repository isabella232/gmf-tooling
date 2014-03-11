package commands

import com.google.inject.Inject
import common.CommandTemplate
import diagram.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet

class CreateNodeCommand extends CommandTemplate<GenNode> {
	
	extension MetaModel = new MetaModel

	@Inject extension CommandCommon

	override body(GenNode it) '''
		«attributes»
		«ctors»
		«prepare»
		«canUndo»
		«execute»
		«undo»
		«redo»
		«additions»
	'''

	override commandName(GenNode it) 
		'''Create«commandNameInfix»Command'''

	override supertypes(GenNode it) 
		'''extends org.eclipse.emf.common.command.AbstractCommand'''
	
	def attributes(GenNode it) '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand notationAddCommand;

		«generatedMemberComment»
		private final org.eclipse.emf.common.command.Command domainModelAddCommand;
	'''
	
	def ctors(GenNode it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.View parent, org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx request) {
			this(parent, request, null);
		}

		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.View parent, org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx request, org.eclipse.draw2d.geometry.Rectangle constraint) {
			«modelFacet.metaClass.newInstance('createdDomainElement')»
			«initialize('createdDomainElement')»
			«modelFacet.initializeDomainModelCommand»
			«adjustConstraint»
			this.notationAddCommand = new org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand(parent, «modelFacet.metaClass.downcastToEObject('createdDomainElement')», constraint, «getNotationViewFactoryQualifiedClassName()».INSTANCE);
			request.setCreatedObject(notationAddCommand.getCreatedView());
		}
	'''

	def initializeDomainModelCommand(TypeModelFacet it) {
		val addChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		'''
		«containmentMetaFeature.checkFeature('parent.getElement()', null)»
		«IF addChild»
		«childMetaFeature.checkFeature('parent.getElement()', null)»
		«ENDIF»
		org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(parent.getDiagram().getElement());
		«IF addChild»
		org.eclipse.emf.common.command.CompoundCommand compoundCommand = new org.eclipse.emf.common.command.CompoundCommand();
		«IF containmentMetaFeature == null»
		compoundCommand.append(new org.eclipse.emf.edit.command.AddCommand(editingDomain, «'parent'.getPhantomContainmentResource».getContents(), createdDomainElement));
		«ELSE»
		compoundCommand.append(«containmentMetaFeature.plugFeatureCommand('editingDomain', 'parent.getElement()', 'createdDomainElement')»);
		«ENDIF»
		compoundCommand.append(«childMetaFeature.plugFeatureCommand('editingDomain', 'parent.getElement()', 'createdDomainElement')»);
		domainModelAddCommand = compoundCommand;
		«ELSE»
		«IF containmentMetaFeature == null»
		domainModelAddCommand = new org.eclipse.emf.edit.command.AddCommand(editingDomain, «'parent'.getPhantomContainmentResource».getContents(), createdDomainElement);
		«ELSE»
		domainModelAddCommand = «containmentMetaFeature.plugFeatureCommand('editingDomain', 'parent.getElement()', 'createdDomainElement')»;
		«ENDIF»
		«ENDIF»
		'''
	}
	
	def prepare(GenNode it) '''
		«generatedMemberComment»
		protected boolean prepare() {
			return domainModelAddCommand != null && domainModelAddCommand.canExecute() && notationAddCommand != null && notationAddCommand.canExecute();
		}
	'''
	
	def canUndo(GenNode it) '''
		«generatedMemberComment»
		public boolean canUndo() {
			return domainModelAddCommand != null && domainModelAddCommand.canUndo() && notationAddCommand != null && notationAddCommand.canUndo();
		}
	'''
	
	def execute(GenNode it) '''
		«generatedMemberComment»
		public void execute() {
			domainModelAddCommand.execute();
			notationAddCommand.execute();
		}
	'''
	
	def undo(GenNode it) '''
		«generatedMemberComment»
		public void undo() {
			notationAddCommand.undo();
			domainModelAddCommand.undo();
		}
	'''
	
	def redo(GenNode it) '''
		«generatedMemberComment»
		public void redo() {
			execute();
		}
	'''

	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («featureMultiplicityComparator(containerVar, containerClass)») {
			domainModelAddCommand = null;
			notationAddCommand = null;
			return;
		}
		«ENDIF»
	'''
	
	def initialize(GenNode it, String newElementVar) '''
		«IF modelFacet.modelElementInitializer != null»
«««		«EXPAND xpt::providers::DomainElementInitializer::qualifiedClassName FOR getDiagram()».init_«getUniqueIdentifier()»(«newElementVar»);
		«ENDIF»
	'''
}
