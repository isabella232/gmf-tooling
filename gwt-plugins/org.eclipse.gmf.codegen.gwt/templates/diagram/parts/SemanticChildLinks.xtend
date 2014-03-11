package diagram.parts

import java.util.ArrayList
import java.util.Collection
import java.util.LinkedHashMap
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import diagram.LinkFinder
import diagram.MetaModel

class SemanticChildLinks {
	
	extension LinkFinder = new LinkFinder
	extension LinkNotationModelRefresherHelper = new LinkNotationModelRefresherHelper
	extension MetaModel = new MetaModel

	def getTypeGenLinksForFeature(GenCommonBase container, GenFeature feature, Iterable<GenLink> containedLinks) {
		buildGenChildFeature2LinkMaps(container, containedLinks).get('type').get(feature)
	}

	def getFeatureGenLinksForFeature(GenCommonBase container, GenFeature feature, Iterable<GenLink> containedLinks) {
		buildGenChildFeature2LinkMaps(container, containedLinks).get('feature').get(feature)
	}

	private def buildGenChildFeature2LinkMaps(GenCommonBase container, Iterable<GenLink> containedLinks) {
		val genFeature2TypeGenLinkMap = new LinkedHashMap<GenFeature, Collection<GenLink>>();
		val genFeature2FeatureGenLinkMap = new LinkedHashMap<GenFeature, Collection<GenLink>>();
		containedLinks.forEach[l |
			switch facet: l.modelFacet {
				TypeLinkModelFacet: {
					val metaFeature = facet.getChildMetaFeature()
					if (!genFeature2TypeGenLinkMap.containsKey(metaFeature)) {
						genFeature2TypeGenLinkMap.put(metaFeature, new ArrayList<GenLink>())
					}
					genFeature2TypeGenLinkMap.get(metaFeature).add(l)
				}
				FeatureLinkModelFacet: {
					val metaFeature = facet.getMetaFeature()
					if (!genFeature2FeatureGenLinkMap.containsKey(metaFeature)) {
						genFeature2FeatureGenLinkMap.put(metaFeature, new ArrayList<GenLink>())
					}
					genFeature2FeatureGenLinkMap.get(metaFeature).add(l)
				}
			}
		]
		#{
			'feature' -> genFeature2FeatureGenLinkMap,
			'type' -> genFeature2TypeGenLinkMap
		}
	}

	def semanticChildLinks(GenCommonBase it, String parentViewCode) {
		val genTypeLinkFeatures = getLinkChildFeatures(it, containedTypeModelFacetLinks(it))
		val genFeatureLinkFeatures = getLinkChildFeatures(it, containedFeatureModelFacetLinks(it))
		'''
			«IF genTypeLinkFeatures.size() + genFeatureLinkFeatures.size() == 0»
			return java.util.Collections.<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor> emptyList();
			«ELSE»
			java.util.List<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor> result = new java.util.LinkedList<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor>();
			org.eclipse.emf.ecore.EObject modelObject = «parentViewCode».getElement();
			org.eclipse.emf.ecore.EObject nextValue;
			«IF genTypeLinkFeatures.size() > 0»
			int linkVID;
			«ENDIF»
			«FOR metaFeature: genTypeLinkFeatures»
				«typeLinkFeature(it, metaFeature)»
			«ENDFOR»
			«FOR metaFeature: genFeatureLinkFeatures»
			«val genLinksCollection = getFeatureGenLinksForFeature(it, metaFeature, containedLinks(it))»
			«IF metaFeature.ecoreFeature.many»
			for(java.util.Iterator it = «metaFeature.getFeatureValue('modelObject', null, true)».iterator(); it.hasNext(); ) {
				nextValue = (org.eclipse.emf.ecore.EObject) it.next();
				«ELSE»
			nextValue = (org.eclipse.emf.ecore.EObject) «metaFeature.getFeatureValue('modelObject', null, false)»;
				«ENDIF»
			if (nextValue != null) {
			«FOR nextLink: genLinksCollection»
			result.add(new org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor(modelObject, nextValue, null, «nextLink.getEditPartQualifiedClassName()».VISUAL_ID));
			«ENDFOR»
			}
			«IF metaFeature.ecoreFeature.many»
			}
			«ENDIF»
			«ENDFOR»
			return result;
			«ENDIF»
		'''
	}
	
	def typeLinkFeature(GenCommonBase it, GenFeature metaFeature) {
		val genLinksCollection = getTypeGenLinksForFeature(it, metaFeature, containedLinks(it))
		'''
			«IF metaFeature.ecoreFeature.many»
			for(java.util.Iterator it = «metaFeature.getFeatureValue('modelObject', null, true)».iterator(); it.hasNext(); ) {
				nextValue = (org.eclipse.emf.ecore.EObject) it.next();
			«ELSE»
			nextValue = (org.eclipse.emf.ecore.EObject) «metaFeature.getFeatureValue('modelObject', null, false)»;
			«ENDIF»
			linkVID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getLinkWithClassVisualID(nextValue);
			«IF genLinksCollection.size() > 1»
			switch (linkVID) {
			«ENDIF»
			«FOR nextLink: genLinksCollection»
			«IF genLinksCollection.size() > 1»
			case «nextLink.getEditPartQualifiedClassName()».VISUAL_ID: {
			«ELSE»
			if («nextLink.getEditPartQualifiedClassName()».VISUAL_ID == linkVID) {
			«ENDIF»
			«val sourceFeature = (nextLink.modelFacet as TypeLinkModelFacet).sourceMetaFeature»
			«IF sourceFeature != null»
				«IF sourceFeature.ecoreFeature.many»
				java.util.List sources = «sourceFeature.getFeatureValue('nextValue', null, true)»;
				org.eclipse.emf.ecore.EObject source = sources.size() == 1 ? (org.eclipse.emf.ecore.EObject) sources.get(0) : null;
				«ELSE»
				org.eclipse.emf.ecore.EObject source = (org.eclipse.emf.ecore.EObject) «sourceFeature.getFeatureValue('nextValue', null, false)»;
				«ENDIF»
			«ELSE»
			org.eclipse.emf.ecore.EObject source = modelObject;
			«ENDIF»
			«val targetFeature = (nextLink.modelFacet as TypeLinkModelFacet).targetMetaFeature»
				«IF targetFeature != null»
				«IF targetFeature.ecoreFeature.many»
				java.util.List targets = «targetFeature.getFeatureValue('nextValue', null, true)»;
				org.eclipse.emf.ecore.EObject target = targets.size() == 1 ? (org.eclipse.emf.ecore.EObject) targets.get(0) : null;
				«ELSE»
				org.eclipse.emf.ecore.EObject target = (org.eclipse.emf.ecore.EObject) «targetFeature.getFeatureValue('nextValue', null, false)»;
				«ENDIF»
				«ELSE»
				org.eclipse.emf.ecore.EObject target = modelObject;
				«ENDIF»
			if (source != null && target != null) {
				result.add(new org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor(source, target, nextValue, linkVID));
			}
			«IF genLinksCollection.size() > 1»
			break;
			}
			«ELSE»
			}
			«ENDIF»
			«ENDFOR»
			«IF genLinksCollection.size() > 1»
			}
			«ENDIF»
			«IF metaFeature.ecoreFeature.many»
			}
			«ENDIF»
		'''
	}
}
