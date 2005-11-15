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
package org.eclipse.gmf.examples.taipan.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.examples.taipan.edit.parts.AquatoryCanvasEditPart;
import org.eclipse.gmf.examples.taipan.edit.parts.ShipNodeEditPart;

/**
 * @generated
 */
public class TaiPanModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		Object editPart = host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof AquatoryCanvasEditPart) {
			List children = new ArrayList();
			children.add(ElementTypes.Port_1001);
			children.add(ElementTypes.Ship_1002);
			return children;
		} else if (editPart instanceof ShipNodeEditPart) {
			List children = new ArrayList();
			children.add(ElementTypes.Item_2001);
			return children;
		}
		return Collections.EMPTY_LIST;
	}
}
