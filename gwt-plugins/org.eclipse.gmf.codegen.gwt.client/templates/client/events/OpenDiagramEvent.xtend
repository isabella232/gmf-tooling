package client.events

import client.ClientClassTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class OpenDiagramEvent extends ClientClassTemplate {
	
	override body(GenEditorGenerator it) '''
		«generatedMemberComment»
		public interface «className»Handler extends com.google.gwt.event.shared.EventHandler {
			«generatedMemberComment»
			void onOpen(«qualifiedClassName» event);
		}

		«generatedMemberComment»
		public static Type<«qualifiedClassName».«className»Handler> TYPE = new Type<«qualifiedClassName».«className»Handler>();

		«generatedMemberComment»
		public final org.eclipse.emf.ecore.resource.Resource resource;

		«generatedMemberComment»
		public «className»(org.eclipse.emf.ecore.resource.Resource resource) {
			this.resource = resource;
		}

		«generatedMemberComment»
		@Override
		public com.google.gwt.event.shared.GwtEvent.Type<«qualifiedClassName».«className»Handler> getAssociatedType() {
			return TYPE;
		}

		«generatedMemberComment»
		@Override
		protected void dispatch(«qualifiedClassName».«className»Handler handler) {
			handler.onOpen(this);
		}
	'''

	override protected extendDefinition(GenEditorGenerator it) 
		'''com.google.gwt.event.shared.GwtEvent<«qualifiedClassName».«className»Handler>'''
	
	override packageName(GenEditorGenerator it) '''«baseEventPackage»'''

}