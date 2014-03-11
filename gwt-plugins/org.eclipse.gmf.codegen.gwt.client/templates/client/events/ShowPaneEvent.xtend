package client.events

import client.ClientClassTemplate
import client.presenter.AppController
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class ShowPaneEvent extends ClientClassTemplate {

	@Inject AppController appController

	override protected getImports(GenEditorGenerator it) '''
		import «appController.qualifiedClassName(it)».Panes;

		import com.google.gwt.event.shared.EventHandler;
		import com.google.gwt.event.shared.GwtEvent;
	''' 

	override body(GenEditorGenerator it) '''
		«generatedMemberComment»
		public final Panes pane;

		«generatedMemberComment»
		public «className»(Panes pane) {
			this.pane = pane;
		}

		«generatedMemberComment»
		public interface «className»Handler extends EventHandler {
			«generatedMemberComment»
			void show(«qualifiedClassName» event);
		}

		«generatedMemberComment»
		public static Type<«qualifiedClassName».«className»Handler> TYPE = new Type<«qualifiedClassName».«className»Handler>();

		«generatedMemberComment»
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<«qualifiedClassName».«className»Handler> getAssociatedType() {
			return TYPE;
		}

		«generatedMemberComment»
		@Override
		protected void dispatch(«qualifiedClassName».«className»Handler handler) {
			handler.show(this);
		}
	'''

	override protected extendDefinition(GenEditorGenerator it) 
		'''com.google.gwt.event.shared.GwtEvent<«qualifiedClassName».«className»Handler>'''

	override packageName(GenEditorGenerator it) '''«baseEventPackage»'''

}

