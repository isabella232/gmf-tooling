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
package org.eclipse.gmf.dev.insider.internal.ui;

import java.net.URL;

import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.ElementUtil;
import org.eclipse.gmf.dev.insider.ReferenceUtil;
import org.eclipse.gmf.dev.insider.internal.InsiderPlugin;
import org.eclipse.gmf.dev.insider.internal.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author dstadnik
 */
public class InsiderLabelProvider extends LabelProvider {

	public String getText(Object object) {
		if (object instanceof View) {
			View view = (View) object;
			StringBuffer buffer = new StringBuffer();
			String description = view.getDescription();
			if (description != null) {
				buffer.append(description);
				buffer.append(" / "); //$NON-NLS-1$
			}
			buffer.append(view.getTimestamp());
			return buffer.toString();
		} else if (object instanceof Element) {
			Element element = (Element) object;
			String targetId = ReferenceUtil.getReferencedId(element);
			if (targetId != null) {
				return "reference to " + targetId;
			}
			String type = element.getAttribute(ElementMetaInfo.TYPE_ATTRIBUTE);
			if (isShowSimpleTypes()) {
				type = type.substring(type.lastIndexOf('.') + 1);
			}
			if (isShowIds()) {
				String id = element.getAttribute(ElementMetaInfo.ID_ATTRIBUTE);
				if (id != null) {
					type += ' ' + id;
				}
			}
			if (isShowBounds()) {
				NodeList children = element.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					Node child = children.item(i);
					if (child instanceof Element && ElementMetaInfo.BOUNDS_ELEMENT.equals(child.getNodeName())) {
						Element boundsElement = (Element) child;
						StringBuffer sb = new StringBuffer();
						sb.append(" / [");
						sb.append(boundsElement.getAttribute(ElementMetaInfo.X_ATTRIBUTE));
						sb.append(',');
						sb.append(boundsElement.getAttribute(ElementMetaInfo.Y_ATTRIBUTE));
						sb.append(',');
						sb.append(boundsElement.getAttribute(ElementMetaInfo.WIDTH_ATTRIBUTE));
						sb.append(',');
						sb.append(boundsElement.getAttribute(ElementMetaInfo.HEIGHT_ATTRIBUTE));
						sb.append("]");
						type += sb;
					}
				}
			}
			return type;
		}
		return super.getText(object);
	}

	public Image getImage(Object object) {
		if (object instanceof View) {
			return getInsiderImage("icons/insider.gif");
		} else if (object instanceof Element) {
			Element element = (Element) object;
			String name = element.getNodeName();
			if (ElementMetaInfo.FIGURE_ELEMENT.equals(name)) {
				if (ElementUtil.hasChildren(element, ElementMetaInfo.POINT_LIST_ELEMENT)) {
					return getInsiderImage("icons/link.gif");
				}
				return getInsiderImage("icons/node.gif");
			}
			return null;
		}
		return super.getImage(object);
	}

	private Image getInsiderImage(String path) {
		ImageRegistry registry = InsiderPlugin.getInstance().getImageRegistry();
		Image image = registry.get(path);
		if (image == null) {
			URL url = InsiderPlugin.getInstance().getBundle().getEntry(path);
			registry.put(path, ImageDescriptor.createFromURL(url));
			image = registry.get(path);
		}
		return image;
	}

	public final boolean isShowSimpleTypes() {
		return myShowSimpleTypes;
	}

	public void setShowSimpleTypes(boolean showSimpleTypes) {
		myShowSimpleTypes = showSimpleTypes;
	}

	public final boolean isShowIds() {
		return myShowIds;
	}

	public void setShowIds(boolean showIds) {
		myShowIds = showIds;
	}

	public final boolean isShowBounds() {
		return myShowBounds;
	}

	public void setShowBounds(boolean showBounds) {
		myShowBounds = showBounds;
	}

	private boolean myShowSimpleTypes;
	private boolean myShowIds;
	private boolean myShowBounds;
}
