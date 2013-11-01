/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #372479, #386838
 */
package xpt.editor

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import com.google.inject.Inject
import xpt.Common
import xpt.Common_qvto
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.ValueExpression
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import xpt.diagram.updater.Utils_qvto
import xpt.CodeStyle
import xpt.diagram.editpolicies.LinkUtils_qvto
import plugin.Activator

//XXX: [MG] decide what to do with @MetaDef methods
class VisualIDRegistry {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;
	@Inject extension LinkUtils_qvto;
	
	@Inject Activator xptActivator
	@Inject CodeStyle xptCodeStyle;
	@Inject MetaModel xptMetaModel;
	@Inject xpt.expressions.getExpression xptGetExpression;
	
	@MetaDef def getVisualIdMethodName(GenDiagram xptSelf) '''getVisualID'''

	@MetaDef def getModelIDMethodName(GenDiagram xptSelf) '''getModelID'''

	@MetaDef def getVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«getVisualIdMethodName(it)»'''

	@MetaDef def getModelIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«getModelIDMethodName(it)»'''

	/**
	 * FIXME: static because its used from xpt.Common (also imported here), to avoid cyclic injection 
	 */
	@MetaDef static def visualID(GenCommonBase xptSelf) '''«xptSelf.editPartQualifiedClassName».VISUAL_ID'''

	/**
	 * FIXME: static because its used from xpt.Common (also imported here), to avoid cyclic injection  
	 */
	@MetaDef static def modelID(GenDiagram xptSelf) '''«xptSelf.editPartQualifiedClassName».MODEL_ID'''

	/**
	 * XXX looks like these methods would produce incorrect result for visualID of GenDiagram itself 
	 * check if getType() method shouldn't be fixed similar to getVisualID, i.e. map diagram's visual id to MODEL_ID instead plain String.valueOf() 
	 */
	@MetaDef def /*!dispatch*/ typeMethodCall(GenCommonBase xptSelf, CharSequence visualIdVar) '''«xptSelf.diagram.
		visualIDRegistryQualifiedClassName».«getTypeMethodName(xptSelf.diagram)»(«visualIdVar»)'''

	@MetaDef def /*!dispatch*/ typeMethodCall(GenCommonBase xptSelf) '''«typeMethodCall(xptSelf, visualID(xptSelf).toString)»'''

	@MetaDef def getTypeMethodName(GenDiagram xptSelf) '''getType'''

	@MetaDef def runtimeTypedInstanceName(GenDiagram it) '''TYPED_INSTANCE'''

	@MetaDef def runtimeTypedInstanceCall(GenDiagram it) '''«qualifiedClassName(it)».«runtimeTypedInstanceName(it)»'''
	
	@MetaDef def getDiagramVisualIDMethodName(GenDiagram it) '''getDiagramVisualID'''
	
	@MetaDef def getDiagramVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«getDiagramVisualIDMethodName(it)»'''
	
	@MetaDef def getNodeVisualIDMethodName(GenDiagram it) '''getNodeVisualID'''

	@MetaDef def getNodeVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«getNodeVisualIDMethodName(it)»'''
	
	@MetaDef def canCreateNodeMethodName(GenDiagram it) '''canCreateNode'''
	
	@MetaDef def canCreateNodeMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«canCreateNodeMethodName(it)»'''

	@MetaDef def getLinkWithClassVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«getLinkWithClassVisualIDMethodName(it)»'''
	
	@MetaDef def getLinkWithClassVisualIDMethodName(GenDiagram it) '''getLinkWithClassVisualID'''
	
	@MetaDef def domainElementConstraintMethodName(GenCommonBase it) '''is«getUniqueIdentifier()»'''
	
	@MetaDef def checkNodeVisualIDMethodName(GenDiagram it) '''checkNodeVisualID'''
	
	@MetaDef def checkNodeVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«checkNodeVisualIDMethodName(it)»'''
	
	@MetaDef def isCompartmentVisualIDMethodName(GenDiagram it) '''isCompartmentVisualID'''

	@MetaDef def isCompartmentVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«isCompartmentVisualIDMethodName(it)»'''
	
