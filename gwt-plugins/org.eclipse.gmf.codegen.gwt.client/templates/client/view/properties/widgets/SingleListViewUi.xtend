package client.view.properties.widgets

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class SingleListViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "SingleListView.ui.xml"
	}
	
	override style() '''
		.item { padding: 5px; color: black; width: 100%; }
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.item}">
			<g:Label ui:field="label"></g:Label>
			<g:ListBox width="100%" ui:field="list" ></g:ListBox>
		</g:HTMLPanel>
	'''
	
}