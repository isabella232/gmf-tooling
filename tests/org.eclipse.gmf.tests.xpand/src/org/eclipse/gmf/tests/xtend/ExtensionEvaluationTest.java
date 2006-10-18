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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.tests.expression.ast.ATypeModel;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;
import org.eclipse.gmf.internal.xpand.xtend.ast.ExtensionFile;

/**
 * FIXME ExtensionAnalyzationTest uses same extensions - reuse
 */
public class ExtensionEvaluationTest extends AbstractXtendTest {

    private ExecutionContextImpl ec;

    @Override
    protected void setUp() throws Exception {
        ec = new ExecutionContextImpl(null);
    }

    public final void testWithEverything() {
        final ExtensionFile file = parse("String toUpperCase(String str) : JAVA " + Helper.class.getName() + ".toUpperCase(java.lang.String) ; \n"
                + "\n"
                + "String privateHelper(String str) : JAVA " + Helper.class.getName() + ".privateHelper(java.lang.String) ; \n"
                + "\n"
                + "String nonStaticHelper(String str) : JAVA " + Helper.class.getName() + ".nonStaticHelper(java.lang.String) ; \n"
                + "\n" + "/* \n" + " * Meine Funktion \n" + " */ \n" + "myExtension(Object val) : {val} ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final Object[] params = new Object[] { "test" };
        Extension ext = ec.getExtension("toUpperCase", detectTypes(params));
        assertEquals("TEST", ext.evaluate(params, ec));

        ext = ec.getExtension("myExtension", detectTypes(params));
        assertEquals(Collections.singletonList("test"), ext.evaluate(params, ec));
    }

    public final void testJavaExtension2() {
        final ExtensionFile file = parse("Collection[Object] union(Collection[Object] c1,Collection[Object] c2) : JAVA "
                + "org.eclipse.gmf.tests.xtend.Helper.union(java.util.Collection,java.util.Collection) ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final Object[] params = new Object[] { Collections.singleton("1"), Collections.singleton("2") };
        final Extension ext = ec.getExtension("union", detectTypes(params));
        final Collection result = (Collection) ext.evaluate(params, ec);
        assertTrue(result.size() == 2);
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
    }

    public final void testPolymorphism() {
        final ExtensionFile file = parse("ext(Object val) : 'Object' ; \n" + "ext(List[Object] val) : 'List' ; \n"
                + "ext(Collection[Object] val) : 'Collection' ; \n" + "ext(Integer val) : 'Integer' ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        Extension ext = ec.getExtension("ext", detectTypes(new Object[] { "test" }));
        assertEquals("Object", ext.evaluate(new Object[] { "test" }, ec));

        ext = ec.getExtension("ext", detectTypes(new Object[] { Collections.EMPTY_SET }));
        assertEquals("Collection", ext.evaluate(new Object[] { Collections.EMPTY_SET }, ec));

        ext = ec.getExtension("ext", detectTypes(new Object[] { Collections.EMPTY_LIST }));
        assertEquals("List", ext.evaluate(new Object[] { Collections.EMPTY_LIST }, ec));

        ext = ec.getExtension("ext", detectTypes(new Object[] { new Integer(2) }));
        assertEquals("Integer", ext.evaluate(new Object[] { new Integer(2) }, ec));

    }

    public final void testRecursion() {
        final ExtensionFile file = parse("List[Integer] recExtension(Integer von,Integer bis) : von>=bis ? {von} : recExtension(von,bis-1).add(bis) ; \n");

        ec = (ExecutionContextImpl) ec.cloneWithResource(file);

        final Extension ext = ec.getExtension("recExtension", detectTypes(new Object[] { new Long(5), new Long(10) }));
        final List<Integer> expected = new ArrayList<Integer>();
        for (int i = 5; i <= 10; i++) {
            expected.add(new Integer(i));
        }
        final Object evalResult = ext.evaluate(new Object[] { new Integer(5), new Integer(10) }, ec);
        assertEquals(expected, evalResult);

    }

    public final void testMemberPosition() {
        final ExtensionFile file = parse("ext1(String txt) : 'test'+txt ;" + "ext2(String txt) : txt.ext1() ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);

        final Extension ext = ec.getExtension("ext2", detectTypes(new Object[] { "fall" }));
        final Object evalResult = ext.evaluate(new Object[] { "fall" }, ec);
        assertEquals("testfall", evalResult);

    }

    public final void testCachedExtension() {
        final ExtensionFile file = parse("cached String ext(String txt) : JAVA " + ExtensionEvaluationTest.class.getName() + ".testMethod(java.lang.String);");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);

        final Extension ext = ec.getExtension("ext", detectTypes(new Object[] { "test" }));
        assertEquals("test0", ext.evaluate(new Object[] { "test" }, ec));
        assertEquals("test0", ext.evaluate(new Object[] { "test" }, ec));
        assertEquals("test0", ext.evaluate(new Object[] { "test" }, ec));
        assertEquals("test0", ext.evaluate(new Object[] { "test" }, ec));
    }

    private EClassifier[] detectTypes(Object[] objects) {
		EClassifier[] rv = new EClassifier[objects.length];
		for (int i = 0; i < objects.length; i++) {
			rv[i] = BuiltinMetaModel.getType(objects[i]);
		}
		return rv;
	}

	private static int magic = 0;

    public final static String testMethod(final String s) {
        return s + magic++;
    }

    public final void testCreateExtension() {
        final ExtensionFile file = parse("create List[String] l test(String s) : l.add(s) ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final List l = (List) file.getExtensions().get(0).evaluate(new String[] { "test" }, ec);

        assertEquals(Collections.singletonList("test"), l);
    }
    
    public final void testCreateExtension1() {
        final ExtensionFile file = parse("create List[String] test(String s) : add(s) ;");
        ec = (ExecutionContextImpl) ec.cloneWithResource(file);
        final List l = (List) ((Extension) file.getExtensions().get(0)).evaluate(new String[] { "test" }, ec);
        
        assertEquals(Collections.singletonList("test"), l);
    }
    
    public final void testAmbigous() {
    	ATypeModel aType = new ATypeModel();
    	final ExtensionFile file = parse("import '"+ aType.getMetaType().getEPackage().getName() +"';"+
                "doStuff(" + aType.getMetaType().getName() + " this) : true; " +
                "doStuff("  + aType.getMetaTypeC().getName() +  " this) : false;");

    	ExecutionContext ctx = aType.newContext(file);
        assertNotNull(ctx.getExtension("doStuff", new EClassifier[] { aType.getMetaType() }));
        try {
        	ctx.getExtension("doStuff", new EClassifier[] { aType.getMetaTypeB() });
            fail("Ambigous operation exception expected");
        } catch (final RuntimeException re) {
            //expected
            System.out.println(re.getMessage());
        }
    }
}
