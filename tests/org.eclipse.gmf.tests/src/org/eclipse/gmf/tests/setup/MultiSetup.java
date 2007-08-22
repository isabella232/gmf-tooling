/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.gmf.tests.TestConfiguration;

/**
 * Holds multiple setups at the same time. 
 */
public class MultiSetup implements TestConfiguration {
	private final SessionSetup[] mySetups;

	public MultiSetup(SessionSetup... setups) {
		mySetups = setups;
	}

	/**
	 * Existing tests (including the convenient abstract superclasses) assume there is a single setup. 
	 * The first setup passed is selected as the default setup for the test.
	 */
	public SessionSetup getDefaultSetup() {
		return mySetups[0];
	}

	public SessionSetup[] getAllSetups() {
		return mySetups;
	}
}
