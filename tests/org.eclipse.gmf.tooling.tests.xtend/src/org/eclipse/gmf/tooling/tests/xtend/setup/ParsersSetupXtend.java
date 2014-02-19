/*
 * Copyright (c) 2008, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (independent) - [138179] expressions-based labels
 */
package org.eclipse.gmf.tooling.tests.xtend.setup;

import org.eclipse.gmf.tests.gef.ParsersTest.ParsersSetup;

	public class ParsersSetupXtend extends ParsersSetup {
		public ParsersSetupXtend(boolean parsersAsProvider) {
			super(parsersAsProvider, new RuntimeBasedGeneratorConfigurationXtend());
		}
}
