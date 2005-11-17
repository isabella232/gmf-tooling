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

import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class ReferenceUtil {

	private ReferenceUtil() {}

	public static String getId(Object object) {
		assert object != null;
		return String.valueOf(object.hashCode());
	}

	public static boolean isReference(Element element) {
		return ElementMetaInfo.REFERENCE_ELEMENT.equals(element.getNodeName());
	}

	public static String getReferencedId(Element element) {
		if (!isReference(element)) {
			return null;
		}
		return element.getAttribute(ElementMetaInfo.ID_ATTRIBUTE);
	}

	public static Element getReferencedElement(Element root, String targetId) {
		if (!isReference(root)) {
			String id = root.getAttribute(ElementMetaInfo.ID_ATTRIBUTE);
			if (targetId.equals(id)) {
				return root;
			}
		}
		Element[] children = ElementUtil.getChildren(root);
		for (int i = 0; i < children.length; i++) {
			Element target = getReferencedElement(children[i], targetId);
			if (target != null) {
				return target;
			}
		}
		return null;
	}

	public static void createReference(Element parent, Object target) {
		String id = getId(target);
		createReference(parent, id);
	}

	public static void createReference(Element parent, String id) {
		Element element = parent.getOwnerDocument().createElement(ElementMetaInfo.REFERENCE_ELEMENT);
		parent.appendChild(element);
		element.setAttribute(ElementMetaInfo.ID_ATTRIBUTE, id);
	}
}
