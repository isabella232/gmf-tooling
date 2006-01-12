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
package org.eclipse.gmf.tests.gen;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;

/**
 * Tests hancoded method in model for audit rule definitions 
 */
public class AuditHandcodedTest extends TestCase {
	private List allAudits;
	private List containers;	
	private GenAuditContainer root;
	private GenAuditContainer child1;
	private GenAuditContainer child2;
	
	private GenAuditRule rule0;	
	private GenAuditRule rule1;
	private GenAuditRule rule2;	

	public AuditHandcodedTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		allAudits = new ArrayList();
		containers = new ArrayList();
		
		containers.add(root = GMFGenFactory.eINSTANCE.createGenAuditContainer());
		allAudits.add(rule0 = GMFGenFactory.eINSTANCE.createGenAuditRule());
		root.getAudits().add(rule0);
		
		containers.add(child1 = GMFGenFactory.eINSTANCE.createGenAuditContainer());						
		root.getChildContainers().add(child1);
		allAudits.add(rule1 = GMFGenFactory.eINSTANCE.createGenAuditRule());		
		child1.getAudits().add(rule1);		
		
		containers.add(child2 = GMFGenFactory.eINSTANCE.createGenAuditContainer());
		allAudits.add(rule2 = GMFGenFactory.eINSTANCE.createGenAuditRule());		
		child2.getAudits().add(rule2);
		child1.getChildContainers().add(child2);		
	}

	public void testPath() throws Exception {
		assertEquals(root.getPath().size(), 1);		
		assertEquals(root.getPath().get(0), root);		
		
		assertEquals(child1.getPath().size(), 2);		
		assertEquals(child1.getPath().get(0), root);		
		assertEquals(child1.getPath().get(1), child1);		
	}
	
	public void testGetAllAudits() throws Exception {
		assertEquals(allAudits, root.getAllAuditRules());		
	}
	
	public void testGetAllContainers() throws Exception {
		assertEquals(containers, root.getAllAuditContainers());						
	}	
}
