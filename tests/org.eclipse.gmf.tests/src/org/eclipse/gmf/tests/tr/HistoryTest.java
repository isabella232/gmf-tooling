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

import junit.framework.TestCase;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.internal.bridge.History;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
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
		assertNull(history.findChildNode(nodeMapping));
		history.log(nodeMapping, childGenNode);
		assertSame(childGenNode, history.findChildNode(nodeMapping));
		assertNotNull(childGenNode);
		
		assertSame(childGenNode, history.find(nodeMapping));
		assertNull(history.findTopNode(nodeMapping));		
		assertFalse(history.isKnownTopNode(nodeMapping));		
		assertTrue(history.isKnownChildNode(nodeMapping));		
		
		history.purge();
		assertNull(history.find(nodeMapping));		
	}
	
	public void testFindTopNode() throws Exception {
		assertNull(history.findTopNode(nodeMapping));
		history.log(nodeMapping, topGenNode);
		assertSame(topGenNode, history.findTopNode(nodeMapping));
		assertNotNull(topGenNode);
		
		assertSame(topGenNode, history.find(nodeMapping));
		assertNull(history.findChildNode(nodeMapping));
		
		assertTrue(history.isKnown(nodeMapping));
		assertTrue(history.isKnownTopNode(nodeMapping));		
		assertFalse(history.isKnownChildNode(nodeMapping));
		
		history.purge();
		assertNull(history.find(nodeMapping));
	}

	public void testMultipleElements() throws Exception {
		history.log(GMFMapFactory.eINSTANCE.createNodeMapping(), GMFGenFactory.eINSTANCE.createGenTopLevelNode()); 		
		history.log(nodeMapping, topGenNode);
		assertSame(topGenNode, history.find(nodeMapping));

		history.log(GMFMapFactory.eINSTANCE.createLinkMapping(), GMFGenFactory.eINSTANCE.createGenLink());		
		history.log(linkMapping, genLink);		
		assertSame(genLink, history.find(linkMapping));		
	}
}
