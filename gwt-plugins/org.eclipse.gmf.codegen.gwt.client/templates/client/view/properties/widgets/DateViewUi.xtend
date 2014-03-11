package client.view.properties.widgets

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class DateViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "DateView.ui.xml"
	}
	
	override namespaces(GenEditorGenerator it) '''«super.namespaces(it)»
			xmlns:dp="urn:import:com.google.gwt.user.datepicker.client"'''

	override style() '''
		.item { padding: 5px; color: black; }
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.item}">
			<g:Label ui:field="label"></g:Label>
			<dp:DateBox ui:field="date"></dp:DateBox>
		</g:HTMLPanel>
	'''

}