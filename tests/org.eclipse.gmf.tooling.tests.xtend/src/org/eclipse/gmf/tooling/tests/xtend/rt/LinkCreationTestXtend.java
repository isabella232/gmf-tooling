/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.rt;

import org.eclipse.gmf.tests.rt.LinkCreationTest;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfiguration;

public class LinkCreationTestXtend extends LinkCreationTest {

	public LinkCreationTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfiguration());
	}

}