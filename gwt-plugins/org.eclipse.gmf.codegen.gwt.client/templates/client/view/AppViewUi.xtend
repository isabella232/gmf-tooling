package client.view

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class AppViewUi extends Ui {
	
	override filePath(GenEditorGenerator it) { 
		super.filePath(it) + "AppView.ui.xml"
	}
	
	override namespaces(GenEditorGenerator it) '''«super.namespaces(it)»
			xmlns:v="urn:import:«baseViewPackage»"'''

	override style() '''
		.main {
			width: 100%;
			height: 100%;
			box-sizing: border-box;
			-moz-box-sizing: border-box;
			overflow: hidden;
			position: absolute;
		}
		.content {
			width: 100%;
			position: absolute;
			top: 0px;
			bottom: 0px;
			overflow: hidden;
			-moz-user-select: none;
		}
	'''
	
	override content() '''
		<g:HTMLPanel styleName="{style.main}">
			<g:HTMLPanel styleName="{style.content}">
				<v:AppMenuView ui:field="controlPanel"></v:AppMenuView>
				<v:DiagramView ui:field="diagramPanel"></v:DiagramView>
			</g:HTMLPanel>
		</g:HTMLPanel>
	'''

}