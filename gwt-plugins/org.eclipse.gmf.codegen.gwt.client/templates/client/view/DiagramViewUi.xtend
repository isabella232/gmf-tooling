package client.view

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class DiagramViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "DiagramView.ui.xml"
	}
	
	override style() '''
		.diagram-outter {
			position: absolute;
			top: 0px;
			right: 0px;
			bottom: 0px;
			left: 40px;
		}

		.diagram-edit {
			background: none repeat scroll 0% 0% white;
			width: 100%;
			height: 100%;
		}
	'''

	override content() '''
		<g:HTMLPanel ui:field="diagramOutterPanel" styleName="{style.diagram-outter}">
			<g:HTMLPanel ui:field="diagramPanel" styleName="{style.diagram-edit}"></g:HTMLPanel>
		</g:HTMLPanel>
	'''

}