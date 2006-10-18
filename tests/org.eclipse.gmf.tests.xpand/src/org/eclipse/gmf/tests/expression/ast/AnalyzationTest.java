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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.SyntaxConstants;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.expression.ast.ChainExpression;
import org.eclipse.gmf.internal.xpand.expression.ast.Expression;
import org.eclipse.gmf.internal.xpand.expression.ast.SwitchExpression;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class AnalyzationTest extends AbstractExpressionTest {

    private Set<AnalysationIssue> issues;

    private ExecutionContext ec;
    private ATypeModel aType;

    @Override
    protected void setUp() throws Exception {
    	aType = new ATypeModel();
        ec = aType.newContext(null);
        issues = new HashSet<AnalysationIssue>();
    }

    private void dumpIssues() {
        for (final Iterator<AnalysationIssue> iter = issues.iterator(); iter.hasNext();) {
            final AnalysationIssue element = iter.next();
            System.out.println(element.getType().toString() + " - " + element.getMessage());
        }
    }

    public final void testEquals() {
        final Expression expr = parse("true == null");
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), result);
        assertTrue(issues.isEmpty());
    }

    /**
     * XXX same as {@link #testTypeLiteral3()}?
     */
    public final void testStaticPropertyCall() {
    	final Expression expr = parse(ATypeModel.EVALUATION_TEST_MODEL + SyntaxConstants.NS_DELIM + ATypeModel.ENUM_TYPE_NAME + SyntaxConstants.NS_DELIM + ATypeModel.LITERAL1_NAME);
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getMetaEnum(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testCollectionLiteral1() {
        final Expression expr = parse("{\"hallo\"}");
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), result);
        assertTrue(issues.isEmpty());
    }

    public final void testCollectionLiteral3() {
        final Expression expr = parse("{3}");
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEInt()), result);
        assertTrue(issues.isEmpty());
    }

    public final void testCollectionLiteral2() {
        final Expression expr = parse("{\"hallo\",3}");
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEJavaObject()), result);
        assertTrue(issues.isEmpty());
    }

    public final void testFeatureCall() {
        final Expression expr = parse(ATypeModel.TEST_ATTR);
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getTestMetaAttr().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testFeatureCall1() {
        final Expression expr = parse("this." + ATypeModel.TEST_ATTR);
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getTestMetaAttr().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testOperationCall1() {
        final Expression expr = parse(ATypeModel.OPERATION_NAME + "()");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getMetaOp1().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testOperationCall2() {
        final Expression expr = parse(ATypeModel.OPERATION_NAME + "(\"Test\")");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getMetaOp2().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testOperationCall3() {
        final Expression expr = parse("this." + ATypeModel.OPERATION_NAME + "()");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getMetaOp1().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testOperationCall4() {
        final Expression expr = parse("this." + ATypeModel.OPERATION_NAME + "(\"Test\")");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(aType.getMetaOp2().getEType(), result);
        assertTrue(issues.isEmpty());
    }

    public final void testSwitchExpr() {
        final SwitchExpression expr = (SwitchExpression) parse("switch (3) { case \"Test\" : true default : false }");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(1, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), result);

    }

    public final void testSwitchExpr1() {
        final SwitchExpression expr = (SwitchExpression) parse("switch (\"Horst\") { case \"Test\" : true default : 3 }");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEJavaObject(), result);

    }

    public final void testSwitchExpr2() {
    	// FIXME test for switch {case Test == null : true} once switch without condition supported
        final SwitchExpression expr = (SwitchExpression) parse("switch (\"\") { case \"Test\" : true default : false }");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), result);

    }

    public final void testChainExpr() {
        final ChainExpression expr = (ChainExpression) parse("switch ('') { case \"Test\" : true default : false } -> 3");
        ec =  ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEInt(), result);
    }

    public final void testChainExpr1() {
        final ChainExpression expr = (ChainExpression) parse("true -> List[Object] -> 3 -> \"Test\"");
        ec = ec.cloneWithVariable(newThisATypeVariable());
        final EClassifier result = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEString(), result);
    }

	private Variable newThisATypeVariable() {
		return new Variable(ExecutionContext.IMPLICIT_VARIABLE, aType.getMetaType());
	}

    public final void testTypeLiteral1() {
        assertEquals(EcorePackage.eINSTANCE.getEClass(), parse("String").analyze(ec, new HashSet<AnalysationIssue>()));
    }

    public final void testTypeLiteral2() {
        final Expression e = parse("EClass.getEStructuralFeature('name')");
        EClassifier result = e.analyze(ec, new HashSet<AnalysationIssue>());
		assertEquals(EcorePackage.eINSTANCE.getEStructuralFeature(), result);
    }

    public final void testTypeLiteral3() {
        final Expression e = parse(ATypeModel.ENUM_TYPE_NAME + "::" + ATypeModel.LITERAL1_NAME);
        EClassifier result = e.analyze(ec, new HashSet<AnalysationIssue>());
		assertEquals(aType.getMetaEnum(), result);
    }

    public final void testSelect() {
        final Expression expr = parse(aType.getMetaType().getName() + ".eStructuralFeatures.select(element.name=='" + ATypeModel.TEST_ATTR + "').toList().get(0)");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertNotNull(t);
        // unless our operations on dynamic lists are typed (now they are static with Object as Collection's innerType) 
        // XXX assertEquals(EcorePackage.eINSTANCE.getEStructuralFeature(), t);
    }

    public final void testTypeSelect() {
        final Expression expr = parse("{3.4,3}.typeSelect(Integer)");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEInt()), t);
    }

    public final void testPath1() {
        final Expression expr = parse("{'a','b','c'}.toUpperCase()");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), t);
    }

    public final void testPath2() {
        final Expression expr = parse("{'a','b','c'}.size()");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEInt(), t);
    }

    public final void testPath3() {
        final Expression expr = parse("{'a','b','c'}.toUpperCase().length()");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEInt()), t);
    }

    public final void testPath4() {
        final Expression expr = parse("{'a,b,c','a,b,c','a,b,c'}.split(',').length()");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEInt()), t);
    }

    public final void testImplies() {
        final Expression expr = parse("true implies false");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), t);
    }

    public final void testImplies1() {
        final Expression expr = parse("true implies null");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(1, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), t);
    }

    public final void testLet1() {
        final Expression expr = parse("let x = true : x");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEBoolean(), t);
    }

    public final void testLet2() {
        final Expression expr = parse("let x = true : 'test'+x");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEString(), t);
    }

    public final void testLet3() {
        final Expression expr = parse("let x = stuff : true");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(1, issues.size());
        assertNull(t);
    }

    public final void testCast1() {
        final Expression expr = parse("(List[String]) {}");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), t);
    }

    public final void testCast2() {
        final Expression expr = parse("(Collection[String]) {}");
        final EClassifier t = expr.analyze(ec, issues);
        dumpIssues();
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), t);
    }

    public final void testConstruction() {
        Expression expr = parse("new String");
        EClassifier t = expr.analyze(ec, issues);
        assertEquals(0, issues.size());
        assertEquals(EcorePackage.eINSTANCE.getEString(), t);

        expr = parse("new Unknown");
        t = expr.analyze(ec, issues);
        assertEquals(1, issues.size());
        assertNull(t);
    }
    
}
