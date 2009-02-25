/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gmf.tests.setup.SessionSetup;

/**
 * @author artem
 */
public class PaletteTest extends GeneratedCanvasTest {


	public PaletteTest(String name) {
		super(name);
		myDefaultSetup = SessionSetup.newInstance();

	}
	// [236869] Provide id for ToolEntry to allow palette customization
	public void testEntriesGetIdentity() throws Exception {
		PaletteRoot root = getPaletteRoot();
		assertFalse(root.getChildren().isEmpty());
		boolean creationToolFound = false;
		HashMap<String, PaletteEntry> duplicateSearch = new HashMap<String, PaletteEntry>();
		LinkedList<PaletteEntry> entries = new LinkedList<PaletteEntry>();
		@SuppressWarnings("unchecked")
		List<PaletteEntry> children = root.getChildren();
		entries.addAll(children);
		while (!entries.isEmpty()) {
			PaletteEntry entry = entries.removeFirst();
			if (entry instanceof ToolEntry && ((ToolEntry) entry).createTool() instanceof CreationTool) {
				creationToolFound = true;
				assertFalse("Tool " + entry.getLabel() + " has no identity", entry.getId().trim().equals(""));
				PaletteEntry dup;
				if ((dup = duplicateSearch.put(entry.getId(), entry)) != null) {
					fail("Tool " + entry.getLabel() + "has same identity as tool " + dup.getLabel() + ":" + entry.getId());
				}
			} else if (entry instanceof PaletteContainer) {
				@SuppressWarnings("unchecked")
				List<PaletteEntry> ch = ((PaletteContainer) entry).getChildren();
				entries.addAll(ch);
			}
		}
		assertTrue("Palette has no elements to check", creationToolFound);
	}

	private PaletteRoot getPaletteRoot() throws Exception {
		String paletteClassName = getSetup().getGenModel().getGenDiagram().getPalette().getFactoryQualifiedClassName();
		Class<?> paletteClass = getSetup().loadGeneratedClass(paletteClassName);
		Object paletteFactory = paletteClass.newInstance();
		PaletteRoot rv = new PaletteRoot();
		paletteClass.getMethod("fillPalette", PaletteRoot.class).invoke(paletteFactory, rv);
		return rv;
		// doesn't work: FakeViewer doesn't initialize paletteViewer
		// getViewerConfiguration().getViewer().getEditDomain().getPaletteViewer().getPaletteRoot();
	}
}
