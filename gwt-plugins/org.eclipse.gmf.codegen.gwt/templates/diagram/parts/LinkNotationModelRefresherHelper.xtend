package diagram.parts

import java.util.Collection
import java.util.Collections
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import org.eclipse.gmf.codegen.gmfgen.GenChildNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import diagram.LinkFinder

class LinkNotationModelRefresherHelper {

	extension LinkFinder = new LinkFinder

	def needsLinkNotationModelRefresher(GenCommonBase it) {
		primNeedsLinkNotationModelRefresher
	}
	
	def needsLinkNotationModelRefresher(GenDiagram it) { true }
	
	def primNeedsLinkNotationModelRefresher(GenCommonBase it) { containedLinks.size() > 0 }
	
	def dispatch Iterable<GenFeature> getAffectingFeatures(GenCommonBase it) {
		containedLinks.map[it | modelFacet.affectingFeatures].flatten
	}

	def dispatch Iterable<GenFeature> getAffectingFeatures(LinkModelFacet it) {
		newArrayList()
	}
	
	def dispatch Iterable<GenFeature> getAffectingFeatures(TypeLinkModelFacet it) {
		newArrayList(childMetaFeature, sourceMetaFeature, targetMetaFeature).filter[e | e != null]
	}
	
	def dispatch Iterable<GenFeature> getAffectingFeatures(FeatureLinkModelFacet it) {
		newArrayList(metaFeature)
	}
	
	def Iterable<GenFeature> getLinkChildFeatures(GenCommonBase it) {
		getLinkChildFeatures(containedLinks)
	}

	def Iterable<GenFeature> getLinkChildFeatures(GenCommonBase it, Iterable<GenLink> someOfContainedLinks) {
		someOfContainedLinks.map[it | modelFacet.linkChildFeature].filter[e | e != null]
	}

	def dispatch GenFeature getLinkChildFeature(LinkModelFacet it) { null }

	def dispatch GenFeature getLinkChildFeature(TypeLinkModelFacet it) { childMetaFeature }

	def dispatch GenFeature getLinkChildFeature(FeatureLinkModelFacet it) { metaFeature }

	def Collection<GenCommonBase> getLinkContainersWithAncestors(GenDiagram diagram) {
		diagram.links.map[it | getPossibleContainers].flatten.buildAncestorClosure
	}

	def dispatch Iterable<? extends GenCommonBase> getContainedContainers(GenCommonBase it) { newArrayList() }

	def dispatch Iterable<? extends GenCommonBase> getContainedContainers(GenContainerBase it) { containedNodes.filter[it | true] }

	def dispatch Iterable<? extends GenCommonBase> getContainedContainers(GenNode it) {
		containedNodes.filter(GenChildContainer) +
		compartments.filter(GenCommonBase) +
		containedLinks
	}

	def dispatch Iterable<? extends GenCommonBase> getContainedContainers(GenLink it) { containedLinks }

	def Collection<GenCommonBase> buildAncestorClosure(Iterable<GenCommonBase> elements) {
		val result = newArrayList()
		result.addAll(elements)

		for(GenCommonBase next : elements) {
			addAncestors(result, next)
		}
		result
	}

	def void addAncestors(Collection<GenCommonBase> result, GenCommonBase next) {
		switch next {
			GenTopLevelNode: Collections::singleton(next.diagram)
			GenCompartment: Collections::singleton(next.node)
			GenChildNode: next.containers
			GenLink: next.getPossibleContainers
			default: Collections::emptyList
		}.forEach[e | switch e {
				GenCommonBase: if (!result.contains(e)) { 
					result.add(e)
					addAncestors(result, e)
				}
			}
		]
	}

}