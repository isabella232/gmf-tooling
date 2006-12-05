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
package org.eclipse.gmf.examples.design2d.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipse2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidEllipseEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineCommentEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidLineEditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangle2EditPart;
import org.eclipse.gmf.examples.design2d.edit.parts.SolidRectangleEditPart;

import org.eclipse.gmf.examples.design2d.part.DesignDiagramEditorPlugin;
import org.eclipse.gmf.examples.design2d.part.DesignVisualIDRegistry;

import org.eclipse.gmf.examples.design2d.providers.DesignElementTypes;

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
public class DesignNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		DesignDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		DesignDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		DesignDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof DesignNavigatorItem && !isOwnView(((DesignNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof DesignNavigatorGroup) {
			DesignNavigatorGroup group = (DesignNavigatorGroup) element;
			return DesignDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof DesignNavigatorItem) {
			DesignNavigatorItem navigatorItem = (DesignNavigatorItem) element;
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
		switch (DesignVisualIDRegistry.getVisualID(view)) {
		case SolidRectangleEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?SolidRectangleFigure", DesignElementTypes.Node_2001);
		case SolidEllipse2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?SolidEllipseFigure", DesignElementTypes.Node_2002);
		case SolidRectangle2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?SolidRectangleFigure", DesignElementTypes.Node_3001);
		case SolidEllipseEditPart.VISUAL_ID:
			return getImage("Navigator?Node?SolidEllipseFigure", DesignElementTypes.Node_3002);
		case Design2DEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?", DesignElementTypes.Diagram_1000);
		case SolidLineEditPart.VISUAL_ID:
			return getImage("Navigator?Link?SolidLineFigure", DesignElementTypes.Link_4001);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = DesignDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && DesignElementTypes.isKnownElementType(elementType)) {
			image = DesignElementTypes.getImage(elementType);
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
		if (element instanceof DesignNavigatorGroup) {
			DesignNavigatorGroup group = (DesignNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof DesignNavigatorItem) {
			DesignNavigatorItem navigatorItem = (DesignNavigatorItem) element;
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
		switch (DesignVisualIDRegistry.getVisualID(view)) {
		case SolidRectangleEditPart.VISUAL_ID:
			return getNode_2001Text(view);
		case SolidEllipse2EditPart.VISUAL_ID:
			return getNode_2002Text(view);
		case SolidRectangle2EditPart.VISUAL_ID:
			return getNode_3001Text(view);
		case SolidEllipseEditPart.VISUAL_ID:
			return getNode_3002Text(view);
		case Design2DEditPart.VISUAL_ID:
			return getDiagram_1000Text(view);
		case SolidLineEditPart.VISUAL_ID:
			return getLink_4001Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getNode_2001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getNode_2002Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getNode_3001Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getNode_3002Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getDiagram_1000Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getLink_4001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return DesignVisualIDRegistry.getType(SolidLineCommentEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return DesignElementTypes.Link_4001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			DesignDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001);
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
		return Design2DEditPart.MODEL_ID.equals(DesignVisualIDRegistry.getModelID(view));
	}

}
