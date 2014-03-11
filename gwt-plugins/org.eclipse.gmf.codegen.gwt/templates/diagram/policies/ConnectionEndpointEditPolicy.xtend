package diagram.policies

import common.EditPolicyTemplate
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel

class ConnectionEndpointEditPolicy extends EditPolicyTemplate<GenLink> {

	override body(GenLink it) '''
		«createSelectionHandles»
		«additions»
	'''

	override editPolicyName(GenLink it) 
		'''«getConnectionEndpointEditPolicyClassName»'''
			
	override supertypes(GenLink it) 
		'''extends org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy'''
	
	def createSelectionHandles(GenLink it) '''
		«IF labels.size() > 0»
		«generatedMemberComment»
		protected java.util.List<org.eclipse.gef.Handle> createSelectionHandles() {
			@SuppressWarnings("unchecked")
			java.util.List<org.eclipse.gef.Handle> result = super.createSelectionHandles();

			for(Object next: getHost().getChildren()) {
				org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) ((org.eclipse.gef.EditPart) next).getModel();
				switch («getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(nextView)) {
					«FOR label: labels»
					«label.addSelectionHandles»
					«ENDFOR»
				}
			}

			return result;
		}
		«ENDIF»
	'''
	
	def addSelectionHandles(GenLinkLabel it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
		result.addAll(((«getEditPartQualifiedClassName()») next).createSelectionHandles());
		break;
	'''

}
