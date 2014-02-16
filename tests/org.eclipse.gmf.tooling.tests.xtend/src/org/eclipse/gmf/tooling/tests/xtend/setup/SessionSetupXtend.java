/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tooling.tests.xtend.setup;

import org.eclipse.gmf.tests.TestConfiguration;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.SessionSetup;

/**
 * @author artem
 */
public class SessionSetupXtend extends SessionSetup {

	protected SessionSetupXtend(GeneratorConfiguration generatorConfig) {
		super(generatorConfig);
	}

	@TestConfiguration.FactoryMethod
	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new SessionSetupXtend(new RuntimeBasedGeneratorConfigurationXtend());
	}
}
