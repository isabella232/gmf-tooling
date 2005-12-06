/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkConstraints;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DomainModelFileSetup;

public class LinkCreationConstraintsTest extends RuntimeDiagramTestBase {
	NodeMapping NODE_MAPPING;
	NodeMapping CONTAINER_MAPPING;
	LinkMapping LINK_MAPPING;
	LinkMapping FIRST_CHILD_LINK_MAPPING;	
	LinkMapping REFERENCE_LINK_MAPPING;	
	LinkMapping MANY_REFERENCE_LINKS_MAPPING;	
	
	static class LinksDiadefSetup extends AbstractDiaDefs {	
		protected void init() {
			getCanvas().setName("LinksCanvas"); //$NON-NLS-1$
			createNode("Node"); //$NON-NLS-1$
			createNode("Container"); //$NON-NLS-1$
			createConnection("ReferenceOnlyConnection"); //$NON-NLS-1$
			createConnection("ManyReferencesOnlyConnection"); //$NON-NLS-1$			
			createConnection("LinkConnection"); //$NON-NLS-1$
			createConnection("FirstChildLinkConnection"); //$NON-NLS-1$			
		}		
	}
		
	class LinksMappings extends AbstractMappings {
		public LinksMappings(EPackage domainModel, DiaDefSource diaDefSource) {
			super(domainModel, diaDefSource);
		}
		
		protected void init() {
			mapCanvas("Root"); //$NON-NLS-1$
			NODE_MAPPING = mapNode("Node", "Node", "Root::elements"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			CONTAINER_MAPPING = mapNode("Container", "Container", "Root::elements"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			LINK_MAPPING = mapClassLink("LinkConnection", "Link", "Container::childNodes", "Link::target"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			addConstraints(LINK_MAPPING, 
					null, //$NON-NLS-1$
					"self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
			
			FIRST_CHILD_LINK_MAPPING = mapClassLink("FirstChildLinkConnection", "Link", "Container::firstChildNode", "Link::target"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						
			REFERENCE_LINK_MAPPING = mapRefLink("ReferenceOnlyConnection", "Container::referenceOnlyLink"); //$NON-NLS-1$ //$NON-NLS-2$
			addConstraints(REFERENCE_LINK_MAPPING, 
					"not self.acceptLinkKind.oclIsUndefined()", //$NON-NLS-1$
					"self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
			
			MANY_REFERENCE_LINKS_MAPPING = mapRefLink("ManyReferencesOnlyConnection", "Container::manyReferenceOnlyLinks"); //$NON-NLS-1$ //$NON-NLS-2$			
		}
	}	

	private EPackage domainMetaModel;
	
	public LinkCreationConstraintsTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		DomainModelFileSetup modelSetup = new DomainModelFileSetup();
		try {
			modelSetup.init(Plugin.createURI("/models/links/links.ecore")); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
			fail("Failed to setup the domain model. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		this.domainMetaModel = modelSetup.getModel();
		
		super.setUp();		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	protected AbstractMappings getMappings() {		
		return new LinksMappings(domainMetaModel, new LinksDiadefSetup());
	}
	
	protected void customizeGenModelBeforeGeneration() {
		super.customizeGenModelBeforeGeneration();
	}
	
	
	public void testCreateConstrainedLinks() throws Exception {		
		IMetamodelType nodeMetaType = getElementType(getGenElement(NODE_MAPPING));
		IMetamodelType linkMetaType = getElementType(getGenElement(LINK_MAPPING));
		IMetamodelType containerMetaType = getElementType(getGenElement(CONTAINER_MAPPING));
		IMetamodelType referenceLinkMetaType = getElementType(getGenElement(REFERENCE_LINK_MAPPING));		
						
		Diagram diagram = (Diagram)getDiagramEditPart().getModel();		
		Node sourceContainerNode = createNode(containerMetaType, diagram);
		EPath.setStructuralFeature(sourceContainerNode.getElement(), "acceptLinkKind", null); //$NON-NLS-1$		
		
		Node targetNode = createNode(nodeMetaType, diagram);		
		assertNotNull(findEditPart(getDiagramEditPart(), targetNode));
		EPath.setStructuralFeature(sourceContainerNode.getElement(), "acceptLinkKind", null); //$NON-NLS-1$				
		assertFalse("Can start link without acceptedLinkKind", //$NON-NLS-1$
				canStartLinkFrom(referenceLinkMetaType, sourceContainerNode));
		
		String linkKind = "kind1"; //$NON-NLS-1$
		EPath.setStructuralFeature(sourceContainerNode.getElement(), "acceptLinkKind", linkKind); //$NON-NLS-1$
		assertTrue("Allow start link with acceptedLinkKind", //$NON-NLS-1$ 
				canStartLinkFrom(referenceLinkMetaType, sourceContainerNode));		
				
		assertNull("Do not create link to node with different linkKind", //$NON-NLS-1$ 
				createLink(referenceLinkMetaType, sourceContainerNode, targetNode));		
		// set the same link kind to target node
		EPath.setStructuralFeature(targetNode.getElement(), "acceptLinkKind", linkKind); //$NON-NLS-1$
		Edge link = createLink(referenceLinkMetaType, sourceContainerNode, targetNode);
		assertNotNull("Link start should be allowed", link); //$NON-NLS-1$		
		// once create, refect 2nd link creation due to multiplicity 0..1
		assertNull("Do not create already existing link", //$NON-NLS-1$ 
				createLink(referenceLinkMetaType, sourceContainerNode, targetNode));
		assertFalse("Do allow start for 2nd link", //$NON-NLS-1$ 
				canStartLinkFrom(referenceLinkMetaType, sourceContainerNode));

		// test link with Class
		assertNotNull("Should create link for nodes with equal acceptLinkKind", //$NON-NLS-1$ 
				createLink(linkMetaType, sourceContainerNode, targetNode));
		// set different acceptLinkKind
		EPath.setStructuralFeature(sourceContainerNode.getElement(), "acceptLinkKind", null); //$NON-NLS-1$		
		assertTrue("Should start link with no restriction", //$NON-NLS-1$ 
				canStartLinkFrom(linkMetaType, sourceContainerNode));
		assertNull("Should not create link for nodes with different acceptLinkKind", //$NON-NLS-1$
				createLink(linkMetaType, sourceContainerNode, targetNode));
		// set the same acceptLinkKind to target node
		EPath.setStructuralFeature(targetNode.getElement(), "acceptLinkKind", null); //$NON-NLS-1$
		assertTrue(canStartLinkFrom(linkMetaType, sourceContainerNode));
		assertNotNull("Should create link for nodes with equal acceptLinkKind", //$NON-NLS-1$ 
				createLink(linkMetaType, sourceContainerNode, targetNode));		
	}
	
	static void addConstraints(LinkMapping linkMapping, String sourceConstraint, String endConstraint) {
		LinkConstraints constraints = GMFMapFactory.eINSTANCE.createLinkConstraints();
		Constraint source = GMFMapFactory.eINSTANCE.createConstraint();
		source.setBody(sourceConstraint);
		constraints.setSourceEnd(source);
		
		Constraint target = GMFMapFactory.eINSTANCE.createConstraint();
		target.setBody(endConstraint);
		constraints.setTargetEnd(target);
		
		linkMapping.setCreationConstraints(constraints);
	}	
}
