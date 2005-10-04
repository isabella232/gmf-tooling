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
import org.eclipse.gmf.bridge.genmodel.EditPartNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.MetaInfoProviderNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.NamingStrategy;
import org.eclipse.gmf.codegen.gmfgen.GenBaseElement;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.Utils;

public abstract class GenModelTransformerTest extends AbstractMappingTransformerTest {

	private NamingStrategy myEditPartNamingStrategy;
	private NamingStrategy myMetaInfoNamingStrategy;

	public GenModelTransformerTest(String name) {
		super(name);
	}

	public void testGenModelTransform() {
		final DiagramRunTimeModelHelper drtModelHelper = getRTHelper();
		final Mapping m = getMapping();

		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, getEditPartNamingStrategy(), getMetaInfoNamingStrategy());
		t.setEMFGenModel(Utils.createGenModel(m.getDiagram().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(m);
		GenDiagram genDiagram = t.getResult();
		assertNotNull("GenDiagram is expected as result of mapping transformation", genDiagram);
		assertNotNull("Diagram filename extension not set", genDiagram.getDiagramFileExtension());
		// FIXME add more

		GenNode genNode = (GenNode) findGenBaseElement(genDiagram.getNodes(), getEditPartNamingStrategy().createClassName(getNodeMapping()));
		assertNotNull("Result model contains no GenNode for nodeMapping", genNode);
		// FIXME add more

		GenLink genLink = (GenLink) findGenBaseElement(genDiagram.getLinks(), getEditPartNamingStrategy().createClassName(getLinkMapping()));
		assertNotNull("Result model contains no GenLink for linkMapping", genLink);
		// FIXME add more
	}

	public void testCreatedPalette() {
		fail("FIXME");
	}

	// actually, we could deal with GenCommonBase
	private GenBaseElement findGenBaseElement(EList/*<GenBaseElement>*/ genBaseElements, String epName) {
		for (Iterator it = genBaseElements.iterator(); it.hasNext(); ) {
			GenBaseElement next = (GenBaseElement) it.next();
			if (next.getEditPartClassName().equals(epName)) {
				return next;
			}
		}
		return null;
	}

	protected abstract DiagramRunTimeModelHelper getRTHelper();

	protected final NamingStrategy getEditPartNamingStrategy() {
		if (myEditPartNamingStrategy == null) {
			myEditPartNamingStrategy = createEditPartNamingStrategy();
		}
		return myEditPartNamingStrategy;
	}

	protected NamingStrategy createEditPartNamingStrategy() {
		return new EditPartNamingStrategy();
	}

	protected final NamingStrategy getMetaInfoNamingStrategy() {
		if (myMetaInfoNamingStrategy == null) {
			myMetaInfoNamingStrategy = createMetaInfoNamingStrategy();
		}
		return myMetaInfoNamingStrategy;
	}

	protected NamingStrategy createMetaInfoNamingStrategy() {
		return new MetaInfoProviderNamingStrategy();
	}
}
