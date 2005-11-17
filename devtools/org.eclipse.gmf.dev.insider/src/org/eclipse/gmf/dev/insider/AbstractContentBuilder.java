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
package org.eclipse.gmf.dev.insider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.w3c.dom.Element;

/**
 * Base implementation with utility methods.
 * 
 * @author dstadnik
 */
public abstract class AbstractContentBuilder implements ContentBuilder {

	protected Element createObject(Element parent, Object object, String elementName) {
		Element element = parent.getOwnerDocument().createElement(elementName);
		parent.appendChild(element);
		element.setAttribute(ElementMetaInfo.TYPE_ATTRIBUTE, object.getClass().getName());
		createExtends(element, object.getClass());
		return element;
	}

	protected void createBounds(Element parent, Rectangle bounds) {
		Element element = parent.getOwnerDocument().createElement(ElementMetaInfo.BOUNDS_ELEMENT);
		parent.appendChild(element);
		element.setAttribute(ElementMetaInfo.X_ATTRIBUTE, String.valueOf(bounds.x));
		element.setAttribute(ElementMetaInfo.Y_ATTRIBUTE, String.valueOf(bounds.y));
		element.setAttribute(ElementMetaInfo.WIDTH_ATTRIBUTE, String.valueOf(bounds.width));
		element.setAttribute(ElementMetaInfo.HEIGHT_ATTRIBUTE, String.valueOf(bounds.height));
	}

	protected void createPointList(Element parent, PointList pointList) {
		Element element = parent.getOwnerDocument().createElement(ElementMetaInfo.POINT_LIST_ELEMENT);
		parent.appendChild(element);
		for (int i = 0; i < pointList.size(); i++) {
			createPoint(element, pointList.getPoint(i));
		}
	}

	protected void createPoint(Element parent, Point point) {
		Element element = parent.getOwnerDocument().createElement(ElementMetaInfo.POINT_ELEMENT);
		parent.appendChild(element);
		element.setAttribute(ElementMetaInfo.X_ATTRIBUTE, String.valueOf(point.x));
		element.setAttribute(ElementMetaInfo.Y_ATTRIBUTE, String.valueOf(point.y));
	}

	protected void createExtends(Element parent, Class clazz) {
		Set ancestors = new HashSet();
		addAncestors(clazz, ancestors);
		Iterator i = ancestors.iterator();
		while (i.hasNext()) {
			String ancestor = (String) i.next();
			if (isIgnoredAncestor(clazz, ancestor)) {
				continue;
			}
			Element element = parent.getOwnerDocument().createElement(ElementMetaInfo.EXTENDS_ELEMENT);
			parent.appendChild(element);
			element.setAttribute(ElementMetaInfo.TYPE_ATTRIBUTE, ancestor);
		}
	}

	protected boolean isIgnoredAncestor(Class clazz, String ancestor) {
		return clazz.getName().equals(ancestor); // ignore self
	}

	protected void addAncestors(Class clazz, Set ancestors) {
		if (clazz == null) {
			return;
		}
		String name = clazz.getName();
		if (Object.class.getName().equals(name)) {
			return; // skip objects
		}
		ancestors.add(name);
		addAncestors(clazz.getSuperclass(), ancestors);
		Class[] interfaces = clazz.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			addAncestors(interfaces[i], ancestors);
		}
	}

	public void setContext(InsiderContext context) {
		myContext = context;
	}

	protected final InsiderContext getContext() {
		return myContext;
	}

	private InsiderContext myContext;
}