	@MetaDef def isSemanticLeafVisualIDMethodName(GenDiagram it) '''isSemanticLeafVisualID'''
	
	@MetaDef def isSemanticLeafVisualIDMethodCall(GenDiagram it) '''«qualifiedClassName(it)».«isSemanticLeafVisualIDMethodName(it)»'''

	
	/**
	 * [MG]: this set of def dispatch'es had been moved from xpt.editor.Utils.qvto as local for VisualIDRegistry
	 */
	def dispatch Iterable<GenCommonBase> getEssentialVisualChildren(GenCommonBase it) {
		return <GenCommonBase>newLinkedList()
	}
	
	/**
	 * [MG]: this set of def dispatch'es had been moved from xpt.editor.Utils.qvto as local for VisualIDRegistry
	 */
	def dispatch Iterable<GenCommonBase> getEssentialVisualChildren(GenLink it) {
		return it.labels.filter(typeof(GenCommonBase))
	}
	
	/**
	 * [MG]: this set of def dispatch'es had been moved from xpt.editor.Utils.qvto as local for VisualIDRegistry
	 */
	def dispatch Iterable<GenCommonBase> getEssentialVisualChildren(GenContainerBase it) {
		return it.containedNodes.filter(typeof(GenCommonBase))
	}
	
	/**
	 * [MG]: this set of def dispatch'es had been moved from xpt.editor.Utils.qvto as local for VisualIDRegistry
	 */
	def dispatch Iterable<GenCommonBase> getEssentialVisualChildren(GenNode it) {
		var result = <GenCommonBase>newLinkedList()
		result.addAll(it.labels)
		result.addAll(it.compartments)
		result.addAll(it.containedNodes)
		return result
	}
	
	def Iterable<GenNode> getContainedSemanticNodes(GenContainerBase container) {
		return container.containedNodes.filter[node | null != node.modelFacet]
	}
	
	def className(GenDiagram it) '''«visualIDRegistryClassName»'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def VisualIDRegistry(GenDiagram it) '''
	«copyright(getDiagram().editorGen)»
	package «packageName(it)»;

	«generatedClassComment(
		'This registry is used to determine which type of visual object should be\n' + 
		'created for the corresponding Diagram, Node, ChildNode or Link represented\n' + 
		'by a domain model object.\n'	
	)»
	public class «className(it)» {

		«attributes(it)»
	
		«getViewVisualID(it)»
		
		«getModelID(it)»
		
		«getVisualID(it)»
	
		«getType(it)»
		
		«getDiagramVisualID(it)»
		
		«getNodeVisualID(it)»
		
		«canCreateNode(it)»
		
		«getLinkWithClassVisualID(it)»
		
		«isDiagram(it)»
	
		«constraintMethods(it)»
		
		«checkNodeVisualID(it)»
	
		«isCompartmentVisualID(it)»
	
		«isSemanticLeafVisualID(it)»
	
		«runtimeTypedInstance(it)»
	
		«additions(it)»	
	}
	'''

	def attributes(GenDiagram it) '''
		«generatedMemberComment()»
		private static final String DEBUG_KEY = "«editorGen.plugin.ID»/debug/visualID"; «nonNLS(1)»
	'''

	def getViewVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static int «getVisualIdMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
			if (view instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				if («modelID(it)».equals(view.getType())) {
					return «visualID(it)»;
				} else {
					«unrecognizedVID(it)»
				}
			}
			return «getVisualIDMethodCall(it)»(view.getType());
		}
	'''

	def getModelID(GenDiagram it) '''
		«generatedMemberComment()»
		public static String «getModelIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();
			while (view != diagram) {
				org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); «nonNLS(1)»
				if (annotation != null) {
					return (String) annotation.getDetails().get("modelID"); «nonNLS(1)»
				}
				view = (org.eclipse.gmf.runtime.notation.View) view.eContainer();
			}
			return diagram != null ? diagram.getType() : null;
		}
	'''

