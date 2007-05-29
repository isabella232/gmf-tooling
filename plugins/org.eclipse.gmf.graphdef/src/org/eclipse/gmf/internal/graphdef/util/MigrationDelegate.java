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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmf.gmfgraph.ChildAccess;
import org.eclipse.gmf.gmfgraph.Compartment;
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
	private EReference myFigure_RefElements;
	
	//private FigureGallery myDefaultCreatedFigureGallery;
	
	MigrationDelegate() {
	}

	void init() {
		// narrowing for reference FigureAccessor.typedFigure: (the only place where concrete CustomFigure was used)
		registerNarrowedAbstractType("RealFigure", GMFGraphPackage.eINSTANCE.getCustomFigure()); //$NON-NLS-1$
		
		registerDeletedAttributes(GMFGraphPackage.eINSTANCE.getCustomClass(), "bundleName"); //$NON-NLS-1$
		
		myFigure_RefElements = createNewReference("referencingElements", GMFGraphPackage.eINSTANCE.getDiagramElement(), false); //$NON-NLS-1$
		registerRenamedParentAttribute(GMFGraphPackage.eINSTANCE.getFigure(), "referencingElements", myFigure_RefElements); //$NON-NLS-1$
	}

	@Override
	public boolean setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (myFigure_RefElements.equals(feature)) {
			Figure figure = (Figure) object; // can be FigureRef as well
			RealFigure topLevel = findTopLevelFigure(figure);
			FigureDescriptor figureDescriptor = getOrCreateFigureDescriptorFor(topLevel);
			if (figure instanceof RealFigure) { //XXX!!! think smth out!
				replaceFigureIdWithDescriptorIdInResolve(figureDescriptor, ((RealFigure) figure).getName());
			}
			if (!figure.equals(topLevel)) {
				ChildAccess access = getOrCreateChildAccessForNested(figure, figureDescriptor);
				DiagramElement node = (DiagramElement) value;
				setNestedFigureAccessFor(node, access);
			}
			fireMigrationApplied(true);
		} else {
			// other cases are would be processed as defaults
			return super.setValue(object, feature, value, position);
		}
		return true;
	}

	private void setNestedFigureAccessFor(DiagramElement dElem, ChildAccess access) {
		if (dElem instanceof DiagramLabel) {
			DiagramLabel label = (DiagramLabel) dElem;
			label.setAccessor(access);
		} else if (dElem instanceof Node) {
			Node node = (Node) dElem;
			node.setContentPane(access);
		} else if (dElem instanceof Compartment) {
			Compartment bag = (Compartment) dElem;
			bag.setAccessor(access);
		}
	}

	private void replaceFigureIdWithDescriptorIdInResolve(EObject figure, String name) {
		//XXX: there is still problem with references for figures, when not only
		// figureDescriptors are needed. For ex., see PolylineConnection.targetDecoration
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
	}

	private RealFigure findTopLevelFigure(Figure figure) {
		RealFigure result = figure instanceof RealFigure ? (RealFigure) figure : null;
		while (result.eContainer() instanceof RealFigure) {
			result = (RealFigure) result.eContainer();
		} // contained within FigureGallery of FigureDescriptor
		return result;
	}

	private ChildAccess getOrCreateChildAccessForNested(Figure nestedFigure, FigureDescriptor toplevelDescriptor) {
		for (ChildAccess haveAccess : toplevelDescriptor.getAccessors()) {
			if (haveAccess.getFigure().equals(nestedFigure)) {
				return haveAccess;
			}
		}
		ChildAccess result = GMFGraphFactory.eINSTANCE.createChildAccess();
		result.setFigure(nestedFigure);
		toplevelDescriptor.getAccessors().add(result);
		return result;
	}
	
	private FigureDescriptor getOrCreateFigureDescriptorFor(RealFigure toplevelFigure) {
		FigureDescriptor descriptor = toplevelFigure.getDescriptor();
		if (descriptor == null) {
			descriptor = GMFGraphFactory.eINSTANCE.createFigureDescriptor();
			if (toplevelFigure.getName() != null) {
				descriptor.setName(toplevelFigure.getName());
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
	
//	private FigureGallery getOrCreateFigureGalleryOnce(Figure figure) {
//		if (myDefaultCreatedFigureGallery == null) {
//			myDefaultCreatedFigureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
//			if (figure.eContainer() instanceof Canvas) {
//				Canvas canvas = (Canvas) figure.eContainer();
//				canvas.getFigures().add(myDefaultCreatedFigureGallery);
//			} else {
//				figure.eResource().getContents().add(myDefaultCreatedFigureGallery);
//			}
//		}
//		return myDefaultCreatedFigureGallery;
//	}
}
