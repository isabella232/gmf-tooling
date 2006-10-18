/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.tests.xpand;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.tests.xpand.output.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.ast.Definition;
import org.eclipse.gmf.internal.xpand.ast.ForEachStatement;
import org.eclipse.gmf.internal.xpand.ast.IfStatement;
import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.model.Output;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.XpandResource;

/**
 * *
 * 
 * @author Sven Efftinge *
 */
public class StatementEvaluatorTest extends AbstractXpandTest {

	private XpandExecutionContextImpl execCtx;

	private BufferOutput out;

	private StringBuilder buffer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		buffer = new StringBuilder();
		out = new BufferOutput(buffer);
		execCtx = createCtx(out);
	}

	private XpandExecutionContextImpl createCtx(Output out) {
		buffer.setLength(0);
		final XpandExecutionContextImpl result = new XpandExecutionContextImpl(new TestsResourceManager(), out, null);
		// result.setFileEncoding("iso-8859-1");
		return result;
	}

	public final void testEvaluation() throws Exception {
		final String id = "org::eclipse::gmf::tests::xpand::evaluate::EvaluateStart::start";

		new XpandFacade(execCtx).evaluate(id, "test", new Object[0]);
		System.out.println(buffer.toString());
	}

	public final void testIf() throws Exception {
		final XpandResource t = parse(tag("DEFINE test FOR ecore::EClass") + tag("IF test==1") + "if" + tag("ELSEIF test==2") + "elseif" + tag("ELSE") + "else" + tag("ENDIF") + tag("ENDDEFINE"));
		assertEquals(1, t.getDefinitions().length);

		final IfStatement ifSt = ((IfStatement) ((Definition) t.getDefinitions()[0]).getBody()[1]);

		final XpandExecutionContext ctx = (XpandExecutionContext) createCtx(out).cloneWithVariable(new Variable("test", new Integer(1)));
		ifSt.evaluate(ctx);
		assertEquals("if", buffer.toString());

		ifSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("test", new Integer(2))));
		assertEquals("elseif", buffer.toString());

		ifSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("test", new Integer(3))));
		assertEquals("else", buffer.toString());
	}

	public final void testForeach() throws Exception {
		final XpandResource t = parse(tag("DEFINE test FOR ecore::EClass") + tag("FOREACH tests AS test SEPARATOR ','") + tag("test") + tag("ENDFOREACH") + tag("ENDDEFINE"));
		assertEquals(1, t.getDefinitions().length);

		final ForEachStatement foreachSt = (ForEachStatement) ((Definition) t.getDefinitions()[0]).getBody()[1];

		final List<String> tests = new ArrayList<String>();

		foreachSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("tests", tests)));
		assertEquals("", buffer.toString());

		tests.add("hallo");
		foreachSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("tests", tests)));
		assertEquals("hallo", buffer.toString());

		tests.add("Du");
		foreachSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("tests", tests)));
		assertEquals("hallo,Du", buffer.toString());

		tests.add("da");
		foreachSt.evaluate((XpandExecutionContextImpl) createCtx(out).cloneWithVariable(new Variable("tests", tests)));
		assertEquals("hallo,Du,da", buffer.toString());
	}

	public final void testComment() throws Exception {
		// FIXME this is not evaluation test, move to better location
		// TODO test both empty and non-empty comments
		final XpandResource t = parse(tag("DEFINE test FOR ecore::EClass") + "TEST" + tag("REM") + "zx" + tag("ENDREM") + "test" + tag("FOREACH tests AS test SEPARATOR ','") + tag("test") + tag("ENDFOREACH") + tag("ENDDEFINE"));
		TextStatement text = (TextStatement) ((Definition) t.getDefinitions()[0]).getBody()[0];
		assertEquals("TEST", text.getValue());
		text = (TextStatement) ((Definition) t.getDefinitions()[0]).getBody()[1];
		assertEquals("test", text.getValue());
	}

	public final void testMultiParams1() throws Exception {
		final String id = "org::eclipse::gmf::tests::xpand::evaluate::MultiParams::test";
		new XpandFacade(execCtx).evaluate(id, "A", new Object[] { "B", "C" });
		assertEquals("ABC1", buffer.toString());
	}

	public final void testMultiParams2() throws Exception {
		final String id = "org::eclipse::gmf::tests::xpand::evaluate::MultiParams::test";
		new XpandFacade(execCtx).evaluate(id, "A", new Object[] { "B", new Integer(1) });
		assertEquals("AB12", buffer.toString());
	}

	public final void testForeach2() throws Exception {
		final String id = "org::eclipse::gmf::tests::xpand::evaluate::Foreach::test";
		new XpandFacade(execCtx).evaluate(id, "ABC", new Object[0]);
		final String[] result = buffer.toString().trim().split(",");
		assertEquals("ABC", result[0].trim());
		assertEquals("AABCBABCC", result[1].trim());
//		assertEquals("1A2B3C", result[2].trim()); XXX uncomment iterator in Foreach.xpt
	}

}