/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Borland - initial API and implementation
 */
package org.eclipse.gmf.internal.graphdef.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.DiagramElement;
import org.eclipse.gmf.gmfgraph.DiagramLabel;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.FigureDescriptor;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.gmfgraph.RealFigure;
import org.eclipse.gmf.internal.common.migrate.MigrationDelegateImpl;

class MigrationDelegate extends MigrationDelegateImpl {
	private EReference myDiagramElement_RefFigures;
	private EReference myFigure_RefElements;
	
	private EReference myNode_NodeFigureRef;
	private EReference myConnection_FigureRef;
	private EReference myDiagramLabel_NodeFigureRef;
	private EAttribute myFigureNameAttribute;
	private FigureGallery myDefaultCreatedFigureGallery;
	
	MigrationDelegate() {
	}

	void init() {
		
		// narrowing for reference FigureAccessor.typedFigure: (the only place where concrete CustomFigure was used)
		registerNarrowedAbstractType("RealFigure", GMFGraphPackage.eINSTANCE.getCustomFigure());
		
		registerDeletedAttributes(GMFGraphPackage.eINSTANCE.getCustomClass(), "bundleName");
		registerDeletedAttributes(GMFGraphPackage.eINSTANCE.getDiagramLabel(), "resizeConstraint", "affixedParentSide");
		registerDeletedAttributes(GMFGraphPackage.eINSTANCE.getFigure(), "parent"); // not needed: readonly !resolve ref.
		
		myFigure_RefElements = createNewReference("referencingElements1", GMFGraphPackage.eINSTANCE.getDiagramElement(), false);
		registerRenamedParentAttribute(GMFGraphPackage.eINSTANCE.getFigure(), "referencingElements", myFigure_RefElements);
		
		myDiagramElement_RefFigures = createNewReference("figure1", GMFGraphPackage.eINSTANCE.getFigure(), false, 1, 1);
		registerRenamedParentAttribute(GMFGraphPackage.eINSTANCE.getDiagramElement(), "figure", myDiagramElement_RefFigures);
		
		//readonly derived transient volatile !resolve ref
		// in fact, DiagramLabel which extends Node breaks this constraint, just because DL SHOULD NOT extend Node, but rather some common AbstractNode superclass.
		myNode_NodeFigureRef = createNewReference("nodeFigure1", GMFGraphPackage.eINSTANCE.getFigure(), false);
		// move as content pane childAccess reference!
		{
			Map<String, EStructuralFeature> renamedAttributes = new HashMap<String, EStructuralFeature>();
			renamedAttributes.put("nodeFigure", myNode_NodeFigureRef);
			registerRenamedAttributes(GMFGraphPackage.eINSTANCE.getNode(), renamedAttributes);
		}
		
		//readonly derived transient volatile !resolve ref
		// doesn't follow Figure[1] nodeFigure from superclass Node because DL is not essentially Node
		myDiagramLabel_NodeFigureRef = createNewReference("nodeFigure2", GMFGraphPackage.eINSTANCE.getFigure(), false);
		// move as label, container childAccess references!
		{
			Map<String, EStructuralFeature> renamedAttributes = new HashMap<String, EStructuralFeature>();
			renamedAttributes.put("nodeFigure", myDiagramLabel_NodeFigureRef);
			registerRenamedAttributes(GMFGraphPackage.eINSTANCE.getDiagramLabel(), renamedAttributes);
		}
		
		//readonly derived transient volatile !resolve ref 
		myConnection_FigureRef = createNewReference("connectionFigure1", GMFGraphPackage.eINSTANCE.getFigure(), false);
		// this reference was removed!!!
		{
			Map<String, EStructuralFeature> renamedAttributes = new HashMap<String, EStructuralFeature>();
			renamedAttributes.put("connectionFigure", myConnection_FigureRef);
			registerRenamedAttributes(GMFGraphPackage.eINSTANCE.getConnection(), renamedAttributes);
		}
		
		myFigureNameAttribute = createNewAttribute("name1", EcorePackage.eINSTANCE.getEString(), false, true);
		//myFigureNameAttribute.setID(true);
		//registerRenamedParentAttribute(GMFGraphPackage.eINSTANCE.getFigure(), "name", myFigureNameAttribute);
		
		myDefaultCreatedFigureGallery = null;
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (myFigure_RefElements.equals(feature)) {
			Figure figure = (Figure) object; // can be FigureRef as well
			RealFigure topLevel = findTopLevelFigure(figure);
			FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
			DiagramElement node = (DiagramElement) value;
			if (figure instanceof RealFigure) {
				saveIdentityNameAttributeForId(figureDescriptor, ((RealFigure) figure).getName());
			}
			setDiagramElementFigureDescriptorReference(node, figureDescriptor);
			if (!figure.equals(topLevel)) {
				saveChildAccess(figureDescriptor, figure);
			}
			fireMigrationApplied(true);
		} else if (myDiagramElement_RefFigures.equals(feature)) {
//			DiagramElement node = (DiagramElement) object;
//			Figure figure = (Figure) value; // can be FigureRef as well
//			RealFigure topLevel = findTopLevelFigure(figure);
//			FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
//			setDiagramElementFigureDescriptorReference(node, figureDescriptor);
//			if (!figure.equals(topLevel)) {
//				saveChildAccess(figureDescriptor, figure);
//			}
//			fireMigrationApplied(true);
		} else if (myNode_NodeFigureRef.equals(feature)) {
			Node node = (Node) object;
			Figure figure = (Figure) value; // should cast to FigureImpl actually!!
			RealFigure topLevel = findTopLevelFigure(figure);
			if (figure.equals(topLevel)) {
				System.out.println("[MigrationDelegate] setValue: unnecessary refinement for "+figure);
			} else {
				FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
				setDiagramElementFigureDescriptorReference(node, figureDescriptor);
				ChildAccess childAccess = saveChildAccess(figureDescriptor, figure);
				saveFigureAccessForContentPane(node, childAccess);
			}
			fireMigrationApplied(true);
//		} else if (myDiagramLabel_NodeFigureRef.equals(feature)) {
//			DiagramLabel label = (DiagramLabel) object;
//			Figure figure = (Figure) value; // should cast to FigureImpl actually!!
//			RealFigure topLevel = findTopLevelFigure(figure);
//			if (figure.equals(topLevel)) {
//				System.out.println("[MigrationDelegate] setValue: unnecessary refinement for "+figure);
//			} else {
//				FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
//				setDiagramElementFigureDescriptorReference(label, figureDescriptor);
//				ChildAccess childAccess = saveChildAccess(figureDescriptor, figure);
//				saveFigureAccessForLabel(label, childAccess);
//			}
//			fireMigrationApplied(true);
//		} else if (myConnection_FigureRef.equals(feature)) {
//			Connection connection = (Connection) object;
//			Figure figure = (Figure) value; // should cast to FigureImpl actually!!
//			RealFigure topLevel = findTopLevelFigure(figure);
//			if (figure.equals(topLevel)) {
//				System.out.println("[MigrationDelegate] setValue: unnecessary refinement for "+figure);
//			} else {
//				FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
//				setDiagramElementFigureDescriptorReference(connection, figureDescriptor);
//				ChildAccess childAccess = saveChildAccess(figureDescriptor, figure);
//				saveFigureAccessForConnection(connection, childAccess);
//			}
//			fireMigrationApplied(true);
		} else if (myFigureNameAttribute.equals(feature)) {
			Figure figure = (Figure) object;
			String name = (String) value;
			//saveIdentityNameAttributeForId(figure, name);
			//fireMigrationApplied(true);
			return super.setValue(object, feature, value, position);
		} else {
			// other cases are would be processed as defaults
			return super.setValue(object, feature, value, position);
		}
		return true;
	}

