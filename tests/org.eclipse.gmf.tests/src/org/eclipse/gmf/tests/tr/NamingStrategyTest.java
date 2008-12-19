/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
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
import org.eclipse.gmf.internal.bridge.naming.ClassGenNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.DefaultGenNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.DesignGenNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.GenNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.gen.GenNamingMediatorImpl;
import org.eclipse.gmf.internal.common.IncrementalNamesDispenser;
import org.eclipse.gmf.internal.common.NamesDispenser;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;

public class NamingStrategyTest extends ConfiguredTestCase {
	/**
	 * Signals error for valid but not recommended name, if <code>true</code>.
	 */
	private static final boolean STRICT_CHECK = true;

	public NamingStrategyTest(String name) {
		super(name);
	}

	public void testUniqueValueDispenser() {
		NamesDispenser d = new IncrementalNamesDispenser();
		String semanticPart = "Rocket";
		String suffixPart = "Node";
		String name1 = d.get(semanticPart, suffixPart);
		String name2 = d.get(semanticPart, suffixPart);
		assertFalse("Names are not unique", name1.equals(name2));
	}

	public void testDefaultEPNamingStrategy() {
		doTest(new GenNamingMediatorImpl().getEditPart());
	}

	public void testPrefixNameStrategy() {
		GenNamingStrategy pns = new DefaultGenNamingStrategy(null, null, null, null);
		pns = new DesignGenNamingStrategy(null, null, pns, null);
		pns = new ClassGenNamingStrategy(null, null, pns, null);
		doTest(pns);
	}

/*  XXX template

	public void test<YourStrategyNameHere>() {
		doTest(new <YourStrategyNameHere>());
	}
 */

	private void doTest(GenNamingStrategy strategy) {
		final String diagramName = strategy.get(getSetup().getGenModel().getGenDiagram());
		final String nodeName = strategy.get(getSetup().getGenModel().getNodeA());
		final String link1Name = strategy.get(getSetup().getGenModel().getLinkC());
		final String link2Name = strategy.get(getSetup().getGenModel().getLinkD());

		final String complianceLevel = JavaCore.VERSION_1_4;
		assertStatus("Invalid Java class name '" + diagramName + " for diagram", JavaConventions.validateJavaTypeName(diagramName, complianceLevel, complianceLevel));
		assertStatus("Invalid Java class name '" + nodeName + " for node", JavaConventions.validateJavaTypeName(nodeName, complianceLevel, complianceLevel));
		assertStatus("Invalid Java class name '" + link1Name + " for link", JavaConventions.validateJavaTypeName(link1Name, complianceLevel, complianceLevel));
		assertStatus("Invalid Java class name '" + link2Name + " for link", JavaConventions.validateJavaTypeName(link2Name, complianceLevel, complianceLevel));
	}

	private void assertStatus(String message, IStatus status) {
		if (STRICT_CHECK) {
			assertTrue(message, status.isOK());
			return;
		}
		assertFalse(message, status.getSeverity() == IStatus.ERROR);
	}
}
