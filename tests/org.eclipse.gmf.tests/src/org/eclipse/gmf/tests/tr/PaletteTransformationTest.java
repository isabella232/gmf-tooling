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
package org.eclipse.gmf.tests.tr;

import java.util.Iterator;

import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.ToolDefSetup;
import org.eclipse.gmf.tooldef.AbstractTool;
import org.eclipse.gmf.tooldef.CreationTool;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.GenericTool;

/**
 * TODO test ToolEntry.properties to appear in the code
 * TODO test collape/active attibutes of tooldef.ToolGroup
 * @author artem
 */
public class PaletteTransformationTest extends GenModelTransformerTest {

	private AbstractTool myTool2Reuse;
	/*
	 * Besides, we add it as a top-level tool, to check in #testTopLevelToolDefMovedToDefaultGroup
	 * And, it's a tool that is not referenced from any mappingEntry
	 */
	private GenericTool myToolWithClass;
	private CreationTool myToolFromWrongPalette;
	private org.eclipse.gmf.tooldef.ToolGroup myGroupWithWrongTool; 

	public PaletteTransformationTest(String name) {
		super(name);
	}

	protected MapDefSource initMapModel(DiaDefSource graphDef) {
		final ToolDefSetup toolDefSetup = new ToolDefSetup();
		myTool2Reuse = toolDefSetup.getNodeCreationTool();
		myTool2Reuse.setTitle("NodeTool");
		final MapSetup init = new MapSetup().init(graphDef, getSetup().getDomainModel(), toolDefSetup);
		// use same tool twice
		init.getNodeA().setTool(myTool2Reuse);
		init.getNodeB().setTool(myTool2Reuse);
		myToolWithClass = GMFToolFactory.eINSTANCE.createGenericTool();
		myToolWithClass.setTitle("ToolWithClass");
		myToolWithClass.setToolClass(Object.class);
		// and explicitly add it as a top-level tool
		init.getMapping().getDiagram().getPalette().getTools().add(myToolWithClass);
		myToolFromWrongPalette = GMFToolFactory.eINSTANCE.createCreationTool();
		myToolFromWrongPalette.setTitle("ToolFromWrongPalette");
		myGroupWithWrongTool = GMFToolFactory.eINSTANCE.createToolGroup();
		myGroupWithWrongTool.setTitle("GroupWithWrongTool");
		myGroupWithWrongTool.getTools().add(myToolFromWrongPalette);
		init.getClassLink().setTool(myToolFromWrongPalette);
		return init;
	}

	public void testToolEntryReuse() {
		ToolEntry te = findToolEntry(myTool2Reuse);
		assertNotNull(te);
		assertEquals(2, te.getGenNodes().size());
		assertEquals(2, te.getElements().size());
		assertEquals(0, te.getGenLinks().size());
		assertEquals("Node[A|B] should share same ToolEntry", 1, countToolEntriesWithName(myTool2Reuse.getTitle()));
	}

	public void testUseNonReferencedTool() {
		ToolEntry te = findToolEntry(myToolWithClass);
		assertNotNull("Present", te);
		assertEquals("... and only once", 1, countToolEntriesWithName(myToolWithClass.getTitle()));
		assertEquals(0, te.getGenNodes().size());
		assertEquals(0, te.getElements().size());
		assertEquals(0, te.getGenLinks().size());
	}

	public void testUseToolWithClass() {
		ToolEntry te = findToolEntry(myToolWithClass);
		assertNotNull("Present", te);
		assertNotNull(te.getQualifiedToolName());
		assertEquals(myToolWithClass.getToolClass().getName(), te.getQualifiedToolName());
	}

	public void testTopLevelToolDefMovedToDefaultGroup() {
		ToolEntry te = findToolEntry(myToolWithClass);
		assertNotNull("Present", te);
		assertFalse("not in palette...", te.eContainer() instanceof Palette);
		assertTrue("... rather in some group ...", te.eContainer() instanceof ToolGroup);
		ToolGroup group = (ToolGroup) te.eContainer();
		assertTrue("... which in turn is child of palette", group.eContainer() instanceof Palette);
	}

	public void testReferenceToolFromWrongPalette() {
		ToolEntry te = findToolEntry(myToolFromWrongPalette);
		assertNotNull("Present", te);
		assertEquals("... and only once", 1, countToolEntriesWithName(myToolFromWrongPalette.getTitle()));
		assertTrue("There's some group for mis-referenced tools...", te.eContainer() instanceof ToolGroup);
		ToolGroup group = (ToolGroup) te.eContainer();
		assert myGroupWithWrongTool.getTools().contains(myToolFromWrongPalette) : "just make sure we didn't forget to add one to another";
		assertNotSame("But it's not the transformation of the original owner", myGroupWithWrongTool.getTitle(), group.getTitle());
	}

	private ToolEntry findToolEntry(AbstractTool tool) {
		Palette palette = transformationResult.getDiagram().getPalette();
		for (Iterator it = palette.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof ToolEntry) {
				ToolEntry toolEntry = (ToolEntry) next;
				if (tool.getTitle().equals(toolEntry.getTitle())) {
					return toolEntry;
				}
			}
		}
		return null;
	}

	private int countToolEntriesWithName(String name) {
		int count = 0;
		Palette palette = transformationResult.getDiagram().getPalette();
		for (Iterator it = palette.eAllContents(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof ToolEntry) {
				ToolEntry toolEntry = (ToolEntry) next;
				if (name.equals(toolEntry.getTitle())) {
					count++;
				}
			}
		}
		return count;
	}

	protected DiagramRunTimeModelHelper getRTHelper() {
		return new BasicDiagramRunTimeModelHelper();
	}
}
