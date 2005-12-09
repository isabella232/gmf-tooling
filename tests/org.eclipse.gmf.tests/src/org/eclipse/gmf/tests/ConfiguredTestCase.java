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
package org.eclipse.gmf.tests;

import org.eclipse.gmf.tests.setup.SessionSetup;

import junit.framework.TestCase;

/**
 * @author artem
 *
 */
public abstract class ConfiguredTestCase extends TestCase implements NeedsSetup {

	private SessionSetup mySessionSetup;
	
	protected ConfiguredTestCase(String name) {
		super(name);
	}

	public final void setSetup(SessionSetup sessionSetup) {
		assertNotNull(sessionSetup);
		mySessionSetup = sessionSetup;
		mySessionSetup.oneUp();
	}

	protected final SessionSetup getSetup() {
		return mySessionSetup;
	}

	protected void setUp() throws Exception {
		super.setUp();
		if (mySessionSetup == null) {
			// subject to enabled/disabled state dictated from AllTests 
			mySessionSetup = createDefaultSetup();
		}
		assertNotNull("Test " + getName() + " needs session setup", mySessionSetup);
	}

	/**
	 * Will be invoked when no setup set, usually in single test execution scenario.
	 */
	protected SessionSetup createDefaultSetup() {
		return SessionSetup.newInstance();
	}

	protected void tearDown() throws Exception {
		mySessionSetup.oneDown();
		super.tearDown();
	}
}
