package diagram.policies

import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink

class PolicyCommon {

	def dispatch getViewCode(GenCommonBase it) { throw new IllegalStateException('Unexpected type') }

	def dispatch getViewCode(GenDiagram it) '''(org.eclipse.gmf.runtime.notation.Diagram) getHost().getModel()'''

	def dispatch getViewCode(GenChildContainer it) '''(org.eclipse.gmf.runtime.notation.Node) getHost().getModel()'''

	def dispatch getViewCode(GenLink it) '''(org.eclipse.gmf.runtime.notation.Edge) getHost().getModel()'''

	def dispatch getDiagramCode(GenCommonBase it) { throw new IllegalStateException('Unexpected type') }

	def dispatch getDiagramCode(GenDiagram it) '''«getViewCode»'''

	def dispatch getDiagramCode(GenChildContainer it) '''(«getViewCode»).getDiagram()'''

	def dispatch getDiagramCode(GenLink it) '''«getViewCode».getDiagram()'''

	def dispatch getDiagramElementCode(GenCommonBase it) '''«getDiagramCode».getElement()'''

	def dispatch getDiagramElementCode(GenDiagram it) '''(«getDiagramCode»).getElement()'''

	def getCastToEditPart(GenChildContainer it) '''(«getEditPartQualifiedClassName()») getHost()'''

}
