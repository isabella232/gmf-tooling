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
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Port_locationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_description2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_descriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_nameEditPart;

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser itemITEMARTICLEQUANTITY_4002Parser;

	/**
	 * @generated
	 */
	private IParser getItemITEMARTICLEQUANTITY_4002Parser() {
		if (itemITEMARTICLEQUANTITY_4002Parser == null) {
			itemITEMARTICLEQUANTITY_4002Parser = createItemITEMARTICLEQUANTITY_4002Parser();
		}
		return itemITEMARTICLEQUANTITY_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createItemITEMARTICLEQUANTITY_4002Parser() {
		List features = new ArrayList(2);
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("quantity"));
		TaiPanStructuralFeaturesParser parser = new TaiPanStructuralFeaturesParser(features);
		parser.setViewPattern("- {0} [{1,number,integer}]");
		parser.setEditPattern("{0} : {1,number,integer}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portPORTLOCATION_4001Parser;

	/**
	 * @generated
	 */
	private IParser getPortPORTLOCATION_4001Parser() {
		if (portPORTLOCATION_4001Parser == null) {
			portPORTLOCATION_4001Parser = createPortPORTLOCATION_4001Parser();
		}
		return portPORTLOCATION_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPORTLOCATION_4001Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getPort().getEStructuralFeature("location"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shipSHIPNAME_4003Parser;

	/**
	 * @generated
	 */
	private IParser getShipSHIPNAME_4003Parser() {
		if (shipSHIPNAME_4003Parser == null) {
			shipSHIPNAME_4003Parser = createShipSHIPNAME_4003Parser();
		}
		return shipSHIPNAME_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipSHIPNAME_4003Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getShip().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTEDESCRIPTION_4005Parser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTEDESCRIPTION_4005Parser() {
		if (routeROUTEDESCRIPTION_4005Parser == null) {
			routeROUTEDESCRIPTION_4005Parser = createRouteROUTEDESCRIPTION_4005Parser();
		}
		return routeROUTEDESCRIPTION_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTEDESCRIPTION_4005Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTERELIABILITY_4006Parser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTERELIABILITY_4006Parser() {
		if (routeROUTERELIABILITY_4006Parser == null) {
			routeROUTERELIABILITY_4006Parser = createRouteROUTERELIABILITY_4006Parser();
		}
		return routeROUTERELIABILITY_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTERELIABILITY_4006Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTEDESCRIPTION_4007Parser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTEDESCRIPTION_4007Parser() {
		if (routeROUTEDESCRIPTION_4007Parser == null) {
			routeROUTEDESCRIPTION_4007Parser = createRouteROUTEDESCRIPTION_4007Parser();
		}
		return routeROUTEDESCRIPTION_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTEDESCRIPTION_4007Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTERELIABILITY_4008Parser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTERELIABILITY_4008Parser() {
		if (routeROUTERELIABILITY_4008Parser == null) {
			routeROUTERELIABILITY_4008Parser = createRouteROUTERELIABILITY_4008Parser();
		}
		return routeROUTERELIABILITY_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTERELIABILITY_4008Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (TaiPanElementTypes.Item_2001 == type) {
			return getItemITEMARTICLEQUANTITY_4002Parser();
		}
		if (TaiPanElementTypes.Port_1001 == type) {
			if (Port_locationEditPart.VISUAL_ID.equals(viewType)) {
				return getPortPORTLOCATION_4001Parser();
			}
		}
		if (TaiPanElementTypes.Ship_1002 == type) {
			if (Ship_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getShipSHIPNAME_4003Parser();
			}
		}
		if (TaiPanElementTypes.Route_3002 == type) {
			if (Route_descriptionEditPart.VISUAL_ID.equals(viewType)) {
				return getRouteROUTEDESCRIPTION_4005Parser();
			}
			if (Route_reliabilityEditPart.VISUAL_ID.equals(viewType)) {
				return getRouteROUTERELIABILITY_4006Parser();
			}
		}
		if (TaiPanElementTypes.Route_3003 == type) {
			if (Route_description2EditPart.VISUAL_ID.equals(viewType)) {
				return getRouteROUTEDESCRIPTION_4007Parser();
			}
			if (Route_reliability2EditPart.VISUAL_ID.equals(viewType)) {
				return getRouteROUTERELIABILITY_4008Parser();
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String viewType = (String) hint.getAdapter(String.class);
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type == null) {
			EObject element = (EObject) hint.getAdapter(EObject.class);
			type = ElementTypeRegistry.getInstance().getElementType(element);
		}
		return getParser(type, viewType);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			return getParser(((GetParserOperation) operation).getHint()) != null;
		}
		return false;
	}
}
