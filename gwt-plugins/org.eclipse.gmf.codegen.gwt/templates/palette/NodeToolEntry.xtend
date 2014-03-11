package palette

import org.eclipse.gmf.codegen.gmfgen.Palette
import common.Common
import diagram.VisualIDRegistry

class NodeToolEntry {
	
	extension VisualIDRegistry = new VisualIDRegistry
	extension Common = new Common

	/**
	 * TODO: Move to gwt runtime (will need an extra param in constructor for model id)
	 */
	def nodeToolEntry(Palette it) '''
		«generatedClassComment»
		private static class NodeToolEntry «supertypes» {
			«attrs»
			«ctor»
			«createTool»
			«additions»
		}
	'''
	
	def supertypes(Palette it) '''extends org.eclipse.gef.palette.CombinedTemplateCreationEntry'''
	
	def attrs(Palette it) '''
		«generatedMemberComment»
		private final int[] myVisualIDs;
	'''
	
	def ctor(Palette it) '''
		«generatedMemberComment»
		private NodeToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new org.eclipse.gmf.runtime.gwt.requests.ModelCreationFactory(org.eclipse.gmf.runtime.notation.Node.class), null, null);
			myVisualIDs = visualIDs;
		}
	'''
	
	def createTool(Palette it) '''
		«generatedMemberComment»
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool result = new org.eclipse.gef.tools.CreationTool() {
				protected org.eclipse.gef.Request createTargetRequest() {
					org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx request = new org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx(«diagram.modelID», myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
				protected void performCreation(int button) {
					super.performCreation(button);
					final org.eclipse.gef.EditPart createdEditPart = (org.eclipse.gef.EditPart)getCurrentViewer().getEditPartRegistry().get(getCreateRequest().getNewObject());
					if (createdEditPart != null) {
						getCurrentViewer().getControl().getDisplay().asyncExec(new Runnable() {
							public void run() {
								if (createdEditPart.isActive()) {
									createdEditPart.performRequest(new org.eclipse.gef.Request(org.eclipse.gef.RequestConstants.REQ_DIRECT_EDIT));
								}
							}
						});
					}
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}
	'''
	
	def additions(Palette it) ''''''

}