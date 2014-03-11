package client.view

import client.ClientClassTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

abstract class BinderView extends ClientClassTemplate {

	override packageName(GenEditorGenerator it) '''«baseViewPackage»'''

	override protected body(GenEditorGenerator it) '''
		«binder»

		«attrs»

		«ctor»

		«addMethods»
	'''
	
	override protected extendDefinition(GenEditorGenerator it) '''com.google.gwt.user.client.ui.Composite'''

	override getImports(GenEditorGenerator it) '''
		import com.google.gwt.core.client.GWT;
		import com.google.gwt.uibinder.client.UiBinder;
		import com.google.gwt.user.client.ui.Composite;
		import com.google.gwt.user.client.ui.Widget;
	'''

	def binder(GenEditorGenerator it) '''
		interface Binder extends com.google.gwt.uibinder.client.UiBinder<com.google.gwt.user.client.ui.Widget, «className»> {}

		private static Binder uiBinder = GWT.create(Binder.class);
	'''

	def attrs(GenEditorGenerator it) ''''''

	def ctor(GenEditorGenerator it) '''
		public «className»(«ctorParams») {
			initWidget(uiBinder.createAndBindUi(this));
			«ctorBody»
		}
	'''

	def ctorBody() ''''''

	def ctorParams() ''''''
	
	def addMethods(GenEditorGenerator it) ''''''

}