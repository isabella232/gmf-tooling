/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanModelingAssistantProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class TaiPanModelingAssistantProviderOfPortEditPart extends TaiPanModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((PortEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(PortEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(TaiPanElementTypes.Route_4002);
		types.add(TaiPanElementTypes.Route_4003);
		types.add(TaiPanElementTypes.PortRegister_4007);
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((PortEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(PortEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof PortEditPart) {
			types.add(TaiPanElementTypes.Route_4002);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(TaiPanElementTypes.Route_4003);
		}
		if (targetEditPart instanceof ShipEditPart) {
			types.add(TaiPanElementTypes.PortRegister_4007);
		}
		if (targetEditPart instanceof WarshipEditPart) {
			types.add(TaiPanElementTypes.PortRegister_4007);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((PortEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(PortEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TaiPanElementTypes.Route_4002) {
			types.add(TaiPanElementTypes.Port_2001);
		} else if (relationshipType == TaiPanElementTypes.Route_4003) {
			types.add(TaiPanElementTypes.Port_2001);
		} else if (relationshipType == TaiPanElementTypes.PortRegister_4007) {
			types.add(TaiPanElementTypes.Ship_2002);
			types.add(TaiPanElementTypes.Warship_2003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((PortEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(PortEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(TaiPanElementTypes.ShipDestination_4001);
		types.add(TaiPanElementTypes.Route_4002);
		types.add(TaiPanElementTypes.Route_4003);
		types.add(TaiPanElementTypes.BesiegePortOrder_4005);
		return types;
	}

	/**
	* @generated
	*/
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((PortEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(PortEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TaiPanElementTypes.ShipDestination_4001) {
			types.add(TaiPanElementTypes.Ship_2002);
			types.add(TaiPanElementTypes.Warship_2003);
		} else if (relationshipType == TaiPanElementTypes.Route_4002) {
			types.add(TaiPanElementTypes.Port_2001);
		} else if (relationshipType == TaiPanElementTypes.Route_4003) {
			types.add(TaiPanElementTypes.Port_2001);
		} else if (relationshipType == TaiPanElementTypes.BesiegePortOrder_4005) {
			types.add(TaiPanElementTypes.Warship_2003);
		}
		return types;
	}

}
