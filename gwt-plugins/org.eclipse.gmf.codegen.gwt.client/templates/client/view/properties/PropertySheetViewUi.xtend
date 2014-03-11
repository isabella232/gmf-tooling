package client.view.properties

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class PropertySheetViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "PropertySheetView.ui.xml"
	}

	override additions(GenEditorGenerator it) '''
		<ui:with field='res' type='«baseClientPackage».icons.Icons' />
	'''
	
	override style() '''
		.diagram-property {
			position: absolute;
			top: 40px;
			left: 10px;
		}
		.nav-box {
			color: rgb(0, 0, 0);
			display: -moz-box;
			-moz-box-orient: vertical;
			-moz-box-align: stretch;
		}
	'''

	override content() '''
		<g:HTMLPanel styleName="{style.diagram-property}">
			<g:HTMLPanel ui:field="panel" styleName="{style.nav-box}"></g:HTMLPanel>
		</g:HTMLPanel>
	'''

}