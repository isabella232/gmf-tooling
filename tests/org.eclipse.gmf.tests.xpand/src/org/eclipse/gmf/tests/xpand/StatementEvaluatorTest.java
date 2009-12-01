/*
 * Copyright (c) 2005, 2009 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Alexander Shatalin (Borland) - QVTO migration
 */
package org.eclipse.gmf.tests.xpand;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.ast.Definition;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Output;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.XpandResource;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;

/**
 * FIXME move tests with parse() only to StatementParserTest 
 * @author Sven Efftinge
 */
public class StatementEvaluatorTest extends AbstractXpandTest {

	private ExecutionContextImpl execCtx;

	private BufferOutput out;

	private StringBuilder buffer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// [radvorak]
		// Consider to avoid this code
		if (QvtPlugin.getDefault() == null) {
			new QvtPlugin();
		}
		buffer = new StringBuilder();
		out = new BufferOutput(buffer);
		execCtx = createCtx(out);
	}

	private ExecutionContextImpl createCtx(Output out) {
		buffer.setLength(0);
		final ExecutionContextImpl result = new ExecutionContextImpl(new Scope(new TestsResourceManager(), null, out));
		// result.setFileEncoding("iso-8859-1");
		result.getScope().setEvaluationListener(new DumpEvaluationListener());
		return result;
	}

	// FIXME get started with simple test - no params, no extensions, no operations
	public final void testEvaluation() throws Exception {
		final String id = "org::eclipse::gmf::tests::xpand::evaluate::EvaluateStart::start";

		new XpandFacade(execCtx).evaluate(id, "test", new Object[0]);
		System.out.println(buffer.toString());
	}

	public final void testIf() throws Exception {
		final XpandResource t = parse(tag("DEFINE test FOR ecore::EClass") + tag("IF test=1") + "if" + tag("ELSEIF test=2") + "elseif" + tag("ELSE") + "else" + tag("ENDIF") + tag("ENDDEFINE"));
		assertEquals(1, t.getDefinitions().length);

		final XpandDefinition temlateWithIf = t.getDefinitions()[0];
		// any EClass instance for 'this'
		final Variable self = new Variable(ExecutionContext.IMPLICIT_VARIABLE, EcorePackage.eINSTANCE.getEClass(), EcorePackage.eINSTANCE.getEAnnotation());

		final ExecutionContext ctx = createCtx(out).cloneWithVariable(self, new Variable("test", null, new Integer(1)));
		temlateWithIf.evaluate(ctx);
		assertEquals("if", buffer.toString().trim());

		temlateWithIf.evaluate(createCtx(out).cloneWithVariable(self, new Variable("test", null, new Integer(2))));
		assertEquals("elseif", buffer.toString().trim());

		temlateWithIf.evaluate(createCtx(out).cloneWithVariable(self, new Variable("test", null, new Integer(3))));
		assertEquals("else", buffer.toString().trim());
	}

	public final void testForeach() throws Exception {
		// any EClass instance for 'this'
		final Variable self = new Variable(ExecutionContext.IMPLICIT_VARIABLE, EcorePackage.eINSTANCE.getEClass(), EcorePackage.eINSTANCE.getEAnnotation());

		final List<String> tests = new ArrayList<String>();

		createDefineWithForeach().evaluate(createCtx(out).cloneWithVariable(self, new Variable("tests", null, tests)));
		assertEquals("", buffer.toString().trim());

		tests.add("hallo");
		createDefineWithForeach().evaluate(createCtx(out).cloneWithVariable(self, new Variable("tests", null, tests)));
		assertEquals("hallo", buffer.toString().trim());

		tests.add("Du");
		createDefineWithForeach().evaluate(createCtx(out).cloneWithVariable(self, new Variable("tests", null, tests)));
		assertEquals("hallo,Du", buffer.toString().trim());

		tests.add("da");
		createDefineWithForeach().evaluate(createCtx(out).cloneWithVariable(self, new Variable("tests", null, tests)));
		assertEquals("hallo,Du,da", buffer.toString().trim());
	}

	private XpandDefinition createDefineWithForeach() throws Exception {
		final XpandResource t = parse(tag("DEFINE test FOR ecore::EClass") + tag("FOREACH tests AS test SEPARATOR ','") + tag("test") + tag("ENDFOREACH") + tag("ENDDEFINE"));
		assertEquals(1, t.getDefinitions().length);

		final XpandDefinition defineWithForeach = t.getDefinitions()[0];
		return defineWithForeach;
	}

	public final void testMultilineText() throws Exception {
		String text = "abc\r\ncba";
		String str = tag("DEFINE z FOR o") + text + tag("ENDDEFINE");
		Template t = parse(str);
		assertNotNull(t);
		TextStatement textStmt = (TextStatement) ((Definition) t.getDefinitions()[0]).getBody()[0];
		assertEquals(text, textStmt.getValue());
	}

	public final void testTrailingText() {
		String str = tag("DEFINE z FOR o") + "abc" + tag("ENDDEFINExxx");
		try {
			Template t = parse(str);
			assertNull(t);
		} catch (Exception ex) {
			ex.printStackTrace();
			fail("Parsing should not fail with exception ("+ ex.getClass().getSimpleName() +")even when the grammar is incorrect");
		}
	}

	public final void testCommentOnly() throws Exception {
		assertNotNull(parse(tag("REM") + "zx" + tag("ENDREM")));
	}
	
	public final void testCommentNestedTag() throws Exception {
		String nestedTag = tag("DEFINE") + "placeholder" + tag("ENDDEFINE");
		String string = tag("REM") + " bla-bla " + nestedTag + " foo"+ tag("ENDREM");
		// just to add any define after comment to actually check nested comment but not comment-only file
		string += tag("DEFINE z FOR o") + tag("ENDDEFINE"); 
		assertNotNull(parse(string));
	}

	public final void testWhitespacesAtTopLevel() throws Exception {
		String text = tag("REM") + "zx" + tag("ENDREM");
		//String text = tag("IMPORT 'aaaa'");
		text += "\r\n"; // intermediate
		text += tag("DEFINE test FOR Object") + tag("ENDDEFINE");
		text += "\r"; // trailing
		assertNotNull(parse(text));
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
		new XpandFacade(execCtx).evaluate(id, "X", new Object[0]);
		final String[] result = buffer.toString().trim().split(",");
		assertEquals("XXX", result[0].trim());
		assertEquals("XXXXX", result[1].trim());
		assertEquals("1X2X3X", result[2].trim());
		assertEquals("3X3X3X", result[3].trim());
	}

	public void testReferenceAnotherDefinition() throws Exception {
		String test = tag("DEFINE test FOR String") + "TEST" + tag("EXPAND test2") + tag("ENDDEFINE");
		String test2 = tag("DEFINE test2 FOR String") + "2" + tag("ENDDEFINE");
		final XpandResource t = parse(test + "\n" + test2);
		XpandDefinition xpandDefinition = t.getDefinitions()[0];
		ExecutionContext ctx = new ExecutionContextImpl(new Scope(out) {});
		ctx = ctx.cloneWithVariable(new Variable("this", null, ""));
		xpandDefinition.evaluate(ctx);
		assertEquals("TEST2", buffer.toString());
	}
}