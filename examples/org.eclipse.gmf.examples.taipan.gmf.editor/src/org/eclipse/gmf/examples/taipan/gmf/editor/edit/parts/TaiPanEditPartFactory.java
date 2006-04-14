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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class TaiPanEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!AquatoryEditPart.MODEL_ID.equals(TaiPanVisualIDRegistry.getModelID(view))) {
				return null;
			}

			int viewVisualID = TaiPanVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case 1001:
				return new PortEditPart(view);
			case 4001:
				return new Port_locationEditPart(view);
			case 1002:
				return new ShipEditPart(view);
			case 4003:
				return new Ship_nameEditPart(view);
			case 2001:
				return new ItemEditPart(view);
			case 5001:
				return new Ship_CargoCompartmentEditPart(view);
			case 79:
				return new AquatoryEditPart(view);
			case 3001:
				return new DestinationEditPart(view);
			case 4004:
				return new Destination_UnknownEditPart(view);
			case 3002:
				return new RouteEditPart(view);
			case 4005:
				return new Route_descriptionEditPart(view);
			case 4006:
				return new Route_reliabilityEditPart(view);
			case 3003:
				return new Route2EditPart(view);
			case 4007:
				return new Route_description2EditPart(view);
			case 4008:
				return new Route_reliability2EditPart(view);
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
