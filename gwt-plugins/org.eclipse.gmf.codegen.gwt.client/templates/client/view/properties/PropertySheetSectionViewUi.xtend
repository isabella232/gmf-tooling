package client.view.properties

import client.view.Ui
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class PropertySheetSectionViewUi extends Ui {

	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "PropertySheetSectionView.ui.xml"
	}

	override style() '''
		.nav-row {
			cursor: pointer;
			overflow: hidden;
			position: relative;
		}
	'''

	override content() '''
		<g:HTMLPanel styleName="{style.nav-row}" ui:field="layout"></g:HTMLPanel>
	'''

}