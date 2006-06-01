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
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItem_articleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItem_weightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Port_locationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_description2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_descriptionEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliability2EditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Route_reliabilityEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.Ship_nameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser smallItemsSmallItems_3001Parser;

	/**
	 * @generated
	 */
	private IParser getSmallItemsSmallItems_3001Parser() {
		if (smallItemsSmallItems_3001Parser == null) {
			smallItemsSmallItems_3001Parser = createSmallItemsSmallItems_3001Parser();
		}
		return smallItemsSmallItems_3001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSmallItemsSmallItems_3001Parser() {
		List features = new ArrayList(2);
		features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article")); //$NON-NLS-1$
		features.add(TaiPanPackage.eINSTANCE.getSmallItems().getEStructuralFeature("quantity")); //$NON-NLS-1$
		TaiPanStructuralFeaturesParser parser = new TaiPanStructuralFeaturesParser(features);
		parser.setViewPattern("- {0} [{1,number,integer}]");
		parser.setEditPattern("{0} : {1,number,integer}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser largeItemLargeItemArticle_5002Parser;

	/**
	 * @generated
	 */
	private IParser getLargeItemLargeItemArticle_5002Parser() {
		if (largeItemLargeItemArticle_5002Parser == null) {
			largeItemLargeItemArticle_5002Parser = createLargeItemLargeItemArticle_5002Parser();
		}
		return largeItemLargeItemArticle_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLargeItemLargeItemArticle_5002Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser largeItemLargeItemWeight_5003Parser;

	/**
	 * @generated
	 */
	private IParser getLargeItemLargeItemWeight_5003Parser() {
		if (largeItemLargeItemWeight_5003Parser == null) {
			largeItemLargeItemWeight_5003Parser = createLargeItemLargeItemWeight_5003Parser();
		}
		return largeItemLargeItemWeight_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLargeItemLargeItemWeight_5003Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getLargeItem().getEStructuralFeature("weight")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portPortLocation_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPortPortLocation_5001Parser() {
		if (portPortLocation_5001Parser == null) {
			portPortLocation_5001Parser = createPortPortLocation_5001Parser();
		}
		return portPortLocation_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPortLocation_5001Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getPort().getEStructuralFeature("location")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shipShipName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getShipShipName_5004Parser() {
		if (shipShipName_5004Parser == null) {
			shipShipName_5004Parser = createShipShipName_5004Parser();
		}
		return shipShipName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipShipName_5004Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getShip().getEStructuralFeature("name")); //$NON-NLS-1$
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteDescription_6002Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteDescription_6002Parser() {
		if (routeRouteDescription_6002Parser == null) {
			routeRouteDescription_6002Parser = createRouteRouteDescription_6002Parser();
		}
		return routeRouteDescription_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteDescription_6002Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description")); //$NON-NLS-1$
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteReliability_6003Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteReliability_6003Parser() {
		if (routeRouteReliability_6003Parser == null) {
			routeRouteReliability_6003Parser = createRouteRouteReliability_6003Parser();
		}
		return routeRouteReliability_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteReliability_6003Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability")); //$NON-NLS-1$
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteDescription_6004Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteDescription_6004Parser() {
		if (routeRouteDescription_6004Parser == null) {
			routeRouteDescription_6004Parser = createRouteRouteDescription_6004Parser();
		}
		return routeRouteDescription_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteDescription_6004Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("description")); //$NON-NLS-1$
		parser.setViewPattern("route : {0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeRouteReliability_6005Parser;

	/**
	 * @generated
	 */
	private IParser getRouteRouteReliability_6005Parser() {
		if (routeRouteReliability_6005Parser == null) {
			routeRouteReliability_6005Parser = createRouteRouteReliability_6005Parser();
		}
		return routeRouteReliability_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteRouteReliability_6005Parser() {
		TaiPanStructuralFeatureParser parser = new TaiPanStructuralFeatureParser(TaiPanPackage.eINSTANCE.getRoute().getEStructuralFeature("reliability")); //$NON-NLS-1$
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItemsSmallItems_3001Parser();
		case LargeItem_articleEditPart.VISUAL_ID:
			return getLargeItemLargeItemArticle_5002Parser();
		case LargeItem_weightEditPart.VISUAL_ID:
			return getLargeItemLargeItemWeight_5003Parser();
		case Port_locationEditPart.VISUAL_ID:
			return getPortPortLocation_5001Parser();
		case Ship_nameEditPart.VISUAL_ID:
			return getShipShipName_5004Parser();
		case Route_descriptionEditPart.VISUAL_ID:
			return getRouteRouteDescription_6002Parser();
		case Route_reliabilityEditPart.VISUAL_ID:
			return getRouteRouteReliability_6003Parser();
		case Route_description2EditPart.VISUAL_ID:
			return getRouteRouteDescription_6004Parser();
		case Route_reliability2EditPart.VISUAL_ID:
			return getRouteRouteReliability_6005Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(TaiPanVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(TaiPanVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (TaiPanElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}
