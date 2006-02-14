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

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private Map itemITEMARTICLEQUANTITY_4003_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getItemITEMARTICLEQUANTITY_4003_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (itemITEMARTICLEQUANTITY_4003_TEXTParsers == null) {
			itemITEMARTICLEQUANTITY_4003_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) itemITEMARTICLEQUANTITY_4003_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createItemITEMARTICLEQUANTITY_4003_TEXTParser(editingDomain);
			itemITEMARTICLEQUANTITY_4003_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createItemITEMARTICLEQUANTITY_4003_TEXTParser(TransactionalEditingDomain editingDomain) {
		List features = new ArrayList(2);
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("quantity"));
		TaiPanStructuralFeaturesParser parser = new TaiPanStructuralFeaturesParser(features);
		parser.setViewPattern("- {0} [{1,number,integer}]");
		parser.setEditPattern("{0}:{1,number,integer}");
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map portPORTLOCATION_4001_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getPortPORTLOCATION_4001_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (portPORTLOCATION_4001_TEXTParsers == null) {
			portPORTLOCATION_4001_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) portPORTLOCATION_4001_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createPortPORTLOCATION_4001_TEXTParser(editingDomain);
			portPORTLOCATION_4001_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPORTLOCATION_4001_TEXTParser(TransactionalEditingDomain editingDomain) {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getPort().getEStructuralFeature("location"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map shipSHIPNAME_4002_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getShipSHIPNAME_4002_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (shipSHIPNAME_4002_TEXTParsers == null) {
			shipSHIPNAME_4002_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) shipSHIPNAME_4002_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createShipSHIPNAME_4002_TEXTParser(editingDomain);
			shipSHIPNAME_4002_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipSHIPNAME_4002_TEXTParser(TransactionalEditingDomain editingDomain) {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getShip().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map routeROUTEDESCRIPTION_4004_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getRouteROUTEDESCRIPTION_4004_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (routeROUTEDESCRIPTION_4004_TEXTParsers == null) {
			routeROUTEDESCRIPTION_4004_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) routeROUTEDESCRIPTION_4004_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createRouteROUTEDESCRIPTION_4004_TEXTParser(editingDomain);
			routeROUTEDESCRIPTION_4004_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTEDESCRIPTION_4004_TEXTParser(TransactionalEditingDomain editingDomain) {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map routeROUTERELIABILITY_4009_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getRouteROUTERELIABILITY_4009_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (routeROUTERELIABILITY_4009_TEXTParsers == null) {
			routeROUTERELIABILITY_4009_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) routeROUTERELIABILITY_4009_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createRouteROUTERELIABILITY_4009_TEXTParser(editingDomain);
			routeROUTERELIABILITY_4009_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteROUTERELIABILITY_4009_TEXTParser(TransactionalEditingDomain editingDomain) {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		parser.setViewPattern("reliability: {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType, TransactionalEditingDomain editingDomain) {
		if (TaiPanElementTypes.Item_2001 == type) {
			return getItemITEMARTICLEQUANTITY_4003_TEXTParser(editingDomain);
		}
		if (TaiPanElementTypes.Port_1001 == type) {
			if (TaiPanSemanticHints.Port_1001Labels.PORTLOCATION_4001_TEXT.equals(viewType)) {
				return getPortPORTLOCATION_4001_TEXTParser(editingDomain);
			}
		}
		if (TaiPanElementTypes.Ship_1002 == type) {
			if (TaiPanSemanticHints.Ship_1002Labels.SHIPNAME_4002_TEXT.equals(viewType)) {
				return getShipSHIPNAME_4002_TEXTParser(editingDomain);
			}
		}
		if (TaiPanElementTypes.Route_3002 == type) {
			if (TaiPanSemanticHints.Route_3002Labels.ROUTEDESCRIPTION_4004_TEXT.equals(viewType)) {
				return getRouteROUTEDESCRIPTION_4004_TEXTParser(editingDomain);
			}
			if (TaiPanSemanticHints.Route_3002Labels.ROUTERELIABILITY_4009_TEXT.equals(viewType)) {
				return getRouteROUTERELIABILITY_4009_TEXTParser(editingDomain);
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
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) hint.getAdapter(TransactionalEditingDomain.class);
		return getParser(type, viewType, editingDomain);
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
