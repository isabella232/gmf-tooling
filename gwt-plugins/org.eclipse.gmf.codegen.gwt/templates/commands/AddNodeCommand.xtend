package commands

import com.google.inject.Inject
import common.CommandTemplate
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet

class AddNodeCommand extends CommandTemplate<GenNode> {

	extension CommandUtils = new CommandUtils

	@Inject CommandCommon commandCommon

	override def body(GenNode it) {
		val relatedNodes = getRelatedGenNodes
		val multipleRelatedNodes = relatedNodes.size() > 1
		'''
			«attributes(multipleRelatedNodes)»
			«ctors(multipleRelatedNodes)»
			«createCommand(relatedNodes)»
			«additions»
		'''
	}

	def attributes(Boolean multipleRelatedNodes) '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.View parentView;

		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.notation.Node childNode;

		«IF multipleRelatedNodes»
		«generatedMemberComment»
		private final int oldVisualID;

		«generatedMemberComment»
		private final int newVisualID;
		«ENDIF»

		«generatedMemberComment»
		private final org.eclipse.draw2d.geometry.Rectangle constraint;
	'''

	override commandName(GenNode it) 
		'''Add«commandCommon.commandNameInfix(it)»Command'''

	override supertypes(GenNode it) 
		'''extends org.eclipse.emf.common.command.CommandWrapper'''


	def ctors(GenNode it, Boolean multipleRelatedNodes) '''
		«generatedMemberComment»
		public «commandName»(org.eclipse.gmf.runtime.notation.View parentView, org.eclipse.gmf.runtime.notation.Node childNode, int newVisualID, org.eclipse.draw2d.geometry.Rectangle constraint) {
			this.parentView = parentView;
			this.childNode = childNode;
			«IF multipleRelatedNodes»
			this.oldVisualID = «diagram.getVisualIDRegistryQualifiedClassName()».getVisualID(childNode);
			this.newVisualID = newVisualID;
			«ENDIF»
			this.constraint = constraint;
		}
	'''

	def createCommand(GenNode it, Iterable<GenNode> relatedNodes) '''
		«generatedMemberComment»
		protected org.eclipse.emf.common.command.Command createCommand() {
			«modelFacet.checkFeatures»
			org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
			org.eclipse.emf.ecore.EObject element = childNode.getElement();
			org.eclipse.emf.edit.domain.EditingDomain editingDomain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(parentView.getDiagram().getElement());
			«IF relatedNodes.size() > 1»
			switch (oldVisualID) {
			«ENDIF»
			«FOR next : relatedNodes»
			«IF relatedNodes.size() > 1»
			case «next.getEditPartQualifiedClassName()».VISUAL_ID:
			«ENDIF»
			«next.modelFacet.unplugFeatures»
			«IF relatedNodes.size() > 1»
			break;
			«ENDIF»
			«ENDFOR»
			«IF relatedNodes.size() > 1»
			}
			«ENDIF»
			«modelFacet.plugFeatures»
			result.append(org.eclipse.emf.edit.command.RemoveCommand.create(editingDomain, childNode.eContainer(), childNode.eContainmentFeature(), childNode));
			«IF relatedNodes.size() > 1»
			if (newVisualID == oldVisualID) {
			«ENDIF»
			result.append(new org.eclipse.gmf.runtime.gwt.commands.ExpandDrawerCommand(parentView));
			result.append(org.eclipse.emf.edit.command.AddCommand.create(editingDomain, parentView, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_PersistedChildren(), childNode));
			result.append(new org.eclipse.gmf.runtime.gwt.commands.SetBoundsCommand(childNode, constraint));
			«IF relatedNodes.size() > 1»
			} else {
			«commandCommon.adjustConstraint(it)»
			result.append(new org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand(parentView, element, constraint, «getNotationViewFactoryQualifiedClassName()».INSTANCE));
			}
			«ENDIF»
			return result;
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
			result.append(«commandCommon.plugFeatureCommand(childMetaFeature, 'editingDomain', 'parentView.getElement()', 'element')»);
			«ENDIF»
			«IF containmentMetaFeature == null»
			result.append(new org.eclipse.emf.edit.command.AddCommand(editingDomain, «commandCommon.getPhantomContainmentResource('parentView')».getContents(), element));
			«ELSE»
			result.append(«commandCommon.plugFeatureCommand(containmentMetaFeature, 'editingDomain', 'parentView.getElement()', 'element')»);
			«ENDIF»
		'''
	}

	def unplugFeatures(TypeModelFacet it) {
		val removeChild = childMetaFeature != null && (childMetaFeature != containmentMetaFeature && !childMetaFeature.ecoreFeature.derived)
		'''
			«IF removeChild»
			result.append(«commandCommon.unplugFeatureCommand(childMetaFeature, 'editingDomain', 'element.eContainer()', 'element')»);
			«ENDIF»
			«IF containmentMetaFeature == null»
			if (element.eContainer() != null) {
				result.append(org.eclipse.emf.edit.command.RemoveCommand.create(editingDomain, element.eContainer(), element.eContainmentFeature(), element));
			} else if (element.eResource() != null) {
				result.append(new org.eclipse.emf.edit.command.RemoveCommand(editingDomain, element.eResource().getContents(), element));
			} else {
				result.append(org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE);
			}
			«ELSE»
			result.append(«commandCommon.unplugFeatureCommand(containmentMetaFeature, 'editingDomain', 'element.eContainer()', 'element')»);
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
