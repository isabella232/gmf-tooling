/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.LinkedList;

import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * FIXME lookup idea doesn't seem to apply well to obtain canvas elements for a mapping element, e.g. when we need to pick a Node
 * for a NodeMapping with few LabelMappings
 * @author artem
 */
public class GraphDefLookup {

	private final Canvas myCanvas;

	public GraphDefLookup(Canvas canvas) {
		myCanvas = canvas;
	}

	public Node findSuitableNode(NodeMapping nm) {
		if (myCanvas.getNodes().isEmpty()) {
			return null;
		}
		LinkedList<Node> candidateNodes = new LinkedList<Node>();
		if (nm.getDomainMetaElement() != null) {
			String name = nm.getDomainMetaElement().getName();
			for (Node n : myCanvas.getNodes()) {
				if (n.getName() != null && n.getName().indexOf(name) >= 0) {
					candidateNodes.add(n);
				}
			}
		}
		if (candidateNodes.isEmpty()) {
			candidateNodes.addAll(myCanvas.getNodes());
		}
		if (candidateNodes.size() == 1) {
			return candidateNodes.getFirst();
		}
		if (nm.getLabelMappings().isEmpty()) {
L1:			for (Node n : candidateNodes) {
				for (DiagramLabel dl : myCanvas.getLabels()) {
					if (n.getFigure().getAccessors().contains(dl.getAccessor())) {
						// one of node's accessors is referenced for a label, however, 
						// mapping being processed doesn't need any, hence go to next node
						continue L1;
					}
				}
				return n;
			}
		} else {
			Node candidateWithLessLabels= null, candidateWithMoreLabels = null;
			for (Node n : candidateNodes) {
				if (n.getFigure().getAccessors().size() >= nm.getLabelMappings().size()) {
					LinkedList<DiagramLabel> labels = collectAccessingLabels(n);
					if (labels.isEmpty()) {
						continue;
					}
					// perfect match, same number of labels as labelMappings
					if (labels.size() == nm.getLabelMappings().size()) {
						return n;
					}
					if (labels.size() > nm.getLabelMappings().size() && candidateWithMoreLabels == null) {
						candidateWithMoreLabels = n;
					}
					if (labels.size() < nm.getLabelMappings().size() && candidateWithLessLabels == null) {
						candidateWithLessLabels = n;
					}
				}
			}
			if (candidateWithMoreLabels != null) {
				return candidateWithMoreLabels;
			}
			if (candidateWithLessLabels != null && findFloatingLabel() != null) {
				// take the one with less labels *only* if there's spare descriptor for a floating label
				return candidateWithLessLabels;
			}
			// else - fall through, to get any
		}
		return candidateNodes.get(0); // take any
	}

	// canvas.labels->select(l | n.figure.accessors.contains(l))
	private LinkedList<DiagramLabel> collectAccessingLabels(Node n) {
		LinkedList<DiagramLabel> labels = new LinkedList<DiagramLabel>();
		for (DiagramLabel l : myCanvas.getLabels()) {
			if (l.getFigure() == n.getFigure() && n.getFigure().getAccessors().contains(l.getAccessor())) {
				labels.add(l);
			}
		}
		return labels;
	}
	
	private DiagramLabel findFloatingLabel() {
		for (DiagramLabel dl : myCanvas.getLabels()) {
			if (dl.getAccessor() != null) {
				continue; // XXX actually, not sure if a label can't use accessor, even if standalone
			}
			// XXX again, not sure if next check is reasonable, idea is to avoid labels that share a figure with some node
			for (Node n : myCanvas.getNodes()) {
				if (n.getFigure() == dl.getFigure()) {
					continue;
				}
			}
			return dl;
		}
		return null;
	}
	
	public void assignLabels(NodeMapping nm, Node n) {
		if (n == null || n.getFigure().getAccessors().isEmpty() || nm.getLabelMappings().isEmpty()) {
			return;
		}
		LinkedList<DiagramLabel> labels = collectAccessingLabels(n);
		for(int i = 0; i < nm.getLabelMappings().size(); i++) {
			DiagramLabel l = !labels.isEmpty() ? labels.removeFirst() : findFloatingLabel();
			nm.getLabelMappings().get(i++).setDiagramLabel(l);
		}
	}

	public Connection findSuitableLink(LinkMapping lm) {
		if (myCanvas.getConnections().isEmpty()) {
			return null;
		}
		String name = null;
		if (lm.getDomainMetaElement() != null) {
			name = lm.getDomainMetaElement().getName();
		} else if (lm.getLinkMetaFeature() != null) {
			name = lm.getLinkMetaFeature().getEContainingClass().getName();
		}
		for (Connection c : myCanvas.getConnections()) {
			if (c.getName() != null && c.getName().indexOf(name) >= 0) {
				return c;
			}
		}
		return myCanvas.getConnections().get(0);
	}

	public void assignLabels(LinkMapping lm, Connection c) {
		if (c == null || lm.getLabelMappings().isEmpty()) {
			return;
		}
		DiagramLabel floating = findFloatingLabel();
		for (int i = 0; i < lm.getLabelMappings().size(); i++) {
			lm.getLabelMappings().get(i).setDiagramLabel(floating);
		}
	}
}
