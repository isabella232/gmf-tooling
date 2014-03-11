package client.view.properties.widgets

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.FeatureEditPresenter
import client.view.BinderView

class TextView extends BinderView {

	@Inject FeatureEditPresenter presenter

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import java.util.List;

		import «presenter.qualifiedClassName(it)».View;
		import «presenter.qualifiedClassName(it)».ViewEventHandler;
		
		import com.google.gwt.event.logical.shared.ValueChangeEvent;
		import com.google.gwt.event.logical.shared.ValueChangeHandler;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.Label;
		import com.google.gwt.user.client.ui.TextBox;
	'''

	override protected implementDefinition(GenEditorGenerator it) '''View'''

	override attrs(GenEditorGenerator it) '''
		@UiField Label label;

		@UiField TextBox text;
	'''
	
	override ctorBody() '''
		label.setWordWrap(false);
	'''
	
	override addMethods(GenEditorGenerator it) '''
		@Override
		public void addEventHandler(final ViewEventHandler handler) {
			text.addValueChangeHandler(new ValueChangeHandler<String>() {
				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					handler.update(event.getValue());
				}
			});
		}

		@Override
		public void setValue(Object value) {
			if (value instanceof String)
				text.setValue((String) value);
		}

		@Override
		public Label getLabel() {
			return label;
		}

		@Override
		public int getColSpan() {
			return 1;
		}

		@Override
		public Widget getEditWidget() {
			return text;
		}
	'''
	
}