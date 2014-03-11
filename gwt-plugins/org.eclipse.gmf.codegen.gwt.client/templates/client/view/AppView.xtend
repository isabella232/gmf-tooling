package client.view

import client.presenter.AppController
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class AppView extends BinderView {
	
	@Inject DiagramView diagramView
	@Inject AppController presenter

	override implementDefinition(GenEditorGenerator it) '''«presenter.qualifiedClassName(it)».View'''
	
	override attrs(GenEditorGenerator it) '''
		@com.google.gwt.uibinder.client.UiField «presenter.qualifiedClassName(it)».MenuView controlPanel;

		@com.google.gwt.uibinder.client.UiField «diagramView.qualifiedClassName(it)» diagramPanel;
	'''

	override addMethods(GenEditorGenerator it) '''
		@Override
		public «diagramView.qualifiedClassName(it)» get«diagramView.className(it)»() {
			return diagramPanel;
		}

		@Override
		public «presenter.qualifiedClassName(it)».MenuView getMenuView() {
			return controlPanel;
		}
	'''

}