package diagram.parts

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import common.Common

class Decorations {

	extension Common = new Common

	def decorationManager(GenCommonBase it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager myDecorationManager;

		«generatedMemberComment»
		public org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager getDecorationManager() {
			return myDecorationManager;
		}
	'''

	def dispatch createDecorationManager(GenCommonBase it) '''«'Unexpected type'»'''
	
	def dispatch createDecorationManager(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager createDecorationManager(org.eclipse.draw2d.IFigure decorationShape) {
			org.eclipse.gmf.runtime.gwt.edit.parts.decorations.PaneDecorationManager result = new org.eclipse.gmf.runtime.gwt.edit.parts.decorations.PaneDecorationManager(decorationShape);
			«adjustDecorationManager»
			return result;
		}
	'''

	def dispatch createDecorationManager(GenLink it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager createDecorationManager(org.eclipse.draw2d.Connection connection) {
			return new org.eclipse.gmf.runtime.gwt.edit.parts.decorations.ConnectionDecorationManager(connection);
		}
	'''
	
	def dispatch adjustDecorationManager(GenNode it) ''''''
	
	def dispatch adjustDecorationManager(GenTopLevelNode it) '''
		«IF getDiagram().shortcutsProvidedFor.size() > 0»
			result.installDecorationPosition("Shortcut", org.eclipse.draw2d.PositionConstants.SOUTH_WEST);
		«ENDIF»
	'''

}