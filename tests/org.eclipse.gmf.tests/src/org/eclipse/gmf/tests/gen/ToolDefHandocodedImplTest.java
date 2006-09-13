/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
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

import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
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
		final FillStyle fillStyle = NotationFactory.eINSTANCE.createFillStyle();
		final LineStyle lineStyle = NotationFactory.eINSTANCE.createLineStyle();
		final FontStyle fontStyle = NotationFactory.eINSTANCE.createFontStyle();

		ss.getValues().add(AppearanceStyle.FILL_LITERAL);
		assertTrue(ss.isOk(fillStyle));
		assertFalse(ss.isOk(fontStyle));
		ss.getValues().clear();
		ss.getValues().add(AppearanceStyle.LINE_LITERAL);
		assertTrue(ss.isOk(lineStyle));
		ss.getValues().clear();
		ss.getValues().add(AppearanceStyle.FONT_LITERAL);
		assertTrue(ss.isOk(fontStyle));
		assertFalse(ss.isOk(lineStyle));
		// note, no clear(), two values in the list
		ss.getValues().add(AppearanceStyle.FILL_LITERAL);
		assertTrue(ss.isOk(NotationFactory.eINSTANCE.createFontStyle()));
		assertFalse(ss.isOk(lineStyle));
		assertFalse(ss.isOk(NotationFactory.eINSTANCE.createLineStyle()));
		assertTrue(ss.isOk(NotationFactory.eINSTANCE.createFillStyle()));
		assertTrue(ss.isOk(fillStyle));
	}
}
