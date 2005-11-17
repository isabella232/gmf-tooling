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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.InsiderContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class ViewFactory {

	public View createView(InsiderContext context) {
		String timestamp = String.valueOf(System.currentTimeMillis());
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element element = document.createElement(ElementMetaInfo.VIEW_ELEMENT);
			element.setAttribute(ElementMetaInfo.TIMESTAMP_ATTRIBUTE, timestamp);
			document.appendChild(element);
			InsiderAccess.getContentBuilderManager().contribute(element, context);
			return new View(document);
		} catch (Exception e) {
			InsiderPlugin.logError(null, e);
		}
		return null;
	}
}
