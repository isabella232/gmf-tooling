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

import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;

public interface BridgeFactoryGate {

	public void prepare(CanvasMapping canvasMap);

	public GenLink findOrCreateLink(LinkMapping linkMap, GenDiagram diagram);

	public GenLink findLink(LinkMapping lm);

	public GenNode findOrCreateTopNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenDiagram diagram);

	public GenChildNodeBase findCompatibleChildNode(NodeMapping nodeMap, ChildReference childRef);

	public GenChildNodeBase createChildNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenDiagram diagram);

	public GenChildLabelNode createChildLabelNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenDiagram diagram);

	public GenChildSideAffixedNode createSideAffixedNode(NodeMapping nodeMap, TypeModelFacet modelFacet, GenDiagram diagram);

	public void logMetricRule(MetricRule metric, GenMetricRule genMetric);

	public GenMetricRule findMetricRule(MetricRule metric);

	public GenNode[] findAllNodesFor(NodeMapping nm);

}
