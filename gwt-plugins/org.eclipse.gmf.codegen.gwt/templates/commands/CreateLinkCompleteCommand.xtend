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
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import providers.DomainElementInitializer

class CreateLinkCompleteCommand extends CommandTemplate<GenLink> {

	extension MetaModel = new MetaModel
	@Inject extension CommandCommon
	@Inject extension DomainElementInitializer

	override body(GenLink it) '''		
		«attributes»
		«ctors»
		«prepare»
		«initializeDomainModelCommand»
		«canUndo»
		«execute»
		«undo»
		«redo»
		«modelFacet.getRelationshipContainer»
		«additions»
	'''

	override commandName(GenLink it) 
		'''Create«commandNameInfix»Command'''

	override supertypes(GenLink it)
		'''extends org.eclipse.emf.common.command.AbstractCommand'''
	
	def attributes(GenLink it) '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.View source;

		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.View target;

		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.Edge createdEdge;

		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command domainModelAddCommand;
	'''
	
	def ctors(GenLink it) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx requestEx) {
			if (requestEx.getSourceEditPart().getModel() instanceof org.eclipse.gmf.runtime.notation.View) {
				source = (org.eclipse.gmf.runtime.notation.View) requestEx.getSourceEditPart().getModel();
			} else {
				source = null;
			}
			if (requestEx.getTargetEditPart().getModel() instanceof org.eclipse.gmf.runtime.notation.View) {
				target = (org.eclipse.gmf.runtime.notation.View) requestEx.getTargetEditPart().getModel();
			} else {
				target = null;
			}
			if (source == null || target == null) {
				createdEdge = null;
				return;
			}
			createdEdge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createEdge();
			«modelFacet.setEdgeElement(it)»
			«getNotationViewFactoryQualifiedClassName()».INSTANCE.decorateView(createdEdge);
		}
	'''

	def dispatch setEdgeElement(LinkModelFacet it, GenLink genLink) '''
		createdEdge.setElement(null);
	'''
	
	def dispatch setEdgeElement(TypeLinkModelFacet it, GenLink genLink) '''
		«metaClass.newInstance('createdDomainElement')»
		createdEdge.setElement(«metaClass.downcastToEObject('createdDomainElement')»);
		«initialize(genLink, 'createdDomainElement')»
	'''

	def prepare(GenLink it) '''
		«generatedMemberComment»
		protected boolean prepare() {
			if (source == null || target == null || createdEdge == null) {
				return false;
			}
			«creationConstraints.checkLinkConstraints('source.getElement()', 'target.getElement()')»
			domainModelAddCommand = initializeDomainModelCommand();
			if (domainModelAddCommand == null || !domainModelAddCommand.canExecute()) {
				return false;
			}
			return true;
		}
	'''

	def dispatch CharSequence initializeDomainModelCommand(GenLink it) '''
		«generatedMemberComment»
		private org.eclipse.emf.common.command.Command initializeDomainModelCommand() {
			«modelFacet.initializeDomainModelCommand»
		}
	'''
	
	def dispatch CharSequence initializeDomainModelCommand(LinkModelFacet it) '''
		return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
	'''
	
