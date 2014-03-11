package diagram.policies

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode

class ClassNames { 

	def getComponentEditPolicyClassName(GenCommonBase it) { baseName + 'ComponentEditPolicy' }

	def getLayoutEditPolicyClassName(GenContainerBase it) { baseName + 'LayoutEditPolicy' }

	def getSideAffixedLayoutEditPolicyClassName(GenContainerBase it) { baseName + 'SideAffixedLayoutEditPolicy' }

	def getGraphicalNodeEditPolicyClassName(GenCommonBase it) { baseName + 'GraphicalNodeEditPolicy' }

	def getGraphicalNodeEditPolicyClassName(GenNode it) { graphicalNodeEditPolicyClassName }

	def getConnectionEndpointEditPolicyClassName(GenLink it) { baseName + 'EndpointEditPolicy' }

	def getBaseName(GenCommonBase it) { 
		 if (editPartClassName.endsWith('EditPart')) 
		 	editPartClassName.substring(0, editPartClassName.length - 'EditPart'.length) 
		 else editPartClassName
	}

}