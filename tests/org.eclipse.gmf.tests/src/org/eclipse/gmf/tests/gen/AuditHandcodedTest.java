/*
 * Copyright (c) 2005, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Radek Dvorak (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - GenAuditRoot introduced, GenAuditContainers flattened
 */
package org.eclipse.gmf.tests.gen;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenAuditable;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget;
import org.eclipse.gmf.codegen.gmfgen.GenRuleTarget;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;

/**
 * Tests hancoded method in model for audit rule definitions 
 */
public class AuditHandcodedTest extends ConfiguredTestCase {
	private final String javaLevel = JavaCore.VERSION_1_4;

	private GenAuditRoot root;
	private GenAuditContainer topCat;
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
		root = GMFGenFactory.eINSTANCE.createGenAuditRoot();
		
		root.getCategories().add(topCat = GMFGenFactory.eINSTANCE.createGenAuditContainer());
		topCat.getPath().add(topCat);
		root.getRules().add(rule0 = GMFGenFactory.eINSTANCE.createGenAuditRule());
		rule0.setCategory(topCat);

		root.getCategories().add(child1 = GMFGenFactory.eINSTANCE.createGenAuditContainer());						
		child1.getPath().add(topCat);
		child1.getPath().add(child1);
		root.getRules().add(rule1 = GMFGenFactory.eINSTANCE.createGenAuditRule());		
		rule1.setCategory(child1);
		
		root.getCategories().add(child2 = GMFGenFactory.eINSTANCE.createGenAuditContainer());
		child2.getPath().add(topCat);		
		child2.getPath().add(child1);		
		child2.getPath().add(child2);		
		root.getRules().add(rule2 = GMFGenFactory.eINSTANCE.createGenAuditRule());		
		rule2.setCategory(child2);
	}

	public void testRulesToContextMap() {
		// setup different kinds of targets and assign to audits
		GenDiagramElementTarget diagramElementTarget1 = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
		diagramElementTarget1.getElement().add(getSetup().getGenModel().getNodeA());
		GenDiagramElementTarget diagramElementTarget2 = GMFGenFactory.eINSTANCE.createGenDiagramElementTarget();
		diagramElementTarget2.getElement().add(getSetup().getGenModel().getLinkC());
		
		
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
		final int numberOfAuditsToAdd = expectedCtxCount * minOfAuditsInCtx - root.getRules().size();
		for(int i = 0; i < numberOfAuditsToAdd; i++) {
			GenAuditRule r;
			root.getRules().add(r = GMFGenFactory.eINSTANCE.createGenAuditRule());
			r.setCategory(topCat);
		}

		int i = 0;		
		for (GenAuditRule audit : root.getRules()) {
			audit.setTarget((GenAuditable)EcoreUtil.copy(targets[i%targets.length]));
			
			IStatus s = JavaConventions.validateIdentifier(audit.getContextSelectorLocalClassName(), javaLevel, javaLevel);
			assertTrue("Context selectorClassLocalName must valid java name", s.getSeverity() != IStatus.ERROR); //$NON-NLS-1$			
			String ctxID = audit.getTarget().getClientContextID();
			s = JavaConventions.validateIdentifier(ctxID, javaLevel, javaLevel);
			assertTrue("Context ID must be a valid java identifier", s.getSeverity() != IStatus.ERROR); //$NON-NLS-1$
			i++;
		}
		
		assertTargetedModels(targets);		
	}
	
	public void testModelConstraintAdapters() throws Exception {
		int i = 1;
		for (GenAuditRule nextAudit : root.getRules()) {
			assertEquals("Adapter" + i, nextAudit.getConstraintAdapterLocalClassName()); //$NON-NLS-1$
			i++;
		}
	}
	
	private void assertTargetedModels(GenRuleTarget[] targets) {
		List<GenPackage> packageList = root.getTargetedModelPackages();
		assertFalse(packageList.isEmpty());
		for (int i = 0; i < targets.length; i++) {
			assertTrue("Package must be found targeted packages", //$NON-NLS-1$
					packageList.contains(targets[i].getContext().getGenPackage()));					
		}
	}
}
