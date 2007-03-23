/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Port;

import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingAddressEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.BuildingEditPart;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.parts.PortEditPart;

import org.eclipse.gmf.examples.taipan.port.diagram.part.PortDiagramEditorPlugin;
import org.eclipse.gmf.examples.taipan.port.diagram.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.examples.taipan.port.diagram.providers.TaiPanElementTypes;

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
		PortDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		PortDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		PortDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
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
			return PortDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof TaiPanNavigatorItem) {
			TaiPanNavigatorItem navigatorItem = (TaiPanNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/examples/gmf/taipan?Building", TaiPanElementTypes.Building_2001);
		case PortEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/examples/gmf/taipan?Port", TaiPanElementTypes.Port_1000);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PortDiagramEditorPlugin.getInstance().getImageRegistry();
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

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (TaiPanVisualIDRegistry.getVisualID(view)) {
		case BuildingEditPart.VISUAL_ID:
			return getBuilding_2001Text(view);
		case PortEditPart.VISUAL_ID:
			return getPort_1000Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getBuilding_2001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return TaiPanVisualIDRegistry.getType(BuildingAddressEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return TaiPanElementTypes.Building_2001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			PortDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPort_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return ((Port) domainModelElement).getLocation();
		} else {
			PortDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000);
			return "";
		}
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
		return PortEditPart.MODEL_ID.equals(TaiPanVisualIDRegistry.getModelID(view));
	}

}
