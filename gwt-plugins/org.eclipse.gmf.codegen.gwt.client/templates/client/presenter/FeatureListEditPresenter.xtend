package client.presenter

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class FeatureListEditPresenter extends PresenterTemplate {

	@Inject FeatureEditPresenter superPresenter

	override protected isAbstract() { false }

	override protected getImports(GenEditorGenerator it) '''
		import java.util.ArrayList;
		import java.util.Collections;
		import java.util.List;
		
		import org.eclipse.emf.edit.provider.IItemLabelProvider;
		import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
		import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
		
		import com.google.gwt.user.client.ui.HasWidgets;
		import com.google.gwt.user.client.ui.ListBox;
	'''
	
	override attrs(GenEditorGenerator it) '''
		private View view;
	'''
	
	override protected extendDefinition(GenEditorGenerator it) '''«superPresenter.qualifiedClassName(it)»'''
	
	override viewInterface(GenEditorGenerator it) '''
		public interface View extends «superPresenter.qualifiedClassName(it)».View {
			ListBox getListBox();
		}
	'''

	override ctorParams() '''org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor, View view'''
	
	override ctorBody(GenEditorGenerator it) '''
		super(clientFactory, object, descriptor);

		this.view  = view;
		this.view.getLabel().setText(descriptor.getDisplayName(object));

		initialize();
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«initialize»
		
		«setValue»
		
		«update»
		
		«view»
	'''
	
	protected def getView() '''
		public View getView() {
			return view;
		};
	'''

	protected def initialize() '''
		protected void initialize() {
			Object value = getEditableValue();
			List<?> optionals = (List<?>) descriptor.getChoiceOfValues(object); 
			List<?> values;
		
			if (!descriptor.isMany(object)) {
				values = Collections.singletonList(value);
				view.getListBox().setVisibleItemCount(1);
			} else {
				values = (List<?>) value;
				view.getListBox().setVisibleItemCount(values.size());
			}
		
			setValue(values);
		
			if (!descriptor.isMany(object)) {
				setValue(optionals);
			}
		}
	'''

	protected def setValue() '''
		@Override
		public void setValue(Object value) {
			List<?> values = (List<?>) value;
			IItemLabelProvider labelProvider = descriptor.getLabelProvider(object);
			List<?> oldValues = (List<?>) values;
			List<Object> oldValueSelection = new ArrayList<Object>();
			int valueBoxItemCount = view.getListBox().getItemCount();
		
			if (valueBoxItemCount != 0) {
				for (int i = 0; i < valueBoxItemCount; ++i) {
					if (view.getListBox().isItemSelected(i) && oldValues.size() > i) {
						oldValueSelection.add(oldValues.get(i));
					}
				}
				view.getListBox().clear();
			}
		
			for (Object val : values) {
				view.getListBox().addItem(labelProvider.getText(val));

				if (oldValueSelection.contains(val) || oldValues != null && !oldValues.contains(val)) {
					view.getListBox().setItemSelected(view.getListBox().getItemCount() - 1, true);
				}
			}
		}
	'''
	
	protected def update() '''
		@Override
		protected void update(Object value) {
			List<?> optionals = (List<?>) descriptor.getChoiceOfValues(object);
			if (value instanceof Integer) {
				Object selected = optionals.get((Integer) value);
				descriptor.setPropertyValue(object, selected);
			}
		}
	'''

}