/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Item;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

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

	public static final TaiPanVisualIDRegistry INSTANCE = new TaiPanVisualIDRegistry();

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (TaiPanPackage.eINSTANCE.getAquatory().equals(domainElementMetaclass) && (domainElement != null ? isDiagramAquatory_79((Aquatory) domainElement) : true)) {
			return 79;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement, String semanticHint) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, semanticHint);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!"TaiPan".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if ("TaiPan".equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = 79;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case 1001:
			if (TaiPanSemanticHints.Port_1001Labels.PORTLOCATION_4001_TEXT.equals(semanticHint)) {
				return 4001;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedPort_1001ChildNodeID(semanticHint);
			}
			return getUnrecognizedPort_1001ChildNodeID(domainElement);
		case 1002:
			if (TaiPanSemanticHints.Ship_1002Labels.SHIPNAME_4003_TEXT.equals(semanticHint)) {
				return 4003;
			}
			if (TaiPanSemanticHints.Ship_1002Compartments.CARGOCOMPARTMENT_5001.equals(semanticHint)) {
				return 5001;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedShip_1002ChildNodeID(semanticHint);
			}
			return getUnrecognizedShip_1002ChildNodeID(domainElement);
		case 2001:
			if (TaiPanSemanticHints.Item_2001Labels.ITEMARTICLEQUANTITY_4002_TEXT.equals(semanticHint)) {
				return 4002;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedItem_2001ChildNodeID(semanticHint);
			}
			return getUnrecognizedItem_2001ChildNodeID(domainElement);
		case 5001:
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedCargoCompartment_5001ChildNodeID(semanticHint);
			}
			if (TaiPanPackage.eINSTANCE.getItem().equals(domainElementMetaclass) && (domainElement != null ? isNodeItem_2001((Item) domainElement) : true)) {
				return 2001;
			}
			return getUnrecognizedCargoCompartment_5001ChildNodeID(domainElement);
		case 79:
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedAquatory_79ChildNodeID(semanticHint);
			}
			if (TaiPanPackage.eINSTANCE.getPort().equals(domainElementMetaclass) && (domainElement != null ? isNodePort_1001((Port) domainElement) : true)) {
				return 1001;
			}
			if (TaiPanPackage.eINSTANCE.getShip().equals(domainElementMetaclass) && (domainElement != null ? isNodeShip_1002((Ship) domainElement) : true)) {
				return 1002;
			}
			return getUnrecognizedAquatory_79ChildNodeID(domainElement);
		case 3001:
			if (TaiPanSemanticHints.Route_3001Labels.ROUTEDESCRIPTION_4004_LABEL.equals(semanticHint)) {
				return 4004;
			}
			if (TaiPanSemanticHints.Route_3001Labels.ROUTERELIABILITY_4005_LABEL.equals(semanticHint)) {
				return 4005;
			}
			return getUnrecognizedRoute_3001LinkLabelID(semanticHint);
		case 4004:
			if (TaiPanSemanticHints.Route_3001Labels.ROUTEDESCRIPTION_4004_TEXT.equals(semanticHint)) {
				return 4004;
			}
			return getUnrecognizedRoute_3001LinkLabelTextID(semanticHint);
		case 4005:
			if (TaiPanSemanticHints.Route_3001Labels.ROUTERELIABILITY_4005_TEXT.equals(semanticHint)) {
				return 4005;
			}
			return getUnrecognizedRoute_3001LinkLabelTextID(semanticHint);
		case 3002:
			if (TaiPanSemanticHints.ShipDestination_3002Labels.SHIPDESTINATIONLABEL15275681_4006_LABEL.equals(semanticHint)) {
				return 4006;
			}
			return getUnrecognizedShipDestination_3002LinkLabelID(semanticHint);
		case 4006:
			if (TaiPanSemanticHints.ShipDestination_3002Labels.SHIPDESTINATIONLABEL15275681_4006_TEXT.equals(semanticHint)) {
				return 4006;
			}
			return getUnrecognizedShipDestination_3002LinkLabelTextID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (TaiPanPackage.eINSTANCE.getRoute().equals(domainElementMetaclass) && (domainElement != null ? isLinkWithClassRoute_3001((Route) domainElement) : true)) {
			return 3001;
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
	private boolean isDiagramAquatory_79(Aquatory element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodePort_1001(Port element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeShip_1002(Ship element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeItem_2001(Item element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPort_1001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPort_1001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShip_1002ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShip_1002ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedItem_2001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedItem_2001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedCargoCompartment_5001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedCargoCompartment_5001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedAquatory_79ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedAquatory_79ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedRoute_3001LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedRoute_3001LinkLabelTextID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShipDestination_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShipDestination_3002LinkLabelTextID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassRoute_3001(Route element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * @generated
	 */
	private String getModelID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return null;
		}
		return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private static int getVisualID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return -1;
		}
		String visualID = (String) annotation.getDetails().get("visualID"); //$NON-NLS-1$
		if (visualID == null) {
			return -1;
		}
		try {
			return Integer.parseInt(visualID);
		} catch (NumberFormatException e) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Unable to parse \"visualID\" annotation: " + visualID, e);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	private static class ElementSelectors {

		/**
		 * @generated
		 */
		private ElementSelectors() {
		}

		/**
		 * @generated
		 */
		static class AcceptAllMatcher {

			/**
			 * @generated
			 */
			static final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();

			/**
			 * @generated
			 */
			boolean matches(Object element) {
				return true;
			}
		}

		/**
		 * @generated
		 */
		static AcceptAllMatcher acceptAllMatcher() {
			return AcceptAllMatcher.INSTANCE;
		}
	} // end of ElementSelectors
}
