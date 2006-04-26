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

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItem_articleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Port_locationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_description2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_descriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_nameEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser smallItemsSmallItemsArticleQuantity_4002Parser;

	/**
	 * @generated
	 */
	private IParser getSmallItemsSmallItemsArticleQuantity_4002Parser() {
		if (smallItemsSmallItemsArticleQuantity_4002Parser == null) {
			smallItemsSmallItemsArticleQuantity_4002Parser = createSmallItemsSmallItemsArticleQuantity_4002Parser();
		}
		return smallItemsSmallItemsArticleQuantity_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSmallItemsSmallItemsArticleQuantity_4002Parser() {
		List features = new ArrayList(2);
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		features.add(TaiPanPackage.eINSTANCE.getSmallItems().getEStructuralFeature("quantity"));
		TaiPanStructuralFeaturesParser parser = new TaiPanStructuralFeaturesParser(features);
		parser.setViewPattern("- {0} [{1,number,integer}]");
		parser.setEditPattern("{0} : {1,number,integer}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser largeItemLargeItemArticle_4003Parser;

	/**
	 * @generated
	 */
	private IParser getLargeItemLargeItemArticle_4003Parser() {
		if (largeItemLargeItemArticle_4003Parser == null) {
			largeItemLargeItemArticle_4003Parser = createLargeItemLargeItemArticle_4003Parser();
		}
		return largeItemLargeItemArticle_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLargeItemLargeItemArticle_4003Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portPortLocation_4001Parser;

	/**
	 * @generated
	 */
	private IParser getPortPortLocation_4001Parser() {
		if (portPortLocation_4001Parser == null) {
			portPortLocation_4001Parser = createPortPortLocation_4001Parser();
		}
		return portPortLocation_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPortLocation_4001Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getPort().getEStructuralFeature("location"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shipShipName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getShipShipName_4004Parser() {
		if (shipShipName_4004Parser == null) {
			shipShipName_4004Parser = createShipShipName_4004Parser();
		}
		return shipShipName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipShipName_4004Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getShip().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteDescription_4006Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteDescription_4006Parser() {
		if (routeRouteDescription_4006Parser == null) {
			routeRouteDescription_4006Parser = createRouteRouteDescription_4006Parser();
		}
		return routeRouteDescription_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteDescription_4006Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteReliability_4007Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteReliability_4007Parser() {
		if (routeRouteReliability_4007Parser == null) {
			routeRouteReliability_4007Parser = createRouteRouteReliability_4007Parser();
		}
		return routeRouteReliability_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteReliability_4007Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteDescription_4008Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteDescription_4008Parser() {
		if (routeRouteDescription_4008Parser == null) {
			routeRouteDescription_4008Parser = createRouteRouteDescription_4008Parser();
		}
		return routeRouteDescription_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteDescription_4008Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description"));
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteReliability_4009Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteReliability_4009Parser() {
		if (routeRouteReliability_4009Parser == null) {
			routeRouteReliability_4009Parser = createRouteRouteReliability_4009Parser();
		}
		return routeRouteReliability_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteReliability_4009Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability"));
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, int visualID) {
		if (TaiPanElementTypes.SmallItems_2001 == type) {
			return getSmallItemsSmallItemsArticleQuantity_4002Parser();
		}
		if (TaiPanElementTypes.LargeItem_2002 == type) {
			if (LargeItem_articleEditPart.VISUAL_ID == visualID) {
				return getLargeItemLargeItemArticle_4003Parser();
			}
		}
		if (TaiPanElementTypes.Port_1001 == type) {
			if (Port_locationEditPart.VISUAL_ID == visualID) {
				return getPortPortLocation_4001Parser();
			}
		}
		if (TaiPanElementTypes.Ship_1002 == type) {
			if (Ship_nameEditPart.VISUAL_ID == visualID) {
				return getShipShipName_4004Parser();
			}
		}
		if (TaiPanElementTypes.Route_3002 == type) {
			switch (visualID) {
			case Route_descriptionEditPart.VISUAL_ID: {
				return getRouteRouteDescription_4006Parser();
			}
			case Route_reliabilityEditPart.VISUAL_ID: {
				return getRouteRouteReliability_4007Parser();
			}
			}
		}
		if (TaiPanElementTypes.Route_3003 == type) {
			switch (visualID) {
			case Route_description2EditPart.VISUAL_ID: {
				return getRouteRouteDescription_4008Parser();
			}
			case Route_reliability2EditPart.VISUAL_ID: {
				return getRouteRouteReliability_4009Parser();
			}
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		int visualID = TaiPanVisualIDRegistry.getVisualID((String) hint.getAdapter(String.class));
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type == null) {
			EObject element = (EObject) hint.getAdapter(EObject.class);
			type = ElementTypeRegistry.getInstance().getElementType(element);
		}
		return getParser(type, visualID);
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
