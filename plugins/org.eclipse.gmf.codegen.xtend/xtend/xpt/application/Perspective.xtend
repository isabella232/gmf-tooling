/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.application

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenApplication
import xpt.Common
import xpt.QualifiedClassNameProvider

class Perspective {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;
	
	def className(GenApplication it) '''«it.perspectiveClassName»'''

	def packageName(GenApplication it) '''«it.packageName»'''

	def qualifiedClassName(GenApplication it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenApplication it) '''«qualifiedClassName(it)»'''

	def Perspective(GenApplication it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» implements org.eclipse.ui.IPerspectiveFactory {
			«createInitialLayout(it)»
			«additions(it)»
		}
	'''

	def createInitialLayout(GenApplication it) '''
		«generatedMemberComment»
		public void createInitialLayout(org.eclipse.ui.IPageLayout layout) {
			layout.setEditorAreaVisible(true);
			layout.addPerspectiveShortcut(«getWorkbenchAdvisorQualifiedClassName(it)».PERSPECTIVE_ID);
			org.eclipse.ui.IFolderLayout right = layout.createFolder(
				"right", org.eclipse.ui.IPageLayout.RIGHT, 0.6f, layout.getEditorArea()); «nonNLS(1)»
			right.addView(org.eclipse.ui.IPageLayout.ID_OUTLINE);
			org.eclipse.ui.IFolderLayout bottomRight = layout.createFolder(
				"bottomRight", org.eclipse.ui.IPageLayout.BOTTOM, 0.6f, "right"); «nonNLS(1)»	 «nonNLS(2)»
			bottomRight.addView(org.eclipse.ui.IPageLayout.ID_PROP_SHEET);
			«layoutAdditions(it)»
		}
	'''

	def layoutAdditions(GenApplication it) ''''''

	def additions(GenApplication it) ''''''

}
