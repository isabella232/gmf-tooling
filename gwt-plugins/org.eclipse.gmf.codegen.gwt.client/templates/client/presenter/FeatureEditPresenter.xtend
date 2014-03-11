package client.presenter

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class FeatureEditPresenter extends PresenterTemplate {

	override protected isAbstract() { true }

	override viewInterfaceMethods(GenEditorGenerator it) '''
		Label getLabel();

		Widget getEditWidget();

		int getColSpan();

		void setValue(Object value);

		void addEventHandler(ViewEventHandler handler);

		Widget asWidget();
	'''
	
	override protected getImports(GenEditorGenerator it) '''
		import java.util.Collection;
		import java.util.EventObject;

		import org.eclipse.emf.common.command.Command;
		import org.eclipse.emf.common.command.CommandStack;
		import org.eclipse.emf.common.command.CommandStackListener;
		import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
		import org.eclipse.gmf.runtime.gwt.client.ClientFactory;

		import com.google.gwt.user.client.ui.Label;
		import com.google.gwt.user.client.ui.Widget;
	''' 

	override handlers(GenEditorGenerator it) '''
		public interface ViewEventHandler {
			void update(Object value);
		}

		protected final ViewEventHandler viewHandler = new ViewEventHandler() {
			@Override
			public void update(Object value) {
				FeatureEditPresenter.this.update(value);
			}
		};
	'''
	
	override attrs(GenEditorGenerator it) '''
		protected final ClientFactory clientFactory;
		protected final Object object;
		protected final IItemPropertyDescriptor descriptor;
		protected final CommandStackListener listener;
	'''

	override ctorParams() '''org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory, Object object, IItemPropertyDescriptor descriptor'''
	
	override ctorBody(GenEditorGenerator it) '''
		this.clientFactory = clientFactory;
		this.object = object;
		this.descriptor = descriptor;
		this.listener = getCommandStackListener();
	'''
	
	protected def update() '''
		protected abstract void update(Object value);
	'''
	
	protected def getListener() '''
		public CommandStackListener getListener() {
			return listener;
		}
	'''
	
	protected def getEditableValue() '''
		protected Object getEditableValue() {
			return clientFactory.getItemDelegator().getEditableValue(descriptor.getPropertyValue(object));
		}
	'''
	
	protected def getCommandStackListener() '''
		protected CommandStackListener getCommandStackListener() {
			return new CommandStackListener() {
				public void commandStackChanged(EventObject event) {
					Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();

					if (mostRecentCommand != null) {
						Collection<?> affectedObjects = mostRecentCommand.getAffectedObjects();
						if (!affectedObjects.isEmpty()) {
							Object newSelection = affectedObjects.iterator().next();
							if (newSelection.equals(object)) {
								setValue(getEditableValue());
							}
						}
					}
				}
			};
		}
	'''

	protected def setValue() '''
		public abstract void setValue(Object value);
	'''

	protected def getLabel() '''
		public String getLabel() {
			return descriptor.getDisplayName(object);
		}
	'''
	
	protected def getView() '''
		public abstract View getView();
	'''

	override addMethods(GenEditorGenerator it) '''
		«update»
		
		«editableValue»
		
		«commandStackListener»
		
		«setValue»
		
		«label»
		
		«view»

		@Override
		protected void finalize() throws Throwable {
			clientFactory.getCommandStack().removeCommandStackListener(getCommandStackListener());
			super.finalize();
		}
	'''

}