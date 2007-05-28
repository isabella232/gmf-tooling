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
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.PolylineConnection;
import org.eclipse.gmf.gmfgraph.Rectangle;

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
		labelFigure.setText("LabelText");
		label.setFigure(newDescriptor("LabelWithFont", labelFigure));
		BasicFont font = GMFGraphFactory.eINSTANCE.createBasicFont();
		font.setFaceName("Arial");
		font.setHeight(18);
		font.setStyle(FontStyle.BOLD_LITERAL);
		labelFigure.setFont(font);
		myFigureContainer.getDescriptors().add(label.getFigure());
	}

	private void commonSetupCompartmentA(Compartment compartment) {
		compartment.setName("Compartment_Title_Collapse");
		compartment.setNeedsTitle(true);
		compartment.setCollapsible(true);
		RealFigure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
		compartment.setFigure(newDescriptor("CompartmentFigureA", compartmentFigure));
		myFigureContainer.getDescriptors().add(compartment.getFigure());
	}

	private void commonSetupCompartmentB(Compartment compartment) {
		compartment.setName("Compartment_NoTitle_No_Collapse");
		compartment.setNeedsTitle(false);
		compartment.setCollapsible(false);
		RealFigure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
		compartment.setFigure(newDescriptor("CompartmentFigureB", compartmentFigure));
		myFigureContainer.getDescriptors().add(compartment.getFigure());
	}
	
	private void commonSetupColoredNodeDef(Node coloredNodeDef) {
		coloredNodeDef.setName("ColoredRectangleNode");
		final Rectangle rect = GMFGraphFactory.eINSTANCE.createRectangle();
		coloredNodeDef.setFigure(newDescriptor("ColoredRectangle", rect));
		rect.setForegroundColor(createColor(ColorConstants.RED_LITERAL));
		rect.setBackgroundColor(createColor(ColorConstants.BLUE_LITERAL));
		myFigureContainer.getDescriptors().add(coloredNodeDef.getFigure());
	}

	private void commonSetupColoredLinkDef(Connection coloredLinkDef) {
		coloredLinkDef.setName("ColoredLinkConnection");
		final PolylineConnection pc = GMFGraphFactory.eINSTANCE.createPolylineConnection();
		coloredLinkDef.setFigure(newDescriptor("ColoredLink", pc));
		pc.setForegroundColor(createColor(ColorConstants.ORANGE_LITERAL));
		myFigureContainer.getDescriptors().add(coloredLinkDef.getFigure());
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
		nodeDef.setFigure(newDescriptor("nf1", GMFGraphFactory.eINSTANCE.createRoundedRectangle()));
		myFigureContainer.getDescriptors().add(nodeDef.getFigure());
	}

	private void commonSetupLinkDef(Connection linkDef) {
		linkDef.setName("Test-dd-link");
		linkDef.setFigure(newDescriptor("lf1", GMFGraphFactory.eINSTANCE.createPolylineConnection()));
		myFigureContainer.getDescriptors().add(linkDef.getFigure());
	}
	
	private void commonSetupLabelDef(DiagramLabel labelDef) {
		labelDef.setName("TestLabel");
		Label figure= GMFGraphFactory.eINSTANCE.createLabel();
		labelDef.setFigure(newDescriptor("LabelFig", figure));
		myFigureContainer.getDescriptors().add(labelDef.getFigure());
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

	// XXX private hook???
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

	public static FigureDescriptor newDescriptor(String name, Figure fig) {
		assert name != null;
		FigureDescriptor fd = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
		fd.setActualFigure(fig);
		fd.setName(name);
		return fd;
	}
	public static FigureDescriptor newDescriptor(RealFigure fig) {
		return newDescriptor(fig.getName(), fig);
	}
	public static ChildAccess newAccess(FigureDescriptor fd, RealFigure child) {
		ChildAccess ca = GMFGraphFactory.eINSTANCE.createChildAccess();
		ca.setFigure(child);
		fd.getAccessors().add(ca);
		return ca;
	}
}
