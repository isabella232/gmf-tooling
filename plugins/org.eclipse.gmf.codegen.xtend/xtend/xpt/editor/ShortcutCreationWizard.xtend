/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
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
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import plugin.Activator
import xpt.Common
import xpt.Externalizer
import xpt.ExternalizerUtils_qvto

class ShortcutCreationWizard {
	@Inject extension Common;
	@Inject extension ExternalizerUtils_qvto;

	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;
	@Inject ModelElementSelectionPage xptModelElementSelectionPage;

	@MetaDef def className(GenDiagram it) '''ShortcutCreationWizard'''

	@MetaDef def qualifiedClassName(GenDiagram it) '''«editorGen.editor.packageName».«className(it)»'''

	def ShortcutCreationWizard(GenDiagram it) '''
		«copyright(editorGen)»
		package «editorGen.editor.packageName»;
		
		«generatedClassComment(it, 'Allows to select foreign model element and add shortcut to the diagram.')»
		public class «className(it)» extends org.eclipse.jface.wizard.Wizard {
		
			 «generatedMemberComment»
			private ReferencedElementSelectionPage referencedElementSelectionPage;
		
			«generatedMemberComment»
			private org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain;
		
			«generatedMemberComment»
			public «className(it)»(org.eclipse.emf.ecore.EObject modelElement, org.eclipse.gmf.runtime.notation.View view,
					org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain) {
			referencedElementSelectionPage = new ReferencedElementSelectionPage(«xptExternalizer.accessorCall(editorGen,
			nameKey(i18nKeyForShortcutWizardReferencedElementPage(it)))», view);
			referencedElementSelectionPage.setTitle(«xptExternalizer.accessorCall(editorGen,
			titleKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»);
			referencedElementSelectionPage.setDescription(«xptExternalizer.accessorCall(editorGen,
			descriptionKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»);
			referencedElementSelectionPage.setModelElement(modelElement);
		
				this.editingDomain = editingDomain;
			}
		
			«generatedMemberComment»
			public void addPages() {
				addPage(referencedElementSelectionPage);
			}
		
			«generatedMemberComment»
			public boolean performFinish() {
				org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor viewDescriptor =
						new org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor(
								new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(referencedElementSelectionPage.getModelElement()),
								org.eclipse.gmf.runtime.notation.Node.class, null, «xptActivator.preferenceHintAccess(it.editorGen)»);
				org.eclipse.gmf.runtime.common.core.command.ICommand command =
						new org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand(
								editingDomain, viewDescriptor, referencedElementSelectionPage.getView());
				command = command.compose(new «getCreateShortcutDecorationsCommandQualifiedClassName()»(
						editingDomain, referencedElementSelectionPage.getView(), viewDescriptor));
				try {
					org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory().execute(
						command, new org.eclipse.core.runtime.NullProgressMonitor(), null);
				} catch (org.eclipse.core.commands.ExecutionException ee) {
					«editorGen.plugin.activatorQualifiedClassName».getInstance().logError("Unable to create shortcut", ee); «nonNLS(1)»
				}
				return true;
			}
		
			«generatedClassComment»
			private static class ReferencedElementSelectionPage extends «xptModelElementSelectionPage.qualifiedClassName(it)» {
		
				«generatedMemberComment»
				private org.eclipse.gmf.runtime.notation.View view;
		
				«generatedMemberComment»
				public ReferencedElementSelectionPage(String pageName, org.eclipse.gmf.runtime.notation.View view) {
					super(pageName);
					this.view = view;
				}
		
				«generatedMemberComment»
				public org.eclipse.gmf.runtime.notation.View getView() {
					return view;
				}
		
				«generatedMemberComment»
				protected String getSelectionTitle() {
					return «xptExternalizer.accessorCall(editorGen, messageKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»;
				}
		
				«generatedMemberComment»
				protected boolean validatePage() {
					if (selectedModelElement == null) {
						setErrorMessage(«xptExternalizer.accessorCall(editorGen,
			i18nKeyForShortcutWizardReferencedElementPageEmptyError(it))»);
						return false;
					}
					boolean result = org.eclipse.gmf.runtime.diagram.core.services.ViewService.getInstance().provides(
							org.eclipse.gmf.runtime.notation.Node.class,
							new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(selectedModelElement),
							view, null, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true,
							«xptActivator.preferenceHintAccess(it.editorGen)»);
					setErrorMessage(result ? null : «xptExternalizer.accessorCall(editorGen,
			i18nKeyForShortcutWizardReferencedElementPageInvalidError(it))»);
					return result;
				}
			}
		}
	'''

	@Localization def i18nValues(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.messageEntry(nameKey(i18nKeyForShortcutWizardReferencedElementPage(it)), 'Select referenced element')»
			«xptExternalizer.messageEntry(titleKey(i18nKeyForShortcutWizardReferencedElementPage(it)), 'Referenced element')»
			«xptExternalizer.messageEntry(descriptionKey(i18nKeyForShortcutWizardReferencedElementPage(it)),
				'Select element that the new shortcut will refer to.')»
			«xptExternalizer.messageEntry(messageKey(i18nKeyForShortcutWizardReferencedElementPage(it)),
				'Select referenced element:')»
			«xptExternalizer.messageEntry(i18nKeyForShortcutWizardReferencedElementPageEmptyError(it),
				'Referenced element is not selected')»
			«xptExternalizer.messageEntry(i18nKeyForShortcutWizardReferencedElementPageInvalidError(it),
				'Invalid referenced element is selected')»
		«ENDIF»
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
		«IF null != editorGen.application»
			«xptExternalizer.accessorField(nameKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»
			«xptExternalizer.accessorField(titleKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»
			«xptExternalizer.accessorField(descriptionKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»
			«xptExternalizer.accessorField(messageKey(i18nKeyForShortcutWizardReferencedElementPage(it)))»
			«xptExternalizer.accessorField(i18nKeyForShortcutWizardReferencedElementPageEmptyError(it))»
			«xptExternalizer.accessorField(i18nKeyForShortcutWizardReferencedElementPageInvalidError(it))»
		«ENDIF»
	'''

	@Localization def String i18nKeyForShortcutWizardReferencedElementPage(GenDiagram diagram) {
		return className(diagram) + '.ReferencedElementSelectionPage'
	}

	@Localization def String i18nKeyForShortcutWizardReferencedElementPageEmptyError(GenDiagram diagram) {
		return i18nKeyForShortcutWizardReferencedElementPage(diagram) + 'EmptyError'
	}

	@Localization def String i18nKeyForShortcutWizardReferencedElementPageInvalidError(GenDiagram diagram) {
		return i18nKeyForShortcutWizardReferencedElementPage(diagram) + 'InvalidError'
	}

}
