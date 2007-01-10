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
package org.eclipse.gmf.tests.expression.ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.expression.EvaluationException;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class EvaluationTest extends AbstractExpressionTest {

	private ExecutionContext ec;

	private ATypeModel aType;

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		aType = new ATypeModel();
		ec = aType.newContext(null);
	}

	public final void testSimple() {
		final Expression expr = parse("true == null");
		final Object result = expr.evaluate(ec);
		assertFalse(((Boolean) result).booleanValue());
	}

	public final void testStaticPropertyCall() {
		final Expression expr = parse(ATypeModel.EVALUATION_TEST_MODEL + SyntaxConstants.NS_DELIM + ATypeModel.ENUM_TYPE_NAME + SyntaxConstants.NS_DELIM + ATypeModel.LITERAL1_NAME);
		final Object result = expr.evaluate(ec);
		EEnumLiteral metaLiteral1 = aType.getMetaEnum().getEEnumLiteral(ATypeModel.LITERAL1_NAME);
		assertEquals(metaLiteral1.getInstance(), result);
	}

	public final void testCollectionLiteral1() {
		final Expression expr = parse("{\"hallo\"}");
		final Object result = expr.evaluate(ec);
		assertEquals("hallo", ((List) result).iterator().next());
	}

	public final void testCollectionLiteral3() {
		final Expression expr = parse("{3}");
		final Object result = expr.evaluate(ec);
		assertEquals(3, ((List) result).iterator().next());
	}

	public final void testCollectionLiteral2() {
		final Expression expr = parse("{\"hallo\",3}");
		final List result = (List) expr.evaluate(ec);
		assertEquals(2, result.size());
		assertEquals("hallo", result.get(0));
		assertEquals(3, result.get(1));
	}

	public final void testFeatureCall() {
		final Expression expr = parse(ATypeModel.TEST_ATTR);
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);
		assertEquals(aType.getATypeTestFeatureValue(), result);
	}

	public final void testFeatureCall1() {
		final Expression expr = parse("this." + ATypeModel.TEST_ATTR);
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);
		assertEquals(aType.getATypeTestFeatureValue(), result);
	}

	// next two tests are checking that != and == operations are available for EObjects

	public final void testEqualsNull() {
		final Expression expr = parse("this == null");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);
		assertEquals(Boolean.FALSE, result);
	}

	public final void testNotEqualsNull() {
		final Expression expr = parse("this != null");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);
		assertEquals(Boolean.TRUE, result);
	}

	public final void testOperationCall1() {
		aType.registerOperations();
		final Expression expr = parse("myOperation()");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);

		assertEquals(ATypeModel.myOperation(), result);
	}

	public final void testOperationCall2() {
		aType.registerOperations();
		final Expression expr = parse("myOperation(\"Test\")");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);

		assertEquals(ATypeModel.myOperation("Test"), result);
	}

	public final void testOperationCall3() {
		aType.registerOperations();
		final Expression expr = parse("this.myOperation()");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);

		assertEquals(ATypeModel.myOperation(), result);
	}

	public final void testOperationCall4() {
		aType.registerOperations();
		final Expression expr = parse("this.myOperation(\"Test\")");
		ec = ec.cloneWithVariable(new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getInstance()));
		final Object result = expr.evaluate(ec);

		assertEquals(ATypeModel.myOperation("Test"), result);
	}

	public final void testArithmetic() {
		Expression expr = parse("3 + 4 * 2");
		assertEquals(11, expr.evaluate(ec));

		expr = parse("4 * 2 + 3");
		assertEquals(11, expr.evaluate(ec));

		expr = parse("4 * 2 + 3 / 3");
		assertEquals(9, expr.evaluate(ec));
	}

	public final void testArithmetic2() {
		Expression expr = parse("3 + 4.0 * 2");
		assertEquals(new Double(11), expr.evaluate(ec));

		expr = parse("4.0 * 2 + 3");
		assertEquals(new Double(11), expr.evaluate(ec));

		expr = parse("4 * 2 + 3 / 3.0");
		assertEquals(new Double(9), expr.evaluate(ec));

	}

	public final void testArithmetic3() {
		Expression expr = parse("5 / 2");
		assertEquals(2, expr.evaluate(ec));

		expr = parse("5 / 2.0");
		assertEquals(new Double(2.5), expr.evaluate(ec));

	}

	public final void testStringConcatenation1() {
		final Expression expr = parse("\"test\" + 3 + 4");
		assertEquals("test7", expr.evaluate(ec));
	}

	public final void testStringConcatenation2() {
		final Expression expr = parse("(\"test\" + 3) + 4");
		assertEquals("test34", expr.evaluate(ec));
	}

	public final void testNullReference() {
		ec = ec.cloneWithVariable(new Variable("nullRef", null));
		final Expression expr = parse("nullRef + \"test\" + 3 + 4");
		assertEquals(null, expr.evaluate(ec));

		ec = ec.cloneWithVariable(new Variable("this", null));
		assertNull(parse("this.unknownMember").evaluate(ec));
	}

	public final void testTypeLiteral1() {
		assertEquals(EcorePackage.eINSTANCE.getEString(), parse("String").evaluate(ec));
	}

	public final void testTypeLiteral2() {
		final Expression e = parse("EClass.getEStructuralFeature('name')");
		assertTrue(e.evaluate(ec) instanceof EStructuralFeature);
	}

	public final void testPath1() {
		final Expression expr = parse("{'a','b','c'}.toUpperCase()");
		final List result = (List) expr.evaluate(ec);
		assertEquals("A", result.get(0));
		assertEquals("B", result.get(1));
		assertEquals("C", result.get(2));
	}

	public final void testPath2() {
		final Expression expr = parse("{'a','b','c'}.size()");
		assertEquals(3, expr.evaluate(ec));
	}

	public final void testPath3() {
		final Expression expr = parse("{'a','b2','c'}.toUpperCase().length()");
		final List result = (List) expr.evaluate(ec);
		assertEquals(1, result.get(0));
		assertEquals(2, result.get(1));
		assertEquals(1, result.get(2));
	}

	public final void testPath4() {
		final Expression expr = parse("{'a,b2,c','a,b,c','a,b,c'}.split(',').length()");
		final List result = (List) expr.evaluate(ec);
		assertEquals(9, result.size());
		assertEquals(1, result.get(0));
		assertEquals(2, result.get(1));
		assertEquals(1, result.get(2));
	}

	public final void testNestedCollExpr() {
		final Expression expr = parse("col.typeSelect(String).forAll(e|" + "col.typeSelect(Integer).exists(a| a == e.length()))");
		final List<Comparable> list = new ArrayList<Comparable>();
		list.add("123");
		list.add("1234");
		list.add("12345");
		list.add(3);
		list.add(4);
		ExecutionContext contextWithVar = ec.cloneWithVariable(new Variable("col", list));
		assertEquals(Boolean.FALSE, expr.evaluate(contextWithVar));
		list.add(5);
		assertEquals(Boolean.TRUE, expr.evaluate(contextWithVar));
	}

	public final void testTypeSelectWithNull() {
		final Expression expr = parse("{null, 'test'}.typeSelect(String).size()");
		assertEquals(1, expr.evaluate(ec));
	}

	public final void testLet1() {
		final Expression expr = parse("let x = {'a,b2,c','a,b,c','1,2,3'} : x.get(1)");
		assertEquals("a,b,c", expr.evaluate(ec));
	}

	public final void testLet2() {
		final Expression expr = parse("let x = {} : x.add('1') -> x.add('2')" + " -> x.add('3') -> x");
		final List<String> l = new ArrayList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		assertEquals(l, expr.evaluate(ec));
	}

	public final void testConstruction() {
		final Expression expr = parse("new String");
		assertEquals("", expr.evaluate(ec));

		try {
			parse("new Unkown").evaluate(ec);
			fail();
		} catch (final EvaluationException ee) {
			// expected
		}
	}
}
