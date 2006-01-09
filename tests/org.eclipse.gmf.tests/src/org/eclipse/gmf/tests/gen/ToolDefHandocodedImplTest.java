/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import junit.framework.TestCase;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.tooldef.AppearanceStyle;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.GenericStyleSelector;

/**
 * @author artem
 */
public class ToolDefHandocodedImplTest extends TestCase {

	public ToolDefHandocodedImplTest(String name) {
		super(name);
	}

	public void testGenericStyleSelector() {
		final GenericStyleSelector ss = GMFToolFactory.eINSTANCE.createGenericStyleSelector();
		ss.setValue(AppearanceStyle.FILL_LITERAL);
		assertTrue(ss.isOk(NotationFactory.eINSTANCE.createFillStyle()));
		ss.setValue(AppearanceStyle.LINE_LITERAL);
		assertTrue(ss.isOk(NotationFactory.eINSTANCE.createLineStyle()));
		ss.setValue(AppearanceStyle.FONT_LITERAL);
		assertTrue(ss.isOk(NotationFactory.eINSTANCE.createFontStyle()));
	}
}
