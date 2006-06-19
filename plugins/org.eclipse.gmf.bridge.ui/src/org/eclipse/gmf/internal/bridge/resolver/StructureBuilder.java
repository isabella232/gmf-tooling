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

	public ResolvedItem process(EPackage domainPackage, EClass diagramClass) {
		ResolvedItem item = new ResolvedItem(null, domainPackage, null, ResolvedItem.DEFAULT_RESOLUTIONS);
		for (Iterator it = domainPackage.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				item.addChild(process((EClass) next, domainPackage, diagramClass));
			}
		}
		return item;
	}

	public ResolvedItem process(EClass domainClass, EPackage domainPackage, EClass diagramClass) {
		ResolvedItem item;
		TypePattern pattern = resolver.resolve(domainClass, domainPackage);
		if (pattern instanceof NodePattern) {
			Resolution resolution = Resolution.NODE;
			if (diagramClass != null && !ContainmentClosure.contains(diagramClass, domainClass, domainPackage)) {
				resolution = null;
			}
			item = new ResolvedItem(resolution, domainClass, pattern, ResolvedItem.NODE_LINK_RESOLUTIONS);
			NodePattern nodePattern = (NodePattern) pattern;
			addLabels(item, nodePattern);
			Resolution linkResolution = item.getResolution() == null ? null : Resolution.LINK;
			for (int i = 0; i < nodePattern.getRefLinks().length; i++) {
				item.addChild(new ResolvedItem(linkResolution, nodePattern.getRefLinks()[i], null, ResolvedItem.LINK_RESOLUTIONS));
			}
		} else if (pattern instanceof TypeLinkPattern) {
			Resolution resolution = Resolution.LINK;
			if (diagramClass != null) {
				TypeLinkPattern linkPattern = (TypeLinkPattern) pattern;
				if (linkPattern.getSource() != null && !ContainmentClosure.contains(diagramClass, linkPattern.getSource().getEReferenceType(), domainPackage)) {
					resolution = null;
				}
				if (linkPattern.getTarget() != null && !ContainmentClosure.contains(diagramClass, linkPattern.getTarget().getEReferenceType(), domainPackage)) {
					resolution = null;
				}
			}
			item = new ResolvedItem(resolution, domainClass, pattern, ResolvedItem.NODE_LINK_RESOLUTIONS);
			TypeLinkPattern linkPattern = (TypeLinkPattern) pattern;
			addLabels(item, linkPattern);
		} else {
			Resolution[] resolutions = ResolvedItem.NODE_LINK_RESOLUTIONS;
			if (domainClass.isAbstract() || domainClass.isInterface()) {
				resolutions = ResolvedItem.DEFAULT_RESOLUTIONS;
			}
			item = new ResolvedItem(null, domainClass, pattern, resolutions);
		}
		return item;
	}

	protected void addLabels(ResolvedItem typeItem, TypePattern pattern) {
		Resolution resolution = typeItem.getResolution() == null ? null : Resolution.LABEL;
		for (int i = 0; i < pattern.getLabels().length; i++) {
			typeItem.addChild(new ResolvedItem(resolution, pattern.getLabels()[i], null, ResolvedItem.LABEL_RESOLUTIONS));
		}
	}
}
