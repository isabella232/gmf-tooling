package diagram.parts

import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import commands.CommandUtils
import diagram.PhantomUtils

class NotationModelRefresherHelper {

	extension CommandUtils = new CommandUtils
	extension PhantomUtils = new PhantomUtils

	def dispatch needsNotationModelRefresher(GenContainerBase it) {
		getChildNodesForNotationModelRefresher.size() > 0
	}
	
	def dispatch needsNotationModelRefresher(GenDiagram it) {
		getChildNodesForNotationModelRefresher.size() > 0 || getPhantomNodes.size() > 0
	}
	
	def getChildNodesForNotationModelRefresher(GenContainerBase it) {
		getChildNodes.filter(e | e.modelFacet != null && (e.modelFacet.metaClass != null && (!e.modelFacet.isPhantomElement() && e.modelFacet.childMetaFeature != null)))
	}
	
	def getConstraintsInChildren(GenContainerBase it) {
		getChildNodes.filter(e | e.modelFacet != null && (e.modelFacet.metaClass != null && e.modelFacet.modelElementSelector != null))
	}
	
	def getChildFeatures(GenContainerBase it) {
		getChildNodesForNotationModelRefresher.map[it | modelFacet.childMetaFeature]
	}

	def getChildFeaturesForFilter(GenContainerBase it) {
		getChildNodesForNotationModelRefresher.map[it | modelFacet.childMetaFeatureForFilter]
	}

	def childMetaFeatureForFilter(TypeModelFacet it) {
		if (childMetaFeature.ecoreFeature.derived) 
			containmentMetaFeature 
		else childMetaFeature
	}
	
	def getAllInitableContainers(GenDiagram it) {
		getAllContainersWithChildren + allNodes.filter[e | e.initableCompartments.size > 0]
	}
	
	def getAllContainersWithChildren(GenDiagram it) {
		diagram.getAllContainers().filter(e | e.needsNotationModelRefresher())
	}
	
	def getInitableCompartments(GenNode it) {
		compartments.filter(e | e.needsNotationModelRefresher())
	}
	
	def getInitableGrandChildren(GenContainerBase it) {
		val allInitableContainers = getAllInitableContainers(getDiagram())
		getChildNodesForNotationModelRefresher.filter(e | allInitableContainers.exists[c | c == e])
	}

}
