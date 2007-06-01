/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
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
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemArticleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemWeightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortLocationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortRegisterEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteRelbEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationMarkerEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteRelbEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipNameEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.AquatoryViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.BesiegePortOrderViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.EmptyBoxViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.EscortShipsOrderViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemArticleViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.LargeItemWeightViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortLocationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortRegisterViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.PortViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ReliableRouteDescViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ReliableRouteRelbViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ReliableRouteViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipDestinationMarkerViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipDestinationViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipLargeCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipNameViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipSmallCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.ShipViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.SmallItemsViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.UnreliableRouteDescViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.UnreliableRouteRelbViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.UnreliableRouteViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipLargeCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipNameViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipSmallCargoViewFactory;
import org.eclipse.gmf.examples.taipan.gmf.editor.view.factories.WarshipViewFactory;

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
		EObject domainElement = getSemanticElement(semanticAdapter);

		int visualID;
		if (semanticHint == null) {
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = TaiPanVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = TaiPanVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				if (!TaiPanElementTypes.isKnownElementType(elementType) || false == elementType instanceof IHintedType) {
					return null;
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null;
				}
				if (domainElement != null && visualID != TaiPanVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null;
				}
			} else {
				switch (visualID) {
				case AquatoryEditPart.VISUAL_ID:
				case PortEditPart.VISUAL_ID:
				case ShipEditPart.VISUAL_ID:
				case WarshipEditPart.VISUAL_ID:
				case SmallItemsEditPart.VISUAL_ID:
				case LargeItemEditPart.VISUAL_ID:
				case EmptyBoxEditPart.VISUAL_ID:
				case ShipDestinationEditPart.VISUAL_ID:
				case ReliableRouteEditPart.VISUAL_ID:
				case UnreliableRouteEditPart.VISUAL_ID:
				case EscortShipsOrderEditPart.VISUAL_ID:
				case BesiegePortOrderEditPart.VISUAL_ID:
				case PortRegisterEditPart.VISUAL_ID:
					return null;
				}
			}
		}
		if (!TaiPanVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
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
		case WarshipSmallCargoEditPart.VISUAL_ID:
			return WarshipSmallCargoViewFactory.class;
		case WarshipLargeCargoEditPart.VISUAL_ID:
			return WarshipLargeCargoViewFactory.class;
		case ShipDestinationMarkerEditPart.VISUAL_ID:
			return ShipDestinationMarkerViewFactory.class;
		case ReliableRouteDescEditPart.VISUAL_ID:
			return ReliableRouteDescViewFactory.class;
		case ReliableRouteRelbEditPart.VISUAL_ID:
			return ReliableRouteRelbViewFactory.class;
		case UnreliableRouteDescEditPart.VISUAL_ID:
			return UnreliableRouteDescViewFactory.class;
		case UnreliableRouteRelbEditPart.VISUAL_ID:
			return UnreliableRouteRelbViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType == null) {
			return null;
		}
		if (!TaiPanElementTypes.isKnownElementType(elementType) || false == elementType instanceof IHintedType) {
			return null;
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null;
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null;
		}
		int visualID = TaiPanVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null;
		}
		switch (visualID) {
		case ShipDestinationEditPart.VISUAL_ID:
			return ShipDestinationViewFactory.class;
		case ReliableRouteEditPart.VISUAL_ID:
			return ReliableRouteViewFactory.class;
		case UnreliableRouteEditPart.VISUAL_ID:
			return UnreliableRouteViewFactory.class;
		case EscortShipsOrderEditPart.VISUAL_ID:
			return EscortShipsOrderViewFactory.class;
		case BesiegePortOrderEditPart.VISUAL_ID:
			return BesiegePortOrderViewFactory.class;
		case PortRegisterEditPart.VISUAL_ID:
			return PortRegisterViewFactory.class;
		}
		return null;
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

}
