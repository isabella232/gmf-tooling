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
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.ModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;

/**
 * @author dstadnik
 */
public class ModelFacetDecision extends SmartDecision {

	public void apply(EObject newElement, EObject oldElement) {
		ModelFacet newFacet = getFacet(newElement);
		ModelFacet oldFacet = getFacet(oldElement);
		if (newFacet instanceof TypeModelFacet && oldFacet instanceof TypeModelFacet) {
			TypeModelFacet newTypeFacet = (TypeModelFacet) newFacet;
			TypeModelFacet oldTypeFacet = (TypeModelFacet) oldFacet;
			newTypeFacet.setContainmentMetaFeature(oldTypeFacet.getContainmentMetaFeature());
			if (oldTypeFacet.eIsSet(GMFGenPackage.eINSTANCE.getTypeModelFacet_ChildMetaFeature())) {
				newTypeFacet.setChildMetaFeature(oldTypeFacet.getChildMetaFeature());
			}
			newTypeFacet.setModelElementInitializer(oldTypeFacet.getModelElementInitializer());
			newTypeFacet.setModelElementSelector(oldTypeFacet.getModelElementSelector());
			if (newTypeFacet instanceof TypeLinkModelFacet && oldTypeFacet instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet newTypeLinkFacet = (TypeLinkModelFacet) newTypeFacet;
				TypeLinkModelFacet oldTypeLinkFacet = (TypeLinkModelFacet) oldTypeFacet;
				newTypeLinkFacet.setSourceMetaFeature(oldTypeLinkFacet.getSourceMetaFeature());
				newTypeLinkFacet.setTargetMetaFeature(oldTypeLinkFacet.getTargetMetaFeature());
			}
		}
	}

	protected ModelFacet getFacet(EObject element) {
		if (element instanceof GenNode) {
			return ((GenNode) element).getModelFacet();
		} else if (element instanceof GenLink) {
			return ((GenLink) element).getModelFacet();
		}
		return null;
	}
}
