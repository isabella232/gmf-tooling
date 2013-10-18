/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 Artem Tikhomirov (Borland) - initial API and implementation
 *	 Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.actions

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenAction
import org.eclipse.gmf.codegen.gmfgen.GenCommandAction
import org.eclipse.gmf.codegen.gmfgen.GenContextMenu
import org.eclipse.gmf.codegen.gmfgen.GenContributionItem
import org.eclipse.gmf.codegen.gmfgen.GenContributionManager
import org.eclipse.gmf.codegen.gmfgen.GenCustomAction
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenGroupMarker
import org.eclipse.gmf.codegen.gmfgen.GenMenuManager
import org.eclipse.gmf.codegen.gmfgen.GenSeparator
import org.eclipse.gmf.codegen.gmfgen.GenToolBarManager
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.editparts.EditPartFactory

class extensions {
	@Inject extension Common_qvto;
	@Inject extension Common;
	@Inject extension MenuAction_qvto;
	
	@Inject EditPartFactory xptEditPartFactory;

	//[MG] why different pattern here, @Inject extension is normally usd for QCNP
	@Inject PredefinedAction predefinedAction;
	
	def Main(GenEditorGenerator it) '''
		<extension point="org.eclipse.ui.menus" id="context-menus">
			«xmlGeneratedTag»
			<!-- menuContribution locationURI="menu:org.eclipse.ui.main.menu?after=">
			</menuContribution>
			<menuContribution locationURI="toolbar:org.eclipse.ui.main.toolbar?after=">
			</menuContribution -->
			«FOR cm : contextMenus»
				«menuContribution(cm)»
			«ENDFOR»
		</extension>
		
		«IF hasCommandsToContribute(it)»
			<extension point="org.eclipse.ui.commands" id="menu-commands">
				«xmlGeneratedTag»
				<category id="«editor.ID»" name="%cmdcategory.name" description="%cmdcategory.desc"/>
				«FOR cm : contextMenus»
					«commandContribution(cm)»
				«ENDFOR»
			</extension>
		«ENDIF»
		
		«IF hasHandlersToContribute(it)»
			<extension point="org.eclipse.ui.handlers" id="menu-handlers">
				«xmlGeneratedTag»
				«FOR cm : contextMenus»
					«handlerContribution(cm)»
				«ENDFOR»
			</extension>
		«ENDIF»
		
		<!-- optionally, specify keybindings -->
	'''

	def menuContribution(GenContextMenu it) '''
		«menuContribution3(it, it, 'popup:org.eclipse.gmf.runtime.diagram.ui.DiagramEditorContextMenu')»
	'''

	def dispatch CharSequence menuContribution(GenContributionManager it, GenContextMenu contextMenu) '''«ERROR(
		'Abstract menuContribution for ' + it)»'''

	def dispatch CharSequence menuContribution(GenMenuManager it, GenContextMenu contextMenu) '''«menuContribution3(it,
		contextMenu, 'popup:' + it.ID)»'''

	def dispatch CharSequence menuContribution(GenToolBarManager it, GenContextMenu contextMenu) '''«menuContribution3(
		it, contextMenu, 'toolbar:' + it.ID)»'''

	def CharSequence menuContribution3(GenContributionManager it, GenContextMenu contextMenu, String locationURI) '''
		<menuContribution locationURI="«locationURI»">
		«FOR i : items»
			«menuEntry(i, contextMenu)»
		«ENDFOR»
		</menuContribution>
		«FOR m : items.filter(typeof(GenContributionManager))»
			«menuContribution(m, contextMenu)»
		«ENDFOR»
	'''

	def dispatch CharSequence commandContribution(GenContributionManager it) '''
		«FOR ca : items.filter(typeof(GenCustomAction))»
			«commandContribution(ca)»
		«ENDFOR»
		«FOR a : items.filter(typeof(GenAction))»
			«commandContribution(a)»
		«ENDFOR»
		«FOR cm : items.filter(typeof(GenContributionManager))»
			«commandContribution(cm)»
		«ENDFOR»
	'''

