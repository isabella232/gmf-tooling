/*
 * Copyright (c) 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Montages) - #403577, [optionally] avoid GenTopLevelNode / GenChildNode separation
 */
package org.eclipse.gmf.internal.bridge;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricRule;

public abstract class BridgeFactoryGateBase implements BridgeFactoryGate {

	private final Map<LinkMapping, GenLink> myLinkMap = new HashMap<LinkMapping, GenLink>();

	private final Map<MetricRule, GenMetricRule> myMetricMap = new HashMap<MetricRule, GenMetricRule>();

	@Override
	public void logMetricRule(MetricRule metric, GenMetricRule genMetric) {
		assert metric != null && genMetric != null;
		myMetricMap.put(metric, genMetric);
	}

	@Override
	public GenMetricRule findMetricRule(MetricRule metric) {
		assert metric != null;
		return myMetricMap.get(metric);
	}

	/**
	 * No more than 1 GenLink is allowed for link mapping.
	 */
	@Override
	public GenLink findOrCreateLink(LinkMapping linkMap, GenDiagram diagram) {
		GenLink result = findLink(linkMap);
		if (result == null) {
			result = GMFGenFactory.eINSTANCE.createGenLink();
			diagram.getLinks().add(result);
			logLink(linkMap, result);
		}
		return result;
	}

	@Override
	public GenLink findLink(LinkMapping linkMap) {
		assert linkMap != null;
		return myLinkMap.get(linkMap);
	}

	/**
	 * No more than 1 GenLink is allowed for link mapping.
	 */
	protected void logLink(LinkMapping linkMap, GenLink genLink) {
		assert linkMap != null && genLink != null && !myLinkMap.containsKey(linkMap);
		myLinkMap.put(linkMap, genLink);
	}

	@Override
	public void prepare(CanvasMapping canvasMap) {
		myLinkMap.clear();
		myMetricMap.clear();
	}

	/**
	 * Handle case when second-level ChildReference references existing
	 * nodemapping, but with different containment/children reference.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=129552
	 */
	public static boolean matchFeaturesWithModelFacet(EReference containmentERef, EReference childrenERef, TypeModelFacet modelFacet) {
		final boolean containmentFeatureMatch;
		final boolean childrenFeatureMatch;
		if (modelFacet == null || modelFacet.getContainmentMetaFeature() == null) {
			containmentFeatureMatch = (null == containmentERef);
		} else {
			// seems legal to use '==' because features should came from the same model
			containmentFeatureMatch = containmentERef == modelFacet.getContainmentMetaFeature().getEcoreFeature();
		}
		if (modelFacet == null || modelFacet.getChildMetaFeature() == null) {
			childrenFeatureMatch = (null == childrenERef);
		} else {
			if (childrenERef == null) {
				// likely, childMetaFeature in model facet was derived from containment feature 
				childrenFeatureMatch = modelFacet.getChildMetaFeature() == modelFacet.getContainmentMetaFeature();
			} else {
				// honest check
				childrenFeatureMatch = modelFacet.getChildMetaFeature().getEcoreFeature() == childrenERef;
			}
		}
		return containmentFeatureMatch && childrenFeatureMatch;
	}
}