	private void saveIdentityNameAttributeForId(EObject figure, String name) {
		Resource resource = getResource();
		if (resource instanceof ResourceImpl) {
			ResourceImpl resourceImpl = (ResourceImpl) resource;
			Map<String, EObject> idMap = resourceImpl.getIntrinsicIDToEObjectMap();
			if (idMap == null) {
				idMap = new HashMap<String, EObject>();
				resourceImpl.setIntrinsicIDToEObjectMap(idMap);
			}
			idMap.put(name, figure);
		}
		if (resource != null) {
			XMLResource xmlResource = (XMLResource) resource;
			resource.getEObject(name);
			String haveID = xmlResource.getID(figure);
			if (haveID == null || !haveID.equals(name)) {
				xmlResource.setID(figure, name);
			}
		}
	}

	private void setDiagramElementFigureDescriptorReference(DiagramElement node, FigureDescriptor figureDescriptor) {
		FigureDescriptor descriptor = node.getFigure();//getDiagramElementDescriptor().get(node);
		if (descriptor == null || descriptor.equals(figureDescriptor)) {
			//getDiagramElementDescriptor().put(node, figureDescriptor);
			node.setFigure(figureDescriptor);
		} else {
			System.out.println("[MigrationDelegate] setDiagramElementFigureDescriptorReference: double reference for: "+descriptor);
		}
	}

