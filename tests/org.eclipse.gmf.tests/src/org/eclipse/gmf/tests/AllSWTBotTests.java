/*******************************************************************************
* Copyright (c) 2011 EBM Websourcing (PetalsLink)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Mickael Istria (EBM - PetalsLink) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests;

import org.eclipse.gmf.tests.gen.swtbot.FigureGenerationTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	FigureGenerationTest.class
})
public class AllSWTBotTests {
	
	@BeforeClass
	public static void setUp() throws Exception {
		if (System.getProperty("buildingWithTycho") != null) {
			System.err.println("Generating a target platform");
			Utils.setTargetPlatform();
		}
	}
}
