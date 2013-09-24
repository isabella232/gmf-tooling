/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2, use GMFT runtime
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

class DeleteElementAction {
	@Inject extension Common;

	def className(GenDiagram it) '''DeleteElementAction'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.tooling.runtime.actions.DefaultDeleteElementAction'''

	def DeleteElementAction(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» {
		
			«constructor(it)»
			
			«additions(it)»
		}
	'''

	def constructor(GenDiagram it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.ui.IWorkbenchPart part) {
			super(part);
		}
	'''

	def additions(GenDiagram it) ''''''

}
