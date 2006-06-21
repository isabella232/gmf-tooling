/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.tests.setup;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Color;
import org.eclipse.gmf.gmfgraph.ColorConstants;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.ConnectionFigure;
import org.eclipse.gmf.gmfgraph.ConstantColor;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Label;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.Rectangle;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.setup.DomainModelSource.NodeData;

public class CompartmentsSessionSetup extends SessionSetup {
	protected CompartmentsSessionSetup() {
		//
	}

	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new CompartmentsSessionSetup();
	}
	
	protected DomainModelSource createDomainModel() {
		return new DomainSetupWithChildren().init();
	}
	
	protected DiaDefSource createGraphDefModel() {
		return new DiaDefSetupWithCompartments().init();
	}
	
	protected MapDefSource createMapModel() {
		MapDefSource mapDefSource = new MapSetupWithCompartments().init(getGraphDefModel(), getDomainModel(), new ToolDefSetup());
		assertCompartmentMapping(mapDefSource.getNodeA());
		assertCompartmentMapping(mapDefSource.getNodeB());
		return mapDefSource;
	}
	
	private void assertCompartmentMapping(NodeMapping nodeMapping){
		Assert.assertFalse(nodeMapping.getCompartments().isEmpty());
		for (Iterator compartments = nodeMapping.getCompartments().iterator(); compartments.hasNext();){
			CompartmentMapping next = (CompartmentMapping)compartments.next();
			Assert.assertSame(nodeMapping, next.getParentNode());
		}
	}
	
	protected DiaGenSource createGenModel() {
		DiaGenSource result = new DiaGenSetup().init(getMapModel());
		Assert.assertFalse(result.getNodeA().getCompartments().isEmpty());
		Assert.assertFalse(result.getNodeB().getCompartments().isEmpty());
		return result;
	}
	
	public DomainModelSourceExtension getDomainModelExtension() {
		return (DomainModelSourceExtension)getDomainModel();
	}
	
	public DiaDefSourceExtension getGraphDefModelExtension() {
		return (DiaDefSourceExtension)getGraphDefModel();
	}
	
	public static interface DiaDefSourceExtension extends DiaDefSource {
		/**
		 * @return compartment, hasTitle = true, collapsible = true
		 */
		public Compartment getCompartmentA();
		/**
		 * @return compartment, hasTitle = false, collapsible = false
		 */
		public Compartment getCompartmentB();
		
		/**
		 * @return node, foreground = red, background = blue
		 */
		public Node getColoredNode();
		
		/**
		 * @return connection, foreground = orange
		 */
		public Connection getColoredConnection();
		
		/**
		 * @return diagram label, font = "Arial", size = 18, bold
		 */
		public DiagramLabel getDecoratedDiagramLabel();
	}
	
	public static interface DomainModelSourceExtension extends DomainModelSource {
		public NodeData getChildOfA();
		public NodeData getChildOfB();
	}
	
	protected static class DiaDefSetupWithCompartments extends DiaDefSetup implements DiaDefSourceExtension {
		private Compartment myCollapsibleCompartmentWithTitle;
		private Compartment myCompartmentNoTitleNoCollapse;
		private Node myColoredNode;
		private Connection myColoredConnection;
		private DiagramLabel myDiagramLabelWithFont;
		
		public void setupCanvasDef(Canvas canvasDef) {
			FigureGallery oneMoreGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			canvasDef.getFigures().add(oneMoreGallery);
			Figure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
			compartmentFigure.setName("CompartmentFigure");
			oneMoreGallery.getFigures().add(compartmentFigure);
			myCollapsibleCompartmentWithTitle = createCompartment(compartmentFigure, "Compartment_Title_Collapse", true, true);
			canvasDef.getCompartments().add(myCollapsibleCompartmentWithTitle);
			
			myCompartmentNoTitleNoCollapse = createCompartment(compartmentFigure, "Compartment_NoTitle_No_Collapse", false, false);
			canvasDef.getCompartments().add(myCompartmentNoTitleNoCollapse);
			
			Rectangle colored = GMFGraphFactory.eINSTANCE.createRectangle();
			colored.setForegroundColor(createColor(ColorConstants.RED_LITERAL));
			colored.setBackgroundColor(createColor(ColorConstants.BLUE_LITERAL));
			colored.setName("ColoredRectangle");
			oneMoreGallery.getFigures().add(colored);
			myColoredNode = GMFGraphFactory.eINSTANCE.createNode();
			myColoredNode.setName("ColoredRectangleNode");
			myColoredNode.setFigure(colored);
			getCanvasDef().getNodes().add(myColoredNode);
			
			ConnectionFigure connectionLink = GMFGraphFactory.eINSTANCE.createPolylineConnection();
			connectionLink.setName("ColoredLink");
			connectionLink.setForegroundColor(createColor(ColorConstants.ORANGE_LITERAL));
			oneMoreGallery.getFigures().add(connectionLink);
			myColoredConnection = GMFGraphFactory.eINSTANCE.createConnection();
			myColoredConnection.setName("ColoredLinkConnection");
			myColoredConnection.setFigure(connectionLink);
			getCanvasDef().getConnections().add(myColoredConnection);
			
			Label label = GMFGraphFactory.eINSTANCE.createLabel();
			label.setName("LabelWithFont");
			label.setText("LabelText");
			BasicFont font = GMFGraphFactory.eINSTANCE.createBasicFont();
			font.setFaceName("Arial");
			font.setHeight(18);
			font.setStyle(FontStyle.BOLD_LITERAL);
			label.setFont(font);
			oneMoreGallery.getFigures().add(label);
			
			myDiagramLabelWithFont = GMFGraphFactory.eINSTANCE.createDiagramLabel();
			myDiagramLabelWithFont.setName("DiagramLabelWithFont");
			myDiagramLabelWithFont.setFigure(label);
			getCanvasDef().getLabels().add(myDiagramLabelWithFont);
		}
		
		protected void setupNodeDef(Node nodeDef) {
			Figure figure = (Figure)nodeDef.getFigure();
			figure.setLayout(GMFGraphFactory.eINSTANCE.createBorderLayout());
		}
		
		public Compartment getCompartmentA() {
			return myCollapsibleCompartmentWithTitle;
		}
		
		public Compartment getCompartmentB() {
			return myCompartmentNoTitleNoCollapse;
		}
		
		public Connection getColoredConnection() {
			return myColoredConnection;
		}
		
		public Node getColoredNode() {
			return myColoredNode;
		}
		
		public DiagramLabel getDecoratedDiagramLabel() {
			return myDiagramLabelWithFont;
		}
		
		private Compartment createCompartment(Figure figure, String name, boolean collapsible, boolean needsTitle){
			Compartment result = GMFGraphFactory.eINSTANCE.createCompartment();
			result.setFigure(figure);
			result.setName(name);
			result.setNeedsTitle(needsTitle);
			result.setCollapsible(collapsible);
			return result;
		}
		
		private Color createColor(ColorConstants color){
			ConstantColor result = GMFGraphFactory.eINSTANCE.createConstantColor();
			result.setValue(color);
			return result;
		}
	}
	
	protected static class DomainSetupWithChildren extends DomainModelSetup implements DomainModelSourceExtension {
		private NodeData myChildOfA;
		private NodeData myChildOfB;
		
		public DomainModelSetup init() {
			DomainModelSetup result = super.init();
			result.getModel().setName("ModelWithChildren");

			EClass childClass = EcoreFactory.eINSTANCE.createEClass();
			childClass.setName("Child");
			EAttribute childLabel = EcoreFactory.eINSTANCE.createEAttribute();
			childLabel.setName("childLabel");
			childLabel.setEType(EcorePackage.eINSTANCE.getEString());
			childClass.getEStructuralFeatures().add(childLabel);
			result.getModel().getEClassifiers().add(childClass);
			
			EReference containmentForA = EcoreFactory.eINSTANCE.createEReference();
			containmentForA.setContainment(true);
			containmentForA.setName("childrenOfA");
			containmentForA.setEType(childClass);
			containmentForA.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			result.getNodeA().getEClass().getEStructuralFeatures().add(containmentForA);
			
			EReference containmentForB = (EReference) EcoreUtil.copy(containmentForA);
			containmentForB.setName("childrenOfB");
			result.getNodeB().getEClass().getEStructuralFeatures().add(containmentForB);
			
			myChildOfA = new NodeData(childClass, childLabel, containmentForA);
			myChildOfB = new NodeData(childClass, childLabel, containmentForB);
			return result;
		}
		
		public NodeData getChildOfA() {
			return myChildOfA;
		}
		
		public NodeData getChildOfB(){
			return myChildOfB;
		}	
	}
	
	protected static class MapSetupWithCompartments extends MapSetup {
		public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
			Assert.assertTrue(domainSource instanceof DomainSetupWithChildren);
			Assert.assertTrue(ddSource instanceof DiaDefSetupWithCompartments);
			
			DomainSetupWithChildren domainWithChildren = (DomainSetupWithChildren)domainSource;
			DiaDefSetupWithCompartments diaDefSetupWithCompartments = (DiaDefSetupWithCompartments)ddSource;
			Assert.assertNotNull(diaDefSetupWithCompartments.getCompartmentA());
			Assert.assertNotNull(diaDefSetupWithCompartments.getCompartmentB());
			
			MapSetup result = super.init(ddSource, domainSource, toolDef);
			
			getNodeB().setDiagramNode(diaDefSetupWithCompartments.getColoredNode());
			getReferenceLink().setDiagramLink(diaDefSetupWithCompartments.getColoredConnection());
			
			setupReferenceAndCompartment(ddSource, diaDefSetupWithCompartments.getCompartmentA(), domainWithChildren.getChildOfA(), result.getNodeA());
			setupReferenceAndCompartment(ddSource, diaDefSetupWithCompartments.getCompartmentB(), domainWithChildren.getChildOfB(), result.getNodeB());
			
			Assert.assertFalse(getNodeB().getLabelMappings().isEmpty());
			for (Iterator labelsB = getNodeB().getLabelMappings().iterator(); labelsB.hasNext();){
				LabelMapping next = (LabelMapping)labelsB.next();
				next.setDiagramLabel(diaDefSetupWithCompartments.getDecoratedDiagramLabel());
			}

			return result;
		}
		
		private ChildReference setupReferenceAndCompartment(DiaDefSource ddSource, Compartment diagramCompartment, NodeData data, NodeMapping parentMapping){
			Node diagramNode = ddSource.getNodeDef();
			DiagramLabel diagramLabel = ddSource.getLabelDef(); 
			NodeMapping childMapping = createNodeMapping(diagramNode, data.getEClass(), diagramLabel, data.getNameAttr(), data.getContainment(), false);
			
			ChildReference childReference = GMFMapFactory.eINSTANCE.createChildReference();
			childReference.setOwnedChild(childMapping);
			childReference.setChildrenFeature(data.getContainment());
			childReference.setContainmentFeature(data.getContainment());
			parentMapping.getChildren().add(childReference);
			
			CompartmentMapping compartmentMapping = GMFMapFactory.eINSTANCE.createCompartmentMapping();
			compartmentMapping.setCompartment(diagramCompartment);
			compartmentMapping.getChildren().add(childReference);
			
			parentMapping.getCompartments().add(compartmentMapping);
			return childReference;
		}
	}
	
}
