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
package org.eclipse.gmf.tests.rt;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @author artem
 *
 */
public class SpecificRTPropertiesTest extends PropertiesTest {
	private View mySubject;

	public SpecificRTPropertiesTest(String name) {
		super(name);
	}

	public void testNamedAccess() {
		// generate code, install and try to access using reflection? 
		fail("TODO"); // FIXME
	}

	public void testGenericAccess() {
		checkWithGenericAccess(mySubject); // TODO
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
