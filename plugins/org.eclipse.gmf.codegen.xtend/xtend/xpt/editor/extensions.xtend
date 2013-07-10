/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 Dmitry Stadnik (Borland) - initial API and implementation
 *	 Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import xpt.Common

class extensions {
	@Inject extension Common;
		
	def extensions(GenEditorGenerator it) '''
		<extension point="org.eclipse.ui.editors" id="gmf-editor">
			«xmlGeneratedTag()»
			<editor
				id="«editor.ID»"
				name="%editorName"
				icon="«editor.iconPathX»"
				extensions="«diagramFileExtension»"
				default="true"
				class="«editor.getQualifiedClassName()»"
				matchingStrategy="«diagram.getMatchingStrategyQualifiedClassName()»"
				contributorClass="«editor.getActionBarContributorQualifiedClassName()»">
			</editor>
		</extension>
		
		<extension point="org.eclipse.ui.contexts" id="ui-context">
			«xmlGeneratedTag()»
			<context
				description="%context.description"
				id="«editor.contextID»"
				name="%context.name"
				parentId="org.eclipse.gmf.runtime.diagram.ui.diagramContext">
			</context>
		</extension>
		
		<extension point="org.eclipse.ui.newWizards" id="creation-wizard">
			«xmlGeneratedTag()»
			<wizard
				name="%newWizardName"
				icon="«diagram.creationWizardIconPathX»"
				category="«diagram.creationWizardCategoryID»"
				class="«diagram.getCreationWizardQualifiedClassName()»"
				id="«diagram.getCreationWizardQualifiedClassName()»ID">
				<description>%newWizardDesc</description>  
			</wizard>
		</extension>
		
		«IF diagram.generateInitDiagramAction()»
			«IF null == application»<extension point="org.eclipse.ui.popupMenus" id="init-diagram-action">
				«xmlGeneratedTag()»
				<objectContribution
					id="«plugin.ID».InitDiagram"
					nameFilter="*.«domainFileExtension»"
					objectClass="org.eclipse.core.resources.IFile">
					<action
						label="%initDiagramActionLabel"
						class="«diagram.getInitDiagramFileActionQualifiedClassName()»"
						menubarPath="additions"
						enablesFor="1"
						id="«plugin.ID».InitDiagramAction">
					</action>
				</objectContribution>
			</extension>
			«ELSE»
			<extension point="org.eclipse.ui.actionSets" id="init-diagram-action">
				«xmlGeneratedTag()»
				<actionSet
					label="%initDiagramActionLabel"
					visible="true"
					id="«plugin.ID».InitDiagram">
					<action
						label="%initDiagramActionLabel"
						class="«diagram.getInitDiagramFileActionQualifiedClassName()»"
						menubarPath="file/additions"
						id="«plugin.ID».InitDiagramAction">
					</action>
				</actionSet>
			</extension>
			«ENDIF»
		«ENDIF»
	'''
	
}