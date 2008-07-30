/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.xpand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.gmf.internal.xpand.xtend.ast.QvtResource;
import org.eclipse.ocl.util.CollectionUtil;

public class QvtExtensions extends TestCase {

	private static final Object[] YES_NO = new Object[] { "YES", "NO" };

	private StringBuilder buffer;

	private TestsResourceManager resourceManager;

	private XpandFacade xpandFacade;

	private XpandExecutionContextImpl execCtx;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		buffer = new StringBuilder();
		resourceManager = new TestsResourceManager();
		execCtx = new XpandExecutionContextImpl(resourceManager, new BufferOutput(buffer), null);
		xpandFacade = new XpandFacade(execCtx);
	}

	public void testQvtLibraryCompilation() {
		QvtResource qvtResource = resourceManager.loadQvtResource("org::eclipse::gmf::tests::xpand::evaluate::QvtLibrary");
		Set<AnalysationIssue> issues = new LinkedHashSet<AnalysationIssue>();
		qvtResource.analyze(execCtx, issues);
		checkIssues(issues);
		XpandResource template = execCtx.findTemplate("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension");
		template.analyze(execCtx, issues);
		checkIssues(issues);
	}

	private void checkIssues(Set<AnalysationIssue> issues) {
		if (issues.size() == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (AnalysationIssue analysationIssue : issues) {
			if (sb.length() > 0) {
				sb.append("\n");
			}
			sb.append(analysationIssue.getMessage());
		}
		fail(sb.toString());
	}

	public void testContextInvocationContextualQuery() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkStringContextInvocation", "ContextString1");
	}

	public void testStatisInvocationContextualQuery() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkStringStaticInvocation", "ContextString2");
	}

	public void testContextInvocationStaticQuery() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkIntConvextInvocation", 10);
	}

	public void testStaticInvocationStaticQuery() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkIntStaticInvocation", 20);
	}

	public void testBooleanTypeQuery() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkBoolean", false);
	}

	// TODO: Plugin test configuration required to execute this kind of test.
	public void _testDeployedMetaType() {
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkDeployedMetaType", EcoreFactory.eINSTANCE.createEAttribute());
	}
	
	// TODO: not sure this is a valid situation from the side of OCL. See
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=242545
	public void _testCollectionOfStrings() {
		List<String> sequence = CollectionUtil.<String>createNewSequence();
		sequence.add("SampleString1");
		sequence.add("SampleString2");
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkCollection", sequence);
	}
	
	public void testSetOfBooleans() {
		Set<Boolean> collection = new HashSet<Boolean>();
		collection.add(true);
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkSet", collection);
	}
	
	public void testSequenceOfBooleans() {
		List<Boolean> collection = new ArrayList<Boolean>();
		collection.add(true);
		collection.add(false);
		collection.add(false);
		collection.add(true);
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkSequence", collection);
	}
	
	public void testBagOfBooleans() {
		List<Boolean> collection = new ArrayList<Boolean>();
		collection.add(true);
		collection.add(false);
		collection.add(false);
		collection.add(true);
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkBag", collection);
	}

	public void testOrderedSetOfIntegers() {
		Set<Integer> collection = new HashSet<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(5);
		collection.add(10);
		checkQueryCall("org::eclipse::gmf::tests::xpand::evaluate::QvtExtension::checkOrderedSet", collection);
	}

	private void checkQueryCall(String queryName, Object selfObject) {
		xpandFacade.evaluate(queryName, selfObject, YES_NO);
		assertEquals(YES_NO[0], buffer.toString());
	}

}
