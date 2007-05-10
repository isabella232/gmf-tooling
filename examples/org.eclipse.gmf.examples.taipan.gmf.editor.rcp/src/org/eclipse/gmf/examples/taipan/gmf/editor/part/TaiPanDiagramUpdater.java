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

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.BesiegePortOrder;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
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
			return getPort_2001ContainedLinks(view);
		case ShipEditPart.VISUAL_ID:
			return getShip_2002ContainedLinks(view);
		case WarshipEditPart.VISUAL_ID:
			return getWarship_2003ContainedLinks(view);
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001ContainedLinks(view);
		case LargeItemEditPart.VISUAL_ID:
			return getLargeItem_3002ContainedLinks(view);
		case EmptyBoxEditPart.VISUAL_ID:
			return getEmptyBox_3003ContainedLinks(view);
		case ReliableRouteEditPart.VISUAL_ID:
			return getRoute_4002ContainedLinks(view);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getRoute_4003ContainedLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006ContainedLinks(view);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_2001IncomingLinks(view);
		case ShipEditPart.VISUAL_ID:
			return getShip_2002IncomingLinks(view);
		case WarshipEditPart.VISUAL_ID:
			return getWarship_2003IncomingLinks(view);
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001IncomingLinks(view);
		case LargeItemEditPart.VISUAL_ID:
			return getLargeItem_3002IncomingLinks(view);
		case EmptyBoxEditPart.VISUAL_ID:
			return getEmptyBox_3003IncomingLinks(view);
		case ReliableRouteEditPart.VISUAL_ID:
			return getRoute_4002IncomingLinks(view);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getRoute_4003IncomingLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006IncomingLinks(view);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_2001OutgoingLinks(view);
		case ShipEditPart.VISUAL_ID:
			return getShip_2002OutgoingLinks(view);
		case WarshipEditPart.VISUAL_ID:
			return getWarship_2003OutgoingLinks(view);
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001OutgoingLinks(view);
		case LargeItemEditPart.VISUAL_ID:
			return getLargeItem_3002OutgoingLinks(view);
		case EmptyBoxEditPart.VISUAL_ID:
			return getEmptyBox_3003OutgoingLinks(view);
		case ReliableRouteEditPart.VISUAL_ID:
			return getRoute_4002OutgoingLinks(view);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getRoute_4003OutgoingLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006OutgoingLinks(view);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPort_2001ContainedLinks(View view) {
		Port modelElement = (Port) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedFeatureModelFacetLinks_Port_Register_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShip_2002ContainedLinks(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003ContainedLinks(View view) {
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
	public static List getSmallItems_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLargeItem_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEmptyBox_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEscortShipsOrder_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBesiegePortOrder_4005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPort_2001IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Ship_Destination_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Route_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Route_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BesiegePortOrder_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShip_2002IncomingLinks(View view) {
		Ship modelElement = (Ship) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_EscortShipsOrder_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Register_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003IncomingLinks(View view) {
		Warship modelElement = (Warship) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_EscortShipsOrder_4006(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Register_4007(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSmallItems_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLargeItem_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEmptyBox_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEscortShipsOrder_4006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBesiegePortOrder_4005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPort_2001OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4003(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Register_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShip_2002OutgoingLinks(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003OutgoingLinks(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_EscortShipsOrder_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BesiegePortOrder_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSmallItems_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLargeItem_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEmptyBox_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEscortShipsOrder_4006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBesiegePortOrder_4005OutgoingLinks(View view) {
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
		if (EscortShipsOrderEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
			return result;
		}
		List targets = link.getShips();
		Object theTarget = targets.size() == 1 ? targets.get(0) : null;
		if (false == theTarget instanceof Ship) {
			return result;
		}
		Ship dst = (Ship) theTarget;
		result.add(new TaiPanLinkDescriptor(container, dst, link, TaiPanElementTypes.EscortShipsOrder_4006, EscortShipsOrderEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_BesiegePortOrder_4005(Warship container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getAttackOrders().iterator(); links.hasNext();) {
			BesiegePortOrder link = (BesiegePortOrder) links.next();
			if (BesiegePortOrderEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Port dst = link.getPort();
			result.add(new TaiPanLinkDescriptor(container, dst, link, TaiPanElementTypes.BesiegePortOrder_4005, BesiegePortOrderEditPart.VISUAL_ID));
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

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Ship_Destination_4001(Port target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == TaiPanPackage.eINSTANCE.getShip_Destination()) {
				result.add(new TaiPanLinkDescriptor(setting.getEObject(), target, TaiPanElementTypes.ShipDestination_4001, ShipDestinationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Route_4002(Port target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TaiPanPackage.eINSTANCE.getRoute_Destination() || false == setting.getEObject() instanceof Route) {
				continue;
			}
			Route link = (Route) setting.getEObject();
			if (ReliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Port src = link.getSource();
			result.add(new TaiPanLinkDescriptor(src, target, link, TaiPanElementTypes.Route_4002, ReliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Route_4003(Port target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TaiPanPackage.eINSTANCE.getRoute_Destination() || false == setting.getEObject() instanceof Route) {
				continue;
			}
			Route link = (Route) setting.getEObject();
			if (UnreliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Port src = link.getSource();
			result.add(new TaiPanLinkDescriptor(src, target, link, TaiPanElementTypes.Route_4003, UnreliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_EscortShipsOrder_4006(Ship target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TaiPanPackage.eINSTANCE.getEscortShipsOrder_Ships() || false == setting.getEObject() instanceof EscortShipsOrder) {
				continue;
			}
			EscortShipsOrder link = (EscortShipsOrder) setting.getEObject();
			if (EscortShipsOrderEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Warship) {
				continue;
			}
			Warship container = (Warship) link.eContainer();
			result.add(new TaiPanLinkDescriptor(container, target, link, TaiPanElementTypes.EscortShipsOrder_4006, EscortShipsOrderEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_BesiegePortOrder_4005(Port target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TaiPanPackage.eINSTANCE.getBesiegePortOrder_Port() || false == setting.getEObject() instanceof BesiegePortOrder) {
				continue;
			}
			BesiegePortOrder link = (BesiegePortOrder) setting.getEObject();
			if (BesiegePortOrderEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Warship) {
				continue;
			}
			Warship container = (Warship) link.eContainer();
			result.add(new TaiPanLinkDescriptor(container, target, link, TaiPanElementTypes.BesiegePortOrder_4005, BesiegePortOrderEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Port_Register_4007(Ship target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == TaiPanPackage.eINSTANCE.getPort_Register()) {
				result.add(new TaiPanLinkDescriptor(setting.getEObject(), target, TaiPanElementTypes.PortRegister_4007, PortRegisterEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(Ship source) {
		return getContainedFeatureModelFacetLinks_Ship_Destination_4001(source);
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Route_4002(Port source) {
		Aquatory container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Aquatory) {
				container = (Aquatory) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getRoutes().iterator(); links.hasNext();) {
			Route link = (Route) links.next();
			if (ReliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Port dst = link.getDestination();
			Port src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new TaiPanLinkDescriptor(src, dst, link, TaiPanElementTypes.Route_4002, ReliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Route_4003(Port source) {
		Aquatory container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Aquatory) {
				container = (Aquatory) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getRoutes().iterator(); links.hasNext();) {
			Route link = (Route) links.next();
			if (UnreliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Port dst = link.getDestination();
			Port src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new TaiPanLinkDescriptor(src, dst, link, TaiPanElementTypes.Route_4003, UnreliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_EscortShipsOrder_4006(Warship source) {
		return getContainedTypeModelFacetLinks_EscortShipsOrder_4006(source);
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_BesiegePortOrder_4005(Warship source) {
		return getContainedTypeModelFacetLinks_BesiegePortOrder_4005(source);
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Port_Register_4007(Port source) {
		return getContainedFeatureModelFacetLinks_Port_Register_4007(source);
	}

}
