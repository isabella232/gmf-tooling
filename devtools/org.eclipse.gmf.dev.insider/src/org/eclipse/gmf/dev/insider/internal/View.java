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
package org.eclipse.gmf.dev.insider.internal;

import java.io.Writer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.ElementUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class View {

	public View(Document document) {
		assert document != null;
		myDocument = document;
	}

	public String getTimestamp() {
		Element element = getViewElement(false);
		if (element == null) {
			return null;
		}
		return element.getAttribute(ElementMetaInfo.TIMESTAMP_ATTRIBUTE);
	}

	public String getDescription() {
		Element element = getViewElement(false);
		if (element == null) {
			return null;
		}
		return element.getAttribute(ElementMetaInfo.DESCRIPTION_ATTRIBUTE);
	}

	public void setDescription(String description) {
		Element element = getViewElement(true);
		element.setAttribute(ElementMetaInfo.DESCRIPTION_ATTRIBUTE, description);
	}

	public Element[] getElements() {
		Element element = getViewElement(false);
		return ElementUtil.getChildren(element);
	}

	public boolean hasElements() {
		Element element = getViewElement(false);
		return ElementUtil.hasChildren(element);
	}

	public void serialize(Writer writer) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml"); //$NON-NLS-1$
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
			transformer.transform(new DOMSource(myDocument), new StreamResult(writer));
		} catch (Exception e) {
			InsiderPlugin.logError(null, e);
		}
	}

	protected Element getViewElement(boolean create) {
		Element element = myDocument.getDocumentElement();
		if (element == null && create) {
			element = myDocument.createElement(ElementMetaInfo.VIEW_ELEMENT);
			myDocument.appendChild(element);
		}
		return element;
	}

	private Document myDocument;
}
