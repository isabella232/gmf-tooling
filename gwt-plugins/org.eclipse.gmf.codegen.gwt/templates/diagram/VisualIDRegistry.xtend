package diagram

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import common.BaseClassTemplate

class VisualIDRegistry extends BaseClassTemplate<GenDiagram> {

	extension MetaModel = new MetaModel

	def className(GenDiagram it) '''«visualIDRegistryClassName»'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	override qualifiedClassName(GenDiagram it) { packageName + "." + className }

	override generate(GenDiagram it) '''
		package «editorGen.editor.packageName»;

		«generatedClassComment»
		public class «visualIDRegistryClassName» {
			«body»
		}
	'''
	
	override protected body(GenDiagram it) '''
		«getModelIDMethod»
		«getViewVisualID»
		«getVisualID»
		«getType»
		«getDiagramVisualID»
		«getNodeVisualID»
		«isDiagram»
	'''

	def getModelIDMethod(GenDiagram it) '''
		«generatedMemberComment»
		public static String getModelID(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();
			while (view != diagram) {
				org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); 
				if (annotation != null) {
					return (String) annotation.getDetails().get("modelID"); 
				}
				view = (org.eclipse.gmf.runtime.notation.View) view.eContainer();
			}
			return diagram != null ? diagram.getType() : null;
		}
	'''

	def getViewVisualID(GenDiagram it) '''
		«generatedMemberComment»
		public static int getVisualID(org.eclipse.gmf.runtime.notation.View view) {
			if (view instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				if («editPartQualifiedClassName».MODEL_ID.equals(view.getType())) {
					return «editPartQualifiedClassName».VISUAL_ID;
				} else {
					return -1;
				}
			}
			return «visualIDRegistryQualifiedClassName».getVisualID(view.getType());
		}
	'''
	
	val getVisualID = '''
		«generatedMemberComment»
		public static int getVisualID(String type) {
			try {
				return Integer.parseInt(type);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return -1;
			}
		}
	'''
	
	val getType = '''
		«generatedMemberComment»
		public static String getType(int visualID) {
			return Integer.toString(visualID);
		}
	'''

	def getDiagramVisualID(GenDiagram it) '''
		public static int getDiagramVisualID(org.eclipse.emf.ecore.EObject domainElement) {
			if (domainElement == null) {
				return -1;
			}
		«IF null != domainDiagramElement»
			«returnVisualID(it)»
		«ENDIF»
			return -1;
		}
	'''
	
	def getNodeVisualID(GenDiagram it) '''
		public static int getNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
			if (domainElement == null) {
				return -1;
			}
			String containerModelID = «qualifiedClassName».getModelID(containerView);
			if (!«editPartQualifiedClassName».MODEL_ID.equals(containerModelID)«FOR spf : shortcutsProvidedFor»«checkContainerModelID(spf)»«ENDFOR») { 
				return -1;
			}
			int containerVisualID;
			if («editPartQualifiedClassName».MODEL_ID.equals(containerModelID)) {
				containerVisualID = «qualifiedClassName».getVisualID(containerView);
			} else {
				if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
					containerVisualID = «editPartQualifiedClassName».VISUAL_ID;
				} else {
					return -1;
				}
			}
			switch (containerVisualID) {
				«FOR container : allContainers»
				«caseDomainContainerVisualID(container)»
				«ENDFOR»
			}
			return -1;
		}
	'''
	
	def caseDomainContainerVisualID(GenContainerBase it) '''
		«IF !getContainedSemanticNodes.nullOrEmpty»
			«caseVisualID(it)»
			«FOR node : getContainedSemanticNodes(it)»«returnVisualID(node)»«ENDFOR»
			break;
		«ENDIF»
	'''

	def caseVisualID(GenCommonBase it) '''
		case «editPartQualifiedClassName».VISUAL_ID:
	'''

	def returnVisualID(GenCommonBase it) '''
		if («checkSemanticElement») {
			return «editPartQualifiedClassName».VISUAL_ID;
		}
	'''

	def dispatch checkSemanticElement(GenDiagram it) '''
		«checkDomainElementMetaclass(domainDiagramElement)» && isDiagram(«castEObject(domainDiagramElement, 'domainElement')»)
	'''
	def dispatch checkSemanticElement(GenNode it) '''
		«checkDomainElementMetaclass(modelFacet.metaClass)»«checkDomainElementConstraints(it.modelFacet, it)»
	'''
	def dispatch checkSemanticElement(GenLink it) '''
		«checkSemanticElement(it.modelFacet, it)»
	'''

	def checkDomainElementMetaclass(GenClass it) '''
		«metaClass».isSuperTypeOf(domainElement.eClass())
	'''
	def checkDomainElementConstraints(TypeModelFacet it, GenCommonBase commonBase) '''
		«IF null != modelElementSelector» && «domainElementConstraintMethodName(commonBase)»(«castEObject(metaClass, 'domainElement')»)«ENDIF»
	'''

	def dispatch checkSemanticElement(LinkModelFacet it, GenLink genLink) {
		throw new IllegalStateException('checkSemanticElement is supported only for TypeLinkModelFacet: ' + it)
	}

	def dispatch checkSemanticElement(TypeLinkModelFacet it, GenLink genLink) '''
		«checkDomainElementMetaclass(metaClass)»«checkDomainElementConstraints(it, genLink)»
	'''
	
	def isDiagram(GenDiagram it) '''
		«generatedMemberComment("User can change implementation of this method to handle some specific" +
			"situations not covered by default logic."
		)»
		private static boolean isDiagram(«domainDiagramElement.qualifiedInterfaceName» element) {
			return true;
		}
	'''

	def domainElementConstraintMethodName(GenCommonBase it) '''is«getUniqueIdentifier()»'''
	
	def checkContainerModelID(String someModelId)''' && !"«someModelId»".equals(containerModelID)'''

	def getContainedSemanticNodes(GenContainerBase container) {
		container.containedNodes.filter[node | null != node.modelFacet]
	}

	def visualID(GenCommonBase base) '''«base.editPartQualifiedClassName».VISUAL_ID'''
	def getVisualIdMethodName(GenDiagram xptSelf) '''getVisualID'''
	def getModelIDMethodName(GenDiagram xptSelf) '''getModelID'''
	def getVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName».«getVisualIdMethodName»'''
	def getModelIDMethodCall(GenDiagram it) '''«qualifiedClassName».«getModelIDMethodName»'''
	def modelID(GenDiagram it) '''«editPartQualifiedClassName».MODEL_ID'''

}