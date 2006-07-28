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
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FontStyle;
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
	private Connection myColoredLinkDef;
	private Node myColoredNodeDef;
	private Compartment myCompartmentA;
	private Compartment myCompartmentB;
	private DiagramLabel myDecoratedLabelDef;

	/**
	 * @return <code>this</code> for convenience
	 */
	public final DiaDefSetup init() {
		myCanvasDef = GMFGraphFactory.eINSTANCE.createCanvas();
		myNodeDef = GMFGraphFactory.eINSTANCE.createNode();
		myLinkDef = GMFGraphFactory.eINSTANCE.createConnection();
		myLabelDef = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		myFigureContainer = GMFGraphFactory.eINSTANCE.createFigureGallery();
		myColoredLinkDef = GMFGraphFactory.eINSTANCE.createConnection();
		myColoredNodeDef = GMFGraphFactory.eINSTANCE.createNode();
		myCompartmentA = GMFGraphFactory.eINSTANCE.createCompartment();
		myCompartmentB = GMFGraphFactory.eINSTANCE.createCompartment();
		myDecoratedLabelDef = GMFGraphFactory.eINSTANCE.createDiagramLabel();
		myFigureContainer.setName("fc1");
		myCanvasDef.getFigures().add(myFigureContainer);
		myCanvasDef.getNodes().add(myNodeDef);
		myCanvasDef.getConnections().add(myLinkDef);
		myCanvasDef.getLabels().add(myLabelDef);
		myCanvasDef.getConnections().add(myColoredLinkDef);
		myCanvasDef.getNodes().add(myColoredNodeDef);
		myCanvasDef.getCompartments().add(myCompartmentA);
		myCanvasDef.getCompartments().add(myCompartmentB);
		myCanvasDef.getLabels().add(myDecoratedLabelDef);
		
		commonSetupCanvasDef(myCanvasDef);
		commonSetupNodeDef(myNodeDef);
		commonSetupLinkDef(myLinkDef);
		commonSetupLabelDef(myLabelDef);
		commonSetupColoredLinkDef(myColoredLinkDef);
		commonSetupColoredNodeDef(myColoredNodeDef);
		commonSetupCompartmentA(myCompartmentA);
		commonSetupCompartmentB(myCompartmentB);
		commonSetupDecoratedLabelDef(myDecoratedLabelDef);
		
		setupCanvasDef(myCanvasDef);
		setupNodeDef(myNodeDef);
		setupLinkDef(myLinkDef);
		setupLabelDef(myLabelDef);
		setupColoredLinkDef(myColoredLinkDef);
		setupColoredNodeDef(myColoredNodeDef);
		setupCompartmentA(myCompartmentA);
		setupCompartmentB(myCompartmentB);
		setupDecoratedLabelDef(myDecoratedLabelDef);
		
		confineInResource();
		return this;
	}

	private void commonSetupDecoratedLabelDef(DiagramLabel label) {
		label.setName("DiagramLabelWithFont");
		Label labelFigure = GMFGraphFactory.eINSTANCE.createLabel();
		label.setFigure(labelFigure);
		labelFigure.setName("LabelWithFont");
		labelFigure.setText("LabelText");
		BasicFont font = GMFGraphFactory.eINSTANCE.createBasicFont();
		font.setFaceName("Arial");
		font.setHeight(18);
		font.setStyle(FontStyle.BOLD_LITERAL);
		labelFigure.setFont(font);
		myFigureContainer.getFigures().add(labelFigure);
	}

	private void commonSetupCompartmentA(Compartment compartment) {
		compartment.setName("Compartment_Title_Collapse");
		compartment.setNeedsTitle(true);
		compartment.setCollapsible(true);
		Figure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
		compartmentFigure.setName("CompartmentFigureA");
		myFigureContainer.getFigures().add(compartmentFigure);
		compartment.setFigure(compartmentFigure);
	}

	private void commonSetupCompartmentB(Compartment compartment) {
		compartment.setName("Compartment_NoTitle_No_Collapse");
		compartment.setNeedsTitle(false);
		compartment.setCollapsible(false);
		Figure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
		compartmentFigure.setName("CompartmentFigureB");
		myFigureContainer.getFigures().add(compartmentFigure);
		compartment.setFigure(compartmentFigure);
	}
	
	private void commonSetupColoredNodeDef(Node coloredNodeDef) {
		coloredNodeDef.setName("ColoredRectangleNode");
		coloredNodeDef.setFigure(GMFGraphFactory.eINSTANCE.createRectangle());
		coloredNodeDef.getNodeFigure().setForegroundColor(createColor(ColorConstants.RED_LITERAL));
		coloredNodeDef.getNodeFigure().setBackgroundColor(createColor(ColorConstants.BLUE_LITERAL));
		coloredNodeDef.getNodeFigure().setName("ColoredRectangle");
		myFigureContainer.getFigures().add(coloredNodeDef.getNodeFigure());
	}

	private void commonSetupColoredLinkDef(Connection coloredLinkDef) {
		coloredLinkDef.setName("ColoredLinkConnection");
		coloredLinkDef.setFigure(GMFGraphFactory.eINSTANCE.createPolylineConnection());
		coloredLinkDef.getConnectionFigure().setName("ColoredLink");
		coloredLinkDef.getConnectionFigure().setForegroundColor(createColor(ColorConstants.ORANGE_LITERAL));
		myFigureContainer.getFigures().add(coloredLinkDef.getConnectionFigure());
	}
	
	private Color createColor(ColorConstants color){
		ConstantColor result = GMFGraphFactory.eINSTANCE.createConstantColor();
		result.setValue(color);
		return result;
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

	public void setupColoredLinkDef(Connection myColoredLinkDef2) {
		//hook for subclasses
	}
	
	public void setupColoredNodeDef(Node myColoredNodeDef2) {
		//hook for subclasses
	}
	
	private void setupCompartmentA(Compartment compartment) {
		//hook for subclasses
	}

	private void setupCompartmentB(Compartment compartment) {
		//hook for subclasses
	}
	
	private void setupDecoratedLabelDef(DiagramLabel myDecoratedLabelDef2) {
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


	public Connection getColoredLinkDef() {
		return myColoredLinkDef;
	}

	public Node getColoredNodeDef() {
		return myColoredNodeDef;
	}

	public Compartment getCompartmentA() {
		return myCompartmentA;
	}

	public Compartment getCompartmentB() {
		return myCompartmentB;
	}


	public DiagramLabel getDecoratedLabelDef() {
		return myDecoratedLabelDef;
	}

}
