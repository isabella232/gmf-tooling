/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.graphdef.codegen.ui;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;

/**
 * @author artem
 */
class FigureFinder {

	public FigureFinder() {
	}

	public FigureGallery[] findFigures(Resource resource) {
		ArrayList rv = new ArrayList();
		for(TreeIterator it = resource.getAllContents(); it.hasNext();) {
			EObject next = (EObject) it.next();
			// FigureGallery could be either top element or as a child of canvas
			if (next.eClass().getClassifierID() == GMFGraphPackage.FIGURE_GALLERY) {
				rv.add(next);
				it.prune();
			} else if (next.eClass().getClassifierID() != GMFGraphPackage.CANVAS) {
				it.prune();
			}
		}
		return (FigureGallery[]) rv.toArray(new FigureGallery[rv.size()]);
	}
}
