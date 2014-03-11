package client.view.properties.widgets

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.FeatureListEditPresenter
import client.view.BinderView

class MultipleListView extends BinderView {

	@Inject FeatureListEditPresenter presenter

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import java.util.List;

		import «presenter.qualifiedClassName(it)».View;
		import «basePresenterPackage».FeatureEditPresenter.ViewEventHandler;
		
		import com.google.gwt.event.dom.client.ChangeEvent;
		import com.google.gwt.event.dom.client.ChangeHandler;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.Button;
		import com.google.gwt.user.client.ui.FlowPanel;
		import com.google.gwt.user.client.ui.HorizontalPanel;
		import com.google.gwt.user.client.ui.Label;
		import com.google.gwt.user.client.ui.ListBox;
	'''

	override protected implementDefinition(GenEditorGenerator it) '''View'''

	override attrs(GenEditorGenerator it) '''
		@UiField Label label;
		@UiField HorizontalPanel featureGrid;
		@UiField ListBox valueBox;
		@UiField FlowPanel buttonPanel;
		@UiField Button upButton;
		@UiField Button downButton;
		@UiField Button addButton;
		@UiField Button removeButton;

		private List<?> values;
	'''
	
	override addMethods(GenEditorGenerator it) '''
		@Override
		public void addEventHandler(final ViewEventHandler handler) {
			getListBox().addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					handler.update(getListBox().getSelectedIndex());
				}
			});
		}

		@Override
		public ListBox getListBox() {
			return valueBox;
		}

		@Override
		public Label getLabel() {
			return label;
		}

		@Override
		public Widget getEditWidget() {
			return featureGrid;
		}

		@Override
		public int getColSpan() {
			return 1;
		}

		@Override
		public void setValue(Object value) {
			// TODO Auto-generated method stub
			
		}
	'''
	
}