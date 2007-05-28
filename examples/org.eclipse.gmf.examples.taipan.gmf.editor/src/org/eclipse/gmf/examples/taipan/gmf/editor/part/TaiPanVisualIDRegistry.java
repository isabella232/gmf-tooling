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
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
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
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipLargeCargoEditPart;
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
	private static final TaiPanAbstractExpression Ship_2002_Constraint = TaiPanOCLFactory.getExpression("not oclIsKindOf(taipan::Warship)", TaiPanPackage.eINSTANCE.getShip());

	/**
	 * @generated
	 */
	private static final TaiPanAbstractExpression Route_4002_Constraint = TaiPanOCLFactory.getExpression("reliability >= 0.5", TaiPanPackage.eINSTANCE.getRoute());

	/**
	 * @generated
	 */
	private static final TaiPanAbstractExpression Route_4003_Constraint = TaiPanOCLFactory.getExpression("reliability < 0.5", TaiPanPackage.eINSTANCE.getRoute());

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
		if (TaiPanPackage.eINSTANCE.getAquatory().isSuperTypeOf(domainElementMetaclass) && isDiagram((Aquatory) domainElement)) {
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
		String containerModelID = org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry.getModelID(containerView);
		if (!AquatoryEditPart.MODEL_ID.equals(containerModelID) && !"TaiPan".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (AquatoryEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = 1000;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry.getVisualID(semanticHint) : -1;
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
			if (WarshipLargeCargoEditPart.VISUAL_ID == nodeVisualID) {
				return WarshipLargeCargoEditPart.VISUAL_ID;
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
			if ((semanticHint == null || SmallItemsEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getSmallItems().isSuperTypeOf(domainElementMetaclass)) {
				return SmallItemsEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipSmallCargo_7001ChildNodeID(domainElement, semanticHint);
		case ShipLargeCargoEditPart.VISUAL_ID:
			if ((semanticHint == null || LargeItemEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getLargeItem().isSuperTypeOf(domainElementMetaclass)) {
				return LargeItemEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EmptyBoxEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getEmptyBox().isSuperTypeOf(domainElementMetaclass)) {
				return EmptyBoxEditPart.VISUAL_ID;
			}
			return getUnrecognizedShipLargeCargo_7002ChildNodeID(domainElement, semanticHint);
		case WarshipLargeCargoEditPart.VISUAL_ID:
			if ((semanticHint == null || LargeItemEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getLargeItem().isSuperTypeOf(domainElementMetaclass)) {
				return LargeItemEditPart.VISUAL_ID;
			}
			return getUnrecognizedWarshipLargeCargo_7003ChildNodeID(domainElement, semanticHint);
		case AquatoryEditPart.VISUAL_ID:
			if ((semanticHint == null || PortEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getPort().isSuperTypeOf(domainElementMetaclass)) {
				return PortEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || ShipEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getShip().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || evaluate(Ship_2002_Constraint, domainElement))) {
				return ShipEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || WarshipEditPart.VISUAL_ID == nodeVisualID) && TaiPanPackage.eINSTANCE.getWarship().isSuperTypeOf(domainElementMetaclass)) {
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
		return getUnrecognizedNodeID(containerView, domainElement);
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
		if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || evaluate(Route_4002_Constraint, domainElement))) {
			return ReliableRouteEditPart.VISUAL_ID;
		}
		if (TaiPanPackage.eINSTANCE.getRoute().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || evaluate(Route_4003_Constraint, domainElement))) {
			return UnreliableRouteEditPart.VISUAL_ID;
		}
		if (TaiPanPackage.eINSTANCE.getEscortShipsOrder().isSuperTypeOf(domainElementMetaclass)) {
			return EscortShipsOrderEditPart.VISUAL_ID;
		}
		if (TaiPanPackage.eINSTANCE.getBesiegePortOrder().isSuperTypeOf(domainElementMetaclass)) {
			return BesiegePortOrderEditPart.VISUAL_ID;
		}
		return getUnrecognizedLinkWithClassID(domainElement);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Aquatory element) {
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
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedNodeID(View containerView, EObject domainElement) {
		return -1;
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
	private static int getUnrecognizedWarshipLargeCargo_7003ChildNodeID(EObject domainElement, String semanticHint) {
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
	 * @generated
	 */
	private static boolean evaluate(TaiPanAbstractExpression expression, Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static class JavaConstraints {

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
}
