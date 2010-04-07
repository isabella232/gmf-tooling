/*
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import org.eclipse.gmf.tests.setup.MultiSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;

public abstract class AbstractMultiSetupTest extends GeneratedCanvasTest {
	private MultiSetup myMultiSetup;

	public AbstractMultiSetupTest(String name, ViewerConfiguration.Factory viewerConfigFactory) {
		super(name, viewerConfigFactory);
	}

	public final void configure(MultiSetup setup) {
		myMultiSetup = setup;
		configure(setup.getDefaultSetup());
	}

	@Override
	protected RTSource createCanvasInstance() throws Exception {
		RTSource result = super.createCanvasInstance();
		//Initialize other models as well.
		for (SessionSetup next : myMultiSetup.getAllSetups()) {
			next.getGeneratedPlugin();
		}
		return result;
	}

	protected final MultiSetup getMultiSetup() {
		return myMultiSetup;
	}
}
