package commands

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenNode

class CommandUtils {

	def dispatch getChildNodes(GenContainerBase it) { null }

	def dispatch getChildNodes(GenDiagram it) { topLevelNodes }
	
	def dispatch getChildNodes(GenChildContainer it) { childNodes }
	
	def getRelatedGenNodes(GenNode it) { getRelatedGenNodes(diagram, domainMetaClass) }

	def getRelatedGenNodes(GenDiagram diagram, GenClass nodeClass) {
		diagram.getAllNodes().filter(e | nodeClass.eClass.isSuperTypeOf(e.getDomainMetaClass.eClass))
	}

	def getRelatedChildLabelGenNodes(GenDiagram diagram, GenClass nodeClass) {
		getRelatedGenNodes(diagram, nodeClass).filter(typeof(GenChildLabelNode))
	}

	def getCreateShortcutNodeCommandClassName(GenDiagram diagram) { 'CreateShortcutNodeCommand' }
	
	def getCreateShortcutNodeCommandQualifiedClassName(GenDiagram diagram) {
		diagram.editCommandsPackageName + '.' + getCreateShortcutNodeCommandClassName(diagram)
	}
	
	def getCreateShortcutEdgeCommandClassName(GenDiagram diagram) { 'CreateShortcutEdgeCommand' }
	
	def getCreateShortcutEdgeCommandQualifiedClassName(GenDiagram diagram) {
		diagram.editCommandsPackageName + '.' + getCreateShortcutEdgeCommandClassName(diagram)
	}
}