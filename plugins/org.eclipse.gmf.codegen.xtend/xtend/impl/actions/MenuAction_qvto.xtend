/**
 * Copyright (c) 2009-2013 Borland Software Corporation and others
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

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class MenuAction_qvto {

	def boolean hasCommandsToContribute(GenEditorGenerator editorGen) {
		return !editorGen.contextMenus.empty
	}

	def boolean hasHandlersToContribute(GenEditorGenerator editorGen) {
		return hasCommandsToContribute(editorGen)
	}

}
