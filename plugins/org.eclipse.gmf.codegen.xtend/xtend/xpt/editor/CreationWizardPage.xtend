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
import xpt.Common
import xpt.Externalizer

class CreationWizardPage {
	@Inject extension Common;
	
	@Inject Externalizer xptExternalizer;
	@Inject DiagramEditorUtil xptDiagramEditorUtil;
	
	def className(GenDiagram it) '''«creationWizardPageClassName»'''
	
	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def extendsList(GenDiagram it) '''extends « //
		IF editorGen.application == null»org.eclipse.ui.dialogs.WizardNewFileCreationPage« //
		ELSE»«editorGen.application.packageName».WizardNewFileCreationPage«ENDIF»'''

	def CreationWizardPage(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
			
			«generatedMemberComment»
			private final String fileExtension;
			
			«generatedMemberComment»
			public «className(it)»(String pageName,
					org.eclipse.jface.viewers.IStructuredSelection selection, String fileExtension) {
			super(pageName, selection);
			this.fileExtension = fileExtension;
			}
			
			«generatedMemberComment(it, 'Override to create files with this extension.\n')» 
			protected String getExtension() {
				return fileExtension;
			}
			
			«generatedMemberComment»
			public org.eclipse.emf.common.util.URI getURI() {
			«IF editorGen.application == null»
				return org.eclipse.emf.common.util.URI.createPlatformResourceURI(getFilePath().toString(), false);
			«ELSE»
				return org.eclipse.emf.common.util.URI.createFileURI(getFilePath().toString());
			«ENDIF»
			}
			«IF editorGen.application == null»
				
				«generatedMemberComment»
				protected org.eclipse.core.runtime.IPath getFilePath() {
					org.eclipse.core.runtime.IPath path = getContainerFullPath();
					if (path == null) {
						path = new org.eclipse.core.runtime.Path(""); //$NON-NLS-1$
					}
					String fileName = getFileName();
					if (fileName != null) {
						path = path.append(fileName);
					}
					return path;
				}
			«ENDIF»
			
			«generatedMemberComment»
			public void createControl(org.eclipse.swt.widgets.Composite parent) {
				super.createControl(parent);
				setFileName(«xptDiagramEditorUtil.qualifiedClassName(it)».getUniqueFileName(
						getContainerFullPath(), getFileName(), getExtension()));
				setPageComplete(validatePage());
			}
		
			«generatedMemberComment»
			protected boolean validatePage() {
				if (!super.validatePage()) {
					return false;
				}
				String extension = getExtension();
				if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
					setErrorMessage(org.eclipse.osgi.util.NLS.bind(
							«xptExternalizer.accessorCall(editorGen, i18nKeyForCreationWizardPageExtensionError(it))», extension));
					return false;
				}
				return true;
			}
			«additions(it)»
		}
	'''

	def additions(GenDiagram it) ''''''

	def i18nValues(GenDiagram it) '''
		«xptExternalizer.messageEntry(i18nKeyForCreationWizardPageExtensionError(it), 'File name should have {0} extension.')»
	'''

	def i18nAccessors(GenDiagram it) '''
		«xptExternalizer.accessorField(i18nKeyForCreationWizardPageExtensionError(it))»
	'''

	@Localization def String i18nKeyForCreationWizardPageExtensionError(GenDiagram diagram) {
		return className(diagram) + 'ExtensionError'
	}

}
