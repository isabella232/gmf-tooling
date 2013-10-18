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
package xpt.editor

import com.google.inject.Inject
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.GenEditorView
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto
import xpt.navigator.NavigatorLinkHelper
import xpt.editor.palette.PaletteFactory
import xpt.navigator.NavigatorItem

class Editor {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject extension ExternalizerUtils_qvto;

	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;
	@Inject NavigatorLinkHelper xptNavigatorLinkHelper;
	@Inject NavigatorItem xptNavigatorItem;
	@Inject DiagramEditorContextMenuProvider xptDiagramEditorContextMenuProvider;
	@Inject PaletteFactory pallette;

	def className(GenEditorView it) '''«it.className»'''

	def packageName(GenEditorView it) '''«it.packageName»'''

	def qualifiedClassName(GenEditorView it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenEditorView it) '''«qualifiedClassName(it)»'''

	def extendsList(GenEditorView it) '''extends org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor'''

	def implementsList(GenEditorView it) '''«implementsList(buildImplementsList(it))»'''

	def implementsList(Iterable<String> list) '''«IF list.notEmpty»implements «FOR next : list SEPARATOR ', '»«next»«ENDFOR»«ENDIF»'''

	def Editor(GenEditorView it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
		
			«attributes(it)»
			
			«constructor(it)»
			
			«getContextID(it)»
			
			«IF editorGen.diagram.palette != null»
				«createPaletteRoot(editorGen.diagram.palette)»
			«ENDIF»
			
			«getPreferencesHint(it)»
			
			«getContributorId(it)»
			
			«getAdapter(it)»
			
			«getDocumentProvider(it)»
			
			«getEditingDomain(it)»
			
			«setDocumentProvider(it)»
			«IF isIDEMode(it)»
				
					«gotoMarker(it)»
					
					«isSaveAsAllowed(it)»
					
					«doSaveAs(it)»
					
					«performSaveAs(it)»
					
					«getShowInContext(it)»
					
					«IF hasNavigator(it)»
						«getNavigatorSelection(it.editorGen.navigator)»
					«ENDIF»
			«ENDIF»
		
			«configureGraphicalViewer(it)»
		
			«IF editorGen.diagram.generateCreateShortcutAction»
				
					«initializeGraphicalViewer(it)»
					
					«DropTargetListener(it)»
			«ENDIF»
		
			«additions(it)»
		}
	'''

	def attributes(GenEditorView it) '''
	«generatedMemberComment»
		public static final String ID = "«ID»"; «nonNLS(1)»
			
		«generatedMemberComment»
		public static final String CONTEXT_ID = "«contextID»"; «nonNLS(1)»
	'''

	def constructor(GenEditorView it) '''
	«generatedMemberComment»
		public «className(it)»() {
			super(«null != editorGen.diagram.palette && editorGen.diagram.palette.flyout»);
		}
	'''

	def getContextID(GenEditorView it) '''
		«generatedMemberComment»
		protected String getContextID() {
			return CONTEXT_ID;
		}
	'''

	def createPaletteRoot(Palette it) '''
		
		«generatedMemberComment»
		protected org.eclipse.gef.palette.PaletteRoot createPaletteRoot(org.eclipse.gef.palette.PaletteRoot existingPaletteRoot) {
			org.eclipse.gef.palette.PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
			new «pallette.qualifiedClassName(it)»().fillPalette(root);
			return root;
		}
	'''

	def getPreferencesHint(GenEditorView it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint getPreferencesHint() {
		«/** 
		 * seems better we use preference store directly (in configureGraphicalViewer) instead all these indirect ids 
		 */»return «xptActivator.preferenceHintAccess(editorGen)»;
		}
	'''

	def getContributorId(GenEditorView it) '''
		«generatedMemberComment»
		public String getContributorId() {
			return «xptActivator.qualifiedClassName(editorGen.plugin)».ID;
		}
	'''

	def getAdapter(GenEditorView it) '''
		«IF !hasPropertySheet(it) || hasNavigator(it)»
			
			«generatedMemberComment»
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Class type) {
				«IF !hasPropertySheet(it)»
					if (type == org.eclipse.ui.views.properties.IPropertySheetPage.class) {
						return null;
					}
				«ENDIF»
				«IF hasNavigator(it)»
					if (type == org.eclipse.ui.part.IShowInTargetList.class) {
						return new org.eclipse.ui.part.IShowInTargetList() {
							public String[] getShowInTargetIds() {
								return new String[] { org.eclipse.ui.navigator.resources.ProjectExplorer.VIEW_ID };
							}
						};
					}
				«ENDIF»
				return super.getAdapter(type);
			}
		«ENDIF»
	'''

