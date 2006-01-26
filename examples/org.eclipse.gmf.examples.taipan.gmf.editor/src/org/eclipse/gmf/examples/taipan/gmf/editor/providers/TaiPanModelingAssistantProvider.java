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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

/**
 * @generated
 */
public class TaiPanModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof ShipEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.Item_2001);
			return types;
		}
		if (editPart instanceof Ship_CargoCompartmentEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.Item_2001);
			return types;
		}
		if (editPart instanceof AquatoryEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.Port_1001);
			types.add(TaiPanElementTypes.Ship_1002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ShipEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.ShipDestination_3001);
			return types;
		}
		if (sourceEditPart instanceof PortEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.Route_3002);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof PortEditPart) {
			List types = new ArrayList();
			types.add(TaiPanElementTypes.Route_3002);
			types.add(TaiPanElementTypes.ShipDestination_3001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ShipEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof PortEditPart) {
				types.add(TaiPanElementTypes.ShipDestination_3001);
			}
			return types;
		}
		if (sourceEditPart instanceof PortEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof PortEditPart) {
				types.add(TaiPanElementTypes.Route_3002);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof PortEditPart) {
			List types = new ArrayList();
			if (relationshipType == TaiPanElementTypes.Route_3002) {
				types.add(TaiPanElementTypes.Port_1001);
			}
			if (relationshipType == TaiPanElementTypes.ShipDestination_3001) {
				types.add(TaiPanElementTypes.Ship_1002);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ShipEditPart) {
			List types = new ArrayList();
			if (relationshipType == TaiPanElementTypes.ShipDestination_3001) {
				types.add(TaiPanElementTypes.Port_1001);
			}
			return types;
		}
		if (sourceEditPart instanceof PortEditPart) {
			List types = new ArrayList();
			if (relationshipType == TaiPanElementTypes.Route_3002) {
				types.add(TaiPanElementTypes.Port_1001);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}
}
