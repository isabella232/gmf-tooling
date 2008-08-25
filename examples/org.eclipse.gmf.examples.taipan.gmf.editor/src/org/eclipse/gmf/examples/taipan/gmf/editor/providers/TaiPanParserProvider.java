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
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemArticleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemWeightEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortLocationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteRelbEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteRelbEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.parsers.CompositeParser;
import org.eclipse.gmf.examples.taipan.gmf.editor.parsers.MessageFormatParser;
import org.eclipse.gmf.examples.taipan.gmf.editor.parsers.NativeParser;
import org.eclipse.gmf.examples.taipan.gmf.editor.parsers.PrintfParser;
import org.eclipse.gmf.examples.taipan.gmf.editor.parsers.RegexpParser;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TaiPanParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser portLocation_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPortLocation_5001Parser() {
		if (portLocation_5001Parser == null) {
			portLocation_5001Parser = createPortLocation_5001Parser();
		}
		return portLocation_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortLocation_5001Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getPort_Location(), };
		NativeParser parser = new NativeParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser shipName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getShipName_5004Parser() {
		if (shipName_5004Parser == null) {
			shipName_5004Parser = createShipName_5004Parser();
		}
		return shipName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createShipName_5004Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getShip_Name(), };
		NativeParser parser = new NativeParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser warshipName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getWarshipName_5005Parser() {
		if (warshipName_5005Parser == null) {
			warshipName_5005Parser = createWarshipName_5005Parser();
		}
		return warshipName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createWarshipName_5005Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getShip_Name(), };
		NativeParser parser = new NativeParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser smallItems_3001Parser;

	/**
	 * @generated
	 */
	private IParser getSmallItems_3001Parser() {
		if (smallItems_3001Parser == null) {
			smallItems_3001Parser = createSmallItems_3001Parser();
		}
		return smallItems_3001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSmallItems_3001Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getItem_Article(), TaiPanPackage.eINSTANCE.getSmallItems_Quantity(), };
		PrintfParser reader = new PrintfParser(features);
		reader.setViewPattern("- %1$s [%2$d]");
		reader.setEditorPattern("%1$s:%2$s");
		RegexpParser writer = new RegexpParser(features);
		writer.setEditPattern(":");
		return new CompositeParser(reader, writer);
	}

	/**
	 * @generated
	 */
	private IParser largeItemArticle_5002Parser;

	/**
	 * @generated
	 */
	private IParser getLargeItemArticle_5002Parser() {
		if (largeItemArticle_5002Parser == null) {
			largeItemArticle_5002Parser = createLargeItemArticle_5002Parser();
		}
		return largeItemArticle_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLargeItemArticle_5002Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getItem_Article(), };
		NativeParser parser = new NativeParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser largeItemWeight_5003Parser;

	/**
	 * @generated
	 */
	private IParser getLargeItemWeight_5003Parser() {
		if (largeItemWeight_5003Parser == null) {
			largeItemWeight_5003Parser = createLargeItemWeight_5003Parser();
		}
		return largeItemWeight_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLargeItemWeight_5003Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getLargeItem_Weight(), };
		NativeParser parser = new NativeParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeDescription_6002Parser;

	/**
	 * @generated
	 */
	private IParser getRouteDescription_6002Parser() {
		if (routeDescription_6002Parser == null) {
			routeDescription_6002Parser = createRouteDescription_6002Parser();
		}
		return routeDescription_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteDescription_6002Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getRoute_Description(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("route : {0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeReliability_6003Parser;

	/**
	 * @generated
	 */
	private IParser getRouteReliability_6003Parser() {
		if (routeReliability_6003Parser == null) {
			routeReliability_6003Parser = createRouteReliability_6003Parser();
		}
		return routeReliability_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteReliability_6003Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getRoute_Reliability(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditorPattern("{0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeDescription_6004Parser;

	/**
	 * @generated
	 */
	private IParser getRouteDescription_6004Parser() {
		if (routeDescription_6004Parser == null) {
			routeDescription_6004Parser = createRouteDescription_6004Parser();
		}
		return routeDescription_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteDescription_6004Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getRoute_Description(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("route : {0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser routeReliability_6005Parser;

	/**
	 * @generated
	 */
	private IParser getRouteReliability_6005Parser() {
		if (routeReliability_6005Parser == null) {
			routeReliability_6005Parser = createRouteReliability_6005Parser();
		}
		return routeReliability_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createRouteReliability_6005Parser() {
		EAttribute[] features = new EAttribute[] { TaiPanPackage.eINSTANCE.getRoute_Reliability(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("reliability : {0,number,percent}");
		parser.setEditorPattern("{0,number,percent}");
		parser.setEditPattern("{0,number,percent}");
		return parser;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PortLocationEditPart.VISUAL_ID:
			return getPortLocation_5001Parser();
		case ShipNameEditPart.VISUAL_ID:
			return getShipName_5004Parser();
		case WarshipNameEditPart.VISUAL_ID:
			return getWarshipName_5005Parser();
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001Parser();
		case LargeItemArticleEditPart.VISUAL_ID:
			return getLargeItemArticle_5002Parser();
		case LargeItemWeightEditPart.VISUAL_ID:
			return getLargeItemWeight_5003Parser();
		case ReliableRouteDescEditPart.VISUAL_ID:
			return getRouteDescription_6002Parser();
		case ReliableRouteRelbEditPart.VISUAL_ID:
			return getRouteReliability_6003Parser();
		case UnreliableRouteDescEditPart.VISUAL_ID:
			return getRouteDescription_6004Parser();
		case UnreliableRouteRelbEditPart.VISUAL_ID:
			return getRouteReliability_6005Parser();
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

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
