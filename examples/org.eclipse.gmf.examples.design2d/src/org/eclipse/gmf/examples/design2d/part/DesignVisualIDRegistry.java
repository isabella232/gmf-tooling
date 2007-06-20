/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *     Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
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
		return org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry.getVisualID(view.getType());
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
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null || !Design2DEditPart.MODEL_ID.equals(org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry.getModelID(containerView))) {
			return -1;
		}
		switch (org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry.getVisualID(containerView)) {
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry.getModelID(containerView);
		if (!Design2DEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (Design2DEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Design2DEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case SolidRectangleEditPart.VISUAL_ID:
			if (SolidRectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolidEllipseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SolidEllipse2EditPart.VISUAL_ID:
			if (SolidRectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolidEllipseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SolidRectangle2EditPart.VISUAL_ID:
			if (SolidRectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolidEllipseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SolidEllipseEditPart.VISUAL_ID:
			if (SolidRectangle2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolidEllipseEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Design2DEditPart.VISUAL_ID:
			if (SolidRectangleEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SolidEllipse2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SolidLineEditPart.VISUAL_ID:
			if (SolidLineCommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

}
