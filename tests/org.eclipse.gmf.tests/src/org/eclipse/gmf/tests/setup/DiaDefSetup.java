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

/**
 * This class is intended to be subclassed
 * It is allowed to override setup* methods to tweak setup for managed gmfgraph instances.
 */
public class DiaDefSetup implements DiaDefSource {
	private Canvas myCanvasDef;
	private Node myNodeDef;
	private Connection myLinkDef;
	private FigureGallery myFigureContainer;
	private DiagramLabel myLabelDef;

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
		
		commonSetupCanvasDef(myCanvasDef);
		commonSetupNodeDef(myNodeDef);
		commonSetupLinkDef(myLinkDef);
		commonSetupLabelDef(myLabelDef);
		
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

	private void commonSetupCanvasDef(Canvas canvasDef) {
		canvasDef.setName("Test-dd-canvas");
	}

	private void commonSetupNodeDef(Node nodeDef) {
		nodeDef.setName("Test-dd-node");
		nodeDef.setFigure(GMFGraphFactory.eINSTANCE.createRoundedRectangle());
		nodeDef.getNodeFigure().setName("nf1");
		myFigureContainer.getFigures().add(nodeDef.getFigure());
	}

	private void commonSetupLinkDef(Connection linkDef) {
		linkDef.setName("Test-dd-link");
		linkDef.setFigure(GMFGraphFactory.eINSTANCE.createPolylineConnection());
		linkDef.getConnectionFigure().setName("lf1");
		myFigureContainer.getFigures().add(linkDef.getFigure());
	}
	
	private void commonSetupLabelDef(DiagramLabel labelDef) {
		labelDef.setName("TestLabel");
		Label figure; 
		labelDef.setFigure(figure = GMFGraphFactory.eINSTANCE.createLabel());
		figure.setName("LabelFig");
		myFigureContainer.getFigures().add(labelDef.getFigure());
	}

	protected void setupCanvasDef(Canvas canvasDef) {
		//hook for subclasses
	}

	protected void setupNodeDef(Node nodeDef) {
		//hook for subclasses
	}

	protected void setupLinkDef(Connection linkDef) {
		//hook for subclasses
	}

	protected void setupLabelDef(DiagramLabel labelDef) {
		//hook for subclasses
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

}
