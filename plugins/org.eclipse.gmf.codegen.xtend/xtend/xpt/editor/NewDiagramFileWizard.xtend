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

class NewDiagramFileWizard {
	@Inject extension Common;

	@Inject extension ExternalizerUtils_qvto;
	@Inject Externalizer xptExternalizer;
	@Inject Activator xptActivator;
	@Inject DiagramEditorUtil xptDiagramEditorUtil;
	@Inject VisualIDRegistry xptVisualIDRegistry;

	@Inject ModelElementSelectionPage xptModelElementSelectionPage;

	@MetaDef def className(GenDiagram it) '''«newDiagramFileWizardClassName»'''

	@MetaDef def qualifiedClassName(GenDiagram it) '''«editorGen.editor.packageName».«className(it)»'''

	def NewDiagramFileWizard(GenDiagram it) '''
	«copyright(editorGen)»
	package «editorGen.editor.packageName»;
	
	«generatedClassComment»
	public class «className(it)» extends org.eclipse.jface.wizard.Wizard {
	
		«generatedMemberComment»
		private «creationPage(it)» myFileCreationPage;
	
		«generatedMemberComment»
		private «xptModelElementSelectionPage.qualifiedClassName(it)» diagramRootElementSelectionPage;
	
		«generatedMemberComment»
		private org.eclipse.emf.transaction.TransactionalEditingDomain myEditingDomain;
	
		«generatedMemberComment»
		public «className(it)»(org.eclipse.emf.common.util.URI domainModelURI,
				org.eclipse.emf.ecore.EObject diagramRoot,
				org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain) {
			«_assert('domainModelURI != null : \"Domain model uri must be specified\"')»
		    «_assert('diagramRoot != null : \"Doagram root element must be specified\"')»
		    «_assert('editingDomain != null : \"Editing domain must be specified\"')»
	
			myFileCreationPage = new «creationPage(it)»(«xptExternalizer.accessorCall(editorGen,
			nameKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))», org.eclipse.jface.viewers.StructuredSelection.EMPTY);
			myFileCreationPage.setTitle(«xptExternalizer.accessorCall(editorGen,
			titleKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))»);
			myFileCreationPage.setDescription(org.eclipse.osgi.util.NLS.bind(
					«xptExternalizer.accessorCall(editorGen, descriptionKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))», 
					«VisualIDRegistry::modelID(it)»));
			org.eclipse.core.runtime.IPath filePath;
			String fileName = org.eclipse.emf.common.util.URI.decode(domainModelURI.trimFileExtension().lastSegment());
			if (domainModelURI.isPlatformResource()) {
				filePath = new org.eclipse.core.runtime.Path(domainModelURI.trimSegments(1).toPlatformString(true));
			} else if (domainModelURI.isFile()) {
				filePath = new org.eclipse.core.runtime.Path(domainModelURI.trimSegments(1).toFileString());
			} else {
				// TODO : use some default path
				throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); «nonNLS(1)»
			}
			myFileCreationPage.setContainerFullPath(filePath);
			myFileCreationPage.setFileName(«getDiagramEditorUtilQualifiedClassName()».getUniqueFileName(
					filePath, fileName, "«editorGen.diagramFileExtension»")); «nonNLS(1)»
	
			diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(«xptExternalizer.accessorCall(editorGen,
			nameKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»);
			diagramRootElementSelectionPage.setTitle(«xptExternalizer.accessorCall(editorGen,
			titleKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»);
			diagramRootElementSelectionPage.setDescription(«xptExternalizer.accessorCall(editorGen,
			descriptionKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»);
			diagramRootElementSelectionPage.setModelElement(diagramRoot);
	
		   	myEditingDomain = editingDomain;
		}
	
		«generatedMemberComment»
		public void addPages() {
			addPage(myFileCreationPage);
			addPage(diagramRootElementSelectionPage);
		}
	
		«generatedMemberComment»
		public boolean performFinish() {
			java.util.LinkedList<org.eclipse.core.resources.IFile> affectedFiles = new java.util.LinkedList<org.eclipse.core.resources.IFile>(); 
			«IF null == editorGen.application»
			org.eclipse.core.resources.IFile diagramFile = myFileCreationPage.createNewFile();
			«xptDiagramEditorUtil.callSetCharset(it, 'diagramFile')»
			affectedFiles.add(diagramFile);
			org.eclipse.emf.common.util.URI diagramModelURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			«ELSE»
			org.eclipse.core.runtime.IPath diagramModelPath = myFileCreationPage.getContainerFullPath().append(myFileCreationPage.getFileName());
			org.eclipse.emf.common.util.URI diagramModelURI = org.eclipse.emf.common.util.URI.createFileURI(diagramModelPath.toString());
			«ENDIF»
			org.eclipse.emf.ecore.resource.ResourceSet resourceSet = myEditingDomain.getResourceSet();
			final org.eclipse.emf.ecore.resource.Resource diagramResource = resourceSet.createResource(diagramModelURI);
			org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand command =
				new org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand(
					myEditingDomain, «xptExternalizer.accessorCall(editorGen, i18nKeyForNewDiagramFileWizardInitDiagramCommand(it))», affectedFiles) {
	
				protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(
						org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info)
							throws org.eclipse.core.commands.ExecutionException {
					int diagramVID = «xptVisualIDRegistry.getDiagramVisualIDMethodCall(it)»(diagramRootElementSelectionPage.getModelElement());
					if (diagramVID != «VisualIDRegistry::visualID(it)») {
						return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult(
							«xptExternalizer.accessorCall(editorGen, i18nKeyForNewDiagramFileWizardIncorrectRootError(it))»);
					}
					org.eclipse.gmf.runtime.notation.Diagram diagram =
						org.eclipse.gmf.runtime.diagram.core.services.ViewService.createDiagram(
							diagramRootElementSelectionPage.getModelElement(), «VisualIDRegistry::modelID(it)»,
							«xptActivator.preferenceHintAccess(editorGen)»);
					diagramResource.getContents().add(diagram);
					«IF editorGen.sameFileForDiagramAndModel»
					diagramResource.getContents().add(diagram.getElement());
					«ENDIF»
					«IF !it.synchronized»
					new «getDiagramContentInitializerQualifiedClassName()»().initDiagramContent(diagram);			
					«ENDIF»
					return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult();
				}
			};
			try {
				org.eclipse.core.commands.operations.OperationHistoryFactory.getOperationHistory().execute(
					command, new org.eclipse.core.runtime.NullProgressMonitor(), null);
				diagramResource.save(«xptDiagramEditorUtil.callGetSaveOptions(it)»);
				«getDiagramEditorUtilQualifiedClassName()».openDiagram(diagramResource);
			} catch (org.eclipse.core.commands.ExecutionException e) {
				«editorGen.plugin.activatorQualifiedClassName».getInstance().logError(
					"Unable to create model and diagram", e); «nonNLS(1)»
			} catch (java.io.IOException ex) {
				«editorGen.plugin.activatorQualifiedClassName».getInstance().logError(
					"Save operation failed for: " + diagramModelURI, ex); «nonNLS(1)»
			} catch (org.eclipse.ui.PartInitException ex) {
				«editorGen.plugin.activatorQualifiedClassName».getInstance().logError(
					"Unable to open editor", ex); «nonNLS(1)»
			}			
			return true;
		}
	
		«generatedClassComment»
		private static class DiagramRootElementSelectionPage extends «xptModelElementSelectionPage.qualifiedClassName(it)» {
	
			«generatedMemberComment»
			protected DiagramRootElementSelectionPage(String pageName) {
				super(pageName);
			}
	
			«generatedMemberComment»
			protected String getSelectionTitle() {
				return «xptExternalizer.accessorCall(editorGen, i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(it))»;
			}
	
			«generatedMemberComment»
			protected boolean validatePage() {
				if (getModelElement() == null) {
					setErrorMessage(«xptExternalizer.accessorCall(editorGen,
			i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(it))»);
					return false;
				}
				boolean result = org.eclipse.gmf.runtime.diagram.core.services.ViewService.getInstance().provides(
					new org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation(
						new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getModelElement()),
						«VisualIDRegistry::modelID(it)», «xptActivator.preferenceHintAccess(editorGen)»));
				setErrorMessage(result ? null : «xptExternalizer.accessorCall(editorGen,
			i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(it))»);
				return result;
			}
		}
	}
	'''

