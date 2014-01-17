/*
 * Copyright (c) 2006 Borland Software Corporation, 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #403577, [optionally] avoid GenTopLevelNode / GenChildNode separation
 */
package org.eclipse.gmf.internal.bridge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * Keep track of gmfmap-to-gmfgen transformation elements.
 * @author artem
 */
public class DistinctTopLevelNodesFactoryGate extends BridgeFactoryGateBase {

	private final Map<NodeMapping, GenTopLevelNode> myTopNodeMap;

	private final Map<NodeMapping, Set<GenChildNode>> myNodeMap;

	public DistinctTopLevelNodesFactoryGate() {
		myTopNodeMap = new HashMap<NodeMapping, GenTopLevelNode>();
		myNodeMap = new HashMap<NodeMapping, Set<GenChildNode>>();
	}

	@Override
	public GenNode findOrCreateTopNode(NodeMapping nodeMap, GenDiagram diagram) {
		if (myTopNodeMap.containsKey(nodeMap)) {
			return myTopNodeMap.get(nodeMap);
		}
		//
		GenTopLevelNode result = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		diagram.getTopLevelNodes().add(result);
		logTopNode(nodeMap, result);
		return result;
	}

	@Override
	public GenChildLabelNode createChildLabelNode(NodeMapping nodeMap, GenDiagram diagram) {
		GenChildLabelNode result = GMFGenFactory.eINSTANCE.createGenChildLabelNode();
		diagram.getChildNodes().add(result);
		logChildNode(nodeMap, result);
		return result;
	}

	@Override
	public GenChildSideAffixedNode createSideAffixedNode(NodeMapping nodeMap, GenDiagram diagram) {
		GenChildSideAffixedNode result = GMFGenFactory.eINSTANCE.createGenChildSideAffixedNode();
		diagram.getChildNodes().add(result);
		logChildNode(nodeMap, result);
		return result;
	}

	@Override
	public GenChildNodeBase createChildNode(NodeMapping nodeMap, GenDiagram diagram) {
		GenChildNode result = GMFGenFactory.eINSTANCE.createGenChildNode();
		diagram.getChildNodes().add(result);
		logChildNode(nodeMap, result);
		return result;
	}

	/**
	 * No more then 1 GenTopLevelNode may be logged for node mapping 
	 */
	private void logTopNode(NodeMapping nodeMap, GenTopLevelNode genNode) {
		assert nodeMap != null && genNode != null && !myTopNodeMap.containsKey(nodeMap);
		myTopNodeMap.put(nodeMap, genNode);
	}

	@Override
	public GenChildNodeBase findCompatibleChildNode(NodeMapping nodeMap, ChildReference childRef) {
		EReference containmentERef = childRef.getContainmentFeature();
		EReference childrenERef = childRef.getChildrenFeature();
		for (GenChildNode next : findChildNodesFor(nodeMap)) {
			if (matchFeaturesWithModelFacet(containmentERef, childrenERef, next.getModelFacet())) {
				return next;
			}
		}
		return null;
	}

	/**
	 * More than 1 GenChildNode may be logged for node mapping  
	 * (to handle children taken from different containment/children features)
	 */
	private void logChildNode(NodeMapping nodeMap, GenChildNode genNode) {
		assert nodeMap != null && genNode != null;
		Set<GenChildNode> genNodes = myNodeMap.get(nodeMap);
		if (genNodes == null) {
			genNodes = new HashSet<GenChildNode>();
			myNodeMap.put(nodeMap, genNodes);
		}
		genNodes.add(genNode);
	}

	@Override
	public GenNode[] findAllNodesFor(NodeMapping nm) {
		assert nm != null;
		GenNode[] childNodes = findChildNodesFor(nm);
		GenNode topNode = myTopNodeMap.get(nm);
		if (topNode == null) {
			return childNodes;
		}

		GenNode[] result = new GenNode[childNodes.length + 1];
		result[0] = topNode;
		System.arraycopy(childNodes, 0, result, 1, childNodes.length);
		return result;
	}

	/**
	 * @return never <code>null</code>>
	 */
	private GenChildNode[] findChildNodesFor(NodeMapping nodeMap) {
		assert nodeMap != null;
		Set<GenChildNode> genNodes = myNodeMap.get(nodeMap);
		if (genNodes == null) {
			return new GenChildNode[0];
		}
		return genNodes.toArray(new GenChildNode[genNodes.size()]);
	}

	@Override
	public void prepare(CanvasMapping canvasMap) {
		super.prepare(canvasMap);
		myTopNodeMap.clear();
		myNodeMap.clear();
	}

}
