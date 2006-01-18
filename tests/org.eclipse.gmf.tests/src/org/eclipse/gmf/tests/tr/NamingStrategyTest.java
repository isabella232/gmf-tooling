/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.internal.bridge.naming.ClassNameStrategy;
import org.eclipse.gmf.internal.bridge.naming.CollectingDispenser;
import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.UniqueValueDispenser;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.jdt.core.JavaConventions;

public class NamingStrategyTest extends AbstractMappingTransformerTest {
	/**
	 * Signals error for valid but not recommended name, if <code>true</code>.
	 */
	private static final boolean STRICT_CHECK = true;

	public NamingStrategyTest(String name) {
		super(name);
	}

	public void testUniqueValueDispenser() {
		UniqueValueDispenser d = new CollectingDispenser();
		Object o1 = "String1";
		Object o2 = "String2";
		Object o3 = "String" + "1";
		assertTrue("In the beginning...", d.isUnique(o1));
		assertTrue("In the beginning...", d.isUnique(o2));
		assertTrue("In the beginning...", d.isUnique(o3));
		d.remember(o1);
		assertTrue("Still", d.isUnique(o2));
		assertFalse("But", d.isUnique(o3));
	}

	public void testDefaultEPNamingStrategy() {
		doTest(new GenModelNamingMediatorImpl().getEditPart());
	}

	public void testClassNameStrategy() {
		doTest(new ClassNameStrategy("Whatever", null, null));
	}

/*  XXX template

	public void test<YourStrategyNameHere>() {
		doTest(new <YourStrategyNameHere>());
	}
 */

	private void doTest(NamingStrategy strategy) {
		final String diagramEPName = strategy.get(getCanvasMapping());
		final String nodeEPName = strategy.get(getNodeMapping());
		final String linkEPName = strategy.get(getLinkMapping());

		assertStatus("Invalid Java class name '" + diagramEPName + " for diagram", JavaConventions.validateJavaTypeName(diagramEPName));
		assertStatus("Invalid Java class name '" + nodeEPName + " for node", JavaConventions.validateJavaTypeName(nodeEPName));
		assertStatus("Invalid Java class name '" + linkEPName + " for link", JavaConventions.validateJavaTypeName(linkEPName));
	}

	private void assertStatus(String message, IStatus status) {
		if (STRICT_CHECK) {
			assertTrue(message, status.isOK());
			return;
		}
		assertFalse(message, status.getSeverity() == IStatus.ERROR);
	}
}
