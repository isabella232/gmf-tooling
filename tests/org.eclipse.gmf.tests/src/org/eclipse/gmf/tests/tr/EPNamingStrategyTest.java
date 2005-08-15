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
import org.eclipse.gmf.bridge.genmodel.EditPartNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.NamingStrategy;
import org.eclipse.jdt.core.JavaConventions;

public class EPNamingStrategyTest extends AbstractMappingTransformerTest {
	/**
	 * Signals error for valid but not recommended name, if <code>true</code>.
	 */
	private static final boolean STRICT_CHECK = true;

	public EPNamingStrategyTest(String name) {
		super(name);
	}

	public void testDefaultEPNamingStrategy() {
		doTest(new EditPartNamingStrategy());
	}

/*  XXX template

	public void test<YourStrategyNameHere>() {
		doTest(new <YourStrategyNameHere>());
	}
 */

	private void doTest(NamingStrategy strategy) {
		final String diagramEPName = strategy.createClassName(getCanvasMapping());
		final String nodeEPName = strategy.createClassName(getNodeMapping());
		final String linkEPName = strategy.createClassName(getLinkMapping());

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
