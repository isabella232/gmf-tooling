package client.view.properties.widgets

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class CheckBoxViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "CheckBoxView.ui.xml"
	}

	override style() '''
		.item { padding: 5px; color: black; }
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.item}">
			<g:Label ui:field="label"></g:Label>
			<g:CheckBox ui:field="check"></g:CheckBox>
		</g:HTMLPanel>
	'''

}