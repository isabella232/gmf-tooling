/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - tests for Ant build
 */
package org.eclipse.gmf.tooling.tests.xtend.gen;

import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

public class RuntimeCompilationTestXtend extends org.eclipse.gmf.tests.gen.RuntimeCompilationTest {

	public RuntimeCompilationTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}

}
