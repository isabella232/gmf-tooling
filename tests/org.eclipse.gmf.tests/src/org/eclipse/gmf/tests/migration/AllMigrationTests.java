/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.tests.migration;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllMigrationTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Migration tests"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(GenericMigrationTest.class);
		suite.addTestSuite(MigrationPatchesTest.class);
		suite.addTestSuite(TestCustomCopier.class);
		suite.addTestSuite(TestMigrate08to09.class);
		//$JUnit-END$
		return suite;
	}

}
