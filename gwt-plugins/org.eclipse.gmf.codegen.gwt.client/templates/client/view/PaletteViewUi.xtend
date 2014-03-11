package client.view

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class PaletteViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "PaletteView.ui.xml"
	}

	override additions(GenEditorGenerator it) '''
		<ui:with field='res' type='«baseClientPackage».icons.Icons' />
	'''

	override style() '''
		.diagram-palette {
			position: absolute;
			left: 10px;
		}
	'''

	override content() '''
		<g:HTMLPanel styleName="{style.diagram-palette}">
			<g:HTMLPanel ui:field="palettePanel"></g:HTMLPanel>
		</g:HTMLPanel>
	'''

}