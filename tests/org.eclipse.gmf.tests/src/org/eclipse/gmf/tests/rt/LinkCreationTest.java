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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
	 * TypeLink can be created only in straight direction
	 */
	public void testTypeLinkOutOnly() {
		GenLink genLink = getSetup().getGenModel().getLinkC();
		assertTrue("Incorrect session setup: outgoing creation should be allowed", genLink.isOutgoingCreationAllowed());
		assertFalse("Incorrect session setup: incoming creation should not be allowed", genLink.isIncomingCreationAllowed());
		checkLink(genLink);
	}

	/**
	 * Multiple TypeLinks can be created between choosen source and target
	 */
	public void testCreateMultipleTypeLinks() {
		GenLink genLink = getSetup().getGenModel().getLinkC();
		checkLinkCreation(genLink, false);
		checkLinkCreation(genLink, false);
		checkLinkCreation(genLink, false);
	}

	/**
	 * TypeLink can be created only in reversed direction
	 */
	public void testTypeLinkInOnly() {
		GenLink genLink = getLink(true, 1);
		assertFalse("Incorrect session setup: outgoing creation should not be allowed", genLink.isOutgoingCreationAllowed());
		assertTrue("Incorrect session setup: incoming creation should be allowed", genLink.isIncomingCreationAllowed());
		checkLink(genLink);
	}

	/**
	 * Only one TypeLink can be created between choosen source and target
	 */
	public void testCreateOneTypeLink() {
		GenLink genLink = getLink(true, 1);
		checkLinkCreation(genLink, true);

		checkLinkCreationNotAllowed(genLink);
	}

	/**
	 * TypeLink can be created in streight or reversed direction
	 */
	public void testTypeLinkInOut() {
		GenLink genLink = getLink(true, 2);
		assertTrue("Incorrect session setup: outgoing creation should be allowed", genLink.isOutgoingCreationAllowed());
		assertTrue("Incorrect session setup: incoming creation should be allowed", genLink.isIncomingCreationAllowed());
		checkLink(genLink);
	}

	/**
	 * Only two TypeLinks can be created between choosen source and target
	 */
	public void testCreateTwoTypeLinks() {
		GenLink genLink = getLink(true, 2);
		checkLinkCreation(genLink, false);
		checkLinkCreation(genLink, true);

		checkLinkCreationNotAllowed(genLink);
	}

	/**
	 * ReferenceLink can be created only in straight direction
	 */
	public void testRefLinkOutOnly() {
		Node nodeB = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB);
		checkLink(getSetup().getGenModel().getLinkD(), myNodeA, nodeB, true, false);
	}

	/**
	 * Multiple ReferenceLinks can be created between choosen source and target
	 * NOTE: in EMF reference links are always unique.
	 */
	public void testCreateMultipleReferenceLinks() {
		Node nodeB1 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB1);
		Node nodeB2 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB2);
		Node nodeB3 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB3);
		GenLink genLink = getSetup().getGenModel().getLinkD();
		checkLinkCreation(genLink, myNodeA, nodeB3, false);
		checkLinkCreation(genLink, myNodeA, nodeB1, false);
		checkLinkCreation(genLink, myNodeA, nodeB2, false);
	}

	/**
	 * ReferenceLink can be created only in reversed direction
	 */
	public void testRefLinkInOnly() {
		GenLink genLink = getLink(false, 1);
		assertFalse("Incorrect session setup: outgoing creation should not be allowed", genLink.isOutgoingCreationAllowed());
		assertTrue("Incorrect session setup: incoming creation should be allowed", genLink.isIncomingCreationAllowed());
		checkLink(genLink);
	}

	/**
	 * Only one ReferenceLink can be created between choosen source and target
	 */
	public void testCreateOneReferenceLink() {
		Node nodeB1 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB1);
		GenLink genLink = getLink(false, 1);
		checkLinkCreation(genLink, nodeB1, myNodeA, true);

		checkLinkCreationNotAllowed(genLink);
	}

	/**
	 * ReferenceLink can be created in streight or reversed direction
	 */
	public void testRefLinkInOut() {
		GenLink genLink = getLink(false, 2);
		assertTrue("Incorrect session setup: outgoing creation should be allowed", genLink.isOutgoingCreationAllowed());
		assertTrue("Incorrect session setup: incoming creation should be allowed", genLink.isIncomingCreationAllowed());
		checkLink(genLink);
	}

	/**
	 * Only two ReferenceLinks can be created between choosen source and target
	 * NOTE: in EMF reference links are always unique.
	 */
	public void testCreateTwoReferenceLinks() {
		Node nodeB1 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB1);
		Node nodeB2 = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
		assertNotNull("Unable to create another nodeB", nodeB2);
		GenLink genLink = getLink(false, 2);

		checkLinkCreation(genLink, myNodeA, nodeB1, false);
		checkLinkCreation(genLink, nodeB2, myNodeA, true);

		checkLinkCreationNotAllowed(genLink);
	}

	/**
	 * In EMF reference links are always unique.
	 */
	public void testCreateReferenceLinkUniqueness() {
		GenLink genLink = getLink(false, 2);
		assertTrue("Incorrect genLink found", genLink.getModelFacet() instanceof FeatureLinkModelFacet && ((FeatureLinkModelFacet) genLink.getModelFacet()).getMetaFeature().isUnique());
		checkLinkCreation(genLink, false);

		checkLinkCreationNotAllowed(genLink);
	}

	/**
	 * TypeLink: SelfLink should becreated in straight direction if both
	 * outgoing and incomming creations allowed
	 */
	public void testSelfTypeLinkOut() {
		Node nodeA1 = createNode(getSetup().getGenModel().getNodeA(), getDiagram());
		assertNotNull("Unable to create another nodeA", nodeA1);
		checkLinkCreation(getSelfLink(true), myNodeA, nodeA1, false);
	}

	/**
	 * ReferenceLink: SelfLink should becreated in straight direction if both
	 * outgoing and incomming creations allowed
	 */
	public void testSelfRefLinkOut() {
		Node nodeA1 = createNode(getSetup().getGenModel().getNodeA(), getDiagram());
		assertNotNull("Unable to create another nodeA", nodeA1);
		checkLinkCreation(getSelfLink(false), myNodeA, nodeA1, false);
	}

	private void checkLinkCreationNotAllowed(GenLink genLink) {
		checkLink(genLink, myNodeA, myNodeB, false, false);
	}

	private void checkLink(GenLink genLink) {
		checkLink(genLink, myNodeA, myNodeB, genLink.isOutgoingCreationAllowed(), genLink.isIncomingCreationAllowed());
	}

	private void checkLink(GenLink genLink, View sourceNode, View targetNode, boolean directCreation, boolean reversedCreation) {
		Command directCommand = getViewerConfiguration().getCreateLinkCommand(sourceNode, targetNode, genLink);
		assertTrue("Dirrect link creation command should " + (directCreation ? "" : "not ") + "be allowed", (directCommand != null && directCommand.canExecute()) == directCreation);
		Command reversedCommand = getViewerConfiguration().getCreateLinkCommand(targetNode, sourceNode, genLink);
		assertTrue("Reversed link creation command should " + (reversedCreation ? "" : "not ") + "be allowed", (reversedCommand != null && reversedCommand.canExecute()) == reversedCreation);
	}

	private GenLink getSelfLink(boolean typeLink) {
		for (Iterator it = getSetup().getGenModel().getGenDiagram().getLinks().iterator(); it.hasNext();) {
			GenLink nextLink = (GenLink) it.next();
			if (typeLink && nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
				TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
				if (modelFacet.getTargetMetaFeature().getTypeGenClass() == modelFacet.getContainmentMetaFeature().getGenClass()) {
					return nextLink;
				}
			} else if (!typeLink && nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				FeatureLinkModelFacet modelFacet = (FeatureLinkModelFacet) nextLink.getModelFacet();
				if (modelFacet.getMetaFeature().getTypeGenClass() == modelFacet.getMetaFeature().getGenClass()) {
					return nextLink;
				}
			}
		}
		fail("Self gen link was not found. Probably incorrect session setup used. isTypeLink = " + typeLink);
		return null;
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

	private void checkLinkCreation(GenLink link, boolean reversed) {
		checkLinkCreation(link, reversed ? myNodeB : myNodeA, reversed ? myNodeA : myNodeB, reversed);
	}

	private void checkLinkCreation(GenLink genLink, View source, View target, boolean reversed) {
		Edge link = createLink(genLink, source, target);
		assertNotNull(link);
		View srcView = reversed ? target : source;
		View dstView = reversed ? source : target;

		assertEquals(srcView, link.getSource());
		assertEquals(dstView, link.getTarget());
		if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
			checkSemanticTypeLink(link, srcView, dstView, (TypeLinkModelFacet) genLink.getModelFacet());
		} else if (genLink.getModelFacet() instanceof FeatureLinkModelFacet) {
			checkSemanticReferenceLink(link, srcView, dstView, (FeatureLinkModelFacet) genLink.getModelFacet());
		} else {
			fail("Link with unsupported model facet passed");
		}
	}

	private void checkSemanticReferenceLink(Edge link, View source, View target, FeatureLinkModelFacet facet) {
		EObject linkSource = source.getElement();
		EObject linkTarget = target.getElement();
		assertNull(link.getElement());

		EStructuralFeature linkFeature = linkSource.eClass().getEStructuralFeature(facet.getMetaFeature().getName());
		assertNotNull(linkFeature);
		Object linked = linkSource.eGet(linkFeature);
		if (linked instanceof Collection) {
			assertTrue("Link element was not added to the container", ((Collection) linked).contains(linkTarget));
		} else {
			assertEquals("Link element was not added to the container", linkTarget, linked);
		}
	}

	private void checkSemanticTypeLink(Edge link, View source, View target, TypeLinkModelFacet facet) {
		EObject linkSource = source.getElement();
		EObject linkElement = link.getElement();
		EObject linkTarget = target.getElement();
		assertNotNull(linkElement);

		if (facet.getSourceMetaFeature() == null) {
			EStructuralFeature containmentFeature = linkSource.eClass().getEStructuralFeature(facet.getContainmentMetaFeature().getName());
			assertNotNull(containmentFeature);
			Object contained = linkSource.eGet(containmentFeature);
			if (contained instanceof Collection) {
				assertTrue("Link element was not added to the container", ((Collection) contained).contains(linkElement));
			} else {
				assertEquals("Link element was not added to the container", linkElement, contained);
			}
		} else {
			EStructuralFeature sourceFeature = linkElement.eClass().getEStructuralFeature(facet.getSourceMetaFeature().getName());
			assertNotNull(sourceFeature);
			Object sources = linkElement.eGet(sourceFeature);
			if (sources instanceof Collection) {
				assertTrue("Link source was not set correctly", ((Collection) sources).contains(linkSource));
			} else {
				assertEquals("Link source was not set correctly", linkSource, sources);
			}
		}

		EStructuralFeature targetFeature = linkElement.eClass().getEStructuralFeature(facet.getTargetMetaFeature().getName());
		assertNotNull(targetFeature);
		Object targets = linkElement.eGet(targetFeature);
		if (targets instanceof Collection) {
			assertTrue("Link target was not set correctly", ((Collection) targets).contains(linkTarget));
		} else {
			assertEquals("Link target was not set correctly", linkTarget, targets);
		}
	}

}