	def dispatch CharSequence initializeDomainModelCommand(TypeLinkModelFacet it) {
		val addChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
	
	/**
	 «LET 
	 * sourceMetaFeature <> null and 
	 * 	(not sourceMetaFeature.ecoreFeature._derived and 
	 * 		(sourceMetaFeature.ecoreFeature.oclIsKindOf(ecore::EReference) and 
	 * 			(sourceMetaFeature.ecoreFeature.oclAsType(ecore::EReference).eOpposite <> containmentMetaFeature.ecoreFeature and 
	 * 				(addChild implies sourceMetaFeature.ecoreFeature.oclAsType(ecore::EReference).eOpposite <> childMetaFeature.ecoreFeature)
	 * 			)
	 * 		)
	 * 	) AS addSource-»
	 */
		val a = !sourceMetaFeature.ecoreFeature.derived
		val b = sourceMetaFeature.referenceType && ((sourceMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature)
		val c = if (addChild) ((sourceMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature) == true else true
		val addSource = sourceMetaFeature != null && (a && (b && c))

		val a1 = !targetMetaFeature.ecoreFeature.derived
		val b1 = targetMetaFeature.referenceType && ((targetMetaFeature.ecoreFeature as EReference).EOpposite != containmentMetaFeature.ecoreFeature)
		var c1 = if (addChild) ((targetMetaFeature.ecoreFeature as EReference).EOpposite != childMetaFeature.ecoreFeature) == true else true
		val addTarget = targetMetaFeature != null && (a1 && (b1 && c1))
		
		val targetReverseFeature = targetMetaFeature.reverse

		'''
			org.eclipse.emf.ecore.EObject containerEObj = getRelationshipContainer(source.getElement(), «containmentMetaFeature.genClass.metaClass»);
			«containmentMetaFeature.genClass.declareAndAssign('container', 'containerEObj')»
			if (container == null) {
				return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
			}
			«IF addSource»
			«sourceMetaFeature.checkFeature('createdEdge.getElement()', null)»
			«ENDIF»
			«IF addTarget»
			«targetMetaFeature.checkFeature('createdEdge.getElement()', null)»			
			«IF targetReverseFeature != null && !targetReverseFeature.ecoreFeature.derived»
				«targetReverseFeature.checkFeature('target.getElement()', null)»
			«ENDIF»
			«ENDIF»
			org.eclipse.emf.edit.domain.EditingDomain domainModelEditDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(source.getDiagram().getElement());
			org.eclipse.emf.common.command.CompoundCommand addLinkEndsCommand = new org.eclipse.emf.common.command.CompoundCommand();
			addLinkEndsCommand.append(«containmentMetaFeature.plugFeatureCommand('domainModelEditDomain', 'container', 'createdEdge.getElement()')»);
			«IF addChild»
			addLinkEndsCommand.append(«childMetaFeature.plugFeatureCommand('domainModelEditDomain', 'container', 'createdEdge.getElement()')»);
			«ENDIF»
			«IF addSource»
			addLinkEndsCommand.append(«sourceMetaFeature.plugFeatureCommand('domainModelEditDomain', 'createdEdge.getElement()', 'source.getElement()')»);
			«ENDIF»
			«IF addTarget»
			addLinkEndsCommand.append(«targetMetaFeature.plugFeatureCommand('domainModelEditDomain', 'createdEdge.getElement()', 'target.getElement()')»);
			«ENDIF»
			return addLinkEndsCommand;
		'''
	}
	
	
	def dispatch CharSequence initializeDomainModelCommand(FeatureLinkModelFacet it) {
		val reverseMetaFeature = metaFeature.reverse
		
		'''
			«IF reverseMetaFeature != null && !reverseMetaFeature.ecoreFeature.derived»
			«reverseMetaFeature.checkFeature('target.getElement()', null)»
			«ENDIF»
			org.eclipse.emf.edit.domain.EditingDomain domainModelEditDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(source.getDiagram().getElement());
			«IF metaFeature.referenceType && (metaFeature.ecoreFeature as EReference).containment»
			if (target.getElement().eContainer() != null) {
				return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
			}
			org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
			if (target.getElement().eResource() != null) {
				result.append(new org.eclipse.emf.edit.command.RemoveCommand(domainModelEditDomain, target.getElement().eResource().getContents(), target.getElement()));
			}
			result.append(«metaFeature.plugFeatureCommand('domainModelEditDomain', 'source.getElement()', 'target.getElement()')»);
			return result.unwrap();
			«ELSE»
			return «metaFeature.plugFeatureCommand('domainModelEditDomain', 'source.getElement()', 'target.getElement()')»;
			«ENDIF»
		'''
	}
	
	def canUndo(GenLink it) '''
		«generatedMemberComment»
		public boolean canUndo() {
			return source != null && target != null && createdEdge != null && domainModelAddCommand != null && domainModelAddCommand.canUndo();
		}
	'''
	
	def execute(GenLink it) '''
		«generatedMemberComment»
		public void execute() {
			domainModelAddCommand.execute();
			source.getDiagram().insertEdge(createdEdge);
			createdEdge.setSource(source);
			createdEdge.setTarget(target);
		}
	'''
	
	def undo(GenLink it) '''
		«generatedMemberComment»
		public void undo() {
			domainModelAddCommand.undo();
			source.getDiagram().removeEdge(createdEdge);
			createdEdge.setSource(null);
			createdEdge.setTarget(null);
		}
	'''
	
	def redo(GenLink it) '''
		«generatedMemberComment»
		public void redo() {
			execute();
		}
	'''

	def checkFeature(GenFeature it, String containerVar, GenClass containerClass) '''
		«IF ecoreFeature.upperBound > 0»
		if («featureMultiplicityComparator(containerVar, containerClass)») {
			return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
		}
		«ENDIF»
	'''
	
	def initialize(TypeModelFacet it, GenLink link, String newElementVar) '''
		«IF modelElementInitializer != null»
		«link.getDiagram().qualifiedClassName».init_«link.getUniqueIdentifier()»(«newElementVar»);
		«ENDIF»
	'''

}
