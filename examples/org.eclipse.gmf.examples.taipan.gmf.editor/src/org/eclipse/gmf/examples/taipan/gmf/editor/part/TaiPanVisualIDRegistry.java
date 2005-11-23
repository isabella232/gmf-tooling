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
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

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
		if (TaiPanPackage.eINSTANCE.getAquatory().equals(domainElementMetaclass)
				&& (domainElement != null ? isDiagramAquatory_79((Aquatory) domainElement) : true)) {
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
		int containerVisualID = getVisualID(containerView);
		switch (containerVisualID) {
		case 79:
			if (TaiPanPackage.eINSTANCE.getPort().equals(domainElementMetaclass)
					&& (domainElement != null ? isNodePort_1001((Port) domainElement) : true)) {
				return 1001;
			}
			if (TaiPanPackage.eINSTANCE.getShip().equals(domainElementMetaclass)
					&& (domainElement != null ? isNodeShip_1002((Ship) domainElement) : true)) {
				return 1002;
			}
			return getUnrecognizedDiagramChildID(domainElement);
		case 1001:
			if (TaiPanSemanticHints.Port_1001Labels.LOCATION_TEXT.equals(semanticHint)) {
				return 4001;
			}
			if (!"".equals(semanticHint)) {
				return getUnrecognizedPort_1001ChildNodeID(semanticHint);
			}
			return getUnrecognizedPort_1001ChildNodeID(domainElement);
		case 1002:
			if (TaiPanSemanticHints.Ship_1002Labels.NAME_TEXT.equals(semanticHint)) {
				return 4002;
			}
			if (TaiPanSemanticHints.Ship_1002Compartments.CARGO.equals(semanticHint)) {
				return 5001;
			}
			if (!"".equals(semanticHint)) {
				return getUnrecognizedShip_1002ChildNodeID(semanticHint);
			}
			return getUnrecognizedShip_1002ChildNodeID(domainElement);
		case 5001:
			if (!"".equals(semanticHint)) {
				return getUnrecognizedCargo_5001ChildNodeID(semanticHint);
			}
			if (TaiPanPackage.eINSTANCE.getItem().equals(domainElementMetaclass)
					&& (domainElement != null ? isChildNodeItem_2001((Item) domainElement) : true)) {
				return 2001;
			}
			return getUnrecognizedCargo_5001ChildNodeID(domainElement);
		case 2001:
			if (TaiPanSemanticHints.Item_2001Labels.ARTICLE_TEXT.equals(semanticHint)) {
				return 4003;
			}
			if (!"".equals(semanticHint)) {
				return getUnrecognizedItem_2001ChildNodeID(semanticHint);
			}
			return getUnrecognizedItem_2001ChildNodeID(domainElement);
		case 3001:
			return getUnrecognizedShipDestination_3001LinkLabelID(semanticHint);
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
		{
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
	private boolean isChildNodeItem_2001(Item element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDiagramChildID(EObject domainElement) {
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
	private int getUnrecognizedPort_1001ChildNodeID(String semanticHint) {
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
	private int getUnrecognizedShip_1002ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedCargo_5001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedCargo_5001ChildNodeID(String semanticHint) {
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
	private int getUnrecognizedItem_2001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShipDestination_3001LinkLabelID(String semanticHint) {
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
	 * @generated
	 */
	public int getVisualID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("VisualID");
		if (annotation == null) {
			return -1;
		}
		String visualID = (String) annotation.getDetails().get("value");
		if (visualID == null) {
			return -1;
		}
		try {
			return Integer.parseInt(visualID);
		} catch (NumberFormatException e) {
			e.printStackTrace();
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
		private ElementSelectors() {}

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
