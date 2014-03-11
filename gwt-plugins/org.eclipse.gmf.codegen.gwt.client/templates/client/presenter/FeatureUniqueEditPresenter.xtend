package client.presenter

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class FeatureUniqueEditPresenter extends PresenterTemplate {
	
	@Inject FeatureEditPresenter superPresenter

	override protected isAbstract() { false }
	
	override protected getImports(GenEditorGenerator it) '''
		import org.eclipse.emf.ecore.EAttribute;
		import org.eclipse.emf.ecore.EDataType;
		import org.eclipse.emf.ecore.util.EcoreUtil;
		import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
		import org.eclipse.gmf.runtime.gwt.client.ClientFactory;

		import com.google.gwt.user.client.ui.HasWidgets;
	'''

	override viewInterface(GenEditorGenerator it) ''''''

	override attrs(GenEditorGenerator it) '''		
		private final EAttribute attribute;

		private final EDataType eDataType;
		
		private final View view;
	'''

	protected override extendDefinition(GenEditorGenerator it) '''«superPresenter.qualifiedClassName(it)»'''

	override ctorParams() '''org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor, View view'''

	override ctorBody(GenEditorGenerator it) '''
		super(clientFactory, object, descriptor);

		this.view  = view;
		this.attribute = (EAttribute) descriptor.getFeature(object);
		this.eDataType = attribute.getEAttributeType();
		this.view.addEventHandler(viewHandler);
		this.view.getLabel().setText(descriptor.getDisplayName(object));

		setValue(getEditableValue());
		clientFactory.getCommandStack().addCommandStackListener(getCommandStackListener());
	'''
	
	protected def update() '''
		@Override
		protected void update(Object value) {
			descriptor.setPropertyValue(object, EcoreUtil.createFromString(eDataType, value.toString()));
		}
	'''
	
	protected def setValue() '''
		@Override
		public void setValue(Object value) {
			view.setValue(EcoreUtil.convertToString(eDataType, value));
		}
	'''
	
	def getEDataType() '''
		public EDataType getEDataType() {
			return eDataType;
		}
	'''
	
	protected def getView() '''
		public View getView() {
			return view;
		};
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«update»

		«setValue»

		«EDataType»
		
		«view»
	'''

}