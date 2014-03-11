package diagram

import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import commands.CommandUtils

class Helper {

	extension CommandUtils = new CommandUtils

	def isXYLayout(GenNode node) {
		node.layoutType == ViewmapLayoutType::XY_LAYOUT
	}

	def hasDirectChildren(GenNode node) {
		!node.getDirectChildren.empty
	}
	def dispatch Iterable<? extends GenNode> getDirectChildren(GenContainerBase it) {
		childNodes
	}
	def dispatch Iterable<? extends GenNode> getDirectChildren(GenNode it) {
		childNodes.filter[e | !(e instanceof GenChildSideAffixedNode)]
	}

	def dispatch needsXYLayout(GenContainerBase node) { false }
	def dispatch needsXYLayout(GenDiagram node) { true }
	def dispatch needsXYLayout(GenCompartment node) { !node.listLayout }
	def dispatch needsXYLayout(GenNode node) { node.hasDirectChildren && node.isXYLayout }
	def dispatch needsXYLayout(GenChildLabelNode node) { false }
	def dispatch needsXYLayout(GenContainerBase node, GenNode child) { node.needsXYLayout }
	def dispatch needsXYLayout(GenContainerBase node, GenChildSideAffixedNode child) { true }
	
	def Iterable<? extends GenNodeLabel> getExternalLabels(GenNode node) {
		node.labels.fold(newArrayList()) [list, e | switch e {
			GenExternalNodeLabel: list.add(e)
		} list]
	}

	def Iterable<? extends GenNode> getSideAffixedChildren(GenNode node) {
		node.childNodes.map[e | switch e {
			GenChildSideAffixedNode: e
		}]
	}
	def hasSideAffixedChildren(GenNode node) {
		!node.getSideAffixedChildren.empty
	}

}









