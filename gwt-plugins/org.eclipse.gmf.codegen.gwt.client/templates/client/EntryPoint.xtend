package client

import client.presenter.AppController
import client.view.AppView
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class EntryPoint extends ClientClassTemplate {

	@Inject AppView appView
	@Inject AppController appController

	override protected body(GenEditorGenerator it) '''
		«onModuleLoad»
	'''

	def onModuleLoad(GenEditorGenerator it) '''
		«generatedMemberComment»
		public void onModuleLoad() {
			org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory = com.google.gwt.core.client.GWT.create(org.eclipse.gmf.runtime.gwt.client.ClientFactory.class);
			«appView.qualifiedClassName(it)» view = new «appView.qualifiedClassName(it)»();

			new «appController.qualifiedClassName(it)»(clientFactory.getEventBus(), clientFactory, view).goTo(com.google.gwt.user.client.ui.RootPanel.get());
		}
	'''

	override className(GenEditorGenerator it) '''AppEntryPoint'''

}