	def dispatch CharSequence handlerContribution(GenContributionManager it) '''
		«FOR ca : items.filter(typeof(GenCustomAction))»
			«handlerContribution(ca)»
		«ENDFOR»
		«FOR cm : items.filter(typeof(GenContributionManager))»
			«handlerContribution(cm)»
		«ENDFOR»
	'''

	def dispatch CharSequence commandContribution(GenCustomAction it) '''
		<command id="«commandIdentifier(it)»"
			name="«name»"
			categoryId="«owner.editorGen.editor.ID»"/>
	'''

	def dispatch CharSequence commandContribution(GenAction it) '''
		<command id="«commandIdentifier(it)»"
			name="«name/*FIXME: into i18n keys*/»"
			categoryId="«owner.editorGen.editor.ID»"
			defaultHandler="«predefinedAction.qualifiedClassName(it)»"/>
	'''

	def dispatch CharSequence handlerContribution(GenCustomAction it) '''
		<handler
			commandId="«commandIdentifier(it)»"
			class="«qualifiedClassName»">
			<enabledWhen>
				<with variable="activePartId"><equals value="«owner.editorGen.editor.ID»"/></with>
			</enabledWhen>
		</handler>
	'''

	def dispatch CharSequence commandIdentifier(GenCustomAction it) '''«owner.editorGen.plugin.ID».«lastSegment(
		qualifiedClassName)»'''

	def dispatch CharSequence commandIdentifier(GenAction it) '''«owner.editorGen.plugin.ID».«predefinedAction.className(it)»'''

	def dispatch CharSequence menuEntry(GenContributionItem it, GenContextMenu contextMenu) '''«/* NO-OP XXX or ERROR? */»'''

	def dispatch CharSequence menuEntry(GenSeparator it, GenContextMenu contextMenu) '''
		<separator name=«IF groupName != null»"«groupName»"«ELSE»"withoutname"«ENDIF» visible="true"/>
	'''

	def dispatch CharSequence menuEntry(GenGroupMarker it, GenContextMenu contextMenu) '''
		<separator name="«groupName»"/>
	'''

	def dispatch CharSequence menuEntry(GenCommandAction it, GenContextMenu contextMenu) '''
		<command commandId="«commandIdentifier»">
			<visibleWhen>
				«menuCondition(contextMenu)»
			</visibleWhen>
		</command>
	'''

	def dispatch CharSequence menuEntry(GenCustomAction it, GenContextMenu contextMenu) '''
		<command commandId="«commandIdentifier(it)»">
			<visibleWhen>
				«menuCondition(contextMenu)»
			</visibleWhen>
		</command>
	'''

	def dispatch CharSequence menuEntry(GenAction it, GenContextMenu contextMenu) '''
		<command commandId="«commandIdentifier(it)»">
			<visibleWhen>
				«menuCondition(contextMenu)»
			</visibleWhen>
		</command>
	'''

	def dispatch CharSequence menuEntry(GenMenuManager it, GenContextMenu contextMenu) '''
		<menu id="«it.ID»" label="«name»">
			<visibleWhen>
				«menuCondition(contextMenu)»
			</visibleWhen>
		</menu>
	'''

	def menuCondition(GenContextMenu it) '''
		<and>
			<with variable="activePartId"><equals value="«editorGen.editor.ID»"/></with>
			<with variable="selection"><iterate ifEmpty="false">«IF context.size > 1»<or>«ENDIF» 
			«/* XXX, perhaps, <adapt type="EditPart">? */FOR de : context»
				<instanceof value="«xptEditPartFactory.getEditPartQualifiedClassName(de)»"/>
			«ENDFOR»
			«IF context.size > 1»</or>«ENDIF»</iterate></with>
		</and>
	'''

	@Localization def i18n(GenEditorGenerator it) '''
		«IF hasCommandsToContribute(it)»
			# Commands and menu actions
			cmdcategory.name=«modelID» Editor Commands
			cmdcategory.desc=«modelID» Editor Commands
		«ENDIF»
	'''

}
