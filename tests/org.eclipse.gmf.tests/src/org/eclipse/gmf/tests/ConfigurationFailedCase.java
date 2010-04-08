/*
 * Copyright (c) 2010 Artem Tikhomirov and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (independent) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import junit.framework.TestCase;

public class ConfigurationFailedCase extends TestCase {
	private final String cause;
	private final Exception exception; 

	ConfigurationFailedCase(String aCause, Exception e) {
		super(ConfigurationFailedCase.class.getName());
		cause = aCause;
		exception = e;
	}
	protected void runTest() throws Throwable {
		if (exception != null) {
			exception.printStackTrace();
		}
		fail(cause);
	}
}