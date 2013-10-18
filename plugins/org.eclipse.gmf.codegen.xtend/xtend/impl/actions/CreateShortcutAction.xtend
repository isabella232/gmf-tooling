/**
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [174961] migration to Commands/Handlers 
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.actions

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import plugin.Activator
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto
import xpt.diagram.commands.CreateShortcutDecorationsCommand
import xpt.editor.ShortcutCreationWizard
import xpt.editor.ElementChooser
import xpt.editor.DiagramEditorUtil

class CreateShortcutAction {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension ExternalizerUtils_qvto;

	@Inject ShortcutCreationWizard xptShortcutCreationWizard;
	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;
	@Inject CreateShortcutDecorationsCommand xptCreateShortcutDecorationCommand;
	@Inject ElementChooser xptElementChooser;
	@Inject DiagramEditorUtil xptDiagramEditorUtil;

	def className(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«lastSegment(qualifiedClassName)»'''

	def packageName(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«withoutLastSegment(qualifiedClassName)»'''

	def qualifiedClassName(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«packageName(it)».«className(it)»'''

	def fullPath(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«qualifiedClassName(it)»'''

	def Main(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
		«copyright(it.owner.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
			«executeMethod(it)»
			«additions(it)»
		}
	'''

	def extendsList(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''extends org.eclipse.core.commands.AbstractHandler'''

	def implementsList(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) ''''''

	def executeMethod(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''
		«generatedMemberComment»
		public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
			org.eclipse.ui.IEditorPart diagramEditor = org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked(event);
			org.eclipse.swt.widgets.Shell shell = diagramEditor.getEditorSite().getShell();
			«_assert('diagramEditor instanceof org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor')»
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = ((org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor) diagramEditor).getEditingDomain();
			org.eclipse.jface.viewers.ISelection selection = org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked(event);
			«_assert('selection instanceof org.eclipse.jface.viewers.IStructuredSelection')»
			«_assert('((org.eclipse.jface.viewers.IStructuredSelection) selection).size() == 1')»
			«_assert(
			'((org.eclipse.jface.viewers.IStructuredSelection) selection).getFirstElement() instanceof org.eclipse.gef.EditPart')»
			org.eclipse.gef.EditPart selectedDiagramPart = (org.eclipse.gef.EditPart) ((org.eclipse.jface.viewers.IStructuredSelection) selection).getFirstElement();
			final org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) selectedDiagramPart.getModel();
			«IF null == owner.editorGen.application»
				«xptElementChooser.qualifiedClassName(owner.editorGen.diagram)» elementChooser = new «xptElementChooser.qualifiedClassName(
			owner.editorGen.diagram)»(shell, view);
				int result = elementChooser.open();
				if (result != org.eclipse.jface.window.Window.OK) {
					return null;
				}
				org.eclipse.emf.common.util.URI selectedModelElementURI = elementChooser.getSelectedModelElementURI();
				final org.eclipse.emf.ecore.EObject selectedElement;
				try {
					selectedElement = editingDomain.getResourceSet().getEObject(selectedModelElementURI, true);
				} catch (org.eclipse.emf.common.util.WrappedException e) {
					«xptActivator.qualifiedClassName(owner.editorGen.plugin)».getInstance().logError("Exception while loading object: " + selectedModelElementURI.toString(), e); «nonNLS(
			1)»
					return null;
				}
				
				if (selectedElement == null) {
					return null;
				}
				org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor viewDescriptor = new org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(selectedElement), org.eclipse.gmf.runtime.notation.Node.class, null, «xptActivator.
			preferenceHintAccess(owner.editorGen)»);
				org.eclipse.gmf.runtime.common.core.command.ICommand command = new org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand(editingDomain, viewDescriptor, view);
				command = command.compose(new «xptCreateShortcutDecorationCommand.qualifiedClassName(it.owner.editorGen.diagram)»(editingDomain, view, viewDescriptor));
				try {
					org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory().execute(command, new org.eclipse.core.runtime.NullProgressMonitor(), null);
				} catch (org.eclipse.core.commands.ExecutionException e) {
					«xptActivator.qualifiedClassName(owner.editorGen.plugin)».getInstance().logError("Unable to create shortcut", e); «nonNLS(
			1)»
				}
			«ELSE»
				org.eclipse.emf.ecore.resource.Resource resource = «xptDiagramEditorUtil.qualifiedClassName(owner.editorGen.diagram)».openModel(shell, «xptExternalizer.
			accessorCall(owner.editorGen, titleKey(i18nKeyForCreateShortcutOpenModel()))», editingDomain);
				if (resource == null || resource.getContents().isEmpty()) {
					return null;
				}
				«xptShortcutCreationWizard.qualifiedClassName(owner.editorGen.diagram)» wizard = new «xptShortcutCreationWizard.
			qualifiedClassName(owner.editorGen.diagram)»((org.eclipse.emf.ecore.EObject) resource.getContents().get(0), view, editingDomain);
				wizard.setWindowTitle(«xptExternalizer.accessorCall(it.owner.editorGen, titleKey(i18nKeyForCreateShortcutWizard()))»);
				«xptDiagramEditorUtil.qualifiedClassName(owner.editorGen.diagram)».runWizard(myShell, wizard, "CreateShortcut"); «nonNLS(
			1)»
			«ENDIF»
			return null;
		}
	'''

	def additions(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) ''''''

	def i18nValues(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.messageEntry(titleKey(i18nKeyForCreateShortcutOpenModel()), 'Select model to reference')»
			«xptExternalizer.messageEntry(titleKey(i18nKeyForCreateShortcutWizard()), 'Create shortcut')»
		«ENDIF»
	'''

	def i18nAccessors(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.accessorField(titleKey(i18nKeyForCreateShortcutOpenModel()))»
			«xptExternalizer.accessorField(titleKey(i18nKeyForCreateShortcutWizard()))»
		«ENDIF»
	'''

	@Localization def String i18nKeyForCreateShortcutWizard() {
		return 'CreateShortcutAction.Wizard'
	}

	@Localization def String i18nKeyForCreateShortcutOpenModel() {
		return 'CreateShortcutAction.OpenModel'
	}

}
