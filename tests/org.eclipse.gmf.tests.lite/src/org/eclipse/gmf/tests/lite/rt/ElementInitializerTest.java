/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.rt;


public class ElementInitializerTest extends org.eclipse.gmf.tests.rt.ElementInitializerTest {
	public ElementInitializerTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myElementInitializersClassName = getGenModel().getGenDiagram().getNotationViewFactoriesPackageName() + ".DomainElementInitializer"; //$NON-NLS-1$
	}
}
