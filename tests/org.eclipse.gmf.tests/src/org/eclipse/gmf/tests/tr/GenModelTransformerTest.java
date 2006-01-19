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
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkEntry;
import org.eclipse.gmf.codegen.gmfgen.NodeEntry;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.internal.bridge.naming.CollectingDispenser;
import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tests.Utils;

public abstract class GenModelTransformerTest extends AbstractMappingTransformerTest {

	private NamingStrategy myNamingStrategy;
	private GenDiagram transfromationResult; 

	public GenModelTransformerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		final DiagramRunTimeModelHelper drtModelHelper = getRTHelper();
		final Mapping m = getMapping();
		CollectingDispenser uniquenessDispenser = new CollectingDispenser();
		GenModelNamingMediatorImpl namingMediator = new GenModelNamingMediatorImpl(uniquenessDispenser);
		myNamingStrategy = namingMediator.getEditPart();

		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, namingMediator);
		t.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(m);
		transfromationResult = t.getResult();
		uniquenessDispenser.forget();
	}

	public void testGenModelTransform() {
		assertNotNull("GenDiagram is expected as result of mapping transformation", transfromationResult);
		assertNotNull("Diagram filename extension not set", transfromationResult.getDiagramFileExtension());
		// FIXME add more

		GenNode genNode = (GenNode) findGenBaseElement(transfromationResult.getTopLevelNodes(), getEditPartNameStrategy().get(getNodeMapping()));
		assertNotNull("Result model contains no GenNode for nodeMapping", genNode);
		// FIXME add more

		GenLink genLink = (GenLink) findGenBaseElement(transfromationResult.getLinks(), getEditPartNameStrategy().get(getLinkMapping()));
		assertNotNull("Result model contains no GenLink for linkMapping", genLink);
		// FIXME add more
	}

	public void testCreatedPalette() {
		Palette palette = transfromationResult.getPalette();
		for (Iterator itN = getMapping().getNodes().iterator(); itN.hasNext();) {
			NodeMapping nodeMapping = (NodeMapping) (itN.next());
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
			for (Iterator itE = nextGroup.getNodeTools().iterator(); itE.hasNext();) {
				NodeEntry nodeEntry = (NodeEntry) (itE.next());
				for (Iterator itN = nodeEntry.getGenNode().iterator(); itN.hasNext();) {
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
			for (Iterator itE = nextGroup.getLinkTools().iterator(); itE.hasNext();) {
				LinkEntry linkEntry = (LinkEntry) (itE.next());
				for (Iterator itL = linkEntry.getGenLink().iterator(); itL.hasNext();) {
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
