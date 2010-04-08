/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
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
public abstract class ConfiguredTestCase extends TestCase {

	private SessionSetup mySessionSetup;

	protected ConfiguredTestCase(String name) {
		super(name);
		Plugin.getConfig().prepare(this);
	}

	@NeedsSetup
	public final void configure(SessionSetup sessionSetup) {
		assertNotNull(sessionSetup);
		// XXX if (mySessionSetup != null) mySessionSetup.oneDown() - e.g. if configure is called twice for the same test?
		// i.e. once from Configurator.prepare (cons), another one from outsite (AllTests)?
		mySessionSetup = sessionSetup;
		mySessionSetup.oneUp();
	}

	protected final SessionSetup getSetup() {
		return mySessionSetup;
	}

	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull("Test " + getName() + " needs session setup", mySessionSetup);
	}

	protected void tearDown() throws Exception {
		mySessionSetup.oneDown();
		super.tearDown();
	}
}
