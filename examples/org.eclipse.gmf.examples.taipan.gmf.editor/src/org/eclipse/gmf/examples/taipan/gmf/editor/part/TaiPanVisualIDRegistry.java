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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.EmptyBox;
import org.eclipse.gmf.examples.taipan.LargeItem;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.SmallItems;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.DestinationEditPart;
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
			TaiPanDiagramEditorPlugin.getInstance().logInfo("Unable to parse view type as a visualID number: " + type);
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
		if (TaiPanPackage.eINSTANCE.getAquatory().isSuperTypeOf(domainElementMetaclass) && isDiagramAquatory_79((Aquatory) domainElement)) {
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
		int nodeVisualID = getVisualID(semanticHint);
		switch (containerVisualID) {
		case PortEditPart.VISUAL_ID:
			if (Port_locationEditPart.VISUAL_ID == nodeVisualID) {
				return Port_locationEditPart.VISUAL_ID;
			}
			return getUnrecognizedPort_1001ChildNodeID(domainElement, semanticHint);
		case ShipEditPart.VISUAL_ID:
			if (Ship_nameEditPart.VISUAL_ID == nodeVisualID) {
				return Ship_nameEditPart.VISUAL_ID;
			}
			if (Ship_SmallCargoCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return Ship_SmallCargoCompartmentEditPart.VISUAL_ID;
			}
			if (Ship_LargeCargoCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return Ship_LargeCargoCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedShip_1002ChildNodeID(domainElement, semanticHint);
		case LargeItemEditPart.VISUAL_ID:
			if (LargeItem_articleEditPart.VISUAL_ID == nodeVisualID) {
				return LargeItem_articleEditPart.VISUAL_ID;
			}
			if (LargeItem_weightEditPart.VISUAL_ID == nodeVisualID) {
				return LargeItem_weightEditPart.VISUAL_ID;
			}
			return getUnrecognizedLargeItem_2002ChildNodeID(domainElement, semanticHint);
		case EmptyBoxEditPart.VISUAL_ID:
			return getUnrecognizedEmptyBox_2003ChildNodeID(domainElement, semanticHint);
		case SmallItemsEditPart.VISUAL_ID:
			return getUnrecognizedSmallItems_2001ChildNodeID(domainElement, semanticHint);
		case Ship_SmallCargoCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || SmallItemsEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getSmallItems().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeSmallItems_2001((SmallItems) domainElement))) {
				return SmallItemsEditPart.VISUAL_ID;
			}
			return getUnrecognizedSmallCargoCompartment_5001ChildNodeID(domainElement, semanticHint);
		case Ship_LargeCargoCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || LargeItemEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getLargeItem().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeLargeItem_2002((LargeItem) domainElement))) {
				return LargeItemEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EmptyBoxEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getEmptyBox().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEmptyBox_2003((EmptyBox) domainElement))) {
				return EmptyBoxEditPart.VISUAL_ID;
			}
			return getUnrecognizedLargeCargoCompartment_5002ChildNodeID(domainElement, semanticHint);
		case AquatoryEditPart.VISUAL_ID:
			if ((semanticHint == null || PortEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getPort().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodePort_1001((Port) domainElement))) {
				return PortEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ShipEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getShip().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeShip_1002((Ship) domainElement))) {
				return ShipEditPart.VISUAL_ID;
			}
			return getUnrecognizedAquatory_79ChildNodeID(domainElement, semanticHint);
		case DestinationEditPart.VISUAL_ID:
			if (Destination_UnknownEditPart.VISUAL_ID == nodeVisualID) {
				return Destination_UnknownEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipDestination_3001LinkLabelID(semanticHint);
		case RouteEditPart.VISUAL_ID:
			if (Route_descriptionEditPart.VISUAL_ID == nodeVisualID) {
				return Route_descriptionEditPart.VISUAL_ID;
			}
			if (Route_reliabilityEditPart.VISUAL_ID == nodeVisualID) {
				return Route_reliabilityEditPart.VISUAL_ID;
			}
			return getUnrecognizedRoute_3002LinkLabelID(semanticHint);
		case Route2EditPart.VISUAL_ID:
			if (Route_description2EditPart.VISUAL_ID == nodeVisualID) {
				return Route_description2EditPart.VISUAL_ID;
			}
			if (Route_reliability2EditPart.VISUAL_ID == nodeVisualID) {
				return Route_reliability2EditPart.VISUAL_ID;
			}
			return getUnrecognizedRoute_3003LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_3002((Route) domainElement))) {
			return RouteEditPart.VISUAL_ID;
		} else if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_3003((Route) domainElement))) {
			return Route2EditPart.VISUAL_ID;
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
	private static boolean isDiagramAquatory_79(Aquatory element) {
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
	private static boolean isNodePort_1001(Port element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeShip_1002(Ship element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeLargeItem_2002(LargeItem element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEmptyBox_2003(EmptyBox element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeSmallItems_2001(SmallItems element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPort_1001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShip_1002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLargeItem_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEmptyBox_2003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSmallItems_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedSmallCargoCompartment_5001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLargeCargoCompartment_5002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAquatory_79ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedShipDestination_3001LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRoute_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedRoute_3003LinkLabelID(String semanticHint) {
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
	private static boolean isLinkWithClassRoute_3002(Route element) {
		return Route_3002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassRoute_3003(Route element) {
		return Route_3003.matches(element);
	}

	/**
	 * @generated
	 */
	private static final Matcher Route_3002 = new Matcher(TaiPanOCLFactory.getExpression("reliability >= 0.5", //$NON-NLS-1$
			TaiPanPackage.eINSTANCE.getRoute()));

	/**
	 * @generated
	 */
	private static final Matcher Route_3003 = new Matcher(TaiPanOCLFactory.getExpression("reliability < 0.5", //$NON-NLS-1$
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
		boolean matches(EObject object) {
			Object result = condition.evaluate(object);
			return result instanceof Boolean && ((Boolean) result).booleanValue();
		}
	}// Matcher
}
