/*
 * Copyright (c) 2005 Borland Software Corporation
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

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

/**
 * @generated
 */
public class Destination_UnknownEditPart extends LabelEditPart {

	/**
	 * @generated
	 */
	static {
		registerSnapBackPosition(TaiPanSemanticHints.ShipDestination_3001Labels.SHIPDESTINATIONUNKNOWN_4004_LABEL, new Point(0, 0));
	}

	/**
	 * @generated
	 */
	public Destination_UnknownEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public int getKeyPoint() {
		return ConnectionLocator.MIDDLE;
	}
}
