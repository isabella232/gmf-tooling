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
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_CargoCompartmentEditPart;

/**
 * @generated
 */
public class TaiPanModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		Object editPart = host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof Ship_CargoCompartmentEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.Item_2001);
			return children;
		}
		if (editPart instanceof AquatoryEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.Port_1001);
			children.add(TaiPanElementTypes.Ship_1002);
			return children;
		}
		return Collections.EMPTY_LIST;
	}
}
