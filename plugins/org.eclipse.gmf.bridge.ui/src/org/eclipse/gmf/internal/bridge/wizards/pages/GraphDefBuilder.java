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

import java.util.Iterator;

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

/**
 * @author dstadnik
 */
public class GraphDefBuilder {

	protected GMFGraphPackage gmfGraphPackage = GMFGraphPackage.eINSTANCE;

	protected GMFGraphFactory gmfGraphFactory = gmfGraphPackage.getGMFGraphFactory();

	public Canvas process(ResolvedItem item) {
		Canvas canvas = gmfGraphFactory.createCanvas();
		if (item != null) {
			EPackage ePackage = (EPackage) item.getDomainRef();
			canvas.setName(ePackage.getName());
			FigureGallery fGallery = gmfGraphFactory.createFigureGallery();
			fGallery.setName("default");
			canvas.getFigures().add(fGallery);
			for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
				process((ResolvedItem) it.next(), canvas, fGallery, null);
			}
		}
		return canvas;
	}

	protected void process(ResolvedItem item, Canvas canvas, FigureGallery fGallery, DiagramElement parent) {
		boolean descend = false;
		DiagramElement newParent = null;
		if (item.getDomainRef() instanceof EClass) {
			EClass type = (EClass) item.getDomainRef();
			String baseName = type.getName();
			if (item.getResolution() == Resolution.NODE) {
				Rectangle figure = gmfGraphFactory.createRectangle();
				figure.setName(baseName + "Figure");
				fGallery.getFigures().add(figure);
				Node dElement = gmfGraphFactory.createNode();
				dElement.setFigure(figure);
				dElement.setName(baseName + "Node");
				canvas.getNodes().add(dElement);
				descend = true;
				newParent = dElement;
			} else if (item.getResolution() == Resolution.LINK) {
				PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
				figure.setName(baseName + "Figure");
				fGallery.getFigures().add(figure);
				Connection dElement = gmfGraphFactory.createConnection();
				dElement.setFigure(figure);
				dElement.setName(baseName + "Link");
				canvas.getConnections().add(dElement);
				descend = true;
				newParent = dElement;
			}
		} else if (item.getDomainRef() instanceof EReference) {
			EReference ref = (EReference) item.getDomainRef();
			String baseName = WizardUtil.getCapName(ref);
			if (item.getResolution() == Resolution.LINK) {
				PolylineConnection figure = gmfGraphFactory.createPolylineConnection();
				figure.setName(baseName + "Figure");
				DecorationFigure decoration = gmfGraphFactory.createPolylineDecoration();
				decoration.setName(baseName + "TargetDecoration");
				figure.setTargetDecoration(decoration);
				fGallery.getFigures().add(figure);
				fGallery.getFigures().add(decoration);
				Connection dElement = gmfGraphFactory.createConnection();
				dElement.setFigure(figure);
				dElement.setName(baseName + "Link");
				canvas.getConnections().add(dElement);
				descend = true;
				newParent = dElement;
			}
		} else if (item.getDomainRef() instanceof EAttribute) {
			EAttribute attr = (EAttribute) item.getDomainRef();
			String baseName = WizardUtil.getCapName(attr);
			if (item.getResolution() == Resolution.LABEL) {
				Label figure = gmfGraphFactory.createLabel();
				figure.setName(baseName + "Figure");
				figure.setText("<...>");
				// we are creators of this gmfgraph, assume no figure accessors get into it
				assert parent.getFigure() instanceof Figure;
				((Figure) parent.getFigure()).getChildren().add(figure);
				DiagramLabel dElement = gmfGraphFactory.createDiagramLabel();
				dElement.setFigure(figure);
				dElement.setName(baseName + "Label");
				canvas.getLabels().add(dElement);
				descend = true;
				newParent = dElement;
			}
		}
		if (descend) {
			for (Iterator it = item.getChildren().iterator(); it.hasNext();) {
				process((ResolvedItem) it.next(), canvas, fGallery, newParent);
			}
		}
	}
}
