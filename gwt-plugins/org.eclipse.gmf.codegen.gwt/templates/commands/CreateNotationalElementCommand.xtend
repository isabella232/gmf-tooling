package commands

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import diagram.Helper
import diagram.LinkFinder
import diagram.MetaModel

class CreateNotationalElementCommand {

	extension Helper = new Helper
	extension LinkFinder = new LinkFinder
	extension MetaModel = new MetaModel
	extension CommandUtils = new CommandUtils 
	extension CommandCommon = new CommandCommon

	def createNotationalNodeCommand(GenContainerBase it, String parentViewCode) '''
		org.eclipse.emf.ecore.EObject domainElement = descriptor.getElement();
		int nodeVisualID = descriptor.getVisualID();
		switch (nodeVisualID) {
			«FOR l: it.childNodes.filter[e | e.modelFacet != null && e.modelFacet.metaClass != null]»
			«l.createNotationalNodeCommandForChild(it, parentViewCode, 'domainElement')»
			«ENDFOR»
			default:
				return null;
		}
	'''

	def createNotationalNodeCommandForChild(GenNode it, GenContainerBase parentContainer, String parentViewCode, String domainElementCode) '''
		«createNotationalNodeCommandForChild(parentContainer, parentViewCode, domainElementCode, 'org.eclipse.gmf.runtime.gwt.commands.CreateNotationalNodeCommand')»
	'''

	def createNotationalNodeCommandForChild(GenNode it, GenContainerBase parentContainer, String parentViewCode, String domainElementCode, String createNotationalNodeCommandFQN) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			if («modelFacet.metaClass.IsInstance(domainElementCode)») {
				return new «createNotationalNodeCommandFQN»(«parentViewCode», «domainElementCode», «defaultConstraint(parentContainer.needsXYLayout() || it instanceof GenChildSideAffixedNode)», «getNotationViewFactoryQualifiedClassName()».INSTANCE, false);
			}
			return null;
	'''

	def  defaultConstraint(GenNode it, Boolean xyLayouted) '''
		«IF xyLayouted»new org.eclipse.draw2d.geometry.Rectangle(0, 0, «defaultWidth», «defaultHeight»)«ELSE»null«ENDIF»
	'''

	def createNotationalEdgeCommand(GenCommonBase it, String parentDiagramCode) '''
		«defineDecorator»
		«instantiateNotationalEdgeCommand(parentDiagramCode)»
	'''

	def defineDecorator(GenCommonBase it) '''
		org.eclipse.gmf.runtime.notation.View sourceView = getViewService().findView(linkDescriptor.getSource());
		org.eclipse.gmf.runtime.notation.View targetView = getViewService().findView(linkDescriptor.getDestination());
		org.eclipse.gmf.runtime.gwt.services.IViewDecorator decorator = null;
		if (sourceView == null || targetView == null) {
			return null;
		}
		String sourceModelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(sourceView);
		if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(sourceModelID)) {
			return null;
		}
		String targetModelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(targetView);
		if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(targetModelID)) {
			return null;
		}
		«IF needsSourceVisualID»
		int sourceVisualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(sourceView);
		«ENDIF»
		«IF needsTargetVisualID»
		int targetVisualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(targetView);
		«ENDIF»
		switch (linkDescriptor.getVisualID()) {
			«FOR l: containedLinks»
			«l.createDecorator»
			«ENDFOR»
		}
		if (decorator == null) {
			return null;
		}
	'''

	def createDecorator(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
		«getDiagram.restrictEdgeEnds('sourceVisualID', modelFacet.getSourceType())»
		«getDiagram.restrictEdgeEnds('targetVisualID', modelFacet.getTargetType())»
		if («modelFacet.linkDescriptorCondition») {
			decorator = «getNotationViewFactoryQualifiedClassName()».INSTANCE;
		}
		break;
	'''

	def instantiateNotationalEdgeCommand(GenCommonBase it, String parentDiagramCode) '''
		return new org.eclipse.gmf.runtime.gwt.commands.CreateNotationalEdgeCommand(«parentDiagramCode», linkDescriptor.getElement(), sourceView, targetView, decorator);
	'''

	def dispatch linkDescriptorCondition(LinkModelFacet it) { throw new IllegalStateException('Unexpected type') }

	def dispatch linkDescriptorCondition(TypeLinkModelFacet it) '''«metaClass.IsInstance('linkDescriptor.getElement()')»'''

	def dispatch linkDescriptorCondition(FeatureLinkModelFacet it) '''linkDescriptor.getElement() == null'''

	def  restrictEdgeEnds(GenDiagram it, String visualIdVar, GenClass expectedClass) { 
		val relatedChildLabelGenNodes = getRelatedChildLabelGenNodes(expectedClass)
		'''
			«IF relatedChildLabelGenNodes.size() > 0»
			switch («visualIdVar») {
				«FOR nextNode: relatedChildLabelGenNodes»
				case  «nextNode.getEditPartQualifiedClassName()».VISUAL_ID:
				return null;
				«ENDFOR»
			}
			«ENDIF»
		'''
	}

}
