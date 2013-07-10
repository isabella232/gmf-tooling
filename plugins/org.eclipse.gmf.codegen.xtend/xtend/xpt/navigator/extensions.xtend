/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Dmitry Stadnik (Borland) - initial API and implementation
 *		Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common

class extensions {
	@Inject extension Common;

	def extensions(GenNavigator it) '''
		«editorInputPropertyTester(it, 'URIEditorInput', 'org.eclipse.emf.common.ui.URIEditorInput',
			it.uriInputTesterQualifiedClassName)»
		
		«IF editorGen.diagram.generateShortcutIcon()»
			«editorInputPropertyTester(it, 'Shortcut', 'org.eclipse.gmf.runtime.notation.View',
			editorGen.diagram.shortcutPropertyTesterQualifiedClassName)»
		«ENDIF»
		
		«registerBindings(it)»
		
		<extension point="org.eclipse.ui.navigator.navigatorContent" id="navigator-content">
			«xmlGeneratedTag()»
			<navigatorContent
					id="«contentExtensionID»" 
					name="«contentExtensionName»" 
					priority="«contentExtensionPriority»" 
					contentProvider="«getContentProviderQualifiedClassName()»" 
					labelProvider="«getLabelProviderQualifiedClassName()»"
					icon="«editorGen.editor.iconPathX»"
					activeByDefault="true">
			<triggerPoints>
				<or>
					<and>
						<instanceof value="org.eclipse.core.resources.IFile"/>
						<test property="org.eclipse.core.resources.extension" value="«editorGen.diagramFileExtension»"/>
					</and>
					<instanceof value="«getAbstractNavigatorItemQualifiedClassName()»"/>
				«IF editorGen.diagram.generateShortcutIcon()»
					<adapt type="org.eclipse.gmf.runtime.notation.View">
						<test property="«editorGen.plugin.ID».isShortcut"/>
					</adapt>
				«ENDIF»
				</or>
			</triggerPoints>
			<possibleChildren>
				<or>
					<instanceof value="«getAbstractNavigatorItemQualifiedClassName()»"/>
				«IF editorGen.diagram.generateShortcutIcon()»
					<adapt type="org.eclipse.gmf.runtime.notation.View">
						<test property="«editorGen.plugin.ID».isShortcut"/>
					</adapt>
				«ENDIF»
				</or>
			</possibleChildren>
			<commonSorter 
				id="«sorterExtensionID»" 
				class="«getSorterQualifiedClassName()»">
				<parentExpression>
					<or>
						<and>
							<instanceof value="org.eclipse.core.resources.IFile"/>
							<test property="org.eclipse.core.resources.extension" value="«editorGen.diagramFileExtension»"/>
						</and>
						<instanceof value="«getAbstractNavigatorItemQualifiedClassName()»"/>
					</or>
				</parentExpression>
			</commonSorter>
			</navigatorContent>
		«IF generateDomainModelNavigator && null != editorGen.domainGenModel»
			<navigatorContent
					id="«domainContentExtensionID»" 
					name="«domainContentExtensionName»" 
					priority="«domainContentExtensionPriority»" 
					contentProvider="«getDomainContentProviderQualifiedClassName()»" 
					labelProvider="«getDomainLabelProviderQualifiedClassName()»"
					icon="«editorGen.editor.iconPathX»"
					activeByDefault="true">
			<triggerPoints>
				<or>
				<and>
					<instanceof value="org.eclipse.core.resources.IFile"/>
					<test property="org.eclipse.core.resources.extension" value="«editorGen.domainFileExtension»"/>
					</and>
					<instanceof value="«getDomainNavigatorItemQualifiedClassName()»"/>
				</or>
			</triggerPoints>
			<possibleChildren>
				<instanceof value="«getDomainNavigatorItemQualifiedClassName()»"/>
			</possibleChildren>
			</navigatorContent>
		«ENDIF»
			<actionProvider
			id="«actionProviderID»"
			class="«getActionProviderQualifiedClassName()»">
			<enablement>
				<or>
					<instanceof value="«getAbstractNavigatorItemQualifiedClassName()»"/>
				«IF editorGen.diagram.generateShortcutIcon()»
					<adapt type="org.eclipse.gmf.runtime.notation.View">
						<test property="«editorGen.plugin.ID».isShortcut"/>
					</adapt>
				«ENDIF»
				</or>
			</enablement>
			</actionProvider>
		</extension>
			
		«registerLinkHelper(it)»
	'''

	def editorInputPropertyTester(GenNavigator it, String property, String type, String testerClass) '''
		<extension point="org.eclipse.core.expressions.propertyTesters" id="navigator-proptest.is«property»">
			«xmlGeneratedTag()»
			<propertyTester
				id="«editorGen.plugin.ID».«property»PropertyTester"
				type="«type»"
				namespace="«editorGen.plugin.ID»"
				properties="is«property»"
				class="«testerClass»">
			</propertyTester>
		</extension>
	'''

	def registerBindings(GenNavigator it) '''
		<extension point="org.eclipse.ui.navigator.viewer" id="navigator-viewbinding">
			«xmlGeneratedTag()»
			<viewerContentBinding viewerId="org.eclipse.ui.navigator.ProjectExplorer">
				<includes>
					<contentExtension pattern="«contentExtensionID»"/>
					«IF generateDomainModelNavigator && null != editorGen.domainGenModel»
						<contentExtension pattern="«domainContentExtensionID»"/>
					«ENDIF»
					<contentExtension pattern="«linkHelperExtensionID»"/>
				</includes>
			</viewerContentBinding>
			<viewerActionBinding viewerId="org.eclipse.ui.navigator.ProjectExplorer">
			<includes>
				<actionExtension pattern="«actionProviderID»"/>
			</includes>
			</viewerActionBinding>
		</extension>
	'''

	def registerLinkHelper(GenNavigator it) '''
		<extension point="org.eclipse.ui.navigator.linkHelper" id="navigator-linkhelper">
			«xmlGeneratedTag()»
			<linkHelper
				id="«linkHelperExtensionID»"
				class="«getLinkHelperQualifiedClassName()»">
			<editorInputEnablement>
				<and>
					<instanceof value="org.eclipse.emf.common.ui.URIEditorInput"/>
					<test property="«editorGen.plugin.ID».isURIEditorInput"/>
				</and>
			</editorInputEnablement>
			<selectionEnablement>
				<instanceof value="«getAbstractNavigatorItemQualifiedClassName()»"/>
			</selectionEnablement>
			</linkHelper>
		</extension>
	'''

}
