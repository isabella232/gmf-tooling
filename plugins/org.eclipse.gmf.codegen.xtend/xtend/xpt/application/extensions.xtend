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
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.application

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenApplication
import xpt.Common

class extensions {
	@Inject extension Common;
	@Inject Application xptApplication
	@Inject Perspective xptPerspective
	@Inject ActionBarAdvisor xptActionBarAdvisor


	def extensions(GenApplication it) '''
	«IF it != null»
		<extension id="«ID»" point="org.eclipse.core.runtime.applications">
			«xmlGeneratedTag»
			<application>
				<run class="«xptApplication.qualifiedClassName(it)»"/>
			</application>
		</extension>
			<extension point="org.eclipse.ui.perspectives" id="rcp-perspective">
			«xmlGeneratedTag»
			<perspective
				id="«perspectiveId»"
				name="%perspectiveName"
				class="«xptPerspective.qualifiedClassName(it)»">
			</perspective>
		</extension>
			<extension point="org.eclipse.ui.commands" id="rcp-menu-commands">
			«xmlGeneratedTag»
			<command
				name="%openURIActionLabel"
				description="%openURIActionDescription"
				categoryId="org.eclipse.ui.category.file"
				id="«editorGen.plugin.ID».OpenURICommand"/>  
			<command
				name="%openActionLabel"
				description="%openActionDescription"
				categoryId="org.eclipse.ui.category.file"
				id="«editorGen.plugin.ID».OpenCommand"/>  
		</extension>
		
		<extension point="org.eclipse.ui.bindings" id="rcp-command-bindings">
			«xmlGeneratedTag»
			<key
				commandId="«editorGen.plugin.ID».OpenURICommand"
				sequence="M1+U"
				schemeId="org.eclipse.ui.defaultAcceleratorConfiguration"/>
			<key
				commandId="«editorGen.plugin.ID».OpenCommand"
				sequence="M1+O"
				schemeId="org.eclipse.ui.defaultAcceleratorConfiguration"/>
		</extension>
		
		<extension point="org.eclipse.ui.actionSets" id="rcp-actions">
			«xmlGeneratedTag»
			<actionSet
				label="%applicationActionSetLabel"
				visible="true"
				id="«editorGen.plugin.ID».ActionSet">
				<action
					label="%newDiagramActionLabel"
					class="«xptActionBarAdvisor.qualifiedClassName(it)»$NewDiagramAction"
					menubarPath="file/new/additions"
					id="«editorGen.plugin.ID».NewDiagramAction">
				</action>
				<action
					label="%aboutActionLabel"
					class="«xptActionBarAdvisor.qualifiedClassName(it)»$AboutAction"
					menubarPath="help/additions"
					id="«editorGen.plugin.ID».AboutAction">
				</action>
				<action
					label="%openURIActionLabel"
					definitionId="«editorGen.plugin.ID».OpenURICommand"
					class="«xptActionBarAdvisor.qualifiedClassName(it)»$OpenURIAction"
					menubarPath="file/additions"
					id="«editorGen.plugin.ID».OpenURIAction">
				</action>
				<action
					label="%openActionLabel"
					definitionId="«editorGen.plugin.ID».OpenCommand"
					class="«xptActionBarAdvisor.qualifiedClassName(it)»$OpenAction"
					menubarPath="file/additions"
					id="«editorGen.plugin.ID».OpenAction">
				</action>
			</actionSet>
		</extension>
	«ENDIF»
	'''

}
