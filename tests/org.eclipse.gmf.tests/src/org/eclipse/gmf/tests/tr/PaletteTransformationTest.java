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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.Separator;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
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

	private static final int TOOLS_FOR_CHECK = 5;
	private static final int SEP_2_POS = 4;
	private static final int SEP_1_POS = 2;

	private AbstractTool myTool2Reuse;
	/*
	 * Besides, we add it as a top-level tool, to check in #testTopLevelToolDefMovedToDefaultGroup
	 * And, it's a tool that is not referenced from any mappingEntry
	 */
	private GenericTool myToolWithClass;
	private CreationTool myToolFromWrongPalette;
	private org.eclipse.gmf.tooldef.ToolGroup myGroupWithWrongTool; 
	private org.eclipse.gmf.tooldef.ToolGroup myGroupWithOrderAndSeparators;
	private org.eclipse.gmf.tooldef.ToolGroup myToolStackGroup;
	

	public PaletteTransformationTest(String name) {
		super(name);
	}

	protected MapDefSource initMapModel(DiaDefSource graphDef) {
		final ToolDefSetup toolDefSetup = new ToolDefSetup();
		final MapSetup init = new MapSetup().init(graphDef, getSetup().getDomainModel(), toolDefSetup);
		// use same tool twice
		myTool2Reuse = GMFToolFactory.eINSTANCE.createCreationTool();
		myTool2Reuse.setTitle("NodeTool");
		toolDefSetup.getPalette().getTools().add(myTool2Reuse);
		init.getNodeA().setTool(myTool2Reuse);
		init.getNodeB().setTool(myTool2Reuse);
		myToolWithClass = GMFToolFactory.eINSTANCE.createGenericTool();
		myToolWithClass.setTitle("ToolWithClass");
		myToolWithClass.setToolClass(Object.class.getName());
		// and explicitly add it as a top-level tool
		init.getMapping().getDiagram().getPalette().getTools().add(myToolWithClass);
		myToolFromWrongPalette = GMFToolFactory.eINSTANCE.createCreationTool();
		myToolFromWrongPalette.setTitle("ToolFromWrongPalette");
		myGroupWithWrongTool = GMFToolFactory.eINSTANCE.createToolGroup();
		myGroupWithWrongTool.setTitle("GroupWithWrongTool");
		myGroupWithWrongTool.getTools().add(myToolFromWrongPalette);
		init.getClassLink().setTool(myToolFromWrongPalette);
		myGroupWithOrderAndSeparators = GMFToolFactory.eINSTANCE.createToolGroup();
		myGroupWithOrderAndSeparators.setTitle("GroupWithOrderAndSeparators");
		myGroupWithOrderAndSeparators.getTools().addAll(createToolsForOrderCheck(TOOLS_FOR_CHECK));
		myGroupWithOrderAndSeparators.getTools().add(SEP_1_POS, GMFToolFactory.eINSTANCE.createPaletteSeparator());
		myGroupWithOrderAndSeparators.getTools().add(SEP_2_POS, GMFToolFactory.eINSTANCE.createPaletteSeparator());
		toolDefSetup.getPalette().getTools().add(myGroupWithOrderAndSeparators);
		
		myToolStackGroup = GMFToolFactory.eINSTANCE.createToolGroup();
		myToolStackGroup.setTitle("StackGroup");
		myToolStackGroup.setStack(true);
		myToolStackGroup.getTools().addAll(createToolsForOrderCheck(2));
		toolDefSetup.getPalette().getTools().add(myToolStackGroup);
		
		return init;
	}

	private static List createToolsForOrderCheck(final int numOfTools) {
		assert numOfTools > 0;
		ArrayList rv = new ArrayList(numOfTools);
		for (int i = 0; i < numOfTools; i++) {
			// testOrderPreserved relies on fact there are GenericTools
			GenericTool t = GMFToolFactory.eINSTANCE.createGenericTool();
			t.setTitle("ToolOrder" + i);
			t.setToolClass(Object.class.getName());
			rv.add(t);
		}
		return rv;
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
		assertEquals(myToolWithClass.getToolClass(), te.getQualifiedToolName());
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

	public void testOrderPreserved() {
		ToolGroup transformed = findTransformedGroup(myGroupWithOrderAndSeparators);
		assertNotNull(transformed);
		Iterator itTransformed = transformed.getEntries().iterator();
		int toolsCompared = 0; 
		for (Iterator itOriginal = myGroupWithOrderAndSeparators.getTools().iterator(); itOriginal.hasNext();) {
			GenericTool next = null;
			do {
				Object o = itOriginal.next();
				if (o instanceof GenericTool) {
					next = (GenericTool) o;
				}
			} while (next == null && itOriginal.hasNext());
			if (next == null && !itOriginal.hasNext()) {
				break;
			}
			while (itTransformed.hasNext()) {
				Object o = itTransformed.next();
				if (o instanceof ToolEntry) {
					assertEquals(next.getTitle(), ((ToolEntry) o).getTitle());
					toolsCompared++;
					break;
				}
			}
		}
		assertEquals(TOOLS_FOR_CHECK, toolsCompared);
	}

	public void testSeparators() {
		ToolGroup transformed = findTransformedGroup(myGroupWithOrderAndSeparators);
		assertNotNull(transformed);
		ToolGroupItem item = (ToolGroupItem) transformed.getEntries().get(SEP_1_POS);
		assertTrue(item instanceof Separator);
		item = (ToolGroupItem) transformed.getEntries().get(SEP_2_POS);
		assertTrue(item instanceof Separator);
	}
	
	public void testStackGroup(){
		ToolGroup explicitlyStack = findTransformedGroup(myToolStackGroup);
		assertNotNull(explicitlyStack);
		assertTrue(explicitlyStack.isStack());
		
		ToolGroup byDefaultNotStack = findTransformedGroup(myGroupWithOrderAndSeparators);
		assertNotNull(byDefaultNotStack);
		assertFalse(byDefaultNotStack.isStack());
	}

	private ToolGroup findTransformedGroup(org.eclipse.gmf.tooldef.ToolGroup toolGroup) {
		ToolGroup transformed = null;
		for (Iterator it = getResultPalette().getGroups().iterator(); it.hasNext();) {
			ToolGroup next = (ToolGroup) it.next();
			if (toolGroup.getTitle().equals(next.getTitle())) {
				transformed = next;
				break;
			}
		}
		return transformed;
	}

	private ToolEntry findToolEntry(AbstractTool tool) {
		Palette palette = getResultPalette();
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

	private Palette getResultPalette() {
		Palette palette = transformationResult.getDiagram().getPalette();
		return palette;
	}

	private int countToolEntriesWithName(String name) {
		int count = 0;
		Palette palette = getResultPalette();
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
