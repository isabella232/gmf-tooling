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

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility methods to work with DOM.
 * 
 * @author dstadnik
 */
public class ElementUtil {

	public static final Element[] NO_ELEMENTS = new Element[0];

	public static Element[] getChildren(Element element) {
		if (element == null) {
			return NO_ELEMENTS;
		}
		NodeList children = element.getChildNodes();
		if (children.getLength() == 0) {
			return NO_ELEMENTS;
		}
		List childElements = new ArrayList(children.getLength());
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				childElements.add(child);
			}
		}
		return (Element[]) childElements.toArray(new Element[childElements.size()]);
	}

	public static Element[] getChildren(Element element, String name) {
		if (element == null) {
			return NO_ELEMENTS;
		}
		NodeList children = element.getChildNodes();
		if (children.getLength() == 0) {
			return NO_ELEMENTS;
		}
		List childElements = new ArrayList(children.getLength());
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			Element childElement = (Element) child;
			if (childElement.getNodeName().equals(name)) {
				childElements.add(childElement);
			}
		}
		return (Element[]) childElements.toArray(new Element[childElements.size()]);
	}

	public static boolean hasChildren(Element element) {
		if (element == null) {
			return false;
		}
		NodeList children = element.getChildNodes();
		if (children.getLength() == 0) {
			return false;
		}
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasChildren(Element element, String name) {
		if (element == null) {
			return false;
		}
		NodeList children = element.getChildNodes();
		if (children.getLength() == 0) {
			return false;
		}
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			Element childElement = (Element) child;
			if (childElement.getNodeName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
