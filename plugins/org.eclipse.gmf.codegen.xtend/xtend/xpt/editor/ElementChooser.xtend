/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import plugin.Activator
import xpt.Common
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto

@com.google.inject.Singleton class ElementChooser {
	@Inject extension Common;

	@Inject extension ExternalizerUtils_qvto;
	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;

	def className(GenDiagram it) '''«it.elementChooserClassName»'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def extendsList(GenDiagram it) '''extends org.eclipse.jface.dialogs.Dialog'''

	def ElementChooser(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
			
			«attributes(it)»
			
			«constructor(it)»
			
			«createDialogArea(it)»
			
			«createButtonBar(it)»
			
			«createModelBrowser(it)»
			
			«setOkButtonEnabled(it)»
			
			«isValidModelFile(it)»
			
			«getSelectedModelElementURI(it)»
			
			«open(it)»
			
			«ModelElementsTreeContentProvider(it)»
			
			«ModelElementsTreeLabelProvider(it)»
			
			«ModelFilesFilter(it)»
			
			«OkButtonEnabler(it)»
			
			«additions(it)»
		}
	'''

	def attributes(GenDiagram it) '''
			«generatedMemberComment»
			private org.eclipse.jface.viewers.TreeViewer myTreeViewer;
		
			«generatedMemberComment»
			private org.eclipse.emf.common.util.URI mySelectedModelElementURI;
		
			«generatedMemberComment»
			private org.eclipse.gmf.runtime.notation.View myView;
			
			«generatedMemberComment»
			private org.eclipse.emf.transaction.TransactionalEditingDomain myEditingDomain = org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory.INSTANCE.createEditingDomain();
	'''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.swt.widgets.Shell parentShell, org.eclipse.gmf.runtime.notation.View view) {
			super(parentShell);
			setShellStyle(getShellStyle() | org.eclipse.swt.SWT.RESIZE);
			myView = view;
		}
	'''

	def createDialogArea(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.swt.widgets.Control createDialogArea(org.eclipse.swt.widgets.Composite parent) {
			org.eclipse.swt.widgets.Composite composite = (org.eclipse.swt.widgets.Composite) super.createDialogArea(parent);
			getShell().setText(«xptExternalizer.accessorCall(editorGen, titleKey(i18nKeyForSelectModelElement(it)))»);
			createModelBrowser(composite);
			return composite;
		}
	'''

	def createButtonBar(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.swt.widgets.Control createButtonBar(org.eclipse.swt.widgets.Composite parent) {
			org.eclipse.swt.widgets.Control buttonBar = super.createButtonBar(parent);
			setOkButtonEnabled(false);
			return buttonBar;
		}
	'''

	def createModelBrowser(GenDiagram it) '''
		«generatedMemberComment»
		private void createModelBrowser(org.eclipse.swt.widgets.Composite composite) {
			myTreeViewer = new org.eclipse.jface.viewers.TreeViewer(composite, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.H_SCROLL | org.eclipse.swt.SWT.V_SCROLL | org.eclipse.swt.SWT.BORDER);
			org.eclipse.swt.layout.GridData layoutData = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_BOTH);
			layoutData.heightHint = 300;
			layoutData.widthHint = 300;
			myTreeViewer.getTree().setLayoutData(layoutData);
			myTreeViewer.setContentProvider(new ModelElementsTreeContentProvider());
			myTreeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());
			myTreeViewer.setInput(org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot());
			myTreeViewer.addFilter(new ModelFilesFilter());
			myTreeViewer.addSelectionChangedListener(new OkButtonEnabler());
		}
	'''

	def setOkButtonEnabled(GenDiagram it) '''
		«generatedMemberComment»
		private void setOkButtonEnabled(boolean enabled) {
			getButton(org.eclipse.jface.dialogs.IDialogConstants.OK_ID).setEnabled(enabled);
		}
	'''

	def isValidModelFile(GenDiagram it) '''
		«generatedMemberComment»
		private boolean isValidModelFile(org.eclipse.core.resources.IFile file) {
			String fileExtension = file.getFullPath().getFileExtension();
			return «FOR ext : containsShortcutsTo SEPARATOR ' || '»"«ext»".equals(fileExtension)«ENDFOR»; «nonNLS_All(
			containsShortcutsTo)»
		}
	'''

	def getSelectedModelElementURI(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.emf.common.util.URI getSelectedModelElementURI() {
			return mySelectedModelElementURI;
		}
	'''

	def open(GenDiagram it) '''
		«generatedMemberComment»
		public int open() {
			int result = super.open();
			for (org.eclipse.emf.ecore.resource.Resource resource : myEditingDomain.getResourceSet().getResources()) {
				resource.unload();
			}
			myEditingDomain.dispose();
			return result;
		}
	'''

	def ModelElementsTreeContentProvider(GenDiagram it) '''
		«generatedClassComment»
		private class ModelElementsTreeContentProvider implements org.eclipse.jface.viewers.ITreeContentProvider {
		
			«METCP_attributes(it)»
			
			«METCP_getChildren(it)»
		
			«METCP_getParent(it)»
		
			«METCP_hasChildren(it)»
		
			«METCP_getElements(it)»
		
			«METCP_dispose(it)»
		
			«METCP_inputChanged(it)»	
		
			«METCP_additions(it)»
		}
	'''

	def METCP_attributes(GenDiagram it) '''
		«generatedMemberComment»
		private org.eclipse.jface.viewers.ITreeContentProvider myWorkbenchContentProvider = new «IF //
		null == editorGen.application»org.eclipse.ui.model.WorkbenchContentProvider«ELSE»org.eclipse.ui.model.BaseWorkbenchContentProvider«ENDIF»();
		
		«generatedMemberComment»
		private org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider myAdapterFctoryContentProvier = new org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider(« //
		xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getItemProvidersAdapterFactory());
	'''

	def METCP_getChildren(GenDiagram it) '''
		«generatedMemberComment»
		public Object[] getChildren(Object parentElement) {
			Object[] result = myWorkbenchContentProvider.getChildren(parentElement);
			if (result != null && result.length > 0) {
				return result;
			}
			if (parentElement instanceof org.eclipse.core.resources.IFile) {
				org.eclipse.core.resources.IFile modelFile = (org.eclipse.core.resources.IFile) parentElement;
				org.eclipse.core.runtime.IPath resourcePath = modelFile.getFullPath();
				org.eclipse.emf.ecore.resource.ResourceSet resourceSet = myEditingDomain.getResourceSet();
				try {
					org.eclipse.emf.ecore.resource.Resource modelResource = resourceSet.getResource(org.eclipse.emf.common.util.URI.createPlatformResourceURI(resourcePath.toString(), true), true);
					return myAdapterFctoryContentProvier.getChildren(modelResource);
				} catch (org.eclipse.emf.common.util.WrappedException e) {
					«xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().logError("Unable to load resource: " + resourcePath.toString(), e); «nonNLS(
			1)»
				}
				return java.util.Collections.EMPTY_LIST.toArray();
			}
			return myAdapterFctoryContentProvier.getChildren(parentElement);
		}
	'''

	def METCP_getParent(GenDiagram it) '''
		«generatedMemberComment»
		public Object getParent(Object element) {
			Object parent = myWorkbenchContentProvider.getParent(element);
			if (parent != null) {
				return parent;
			}
			if (element instanceof org.eclipse.emf.ecore.EObject) {
				org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) element;
				if (eObject.eContainer() == null && eObject.eResource().getURI().isFile()) {
					String path = eObject.eResource().getURI().path();
					return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new org.eclipse.core.runtime.Path(path));
				}
				return myAdapterFctoryContentProvier.getParent(eObject);
			}
			return null;
		}
	'''

	def METCP_hasChildren(GenDiagram it) '''
		«generatedMemberComment»
		public boolean hasChildren(Object element) {
			if (element instanceof org.eclipse.core.resources.IFile) {
				return isValidModelFile((org.eclipse.core.resources.IFile) element);
			}
			return myWorkbenchContentProvider.hasChildren(element) || myAdapterFctoryContentProvier.hasChildren(element);
		}
	'''

	def METCP_getElements(GenDiagram it) '''
		«generatedMemberComment»
		public Object[] getElements(Object inputElement) {
			Object[] elements = myWorkbenchContentProvider.getElements(inputElement);
			return elements;
		}
	'''

	def METCP_dispose(GenDiagram it) '''
		«generatedMemberComment»
		public void dispose() {
			myWorkbenchContentProvider.dispose();
			myAdapterFctoryContentProvier.dispose();
		}
	'''

	def METCP_inputChanged(GenDiagram it) '''
		«generatedMemberComment»
		public void inputChanged(org.eclipse.jface.viewers.Viewer viewer, Object oldInput, Object newInput) {
			myWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);
			myAdapterFctoryContentProvier.inputChanged(viewer, oldInput, newInput);
		}
	'''

	def ModelElementsTreeLabelProvider(GenDiagram it) '''
		«generatedClassComment»
		private class ModelElementsTreeLabelProvider implements org.eclipse.jface.viewers.ILabelProvider {
		
			«METLP_attributes(it)»
			
			«METLP_getImage(it)»
			
			«METLP_getText(it)»
			
			«METLP_addListener(it)»
			
			«METLP_dispose(it)»
			
			«METLP_isLabelProperty(it)»
			
			«METLP_removeListener(it)»
		
			«METLP_additions(it)»
		}
	'''

	def METLP_attributes(GenDiagram it) '''
		«generatedMemberComment»
			private org.eclipse.ui.model.WorkbenchLabelProvider myWorkbenchLabelProvider = new org.eclipse.ui.model.WorkbenchLabelProvider();
		
		«generatedMemberComment»
			private org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(«
			xptActivator.qualifiedClassName(editorGen.plugin)».getInstance().getItemProvidersAdapterFactory());
	'''

	def METLP_getImage(GenDiagram it) '''
		«generatedMemberComment»
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			org.eclipse.swt.graphics.Image result = myWorkbenchLabelProvider.getImage(element);
			return result != null ? result : myAdapterFactoryLabelProvider.getImage(element);
		}
	'''

	def METLP_getText(GenDiagram it) '''
		«generatedMemberComment»
		public String getText(Object element) {
			String result = myWorkbenchLabelProvider.getText(element);
			return result != null && result.length() > 0 ? result : myAdapterFactoryLabelProvider.getText(element);
		}
	'''

	def METLP_addListener(GenDiagram it) '''
		«generatedMemberComment»
		public void addListener(org.eclipse.jface.viewers.ILabelProviderListener listener) {
			myWorkbenchLabelProvider.addListener(listener);
			myAdapterFactoryLabelProvider.addListener(listener);
		}
	'''

	def METLP_dispose(GenDiagram it) '''
		«generatedMemberComment»
		public void dispose() {
			myWorkbenchLabelProvider.dispose();
			myAdapterFactoryLabelProvider.dispose();
		}
	'''

	def METLP_isLabelProperty(GenDiagram it) '''
		«generatedMemberComment»
		public boolean isLabelProperty(Object element, String property) {
			return myWorkbenchLabelProvider.isLabelProperty(element, property) || myAdapterFactoryLabelProvider.isLabelProperty(element, property);
		}
	'''

	def METLP_removeListener(GenDiagram it) '''
		«generatedMemberComment»
		public void removeListener(org.eclipse.jface.viewers.ILabelProviderListener listener) {
			myWorkbenchLabelProvider.removeListener(listener);
			myAdapterFactoryLabelProvider.removeListener(listener);
		}
	'''

	def ModelFilesFilter(GenDiagram it) '''
		«generatedClassComment»
		private class ModelFilesFilter extends org.eclipse.jface.viewers.ViewerFilter {
		
			«MFF_select(it)»
		
			«MFF_additions(it)»
		}
	'''

	def MFF_select(GenDiagram it) '''
		«generatedMemberComment»
		public boolean select(org.eclipse.jface.viewers.Viewer viewer, Object parentElement, Object element) {
			if (element instanceof org.eclipse.core.resources.IContainer) {
				return true;
			}
			if (element instanceof org.eclipse.core.resources.IFile) {
				org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) element;
				return isValidModelFile(file);
			}
			return true;
		}
	'''

	def OkButtonEnabler(GenDiagram it) '''
		«generatedClassComment»
		private class OkButtonEnabler implements org.eclipse.jface.viewers.ISelectionChangedListener {
		
			«OBE_selectionChanged(it)»
		
			«OBE_additions(it)»
		}
	'''

	def OBE_selectionChanged(GenDiagram it) '''
		«generatedMemberComment»
		public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
			if (event.getSelection() instanceof org.eclipse.jface.viewers.IStructuredSelection) {
				org.eclipse.jface.viewers.IStructuredSelection selection = (org.eclipse.jface.viewers.IStructuredSelection) event.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof org.eclipse.emf.edit.provider.IWrapperItemProvider) {
						selectedElement = ((org.eclipse.emf.edit.provider.IWrapperItemProvider) selectedElement).getValue();
					}
					if (selectedElement instanceof org.eclipse.emf.ecore.util.FeatureMap.Entry) {
						selectedElement = ((org.eclipse.emf.ecore.util.FeatureMap.Entry) selectedElement).getValue();
					}
					if (selectedElement instanceof org.eclipse.emf.ecore.EObject) {
						org.eclipse.emf.ecore.EObject selectedModelElement = (org.eclipse.emf.ecore.EObject) selectedElement;
						setOkButtonEnabled(org.eclipse.gmf.runtime.diagram.core.services.ViewService.getInstance().provides(org.eclipse.gmf.runtime.notation.Node.class, new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(selectedModelElement), myView, null, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true, «xptActivator.
			preferenceHintAccess(editorGen)»));
						mySelectedModelElementURI = org.eclipse.emf.ecore.util.EcoreUtil.getURI(selectedModelElement);
						return;
					}
				}
			}
			mySelectedModelElementURI = null;
			setOkButtonEnabled(false);
		}
	'''

	def METCP_additions(GenDiagram it) ''''''

	def METLP_additions(GenDiagram it) ''''''

	def MFF_additions(GenDiagram it) ''''''

	def OBE_additions(GenDiagram it) ''''''

	def additions(GenDiagram it) ''''''

	@Localization def i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(titleKey(i18nKeyForSelectModelElement(it)), 'Select model element')»
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
		«xptExternalizer.accessorField(titleKey(i18nKeyForSelectModelElement(it)))»
	'''

	@Localization def String i18nKeyForSelectModelElement(GenDiagram diagram) {
		return i18nKeyForElementChooser(diagram) + '.SelectModelElement'
	}

	@Localization def String i18nKeyForElementChooser(GenDiagram diagram) {
		return '' + className(diagram)
	}

}
