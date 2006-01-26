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
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_CargoCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

/**
 * @generated
 */
public class TaiPanModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		Object editPart = host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof ShipEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.Item_2001);
			return children;
		}
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

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		Object sourceEditPart = source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof PortEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.Route_3002);
			return children;
		}
		if (sourceEditPart instanceof ShipEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.ShipDestination_3001);
			return children;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		Object targetEditPart = target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof PortEditPart) {
			List children = new ArrayList();
			children.add(TaiPanElementTypes.ShipDestination_3001);
			children.add(TaiPanElementTypes.Route_3002);
			return children;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		Object sourceEditPart = source.getAdapter(IGraphicalEditPart.class);
		Object targetEditPart = target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof PortEditPart) {
			List children = new ArrayList();
			if (targetEditPart instanceof PortEditPart) {
				children.add(TaiPanElementTypes.Route_3002);
			}
			return children;
		}
		if (sourceEditPart instanceof ShipEditPart) {
			List children = new ArrayList();
			if (targetEditPart instanceof PortEditPart) {
				children.add(TaiPanElementTypes.ShipDestination_3001);
			}
			return children;
		}
		return Collections.EMPTY_LIST;
	}
}
