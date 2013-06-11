/**
 * Copyright (c) 2008, 2009 Borland Software Corporation
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
import org.eclipse.gmf.codegen.gmfgen.GenCustomAction
import xpt.Common
import xpt.Common_qvto

class CustomAction {

	@Inject extension Common;
	@Inject extension Common_qvto;

	def Main(GenCustomAction it) '''
		«copyright(it.owner.editorGen)»
		package «withoutLastSegment(it.qualifiedClassName)»;
		
		«generatedClassComment(it)»
		public class «lastSegment(it.qualifiedClassName)» extends org.eclipse.core.commands.AbstractHandler {
		
			«generatedMemberComment(it)»
			public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
				org.eclipse.ui.IEditorPart diagramEditor = org.eclipse.ui.handlers.HandlerUtil.getActiveEditorChecked(event);
				org.eclipse.jface.viewers.ISelection selection = org.eclipse.ui.handlers.HandlerUtil.getCurrentSelectionChecked(event);
				// FIXME implement required behavior
				throw new UnsupportedOperationException();
			}
		}
	'''

}
