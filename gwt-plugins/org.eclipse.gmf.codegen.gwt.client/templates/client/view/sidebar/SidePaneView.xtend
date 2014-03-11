package client.view.sidebar

import client.view.BinderView
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class SidePaneView extends BinderView {

	override getImports(GenEditorGenerator it) '''
		import com.google.gwt.core.client.GWT;
		import com.google.gwt.uibinder.client.UiBinder;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.Composite;
		import com.google.gwt.user.client.ui.HTMLPanel;
		import com.google.gwt.user.client.ui.Widget;
	'''
	
	override attrs(GenEditorGenerator it) '''
		«generatedMemberComment»
		@UiField HTMLPanel contentPanel;
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		public void setContent(Widget widget) {
			contentPanel.clear();
			contentPanel.add(widget);
		}
	'''
	
}