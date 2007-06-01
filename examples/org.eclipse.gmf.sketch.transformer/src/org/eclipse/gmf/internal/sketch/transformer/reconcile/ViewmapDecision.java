/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer.reconcile;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;

/**
 * @author dstadnik
 */
public class ViewmapDecision extends SmartDecision {

	public void apply(EObject newElement, EObject oldElement) {
		if (newElement instanceof GenCommonBase && oldElement instanceof GenCommonBase) {
			GenCommonBase newDiagramElement = (GenCommonBase) newElement;
			GenCommonBase oldDiagramElement = (GenCommonBase) oldElement;
			// we generate only FigureViewmaps
			if (oldDiagramElement.getViewmap() instanceof FigureViewmap) {
				newDiagramElement.getViewmap().getAttributes().addAll(oldDiagramElement.getViewmap().getAttributes());
				newDiagramElement.getViewmap().setLayoutType(oldDiagramElement.getViewmap().getLayoutType());
				newDiagramElement.getViewmap().getRequiredPluginIDs().addAll(oldDiagramElement.getViewmap().getRequiredPluginIDs());
			} else {
				newDiagramElement.setViewmap(oldDiagramElement.getViewmap());
			}
		}
	}
}
