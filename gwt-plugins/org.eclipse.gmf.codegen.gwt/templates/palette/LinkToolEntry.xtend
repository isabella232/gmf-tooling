package palette

import org.eclipse.gmf.codegen.gmfgen.Palette
import common.Common
import diagram.VisualIDRegistry

class LinkToolEntry {

	extension VisualIDRegistry = new VisualIDRegistry
	extension Common = new Common

	/**
	 * TODO: Move to gwt runtime (will need an extra param in constructor for model id)
	 */
	def linkToolEntry(Palette it) '''
		«generatedClassComment»
		private static class LinkToolEntry «supertypes» {
			«attrs»
			«ctor»
			«createTool»
			«additions»
		}
	'''

	def supertypes(Palette it) '''extends org.eclipse.gef.palette.ConnectionCreationToolEntry'''
	
	def attrs(Palette it) '''
		«generatedMemberComment»
		private final int[] myVisualIDs;
	'''
	
	def ctor(Palette it) '''
		«generatedMemberComment»
		private LinkToolEntry(String title, String description, int[] visualIDs) {
			super(title, description, new org.eclipse.gmf.runtime.gwt.requests.ModelCreationFactory(org.eclipse.gmf.runtime.notation.Edge.class), null, null);
			myVisualIDs = visualIDs;
		}
	'''
	
	def createTool(Palette it) '''
		«generatedMemberComment»
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool result = new org.eclipse.gef.tools.ConnectionCreationTool() {
				{
					setUnloadWhenFinished(true);
				}
				protected org.eclipse.gef.Request createTargetRequest() {
					org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx request = new org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx(«diagram.modelID», myVisualIDs);
					request.setFactory(getFactory());
					return request;
				}
			};
			result.setProperties(getToolProperties());
			return result;
		}
	'''
	
	def additions(Palette it) ''''''

}