	def creationPage(GenDiagram it) '''
		«IF null == editorGen.application»
		org.eclipse.ui.dialogs.WizardNewFileCreationPage«ELSE»
		«editorGen.application.packageName».WizardNewFileCreationPage«ENDIF»
	'''

	@Localization def i18nAccessors(GenDiagram it) '''
		«xptExternalizer.accessorField(nameKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))»
		«xptExternalizer.accessorField(titleKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))»
		«xptExternalizer.accessorField(descriptionKey(i18nKeyForNewDiagramFileWizardCreationPage(it)))»
		«xptExternalizer.accessorField(nameKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»
		«xptExternalizer.accessorField(titleKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»
		«xptExternalizer.accessorField(descriptionKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)))»
		«xptExternalizer.accessorField(i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(it))»
		«xptExternalizer.accessorField(i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(it))»
		«xptExternalizer.accessorField(i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(it))»
		«xptExternalizer.accessorField(i18nKeyForNewDiagramFileWizardInitDiagramCommand(it))»
		«xptExternalizer.accessorField(i18nKeyForNewDiagramFileWizardIncorrectRootError(it))»
	'''

	@Localization def i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(nameKey(i18nKeyForNewDiagramFileWizardCreationPage(it)), 'Initialize new diagram file')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForNewDiagramFileWizardCreationPage(it)), 'Diagram file')»
		«xptExternalizer.messageEntry(descriptionKey(i18nKeyForNewDiagramFileWizardCreationPage(it)),
			'Create new diagram based on {0} model content')»
		«xptExternalizer.messageEntry(nameKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)),
			'Select diagram root element')»
		«xptExternalizer.messageEntry(titleKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)), 'Diagram root element')»
		«xptExternalizer.messageEntry(descriptionKey(i18nKeyForNewDiagramFileWizardRootSelectionPage(it)),
			'Select semantic model element to be depicted on diagram')»"Select diagram root element:"
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(it),
			'Select diagram root element:')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(it),
			'Diagram root element is not selected')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(it),
			'Invalid diagram root element is selected')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardInitDiagramCommand(it), 'Initializing diagram contents')»
		«xptExternalizer.messageEntry(i18nKeyForNewDiagramFileWizardIncorrectRootError(it),
			'Incorrect model object stored as a root resource object')»
	'''

	@Localization def String i18nKeyForNewDiagramFileWizard(GenDiagram diagram) {
		return diagram.newDiagramFileWizardClassName
	}

	@Localization def String i18nKeyForNewDiagramFileWizardCreationPage(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizard(diagram) + '.CreationPage'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardRootSelectionPage(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizard(diagram) + '.RootSelectionPage'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardRootSelectionPageSelectionTitle(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizardRootSelectionPage(diagram) + 'SelectionTitle'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardRootSelectionPageNoSelectionMessage(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizardRootSelectionPage(diagram) + 'NoSelectionMessage'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardRootSelectionPageInvalidSelectionMessage(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizardRootSelectionPage(diagram) + 'InvalidSelectionMessage'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardInitDiagramCommand(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizard(diagram) + '.InitDiagramCommand'
	}

	@Localization def String i18nKeyForNewDiagramFileWizardIncorrectRootError(GenDiagram diagram) {
		return i18nKeyForNewDiagramFileWizard(diagram) + '.IncorrectRootError'
	}

}
