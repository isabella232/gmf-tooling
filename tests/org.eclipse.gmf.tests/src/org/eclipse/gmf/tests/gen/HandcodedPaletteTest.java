/*
 * Copyright (c) 2006 Borland Software Corporation
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

import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.StandardEntry;
import org.eclipse.gmf.codegen.gmfgen.StandardEntryKind;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;

/**
 * FIXME add toolsOnly test
 * @author artem
 */
public class HandcodedPaletteTest extends TestCase {
	private Palette palette;
	private ToolGroup groupWithStdTool;

	public HandcodedPaletteTest(String name) {
		super(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		palette = GMFGenFactory.eINSTANCE.createPalette();
		ToolGroup g1 = GMFGenFactory.eINSTANCE.createToolGroup();
		g1.getEntries().add(GMFGenFactory.eINSTANCE.createToolEntry());
		groupWithStdTool = GMFGenFactory.eINSTANCE.createToolGroup();
		final StandardEntry standardEntry = GMFGenFactory.eINSTANCE.createStandardEntry();
		standardEntry.setKind(StandardEntryKind.MARQUEE_LITERAL);
		groupWithStdTool.getEntries().add(standardEntry);
		g1.getEntries().add(groupWithStdTool);
		palette.getGroups().add(g1);
	}

	@SuppressWarnings("unchecked")
	public void testGroupGetPalette() {
		assertTrue(palette.getGroups().size() > 0);
		for (int i = palette.getGroups().size() - 1;  i >= 0; i--) {
			ToolGroup g = (ToolGroup) palette.getGroups().get(i);
			assertNotNull(g.getPalette());
			assertEquals(palette, g.getPalette());
		}
		assertEquals(palette.getGroups().get(0), groupWithStdTool.getGroup()); // make sure it's subgroup
		assertEquals(palette, groupWithStdTool.getPalette());
		ToolGroup g = GMFGenFactory.eINSTANCE.createToolGroup();
		assertNull(g.getPalette());
		groupWithStdTool.getEntries().add(g);
		assertEquals(palette, g.getPalette());
	}

	public void testDefinesStandardTools() {
		assertFalse(GMFGenFactory.eINSTANCE.createPalette().definesStandardTools());
		assertTrue(palette.definesStandardTools());
		groupWithStdTool.getEntries().clear();
		assertFalse(palette.definesStandardTools());
	}

	// XXX might also test getIntKey, but gonna get rid of that method soon
}
