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
package org.eclipse.gmf.tests.xtend;

import org.eclipse.gmf.internal.xpand.expression.ast.BooleanLiteral;
import org.eclipse.gmf.internal.xpand.expression.ast.DeclaredParameter;
import org.eclipse.gmf.internal.xpand.xtend.ast.CreateExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;
import org.eclipse.gmf.internal.xpand.xtend.ast.ImportStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.JavaExtensionStatement;

public class ExtensionParserTest extends AbstractXtendTest {
    public final void testSimple() {
        final ExtensionFile file = parse("trueFunc() :true;");
        assertTrue(file.getNsImports().isEmpty());
        assertTrue(file.getExtImports().isEmpty());
        assertEquals(1, file.getExtensions().size());
        final ExpressionExtensionStatement fd = (ExpressionExtensionStatement) file.getExtensions().get(0);
        assertEquals("trueFunc", fd.getName());
        assertTrue(fd.getFormalParameters().isEmpty());

        assertTrue(fd.getExpression() instanceof BooleanLiteral);
    }

    public final void testWithImportAndComments() {
        final ExtensionFile file = parse("// test \n" + "import \"oaw\"; \n" + "/* \n" + " * Meine Funktion \n"
                + " */ \n" + "trueFunc() :true; \n");
        assertEquals(1, file.getNsImports().size());
        final ImportStatement imp = (ImportStatement) file.getNsImports().get(0);
        assertEquals("oaw", imp.getValue());
        assertTrue(file.getExtImports().isEmpty());
        assertEquals(1, file.getExtensions().size());
        final ExpressionExtensionStatement fd = (ExpressionExtensionStatement) file.getExtensions().get(0);
        assertEquals("trueFunc", fd.getName());
        assertTrue(fd.getFormalParameters().isEmpty());

        assertTrue(fd.getExpression() instanceof BooleanLiteral);
    }

    public final void testWithEverything() {
        final ExtensionFile file = parse("import \"oaw\"; \n" + "import \"http://ecore/x\"; \n"
                + "extension test::TestExtension; \n" + "\n"
                + "private Void dump(Object obj) :JAVA java.util.String.valueOf(char) ; \n" + "\n" + "/* \n"
                + " * Meine Funktion \n" + " */ \n" + "trueFunc() :true; \n" + "\n"
                + "Void dump(String s) : JAVA de.DefaultImpl.doStuff(java.util.Collection,java.util.Set) ; \n");
        assertEquals(2, file.getNsImports().size());

        final ImportStatement imp = (ImportStatement) file.getNsImports().get(1);
        assertEquals("http://ecore/x", imp.getValue());
        assertEquals(1, file.getExtImports().size());

        final ImportStatement extImp = (ImportStatement) file.getExtImports().get(0);
        assertEquals("test::TestExtension", extImp.getValue());

        assertEquals(3, file.getExtensions().size());
        final JavaExtensionStatement ext1 = (JavaExtensionStatement) file.getExtensions().get(0);
        assertNotNull(ext1.getJavaType());
        assertEquals("dump", ext1.getName());
        assertTrue(ext1.isPrivate());
        final DeclaredParameter param = (DeclaredParameter) ext1.getFormalParameters().get(0);
        assertEquals("obj", param.getName().getValue());
        assertEquals("Object", param.getType().getValue());

        final ExpressionExtensionStatement fd = (ExpressionExtensionStatement) file.getExtensions().get(1);
        assertEquals("trueFunc", fd.getName());
        assertTrue(fd.getFormalParameters().isEmpty());

        assertTrue(fd.getExpression() instanceof BooleanLiteral);
    }

    public final void testDoubleSemi() {
        final ExtensionFile file = parse("String dump1(String s) :s ;;" + "\n" + "String dump2(String s) :s ; \n");
        // TODO should 'fail();' because of the two colons
    }

    public final void testCreateExtension() {
        final ExtensionFile file = parse("create List[String] l test(String s) : l.add(s) ;");
        final CreateExtensionStatement c = (CreateExtensionStatement) file.getExtensions().get(0);
        assertNotNull(c);
        assertEquals("List[String]", c.getReturnTypeIdentifier().getValue());
        assertEquals("test", c.getName());
        // TODO would be great to access return variable name "l" to make sure it's "l", not "this" 
    }

}
