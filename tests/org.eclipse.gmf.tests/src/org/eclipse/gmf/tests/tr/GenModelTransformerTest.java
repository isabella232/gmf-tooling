/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
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

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediator;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.Utils;

public abstract class GenModelTransformerTest extends AbstractMappingTransformerTest {

	protected GenEditorGenerator myTransformationResult;
	private DiagramGenModelTransformer myTransformer;
	private final DiagramRunTimeModelHelper myDiagramModelHelper; 

	protected GenModelTransformerTest(String name, DiagramRunTimeModelHelper rtHelper) {
		super(name);
		assert rtHelper != null;
		myDiagramModelHelper = rtHelper;
	}

	protected void setUp() throws Exception {
		super.setUp();
		final Mapping m = getMapping();
		myTransformer = new DiagramGenModelTransformer(myDiagramModelHelper, new GenModelNamingMediator.Empty());
		myTransformer.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel()));
		myTransformer.transform(m);
		myTransformationResult = myTransformer.getResult();
	}

	public void testGenModelTransform() {
		assertNotNull("GenEditorGenerator is expected as result of mapping transformation", myTransformationResult);
		assertNotNull("GenDiagram is expected to be set...", myTransformationResult.getDiagram());
		assertNotNull("... as well as GenPlugin is expected to be set", myTransformationResult.getPlugin());
		assertNotNull("Diagram filename extension not set", myTransformationResult.getDiagramFileExtension());
		// FIXME add more

		GenNode[] genNodes = myTransformer.getTrace().find(getNodeMapping());
		assertEquals("Result model contains no GenNode for nodeMapping", 1, genNodes.length);
		// FIXME add more

		GenLink genLink = myTransformer.getTrace().find(getLinkMapping());
		assertNotNull("Result model contains no GenLink for linkMapping", genLink);
		// FIXME add more
	}
	
	public void testCreatedPalette() {
		final Palette palette = myTransformationResult.getDiagram().getPalette();
		for (TopNodeReference topNode : getMapping().getNodes()) {
			final NodeMapping nodeMapping = topNode.getChild();
			GenTopLevelNode genNode = myTransformer.getTrace().findTopNode(nodeMapping);
			assertNotNull(genNode);
			assertEquals(nodeMapping.getTool() != null ? 1 : 0, countUses(genNode, palette));
		}
		for (LinkMapping linkMapping : getMapping().getLinks()) {
			GenLink genLink = myTransformer.getTrace().find(linkMapping);
			assertNotNull(genLink);
			assertEquals(linkMapping.getTool() != null ? 1 : 0, countUses(genLink, palette));
		}
		// TODO add grooping test
	}

	private static int countUses(GenCommonBase genElement, Palette palette) {
		int uses = 0;
		for (ToolGroup nextGroup : palette.getGroups()) {
			for (ToolGroupItem item : nextGroup.getEntries()) {
				if (false == item instanceof ToolEntry) {
					continue;
				}
				for (GenCommonBase cb : ((ToolEntry) item).getElements()) {
					if (cb == genElement) {
						uses++;
						// although it's hardly there's more that one GenCommonBase in EMF EList for ToolEntry#elements, doesn't hurt 
						// *not to* break here 
					}
				}
			}
		}
		return uses;
	}
}
