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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.dev.insider.ContentBuilder;
import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.InsiderContext;
import org.eclipse.gmf.dev.insider.ReferenceUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author dstadnik
 */
public class ContentBuilderManager {

	// Further methods provide access to the model structure.
	// Contributions are model nodes with id attribute.

	public boolean isContribution(Element element) {
		String id = element.getAttribute(ElementMetaInfo.ID_ATTRIBUTE);
		return id != null && id.trim().length() > 0;
	}

	public Element getParentContribution(Element element) {
		while (true) {
			Node parent = element.getParentNode();
			if (!(parent instanceof Element)) {
				return null;
			}
			element = (Element) parent;
			if (isContribution(element)) {
				return element;
			}
		}
	}

	public Element[] getChildContributions(Element element) {
		List contributions = new ArrayList();
		addChildContributions(element, contributions);
		return (Element[]) contributions.toArray(new Element[contributions.size()]);
	}

	private void addChildContributions(Element element, List contributions) {
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			Element childElement = (Element) child;
			if (isContribution(childElement)) {
				contributions.add(childElement);
			} else {
				addChildContributions(childElement, contributions);
			}
		}
	}

	public boolean hasChildContributions(Element element) {
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			Element childElement = (Element) child;
			if (isContribution(childElement)) {
				return true;
			} else {
				if (hasChildContributions(childElement)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Build model for the specified object using content builders.
	 */
	public void contribute(Element element, Object object) {
		if (object instanceof InsiderContext) {
			setContext((InsiderContext) object);
		}
		contribute(element, object, new Stack());
		setContext(null);
	}

	private void contribute(Element element, Object object, Stack parents) {
		if (object == null) {
			return;
		}
		String id = ReferenceUtil.getId(object);
		if (parents.contains(id)) {
			ReferenceUtil.createReference(element, id);
			return;
		}
		for (int i = 0; i < getContentBuilders().size(); i++) {
			ContentBuilder builder = (ContentBuilder) getContentBuilders().get(i);

			if (object instanceof InsiderContext) {
				contributeChildren(builder, element, object, parents);
				continue;
			}

			Element contribution = builder.contribute(element, object);
			if (contribution == null) {
				contributeChildren(builder, element, object, parents);
			} else {
				contribution.setAttribute(ElementMetaInfo.ID_ATTRIBUTE, id);
				parents.push(id);
				contributeChildren(builder, contribution, object, parents);
				parents.pop();
			}
		}
	}

	private void contributeChildren(ContentBuilder builder, Element element, Object object, Stack parents) {
		List children = builder.getChildren(object);
		if (children != null && !children.isEmpty()) {
			for (int j = 0; j < children.size(); j++) {
				contribute(element, children.get(j), parents);
			}
		}
	}

	private void setContext(InsiderContext context) {
		for (int i = 0; i < getContentBuilders().size(); i++) {
			ContentBuilder builder = (ContentBuilder) getContentBuilders().get(i);
			builder.setContext(context);
		}
	}

	private List getContentBuilders() {
		if (myContentBuilders == null) {
			myContentBuilders = new ArrayList();
			addContentBuilders(myContentBuilders);
		}
		return myContentBuilders;
	}

	private void addContentBuilders(List list) {
		String namespace = InsiderPlugin.getInstance().getBundle().getSymbolicName();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(namespace, "contentBuilders"); //$NON-NLS-1$
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (!"contentBuilder".equals(element.getName())) { //$NON-NLS-1$
				continue;
			}
			try {
				ContentBuilder contentBuilder = (ContentBuilder) element.createExecutableExtension("class"); //$NON-NLS-1$
				list.add(contentBuilder);
			} catch (Exception e) {
				InsiderPlugin.logError(null, e);
			}
		}
	}

	private List myContentBuilders;
}
