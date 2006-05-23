/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;

public class DiaDefSetup implements DiaDefSource {
	private Canvas myCanvasDef;
	private Node myNodeDef;
	private Connection myLinkDef;
	private final Config myConfig;
	private FigureGallery myFigureContainer;
	private DiagramLabel myLabelDef;

	/**
	 * @param config could be <code>null</code>
	 */
	public DiaDefSetup(Config config) {
		myConfig = config;
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public final DiaDefSetup init() {
		myCanvasDef = GMFGraphFactory.eINSTANCE.createCanvas();
		myNodeDef = GMFGraphFactory.eINSTANCE.createNode();
		myLinkDef = GMFGraphFactory.eINSTANCE.createConnection();
		myLabelDef = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		myFigureContainer = GMFGraphFactory.eINSTANCE.createFigureGallery();
		myFigureContainer.setName("fc1");
		myCanvasDef.getFigures().add(myFigureContainer);
		myCanvasDef.getNodes().add(myNodeDef);
		myCanvasDef.getConnections().add(myLinkDef);
		myCanvasDef.getLabels().add(myLabelDef);
		setupCanvasDef(myCanvasDef);
		setupNodeDef(myNodeDef);
		setupLinkDef(myLinkDef);
		setupLabelDef(myLabelDef);
		confineInResource();
		return this;
	}

	private void confineInResource() {
		new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/GMFGraphSetup")).getContents().add(myCanvasDef);
	}

	protected void setupCanvasDef(Canvas canvasDef) {
		canvasDef.setName("Test-dd-canvas");
		if (myConfig != null) {
			myConfig.setupCanvasDef(canvasDef);
		}
	}

	protected void setupNodeDef(Node nodeDef) {
		nodeDef.setName("Test-dd-node");
		nodeDef.setFigure(GMFGraphFactory.eINSTANCE.createRoundedRectangle());
		nodeDef.getNodeFigure().setName("nf1");
		myFigureContainer.getFigures().add(nodeDef.getFigure());
		if (myConfig != null) {
			myConfig.setupNodeDef(nodeDef);
		}
	}

	protected void setupLinkDef(Connection linkDef) {
		linkDef.setName("Test-dd-link");
		linkDef.setFigure(GMFGraphFactory.eINSTANCE.createPolylineConnection());
		linkDef.getConnectionFigure().setName("lf1");
		myFigureContainer.getFigures().add(linkDef.getFigure());
		if (myConfig != null) {
			myConfig.setupLinkDef(linkDef);
		}
	}
	protected void setupLabelDef(DiagramLabel labelDef) {
		labelDef.setName("TestLabel");
		Label figure; 
		labelDef.setFigure(figure = GMFGraphFactory.eINSTANCE.createLabel());
		figure.setName("LabelFig");
		myFigureContainer.getFigures().add(labelDef.getFigure());
	}

	public final Canvas getCanvasDef() {
		return myCanvasDef;
	}

	public final Connection getLinkDef() {
		return myLinkDef;
	}

	public final Node getNodeDef() {
		return myNodeDef;
	}

	public final DiagramLabel getLabelDef() {
		return myLabelDef;
	}

	public final FigureGallery getFigureContainer() {
		return myFigureContainer;
	}

	public interface Config {
		void setupCanvasDef(Canvas canvasDef);
		void setupNodeDef(Node nodeDef);
		void setupLinkDef(Connection linkDef);
	}
}
