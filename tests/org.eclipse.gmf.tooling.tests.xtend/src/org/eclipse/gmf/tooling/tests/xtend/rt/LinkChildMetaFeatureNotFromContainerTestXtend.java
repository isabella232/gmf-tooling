/*
 * Copyright (c) 2008, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.rt;

import org.eclipse.gmf.tests.rt.LinkChildMetaFeatureNotFromContainerTest;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tooling.tests.xtend.setup.RuntimeBasedGeneratorConfigurationXtend;

/**
 * Xtend version for the test for @see https://bugs.eclipse.org/226882
 */
public class LinkChildMetaFeatureNotFromContainerTestXtend extends LinkChildMetaFeatureNotFromContainerTest {

	public static final class CustomSetupXtend extends SessionSetup {

		public CustomSetupXtend() {
			super(new RuntimeBasedGeneratorConfigurationXtend());
		}

		@Override
		protected DiaGenSource createGenModel() {
			return new DiaGenSourceImpl();
		}
	};

	public LinkChildMetaFeatureNotFromContainerTestXtend(String name) {
		super(name, new RuntimeBasedGeneratorConfigurationXtend());
	}
}
