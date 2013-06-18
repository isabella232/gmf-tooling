/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
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
package xpt;

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import xpt.editor.VisualIDRegistry

/**
 * XXX: [MG] I don't like dependency from Common -> VisualIdRegistry 
 */
class Common {
	def copyright(GenEditorGenerator it) 
	'''
	«IF copyrightText != null»
	/*
	 * «copyrightText.replaceAll('\n', '\n * ')»
	 */
 	«ENDIF»
	'''
	def generatedClassComment(){
		doGeneratedComment('')
	}

	def generatedClassComment(Object it){
		generatedClassComment(it, '')
	}
	
	def generatedClassComment(Object it, String comment) {
		doGeneratedComment(comment)
	} 

	def generatedMemberComment() {
		doGeneratedComment('')	
	}

	def generatedMemberComment(Object it) {
		doGeneratedComment('')	
	}

	def generatedMemberComment(Object it, String comment) {
		doGeneratedComment(comment)
	} 

	/**
	 * XXX: FIXME: merge all generatedXXXcomment to go here
	 */ 
	def doGeneratedComment(String comment) 
	'''
	/**
	«IF comment.length > 0»* «comment.replaceAll('\n', '\n * ')»«ENDIF»
	* @generated
	*/
	'''

	def xmlGeneratedTag() '''<?gmfgen generated="true"?>'''
	
	def nonNLS_All(Iterable<?> list) '''«IF !list.empty»«FOR i : 1..list.size SEPARATOR ' '»«nonNLS(i)»«ENDFOR»«ENDIF»'''
	
	def nonNLS() '''«nonNLS(1)»'''
	
	def nonNLS(Object xptSelf, int i) '''«nonNLS(i)»'''

	def nonNLS(int xptSelf) '''//$NON-NLS-«xptSelf»$'''
	
	/**
	 * XXX:[MG] move this to VIDRegistry(?)
	 */
	def caseVisualID(GenCommonBase xptSelf) '''case «VisualIDRegistry::visualID(xptSelf)»:'''
	
	/**
	 * Provides handy single point to override generation of assert statements
	 * TODO refactor this Common.xpt into different flavours - like CommonCodeStyle (nls, assert), CommonSnippets(pkgStmt, setCharset, getSaveOptions) and so on
	 * TODO condition.xpandToCharList()->count('"') / 2 gives better guess about number of nonNLS to generate
	 */ 
	def _assert(String condition) //
	'''assert «condition»;«IF condition.indexOf('\"') > 0» «nonNLS»«ENDIF»'''
	
	def addShortcutAnnotation(GenDiagram it, String viewVar) '''
		org.eclipse.emf.ecore.EAnnotation shortcutAnnotation = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAnnotation();
		shortcutAnnotation.setSource("Shortcut"); «nonNLS()»
		shortcutAnnotation.getDetails().put("modelID", «VisualIDRegistry::modelID(it)»); «nonNLS()»
		«viewVar».getEAnnotations().add(shortcutAnnotation);
	'''
	
	/**
	 * FIXME: [MG] in some cases old xpand template generated artificial extra line break
	 * For now we want to preserve evrything including new line, to simplify checking the diff's against old generated code 
	 * In future this extra lines should be removed, this is single point of removal 
	 */
	def extraLineBreak() '''
		«/*FIXME: artificially inserting new line break to reduce diff against xpand templates */»
	'''

}

