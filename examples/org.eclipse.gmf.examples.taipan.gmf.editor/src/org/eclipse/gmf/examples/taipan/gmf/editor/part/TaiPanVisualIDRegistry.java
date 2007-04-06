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
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.BesiegePortOrder;
import org.eclipse.gmf.examples.taipan.EmptyBox;
import org.eclipse.gmf.examples.taipan.EscortShipsOrder;
import org.eclipse.gmf.examples.taipan.LargeItem;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.SmallItems;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.Warship;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemArticleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemWeightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortLocationEditPart;
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
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanAbstractExpression;
import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanOCLFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class TaiPanVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = TaiPanDiagramEditorPlugin.getInstance().getBundle().getSymbolicName() + "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (AquatoryEditPart.MODEL_ID.equals(view.getType())) {
				return AquatoryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				TaiPanDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (TaiPanPackage.eINSTANCE.getAquatory().isSuperTypeOf(domainElementMetaclass) && isDiagramAquatory_1000((Aquatory) domainElement)) {
			return AquatoryEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!AquatoryEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (AquatoryEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = AquatoryEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint) : -1;
		switch (containerVisualID) {
		case PortEditPart.VISUAL_ID:
			if (PortLocationEditPart.VISUAL_ID == nodeVisualID) {
				return PortLocationEditPart.VISUAL_ID;
			}
			return getUnrecognizedPort_2001ChildNodeID(domainElement, semanticHint);
		case ShipEditPart.VISUAL_ID:
			if (ShipNameEditPart.VISUAL_ID == nodeVisualID) {
				return ShipNameEditPart.VISUAL_ID;
			}
			if (ShipSmallCargoEditPart.VISUAL_ID == nodeVisualID) {
				return ShipSmallCargoEditPart.VISUAL_ID;
			}
			if (ShipLargeCargoEditPart.VISUAL_ID == nodeVisualID) {
				return ShipLargeCargoEditPart.VISUAL_ID;
			}
			return getUnrecognizedShip_2002ChildNodeID(domainElement, semanticHint);
		case WarshipEditPart.VISUAL_ID:
			if (WarshipNameEditPart.VISUAL_ID == nodeVisualID) {
				return WarshipNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedWarship_2003ChildNodeID(domainElement, semanticHint);
		case SmallItemsEditPart.VISUAL_ID:
			return getUnrecognizedSmallItems_3001ChildNodeID(domainElement, semanticHint);
		case LargeItemEditPart.VISUAL_ID:
			if (LargeItemArticleEditPart.VISUAL_ID == nodeVisualID) {
				return LargeItemArticleEditPart.VISUAL_ID;
			}
			if (LargeItemWeightEditPart.VISUAL_ID == nodeVisualID) {
				return LargeItemWeightEditPart.VISUAL_ID;
			}
			return getUnrecognizedLargeItem_3002ChildNodeID(domainElement, semanticHint);
		case EmptyBoxEditPart.VISUAL_ID:
			return getUnrecognizedEmptyBox_3003ChildNodeID(domainElement, semanticHint);
		case ShipSmallCargoEditPart.VISUAL_ID:
			if ((semanticHint == null || SmallItemsEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getSmallItems().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSmallItems_3001((SmallItems) domainElement))) {
				return SmallItemsEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipSmallCargo_7001ChildNodeID(domainElement, semanticHint);
		case ShipLargeCargoEditPart.VISUAL_ID:
			if ((semanticHint == null || LargeItemEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getLargeItem().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeLargeItem_3002((LargeItem) domainElement))) {
				return LargeItemEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EmptyBoxEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getEmptyBox().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEmptyBox_3003((EmptyBox) domainElement))) {
				return EmptyBoxEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipLargeCargo_7002ChildNodeID(domainElement, semanticHint);
		case AquatoryEditPart.VISUAL_ID:
			if ((semanticHint == null || PortEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getPort().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodePort_2001((Port) domainElement))) {
				return PortEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ShipEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getShip().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeShip_2002((Ship) domainElement))) {
				return ShipEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || WarshipEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getWarship().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeWarship_2003((Warship) domainElement))) {
				return WarshipEditPart.VISUAL_ID;
			}
			return getUnrecognizedAquatory_1000ChildNodeID(domainElement, semanticHint);
		case ShipDestinationEditPart.VISUAL_ID:
			if (ShipDestinationMarkerEditPart.VISUAL_ID == nodeVisualID) {
				return ShipDestinationMarkerEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipDestination_4001LinkLabelID(semanticHint);
		case ReliableRouteEditPart.VISUAL_ID:
			if (ReliableRouteDescEditPart.VISUAL_ID == nodeVisualID) {
				return ReliableRouteDescEditPart.VISUAL_ID;
			}
			if (ReliableRouteRelbEditPart.VISUAL_ID == nodeVisualID) {
				return ReliableRouteRelbEditPart.VISUAL_ID;
			}
			return getUnrecognizedRoute_4002LinkLabelID(semanticHint);
		case UnreliableRouteEditPart.VISUAL_ID:
			if (UnreliableRouteDescEditPart.VISUAL_ID == nodeVisualID) {
				return UnreliableRouteDescEditPart.VISUAL_ID;
			}
			if (UnreliableRouteRelbEditPart.VISUAL_ID == nodeVisualID) {
				return UnreliableRouteRelbEditPart.VISUAL_ID;
			}
			return getUnrecognizedRoute_4003LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_4002((Route) domainElement))) {
			return ReliableRouteEditPart.VISUAL_ID;
		} else if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_4003((Route) domainElement))) {
			return UnreliableRouteEditPart.VISUAL_ID;
		} else if (TaiPanPackage.eINSTANCE.getEscortShipsOrder().isSuperTypeOf(domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassEscortShipsOrder_4006((EscortShipsOrder) domainElement))) {
			return EscortShipsOrderEditPart.VISUAL_ID;
		} else if (TaiPanPackage.eINSTANCE.getBesiegePortOrder().isSuperTypeOf(domainElementMetaclass)
				&& (domainElement == null || isLinkWithClassBesiegePortOrder_4005((BesiegePortOrder) domainElement))) {
			return BesiegePortOrderEditPart.VISUAL_ID;
		} else {
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramAquatory_1000(Aquatory element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodePort_2001(Port element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeShip_2002(Ship element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeWarship_2003(Warship element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSmallItems_3001(SmallItems element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLargeItem_3002(LargeItem element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEmptyBox_3003(EmptyBox element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPort_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShip_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedWarship_2003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSmallItems_3001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLargeItem_3002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEmptyBox_3003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShipSmallCargo_7001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShipLargeCargo_7002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAquatory_1000ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShipDestination_4001LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRoute_4002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRoute_4003LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRoute_4002(Route element) {
		return Route_4002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRoute_4003(Route element) {
		return Route_4003.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassEscortShipsOrder_4006(EscortShipsOrder element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassBesiegePortOrder_4005(BesiegePortOrder element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static final Matcher Route_4002 = new Matcher(TaiPanOCLFactory.getExpression("reliability >= 0.5", //$NON-NLS-1$
			TaiPanPackage.eINSTANCE.getRoute()));

	/**
	 * @generated
	 */
	private static final Matcher Route_4003 = new Matcher(TaiPanOCLFactory.getExpression("reliability < 0.5", //$NON-NLS-1$
			TaiPanPackage.eINSTANCE.getRoute()));

	/**
	 * @generated	
	 */
	static class Matcher {

		/**
		 * @generated	
		 */
		private TaiPanAbstractExpression condition;

		/**
		 * @generated	
		 */
		Matcher(TaiPanAbstractExpression conditionExpression) {
			this.condition = conditionExpression;
		}

		/**
		 * @generated	
		 */
		boolean matches(Object object) {
			Object result = condition.evaluate(object);
			return result instanceof Boolean && ((Boolean) result).booleanValue();
		}
	}// Matcher
}
