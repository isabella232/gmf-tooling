/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.internal.bridge.DistinctTopLevelNodesFactoryGate;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;

public class BridgeFactoryGateTest extends TestCase {

	private DistinctTopLevelNodesFactoryGate myDistinctGate;

	private NodeMapping myNodeMapping;

	private LinkMapping myLinkMapping;

	private TypeModelFacet myModelFacetA;

	private TypeModelFacet myModelFacetB;

	private GenCompartment myCompartment;

	private GenDiagram myDiagram;

	public BridgeFactoryGateTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myDistinctGate = new DistinctTopLevelNodesFactoryGate();
		myDistinctGate.prepare(GMFMapFactory.eINSTANCE.createCanvasMapping());

		myNodeMapping = GMFMapFactory.eINSTANCE.createNodeMapping();
		myLinkMapping = GMFMapFactory.eINSTANCE.createLinkMapping();
		myDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		myModelFacetA = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		myModelFacetB = GMFGenFactory.eINSTANCE.createTypeModelFacet();

		myCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		myDiagram.getCompartments().add(myCompartment);
	}

	public void testFindLink() throws Exception {
		assertNull(myDistinctGate.findLink(myLinkMapping));
		GenLink first = myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram);
		GenLink second = myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram);
		assertNotNull(first);
		assertSame(first, second);
		assertSame(first, myDistinctGate.findLink(myLinkMapping));
		assertSame(myDiagram, first.getDiagram());

		purgeHistory();
		assertNotSame(first, myDistinctGate.findOrCreateLink(myLinkMapping, GMFGenFactory.eINSTANCE.createGenDiagram()));
	}

	public void testFindChildNode() throws Exception {
		assertTrue(myDistinctGate.findAllNodesFor(myNodeMapping).length == 0);
		GenChildNodeBase childNode = myDistinctGate.createChildNode(myNodeMapping, myModelFacetA, myCompartment);
		assertTrue(childNode instanceof GenChildNode);
		assertSame(childNode, myDistinctGate.findAllNodesFor(myNodeMapping)[0]);
		assertNotNull(childNode);
		assertSame(myModelFacetA, childNode.getModelFacet());
		assertTrue(myCompartment.getChildNodes().contains(childNode));
		assertTrue(childNode.getContainers().contains(myCompartment));
		assertSame(myDiagram, childNode.getDiagram());

		purgeHistory();
		assertTrue(myDistinctGate.findAllNodesFor(myNodeMapping).length == 0);
	}

	public void testFindMultipleChildNodes() throws Exception {
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);

		GenChildNodeBase first = myDistinctGate.createChildNode(myNodeMapping, myModelFacetA, myCompartment);
		GenChildNodeBase second = myDistinctGate.createChildNode(myNodeMapping, myModelFacetB, myCompartment);

		assertNotNull(first);
		assertNotNull(second);
		assertTrue(first instanceof GenChildNode);
		assertTrue(second instanceof GenChildNode);
		assertNotSame(first, second);

		assertSame(myDiagram, first.getDiagram());
		assertSame(myDiagram, second.getDiagram());

		assertSame(myModelFacetA, first.getModelFacet());
		assertSame(myModelFacetB, second.getModelFacet());

		assertTrue(myCompartment.getChildNodes().contains(first));
		assertTrue(second.getContainers().contains(myCompartment));

		final List<GenNode> all = Arrays.asList(myDistinctGate.findAllNodesFor(myNodeMapping));
		assertTrue(all.contains(first));
		assertTrue(all.contains(second));
		assertEquals(2, all.size());

		purgeHistory();
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);
	}

	public void testFindTopNode() throws Exception {
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);

		GenNode topNode = myDistinctGate.findOrCreateTopNode(myNodeMapping, myModelFacetA, myDiagram);
		assertNotNull(topNode);
		assertSame(topNode, myDistinctGate.findOrCreateTopNode(myNodeMapping, myModelFacetA, myDiagram));
		assertEquals(1, myDistinctGate.findAllNodesFor(myNodeMapping).length);
		assertSame(topNode, myDistinctGate.findAllNodesFor(myNodeMapping)[0]);

		purgeHistory();
		myDistinctGate.findAllNodesFor(myNodeMapping);
	}

	public void testMultipleElements() throws Exception {
		GenNode topNode = myDistinctGate.findOrCreateTopNode(myNodeMapping, myModelFacetA, myDiagram);
		GenChildNodeBase childNode = myDistinctGate.createChildNode(myNodeMapping, myModelFacetB, myCompartment);
		assertNotSame(topNode, childNode);

		assertTrue(myCompartment.getChildNodes().contains(childNode));
		assertFalse(myCompartment.getChildNodes().contains(topNode));
		assertSame(myDiagram, childNode.getDiagram());
		assertSame(myDiagram, topNode.getDiagram());

		assertEquals(2, myDistinctGate.findAllNodesFor(myNodeMapping).length);
		final List<GenNode> all = Arrays.asList(myDistinctGate.findAllNodesFor(myNodeMapping));
		assertTrue(all.contains(topNode));
		assertTrue(all.contains(childNode));

		GenLink link = myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram);
		assertNotNull(link);
		assertSame(link, myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram));
	}

	public void testMetrics() throws Exception {
		MetricRule metric = GMFMapFactory.eINSTANCE.createMetricRule();
		GenMetricRule genMetric = GMFGenFactory.eINSTANCE.createGenMetricRule();

		assertNull(myDistinctGate.findMetricRule(metric));
		myDistinctGate.logMetricRule(metric, genMetric);
		assertSame(genMetric, myDistinctGate.findMetricRule(metric));
		purgeHistory();
		assertNull(myDistinctGate.findMetricRule(metric));
	}

	private void purgeHistory() {
		myDistinctGate.prepare(GMFMapFactory.eINSTANCE.createCanvasMapping());
	}

}
