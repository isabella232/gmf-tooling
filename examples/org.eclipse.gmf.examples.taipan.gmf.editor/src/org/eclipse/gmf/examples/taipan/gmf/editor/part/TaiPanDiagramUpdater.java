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
import org.eclipse.gmf.examples.taipan.Destination;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.Item;
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
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipSmallCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipLargeCargoEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipSmallCargoEditPart;
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
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case ShipSmallCargoEditPart.VISUAL_ID:
			return getShipSmallcargo_7001SemanticChildren(view);
		case ShipLargeCargoEditPart.VISUAL_ID:
			return getShipLargeCargo_7002SemanticChildren(view);
		case WarshipSmallCargoEditPart.VISUAL_ID:
			return getWarshipSmallcargo_7003SemanticChildren(view);
		case WarshipLargeCargoEditPart.VISUAL_ID:
			return getWarshipLargeCargo_7004SemanticChildren(view);
		case AquatoryEditPart.VISUAL_ID:
			return getAquatory_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getShipSmallcargo_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Ship modelElement = (Ship) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getCargo().iterator(); it.hasNext();) {
			Item childElement = (Item) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SmallItemsEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShipLargeCargo_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Ship modelElement = (Ship) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getCargo().iterator(); it.hasNext();) {
			Item childElement = (Item) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LargeItemEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EmptyBoxEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarshipSmallcargo_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Warship modelElement = (Warship) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getCargo().iterator(); it.hasNext();) {
			Item childElement = (Item) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SmallItemsEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarshipLargeCargo_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Warship modelElement = (Warship) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getCargo().iterator(); it.hasNext();) {
			Item childElement = (Item) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == LargeItemEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EmptyBoxEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAquatory_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Aquatory modelElement = (Aquatory) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getPorts().iterator(); it.hasNext();) {
			Port childElement = (Port) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getShips().iterator(); it.hasNext();) {
			Ship childElement = (Ship) it.next();
			int visualID = TaiPanVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ShipEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == WarshipEditPart.VISUAL_ID) {
				result.add(new TaiPanNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case AquatoryEditPart.VISUAL_ID:
			return getAquatory_1000ContainedLinks(view);
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
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005ContainedLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006ContainedLinks(view);
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
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005IncomingLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006IncomingLinks(view);
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
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005OutgoingLinks(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAquatory_1000ContainedLinks(View view) {
		Aquatory modelElement = (Aquatory) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Route_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Route_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPort_2001ContainedLinks(View view) {
		Port modelElement = (Port) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Register_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShip_2002ContainedLinks(View view) {
		Ship modelElement = (Ship) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Route_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003ContainedLinks(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Route_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_BesiegePortOrder_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_EscortShipsOrder_4006(modelElement));
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
		Route modelElement = (Route) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Route_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Route_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Ship_Route_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003IncomingLinks(View view) {
		Route modelElement = (Route) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Route_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Route_4003(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Ship_Route_4004(modelElement, crossReferences));
		return result;
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
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Route_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getWarship_2003OutgoingLinks(View view) {
		Warship modelElement = (Warship) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Ship_Route_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_BesiegePortOrder_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_EscortShipsOrder_4006(modelElement));
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
		Route modelElement = (Route) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRoute_4003OutgoingLinks(View view) {
		Route modelElement = (Route) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Route_4003(modelElement));
		return result;
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
	private static Collection getContainedTypeModelFacetLinks_Route_4002(Aquatory container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRoutes().iterator(); links.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Route) {
				continue;
			}
			Route link = (Route) linkObject;
			if (ReliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Destination dst = link.getDestination();
			Destination src = link.getSource();
			result.add(new TaiPanLinkDescriptor(src, dst, link, TaiPanElementTypes.Route_4002, ReliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Route_4003(Aquatory container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getRoutes().iterator(); links.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Route) {
				continue;
			}
			Route link = (Route) linkObject;
			if (UnreliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Destination dst = link.getDestination();
			Destination src = link.getSource();
			result.add(new TaiPanLinkDescriptor(src, dst, link, TaiPanElementTypes.Route_4003, UnreliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EscortShipsOrder_4006(Warship container) {
		Collection result = new LinkedList();
		EscortShipsOrder link = container.getEscortOrder();
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
			Object linkObject = links.next();
			if (false == linkObject instanceof BesiegePortOrder) {
				continue;
			}
			BesiegePortOrder link = (BesiegePortOrder) linkObject;
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
	private static Collection getIncomingTypeModelFacetLinks_Route_4002(Destination target, Map crossReferences) {
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
			Destination src = link.getSource();
			result.add(new TaiPanLinkDescriptor(src, target, link, TaiPanElementTypes.Route_4002, ReliableRouteEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Route_4003(Destination target, Map crossReferences) {
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
			Destination src = link.getSource();
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
	private static Collection getIncomingFeatureModelFacetLinks_Ship_Route_4004(Route target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() == TaiPanPackage.eINSTANCE.getShip_Route()) {
				result.add(new TaiPanLinkDescriptor(setting.getEObject(), target, TaiPanElementTypes.ShipRoute_4004, ShipRouteEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Ship_Destination_4001(Ship source) {
		Collection result = new LinkedList();
		Port destination = source.getDestination();
		result.add(new TaiPanLinkDescriptor(source, destination, TaiPanElementTypes.ShipDestination_4001, ShipDestinationEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Route_4002(Destination source) {
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
			Object linkObject = links.next();
			if (false == linkObject instanceof Route) {
				continue;
			}
			Route link = (Route) linkObject;
			if (ReliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Destination dst = link.getDestination();
			Destination src = link.getSource();
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
	private static Collection getOutgoingTypeModelFacetLinks_Route_4003(Destination source) {
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
			Object linkObject = links.next();
			if (false == linkObject instanceof Route) {
				continue;
			}
			Route link = (Route) linkObject;
			if (UnreliableRouteEditPart.VISUAL_ID != TaiPanVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Destination dst = link.getDestination();
			Destination src = link.getSource();
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
	private static Collection getOutgoingFeatureModelFacetLinks_Port_Register_4007(Port source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getRegister().iterator(); destinations.hasNext();) {
			Ship destination = (Ship) destinations.next();
			result.add(new TaiPanLinkDescriptor(source, destination, TaiPanElementTypes.PortRegister_4007, PortRegisterEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Ship_Route_4004(Ship source) {
		Collection result = new LinkedList();
		Route destination = source.getRoute();
		result.add(new TaiPanLinkDescriptor(source, destination, TaiPanElementTypes.ShipRoute_4004, ShipRouteEditPart.VISUAL_ID));
		return result;
	}

}
