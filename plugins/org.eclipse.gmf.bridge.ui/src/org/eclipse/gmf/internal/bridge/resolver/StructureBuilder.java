/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.resolver;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author dstadnik
 */
public class StructureBuilder {

	private StructureResolver resolver;

	public StructureBuilder(StructureResolver resolver) {
		this.resolver = resolver;
	}

	public ResolvedItem process(EPackage domainPackage) {
		ResolvedItem item = new ResolvedItem(null, domainPackage, null, ResolvedItem.DEFAULT_RESOLUTIONS);
		for (Iterator it = domainPackage.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				item.addChild(process((EClass) next, domainPackage));
			}
		}
		return item;
	}

	public ResolvedItem process(EClass domainClass, EPackage domainPackage) {
		ResolvedItem item;
		TypePattern pattern = resolver.resolve(domainClass, domainPackage);
		if (pattern instanceof NodePattern) {
			item = new ResolvedItem(Resolution.NODE, domainClass, pattern, ResolvedItem.NODE_LINK_RESOLUTIONS);
			NodePattern nodePattern = (NodePattern) pattern;
			addLabels(item, nodePattern);
			for (int i = 0; i < nodePattern.getRefLinks().length; i++) {
				item.addChild(new ResolvedItem(Resolution.LINK, nodePattern.getRefLinks()[i], null, ResolvedItem.LINK_RESOLUTIONS));
			}
		} else if (pattern instanceof TypeLinkPattern) {
			item = new ResolvedItem(Resolution.LINK, domainClass, pattern, ResolvedItem.NODE_LINK_RESOLUTIONS);
			TypeLinkPattern linkPattern = (TypeLinkPattern) pattern;
			addLabels(item, linkPattern);
		} else {
			item = new ResolvedItem(null, domainClass, pattern, ResolvedItem.DEFAULT_RESOLUTIONS);
		}
		return item;
	}

	protected void addLabels(ResolvedItem typeItem, TypePattern pattern) {
		for (int i = 0; i < pattern.getLabels().length; i++) {
			typeItem.addChild(new ResolvedItem(Resolution.LABEL, pattern.getLabels()[i], null, ResolvedItem.LABEL_RESOLUTIONS));
		}
	}
}
