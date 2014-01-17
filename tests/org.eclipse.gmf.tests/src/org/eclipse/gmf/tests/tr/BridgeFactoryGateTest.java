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
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.internal.bridge.DistinctTopLevelNodesFactoryGate;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;

public class BridgeFactoryGateTest extends TestCase {

	private DistinctTopLevelNodesFactoryGate myDistinctGate;

	private NodeMapping myNodeMapping;

	private LinkMapping myLinkMapping;

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
	}

	public void testFindLink() throws Exception {
		assertNull(myDistinctGate.findLink(myLinkMapping));
		GenLink first = myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram);
		GenLink second = myDistinctGate.findOrCreateLink(myLinkMapping, myDiagram);
		assertNotNull(first);
		assertSame(first, second);
		assertSame(first, myDistinctGate.findLink(myLinkMapping));

		purgeHistory();
		assertNotSame(first, myDistinctGate.findOrCreateLink(myLinkMapping, GMFGenFactory.eINSTANCE.createGenDiagram()));
	}

	public void testFindChildNode() throws Exception {
		assertTrue(myDistinctGate.findAllNodesFor(myNodeMapping).length == 0);
		GenChildNodeBase childNode = myDistinctGate.createChildNode(myNodeMapping, myDiagram);
		assertTrue(childNode instanceof GenChildNode);
		assertSame(childNode, myDistinctGate.findAllNodesFor(myNodeMapping)[0]);
		assertNotNull(childNode);

		purgeHistory();
		assertTrue(myDistinctGate.findAllNodesFor(myNodeMapping).length == 0);
	}

	public void testFindMultipleChildNodes() throws Exception {
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);

		GenChildNodeBase first = myDistinctGate.createChildNode(myNodeMapping, myDiagram);
		GenChildNodeBase second = myDistinctGate.createChildNode(myNodeMapping, myDiagram);

		assertNotNull(first);
		assertNotNull(second);
		assertTrue(first instanceof GenChildNode);
		assertTrue(second instanceof GenChildNode);

		assertNotSame(first, second);

		final List<GenNode> all = Arrays.asList(myDistinctGate.findAllNodesFor(myNodeMapping));
		assertTrue(all.contains(first));
		assertTrue(all.contains(second));
		assertEquals(2, all.size());

		purgeHistory();
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);
	}

	public void testFindTopNode() throws Exception {
		assertEquals(0, myDistinctGate.findAllNodesFor(myNodeMapping).length);

		GenNode topNode = myDistinctGate.findOrCreateTopNode(myNodeMapping, myDiagram);
		assertNotNull(topNode);
		assertSame(topNode, myDistinctGate.findOrCreateTopNode(myNodeMapping, myDiagram));
		assertEquals(1, myDistinctGate.findAllNodesFor(myNodeMapping).length);
		assertSame(topNode, myDistinctGate.findAllNodesFor(myNodeMapping)[0]);

		purgeHistory();
		myDistinctGate.findAllNodesFor(myNodeMapping);
	}

	public void testMultipleElements() throws Exception {
		GenNode topNode = myDistinctGate.findOrCreateTopNode(myNodeMapping, myDiagram);
		GenChildNodeBase childNode = myDistinctGate.createChildNode(myNodeMapping, myDiagram);
		assertNotSame(topNode, childNode);
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
