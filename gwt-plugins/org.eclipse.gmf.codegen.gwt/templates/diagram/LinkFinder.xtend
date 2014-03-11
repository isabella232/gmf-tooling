package diagram

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import commands.CommandUtils

class LinkFinder {

	extension CommandUtils = new CommandUtils
	extension PhantomUtils = new PhantomUtils

	def incomingLinks(GenCommonBase it){
		if (effectiveMetaClass == null)
			newArrayList() 
		else 
			diagram.links.filter[e | e.incomingGenClass.ecoreClass.isSuperTypeOf(effectiveMetaClass.ecoreClass)]	
	}

	def incomingTypeLinks(GenCommonBase it) {
		 incomingLinks.filter[e | e.modelFacet instanceof TypeLinkModelFacet]
	}
	
	def outgoingLinks(GenCommonBase it) {
		 if (effectiveMetaClass == null) 
		 	newArrayList()
		 else 
		 	diagram.links.filter[e | e.outgoingGenClass.ecoreClass.isSuperTypeOf(effectiveMetaClass.ecoreClass)]
	}

	def outgoingNonPhantomLinks(GenCommonBase it) {
		 outgoingLinks.filter[e | !e.modelFacet.isPhantomLink(it.diagram)]
	}

	def containedLinks(GenCommonBase it) {
		 val effectiveMetaClass = getEffectiveMetaClass 
		 if (effectiveMetaClass == null) 
		 	newArrayList() 
		 else diagram.links.filter[e | e.containerGenClass.ecoreClass.isSuperTypeOf(effectiveMetaClass.ecoreClass)]
	}
	
	def containedTypeModelFacetLinks(GenCommonBase it) {
		 containedLinks.filter(e | e.modelFacet instanceof TypeLinkModelFacet)
	}
	
	def containedFeatureModelFacetLinks(GenCommonBase it) {
		 containedLinks.filter(e | e.modelFacet instanceof FeatureLinkModelFacet)
	}
	
	def containedLinksWithSelector(GenCommonBase it) {
		 containedTypeModelFacetLinks.filter[e | e.modelFacet.getElementSelector != null]
	}
	
	def needsSourceVisualID(GenCommonBase it) {
		 containedLinks.filter[e | 
		 	e.modelFacet != null && 
		 	getRelatedChildLabelGenNodes(e.getDiagram(), e.modelFacet.getSourceType()).size() > 0
		 ].size() > 0
	}
	
	def needsTargetVisualID(GenCommonBase it) {
		 containedLinks.filter[e | 
		 	e.modelFacet != null && 
		 	getRelatedChildLabelGenNodes(e.getDiagram(), e.modelFacet.getTargetType()).size() > 0
		 ].size() > 0
	}

	def getPossibleContainers(GenLink it) {
		 val containerClass = containerGenClass
		 newArrayList(diagram) + newArrayList(diagram.allNodes, diagram.links).flatten.filter[it |
			if (effectiveMetaClass == null) 
				false 
			else containerClass.ecoreClass.isSuperTypeOf(effectiveMetaClass.ecoreClass)
		]
	}

	def dispatch getElementSelector(LinkModelFacet it) { null }
	
	def dispatch getElementSelector(TypeLinkModelFacet it) { modelElementSelector }
	
	def dispatch GenClass incomingGenClass(GenLink it) { modelFacet.incomingGenClass() }
	
	def dispatch GenClass incomingGenClass(LinkModelFacet it) { null }
	
	def dispatch GenClass incomingGenClass(FeatureLinkModelFacet it) { metaFeature.getTypeGenClass }
	
	def dispatch GenClass incomingGenClass(TypeLinkModelFacet it) { targetMetaFeature.getTypeGenClass }
	
	def dispatch GenClass outgoingGenClass(GenLink it) { modelFacet.outgoingGenClass() }
	
	def dispatch GenClass outgoingGenClass(LinkModelFacet it) { null }
	
	def dispatch GenClass outgoingGenClass(FeatureLinkModelFacet it) { metaFeature.genClass }
	
	def dispatch GenClass outgoingGenClass(TypeLinkModelFacet it) {
		if (sourceMetaFeature == null) 
			containmentMetaFeature.genClass
		sourceMetaFeature.getTypeGenClass
	}

	def getTypeGenClass(GenFeature it) {
		 genClass.genPackage.genModel.findGenClassifier(ecoreFeature.EType) as GenClass
	}

	def dispatch GenClass containerGenClass(GenLink it) { modelFacet.containerGenClass() }
	
	def dispatch GenClass containerGenClass(LinkModelFacet it) { null }
	
	def dispatch GenClass containerGenClass(TypeLinkModelFacet it) { containmentMetaFeature.genClass }
	
	def dispatch GenClass containerGenClass(FeatureLinkModelFacet it) { metaFeature.genClass }
	
	def dispatch GenClass getEffectiveMetaClass(GenCommonBase it) { null }
	
	def dispatch GenClass getEffectiveMetaClass(GenDiagram it) { domainDiagramElement }
	
	def dispatch GenClass getEffectiveMetaClass(GenNode it) { modelFacet.metaClass }
	
	def dispatch GenClass getEffectiveMetaClass(GenLink it) { modelFacet.getEffectiveMetaClass() }
	
	def dispatch GenClass getEffectiveMetaClass(LinkModelFacet it) { null }
	
	def dispatch GenClass getEffectiveMetaClass(TypeLinkModelFacet it) { metaClass }
	
	def dispatch GenClass getEffectiveMetaClass(GenChildLabelNode it) { null }

}