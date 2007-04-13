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
package org.eclipse.gmf.examples.taipan.gmf.editor.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Item;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.BesiegePortOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EmptyBoxEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.EscortShipsOrderEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemArticleEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.LargeItemEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortLocationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.PortRegisterEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ReliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipDestinationEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.ShipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.SmallItemsEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteDescEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.UnreliableRouteEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.WarshipNameEditPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class TaiPanNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		TaiPanDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		TaiPanDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		TaiPanDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof TaiPanNavigatorItem && !isOwnView(((TaiPanNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof TaiPanNavigatorGroup) {
			TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) element;
			return TaiPanDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof TaiPanNavigatorItem) {
			TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/taipan?Port", TaiPanElementTypes.Port_2001);
		case ShipEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/taipan?Ship", TaiPanElementTypes.Ship_2002);
		case WarshipEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/taipan?Warship", TaiPanElementTypes.Warship_2003);
		case SmallItemsEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/examples/gmf/taipan?SmallItems", TaiPanElementTypes.SmallItems_3001);
		case LargeItemEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/examples/gmf/taipan?LargeItem", TaiPanElementTypes.LargeItem_3002);
		case EmptyBoxEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/examples/gmf/taipan?EmptyBox", TaiPanElementTypes.EmptyBox_3003);
		case AquatoryEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/examples/gmf/taipan?Aquatory", TaiPanElementTypes.Aquatory_1);
		case ShipDestinationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?Ship?destination", TaiPanElementTypes.ShipDestination_4001);
		case ReliableRouteEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?Route", TaiPanElementTypes.Route_4002);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?Route", TaiPanElementTypes.Route_4003);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?EscortShipsOrder", TaiPanElementTypes.EscortShipsOrder_4006);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?BesiegePortOrder", TaiPanElementTypes.BesiegePortOrder_4005);
		case PortRegisterEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/examples/gmf/taipan?Port?register", TaiPanElementTypes.PortRegister_4007);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = TaiPanDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && TaiPanElementTypes.isKnownElementType(elementType)) {
			image = TaiPanElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound");
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof TaiPanNavigatorGroup) {
			TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof TaiPanNavigatorItem) {
			TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}
		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case PortEditPart.VISUAL_ID:
			return getPort_2001Text(view);
		case ShipEditPart.VISUAL_ID:
			return getShip_2002Text(view);
		case WarshipEditPart.VISUAL_ID:
			return getWarship_2003Text(view);
		case SmallItemsEditPart.VISUAL_ID:
			return getSmallItems_3001Text(view);
		case LargeItemEditPart.VISUAL_ID:
			return getLargeItem_3002Text(view);
		case EmptyBoxEditPart.VISUAL_ID:
			return getEmptyBox_3003Text(view);
		case AquatoryEditPart.VISUAL_ID:
			return getAquatory_1Text(view);
		case ShipDestinationEditPart.VISUAL_ID:
			return getShipDestination_4001Text(view);
		case ReliableRouteEditPart.VISUAL_ID:
			return getRoute_4002Text(view);
		case UnreliableRouteEditPart.VISUAL_ID:
			return getRoute_4003Text(view);
		case EscortShipsOrderEditPart.VISUAL_ID:
			return getEscortShipsOrder_4006Text(view);
		case BesiegePortOrderEditPart.VISUAL_ID:
			return getBesiegePortOrder_4005Text(view);
		case PortRegisterEditPart.VISUAL_ID:
			return getPortRegister_4007Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getPort_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(PortLocationEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Port_2001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getShip_2002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(ShipNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Ship_2002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getWarship_2003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(WarshipNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Warship_2003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getSmallItems_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(SmallItemsEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.SmallItems_3001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLargeItem_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(LargeItemArticleEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.LargeItem_3002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEmptyBox_3003Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Item) domainModelElement).getArticle();
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAquatory_1Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getShipDestination_4001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return CommonParserHint.DESCRIPTION;
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.ShipDestination_4001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRoute_4002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(ReliableRouteDescEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Route_4002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRoute_4003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(UnreliableRouteDescEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Route_4003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			TaiPanDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getEscortShipsOrder_4006Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getBesiegePortOrder_4005Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getPortRegister_4007Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return AquatoryEditPart.MODEL_ID.equals(TaiPanVisualIDRegistry.getModelID(view));
	}

}
