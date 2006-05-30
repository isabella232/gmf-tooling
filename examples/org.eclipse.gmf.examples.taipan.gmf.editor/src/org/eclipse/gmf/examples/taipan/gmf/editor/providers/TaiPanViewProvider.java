/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Destination_UnknownEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItem_articleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItem_weightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Port_locationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_description2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_descriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_LargeCargoCompartmentEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_SmallCargoCompartmentEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_nameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.AquatoryViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.DestinationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Destination_UnknownViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.EmptyBoxViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItem_articleViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItem_weightViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Port_locationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route_description2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route_descriptionViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route_reliability2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route_reliabilityViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Ship_LargeCargoCompartmentViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Ship_SmallCargoCompartmentViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Ship_nameViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.SmallItemsViewFactory;

/**
 * @generated
 */
public class TaiPanViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (AquatoryEditPart.MODEL_ID.equals(diagramKind) && TaiPanVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return AquatoryViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null && !TaiPanElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = TaiPanVisualIDRegistry.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case PortEditPart.VISUAL_ID:
			return PortViewFactory.class;
		case Port_locationEditPart.VISUAL_ID:
			return Port_locationViewFactory.class;
		case ShipEditPart.VISUAL_ID:
			return ShipViewFactory.class;
		case Ship_nameEditPart.VISUAL_ID:
			return Ship_nameViewFactory.class;
		case SmallItemsEditPart.VISUAL_ID:
			return SmallItemsViewFactory.class;
		case LargeItemEditPart.VISUAL_ID:
			return LargeItemViewFactory.class;
		case LargeItem_articleEditPart.VISUAL_ID:
			return LargeItem_articleViewFactory.class;
		case LargeItem_weightEditPart.VISUAL_ID:
			return LargeItem_weightViewFactory.class;
		case EmptyBoxEditPart.VISUAL_ID:
			return EmptyBoxViewFactory.class;
		case Ship_SmallCargoCompartmentEditPart.VISUAL_ID:
			return Ship_SmallCargoCompartmentViewFactory.class;
		case Ship_LargeCargoCompartmentEditPart.VISUAL_ID:
			return Ship_LargeCargoCompartmentViewFactory.class;
		case Destination_UnknownEditPart.VISUAL_ID:
			return Destination_UnknownViewFactory.class;
		case Route_descriptionEditPart.VISUAL_ID:
			return Route_descriptionViewFactory.class;
		case Route_reliabilityEditPart.VISUAL_ID:
			return Route_reliabilityViewFactory.class;
		case Route_description2EditPart.VISUAL_ID:
			return Route_description2ViewFactory.class;
		case Route_reliability2EditPart.VISUAL_ID:
			return Route_reliability2ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null && !TaiPanElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		if (TaiPanElementTypes.ShipDestination_4001.equals(elementType)) {
			return DestinationViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = TaiPanVisualIDRegistry.getLinkWithClassVisualID(semanticElement, semanticType);
		switch (linkVID) {
		case RouteEditPart.VISUAL_ID:
			return RouteViewFactory.class;
		case Route2EditPart.VISUAL_ID:
			return Route2ViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
