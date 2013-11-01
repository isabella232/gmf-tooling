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
package xpt.diagram.updater

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater

@com.google.inject.Singleton class extensions {
	@Inject extension xpt.Common;

	def extensions(GenDiagramUpdater it) '''
		«extraLineBreak»
		«extraLineBreak»
		«tripleSpace(1)»<extension point="org.eclipse.ui.commands" id="update-cmd">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<command
		«tripleSpace(3)»categoryId="org.eclipse.ui.category.edit"
		«tripleSpace(3)»defaultHandler="«getUpdateCommandQualifiedClassName()»"
		«tripleSpace(3)»description="%update.diagram.description"
		«tripleSpace(3)»id="«updateCommandID»"
		«tripleSpace(3)»name="%update.diagram.name"/>
		«tripleSpace(1)»</extension>
		«extraLineBreak»«outTab»
		«tripleSpace(1)»<extension point="org.eclipse.ui.bindings" id="update-cmd-binding">
		«tripleSpace(2)»«xmlGeneratedTag»
		«tripleSpace(2)»<key 
		«tripleSpace(3)»commandId="«updateCommandID»"
		«tripleSpace(3)»contextId="«editorGen.editor.contextID»"
		«tripleSpace(3)»schemeId="org.eclipse.ui.defaultAcceleratorConfiguration"
		«tripleSpace(3)»sequence="F5"/>
		«tripleSpace(1)»</extension>
	'''
	
	def outTab() {
		return '	';
	}
}
