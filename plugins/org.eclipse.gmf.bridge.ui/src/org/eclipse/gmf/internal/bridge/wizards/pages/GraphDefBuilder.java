/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DecorationFigure;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.internal.bridge.resolver.Resolution;
import org.eclipse.gmf.internal.bridge.resolver.ResolvedItem;
import org.eclipse.gmf.internal.bridge.wizards.WizardUtil;
import org.eclipse.gmf.internal.common.IncrementalNamesDispenser;
import org.eclipse.gmf.internal.common.NamesDispenser;

/**
 * @author dstadnik
 */
public class GraphDefBuilder {

	protected GMFGraphPackage gmfGraphPackage = GMFGraphPackage.eINSTANCE;

	protected GMFGraphFactory gmfGraphFactory = gmfGraphPackage.getGMFGraphFactory();

	protected NamesDispenser namesDispenser = new IncrementalNamesDispenser();

	protected String getUniqueName(String semanticPart, String suffixPart) {
		return namesDispenser.get(semanticPart, suffixPart);
	}

	@SuppressWarnings("unchecked")
	public Canvas process(ResolvedItem item) {
		Canvas canvas = gmfGraphFactory.createCanvas();
		if (item != null) {
			EPackage ePackage = (EPackage) item.getDomainRef();
			canvas.setName(ePackage.getName());
			FigureGallery fGallery = gmfGraphFactory.createFigureGallery();
			fGallery.setName(Messages.GraphDefBuilder0);
			canvas.getFigures().add(fGallery);
			for (ResolvedItem child : item.getChildren()) {
				process(child, canvas, fGallery, null);
			}
		}
		return canvas;
	}

	protected void process(ResolvedItem item, Canvas canvas, FigureGallery fGallery, DiagramElement parent) {
		DiagramElement newParent = null;
		if (item.getDomainRef() instanceof EClass) {
			EClass type = (EClass) item.getDomainRef();
			if (item.getResolution() == Resolution.NODE) {
				newParent = createNode(type, fGallery, canvas);
			} else if (item.getResolution() == Resolution.LINK) {
				newParent = createLink(type, fGallery, canvas);
			}
		} else if (item.getDomainRef() instanceof EReference) {
			EReference ref = (EReference) item.getDomainRef();
			if (item.getResolution() == Resolution.LINK) {
				newParent = createLink(ref, fGallery, canvas);
			}
		} else if (item.getDomainRef() instanceof EAttribute) {
			EAttribute attr = (EAttribute) item.getDomainRef();
			if (item.getResolution() == Resolution.LABEL) {
				newParent = createLabel(attr, fGallery, canvas, parent);
			}
		}
		for (ResolvedItem next : item.getChildren()) {
			process(next, canvas, fGallery, newParent);
		}
	}

	@SuppressWarnings("unchecked")
	protected Node createNode(EClass type, FigureGallery fGallery, Canvas canvas) {
		String baseName = WizardUtil.getCapName(type);
		Rectangle figure = gmfGraphFactory.createRectangle();
		figure.setName(getUniqueName(baseName, Messages.GraphDefBuilder1));
		fGallery.getFigures().add(figure);
		Node node = gmfGraphFactory.createNode();
		node.setFigure(figure);
		node.setName(getUniqueName(baseName, null));
		canvas.getNodes().add(node);
		return node;
	}

	@SuppressWarnings("unchecked")
	protected Connection createLink(EClass type, FigureGallery fGallery, Canvas canvas) {
		String baseName = WizardUtil.getCapName(type);
		PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
		figure.setName(getUniqueName(baseName, Messages.GraphDefBuilder1));
		fGallery.getFigures().add(figure);
		Connection link = gmfGraphFactory.createConnection();
		link.setFigure(figure);
		link.setName(getUniqueName(baseName, null));
		canvas.getConnections().add(link);
		return link;
	}

	@SuppressWarnings("unchecked")
	protected Connection createLink(EReference ref, FigureGallery fGallery, Canvas canvas) {
		String baseName = WizardUtil.getCapName(ref);
		PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
		figure.setName(getUniqueName(baseName, Messages.GraphDefBuilder1));
		DecorationFigure decoration = gmfGraphFactory.createPolylineDecoration();
		decoration.setName(getUniqueName(baseName, Messages.GraphDefBuilder6));
		figure.setTargetDecoration(decoration);
		fGallery.getFigures().add(figure);
		fGallery.getFigures().add(decoration);
		Connection link = gmfGraphFactory.createConnection();
		link.setFigure(figure);
		link.setName(getUniqueName(baseName, null));
		canvas.getConnections().add(link);
		return link;
	}

	@SuppressWarnings("unchecked")
	protected DiagramLabel createLabel(EAttribute attr, FigureGallery fGallery, Canvas canvas, DiagramElement parent) {
		if (parent == null) {
			return null; // makes no sense to define label without parent
		}
		String baseName = WizardUtil.getCapName(attr);
		Label figure = gmfGraphFactory.createLabel();
		figure.setName(getUniqueName(baseName, Messages.GraphDefBuilder1));
		figure.setText(Messages.GraphDefBuilder5);
		assert parent.getFigure() instanceof Figure : "We are creators of this gmfgraph; there should be no figure accessors"; //$NON-NLS-1$
		((Figure) parent.getFigure()).getChildren().add(figure);
		DiagramLabel label = gmfGraphFactory.createDiagramLabel();
		label.setFigure(figure);
		label.setName(getUniqueName(baseName, null));
		canvas.getLabels().add(label);
		return label;
	}
}
