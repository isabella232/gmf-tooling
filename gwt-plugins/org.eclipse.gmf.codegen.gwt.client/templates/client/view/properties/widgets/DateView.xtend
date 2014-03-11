package client.view.properties.widgets

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.FeatureEditPresenter
import client.view.BinderView

class DateView extends BinderView {

	@Inject FeatureEditPresenter presenter

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import java.util.Date;

		import «presenter.qualifiedClassName(it)».View;
		import «presenter.qualifiedClassName(it)».ViewEventHandler;
		
		import com.google.gwt.event.logical.shared.ValueChangeEvent;
		import com.google.gwt.event.logical.shared.ValueChangeHandler;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.datepicker.client.DateBox;
		import com.google.gwt.user.client.ui.Label;
	'''

	override protected implementDefinition(GenEditorGenerator it) '''View'''

	override attrs(GenEditorGenerator it) '''
		@UiField Label label;

		@UiField DateBox date;
	'''
	
	override addMethods(GenEditorGenerator it) '''
		@Override
		public void addEventHandler(final ViewEventHandler handler) {
			date.addValueChangeHandler(new ValueChangeHandler<Date>() {
				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					handler.update(event.getValue());
				}
			});
		}

		@Override
		public void setValue(Object value) {
			if (value instanceof Date) {
				date.setValue((Date) value);
			}
		}

		@Override
		public Label getLabel() {
			return label;
		}

		@Override
		public Widget getEditWidget() {
			return date;
		}

		@Override
		public int getColSpan() {
			return 1;
		}
	'''
	
}