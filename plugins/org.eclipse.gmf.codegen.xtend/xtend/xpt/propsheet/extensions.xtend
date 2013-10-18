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
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.propsheet

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.CustomTabFilter
import org.eclipse.gmf.codegen.gmfgen.GenCustomPropertyTab
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet
import org.eclipse.gmf.codegen.gmfgen.GenPropertyTab
import org.eclipse.gmf.codegen.gmfgen.GenPropertyTabFilter
import org.eclipse.gmf.codegen.gmfgen.GenStandardPropertyTab
import org.eclipse.gmf.codegen.gmfgen.TypeTabFilter
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto

@com.google.inject.Singleton class extensions {
	@Inject extension Common;
	@Inject extension Common_qvto;
	
	@Inject LabelProvider labelProvider;
	def extensions(GenPropertySheet it) 
	'''
		<extension point="org.eclipse.ui.views.properties.tabbed.propertyContributor" id="prop-contrib">
			«xmlGeneratedTag»
			<propertyContributor
				contributorId="«editorGen.plugin.ID»"
				«IF needsCaption»labelProvider="«labelProvider.qualifiedClassName(it)»"«ENDIF»>
			<propertyCategory category="domain"/>
			<propertyCategory category="visual"/>
			<propertyCategory category="extra"/>
			</propertyContributor>
		</extension>
		
		<extension point="org.eclipse.ui.views.properties.tabbed.propertyTabs" id="proptabs">
			«xmlGeneratedTag»   
			<propertyTabs contributorId="«editorGen.plugin.ID»">
				«FOR t : tabs»
				«tab(t)»
				«ENDFOR»
			</propertyTabs>
		</extension>
		
		<extension point="org.eclipse.ui.views.properties.tabbed.propertySections" id="propsections">
			«xmlGeneratedTag»   
			<propertySections contributorId="«editorGen.plugin.ID»">
				«FOR t : tabs»
				«section(t)»
				«ENDFOR»
			</propertySections>
		</extension>
	'''

	def dispatch tab(GenPropertyTab it) '''«ERROR('Unknown property tab: ' + it)»'''

	def dispatch tab(GenStandardPropertyTab it) '''
		«IF ID == 'appearance'»
		<propertyTab
			category="visual"
			id="property.tab.AppearancePropertySection"
			label="%tab.appearance"/>
		«ELSEIF ID == 'diagram'»
		<propertyTab
			category="visual"
			id="property.tab.DiagramPropertySection"
			label="%tab.diagram"/>
		«ELSEIF ID == 'advanced'»
		<propertyTab
			category="extra"
			id="property.tab.AdvancedPropertySection"
			label="%tab.advanced"/>           
		«ENDIF»
	'''

	def dispatch tab(GenCustomPropertyTab it) '''
		<propertyTab
			«IF ID == 'domain'»
			category="domain"
			«ELSE»
			category="extra"
			«ENDIF»
			id="property.tab.«ID»"
			label="%tab.«ID»"/>
	'''

	def dispatch section(GenPropertyTab it) '''«ERROR('Unknown property tab: ' + it)»'''

	def dispatch section(GenStandardPropertyTab it) '''
		«IF ID == 'appearance'»
		<propertySection id="property.section.ConnectorAppearancePropertySection" 
			filter="org.eclipse.gmf.runtime.diagram.ui.properties.filters.ConnectionEditPartPropertySectionFilter" 
			class="org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ConnectionAppearancePropertySection" 
			tab="property.tab.AppearancePropertySection">
		</propertySection>
		<propertySection id="property.section.ShapeColorAndFontPropertySection" 
			filter="org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter" 
			class="org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ShapeColorsAndFontsPropertySection" 
			tab="property.tab.AppearancePropertySection">
		</propertySection> 
		<propertySection id="property.section.DiagramColorsAndFontsPropertySection" 
			filter="org.eclipse.gmf.runtime.diagram.ui.properties.filters.DiagramEditPartPropertySectionFilter" 
			class="org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.DiagramColorsAndFontsPropertySection" 
			tab="property.tab.AppearancePropertySection">
		</propertySection>     
		«ELSEIF ID == 'diagram'»
		<propertySection id="property.section.RulerGridPropertySection" 
			filter="org.eclipse.gmf.runtime.diagram.ui.properties.filters.DiagramEditPartPropertySectionFilter" 
			class="org.eclipse.gmf.runtime.diagram.ui.properties.sections.grid.RulerGridPropertySection" 
			tab="property.tab.DiagramPropertySection">
		</propertySection>     
		«ELSEIF ID == 'advanced'»
		<propertySection id="property.section.AdvancedPropertySection"
			class="org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection"
			filter="org.eclipse.gmf.runtime.diagram.ui.properties.filters.EditPartPropertySectionFilter"
			tab="property.tab.AdvancedPropertySection">
		</propertySection>            
		«ENDIF»
	'''

	def dispatch section(GenCustomPropertyTab it) '''
		<propertySection
			id="property.section.«ID»" 
			tab="property.tab.«ID»"
			«filter(it.filter)»
			class="«getQualifiedClassName()»">
				«input(it.filter)»
		</propertySection>
	'''

	def dispatch filter(GenPropertyTabFilter it) ''''''

	def dispatch filter(CustomTabFilter it) '''
		filter="«it.qualifiedClassName»"
	'''

	def dispatch input(GenPropertyTabFilter it) ''''''

	def dispatch input(TypeTabFilter it) '''
		«FOR type : getAllTypes()»
		<input type="«type»"/>
		«ENDFOR»
	'''

	@Localization def i18n(GenPropertySheet it) '''
	
	# Property Sheet
	«FOR tab : tabs»
	tab.«tab.ID»=«tab.label»
	«ENDFOR»«extraLineBreak»
	'''

}
