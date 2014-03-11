package client.view

import client.QualifiedNamesHelper
import common.BaseFileTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class Ui extends BaseFileTemplate<GenEditorGenerator> {

	protected extension QualifiedNamesHelper = new QualifiedNamesHelper

	def namespaces(GenEditorGenerator it) 
		'''xmlns:ui="urn:ui:com.google.gwt.uibinder"
			xmlns:g="urn:import:com.google.gwt.user.client.ui"'''

	def additions(GenEditorGenerator it) ''''''

	def style() ''''''
	
	def content() ''''''

	override generate(GenEditorGenerator it) '''
		<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
		<ui:UiBinder «namespaces»>

			«IF additions.length > 0»
			«additions»

			«ENDIF»
			«IF style.length > 0»
			<ui:style>
				«style»
			</ui:style>
			«ENDIF»

			«IF content.length > 0»
			«content»
			«ENDIF»

		</ui:UiBinder>
	'''

	override filePath(GenEditorGenerator it) { 
		baseViewPackage.toString.replaceAll("\\.", "/") + "/"
	}

}