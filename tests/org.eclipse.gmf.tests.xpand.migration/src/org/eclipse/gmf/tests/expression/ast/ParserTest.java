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

import org.eclipse.gmf.internal.xpand.expression.ast.BooleanLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.Case;
import org.eclipse.gmf.internal.xpand.expression.ast.Cast;
import org.eclipse.gmf.internal.xpand.expression.ast.ChainExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.expression.ast.FeatureCall;
import org.eclipse.gmf.internal.xpand.expression.ast.IfExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.IntegerLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.ListLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.NullLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.OperationCall;
import org.eclipse.gmf.internal.xpand.expression.ast.StringLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.SwitchExpression;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class ParserTest extends AbstractExpressionTest {

    public final void testSimple() {
        final Expression expr = parse("true == null");
        assertTrue(expr instanceof OperationCall);
        final OperationCall op = (OperationCall) expr;
        assertTrue(op.getTarget() instanceof BooleanLiteral);
        assertTrue(op.getParams()[0] instanceof NullLiteral);
    }

    public final void testSimple2() {
        final Expression expr = parse("String.feature.test(true, {\"test\",\"hallo\"})");
        assertTrue(expr instanceof OperationCall);
        final OperationCall op = (OperationCall) expr;
        assertEquals("test", op.getName().getValue());

        assertTrue(op.getTarget() instanceof FeatureCall);
        FeatureCall tl = (FeatureCall) op.getTarget();
        assertEquals("feature", tl.getName().getValue());
        tl = (FeatureCall) tl.getTarget();
        assertEquals("String", tl.getName().getValue());

        assertTrue(op.getParams().length == 2);
        assertTrue(op.getParams()[0] instanceof BooleanLiteral);
        final ListLiteral colLit = (ListLiteral) op.getParams()[1];
        assertEquals(2, colLit.getElements().length);
        assertEquals("\"test\"", ((StringLiteral) colLit.getElements()[0]).getLiteralValue());
        assertEquals("\"hallo\"", ((StringLiteral) colLit.getElements()[1]).getLiteralValue());
    }

    public final void testIfExpression() {
        final Expression expr = parse("(client.sIdent1 != null) ? client.sIdent1 : \"XXXXXXXX\"");
        assertTrue(expr instanceof IfExpression);
    }

    public final void testEscaped() {
        final Expression expr = parse("\"\\\"\"");
        assertTrue(expr instanceof StringLiteral);
        assertEquals("\"", ((StringLiteral) expr).getValue());
    }

    public final void testNot() {
        final Expression expr = parse("! ts.checked");
        assertNotNull(expr);
    }

    public final void testCast() {
        final Expression expr = parse("(List[InnerType]) anExpr");
        assertNotNull(expr);
        final Cast cast = (Cast) expr;
        assertEquals("List[InnerType]", cast.getType().getValue());
        final FeatureCall fc = (FeatureCall) cast.getTarget();
        assertEquals("anExpr", fc.getName().getValue());
        assertNull(fc.getTarget());
    }

    public final void testSwitch() {
        SwitchExpression expr = (SwitchExpression) parse("switch (5) { default : true }");
        assertNotNull(expr.getSwitchExpr());
        assertTrue(expr.getCases().isEmpty());
        assertEquals("true", ((BooleanLiteral) expr.getDefaultExpr()).getLiteralValue());

        expr = (SwitchExpression) parse("switch (\"test\") { case \"horst\": false default : true }");
        assertEquals("\"test\"", ((StringLiteral) expr.getSwitchExpr()).getLiteralValue());
        final Case c = expr.getCases().get(0);
        assertEquals("\"horst\"", ((StringLiteral) c.getCondition()).getLiteralValue());
        assertEquals("false", ((BooleanLiteral) c.getThenPart()).getLiteralValue());

        assertEquals("true", ((BooleanLiteral) expr.getDefaultExpr()).getLiteralValue());
    }

    public final void testChainExpression() {
        final ChainExpression expr = (ChainExpression) parse("1 -> 2 -> 3 -> 4");
        assertEquals("4", expr.getNext().toString());
        assertEquals("1->2->3", expr.getFirst().toString());
    }

    public final void testPositionInfo() {
        final Expression exp = parse("\n\n\n1");
        assertEquals(4, exp.getLine());
        assertEquals(0, exp.getStart());
        assertEquals(1, exp.getEnd());

    }

    public final void testPositionInfo2() {
        final Expression exp = parse("/*\n\n\n*/1");
        assertEquals(4, exp.getLine());
        assertEquals(2, exp.getStart());
        assertEquals(3, exp.getEnd());
    }

    public final void testPositionInfo3() {
        final OperationCall exp = (OperationCall) parse("'/*\\n\\n\\n*/'+1");
        assertEquals(1, exp.getLine());
        assertEquals(0, exp.getStart());
        assertEquals(14, exp.getEnd());
        final StringLiteral target = (StringLiteral) exp.getTarget();
        assertEquals(1, target.getLine());
        assertEquals(0, target.getStart());
        assertEquals(12, target.getEnd());
        final IntegerLiteral param = (IntegerLiteral) exp.getParams()[0];
        assertEquals(1, param.getLine());
        assertEquals(13, param.getStart());
        assertEquals(14, param.getEnd());
    }

    public final void testTypeLiterals() {
        final Expression e = parse("{  Object,\n String,\n Collection[A],\n Set[B],\n List[C],\n"
                + " oaw::Type,\n oaw::Feature,\n oaw::Property\n}");

        assertNotNull(e);
    }
}
