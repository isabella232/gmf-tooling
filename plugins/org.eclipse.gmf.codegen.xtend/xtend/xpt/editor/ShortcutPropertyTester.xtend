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

class ShortcutPropertyTester {
	@Inject extension Common;

	def className(GenDiagram it) '''«shortcutPropertyTesterClassName»'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def ShortcutPropertyTester(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» extends org.eclipse.core.expressions.PropertyTester {
			
			«attributes(it)»
			
			«test(it)»
			
			«additions(it)»
		}
	'''

	def attributes(GenDiagram it) '''
		«generatedMemberComment»
		protected static final String SHORTCUT_PROPERTY = "isShortcut"; «nonNLS(1)»
	'''

	def test(GenDiagram it) '''
		«generatedMemberComment»
		public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
			if (false == receiver instanceof org.eclipse.gmf.runtime.notation.View) {
				return false;
			}
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) receiver;
			if (SHORTCUT_PROPERTY.equals(method)) {
				org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); «nonNLS(1)»
				if (annotation != null) {
					return «VisualIDRegistry::modelID(it)».equals(annotation.getDetails().get("modelID")); «nonNLS(1)»
				}
			}
			return false;
		}
	'''

	def additions(GenDiagram it) ''''''
}
