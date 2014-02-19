/**
 * Copyright (c) 2008, 2009 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.actions

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenAction
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.InitDiagramAction
import xpt.Common_qvto
import xpt.editor.InitDiagramFileAction
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

@com.google.inject.Singleton class PredefinedAction {

	@Inject extension Common_qvto

	@Inject LoadResourceAction xptLoadResourceAction;
	@Inject CreateShortcutAction xptCreateShortcutAction;
	@Inject InitDiagramFileAction xptInitDiagramFileAction;

	def dispatch Main(GenAction it) '''«ERROR('Abstract template for ' + it)»'''

	def dispatch Main(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''«xptLoadResourceAction.Main(it)»'''

	def dispatch qualifiedClassName(GenAction it) '''«ERROR('Action not supported ' + it)»'''

	def dispatch qualifiedClassName(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''«xptLoadResourceAction.qualifiedClassName(it)»'''
	def dispatch className(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''«xptLoadResourceAction.className(it)»'''
	def dispatch fullPath(org.eclipse.gmf.codegen.gmfgen.LoadResourceAction it) '''«qualifiedClassName(it)»'''
	def dispatch qualifiedClassName(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«xptCreateShortcutAction.qualifiedClassName(it)»'''
	def dispatch className(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«xptCreateShortcutAction.className(it)»'''
	def dispatch fullPath(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«qualifiedClassName(it)»'''
	def dispatch qualifiedClassName(GenDiagram it) '''«xptInitDiagramFileAction.qualifiedClassName(it)»'''
	def dispatch className(GenDiagram it) '''«xptInitDiagramFileAction.className(it)»'''
	def dispatch fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	/**
	 * XXX The reason we need editorGen here as an arument (not xptSelf.owner.editorGen) 
	 * is we don't have 'honest' InitDiagramAction at the moment, and create it on the fly
	 */
	def Main(InitDiagramAction it, GenEditorGenerator editorGen) //
	'''«xptInitDiagramFileAction.InitDiagramFileAction(it, editorGen)»'''

	/**
	 * This one is legal version of the above method
	 */
	def dispatch Main(InitDiagramAction it) '''«xptInitDiagramFileAction.InitDiagramFileAction(it, owner.editorGen)»'''

	def dispatch Main(org.eclipse.gmf.codegen.gmfgen.CreateShortcutAction it) '''«xptCreateShortcutAction.Main(it)»'''

}
