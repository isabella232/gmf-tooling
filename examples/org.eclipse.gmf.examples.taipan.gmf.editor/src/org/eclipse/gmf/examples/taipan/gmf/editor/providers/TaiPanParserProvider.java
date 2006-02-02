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
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser itemITEMARTICLEQUANTITY_4003_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getItemITEMARTICLEQUANTITY_4003_TEXTParser() {
		if (itemITEMARTICLEQUANTITY_4003_TEXTParser == null) {
			itemITEMARTICLEQUANTITY_4003_TEXTParser = createItemITEMARTICLEQUANTITY_4003_TEXTParser();
		}
		return itemITEMARTICLEQUANTITY_4003_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createItemITEMARTICLEQUANTITY_4003_TEXTParser() {
		List features = new ArrayList(2);
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("quantity"));
		TaiPanStructuralFeaturesParser parser = new TaiPanStructuralFeaturesParser(features);
		((TaiPanStructuralFeaturesParser) parser).setViewPattern("- {0} [{1,number,integer}]");
		((TaiPanStructuralFeaturesParser) parser).setEditPattern("{0}:{1,number,integer}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portPORTLOCATION_4001_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getPortPORTLOCATION_4001_TEXTParser() {
		if (portPORTLOCATION_4001_TEXTParser == null) {
			portPORTLOCATION_4001_TEXTParser = createPortPORTLOCATION_4001_TEXTParser();
		}
		return portPORTLOCATION_4001_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPORTLOCATION_4001_TEXTParser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getPort().getEStructuralFeature("location"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shipSHIPNAME_4002_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getShipSHIPNAME_4002_TEXTParser() {
		if (shipSHIPNAME_4002_TEXTParser == null) {
			shipSHIPNAME_4002_TEXTParser = createShipSHIPNAME_4002_TEXTParser();
		}
		return shipSHIPNAME_4002_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipSHIPNAME_4002_TEXTParser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getShip().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTEDESCRIPTION_4004_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTEDESCRIPTION_4004_TEXTParser() {
		if (routeROUTEDESCRIPTION_4004_TEXTParser == null) {
			routeROUTEDESCRIPTION_4004_TEXTParser = createRouteROUTEDESCRIPTION_4004_TEXTParser();
		}
		return routeROUTEDESCRIPTION_4004_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTEDESCRIPTION_4004_TEXTParser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeROUTERELIABILITY_4009_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getRouteROUTERELIABILITY_4009_TEXTParser() {
		if (routeROUTERELIABILITY_4009_TEXTParser == null) {
			routeROUTERELIABILITY_4009_TEXTParser = createRouteROUTERELIABILITY_4009_TEXTParser();
		}
		return routeROUTERELIABILITY_4009_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTERELIABILITY_4009_TEXTParser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		((TaiPanStructuralFeatureParser) parser).setViewPattern("reliability: {0,number,percent}");
		((TaiPanStructuralFeatureParser) parser).setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(EObject element, String viewType) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
		if (TaiPanElementTypes.Item_2001 == type) {
			return getItemITEMARTICLEQUANTITY_4003_TEXTParser();
		}
		if (TaiPanElementTypes.Port_1001 == type) {
			if (TaiPanSemanticHints.Port_1001Labels.PORTLOCATION_4001_TEXT.equals(viewType)) {
				return getPortPORTLOCATION_4001_TEXTParser();
			}
		}
		if (TaiPanElementTypes.Ship_1002 == type) {
			if (TaiPanSemanticHints.Ship_1002Labels.SHIPNAME_4002_TEXT.equals(viewType)) {
				return getShipSHIPNAME_4002_TEXTParser();
			}
		}
		if (TaiPanElementTypes.Route_3002 == type) {
			if (TaiPanSemanticHints.Route_3002Labels.ROUTEDESCRIPTION_4004_TEXT.equals(viewType)) {
				return getRouteROUTEDESCRIPTION_4004_TEXTParser();
			}
			if (TaiPanSemanticHints.Route_3002Labels.ROUTERELIABILITY_4009_TEXT.equals(viewType)) {
				return getRouteROUTERELIABILITY_4009_TEXTParser();
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String viewType = (String) hint.getAdapter(String.class);
		EObject element = (EObject) hint.getAdapter(EObject.class);
		return getParser(element, viewType);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			String viewType = (String) hint.getAdapter(String.class);
			EObject element = (EObject) hint.getAdapter(EObject.class);
			return getParser(element, viewType) != null;
		}
		return false;
	}
}
