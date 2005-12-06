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
import org.eclipse.gmf.bridge.genmodel.DefaultNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.NamingStrategy;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.Utils;

public abstract class GenModelTransformerTest extends AbstractMappingTransformerTest {

	private NamingStrategy myNamingStrategy;

	public GenModelTransformerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void testGenModelTransform() {
		final DiagramRunTimeModelHelper drtModelHelper = getRTHelper();
		final Mapping m = getMapping();

		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, getNamingStrategy());
		t.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(m);
		getNamingStrategy().reset();
		GenDiagram genDiagram = t.getResult();
		assertNotNull("GenDiagram is expected as result of mapping transformation", genDiagram);
		assertNotNull("Diagram filename extension not set", genDiagram.getDiagramFileExtension());
		// FIXME add more

		GenNode genNode = (GenNode) findGenBaseElement(genDiagram.getNodes(), getNamingStrategy().createNodeClassName(getNodeMapping(), GenCommonBase.EDIT_PART_SUFFIX));
		assertNotNull("Result model contains no GenNode for nodeMapping", genNode);
		// FIXME add more

		GenLink genLink = (GenLink) findGenBaseElement(genDiagram.getLinks(), getNamingStrategy().createLinkClassName(getLinkMapping(), GenCommonBase.EDIT_PART_SUFFIX));
		assertNotNull("Result model contains no GenLink for linkMapping", genLink);
		// FIXME add more
	}

	public void testCreatedPalette() {
		final DiagramRunTimeModelHelper drtModelHelper = getRTHelper();
		final Mapping m = getMapping();
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, getNamingStrategy());
		t.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(m);
		getNamingStrategy().reset();
		GenDiagram genDiagram = t.getResult();
		Palette palette = genDiagram.getPalette();
		for (Iterator itN = m.getNodes().iterator(); itN.hasNext();) {
			NodeMapping nodeMapping = (NodeMapping) (itN.next());
			assertEquals(nodeMapping.getTool() != null ? 1 : 0, countUses(nodeMapping, palette));
		}
		for (Iterator itL = m.getLinks().iterator(); itL.hasNext();) {
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
		final String epName = getNamingStrategy().createNodeClassName(mappingEntry, GenCommonBase.EDIT_PART_SUFFIX);
		for (Iterator itG = palette.getGroups().iterator(); itG.hasNext();) {
			ToolGroup nextGroup = (ToolGroup) (itG.next());
			for (Iterator itE = nextGroup.getNodeTools().iterator(); itE.hasNext();) {
				NodeEntry nodeEntry = (NodeEntry) (itE.next());
				if (nodeEntry.getGenNode().getEditPartClassName().equals(epName)) {
					uses++;
				}
			}
		}
		return uses;
	}

	private int countUses(LinkMapping mappingEntry, Palette palette) {
		int uses = 0;
		final String epName = getNamingStrategy().createLinkClassName(mappingEntry, GenCommonBase.EDIT_PART_SUFFIX);
		for (Iterator itG = palette.getGroups().iterator(); itG.hasNext();) {
			ToolGroup nextGroup = (ToolGroup) (itG.next());
			for (Iterator itE = nextGroup.getLinkTools().iterator(); itE.hasNext();) {
				LinkEntry linkEntry = (LinkEntry) (itE.next());
				if (linkEntry.getGenLink().getEditPartClassName().equals(epName)) {
					uses++;
				}
			}
		}
		return uses;
	}

	protected abstract DiagramRunTimeModelHelper getRTHelper();

	protected final NamingStrategy getNamingStrategy() {
		if (myNamingStrategy == null) {
			myNamingStrategy = createNamingStrategy();
		}
		return myNamingStrategy;
	}

	protected NamingStrategy createNamingStrategy() {
		return new DefaultNamingStrategy();
	}
}