	def getVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static int «getVisualIdMethodName(it)»(String type) {
			try {
				return Integer.parseInt(type);
			} catch (NumberFormatException e) {
				if (Boolean.TRUE.toString().equalsIgnoreCase(org.eclipse.core.runtime.Platform.getDebugOption(DEBUG_KEY))) {
					«xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().logError("Unable to parse view type as a visualID number: " + type);
				}
			}
			«unrecognizedVID(it)»
		}
	'''

	def getType(GenDiagram it) '''
	«generatedMemberComment()»
	public static String «getTypeMethodName(it)»(int visualID) {
		return Integer.toString(visualID);
	}
	'''

	def getDiagramVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static int «getDiagramVisualIDMethodName(it)»(org.eclipse.emf.ecore.EObject domainElement) {
			if (domainElement == null) {
				«unrecognizedVID(it)»
			}
		«IF null != domainDiagramElement»
			«returnVisualID(it)»
		«ENDIF»
			«unrecognizedVID(it)»
		}
	'''

	def returnVisualID(GenCommonBase it) '''
	if («checkSemanticElement(it)») {
		return «visualID(it)»;
	}
	'''

	def dispatch checkSemanticElement(GenCommonBase it) '''
		«ERROR('checkSemanticElement not supported for: ' + it)»
	'''
	
	def dispatch checkSemanticElement(GenDiagram it) '''«checkDomainElementMetaclass(domainDiagramElement)» && isDiagram(«xptMetaModel.CastEObject(domainDiagramElement, 'domainElement')»)'''
	def dispatch checkSemanticElement(GenNode it) '''«checkDomainElementMetaclass(modelFacet.metaClass)»«checkDomainElementConstraints(it.modelFacet, it)»'''
	def dispatch checkSemanticElement(GenLink it) '''«checkSemanticElement(it.modelFacet, it)»'''

	def checkDomainElementMetaclass(GenClass it) '''«xptMetaModel.MetaClass(it)».isSuperTypeOf(domainElement.eClass())'''

	def checkDomainElementConstraints(TypeModelFacet it, GenCommonBase commonBase) 
	'''«IF null != modelElementSelector» && «domainElementConstraintMethodName(commonBase)»(«xptMetaModel.CastEObject(metaClass, 'domainElement')»)«ENDIF»'''

	def dispatch checkSemanticElement(LinkModelFacet it, GenLink genLink) '''«ERROR('checkSemanticElement is supported only for TypeLinkModelFacet: ' + it)»'''
	def dispatch checkSemanticElement(TypeLinkModelFacet it, GenLink genLink) '''«checkDomainElementMetaclass(metaClass)»«checkDomainElementConstraints(it, genLink)»'''


	def getNodeVisualID(GenDiagram it) '''
	«generatedMemberComment()»
	public static int «getNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
		if (domainElement == null) {
			«unrecognizedVID(it)»
		}
		String containerModelID = «getModelIDMethodCall(it)»(containerView);
		if (!«modelID(it)».equals(containerModelID)«FOR spf : shortcutsProvidedFor»«checkContainerModelID(spf)»«ENDFOR») { «nonNLS_All(shortcutsProvidedFor)»
			«unrecognizedVID(it)»
		}
		int containerVisualID;
		if («modelID(it)».equals(containerModelID)) {
			containerVisualID = «getVisualIDMethodCall(it)»(containerView);
		} else {
			if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				containerVisualID = «visualID(it)»;		
			} else {
				«unrecognizedVID(it)»
			}
		}
		switch (containerVisualID) {
			«FOR container : allContainers»
			«caseDomainContainerVisualID(container)»
			«ENDFOR»
		}
		«unrecognizedVID(it)»
	}
	'''

	def caseDomainContainerVisualID(GenContainerBase it) '''
		«IF getContainedSemanticNodes(it).notEmpty»
	«caseVisualID(it)»
		«FOR node : getContainedSemanticNodes(it)»«returnVisualID(node)»«ENDFOR»
		break;
		«ENDIF»
	'''

