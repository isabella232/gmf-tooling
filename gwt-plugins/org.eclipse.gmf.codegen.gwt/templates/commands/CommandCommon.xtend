package commands

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import diagram.MetaModel
import diagram.ViewmapAttributesUtilsHelper

class CommandCommon {

	extension ViewmapAttributesUtilsHelper = new ViewmapAttributesUtilsHelper
	extension MetaModel = new MetaModel

	def dispatch getRelationshipContainer(LinkModelFacet it) ''''''

	def dispatch getRelationshipContainer(TypeLinkModelFacet it) '''
		/**
		 * 'Finds container element for the relationship of the specified type.\n' + 
		 * 'Default implementation goes up by containment hierarchy starting from\n' + 
		 * 'the specified element and returns the first element that is instance of\n' + 
		 * 'the specified container class.'
		 */
		protected org.eclipse.emf.ecore.EObject getRelationshipContainer(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EClass containerClass) {
			for (; element != null; element = element.eContainer()) {
				if (containerClass.isSuperTypeOf(element.eClass())) {
					return element;
				}
			}
			return null;
		}
	'''
	
	def featureMultiplicityComparator(GenFeature it, String ownerVar, GenClass ownerClass) '''
		«IF ecoreFeature.upperBound == 1»«getFeatureValue(ownerVar, ownerClass, false)» != null«ELSE»
		«metaFeature».getUpperBound() > 1 && «getFeatureValue(ownerVar, ownerClass, true)».size() >= «metaFeature».getUpperBound()«ENDIF»
	'''

/*

«DEFINE featureMultiplicityComparator(ownerVar : String, ownerClass : genmodel::GenClass) FOR genmodel::GenFeature-»
«IF ecoreFeature.upperBound = 1»«EXPAND MetaModel::getFeatureValue(ownerVar, ownerClass, false)» != null«ELSE-»
«EXPAND MetaModel::MetaFeature».getUpperBound() > 1 && «EXPAND MetaModel::getFeatureValue(ownerVar, ownerClass, true)».size() >= «EXPAND MetaModel::MetaFeature».getUpperBound()«ENDIF-»
«ENDDEFINE»
*/

	def checkLinkConstraints(GenLinkConstraints it, String sourceVar, String targetVar) ''''''
//	if(!«EXPAND xpt::providers::DomainElementInitializer::qualifiedClassName FOR link.getDiagram()».«link.diagram.getLinkCreationConstraintsClassName()».canExist«link.getUniqueIdentifier()»(«sourceVar», «targetVar»)) {
//		return false;
//	}


	def plugFeatureCommand(GenFeature it, String domainVar, String containerVar, String elementVar) 
		'''«IF ecoreFeature.many»org.eclipse.emf.edit.command.AddCommand«ELSE»org.eclipse.emf.edit.command.SetCommand«ENDIF».create(«domainVar», «containerVar», «metaFeature», «elementVar»)'''

	def unplugFeatureCommand(GenFeature it, String domainVar, String containerVar, String elementVar) '''
		«IF ecoreFeature.many»
		org.eclipse.emf.edit.command.RemoveCommand.create(«domainVar», «containerVar», «metaFeature», «elementVar»)
		«ELSE»
		org.eclipse.emf.edit.command.SetCommand.create(«domainVar», «containerVar», «metaFeature», org.eclipse.emf.edit.command.SetCommand.UNSET_VALUE)
		«ENDIF»
	'''

	def adjustConstraint(GenNode it) {
		val rc = getResizeConstraints(it.viewmap)
		val resizableWidth = rc == null || rc.resizeHandleNames.exists[e | e == 'EAST' || e == 'WEST']
		val resizableHeight = rc == null || rc.resizeHandleNames.exists[e | e == 'NORTH' || e == 'SOUTH']
		'''
			if (constraint != null) {
				«IF resizableWidth || resizableHeight»
				constraint.union(new org.eclipse.draw2d.geometry.Dimension(«defaultWidth», «defaultHeight»));
				«ENDIF»
				«IF !resizableWidth»
				constraint.width = «defaultWidth»;
				«ENDIF»
				«IF !resizableHeight»
				constraint.height = «defaultHeight»;
				«ENDIF»
			}
		'''
	}

	def defaultWidth(GenNode it) '''«defaultSizeWidth(viewmap, 40)»'''
	
	def defaultHeight(GenNode it) '''«defaultSizeHeight(viewmap, 40)»'''

	def dispatch CharSequence commandNameInfix(GenNode it) '''«it.modelFacet.commandNameInfix»«visualID»'''

	def dispatch CharSequence commandNameInfix(GenLink it) '''«it.modelFacet.commandNameInfix»«visualID»'''

	def dispatch CharSequence commandNameInfix(LinkModelFacet it) ''''''

	def dispatch CharSequence commandNameInfix(TypeModelFacet it) '''«metaClass.commandNameInfix»'''

	def dispatch CharSequence commandNameInfix(TypeLinkModelFacet it) '''«metaClass.commandNameInfix»'''

	def dispatch CharSequence commandNameInfix(GenClass it) '''«ecoreClass.name»'''

	def dispatch CharSequence commandNameInfix(FeatureLinkModelFacet it) '''«metaFeature.genClass.ecoreClass.name»_«metaFeature.ecoreFeature.name.toFirstUpper»'''

	def getPhantomContainmentResource(String it) '''«it».getDiagram().getElement().eResource()'''

}
