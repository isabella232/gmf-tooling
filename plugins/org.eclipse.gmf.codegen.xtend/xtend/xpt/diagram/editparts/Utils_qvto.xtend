/**
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.editparts;

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType
import org.eclipse.gmf.gmfgraph.Compartment
import org.eclipse.gmf.gmfgraph.DiagramElement
import org.eclipse.gmf.gmfgraph.DiagramLabel
import xpt.Common_qvto

public class Utils_qvto {
	@Inject extension Common_qvto

	private def <T extends DiagramElement> modeledDiagramElement(GenCommonBase gc, Class<? extends T> clazz) {
		val viewmap = gc.viewmap;
		switch (viewmap) {
			ModeledViewmap case viewmap.figureModel.oclIsKindOf(clazz): return viewmap.figureModel
			default: return null
		}
	}

	private def DiagramLabel modeledDiagramLabel(GenCommonBase gc) {
		return modeledDiagramElement(gc, typeof(DiagramLabel)) as DiagramLabel
	}

	private def Compartment modeledCompartment(GenCommonBase gc) {
		return modeledDiagramElement(gc, typeof(Compartment)) as Compartment
	}

	def boolean isStoringChildPositions(GenNode node) {
		node.getLayoutType() == ViewmapLayoutType::XY_LAYOUT
	}

	def Iterable<GenExternalNodeLabel> getExternalLabels(GenNode node) {
		node.labels.filter(typeof(GenExternalNodeLabel))
	}

	def Iterable<GenChildSideAffixedNode> getSideAffixedChildren(GenNode node) {
		return node.childNodes.filter(typeof(GenChildSideAffixedNode));
	}

	private def Iterable<? extends GenLabel> getInnerLabels(GenNode node) {
		return node.labels.filter[i|!oclIsKindOf(i, typeof(GenExternalNodeLabel))];
	}

	def Iterable<? extends GenLabel> getInnerFixedLabels(GenNode node) {
		val innerLabels = getInnerLabels(node);
		return innerLabels.filter[e|e.viewmap.oclIsKindOf(typeof(ParentAssignedViewmap))];
	}

	def Iterable<? extends GenLabel> getInnerFixedLabelsWithModeledViewmaps(GenNode node) {
		val innerLabels = getInnerLabels(node);
		return innerLabels.filter[e| //
			modeledDiagramLabel(e) != null && //
			modeledDiagramLabel(e).accessor != null];
	}

	def Iterable<GenCompartment> getPinnedCompartments(GenNode node) {
		return node.compartments.filter[e|e.viewmap.oclIsKindOf(typeof(ParentAssignedViewmap))]
	}

	def Iterable<GenCompartment> getPinnedCompartmentsWithModeledViewmaps(GenNode node) {
		return node.compartments.filter[c| //
			modeledCompartment(c) != null && // 
			modeledCompartment(c).accessor != null]
	}

	def boolean hasFixedChildren(GenNode node) {
		return //
		getInnerFixedLabels(node).size > 0 || // 
		getPinnedCompartments(node).size > 0 || //
		getInnerFixedLabelsWithModeledViewmaps(node).size > 0 || //
			getPinnedCompartmentsWithModeledViewmaps(node).size > 0 //
		;
	}

	def boolean listCompartmentHasChildren(GenCompartment compartment) {
		return compartment.listLayout && compartment.childNodes.size > 0
	}

	def boolean hasChildrenInListCompartments(GenNode node) {
		return node.compartments.exists[e|listCompartmentHasChildren(e)]
	}

	def boolean hasBorderItems(GenNode node) {
		return getSideAffixedChildren(node).size > 0 || getExternalLabels(node).size > 0
	}

	def boolean needsGraphicalNodeEditPolicy(GenNode node) {
		return node.modelFacet != null && node.reorientedIncomingLinks.size > 0
	}

	def boolean shouldGenerateDiagramViewmap(GenDiagram genDiagram) {
		val typesWithoutViewmaps = newHashSet(ViewmapLayoutType::UNKNOWN_LITERAL, ViewmapLayoutType::XY_LAYOUT_LITERAL);
		return !typesWithoutViewmaps.contains(genDiagram.viewmap.layoutType)
	}

	def Iterable<GenLink> getAssistantOutgoingLinks(GenNode node) {
		return node.genOutgoingLinks.filter [ link |
			link.targets.exists(t|t.oclIsKindOf(typeof(GenNode)))
		]
	}

	def Iterable<GenLink> getAssistantIncomingLinks(GenNode node) {
		return node.genIncomingLinks.filter [ link |
			link.sources.exists(s|s.oclIsKindOf(typeof(GenNode)))
		]
	}

	def Iterable<GenNode> selectGenNodes(Iterable<GenLinkEnd> ends) {
		return ends.filter(typeof(GenNode))
	}

}
