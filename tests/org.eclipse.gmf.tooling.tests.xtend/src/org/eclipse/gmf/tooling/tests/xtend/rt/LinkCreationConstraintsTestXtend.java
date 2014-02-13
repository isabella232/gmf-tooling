/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.rt;

import org.eclipse.gmf.tests.rt.LinkCreationConstraintsTest;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfiguration;

public class LinkCreationConstraintsTestXtend extends LinkCreationConstraintsTest {

	public LinkCreationConstraintsTestXtend(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	protected LinkCreationConstraintsTestXtend(String name, ViewerConfiguration.Factory viewerConfigFactory) {
		super(name, viewerConfigFactory);
	}
	
}
