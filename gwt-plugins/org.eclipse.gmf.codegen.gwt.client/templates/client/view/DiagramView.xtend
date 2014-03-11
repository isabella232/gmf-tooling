package client.view

import client.presenter.DiagramPresenter
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class DiagramView extends BinderView {

	@Inject DiagramPresenter presenter

	override implementDefinition(GenEditorGenerator it) '''«presenter.qualifiedClassName(it)».View'''
	
	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import com.google.gwt.dom.client.Style;
		import com.google.gwt.dom.client.Style.Unit;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.HTMLPanel;

		import org.eclipse.gef.GraphicalViewer;
		import org.eclipse.swt.SWT;
	'''

	override attrs(GenEditorGenerator it) '''
		«generatedMemberComment»
		@UiField HTMLPanel diagramOutterPanel;

		«generatedMemberComment»
		@UiField HTMLPanel diagramPanel;

		«generatedMemberComment»
		private final org.eclipse.swt.widgets.Composite viewerComposite;

		«generatedMemberComment»
		private GraphicalViewer viewer;
	'''
	
	override ctorBody() '''
		viewerComposite = new org.eclipse.swt.widgets.Composite(null, SWT.NONE);
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		@Override
		public void setGraphicalViewer(GraphicalViewer viewer) {
			diagramPanel.clear();

			this.viewer = viewer;
			this.viewer.createControl(viewerComposite);

			viewerComposite.setSize(1200, 1200);
			diagramPanel.add(viewerComposite.getGwtWidget());
		}
	'''

}