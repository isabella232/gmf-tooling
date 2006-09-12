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
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.internal.bridge.ui.Plugin;

/**
 * @author dstadnik
 */
public class StructureBuilder {

	private final StructureResolver resolver;

	private final boolean withLabels;

	private final ContainmentClosure containmentClosure;

	public StructureBuilder(StructureResolver resolver, boolean withLabels) {
		this.resolver = resolver;
		this.withLabels = withLabels;
		containmentClosure = Plugin.getDefault().getContaintmentClosure();
	}

	public final boolean isWithLabels() {
		return withLabels;
	}

	public ResolvedItem process(EPackage domainPackage, EClass diagramClass) {
		ResolvedItem item = new ResolvedItem(null, domainPackage, null, ResolvedItem.NO_RESOLUTIONS);
		for (Iterator it = domainPackage.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				item.addChild(process((EClass) next, domainPackage, diagramClass));
			}
		}
		return item;
	}

	public ResolvedItem process(EClass domainClass, EPackage domainPackage, EClass diagramClass) {
		Resolution resolution;
		Resolution[] resolutions = ResolvedItem.NODE_LINK_RESOLUTIONS;
		TypePattern pattern = resolver.resolve(domainClass, domainPackage);
		if (pattern instanceof NodePattern) {
			resolution = Resolution.NODE;
			if (diagramClass != null && !containmentClosure.contains(diagramClass, domainClass, domainPackage)) {
				resolution = null;
			}
		} else if (pattern instanceof TypeLinkPattern) {
			resolution = Resolution.LINK;
			if (diagramClass != null) {
				TypeLinkPattern linkPattern = (TypeLinkPattern) pattern;
				if (linkPattern.getSource() != null && !containmentClosure.contains(diagramClass, linkPattern.getSource().getEReferenceType(), domainPackage)) {
					resolution = null;
				}
				if (linkPattern.getTarget() != null && !containmentClosure.contains(diagramClass, linkPattern.getTarget().getEReferenceType(), domainPackage)) {
					resolution = null;
				}
			}
		} else {
			resolution = null;
			if (domainClass.isAbstract() || domainClass.isInterface()) {
				resolutions = ResolvedItem.NO_RESOLUTIONS;
			}
		}
		ResolvedItem item = new ResolvedItem(resolution, domainClass, pattern, resolutions);
		addLabels(item, domainClass);
		addRefLinks(item, domainClass);
		return item;
	}

	protected void addLabels(ResolvedItem typeItem, EClass type) {
		if (!withLabels) {
			return;
		}
		Resolution resolution = typeItem.getResolution() == null ? null : Resolution.LABEL;
		for (EAttribute attribute : (List<? extends EAttribute>) type.getEAllAttributes()) {
			typeItem.addChild(new ResolvedItem(resolution, attribute, null, ResolvedItem.LABEL_RESOLUTIONS));
		}
	}

	protected void addRefLinks(ResolvedItem typeItem, EClass type) {
		Resolution resolution = typeItem.getResolution() != Resolution.NODE ? null : Resolution.LINK;
		for (EReference reference : (List<? extends EReference>) type.getEAllReferences()) {
			typeItem.addChild(new ResolvedItem(resolution, reference, null, ResolvedItem.LINK_RESOLUTIONS));
		}
	}
}
