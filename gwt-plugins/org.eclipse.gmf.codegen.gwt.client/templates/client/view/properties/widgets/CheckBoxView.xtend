package client.view.properties.widgets

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.FeatureEditPresenter
import client.view.BinderView

class CheckBoxView extends BinderView {

	@Inject FeatureEditPresenter presenter

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import «presenter.qualifiedClassName(it)».View;
		import «presenter.qualifiedClassName(it)».ViewEventHandler;
		
		import com.google.gwt.event.logical.shared.ValueChangeEvent;
		import com.google.gwt.event.logical.shared.ValueChangeHandler;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.CheckBox;
		import com.google.gwt.user.client.ui.Label;
	'''

	override protected implementDefinition(GenEditorGenerator it) '''View'''

	override attrs(GenEditorGenerator it) '''
		@UiField Label label;

		@UiField CheckBox check;
	'''
	
	override addMethods(GenEditorGenerator it) '''
		@Override
		public void addEventHandler(final ViewEventHandler handler) {
			check.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					handler.update(event.getValue());
				}
			});
		}

		@Override
		public Label getLabel() {
			return label;
		}

		@Override
		public Widget getEditWidget() {
			return check;
		}

		@Override
		public int getColSpan() {
			return 2;
		}

		@Override
		public void setValue(Object value) {
			check.setValue(Boolean.TRUE.equals(value));
		};
	'''
	
}