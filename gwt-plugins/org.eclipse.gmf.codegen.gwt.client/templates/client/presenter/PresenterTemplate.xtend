package client.presenter

import client.ClientClassTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

abstract class PresenterTemplate extends ClientClassTemplate {

	override protected body(GenEditorGenerator it) '''
		«interfaces»
		
		«handlers»

		«attrs»

		«ctor»

		«bind»

		«addMethods»

		«additions»

		«goTo»
	'''

	override packageName(GenEditorGenerator it) '''«basePresenterPackage»'''

	override protected implementDefinition(GenEditorGenerator it) '''«basePresenterPackage».Presenter'''

	def attrs(GenEditorGenerator it) '''
		«generatedMemberComment»
		private final com.google.gwt.event.shared.HandlerManager eventBus;

		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory;

		«generatedMemberComment»
		private final View view;
	'''

	def interfaces(GenEditorGenerator it) '''
		«viewInterface»
	'''
	
	def viewInterface(GenEditorGenerator it) '''
		«generatedMemberComment»
		public interface View {

			«viewInterfaceMethods»

		}
	'''

	def viewInterfaceMethods(GenEditorGenerator it) ''''''

	def handlers(GenEditorGenerator it) ''''''

	def ctor(GenEditorGenerator it) '''
		public «className»(«ctorParams») {
			«ctorBody»
		}
	'''

	def ctorParams() '''com.google.gwt.event.shared.HandlerManager eventBus, org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory, View view'''

	def ctorBody(GenEditorGenerator it) '''
		this.eventBus = eventBus;
		this.clientFactory = clientFactory;
		this.view = view;
	'''

	def bind(GenEditorGenerator it) '''
		«generatedMemberComment»
		private void bind() {
			«bindBody»
		}
	'''
	
	def bindBody(GenEditorGenerator it) ''''''
	
	def addMethods(GenEditorGenerator it) ''''''

	def goTo() '''
		«generatedMemberComment»
		@Override
		public void goTo(com.google.gwt.user.client.ui.HasWidgets container) {
			«goToBody»
		}
	'''

	def goToBody() ''''''

}