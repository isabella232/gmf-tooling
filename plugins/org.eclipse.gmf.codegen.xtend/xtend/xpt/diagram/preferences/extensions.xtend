/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.preferences

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.Utils_qvto
import impl.preferences.CustomPage
import impl.preferences.StandardPage
import org.eclipse.gmf.codegen.gmfgen.GenCustomPreferencePage
import org.eclipse.gmf.codegen.gmfgen.GenStandardPreferencePage

@com.google.inject.Singleton class extensions {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject PreferenceInitializer xptPreferenceInitializer;
	@Inject CustomPage xptCustomPage;
	@Inject StandardPage xptStandardPage;

	def extensions(GenDiagram it) '''
		
		<extension point="org.eclipse.core.runtime.preferences" id="prefs">
			«xmlGeneratedTag»
			<initializer class="«xptPreferenceInitializer.qualifiedClassName(it)»"/>
		</extension>
		
		«IF it.preferencePages.notEmpty»
			<extension point="org.eclipse.ui.preferencePages" id="prefpages">
				«xmlGeneratedTag»
				«FOR pref : allPreferencePages(it)»
					«preferencePage(pref)»
				«ENDFOR»
			</extension>
		«ENDIF»
	'''

	def preferencePage(GenPreferencePage it) '''
		<page
			id="«ID»"
			name="%prefpage.«ID»"
			«IF null != parent»
				category="«parent.ID»"
			«ELSEIF !parentCategory.nullOrEmpty»
				category="«parentCategory»"
			«ENDIF»
			class="«getQualifiedPageName(it)»">
		</page>
	'''

	@Localization def i18n(GenDiagram it) '''
		# Preferences
		«FOR pref : allPreferencePages(it)»
			prefpage.«pref.ID»=«pref.name»
		«ENDFOR»
	'''
	def dispatch getQualifiedPageName(GenPreferencePage it) ''''''
	def dispatch getQualifiedPageName(GenCustomPreferencePage it) '''«xptCustomPage.qualifiedClassName(it)»'''
	def dispatch getQualifiedPageName(GenStandardPreferencePage it) '''«xptStandardPage.qualifiedClassName(it)»'''
}
