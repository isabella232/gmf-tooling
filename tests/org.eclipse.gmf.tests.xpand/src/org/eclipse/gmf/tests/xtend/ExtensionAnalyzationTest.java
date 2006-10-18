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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.tests.expression.ast.ATypeModel;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;

public class ExtensionAnalyzationTest extends AbstractXtendTest {
    private Set<AnalysationIssue> issues;

    private ExecutionContextImpl ec;

    @Override
    protected void setUp() throws Exception {
        ec = new ExecutionContextImpl(null);
        issues = new HashSet<AnalysationIssue>();
    }

    private void dumpIssues() {
        for (final Iterator<AnalysationIssue> iter = issues.iterator(); iter.hasNext();) {
            final AnalysationIssue element = iter.next();
            System.out.println(element.getType().toString() + " - " + element.getMessage());
        }
    }

    public final void testWithEverything() {
        final ExtensionFile file = parse("String toUpperCase(String str) : JAVA " + Helper.class.getName() + ".toUpperCase(java.lang.String) ; \n"
                + "\n"
                + "String privateHelper(String str) :JAVA " + Helper.class.getName() + ".privateHelper(java.lang.String) ; \n"
                + "\n"
                + "String nonStaticHelper(String str) :JAVA " + Helper.class.getName() + ".nonStaticHelper(java.lang.String) ; \n"
                + "\n" + "/* \n" + " * Meine Funktion \n" + " */ \n" + "myExtension(Object val) : {val}; \n");

        // XXX 'privateHelper' may be misguiding - it's not about checking method's visibility, but about lack of the method
        file.analyze(ec, issues);
        dumpIssues();

        assertEquals(2, issues.size());
        final ExpressionExtensionStatement ext = (ExpressionExtensionStatement) file.getExtensions().get(3);

        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEBoolean()), ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEBoolean() }, ec,
                new HashSet<AnalysationIssue>()));
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEString()), ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEString() }, ec,
                new HashSet<AnalysationIssue>()));
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEJavaObject()), ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEJavaObject() }, ec,
                new HashSet<AnalysationIssue>()));
    }

    public final void testRecursionWithoutType() {
        final ExtensionFile file = parse("recExtension(Integer i) : i==0 ? {i} : recExtension(i-1).add(i) ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final ExpressionExtensionStatement ext = (ExpressionExtensionStatement) file.getExtensions().get(0);
        final EClassifier result = ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEInt() }, ec, new HashSet<AnalysationIssue>());
        assertNull(result);

    }

    public final void testRecursionWithType() {
        final ExtensionFile file = parse("List[Integer] recExtension(Integer i) : i==0 ? {i} : recExtension(i-1).add(i) ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final ExpressionExtensionStatement ext = (ExpressionExtensionStatement) file.getExtensions().get(0);
        final EClassifier result = ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEInt() }, ec, new HashSet<AnalysationIssue>());
        assertEquals(0, issues.size());
        assertEquals(BuiltinMetaModel.getListType(EcorePackage.eINSTANCE.getEInt()), result);

    }

    public final void testMemberPosition() {
        final ExtensionFile file = parse("ext1(String txt) : 'test'+txt ;" + "ext2(String txt) : txt.ext1() ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);

        final Extension ext = ec.getExtension("ext2", new EClassifier[] { EcorePackage.eINSTANCE.getEString() });
        final EClassifier evalResult = ext.getReturnType(new EClassifier[] { EcorePackage.eINSTANCE.getEString() }, ec, new HashSet<AnalysationIssue>());
        assertEquals(EcorePackage.eINSTANCE.getEString(), evalResult);
    }

    public final void testDuplicateParameterNames1() {
        final ExtensionFile file = parse("ext1(String txt, String txt) : 'test'+txt ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        file.analyze(ec, issues);
        assertEquals(1, issues.size());
        
    }

    public final void testDuplicateParameterNames2() {
        final ExtensionFile file = parse("ext1(String txt, String txt2) : 'test'+txt ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        file.analyze(ec, issues);
        assertEquals(0, issues.size());
    }

    public final void testThisParameterName() {
        final ExtensionFile file = parse("ext1(String this, String txt2) : 'test'+length() ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        file.analyze(ec, issues);
        assertEquals(0, issues.size());
    }

    public final void testCreateExtension() {
        final ExtensionFile file = parse("create List[String] l test(String s) : l.add(s) ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        file.analyze(ec, issues);
        assertEquals(0, issues.size());
        final Extension ext = (Extension) file.getExtensions().get(0);
        assertEquals("List", ext.getReturnType(null, ec, null).eClass().getName());
    }
    
    public final void testCreateExtension1() {
        final ExtensionFile file = parse("create List[String] test(String s) : add(s) ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        file.analyze(ec, issues);
        assertEquals(0, issues.size());
        final Extension ext = (Extension) file.getExtensions().get(0);
        assertEquals("List", ext.getReturnType(null, ec, null).eClass().getName());
    }
    
    public final void testAmbigous() {
    	ATypeModel aType = new ATypeModel();
    	final ExtensionFile file = parse("import '"+ aType.getMetaType().getEPackage().getName() +"';"+
                                         "doStuff(" + aType.getMetaType().getName() + " this) : true; " +
                                         "doStuff("  + aType.getMetaTypeC().getName() +  " this) : false;" +
                                         "bla(" + aType.getMetaTypeB().getName() + " this) : this.doStuff();");
        
        ExecutionContext ctx = aType.newContext(file);
        // XXX can't use file.analyze unless metamodel registration works
        // ExtensionFile.analyze clones context and getAllVisibleMetamodel override goes away
		for (Extension x : file.getExtensions()) {
			x.analyze(ctx, issues);
		}
        System.out.println(issues);
        assertEquals(1, issues.size());
    }

}
