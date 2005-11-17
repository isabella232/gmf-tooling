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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EAnnotation;

/**
 * @generated
 */
public class TaiPanEditPartFactory implements EditPartFactory {

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
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!"TaiPan".equals(view.getDiagram().getType())) {
				return null;
			}

			int viewVisualID = getVisualID(view);
			switch (viewVisualID) {
			case 79:
				return new AquatoryCanvasEditPart(view);
			case 1001:
				return new PortNodeEditPart(view);
			case 4001:
				return new PortLocationNodeLabelEditPart(view);
			case 1002:
				return new ShipNodeEditPart(view);
			case 4002:
				return new ShipNameNodeLabelEditPart(view);
			case 5001:
				return new ShipNode_cargoCompartmentEditPart(view);
			case 2001:
				return new ItemNodeChildNodeEditPart(view);
			case 4003:
				return new ItemArticleNodeLabelEditPart(view);
			case 3001:
				return new DestinationLinkEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

}
