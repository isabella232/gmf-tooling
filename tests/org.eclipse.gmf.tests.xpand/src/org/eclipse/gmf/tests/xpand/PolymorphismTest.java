/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.xpand;

import junit.framework.TestCase;

import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;

public class PolymorphismTest extends TestCase {
	
	private static final String TEMPLATE_FILE_PREFIX = "org::eclipse::gmf::tests::xpand::evaluate::Polymorphism::";

	private static final Object[] NO_PARAMS = new Object[0];

	private StringBuilder buffer;

	private XpandFacade xpandFacade;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		buffer = new StringBuilder();
		xpandFacade = new XpandFacade(new ExecutionContextImpl(new Scope(new TestsResourceManager(), null, new BufferOutput(buffer))));
	}
	
	public void testContextualPolymorphysm() {
		checkDefinition("contextualPolymorphysm", "myString", "StringDefine");
		checkDefinition("contextualPolymorphysm", new Object(), "OclAnyDefine");
	}
	
	public void testParameterPolymorphysm() {
		checkDefinition("parameterPolymorphysm", "myString", "StringDefine");
		checkDefinition("parameterPolymorphysm", new Object(), "OclAnyDefine");
	}
	
	public void testSecondParameterPolymorphysm() {
		checkDefinition("secondParameterPolymorphysm", "myString", "StringDefine");
		checkDefinition("secondParameterPolymorphysm", new Object(), "OclAnyDefine");
	}
	
	public void checkDefinition(String definitionName, Object targetObject, String expectedResult) {
		xpandFacade.evaluate(TEMPLATE_FILE_PREFIX + definitionName, targetObject, NO_PARAMS);
		assertEquals(expectedResult, buffer.toString());
		buffer.delete(0, buffer.length());
	}

}
