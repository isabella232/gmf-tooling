package diagram

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.ecore.EReference
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet

class PhantomUtils {

	def getPhantomNodes(GenDiagram it) {
		 topLevelNodes.filter[e | e.modelFacet.isPhantomElement()]
	}

	def dispatch getPhantomFeatures(GenDiagram it) { getPhantomFeatures(getPhantomNodes) }

	def dispatch getPhantomFeatures(GenTopLevelNode it) {
		 getPhantomFeatures(getDiagram(), newArrayList(it))
	}

	def getPhantomFeatures(GenDiagram diagram, Iterable<GenTopLevelNode> phantomNodes) {
		 diagram.links.filter[e | e.modelFacet.isPhantomLink(phantomNodes)].map[e | 
		 	(e.modelFacet as FeatureLinkModelFacet).metaFeature
		 ]
	}
	
	def dispatch Boolean isPhantomLink(LinkModelFacet it, GenDiagram diagram) { 
		isPhantomLink(diagram.getPhantomNodes)
	}

	def dispatch Boolean isPhantomLink(LinkModelFacet it, Iterable<GenTopLevelNode> phantoms) { false }

	def dispatch Boolean isPhantomLink(FeatureLinkModelFacet it, Iterable<GenTopLevelNode> phantoms) {
		 if (!isContains(metaFeature)) 
		 	false 
		 else {
		 	val featureType = metaFeature.getTypeGenClass
		 	phantoms.filter[e | featureType.ecoreClass.isSuperTypeOf(e.modelFacet.metaClass.ecoreClass)].size() > 0
		 }
	}

	private def isContains(GenFeature it) {
		isReferenceType && (ecoreFeature as EReference).containment
	}

}