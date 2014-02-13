/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Radek Dvorak (Borland) - initial API and implementation
 *     Artem Tikhomirov (Borland) - tests for enhanced/refactored java implementations 
 *                                  (method injection, exceptions, method names) 
 */
package org.eclipse.gmf.tooling.tests.xtend.setup;

import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.LinksSessionSetup;

public class LinksSessionSetupXtend extends LinksSessionSetup {

	public static String modelURI = "/models/links/links.ecore"; //$NON-NLS-1$
	
	protected LinksSessionSetupXtend(GeneratorConfiguration genConfig) {
		super(genConfig);
		
	}

	@org.eclipse.gmf.tests.TestConfiguration.FactoryMethod
	public static LinksSessionSetupXtend newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LinksSessionSetupXtend(new RuntimeBasedGeneratorConfiguration());
	}
	
}