	def canCreateNode(GenDiagram it) '''
	«generatedMemberComment()»
	public static boolean «canCreateNodeMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, int nodeVisualID) {
		String containerModelID = «getModelIDMethodCall(it)»(containerView);
		if (!«modelID(it)».equals(containerModelID)«FOR spf : shortcutsProvidedFor»«checkContainerModelID(spf)»«ENDFOR») { «nonNLS_All(shortcutsProvidedFor)»
			return false;
		}
		int containerVisualID;
		if («modelID(it)».equals(containerModelID)) {
			containerVisualID = «getVisualIDMethodCall(it)»(containerView);
		} else {
			if (containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				containerVisualID = «visualID(it)»;		
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
			«FOR container : allContainers.filter[e|getEssentialVisualChildren(e).notEmpty]»«checkEssentialChildren(container)»«ENDFOR»
			«FOR link : links.filter[l|getEssentialVisualChildren(l).notEmpty]»«checkEssentialChildren(link)»«ENDFOR»
		}
		return false;
	}
	'''

	def checkContainerModelID(String someModelId)''' && !"«someModelId»".equals(containerModelID)'''

	def checkEssentialChildren(GenCommonBase it) '''
	«caseVisualID(it)»
		«FOR child : getEssentialVisualChildren(it)»«checkEssentialChild(child)»«ENDFOR»
		break;
	'''

	def checkEssentialChild(GenCommonBase it) '''
	if («visualID(it)» == nodeVisualID) {
		return true;
	}
	'''

	def getLinkWithClassVisualID(GenDiagram it) '''
	«generatedMemberComment()»
	public static int «getLinkWithClassVisualIDMethodName(it)»(org.eclipse.emf.ecore.EObject domainElement) {
		if (domainElement == null) {
			«unrecognizedVID(it)»
		}
		«FOR typeLink : links.filter[l|isTypeLink(l)]»«returnVisualID(typeLink)»«ENDFOR»
		«unrecognizedVID(it)»
	}
	'''

	def isDiagram(GenDiagram it) '''
	«IF null != domainDiagramElement»
		«generatedMemberComment(
				'User can change implementation of this method to handle some specific\n' + 
				'situations not covered by default logic.\n'
		)»
		private static boolean isDiagram(«xptMetaModel.QualifiedClassName(domainDiagramElement)» element) {
			return true;
		}
	«ENDIF»
	'''

	/**
	 * Support for extra contstraints to check about model element.
	 * Includes expression fields for interpreted constrains (like ocl or regexp).
	 * For each model element that has an associated constraint, there's a method is<DomainElement>_<UID>()
	 * that performs extra specification as defined by value expression
	 * 
	 * FIXME don't use static fields, replace with instance/separate cache (e.g. accessible from Activator)
	 */		
	def constraintMethods(GenDiagram it) '''
	«IF null != editorGen.expressionProviders»
		«FOR topNode : topLevelNodes.filter[n | n.modelFacet.modelElementSelector != null]»«constraintMethod(topNode)»«ENDFOR»
		«FOR childNode : childNodes.filter[n | n.modelFacet.modelElementSelector != null]»«constraintMethod(childNode)»«ENDFOR»
		«FOR link : links»«constraintMethod(link.modelFacet, link)»«ENDFOR»
	«ENDIF»
	'''

	def constraintMethod(GenNode it) 
	'''«domainElementConstraintMethod(modelFacet.modelElementSelector.provider, it, modelFacet.modelElementSelector, modelFacet.metaClass)»'''

	def dispatch constraintMethod(LinkModelFacet it, GenLink l) '''''' // no-op
	def dispatch constraintMethod(TypeLinkModelFacet it, GenLink l) 
	'''«IF modelElementSelector != null»«domainElementConstraintMethod(modelElementSelector.provider, l, modelElementSelector, metaClass)»«ENDIF»'''


	def dispatch domainElementConstraintMethod(GenExpressionProviderBase it, GenCommonBase diagramElement, ValueExpression expression, GenClass context)
		'''«ERROR('Constraint method is not supported for ' + it)»'''

