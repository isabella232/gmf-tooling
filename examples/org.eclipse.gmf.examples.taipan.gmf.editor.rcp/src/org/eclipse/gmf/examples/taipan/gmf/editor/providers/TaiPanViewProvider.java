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
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemArticleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemWeightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortLocationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteDescription2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteDescriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteReliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.RouteReliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationMarkerEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.AquatoryViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.BesiegePortOrderViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.EmptyBoxViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.EscortShipsOrderViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemArticleViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemWeightViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortLocationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.Route2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteDescription2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteDescriptionViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteReliability2ViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteReliabilityViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.RouteViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipDestinationMarkerViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipDestinationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipLargeCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipNameViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipSmallCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.SmallItemsViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipNameViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

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
		case PortLocationEditPart.VISUAL_ID:
			return PortLocationViewFactory.class;
		case ShipEditPart.VISUAL_ID:
			return ShipViewFactory.class;
		case ShipNameEditPart.VISUAL_ID:
			return ShipNameViewFactory.class;
		case WarshipEditPart.VISUAL_ID:
			return WarshipViewFactory.class;
		case WarshipNameEditPart.VISUAL_ID:
			return WarshipNameViewFactory.class;
		case SmallItemsEditPart.VISUAL_ID:
			return SmallItemsViewFactory.class;
		case LargeItemEditPart.VISUAL_ID:
			return LargeItemViewFactory.class;
		case LargeItemArticleEditPart.VISUAL_ID:
			return LargeItemArticleViewFactory.class;
		case LargeItemWeightEditPart.VISUAL_ID:
			return LargeItemWeightViewFactory.class;
		case EmptyBoxEditPart.VISUAL_ID:
			return EmptyBoxViewFactory.class;
		case ShipSmallCargoEditPart.VISUAL_ID:
			return ShipSmallCargoViewFactory.class;
		case ShipLargeCargoEditPart.VISUAL_ID:
			return ShipLargeCargoViewFactory.class;
		case ShipDestinationMarkerEditPart.VISUAL_ID:
			return ShipDestinationMarkerViewFactory.class;
		case RouteDescriptionEditPart.VISUAL_ID:
			return RouteDescriptionViewFactory.class;
		case RouteReliabilityEditPart.VISUAL_ID:
			return RouteReliabilityViewFactory.class;
		case RouteDescription2EditPart.VISUAL_ID:
			return RouteDescription2ViewFactory.class;
		case RouteReliability2EditPart.VISUAL_ID:
			return RouteReliability2ViewFactory.class;
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
			return ShipDestinationViewFactory.class;
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
		case EscortShipsOrderEditPart.VISUAL_ID:
			return EscortShipsOrderViewFactory.class;
		case BesiegePortOrderEditPart.VISUAL_ID:
			return BesiegePortOrderViewFactory.class;
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
