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
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.BesiegePortOrder;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.Warship;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortRegisterEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return view.getEAnnotation("Shortcut") != null && view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case ShipSmallCargoEditPart.VISUAL_ID:
			return getShipSmallCargo_7001SemanticChildren(view);
		case ShipLargeCargoEditPart.VISUAL_ID:
			return getShipLargeCargo_7002SemanticChildren(view);
		case WarshipLargeCargoEditPart.VISUAL_ID:
			return getWarshipLargeCargo_7003SemanticChildren(view);
		case AquatoryEditPart.VISUAL_ID:
			return getAquatory_1SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getShipSmallCargo_7001SemanticChildren(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getShipSmallCargo_7001SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isShipSmallCargo_7001DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShipLargeCargo_7002SemanticChildren(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getShipLargeCargo_7002SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isShipLargeCargo_7002DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarshipLargeCargo_7003SemanticChildren(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getWarshipLargeCargo_7003SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isWarshipLargeCargo_7003DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAquatory_1SemanticChildren(View view) {
		Aquatory modelElement = (Aquatory) view.getElement();
		List result = new LinkedList();
		for (Iterator semanticIterator = getAquatory_1SemanticChildren(modelElement).iterator(); semanticIterator.hasNext();) {
			EObject nextElement = (EObject) semanticIterator.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, nextElement);
			if (isAquatory_1DomainMetaChild(visualID)) {
				result.add(new TaiPanNodeDescriptor(nextElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static List getShipSmallCargo_7001SemanticChildren(Ship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getShipLargeCargo_7002SemanticChildren(Ship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getWarshipLargeCargo_7003SemanticChildren(Warship modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getCargo());
		return allValues;
	}

	/**
	 * @generated
	 */
	private static List getAquatory_1SemanticChildren(Aquatory modelElement) {
		List allValues = new LinkedList();
		allValues.addAll(modelElement.getPorts());
		allValues.addAll(modelElement.getShips());
		return allValues;
	}

	/**
	 * @generated
	 */
	public static boolean isShipSmallCargo_7001DomainMetaChild(int visualID) {
		switch (visualID) {
		case SmallItemsEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isShipLargeCargo_7002DomainMetaChild(int visualID) {
		switch (visualID) {
		case LargeItemEditPart.VISUAL_ID:
		case EmptyBoxEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isWarshipLargeCargo_7003DomainMetaChild(int visualID) {
		switch (visualID) {
		case LargeItemEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isAquatory_1DomainMetaChild(int visualID) {
		switch (visualID) {
		case PortEditPart.VISUAL_ID:
		case ShipEditPart.VISUAL_ID:
		case WarshipEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_2001ContainerLinks(view);
		case ShipEditPart.VISUAL_ID:
			return getShip_2002ContainerLinks(view);
		case WarshipEditPart.VISUAL_ID:
			return getWarship_2003ContainerLinks(view);
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001ContainerLinks(view);
		case LargeItemEditPart.VISUAL_ID:
			return getLargeItem_3002ContainerLinks(view);
		case EmptyBoxEditPart.VISUAL_ID:
			return getEmptyBox_3003ContainerLinks(view);
		case ReliableRouteEditPart.VISUAL_ID:
			return getRoute_4002ContainerLinks(view);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getRoute_4003ContainerLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006ContainerLinks(view);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005ContainerLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPort_2001ContainerLinks(View view) {
		Port modelElement = (Port) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedFeatureModelFacetLinks_Port_Register_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShip_2002ContainerLinks(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003ContainerLinks(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_EscortShipsOrder_4006(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_BesiegePortOrder_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSmallItems_3001ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLargeItem_3002ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEmptyBox_3003ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4002ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEscortShipsOrder_4006ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBesiegePortOrder_4005ContainerLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedFeatureModelFacetLinks_Ship_Destination_4001(Ship container) {
		Collection result = new LinkedList();
		Port destination = container.getDestination();
		result.add(new TaiPanLinkDescriptor(container, destination, TaiPanElementTypes.ShipDestination_4001, ShipDestinationEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EscortShipsOrder_4006(Warship container) {
		Collection result = new LinkedList();
		EscortShipsOrder link = (EscortShipsOrder) container.getEscortOrder();
		int linkVID = TaiPanVisualIDRegistry.getLinkWithClassVisualID(link);
		if (linkVID == EscortShipsOrderEditPart.VISUAL_ID) {
			List targets = link.getShips();
			Object target = targets.size() == 1 ? targets.get(0) : null;
			if (target instanceof Ship) {
				Ship dst = (Ship) target;
				result.add(new TaiPanLinkDescriptor(container, dst, link, TaiPanElementTypes.EscortShipsOrder_4006, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_BesiegePortOrder_4005(Warship container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getAttackOrders().iterator(); links.hasNext();) {
			BesiegePortOrder link = (BesiegePortOrder) links.next();
			int linkVID = TaiPanVisualIDRegistry.getLinkWithClassVisualID(link);
			if (linkVID == BesiegePortOrderEditPart.VISUAL_ID) {
				Port dst = link.getPort();
				result.add(new TaiPanLinkDescriptor(container, dst, link, TaiPanElementTypes.BesiegePortOrder_4005, linkVID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedFeatureModelFacetLinks_Port_Register_4007(Port container) {
		Collection result = new LinkedList();
		for (Iterator destinations = container.getRegister().iterator(); destinations.hasNext();) {
			Ship destination = (Ship) destinations.next();
			result.add(new TaiPanLinkDescriptor(container, destination, TaiPanElementTypes.PortRegister_4007, PortRegisterEditPart.VISUAL_ID));
		}
		return result;
	}

}