	def getDocumentProvider(GenEditorView it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider getDocumentProvider(org.eclipse.ui.IEditorInput input) {
			if («checkEditorInput(it)») {
				return «xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getDocumentProvider();
			}
			return super.getDocumentProvider(input);
		}
	'''

	def getEditingDomain(GenEditorView it) '''
		«generatedMemberComment»
		public org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {
			org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
			if (document instanceof org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) {
				return ((org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document).getEditingDomain();
			}
			return super.getEditingDomain();
		}
	'''

	def setDocumentProvider(GenEditorView it) '''
		«generatedMemberComment»
		protected void setDocumentProvider(org.eclipse.ui.IEditorInput input) {
			if («checkEditorInput(it)») {
				setDocumentProvider(«xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getDocumentProvider());
			} else {
				super.setDocumentProvider(input);
			}
		}
	'''

	def checkEditorInput(GenEditorView it) '''«IF isIDEMode(it)»input instanceof org.eclipse.ui.IFileEditorInput || «ENDIF»input instanceof org.eclipse.emf.common.ui.URIEditorInput'''

	def gotoMarker(GenEditorView it) '''
		«generatedMemberComment»
		public void gotoMarker(org.eclipse.core.resources.IMarker marker) {
			org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService.getInstance().gotoMarker(this, marker);
		}
	'''

	def isSaveAsAllowed(GenEditorView it) '''
		«generatedMemberComment»
		public boolean isSaveAsAllowed() {
			return true;
		}
	'''

	def doSaveAs(GenEditorView it) '''
		«generatedMemberComment»
		public void doSaveAs() {
			performSaveAs(new org.eclipse.core.runtime.NullProgressMonitor());
		}
	'''

	def performSaveAs(GenEditorView it) '''
		«generatedMemberComment»
		protected void performSaveAs(org.eclipse.core.runtime.IProgressMonitor progressMonitor) {
			org.eclipse.swt.widgets.Shell shell = getSite().getShell();
			org.eclipse.ui.IEditorInput input = getEditorInput();
			org.eclipse.ui.dialogs.SaveAsDialog dialog = new org.eclipse.ui.dialogs.SaveAsDialog(shell);
			org.eclipse.core.resources.IFile original = input instanceof org.eclipse.ui.IFileEditorInput ? ((org.eclipse.ui.IFileEditorInput) input).getFile() : null;
			if (original != null) {
				dialog.setOriginalFile(original);
			}
			dialog.create();
			org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider provider = getDocumentProvider();
			if (provider == null) {
				// editor has been programmatically closed while the dialog was open
				return;
			}
			if (provider.isDeleted(input) && original != null) {
				String message = org.eclipse.osgi.util.NLS.bind(«xptExternalizer.accessorCall(editorGen,
			i18nKeyForSavingDeletedFile(it))», original.getName());
				dialog.setErrorMessage(null);
				dialog.setMessage(message, org.eclipse.jface.dialogs.IMessageProvider.WARNING);
			}
			if (dialog.open() == org.eclipse.jface.window.Window.CANCEL) {
				if (progressMonitor != null) {
					progressMonitor.setCanceled(true);
				}
				return;
			}
			org.eclipse.core.runtime.IPath filePath = dialog.getResult();
			if (filePath == null) {
				if (progressMonitor != null) {
					progressMonitor.setCanceled(true);
				}
				return;
			}
			org.eclipse.core.resources.IWorkspaceRoot workspaceRoot = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
			org.eclipse.core.resources.IFile file = workspaceRoot.getFile(filePath);
			final org.eclipse.ui.IEditorInput newInput = new org.eclipse.ui.part.FileEditorInput(file);
			// Check if the editor is already open
			org.eclipse.ui.IEditorMatchingStrategy matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();
			org.eclipse.ui.IEditorReference[] editorRefs = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for (int i = 0; i < editorRefs.length; i++) {
				if (matchingStrategy.matches(editorRefs[i], newInput)) {
					org.eclipse.jface.dialogs.MessageDialog.openWarning(shell, «xptExternalizer.accessorCall(editorGen,
			titleKey(i18nKeyForSaveAsProblems(it)))», «xptExternalizer.accessorCall(editorGen,
			messageKey(i18nKeyForSaveAsProblems(it)))»);
					return;
				}
			}
			boolean success = false;
			try {
				provider.aboutToChange(newInput);
				getDocumentProvider(newInput).saveDocument(progressMonitor, newInput, getDocumentProvider().getDocument(getEditorInput()), true);
				success = true;
			} catch (org.eclipse.core.runtime.CoreException x) {
				org.eclipse.core.runtime.IStatus status = x.getStatus();
				if (status == null || status.getSeverity() != org.eclipse.core.runtime.IStatus.CANCEL) {
					org.eclipse.jface.dialogs.ErrorDialog.openError(shell, «xptExternalizer.accessorCall(editorGen,
			titleKey(i18nKeyForSaveProblems(it)))», «xptExternalizer.accessorCall(editorGen,
			messageKey(i18nKeyForSaveProblems(it)))», x.getStatus());
				}
			} finally {
				provider.changed(newInput);
				if (success) {
					setInput(newInput);
				}
			}
			if (progressMonitor != null) {
				progressMonitor.setCanceled(!success);
			}
		}
	'''

	def getShowInContext(GenEditorView it) '''
		«generatedMemberComment»
		public org.eclipse.ui.part.ShowInContext getShowInContext() {
			return new org.eclipse.ui.part.ShowInContext(getEditorInput(), «IF hasNavigator(it)»getNavigatorSelection()«ELSE»getGraphicalViewer().getSelection()«ENDIF»);
		}
	'''

	def getNavigatorSelection(GenNavigator it) '''
		
		«generatedMemberComment»
		private org.eclipse.jface.viewers.ISelection getNavigatorSelection() {
			org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument document = getDiagramDocument();
			«xptNavigatorLinkHelper.findSelectionBody(it)»
		}
	'''

	def configureGraphicalViewer(GenEditorView it) '''
		«generatedMemberComment»
		protected void configureGraphicalViewer() {
			super.configureGraphicalViewer();
			«xptDiagramEditorContextMenuProvider.qualifiedClassName(it.editorGen.diagram)» provider =
					new «xptDiagramEditorContextMenuProvider.qualifiedClassName(it.editorGen.diagram)»(this, getDiagramGraphicalViewer());
			getDiagramGraphicalViewer().setContextMenu(provider);
			getSite().registerContextMenu(org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
		}
	'''

	def initializeGraphicalViewer(GenEditorView it) '''
		«generatedMemberComment»
		protected void initializeGraphicalViewer() {
			super.initializeGraphicalViewer();
			«addDropTargetListener('org.eclipse.jface.util.LocalSelectionTransfer.getTransfer()')»
			«addDropTargetListener('org.eclipse.emf.edit.ui.dnd.LocalTransfer.getInstance()')»
		}
	'''

	def addDropTargetListener(GenEditorView it, String transferAccessor) '''
		getDiagramGraphicalViewer().addDropTargetListener(new DropTargetListener(getDiagramGraphicalViewer(), «transferAccessor») {
		
			protected Object getJavaObject(org.eclipse.swt.dnd.TransferData data) {
				return «transferAccessor».nativeToJava(data);
			}
			
		});
	'''

	def DropTargetListener(GenEditorView it) '''
		«generatedClassComment»
		private abstract class DropTargetListener extends org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener {
		
			«DTL_constructor(it)»
		
			«DTL_getObjectsBeingDropped(it)»
		
			«DTL_getJavaObject(it)»
		
			«DTL_additions(it)»
		}
	'''

	def DTL_constructor(GenEditorView it) '''
		«generatedMemberComment»
		public DropTargetListener(org.eclipse.gef.EditPartViewer viewer, org.eclipse.swt.dnd.Transfer xfer) {
			super(viewer, xfer);
		}
	'''

	def DTL_getObjectsBeingDropped(GenEditorView it) '''
			«generatedMemberComment»
		protected java.util.List getObjectsBeingDropped() {
			org.eclipse.swt.dnd.TransferData data = getCurrentEvent().currentDataType;
			java.util.HashSet<org.eclipse.emf.common.util.URI> uris = new java.util.HashSet<org.eclipse.emf.common.util.URI>(); 
		
			Object transferedObject = getJavaObject(data);
			if (transferedObject instanceof org.eclipse.jface.viewers.IStructuredSelection) {
				org.eclipse.jface.viewers.IStructuredSelection selection = (org.eclipse.jface.viewers.IStructuredSelection) transferedObject;
				for (java.util.Iterator<?> it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					«
		/*
				  * FIXME [MG]: move NavigatorItem to some place available in runtime and remove 
				  * "genEditor.getEditorGen().getNavigator() != null" test
				  */
		IF hasNavigator(it)»if (nextSelectedObject instanceof «xptNavigatorItem.qualifiedClassName(it.editorGen.navigator)») {
										org.eclipse.gmf.runtime.notation.View view = ((«xptNavigatorItem.qualifiedClassName(it.editorGen.navigator)») nextSelectedObject).getView();
										nextSelectedObject = view.getElement();
					} else «ENDIF»if (nextSelectedObject instanceof org.eclipse.core.runtime.IAdaptable) {
						org.eclipse.core.runtime.IAdaptable adaptable = (org.eclipse.core.runtime.IAdaptable) nextSelectedObject;
						nextSelectedObject = adaptable.getAdapter(org.eclipse.emf.ecore.EObject.class);
					}
		
					if (nextSelectedObject instanceof org.eclipse.emf.ecore.EObject) {
						org.eclipse.emf.ecore.EObject modelElement = (org.eclipse.emf.ecore.EObject) nextSelectedObject;
						uris.add(org.eclipse.emf.ecore.util.EcoreUtil.getURI(modelElement));	
					}
				}
			}
		
			java.util.ArrayList<org.eclipse.emf.ecore.EObject> result = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(uris.size());
			for (org.eclipse.emf.common.util.URI nextURI : uris) { 
				org.eclipse.emf.ecore.EObject modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);
				result.add(modelObject);
			}
			return result;
		}
	'''

	def DTL_getJavaObject(GenEditorView it) '''
			«generatedMemberComment»
		protected abstract Object getJavaObject(org.eclipse.swt.dnd.TransferData data);
	'''

	def DTL_additions(GenEditorView it) ''''''

	def additions(GenEditorView it) ''''''

	@Localization def i18nValues(GenEditorView it) '''
		«xptExternalizer.messageEntry(i18nKeyForSavingDeletedFile(it), 'The original file \"{0}\" has been deleted.')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForSaveAsProblems(it)), 'Problem During Save As...')»
		«xptExternalizer.messageEntry(messageKey(i18nKeyForSaveAsProblems(it)),
			'Save could not be completed. Target file is already open in another editor.')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForSaveProblems(it)), 'Save Problems')»
		«xptExternalizer.messageEntry(messageKey(i18nKeyForSaveProblems(it)), 'Could not save file.')»
	'''

	@Localization def i18nAccessors(GenEditorView it) '''
		«xptExternalizer.accessorField(i18nKeyForSavingDeletedFile(it))»
		«xptExternalizer.accessorField(titleKey(i18nKeyForSaveAsProblems(it)))»
		«xptExternalizer.accessorField(messageKey(i18nKeyForSaveAsProblems(it)))»
		«xptExternalizer.accessorField(titleKey(i18nKeyForSaveProblems(it)))»
		«xptExternalizer.accessorField(messageKey(i18nKeyForSaveProblems(it)))»
	'''

	@Localization def String i18nKeyForSavingDeletedFile(GenEditorView editor) {
		return i18nKeyForEditor(editor) + '.SavingDeletedFile'
	}

	@Localization def String i18nKeyForSaveAsProblems(GenEditorView editor) {
		return i18nKeyForEditor(editor) + '.SaveAsError'
	}

	@Localization def String i18nKeyForSaveProblems(GenEditorView editor) {
		return i18nKeyForEditor(editor) + '.SaveError'
	}

	@Localization def String i18nKeyForEditor(GenEditorView editor) {
		return '' + className(editor)
	}

	def Iterable<String> buildImplementsList(GenEditorView it) {
		var List<String> result = <String>newLinkedList();
		if (isIDEMode(it)) {
			result.add('org.eclipse.ui.ide.IGotoMarker');
		}
		if (hasPropertySheet(it) && it.editorGen.propertySheet.readOnly) {
			result.add(
				'org.eclipse.gmf.runtime.diagram.ui.properties.views.IReadOnlyDiagramPropertySheetPageContributor');
		}
		return result;
	}

	def boolean isIDEMode(GenEditorView it) {
		return null == it.editorGen.application;
	}

	def boolean hasPropertySheet(GenEditorView it) {
		return it.editorGen.propertySheet != null
	}

	def boolean hasNavigator(GenEditorView it) {
		return it.editorGen.navigator != null
	}
}