	def dispatch domainElementConstraintMethod(GenJavaExpressionProvider it, GenCommonBase diagramElement, ValueExpression expression, GenClass context) '''
		«generatedMemberComment()»
		private static boolean «domainElementConstraintMethodName(diagramElement)»(«xptMetaModel.QualifiedClassName(context)» domainElement) {
		«IF injectExpressionBody && (expression.body != null && !expression.body.empty)»
			«expression.body»
		«ELSEIF throwException || (injectExpressionBody && (expression.body == null || expression.body.empty))»
			// FIXME: implement this method 
			// Ensure that you remove @generated or mark it @generated NOT
			throw new java.lang.UnsupportedOperationException("No java implementation provided in '«domainElementConstraintMethodName(diagramElement)»' operation");«nonNLS(1)»
		«ELSE»
			return false;
		«ENDIF»
		}
	'''

	// FIXME move these methods to ElementInitializers or any other more suitable place
	def dispatch domainElementConstraintMethod(GenExpressionInterpreter it, GenCommonBase diagramElement, ValueExpression expression, GenClass context)'''
		«generatedMemberComment()»
		private static boolean «domainElementConstraintMethodName(diagramElement)»(«xptMetaModel.QualifiedClassName(context)» domainElement) {
			Object result = «xptGetExpression.getExpression(it, expression, context)».evaluate(domainElement);
			return result instanceof Boolean && ((Boolean)result).booleanValue();
		}			
	'''
	// Constraints support end.


	def unrecognizedVID(GenDiagram it) '''
	return -1;
	'''
	
	def checkNodeVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static boolean «checkNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {
			if (candidate == -1){
				//unrecognized id is always bad
				return false;
			}
			int basic = «getNodeVisualIDMethodName(it)»(containerView, domainElement);
			return basic == candidate;
		}
	'''


	def isCompartmentVisualID(GenDiagram it) '''
		«generatedMemberComment()»
		public static boolean «isCompartmentVisualIDMethodName(it)»(int visualID) {
			«IF compartments.notEmpty»
				switch (visualID) {
					«FOR compartment : compartments»«caseVisualID(compartment)»«ENDFOR»
						return true;
					default:
						break;
				}
			«ENDIF»
			return false;
		}
	'''

	def isSemanticLeafVisualID(GenDiagram it) {
		var leafs = it.allNodes.filter[n | getSemanticChildren(n).empty && n.compartments.forall[c | getSemanticChildren(c).empty]].sortBy[n|n.visualID]
		return '''
		«generatedMemberComment()»
		public static boolean «isSemanticLeafVisualIDMethodName(it)»(int visualID) {
			switch (visualID) {
				«/*We need to ensure at last one case, this is legitimate way*/
				caseVisualID(it)»
					return false;
				«IF leafs.notEmpty»
				«FOR leaf : leafs»«caseVisualID(leaf)»«ENDFOR»
					return true;
				«ENDIF»
				default:
					break;
			}
			return false;
		}
	'''
	}

	def runtimeTypedInstance(GenDiagram it) '''
		«generatedClassComment()»
		public static final org.eclipse.gmf.tooling.runtime.structure.DiagramStructure «runtimeTypedInstanceName(it)» = new org.eclipse.gmf.tooling.runtime.structure.DiagramStructure() {
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public int «getVisualIdMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getVisualIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public String «getModelIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				return «getModelIDMethodCall(it)»(view);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public int «getNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
				return «getNodeVisualIDMethodCall(it)»(containerView, domainElement);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public boolean «checkNodeVisualIDMethodName(it)»(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement, int candidate) {
				return «checkNodeVisualIDMethodCall(it)»(containerView, domainElement, candidate);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public boolean «isCompartmentVisualIDMethodName(it)»(int visualID) {
				return «isCompartmentVisualIDMethodCall(it)»(visualID);
			}
			
			«generatedMemberComment()»
			«xptCodeStyle.overrideI(it)»
			public boolean «isSemanticLeafVisualIDMethodName(it)»(int visualID) {
				return «isSemanticLeafVisualIDMethodCall(it)»(visualID);
			}
		};
	'''

	def caseVisualID(GenCommonBase xptSelf) '''case «VisualIDRegistry::visualID(xptSelf)»:'''

	def additions(GenDiagram it) ''''''
}
