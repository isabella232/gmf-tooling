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
package org.eclipse.gmf.examples.design2d.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipse2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipseEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineCommentEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangle2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangleEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class DesignVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = DesignDiagramEditorPlugin.getInstance().getBundle().getSymbolicName() + "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (Design2DEditPart.MODEL_ID.equals(view.getType())) {
				return Design2DEditPart.VISUAL_ID;
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
				DesignDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
		if (!Design2DEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (Design2DEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Design2DEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint) : -1;
		switch (containerVisualID) {
		case SolidRectangleEditPart.VISUAL_ID:
			if ((semanticHint == null || SolidRectangle2EditPart.VISUAL_ID == nodeVisualID)) {
				return SolidRectangle2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SolidEllipseEditPart.VISUAL_ID == nodeVisualID)) {
				return SolidEllipseEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_2001ChildNodeID(domainElement, semanticHint);
		case SolidEllipse2EditPart.VISUAL_ID:
			if ((semanticHint == null || SolidRectangle2EditPart.VISUAL_ID == nodeVisualID)) {
				return SolidRectangle2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SolidEllipseEditPart.VISUAL_ID == nodeVisualID)) {
				return SolidEllipseEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_2002ChildNodeID(domainElement, semanticHint);
		case SolidRectangle2EditPart.VISUAL_ID:
			if ((semanticHint == null || SolidRectangle2EditPart.VISUAL_ID == nodeVisualID)) {
				return SolidRectangle2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SolidEllipseEditPart.VISUAL_ID == nodeVisualID)) {
				return SolidEllipseEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_3001ChildNodeID(domainElement, semanticHint);
		case SolidEllipseEditPart.VISUAL_ID:
			if ((semanticHint == null || SolidRectangle2EditPart.VISUAL_ID == nodeVisualID)) {
				return SolidRectangle2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SolidEllipseEditPart.VISUAL_ID == nodeVisualID)) {
				return SolidEllipseEditPart.VISUAL_ID;
			}
			return getUnrecognizedNode_3002ChildNodeID(domainElement, semanticHint);
		case Design2DEditPart.VISUAL_ID:
			if ((semanticHint == null || SolidRectangleEditPart.VISUAL_ID == nodeVisualID)) {
				return SolidRectangleEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || SolidEllipse2EditPart.VISUAL_ID == nodeVisualID)) {
				return SolidEllipse2EditPart.VISUAL_ID;
			}
			return getUnrecognizedDiagram_1000ChildNodeID(domainElement, semanticHint);
		case SolidLineEditPart.VISUAL_ID:
			if (SolidLineCommentEditPart.VISUAL_ID == nodeVisualID) {
				return SolidLineCommentEditPart.VISUAL_ID;
			}
			return getUnrecognizedLink_4001LinkLabelID(semanticHint);
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
		{
			return getUnrecognizedLinkWithClassID(domainElement);
		}
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
	private static int getUnrecognizedNode_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNode_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNode_3001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNode_3002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagram_1000ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLink_4001LinkLabelID(String semanticHint) {
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
}
