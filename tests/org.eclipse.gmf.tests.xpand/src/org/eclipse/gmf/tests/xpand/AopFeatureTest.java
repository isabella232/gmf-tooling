/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.tests.xpand;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContextImpl;

public class AopFeatureTest extends TestCase {
    private XpandExecutionContextImpl execCtx;

    private StringBuilder buffer;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        buffer = new StringBuilder();
		execCtx = new XpandExecutionContextImpl(new TestsResourceManager(), new BufferOutput(buffer), null);

        // ADDED encoding
        // XXX fileEncoding for execContext is odd; perhaps, resourceManager? execCtx.setFileEncoding("ISO-8859-1");
        execCtx.registerAdvices(prefix() + "Advices1");
    }

    public final void test_test1_Object() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::test1", EcorePackage.eINSTANCE.getEJavaObject(), null);
        def.evaluate(execCtx);
        assertEquals("12", buffer.toString());
    }

    public final void test_test2_Object() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::test2", EcorePackage.eINSTANCE.getEJavaObject(), null);
        def.evaluate(execCtx);
        assertEquals("13", buffer.toString());
    }

    public final void test_te2st_Object() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::te2st", EcorePackage.eINSTANCE.getEJavaObject(), null);
        def.evaluate(execCtx);
        assertEquals("4", buffer.toString());
    }

    public final void test_test1_String() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::test1", EcorePackage.eINSTANCE.getEString(), null);
        def.evaluate(execCtx);
        assertEquals("1258", buffer.toString());
    }

    public final void test_test1_StringParam_String() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::test1", EcorePackage.eINSTANCE.getEString(),
                new EClassifier[] { EcorePackage.eINSTANCE.getEString() });
        def.evaluate(execCtx);
        assertEquals("678", buffer.toString());
    }

    public final void test_test1_StringParams_String() {
        final XpandDefinition def = execCtx.findDefinition(prefix() + "Adviced::test1", EcorePackage.eINSTANCE.getEString(),
                new EClassifier[] { EcorePackage.eINSTANCE.getEString(), EcorePackage.eINSTANCE.getEString() });
        def.evaluate(execCtx);
        assertEquals("78", buffer.toString());
    }

    private static String prefix() {
        return "org::eclipse::gmf::tests::xpand::evaluate::";
    }
}