	private RealFigure findTopLevelFigure(Figure figure) {
		RealFigure result = figure instanceof RealFigure ? (RealFigure) figure : null;
		while (result.eContainer() instanceof RealFigure) { // FigureImpl, actually! (may be FigureGallery of null?)
			result = (RealFigure) result.eContainer();
		}
		return result;
	}

	private ChildAccess saveChildAccess(FigureDescriptor figureDescriptor, Figure figure) {
		ChildAccess access = null;
		for (ChildAccess haveAccess : figureDescriptor.getAccessors()) {
			if (haveAccess.getFigure().equals(figure)) {
				access = haveAccess;
			}
		}
		if (access == null) {
			access = GMFGraphFactory.eINSTANCE.createChildAccess();
			access.setFigure(figure);
			figureDescriptor.getAccessors().add(access);
		}
		return access;
	}
	
	private void saveNodeReference(DiagramElement node, ChildAccess figureAccess) {
		if (node instanceof DiagramLabel) {
			DiagramLabel label = (DiagramLabel) node;
			saveFigureAccessForLabel(label, figureAccess);
		} else if (node instanceof Node) {
			Node otherNode = (Node) node;
			saveFigureAccessForContentPane(otherNode, figureAccess);
		} else {
			System.out.println("[MigrationDelegate] saveNodeReference wrong figure referenced for connection and compartment!!!"+figureAccess);
		}
	}

	private void saveFigureAccessForContentPane(Node otherNode, ChildAccess figureAccess) {
//		if (myDiagramNodeContentPaneAccess == null) {
//			myDiagramNodeContentPaneAccess = new HashMap<Node, ChildAccess>();
//		}
		ChildAccess haveAccess = otherNode.getContentPane();//myDiagramNodeContentPaneAccess.get(otherNode);
		if (haveAccess != null && !haveAccess.equals(figureAccess)) {
			System.out.println("[MigrationDelegate] saveFigureAccessForContentPane(Node): collision between label figure references!!! "+haveAccess);
		}
		otherNode.setContentPane(figureAccess);
		//myDiagramNodeContentPaneAccess.put(otherNode, figureAccess);
	}

	private void saveFigureAccessForConnection(Connection connection, ChildAccess figureAccess) {
		System.out.println("Collision!!! [MigrationDelegate] saveFigureAccessForContentPane: "+connection);
	}

	private void saveFigureAccessForCompartment(Compartment compartment, ChildAccess figureAccess) {
		System.out.println("Collision!!! [MigrationDelegate] saveFigureAccessForContentPane: "+compartment);
	}

	private void saveFigureAccessForLabel(DiagramLabel label, ChildAccess figureAccess) {
		ChildAccess haveAccess = label.getAccessor();//myDiagramLabelFigureAccess.get(label);
		if (haveAccess != null && !haveAccess.equals(figureAccess)) {
			System.out.println("[MigrationDelegate] saveFigureAccessForLabel: collision between label figure references!!! "+haveAccess);
		}
		label.setAccessor(figureAccess);
	}

	private FigureDescriptor getOrCreateFigureDescriptorFor(RealFigure toplevelFigure) {
		FigureDescriptor descriptor = toplevelFigure.getDescriptor();
		if (descriptor == null) {
			descriptor = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
			if (toplevelFigure.getName() != null) {
				descriptor.setName(toplevelFigure.getName());
				saveIdentityNameAttributeForId(descriptor, toplevelFigure.getName());
			}
			EObject container = toplevelFigure.eContainer();
			if (container instanceof FigureGallery) {
				FigureGallery gallery = (FigureGallery) container;
				gallery.getDescriptors().add(descriptor);
			}
			descriptor.setActualFigure(toplevelFigure);
		}
		return descriptor;
	}
	
	@Override
	public void postProcess() {
		super.postProcess();
		// unfortunately, will be called BEFORE processing resolved id references!!!
	}
	
	private FigureGallery getOrCreateFigureGalleryOnce(Figure figure) {
		if (myDefaultCreatedFigureGallery == null) {
			myDefaultCreatedFigureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			if (figure.eContainer() instanceof Canvas) {
				Canvas canvas = (Canvas) figure.eContainer();
				canvas.getFigures().add(myDefaultCreatedFigureGallery);
			} else {
				figure.eResource().getContents().add(myDefaultCreatedFigureGallery);
			}
		}
		return myDefaultCreatedFigureGallery;
	}

}
