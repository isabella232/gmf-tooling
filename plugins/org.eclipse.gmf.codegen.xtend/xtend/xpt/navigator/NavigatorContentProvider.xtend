/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.editor.VisualIDRegistry
import com.google.inject.Inject
import xpt.Externalizer
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorReferenceType
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorPathSegment

@com.google.inject.Singleton class NavigatorContentProvider {
	@Inject extension xpt.Common;
	@Inject extension xpt.Common_qvto;
	@Inject extension xpt.navigator.Utils_qvto;

	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject Externalizer xptExternalizer;
	@Inject NavigatorGroup navigatorGroup;
	@Inject AbstractNavigatorItem abstractNavigatorItem;
	@Inject NavigatorItem xptNavigatorItem

	def className(GenNavigator it) '''«it.contentProviderClassName»'''

	def packageName(GenNavigator it) '''«it.packageName»'''

	def qualifiedClassName(GenNavigator it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenNavigator it) '''«qualifiedClassName(it)»'''

	def NavigatorContentProvider(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» implements org.eclipse.ui.navigator.ICommonContentProvider {
		
			«attributes(it)»
			
			«constructor(it)»
		
			«iContentProvider(it)»
			
			«iStructuredContentProvider(it)»
			
			«iMementoAware(it)»
			   
			   «iCommonContentProvider(it)»
			   
			   «iTreeContentProvider(it)»
			   
			   «additions(it)»
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private static final Object[] EMPTY_ARRAY = new Object[0];
		
		«generatedMemberComment()»
		private org.eclipse.jface.viewers.Viewer myViewer;
		
		«generatedMemberComment()»
		private org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain myEditingDomain;
		
		«generatedMemberComment()»
		private org.eclipse.emf.workspace.util.WorkspaceSynchronizer myWorkspaceSynchronizer;
		
		«generatedMemberComment()»
		private Runnable myViewerRefreshRunnable;
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
		public «className(it)»() {
			«initCommonAttributes(it)»
		}
	'''

	def initCommonAttributes(GenNavigator it) '''
		org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = «createEditingDomain(it)»;
		myEditingDomain = (org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new java.util.HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new org.eclipse.emf.workspace.util.WorkspaceSynchronizer(editingDomain, new org.eclipse.emf.workspace.util.WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}
		
			public boolean handleResourceChanged(final org.eclipse.emf.ecore.resource.Resource resource) {
				«processChanges(it)»
			}
			
			public boolean handleResourceDeleted(org.eclipse.emf.ecore.resource.Resource resource) {
				«processChanges(it)»
			}
			
			public boolean handleResourceMoved(org.eclipse.emf.ecore.resource.Resource resource, final org.eclipse.emf.common.util.URI newURI) {
				«processChanges(it)»
			}
		});
	'''

	def processChanges(GenNavigator it) '''
		unloadAllResources();
		asyncRefresh();
		return true;
	'''

	def iContentProvider(GenNavigator it) '''
		«dispose(it)»
		
		«inputChanged(it)»
		
		«/** unloadAllResources and asyncRefresh are package-visible because are accessed from WorkspaceSynchronizer.Delegate inner class */generatedMemberComment()»
		void unloadAllResources() {
			for (org.eclipse.emf.ecore.resource.Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
				nextResource.unload();
			}
		}
		
		«generatedMemberComment()»
		void asyncRefresh() {
			if (myViewer != null && !myViewer.getControl().isDisposed()) {
				myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
			}
		}
	'''

	def dispose(GenNavigator it) '''
		«generatedMemberComment()»
		public void dispose() {
			myWorkspaceSynchronizer.dispose();
			myWorkspaceSynchronizer = null;
			myViewerRefreshRunnable = null;
			myViewer = null;
			unloadAllResources();
			((org.eclipse.emf.transaction.TransactionalEditingDomain) myEditingDomain).dispose();
			myEditingDomain = null;
		}
	'''

	def inputChanged(GenNavigator it) '''
			«generatedMemberComment()»
		public void inputChanged(org.eclipse.jface.viewers.Viewer viewer, Object oldInput, Object newInput) {
			myViewer = viewer;
		}
	'''

	def iStructuredContentProvider(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
	'''

	def iMementoAware(GenNavigator it) '''
		«generatedMemberComment()»
		public void restoreState(org.eclipse.ui.IMemento aMemento) {
		}
		
		«generatedMemberComment()»
		public void saveState(org.eclipse.ui.IMemento aMemento) {
		}
	'''

	def iCommonContentProvider(GenNavigator it) '''
		«generatedMemberComment()»
		public void init(org.eclipse.ui.navigator.ICommonContentExtensionSite aConfig) {
		}
	'''

	def iTreeContentProvider(GenNavigator it) '''
		«getChildren(it)»
		
		«getParent(it)»
		
		«hasChildren(it)»
	'''

	def getChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof org.eclipse.core.resources.IFile) {
				«getFileChildren(it)»
				 	} 
				 		
				 	if (parentElement instanceof «navigatorGroup.qualifiedClassName(it)») {
				«getGroupChildren(it)»
			} 
				
			if (parentElement instanceof «xptNavigatorItem.qualifiedClassName(it)») {
				«getItemChildren()»
			}
				
			«IF editorGen.diagram.generateShortcutIcon()»
				«getAdaptableChildren(it)»
			«ENDIF»
			«getOtherChildren(it)»
		}
		    
		«getViewChildren(it)»
		
		«utilityMethods(it)»
	'''

	def getParent(GenNavigator it) '''
		«generatedMemberComment()»
		public Object getParent(Object element) {
			if (element instanceof «abstractNavigatorItem.qualifiedClassName(it)») {
			   	«abstractNavigatorItem.qualifiedClassName(it)» abstractNavigatorItem = («abstractNavigatorItem.qualifiedClassName(it)») element;
			return abstractNavigatorItem.getParent();
			}
			return null;
		}
	'''

	def hasChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean hasChildren(Object element) {
			return element instanceof org.eclipse.core.resources.IFile || getChildren(element).length > 0;
		}
	'''

	def getFileChildren(GenNavigator it) '''
		«var references = getChildReferencesFrom(it, null)»
		«getFileResource(it)»
		java.util.ArrayList<«xptNavigatorItem.qualifiedClassName(it)»> result = new java.util.ArrayList<«xptNavigatorItem.qualifiedClassName(it)»>();
		«FOR groupName : getGroupNames(references)» 
			«initGroupVariables(groupName, it, references, 'file', null)»
		«ENDFOR»
		java.util.ArrayList<org.eclipse.gmf.runtime.notation.View> topViews = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>(resource.getContents().size());
		for (org.eclipse.emf.ecore.EObject o : resource.getContents()) {
			if (o instanceof org.eclipse.gmf.runtime.notation.View) {
				topViews.add((org.eclipse.gmf.runtime.notation.View) o);
			}
		}
		«FOR ref : references»
			«addNavigatorItemsPrefix(ref)»selectViewsByType(topViews, «getChildViewType(ref.child)»)«addNavigatorItemsSuffix(ref,
			'file', false)»
		«ENDFOR»
		«FOR groupName : getGroupNames(references)»
			«addGroups(groupName, references)»
		«ENDFOR»
		return result.toArray();
	'''

	def getFileResource(GenNavigator it) '''
		org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) parentElement;
		org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		org.eclipse.emf.ecore.resource.Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
	'''

	def getGroupChildren(GenNavigator it) '''
		«navigatorGroup.qualifiedClassName(it)» group = («navigatorGroup.qualifiedClassName(it)») parentElement;
		return group.getChildren();
	'''

	def getItemChildren(GenNavigator it) '''
		«xptNavigatorItem.qualifiedClassName(it)» navigatorItem = («xptNavigatorItem.qualifiedClassName(it)») parentElement;
		if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
			return EMPTY_ARRAY;
		}
		return getViewChildren(navigatorItem.getView(), parentElement);
	'''

	def getAdaptableChildren(GenNavigator it) '''
		/*
		 * Due to plugin.xml restrictions this code will be called only for views representing
		 * shortcuts to this diagram elements created on other diagrams. 
		*/ 
		if (parentElement instanceof org.eclipse.core.runtime.IAdaptable) {
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) ((org.eclipse.core.runtime.IAdaptable) parentElement).getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			if (view != null) {
				return getViewChildren(view, parentElement);
			}
		}
	'''

	def getOtherChildren(GenNavigator it) '''
		return EMPTY_ARRAY;
	'''

	def getViewChildren(GenNavigator it) '''
		«generatedMemberComment()»
		private Object[] getViewChildren(org.eclipse.gmf.runtime.notation.View view, Object parentElement) {
		   	switch («xptVisualIDRegistry.getVisualIDMethodCall(it.editorGen.diagram)»(view)) {
		   		«FOR node : getNavigatorContainerNodes(it)»
		   			«caseNavigatorNode(node, it)»	
		   		«ENDFOR»
			}
			return EMPTY_ARRAY;
		}
	'''

	def utilityMethods(GenNavigator it) '''
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getLinksSourceByType(java.util.Collection<org.eclipse.gmf.runtime.notation.Edge> edges, String type) {
			java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
			for (org.eclipse.gmf.runtime.notation.Edge nextEdge : edges) {
				org.eclipse.gmf.runtime.notation.View nextEdgeSource = nextEdge.getSource();
				if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
					result.add(nextEdgeSource);
				}
			}
			return result;
		}
			
		«generatedMemberComment()»
		 private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getLinksTargetByType(java.util.Collection<org.eclipse.gmf.runtime.notation.Edge> edges, String type) {
		 	java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
		 	for (org.eclipse.gmf.runtime.notation.Edge nextEdge : edges) {
		 		org.eclipse.gmf.runtime.notation.View nextEdgeTarget = nextEdge.getTarget();
		 		if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
		 			result.add(nextEdgeTarget);
		 		}
		 	}
		 	return result;
		}
		
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getOutgoingLinksByType(java.util.Collection<? extends org.eclipse.gmf.runtime.notation.View> nodes, String type) {
			java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
		 	for (org.eclipse.gmf.runtime.notation.View nextNode : nodes) {
			 	result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		 	}
			return result;
		}
			
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getIncomingLinksByType(java.util.Collection<? extends org.eclipse.gmf.runtime.notation.View> nodes, String type) {
			java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
			for (org.eclipse.gmf.runtime.notation.View nextNode : nodes) {
				result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
			}
			return result;
		}
			
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getChildrenByType(java.util.Collection<? extends org.eclipse.gmf.runtime.notation.View> nodes, String type) {
			java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
			for (org.eclipse.gmf.runtime.notation.View nextNode : nodes) {
				result.addAll(selectViewsByType(nextNode.getChildren(), type));
			}
			return result;
		}
			
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> getDiagramLinksByType(java.util.Collection<org.eclipse.gmf.runtime.notation.Diagram> diagrams, String type) {
			java.util.ArrayList<org.eclipse.gmf.runtime.notation.View> result = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>();
			for (org.eclipse.gmf.runtime.notation.Diagram nextDiagram : diagrams) {
				result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
			}
			return result;
		}
		
		// TODO refactor as static method
		«generatedMemberComment()»
		private java.util.Collection<org.eclipse.gmf.runtime.notation.View> selectViewsByType(java.util.Collection<org.eclipse.gmf.runtime.notation.View> views, String type) {
			java.util.ArrayList<org.eclipse.gmf.runtime.notation.View> result = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>();
			for (org.eclipse.gmf.runtime.notation.View nextView : views) {
				if (type.equals(nextView.getType()) && isOwnView(nextView)) {
					result.add(nextView);
				}
			}
			return result;
		}
			
		«generatedMemberComment()»
		private boolean isOwnView(org.eclipse.gmf.runtime.notation.View view) {
			return «VisualIDRegistry::modelID(editorGen.diagram)».equals(«xptVisualIDRegistry.
			getModelIDMethodCall(editorGen.diagram)»(view));
		}
			
		«generatedMemberComment()»
		private java.util.Collection<«xptNavigatorItem.qualifiedClassName(it)»> createNavigatorItems(java.util.Collection<org.eclipse.gmf.runtime.notation.View> views, Object parent, boolean isLeafs) {
			java.util.ArrayList<«xptNavigatorItem.qualifiedClassName(it)»> result = new java.util.ArrayList<«xptNavigatorItem.qualifiedClassName(it)»>(views.size());
			for (org.eclipse.gmf.runtime.notation.View nextView : views) {
				result.add(new «xptNavigatorItem.qualifiedClassName(it)»(nextView, parent, isLeafs));
			}
			return result;
		}
		«getForeignShortcuts(it)»
	'''

	def getForeignShortcuts(GenNavigator it) '''
		«IF editorGen.diagram.generateCreateShortcutAction() && getChildReferencesFrom(it, editorGen.diagram).notEmpty»
			
				«generatedMemberComment()»
				private java.util.Collection<«xptNavigatorItem.qualifiedClassName(it)»> getForeignShortcuts(org.eclipse.gmf.runtime.notation.Diagram diagram, Object parent) {
					java.util.LinkedList<org.eclipse.gmf.runtime.notation.View> result = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>();
					for (java.util.Iterator<org.eclipse.gmf.runtime.notation.View> it = diagram.getChildren().iterator(); it.hasNext();) {
						org.eclipse.gmf.runtime.notation.View nextView = it.next();
						if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { «nonNLS(1)»
							result.add(nextView);
						}
					}
					return createNavigatorItems(result, parent, false);
				}
		«ENDIF»
	'''

	def createEditingDomain(GenNavigator it) '''org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory.INSTANCE.createEditingDomain()'''

	def initGroupVariables(String groupName, GenNavigator navigator, Iterable<GenNavigatorChildReference> references,
		String parentVarName, GenCommonBase contextElement) '''
		«navigatorGroup.qualifiedClassName(navigator)» «CodeGenUtil::validJavaIdentifier(groupName)» = new «navigatorGroup.qualifiedClassName(navigator)»(
		«xptExternalizer.accessorCall(navigator.editorGen, i18nKeyForGroup(groupName, contextElement))»,
		"«getNavigatorReference(groupName, references).groupIcon»", «parentVarName»); «nonNLS(1)»
	'''

	@Localization def String i18nKeyForGroup(String groupName, GenCommonBase contextElement) {
		return 'NavigatorGroupName.' + (if(null != contextElement) contextElement.uniqueIdentifier else 'File') + '.' +
			CodeGenUtil::validJavaIdentifier(groupName)
	}

	def addNavigatorItemsPrefix(GenNavigatorChildReference it) '''«IF isInsideGroup()»«CodeGenUtil::validJavaIdentifier(
		groupName)».addChildren(«ELSE»result.addAll(«ENDIF»createNavigatorItems('''

	def addNavigatorItemsSuffix(GenNavigatorChildReference it, String parentVarName, boolean isLeaf) // 
		''', «IF isInsideGroup()»«CodeGenUtil::validJavaIdentifier(groupName)»«ELSE»«parentVarName»«ENDIF», «isLeaf»));'''

	def addGroups(String groupName, Iterable<GenNavigatorChildReference> references) '''
		«var ref = getNavigatorReference(groupName, references)»
		«IF ref.hideIfEmpty»
			if (!«CodeGenUtil::validJavaIdentifier(groupName)».isEmpty()) {
				result.add(«CodeGenUtil::validJavaIdentifier(groupName)»);
			}
		«ELSE»
			result.add(«CodeGenUtil::validJavaIdentifier(groupName)»);
		«ENDIF»
	'''

	def dispatch getChildViewType(GenDiagram it) '''«VisualIDRegistry::modelID(it)»'''

	def dispatch getChildViewType(GenCommonBase it) '''«xptVisualIDRegistry.typeMethodCall(it)»'''

	def caseNavigatorNode(GenCommonBase it, GenNavigator navigator) '''
	
		case «VisualIDRegistry::visualID(it)»: {
			java.util.LinkedList<«abstractNavigatorItem.qualifiedClassName(navigator)»> result = new java.util.LinkedList<«abstractNavigatorItem.
			qualifiedClassName(navigator)»>(); 
			«addForeignShortcuts(it)»
			«nailedDownVariable(it, 'sv', 'view')»
			«var references = getChildReferencesFrom(navigator, it)»
			«FOR groupName : getGroupNames(references)»
			«initGroupVariables(groupName, navigator, references, 'parentElement', it)»
			«ENDFOR»
			«IF references.notEmpty && references.map[r|r.findConnectionPaths()].flatten.notEmpty»
			java.util.Collection<org.eclipse.gmf.runtime.notation.View> connectedViews;
			«FOR reference : references»
				«FOR path : reference.findConnectionPaths()»
					«IF path.segments.notEmpty»
						connectedViews = «childrenMethodName(path.segments.head.from, reference.referenceType, path.segments.head)»(java.util.Collections.singleton(sv), «xptVisualIDRegistry.typeMethodCall(path.segments.head.to)»);
						«FOR segment : path.segments.drop(1)»
						connectedViews = «childrenMethodName(segment.from, reference.referenceType, segment)»(connectedViews, «xptVisualIDRegistry.typeMethodCall(segment.to)»);
						«ENDFOR»
					«ENDIF»
				«addNavigatorItemsPrefix(reference)»connectedViews«addNavigatorItemsSuffix(reference, 'parentElement',
				reference.referenceType != GenNavigatorReferenceType::CHILDREN_LITERAL)»
				«ENDFOR»
			«ENDFOR»
			«ENDIF»
			«FOR groupName : getGroupNames(references)»
			«addGroups(groupName, references)»
			«ENDFOR»
			return result.toArray();
		}
	'''

	def dispatch nailedDownVariable(GenCommonBase it, String varName, String expressionToCast) '''«/* NO-OP, all specific subclasses should be handled */»'''

	def dispatch nailedDownVariable(GenLink it, String varName, String expressionToCast) '''
		org.eclipse.gmf.runtime.notation.Edge «varName» = (org.eclipse.gmf.runtime.notation.Edge) «expressionToCast»;
	'''

	def dispatch nailedDownVariable(GenNode it, String varName, String expressionToCast) '''
		org.eclipse.gmf.runtime.notation.Node «varName» = (org.eclipse.gmf.runtime.notation.Node) «expressionToCast»;
	'''

	def dispatch nailedDownVariable(GenDiagram it, String varName, String expressionToCast) '''
		org.eclipse.gmf.runtime.notation.Diagram «varName» = (org.eclipse.gmf.runtime.notation.Diagram) «expressionToCast»;
	'''

	def dispatch addForeignShortcuts(GenDiagram it) '''
		«IF generateCreateShortcutAction()»
			result.addAll(getForeignShortcuts((org.eclipse.gmf.runtime.notation.Diagram) view, parentElement));
		«ENDIF»
	'''

	def dispatch addForeignShortcuts(GenCommonBase it) ''''''

	def dispatch childrenMethodName(GenLink it, GenNavigatorReferenceType referenceType, GenNavigatorPathSegment segment) '''
		«IF referenceType == GenNavigatorReferenceType::OUT_TARGET_LITERAL»getLinksTargetByType«ELSE»getLinksSourceByType«ENDIF»
	'''

	def dispatch childrenMethodName(GenCommonBase it, GenNavigatorReferenceType referenceType,
		GenNavigatorPathSegment segment) //
	'''«IF referenceType == GenNavigatorReferenceType::OUT_TARGET_LITERAL»getOutgoingLinksByType« //
	ELSEIF referenceType == GenNavigatorReferenceType::IN_SOURCE_LITERAL»getIncomingLinksByType« //
	ELSEIF segment.from.oclIsKindOf(typeof(GenDiagram)) && segment.to.oclIsKindOf(typeof(GenLink))»getDiagramLinksByType« //
	ELSE»getChildrenByType«ENDIF»'''

	def additions(GenNavigator it) ''''''

	@Localization def i18nAccessors(GenNavigator it) '''
		«FOR groupName : getGroupNames(getChildReferencesFrom(it, null))»
			«internal_i18nAccessors(groupName, null)»
		«ENDFOR»
		«FOR contextElement : getNavigatorContainerNodes(it)»
			«FOR groupName : getGroupNames(getChildReferencesFrom(it, contextElement))»
				«internal_i18nAccessors(groupName, contextElement)»
			«ENDFOR»
		«ENDFOR»
	'''

	@Localization def internal_i18nAccessors(String groupName, GenCommonBase contextElement) '''«IF null != groupName»«xptExternalizer.
		accessorField(i18nKeyForGroup(groupName, contextElement))»«ENDIF»'''

	@Localization def i18nValues(GenNavigator it) '''
		«FOR groupName : getGroupNames(getChildReferencesFrom(it, null))»
			«internal_i18nValues(groupName, null)»
		«ENDFOR»
		«FOR contextElement : getNavigatorContainerNodes(it)»
			«FOR groupName : getGroupNames(getChildReferencesFrom(it, contextElement))»
				«internal_i18nValues(groupName, contextElement)»
			«ENDFOR»
		«ENDFOR»
	'''

	@Localization def internal_i18nValues(String groupName, GenCommonBase contextElement) '''«IF null != groupName»«xptExternalizer.
		messageEntry(i18nKeyForGroup(groupName, contextElement), groupName)»«ENDIF»'''

}
