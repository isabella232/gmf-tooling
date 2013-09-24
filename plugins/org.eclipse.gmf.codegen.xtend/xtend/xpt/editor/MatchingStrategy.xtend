/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
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
import xpt.Common

class MatchingStrategy {
	@Inject extension Common;

	def className(GenDiagram it) '''«it.matchingStrategyClassName»'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def implementsList(GenDiagram it) '''implements org.eclipse.ui.IEditorMatchingStrategy'''

	def MatchingStrategy(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «implementsList(it)» {
		
			«matches(it)»
		
		}
	'''

	/**
	 * FIXME: [MG] #175260 is fixed, remove the last check below
	 */
	def matches(GenDiagram it) '''
		«generatedMemberComment»
		public boolean matches(org.eclipse.ui.IEditorReference editorRef, org.eclipse.ui.IEditorInput input) {
			org.eclipse.ui.IEditorInput editorInput;
			try {
				editorInput = editorRef.getEditorInput();
			} catch (org.eclipse.ui.PartInitException e) {
				return false;
			}
		        
			if (editorInput.equals(input)) {
				return true;
			}
			«/*FIXME: [MG]
			 * Should be removed then https://bugs.eclipse.org/bugs/show_bug.cgi?id=175260 commited.
			 * Problem is: URIEditorInput has no .equals() overriden
			 */»if (editorInput instanceof org.eclipse.emf.common.ui.URIEditorInput && input instanceof org.eclipse.emf.common.ui.URIEditorInput) {
				return ((org.eclipse.emf.common.ui.URIEditorInput) editorInput).getURI().equals(((org.eclipse.emf.common.ui.URIEditorInput) input).getURI());
			}
			return false;
		}
	'''

}
