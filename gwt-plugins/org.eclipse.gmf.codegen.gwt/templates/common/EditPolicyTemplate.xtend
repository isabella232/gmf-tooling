package common

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode

abstract class EditPolicyTemplate<T extends GenCommonBase> extends BaseClassTemplate<T> {

	def getComponentEditPolicyClassName(GenCommonBase it) { baseName + 'ComponentEditPolicy' }

	def getLayoutEditPolicyClassName(GenContainerBase it) { baseName + 'LayoutEditPolicy' }

	def getSideAffixedLayoutEditPolicyClassName(GenContainerBase it) { baseName + 'SideAffixedLayoutEditPolicy' }

	def getGraphicalNodeEditPolicyClassName(GenCommonBase it) { baseName + 'GraphicalNodeEditPolicy' }

	def getGraphicalNodeEditPolicyClassName(GenNode it) { graphicalNodeEditPolicyClassName }

	def getConnectionEndpointEditPolicyClassName(GenLink it) { baseName + 'EndpointEditPolicy' }

	abstract def CharSequence editPolicyName(T it)

	def getBaseName(GenCommonBase it) { 
		 if (editPartClassName.endsWith('EditPart')) 
		 	editPartClassName.substring(0, editPartClassName.length - 'EditPart'.length) 
		 else editPartClassName
	}

	override qualifiedClassName(T it) { diagram.editPoliciesPackageName + "." + editPolicyName }

	override generate(T it) '''
		package «getDiagram().editPoliciesPackageName»;

		«generatedClassComment»
		public class «editPolicyName» «supertypes» {
			«body»
		}
	'''

}