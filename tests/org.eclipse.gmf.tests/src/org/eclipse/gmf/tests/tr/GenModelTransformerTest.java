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
package org.eclipse.gmf.tests.tr;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolEntry;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.Utils;

public abstract class GenModelTransformerTest extends AbstractMappingTransformerTest {

	private NamingStrategy myNamingStrategy;
	protected GenEditorGenerator transformationResult; 

	public GenModelTransformerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		final DiagramRunTimeModelHelper drtModelHelper = getRTHelper();
		final Mapping m = getMapping();
		GenModelNamingMediatorImpl namingMediator = new GenModelNamingMediatorImpl();
		myNamingStrategy = namingMediator.getEditPart();

		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, namingMediator);
		t.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(m);
		transformationResult = t.getResult();
		namingMediator.reset();
	}

	public void testGenModelTransform() {
		assertNotNull("GenEditorGenerator is expected as result of mapping transformation", transformationResult);
		assertNotNull("GenDiagram is expected to be set...", transformationResult.getDiagram());
		assertNotNull("... as well as GenPlugin is expected to be set", transformationResult.getPlugin());
		assertNotNull("Diagram filename extension not set", transformationResult.getDiagramFileExtension());
		// FIXME add more

		GenNode genNode = (GenNode) findGenBaseElement(transformationResult.getDiagram().getTopLevelNodes(), getEditPartNameStrategy().get(getNodeMapping()));
		assertNotNull("Result model contains no GenNode for nodeMapping", genNode);
		// FIXME add more

		GenLink genLink = (GenLink) findGenBaseElement(transformationResult.getDiagram().getLinks(), getEditPartNameStrategy().get(getLinkMapping()));
		assertNotNull("Result model contains no GenLink for linkMapping", genLink);
		// FIXME add more
	}
	
	public void testCreatedPalette() {
		Palette palette = transformationResult.getDiagram().getPalette();
		for (Iterator itN = getMapping().getNodes().iterator(); itN.hasNext();) {
			final TopNodeReference topNode = (TopNodeReference) (itN.next());
			final NodeMapping nodeMapping = topNode.getChild();
			assertEquals(nodeMapping.getTool() != null ? 1 : 0, countUses(nodeMapping, palette));
		}
		for (Iterator itL = getMapping().getLinks().iterator(); itL.hasNext();) {
			LinkMapping linkMapping = (LinkMapping) (itL.next());
			assertEquals(linkMapping.getTool() != null ? 1 : 0, countUses(linkMapping, palette));
		}
		// TODO add grooping test
	}

	private GenCommonBase findGenBaseElement(EList/* <GenCommonBase> */genBaseElements, String epName) {
		for (Iterator it = genBaseElements.iterator(); it.hasNext();) {
			GenCommonBase next = (GenCommonBase) it.next();
			if (next.getEditPartClassName().equals(epName)) {
				return next;
			}
		}
		return null;
	}

	private int countUses(NodeMapping mappingEntry, Palette palette) {
		int uses = 0;
		final String epName = getEditPartNameStrategy().get(mappingEntry);
		for (Iterator itG = palette.getGroups().iterator(); itG.hasNext();) {
			ToolGroup nextGroup = (ToolGroup) (itG.next());
			for (Iterator itE = nextGroup.getEntries().iterator(); itE.hasNext();) {
				ToolGroupItem item = (ToolGroupItem) itE.next();
				if (false == item instanceof ToolEntry) {
					continue;
				}
				for (Iterator itN = ((ToolEntry) item).getGenNodes().iterator(); itN.hasNext();) {
					GenNode genNode = (GenNode) itN.next();
					if (genNode.getEditPartClassName().equals(epName)) {
						uses++;
					}
				}
			}
		}
		return uses;
	}

	private int countUses(LinkMapping mappingEntry, Palette palette) {
		int uses = 0;
		final String epName = getEditPartNameStrategy().get(mappingEntry);
		for (Iterator itG = palette.getGroups().iterator(); itG.hasNext();) {
			ToolGroup nextGroup = (ToolGroup) (itG.next());
			for (Iterator itE = nextGroup.getEntries().iterator(); itE.hasNext();) {
				ToolGroupItem item = (ToolGroupItem) itE.next();
				if (false == item instanceof ToolEntry) {
					continue;
				}
				for (Iterator itL = ((ToolEntry) item).getGenLinks().iterator(); itL.hasNext();) {
					GenLink genLink = (GenLink) itL.next();
					if (genLink.getEditPartClassName().equals(epName)) {
						uses++;
					}
				}
			}
		}
		return uses;
	}

	protected abstract DiagramRunTimeModelHelper getRTHelper();

	protected final NamingStrategy getEditPartNameStrategy() {
		return myNamingStrategy;
	}
}
