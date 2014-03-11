package client.view.properties.widgets

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class TextViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "TextView.ui.xml"
	}
	
	override style() '''
		.item { 
			padding: 2px 2px;
			color: black; 
		}
		.item-label {
			width: 100%;
		}
	'''

	override content() '''
		<g:HTMLPanel styleName="{style.item}">
			<g:Label ui:field="label" styleName="{style.item-label}"></g:Label>
			<g:TextBox ui:field="text" styleName="{style.item-label}"></g:TextBox>
		</g:HTMLPanel>
	'''
	
}