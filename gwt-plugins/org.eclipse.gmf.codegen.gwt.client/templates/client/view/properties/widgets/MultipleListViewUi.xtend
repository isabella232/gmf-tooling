package client.view.properties.widgets

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class MultipleListViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "MultipleListView.ui.xml"
	}
	
	override style() '''
		.item { padding: 5px; color: black; width: 100%; }
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.item}">
			<g:Label ui:field="label"></g:Label>
			<g:HorizontalPanel ui:field="featureGrid" spacing="10">
				<g:FlowPanel>
					<g:FlowPanel ui:field="buttonPanel">
						<g:Button ui:field="addButton" styleName="add">add</g:Button>
						<g:Button ui:field="removeButton" styleName="delete">delete</g:Button>
						<g:Button ui:field="upButton" styleName="up">up</g:Button>
						<g:Button ui:field="downButton" styleName="down">down</g:Button>
					</g:FlowPanel>
					<g:ListBox width="100%" ui:field="valueBox" multipleSelect="true"></g:ListBox>
				</g:FlowPanel>
			</g:HorizontalPanel>
		</g:HTMLPanel>
	'''

}