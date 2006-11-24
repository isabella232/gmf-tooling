/**
 * Copyright (c) 2006 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

public class LinkCreationTest extends GeneratedCanvasTest {

	private Node myNodeA;

	private Node myNodeB;

	public LinkCreationTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		myNodeA = getNotation(getNodeEditPartA());
		myNodeB = getNotation(getNodeEditPartB());
	}

	/**
	 * Link can be created only in straight direction
	 */
	public void testTypeLinkOutOnly() {
		checkLink(getSetup().getGenModel().getLinkC(), true, false);
	}

	/**
	 * Multiple links can be created between choosen source and target
	 */
	public void testCreateMultipleTypeLinks() {
		GenLink genLink = getSetup().getGenModel().getLinkC();
		checkLinkCreation(genLink, myNodeA, myNodeB);
		checkLinkCreation(genLink, myNodeA, myNodeB);
		checkLinkCreation(genLink, myNodeA, myNodeB);
	}

	/**
	 * Link can be created only in reversed direction
	 */
	public void testTypeLinkInOnly() {
		checkLink(getLink(true, 1), false, true);
	}

	/**
	 * Only one link can be created between choosen source and target
	 */
	public void testCreateOneTypeLink() {
		GenLink genLink = getLink(true, 1);
		checkLinkCreation(genLink, myNodeB, myNodeA);

		checkLink(genLink, false, false);
	}

	/**
	 * Link can be created in straught or reversed direction
	 */
	public void testTypeLinkInOut() {
		checkLink(getLink(true, 2), true, true);
	}

	/**
	 * Only two links can be created between choosen source and target
	 */
	public void testCreateTwoTypeLinks() {
		GenLink genLink = getLink(true, 2);
		checkLinkCreation(genLink, myNodeA, myNodeB);

		checkLinkCreation(genLink, myNodeB, myNodeA);

		checkLink(genLink, false, false);
	}

	public void testRefLinkOutOnly() {
		checkLink(getSetup().getGenModel().getLinkD(), true, false);
	}

	public void testRefLinkInOnly() {
		checkLink(getLink(true, 1), false, true);
	}

	public void testRefLinkInOut() {
		checkLink(getLink(true, 2), true, true);
	}

	private void checkLink(GenLink genLink, boolean directCreation, boolean reversedCreation) {
		Command directCommand = getViewerConfiguration().getCreateLinkCommand(myNodeA, myNodeB, genLink);
		assertTrue("Dirrect link creation command should " + (directCreation ? "" : "not ") + "be allowed", (directCommand != null && directCommand.canExecute()) == directCreation);
		Command reversedCommand = getViewerConfiguration().getCreateLinkCommand(myNodeB, myNodeA, genLink);
		assertTrue("Reversed link creation command should " + (reversedCreation ? "" : "not ") + "be allowed", (reversedCommand != null && reversedCommand.canExecute()) == reversedCreation);
	}

	private GenLink getLink(boolean typeLink, int cardinality) {
		for (Iterator it = getSetup().getGenModel().getGenDiagram().getLinks().iterator(); it.hasNext();) {
			GenLink nextLink = (GenLink) it.next();
			if (typeLink && nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
				if (modelFacet.getContainmentMetaFeature().getEcoreFeature().getUpperBound() == cardinality) {
					return nextLink;
				}
			} else if (!typeLink && nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				FeatureLinkModelFacet modelFacet = (FeatureLinkModelFacet) nextLink.getModelFacet();
				if (modelFacet.getMetaFeature().getEcoreFeature().getUpperBound() == cardinality) {
					return nextLink;
				}
			}
		}
		fail("Gen link was not found. Probably incorrect session setup used. type = " + typeLink + ", cardinality = " + cardinality);
		return null;
	}

	private void checkLinkCreation(GenLink genLink, View source, View target) {
		Edge link = createLink(genLink, source, target);
		assertNotNull(link);
		// TODO: check model link direction here (source + target) too
		assertEquals(myNodeA, link.getSource());
		assertEquals(myNodeB, link.getTarget());
	}

}