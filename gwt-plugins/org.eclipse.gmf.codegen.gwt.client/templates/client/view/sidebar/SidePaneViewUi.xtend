package client.view.sidebar

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.Ui

class SidePaneViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "SidePaneView.ui.xml"
	}
	
	override style() '''
		.side-pane {
			height: 100%;
			position: absolute;
			left: 0;
			top: 40px;
			display: block;
			overflow: auto;
			background: none repeat scroll 0px 0px rgb(250, 250, 250);
			border-right: 1px solid rgba(0, 0, 0, 0.15);
			color: #444;
		}
	'''

	override content() '''
		<g:HTMLPanel styleName="{style.side-pane}">
			<g:HTMLPanel ui:field="contentPanel"></g:HTMLPanel>
		</g:HTMLPanel>
	'''

}