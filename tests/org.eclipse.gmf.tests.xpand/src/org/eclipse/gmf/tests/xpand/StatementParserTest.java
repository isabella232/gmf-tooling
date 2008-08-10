/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.tests.xpand;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.internal.xpand.ast.AbstractDefinition;
import org.eclipse.gmf.internal.xpand.ast.Definition;
import org.eclipse.gmf.internal.xpand.ast.FileStatement;
import org.eclipse.gmf.internal.xpand.ast.IfStatement;
import org.eclipse.gmf.internal.xpand.ast.Statement;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.ast.TextStatement;
import org.eclipse.gmf.internal.xpand.ocl.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.ocl.ExpressionHelper;

/**
 * *
 * 
 * @author Sven Efftinge *
 */
public class StatementParserTest extends AbstractXpandTest {

    public final void testEmptyTemplate() throws Exception {
        final Template t = parse("");
        assertEquals(0, t.getDefinitions().length);
    }

    public final void testSimpleDefine() throws Exception {
        final Template t = parse(tag("DEFINE test FOR ecore::EClass") + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);
    }

    public final void testTextStmtWithUnusualChars() throws Exception {
    	final String unusualChars = "$";
        final Template t = parse(tag("DEFINE test FOR ecore::EClass") + unusualChars + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);
        Statement st = ((AbstractDefinition) t.getDefinitions()[0]).getBody()[0];
        assertTrue(st instanceof TextStatement);
        assertEquals(unusualChars, ((TextStatement) st).getValue());
    }

    public final void testDoubleDefine() throws Exception {
        final Template t = parse(tag("DEFINE test FOR ecore::EClass") + tag("ENDDEFINE")
                + tag("DEFINE test2(txt:String) FOR ecore::EClass") + tag("ENDDEFINE"));
        assertEquals(2, t.getDefinitions().length);
    }

    public final void testMoreComplexDefine() throws Exception {
        final Template t = parse(tag("DEFINE test(a : ecore::EPackage, b : String) FOR ecore::EClass")
                + tag("FILE name+'.txt'") + "Text und so " + tag("name") + tag("FOREACH eAllattributes AS at")
                + "Attribute : " + tag("at.name") + tag("ENDFOREACH") + tag("ENDFILE") + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);
        final Definition def = (Definition) t.getDefinitions()[0];
        assertEquals("test", def.getName());
        assertEquals(2, def.getParams().length);
        DeclaredParameter param = def.getParams()[0];
        assertEquals("a", param.getVarName());
        assertEquals("ecore::EPackage", param.getTypeName());
        param = def.getParams()[1];
        assertEquals("b", param.getVarName());
        assertEquals("String", param.getTypeName());
        assertEquals("ecore::EClass", def.getTargetType().getName());
        List<Statement> statements = Arrays.asList(def.getBody());
        assertEquals(3, statements.size());
        final FileStatement f = (FileStatement) statements.get(1);
        final ExpressionHelper concat = f.getTargetFileName();
        assertNotNull(concat);
        statements = Arrays.asList(f.getBody());
        assertEquals(5, statements.size());
        assertEquals("Text und so ", ((TextStatement) statements.get(0)).getValue());
    }

    public final void testImportDeclaration() throws Exception {
        Template t;
        final String im1 = "http://ecore/x";
        final String im2 = "zzz";
        t = parse(tag("IMPORT '" + im1 + '\'') + tag("IMPORT '" + im2 + '\'')
                + tag("DEFINE test FOR ecore::EClass") + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);
        assertEquals(2, t.getImportedNamespaces().length);
        assertEquals(im1, t.getImportedNamespaces()[0]);
        assertEquals(im2, t.getImportedNamespaces()[1]);
    }

    public final void testFileStatement() throws Exception {
        final Template t = parse(tag("DEFINE test FOR ecore::EClass") + tag("FILE \"test.txt\" ONCE") + tag("ENDFILE")
                + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);
        final FileStatement file = (FileStatement) ((Definition) t.getDefinitions()[0]).getBody()[1];
        assertEquals("ONCE", file.getMode().getValue());
    }

    public final void testIfStatement() throws Exception {
        final Template t = parse(tag("DEFINE test FOR ecore::EClass") + tag("IF not true") + tag("ELSEIF false")
                + tag("ELSE") + tag("ENDIF") + tag("ENDDEFINE"));
        assertEquals(1, t.getDefinitions().length);

        final IfStatement ifSt = (IfStatement) ((Definition) t.getDefinitions()[0]).getBody()[1];
        assertNotNull(ifSt);
        assertNotNull(ifSt.getCondition());
        assertNotNull(ifSt.getElseIf());
        assertNotNull(ifSt.getElseIf().getCondition());
        assertNotNull(ifSt.getElseIf().getElseIf());
        assertNull(ifSt.getElseIf().getElseIf().getCondition());
    }

}