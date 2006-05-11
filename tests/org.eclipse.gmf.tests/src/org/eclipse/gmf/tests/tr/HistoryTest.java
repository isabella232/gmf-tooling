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
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.internal.bridge.History;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;

public class HistoryTest extends TestCase {
	private History history;
	private NodeMapping nodeMapping;
	private GenTopLevelNode topGenNode;
	private GenChildNode childGenNode;	
	
	private LinkMapping linkMapping;
	private GenLink	genLink;	
	
	public HistoryTest(String name) {
		super(name);		
	}
	
	protected void setUp() throws Exception {	
		super.setUp();
		history = new History();
		nodeMapping = GMFMapFactory.eINSTANCE.createNodeMapping();
		topGenNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		childGenNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		
		linkMapping = GMFMapFactory.eINSTANCE.createLinkMapping();
		genLink = GMFGenFactory.eINSTANCE.createGenLink();
	}
		
	public void testFindLink() throws Exception {
		assertNull(history.find(linkMapping));
		history.log(linkMapping, genLink);
		assertSame(genLink, history.find(linkMapping));
		assertNotNull(genLink);
		assertTrue(history.isKnown(linkMapping));		
		history.purge();
		assertNull(history.find(linkMapping));		
	}
	
	public void testFindChildNode() throws Exception {
		assertTrue(history.findChildNodes(nodeMapping).length == 0);
		history.log(nodeMapping, childGenNode);
		assertSame(childGenNode, history.findChildNodes(nodeMapping)[0]);
		assertNotNull(childGenNode);
		
		assertSame(childGenNode, history.find(nodeMapping)[0]);
		assertNull(history.findTopNode(nodeMapping));		
		assertFalse(history.isKnownTopNode(nodeMapping));		
		assertTrue(history.isKnownChildNode(nodeMapping));		
		
		history.purge();
		assertTrue(history.find(nodeMapping).length == 0);		
	}

	public void testFindMultipleChildNodes() throws Exception {
		assertTrue(history.findChildNodes(nodeMapping).length == 0);
		GenChildNode anotherChildGenNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		history.log(nodeMapping, childGenNode);
		history.log(nodeMapping, anotherChildGenNode);

		assertTrue(history.isKnownChildNode(nodeMapping));

		assertNotNull(childGenNode);
		assertNotNull(anotherChildGenNode);

		final List l1 = Arrays.asList(history.findChildNodes(nodeMapping));
		assertTrue(l1.contains(childGenNode));
		assertTrue(l1.contains(anotherChildGenNode));

		final List l2 = Arrays.asList(history.find(nodeMapping));
		assertTrue(l2.contains(childGenNode));
		assertTrue(l2.contains(anotherChildGenNode));

		history.purge();
		assertTrue(history.find(nodeMapping).length == 0);		
	}

	public void testFindTopNode() throws Exception {
		assertNull(history.findTopNode(nodeMapping));
		history.log(nodeMapping, topGenNode);
		assertSame(topGenNode, history.findTopNode(nodeMapping));
		assertNotNull(topGenNode);
		
		assertSame(topGenNode, history.find(nodeMapping)[0]);
		assertTrue(history.findChildNodes(nodeMapping).length == 0);
		
		assertTrue(history.isKnown(nodeMapping));
		assertTrue(history.isKnownTopNode(nodeMapping));		
		assertFalse(history.isKnownChildNode(nodeMapping));
		
		history.purge();
		assertTrue(history.find(nodeMapping).length == 0);
	}

	public void testMultipleElements() throws Exception {
		history.log(GMFMapFactory.eINSTANCE.createNodeMapping(), GMFGenFactory.eINSTANCE.createGenTopLevelNode()); 		
		history.log(nodeMapping, topGenNode);
		assertSame(topGenNode, history.find(nodeMapping)[0]);

		history.log(GMFMapFactory.eINSTANCE.createLinkMapping(), GMFGenFactory.eINSTANCE.createGenLink());		
		history.log(linkMapping, genLink);		
		assertSame(genLink, history.find(linkMapping));		
	}
	
	public void testMetrics() throws Exception {
		MetricRule metric = GMFMapFactory.eINSTANCE.createMetricRule();
		GenMetricRule genMetric = GMFGenFactory.eINSTANCE.createGenMetricRule();
		
		assertNull(history.find(metric));		
		history.log(metric, genMetric);
		assertSame(genMetric, history.find(metric));
		history.purge();
		assertNull(history.find(metric));
	}
}
