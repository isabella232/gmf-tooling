/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gen;

import org.eclipse.gmf.tests.gen.CompilationTest;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;


public class LiteCompilationTest extends CompilationTest {
	public LiteCompilationTest(String name) {
		super(name);
	}

	protected GeneratorConfiguration getGeneratorConfiguration() {
		return new LiteGeneratorConfiguration();
	}
}
