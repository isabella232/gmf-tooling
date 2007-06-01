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
import org.eclipse.gmf.codegen.gmfgen.DesignLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet;

/**
 * @author dstadnik
 */
public class LabelModelFacetDecision extends SmartDecision {

	public void apply(EObject newElement, EObject oldElement) {
		LabelModelFacet newFacet = getFacet(newElement);
		LabelModelFacet oldFacet = getFacet(oldElement);
		if (newFacet instanceof FeatureLabelModelFacet && oldFacet instanceof FeatureLabelModelFacet) {
			FeatureLabelModelFacet newFeatureFacet = (FeatureLabelModelFacet) newFacet;
			FeatureLabelModelFacet oldFeatureFacet = (FeatureLabelModelFacet) oldFacet;
			newFeatureFacet.setViewPattern(oldFeatureFacet.getViewPattern());
			newFeatureFacet.setEditPattern(oldFeatureFacet.getEditPattern());
			newFeatureFacet.setEditorPattern(oldFeatureFacet.getEditorPattern());
			newFeatureFacet.setViewMethod(oldFeatureFacet.getViewMethod());
			newFeatureFacet.setEditMethod(oldFeatureFacet.getEditMethod());
		} else if (newFacet == null && oldFacet instanceof DesignLabelModelFacet) {
			setFacet(newElement, oldFacet);
		}
	}

	protected LabelModelFacet getFacet(EObject element) {
		LabelModelFacet facet = null;
		if (element instanceof GenLabel) {
			facet = ((GenLabel) element).getModelFacet();
		} else if (element instanceof GenChildLabelNode) {
			facet = ((GenChildLabelNode) element).getLabelModelFacet();
		}
		return facet;
	}

	protected void setFacet(EObject element, LabelModelFacet facet) {
		if (element instanceof GenLabel) {
			((GenLabel) element).setModelFacet(facet);
		} else if (element instanceof GenChildLabelNode) {
			((GenChildLabelNode) element).setLabelModelFacet(facet);
		}
	}
}
