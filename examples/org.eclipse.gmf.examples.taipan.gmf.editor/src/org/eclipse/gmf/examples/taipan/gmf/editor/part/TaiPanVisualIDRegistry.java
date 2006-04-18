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

import org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Item;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Destination_UnknownEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Port_locationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_description2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_descriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_CargoCompartmentEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_nameEditPart;

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
	public static final TaiPanVisualIDRegistry INSTANCE = new TaiPanVisualIDRegistry();

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (AquatoryEditPart.MODEL_ID.equals(view.getType())) {
				return 79;
			} else {
				return -1;
			}
		}
		try {
			return Integer.parseInt(view.getType());
		} catch (NumberFormatException e) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + view.getType(), e);
		}
		return -1;
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
		if (TaiPanPackage.eINSTANCE.getAquatory().equals(domainElementMetaclass) && (domainElement == null || isDiagramAquatory_79((Aquatory) domainElement))) {
			return 79;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!AquatoryEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (AquatoryEditPart.MODEL_ID.equals(containerModelID)) {
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
			if (Port_locationEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4001;
			}
			return getUnrecognizedPort_1001ChildNodeID(domainElement, semanticHint);
		case 1002:
			if (Ship_nameEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4003;
			}
			if (Ship_CargoCompartmentEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5001;
			}
			return getUnrecognizedShip_1002ChildNodeID(domainElement, semanticHint);
		case 2001:
			return getUnrecognizedItem_2001ChildNodeID(domainElement, semanticHint);
		case 5001:
			if ((semanticHint == null || ItemEditPart.VISUAL_ID.equals(semanticHint)) && TaiPanPackage.eINSTANCE.getItem().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeItem_2001((Item) domainElement))) {
				return 2001;
			}
			return getUnrecognizedCargoCompartment_5001ChildNodeID(domainElement, semanticHint);
		case 79:
			if ((semanticHint == null || PortEditPart.VISUAL_ID.equals(semanticHint)) && TaiPanPackage.eINSTANCE.getPort().equals(domainElementMetaclass)
					&& (domainElement == null || isNodePort_1001((Port) domainElement))) {
				return 1001;
			}
			if ((semanticHint == null || ShipEditPart.VISUAL_ID.equals(semanticHint)) && TaiPanPackage.eINSTANCE.getShip().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeShip_1002((Ship) domainElement))) {
				return 1002;
			}
			return getUnrecognizedAquatory_79ChildNodeID(domainElement, semanticHint);
		case 3001:
			if (Destination_UnknownEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4004;
			}
			return getUnrecognizedShipDestination_3001LinkLabelID(semanticHint);
		case 3002:
			if (Route_descriptionEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4005;
			}
			if (Route_reliabilityEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4006;
			}
			return getUnrecognizedRoute_3002LinkLabelID(semanticHint);
		case 3003:
			if (Route_description2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4007;
			}
			if (Route_reliability2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4008;
			}
			return getUnrecognizedRoute_3003LinkLabelID(semanticHint);
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
		if (TaiPanPackage.eINSTANCE.getRoute().equals(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_3002((Route) domainElement))) {
			return 3002;
		} else if (TaiPanPackage.eINSTANCE.getRoute().equals(domainElementMetaclass) && (domainElement == null || isLinkWithClassRoute_3003((Route) domainElement))) {
			return 3003;
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
	private int getUnrecognizedPort_1001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedShip_1002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedItem_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedCargoCompartment_5001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedAquatory_79ChildNodeID(EObject domainElement, String semanticHint) {
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
	private int getUnrecognizedRoute_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedRoute_3003LinkLabelID(String semanticHint) {
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
	private boolean isLinkWithClassRoute_3002(Route element) {
		return ElementSelectors.Route_3002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassRoute_3003(Route element) {
		return ElementSelectors.Route_3003.matches(element);
	}

	/**
	 * @generated
	 */
	private static class ElementSelectors {

		/**
		 * Element matching condition for Route_3002.
		 * <pre>language: ocl</pre>	
		 * <pre>body    : reliability >= 0.5</pre>
		 * @generated
		 */
		private static final Matcher Route_3002 = new Matcher("reliability >= 0.5");

		/**
		 * Element matching condition for Route_3003.
		 * <pre>language: ocl</pre>	
		 * <pre>body    : reliability < 0.5</pre>
		 * @generated
		 */
		private static final Matcher Route_3003 = new Matcher("reliability < 0.5");

		/**
		 * @generated
		 */
		private ElementSelectors() {
		}

		/**
		 * @generated	
		 */
		static class Matcher {

			/**
			 * @generated	
			 */
			private EClass evalContext;

			/**
			 * @generated	
			 */
			private OCLConstraintCondition condition;

			/**
			 * @generated	
			 */
			private String body;

			/**
			 * @generated	
			 */
			Matcher(String expressionBody) {
				body = expressionBody;
			}

			/**
			 * @generated	
			 */
			boolean matches(EObject object) {
				try {
					Boolean result = (object != null) ? evaluate(object) : Boolean.FALSE;
					return result.booleanValue();
				} catch (IllegalArgumentException e) {
					TaiPanDiagramEditorPlugin.getInstance().logError(null, e);
					return false;
				}
			}

			/**
			 * @generated	
			 */
			private Boolean evaluate(EObject context) {
				this.evalContext = context.eClass();
				if (condition == null) {
					condition = new OCLConstraintCondition(body, evalContext);
				}
				if (condition != null) {
					return booleanCast(condition.evaluate(context));
				}
				return Boolean.FALSE;
			}

			/**
			 * @generated	
			 */
			private static Boolean booleanCast(Object value) {
				if (value == null) {
					return null;
				} else if (value instanceof Boolean) {
					return (Boolean) value;
				}
				return Boolean.FALSE;
			}
		} // end of Matcher		

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
