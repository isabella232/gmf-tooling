package aspects.diagram.editparts

import xpt.Common
import diagram.editparts.NodeEditPart
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenNode

class FixedNodeEditPart extends NodeEditPart {
	@Inject extension Common;

	override additions(GenNode it) '''
		«addSourceConnection(it)»
		
		«addTargetConnection(it)»
	'''	
	
	def addSourceConnection(GenNode it) {
		return addConnection(it,  false);
	}
	
	def addTargetConnection(GenNode it) {
		return addConnection(it,  true);
	}
	
	def addConnection(GenNode it, boolean targetNotSource) {
		val suffix = if (targetNotSource) "Target" else "Source";
		val oppositeSuffix = if (!targetNotSource) "Target" else "Source"; 
		return 
		'''
		«generatedMemberComment»
		@Override
		protected void add«suffix»Connection(org.eclipse.gef.ConnectionEditPart connection, int index) {
			super.add«suffix»Connection(connection, index);
			if (connection.get«oppositeSuffix»() == null) {
				org.eclipse.gmf.runtime.notation.View model«oppositeSuffix» =  ((org.eclipse.gmf.runtime.notation.Edge) connection.getModel()).get«oppositeSuffix»();
				org.eclipse.gef.NodeEditPart editPart«oppositeSuffix» = (org.eclipse.gef.NodeEditPart)getViewer().getEditPartRegistry().get(model«oppositeSuffix»);
				if (editPart«oppositeSuffix» != null) {
					editPart«oppositeSuffix».refresh(); 
				}
			}
		}
		''';
	}	
}