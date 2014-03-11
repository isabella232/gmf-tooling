package client.presenter

import client.ClientClassTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class Presenter extends ClientClassTemplate {

	override def generate(GenEditorGenerator it) '''
		package «basePresenterPackage»;

		«generatedClassComment»
		public interface «className» {

			«body»

		}
	'''
	
	override protected body(GenEditorGenerator it) 
	'''
		«generatedMemberComment»
		void goTo(com.google.gwt.user.client.ui.HasWidgets container);
	'''

	override packageName(GenEditorGenerator it) '''«basePresenterPackage»'''

}