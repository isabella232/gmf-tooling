package diagram.parts

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import common.Common
import commands.CommandCommon
import diagram.MetaModel
import diagram.PhantomUtils

class SemanticChildren {

	extension NotationModelRefresherHelper = new NotationModelRefresherHelper
	extension PhantomUtils = new PhantomUtils
	extension MetaModel = new MetaModel
	extension CommandCommon = new CommandCommon
	extension Common = new Common

	protected def getGenNodes(GenContainerBase genContainerBase, GenFeature genFeature) {
		val result = buildGenChildFeature2genNodeMap(genContainerBase).get(genFeature)
		if (result == null) newArrayList() else result
	}

	protected def buildGenChildFeature2genNodeMap(GenContainerBase genContainerBase) {
		switch genContainerBase {
			GenDiagram: genContainerBase.topLevelNodes
			GenChildContainer: genContainerBase.getChildNodes
		}.fold(newHashMap(), [m, n |
			val feature = n?.modelFacet?.childMetaFeature
			if (feature != null) {
			 	if (!m.containsKey(feature)) {
					m.put(feature, newArrayList())
				}
				m.get(feature).add(n)
			}
			m
		])
	}

	def semanticChildren(GenContainerBase it, String viewCode) '''
		«IF !needsNotationModelRefresher()»
		return java.util.Collections.<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor> emptyList();
		«ELSE»
		java.util.List<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor> result = new java.util.LinkedList<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor>();
		org.eclipse.gmf.runtime.notation.View viewObject = «viewCode»;
		org.eclipse.emf.ecore.EObject modelObject = viewObject.getElement();
		org.eclipse.emf.ecore.EObject nextValue;
		int nodeVID;
		«addPhantoms»
		«FOR childMetaFeature: getChildFeatures()»
		«val genNodesCollection = getGenNodes(it, childMetaFeature)»
		«IF genNodesCollection.size() > 0»
		«IF childMetaFeature.ecoreFeature.many»
		for(java.util.Iterator<? extends org.eclipse.emf.ecore.EObject> it = «childMetaFeature.getFeatureValue("modelObject", null, true)».iterator(); it.hasNext(); ) {
			nextValue = it.next();
			«ELSE»
			nextValue = «getFeatureValue(childMetaFeature, 'modelObject', null, false)»;
			«ENDIF»
			nodeVID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getNodeVisualID(viewObject, nextValue);
			«val generateSwitch = genNodesCollection.size() > 1»
			«IF generateSwitch»
			switch (nodeVID) {
			«ENDIF»
			«FOR nextNode: genNodesCollection»
			«IF generateSwitch»
			case «nextNode.getEditPartQualifiedClassName()».VISUAL_ID: {
			«ELSE»
			if («nextNode.getEditPartQualifiedClassName()».VISUAL_ID == nodeVID) {
			«ENDIF»
				result.add(new org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor(nextValue, nodeVID));
			«IF generateSwitch»
			break;
			}
			«ELSE»
			}
			«ENDIF»
			«ENDFOR»
			«IF generateSwitch»
			}
			«ENDIF»
			«IF childMetaFeature.ecoreFeature.many»
			}
			«ENDIF»
		«ENDIF»
	«ENDFOR»
		return result;
	«ENDIF»
	'''

	def dispatch addPhantoms (GenContainerBase it) ''''''
	
	def dispatch addPhantoms (GenDiagram it) '''
		«IF getPhantomNodes(it).size() > 0»
		org.eclipse.emf.ecore.resource.Resource resource = «getPhantomContainmentResource('viewObject')»;
		for (java.util.Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator.hasNext(); ) {
			org.eclipse.emf.ecore.EObject childElement = (org.eclipse.emf.ecore.EObject) semanticIterator.next();
			if (childElement == modelObject) {
				continue;
			}
			nodeVID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getNodeVisualID(viewObject, childElement);
			switch (nodeVID) {
			«FOR node: getPhantomNodes(it)»«addNextIfPhantom(node)»«ENDFOR»
			}
		}
		«ENDIF»
	'''
	
	def addNextIfPhantom (GenTopLevelNode it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID: {
			«val phantomFeatures = it.getPhantomFeatures()»
			org.eclipse.emf.ecore.EStructuralFeature containmentFeature = childElement.eContainmentFeature();
			if (childElement.eContainer() == null«IF phantomFeatures.size() > 0» || «FOR  feature: phantomFeatures SEPARATOR '||'»«checkFeature(feature)»«ENDFOR»«ENDIF») {
				result.add(new org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor(childElement, nodeVID));
			}
		break;
		}
	'''

	def checkFeature(GenFeature it) '''containmentFeature == «metaFeature»'''

	def getPhantomNodesIterator (GenContainerBase it) ''''''

	def getPhantomNodesIterator (GenDiagram it) '''
		«IF getPhantomNodes().size() > 0»
		«generatedMemberComment('By default, returns all contents of the resource. If phantoms are known to be confined in a subset of the resource contents,\n' + 
		'overwriting this method (and marking it as generated NOT) will significantly improve performance.')»
		private java.util.Iterator getPhantomNodesIterator(org.eclipse.emf.ecore.resource.Resource resource) {
			return resource.getAllContents();
		}
		«ENDIF»
	'''

}