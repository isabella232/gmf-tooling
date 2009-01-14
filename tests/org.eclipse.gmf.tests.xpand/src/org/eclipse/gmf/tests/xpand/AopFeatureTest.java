/*
 * Copyright (c) 2005, 2008 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.tests.xpand;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.model.AmbiguousDefinitionException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;

public class AopFeatureTest extends TestCase {
	private ExecutionContextImpl execCtx;

	private StringBuilder buffer;

	private EClassifier oclAnyType;

	private EClassifier oclStringType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		buffer = new StringBuilder();
		execCtx = new ExecutionContextImpl(new Scope(new TestsResourceManager(), null, new BufferOutput(buffer)));

		// ADDED encoding
		// XXX fileEncoding for execContext is odd; perhaps, resourceManager?
		// execCtx.setFileEncoding("ISO-8859-1");
		execCtx.getScope().registerAdvices(prefix() + "Advices1");
		oclAnyType = execCtx.getOCLEnvironment().getOCLStandardLibrary().getOclAny();
		oclStringType = execCtx.getOCLEnvironment().getOCLStandardLibrary().getString();
	}

	public final void test_test1_Object() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest1", oclAnyType, null);
		def.evaluate(execCtx);
		assertEquals("12", buffer.toString());
	}

	public final void test_test2_Object() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest2", oclAnyType, null);
		def.evaluate(execCtx);
		assertEquals("13", buffer.toString());
	}

	public final void test_te2st_Object() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::te2st", oclAnyType, null);
		def.evaluate(execCtx);
		assertEquals("4", buffer.toString());
	}

	public final void test_test1_String() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest1", oclStringType, null);
		def.evaluate(execCtx);
		assertEquals("1258", buffer.toString());
	}

	public final void test_test1_StringParam_String() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest1", oclStringType, new EClassifier[] { oclStringType });
		def.evaluate(execCtx);
		assertEquals("678", buffer.toString());
	}

	public final void test_test1_StringParams_String() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest1", oclStringType, new EClassifier[] { oclStringType, oclStringType });
		def.evaluate(execCtx);
		assertEquals("78", buffer.toString());
	}

	public final void testQualifiedAspect() throws AmbiguousDefinitionException {
		final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::advtest3", oclStringType, null);
		def.evaluate(execCtx);
		assertEquals("15qualified-test3", buffer.toString());
	}

	private static String prefix() {
		return "org::eclipse::gmf::tests::xpand::evaluate::";
	}
}
