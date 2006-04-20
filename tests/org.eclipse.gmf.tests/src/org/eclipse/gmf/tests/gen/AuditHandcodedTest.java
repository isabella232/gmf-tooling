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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenRuleTarget;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.jdt.core.JavaConventions;

/**
 * Tests hancoded method in model for audit rule definitions 
 */
public class AuditHandcodedTest extends ConfiguredTestCase {
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
	
	public void testEditorReference() throws Exception {
		GenEditorGenerator editorGenerator = GMFGenFactory.eINSTANCE.createGenEditorGenerator();
		editorGenerator.setAudits(root);
		List audits = root.getAllAuditContainers();
		assertTrue("at least 2 level container nesting required", audits.size() > 1); //$NON-NLS-1$
		for (Iterator it = audits.iterator(); it.hasNext();) {
			GenAuditContainer auditContainer = (GenAuditContainer) it.next();
			assertSame(editorGenerator, auditContainer.getEditor());			
		}
	}
	
	public void testRulesToContextMap() {
		// setup different kinds of targets and assign to audits
		GenDiagramElementTarget diagramElementTarget1 = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
		diagramElementTarget1.setElement(getSetup().getGenModel().getNodeA());
		GenDiagramElementTarget diagramElementTarget2 = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
		diagramElementTarget2.setElement(getSetup().getGenModel().getLinkC());
		
		
		GenDomainElementTarget domainElementTarget = GMFGenFactory.eINSTANCE.createGenDomainElementTarget();
		domainElementTarget.setElement(getSetup().getGenModel().getNodeA().getDomainMetaClass());
		
		GenNotationElementTarget notationElementTarget = GMFGenFactory.eINSTANCE.createGenNotationElementTarget();
		notationElementTarget.setElement(getSetup().getGenModel().getLinkC().getDiagramRunTimeClass());
		
		GenRuleTarget targets[] = new GenRuleTarget[] { 
			diagramElementTarget1, diagramElementTarget2, domainElementTarget, notationElementTarget
		}; 
		
 		final int expectedCtxCount = targets.length - 1; // domain and notation share default context		
		// ensure sufficient number of audits to be distributed accross contexts
		final int minOfAuditsInCtx = 2; 
		final int numberOfAuditsToAdd = expectedCtxCount * minOfAuditsInCtx - root.getAllAuditRules().size();
		for(int i = 0; i < numberOfAuditsToAdd; i++) {
			root.getAudits().add(GMFGenFactory.eINSTANCE.createGenAuditRule());
		}

		Set IDs = new HashSet();
		int i = 0;		
		for (Iterator it = root.getAllAuditRules().iterator(); it.hasNext(); i++) {
			GenAuditRule audit = (GenAuditRule) it.next();
			audit.setTarget((GenAuditable)EcoreUtil.copy(targets[i%targets.length]));
			
			IStatus s = JavaConventions.validateIdentifier(audit.getContextSelectorLocalClassName());
			assertTrue("Context selectorClassLocalName must valid java name", s.getSeverity() != IStatus.ERROR); //$NON-NLS-1$			
			String ctxID = audit.getTarget().getClientContextID();
			s = JavaConventions.validateIdentifier(ctxID);			
			assertTrue("Context ID must be a valid java identifier", s.getSeverity() != IStatus.ERROR); //$NON-NLS-1$
			
			IDs.add(ctxID);
		}
		
		Map ctxMap = root.getAllRulesToTargetContextMap();
		assertNotNull(ctxMap);		
		assertEquals("All target types should be in context map", IDs, ctxMap.keySet()); //$NON-NLS-1$
		assertEquals("Expected context count differs from resulting context map", expectedCtxCount, ctxMap.size()); //$NON-NLS-1$		
		// check values are not empty EList<GenAuditRule>
		int assignedAuditCount = 0;
		for (Iterator it = ctxMap.values().iterator(); it.hasNext();) {
			Object element = it.next();
			assertTrue(element instanceof EList);
			EList values = (EList)element;
			assertFalse(values.isEmpty());
			assertTrue(values.get(0) instanceof GenAuditRule);
			assignedAuditCount += values.size();			
		}		
		assertEquals(root.getAllAuditRules().size(), assignedAuditCount);
		
		// test Diagram or notation element targeted audit checker method
		assertTrue("Diagram rule should be found", root.hasDiagramElementRule()); //$NON-NLS-1$
		
		assertTargetedModels(targets);		
	}
	
	public void testModelConstraintAdapters() throws Exception {
		HashSet adapterClassNames = new LinkedHashSet();
		for (Iterator it = allAudits.iterator(); it.hasNext();) {
			GenAuditRule nextAudit = (GenAuditRule) it.next();
			adapterClassNames.add(nextAudit.getConstraintAdapterLocalClassName());
		}
		assertEquals("Constraint adapter classnames should be unique for audits", //$NON-NLS-1$
			allAudits.size(), adapterClassNames.size());		

		assertEquals("Adapter1", rule0.getConstraintAdapterLocalClassName()); //$NON-NLS-1$
		assertEquals("Adapter11", rule1.getConstraintAdapterLocalClassName()); //$NON-NLS-1$		
		assertEquals("Adapter111", rule2.getConstraintAdapterLocalClassName()); //$NON-NLS-1$		
		
		GenAuditContainer container12 = GMFGenFactory.eINSTANCE.createGenAuditContainer();
		child1.getChildContainers().add(container12);		
		GenAuditRule child123 = GMFGenFactory.eINSTANCE.createGenAuditRule();
		container12.getAudits().add(GMFGenFactory.eINSTANCE.createGenAuditRule());
		container12.getAudits().add(GMFGenFactory.eINSTANCE.createGenAuditRule());
		container12.getAudits().add(child123);
		assertEquals("Adapter123", child123.getConstraintAdapterLocalClassName()); //$NON-NLS-1$		
	}
	
	private void assertTargetedModels(GenRuleTarget[] targets) {
		EList packageList = root.getAllTargetedModelPackages();
		assertFalse(packageList.isEmpty());
		Set collectedPackages = new HashSet();
		for (Iterator it = packageList.iterator(); it.hasNext();) {
			collectedPackages.add(it.next());			
		}
		for (int i = 0; i < targets.length; i++) {
			assertTrue("Package must be found targeted packages", //$NON-NLS-1$
					collectedPackages.contains(targets[i].getContext().getGenPackage()));					
		}
	}
}
