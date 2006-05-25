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

import junit.framework.Assert;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
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
		Assert.assertFalse(mapDefSource.getNodeA().getCompartments().isEmpty());
		CompartmentMapping compartmentMapping = (CompartmentMapping) mapDefSource.getNodeA().getCompartments().get(0);
		Assert.assertSame(mapDefSource.getNodeA(), compartmentMapping.getParentNode());
		return mapDefSource;
	}
	
	protected DiaGenSource createGenModel() {
		DiaGenSource result = new DiaGenSetup().init(getMapModel());
		Assert.assertFalse(result.getNodeA().getCompartments().isEmpty());
		return result;
	}
	
	public DomainModelSourceExtension getDomainModelExtension() {
		return (DomainModelSourceExtension)getDomainModel();
	}
	
	public DiaDefSourceExtension getGraphDefModelExtension() {
		return (DiaDefSourceExtension)getGraphDefModel();
	}
	
	public static interface DiaDefSourceExtension extends DiaDefSource {
		public Compartment getCompartment();
	}
	
	public static interface DomainModelSourceExtension extends DomainModelSource {
		public NodeData getChildOfA();
	}
	
	protected static class DiaDefSetupWithCompartments extends DiaDefSetup implements DiaDefSourceExtension {
		public void setupCanvasDef(Canvas canvasDef) {
			FigureGallery oneMoreGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			canvasDef.getFigures().add(oneMoreGallery);
			Figure compartmentFigure = GMFGraphFactory.eINSTANCE.createRectangle();
			oneMoreGallery.getFigures().add(compartmentFigure);
			Compartment compartment = createCompartment(compartmentFigure, "CompartmentA", true, true);
			canvasDef.getCompartments().add(compartment);
		}
		
		protected void setupNodeDef(Node nodeDef) {
			Figure figure = (Figure)nodeDef.getFigure();
			figure.setLayout(GMFGraphFactory.eINSTANCE.createBorderLayout());
		}
		
		public Compartment getCompartment(){
			return (Compartment)getCanvasDef().getCompartments().get(0);
		}

		private Compartment createCompartment(Figure figure, String name, boolean collapsible, boolean needsTitle){
			Compartment result = GMFGraphFactory.eINSTANCE.createCompartment();
			result.setCollapsible(true);
			result.setFigure(figure);
			result.setName(name);
			result.setNeedsTitle(needsTitle);
			return result;
		}

	}
	
	protected static class DomainSetupWithChildren extends DomainModelSetup implements DomainModelSourceExtension {
		private NodeData myChildOfA;
		
		public DomainModelSetup init() {
			DomainModelSetup result = super.init();
			result.getModel().setName("ModelWithChildren");

			EClass childClass = EcoreFactory.eINSTANCE.createEClass();
			childClass.setName("ChildOfA");
			EAttribute childLabel = EcoreFactory.eINSTANCE.createEAttribute();
			childLabel.setName("childLabel");
			childLabel.setEType(EcorePackage.eINSTANCE.getEString());
			childClass.getEStructuralFeatures().add(childLabel);
			result.getModel().getEClassifiers().add(childClass);
			
			EReference containment = EcoreFactory.eINSTANCE.createEReference();
			containment.setContainment(true);
			containment.setName("childrenOfA");
			containment.setEType(childClass);
			containment.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			result.getNodeA().getEClass().getEStructuralFeatures().add(containment);
			
			myChildOfA = new NodeData(childClass, childLabel, containment);
			return result;
		}
		
		public NodeData getChildOfA() {
			return myChildOfA;
		}
	}
	
	protected static class MapSetupWithCompartments extends MapSetup {
		public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
			Assert.assertTrue(domainSource instanceof DomainSetupWithChildren);
			Assert.assertTrue(ddSource instanceof DiaDefSetupWithCompartments);
			
			DomainSetupWithChildren domainWithChildren = (DomainSetupWithChildren)domainSource;
			DiaDefSetupWithCompartments diaDefSetupWithCompartments = (DiaDefSetupWithCompartments)ddSource;
			Assert.assertNotNull(diaDefSetupWithCompartments.getCompartment());
			
			MapSetup result = super.init(ddSource, domainSource, toolDef);
			
			NodeData childOfAData = domainWithChildren.getChildOfA();
			NodeMapping childOfAMapping = createNodeMapping(ddSource.getNodeDef(), childOfAData.getEClass(), ddSource.getLabelDef(), childOfAData.getNameAttr(), childOfAData.getContainment(), false);
			
			ChildReference childOfAReference = GMFMapFactory.eINSTANCE.createChildReference();
			childOfAReference.setOwnedChild(childOfAMapping);
			childOfAReference.setChildrenFeature(childOfAData.getContainment());
			childOfAReference.setContainmentFeature(childOfAData.getContainment());
			result.getNodeA().getChildren().add(childOfAReference);
			
			CompartmentMapping childOfACompartment = GMFMapFactory.eINSTANCE.createCompartmentMapping();
			childOfACompartment.setCompartment(diaDefSetupWithCompartments.getCompartment());
			childOfACompartment.getChildren().add(childOfAReference);
			result.getNodeA().getCompartments().add(childOfACompartment);

			return result;
		}
	}
	
}
