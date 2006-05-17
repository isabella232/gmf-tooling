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

import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

public class LinkCreationConstraintsTest extends RuntimeDiagramTestBase {

	public LinkCreationConstraintsTest(String name) {
		super(name);
	}
	
	public void testCreateConstrainedLinks() throws Exception {
		Diagram diagram = (Diagram)getDiagramEditPart().getModel();		
		Node sourceContainerNode = createNode(getSourceGenNode(), diagram);
		setBusinessElementStructuralFeature(sourceContainerNode, "acceptLinkKind", null); //$NON-NLS-1$		
		
		Node targetNode = createNode(getTargetGenNode(), diagram);		
		assertNotNull(findEditPart(targetNode));
		setBusinessElementStructuralFeature(sourceContainerNode, "acceptLinkKind", null); //$NON-NLS-1$				
		assertFalse("Can start link without acceptedLinkKind", //$NON-NLS-1$
				canStartLinkFrom(getRefGenLink(), sourceContainerNode));
		
		String linkKind = "kind1"; //$NON-NLS-1$
		setBusinessElementStructuralFeature(sourceContainerNode, "acceptLinkKind", linkKind); //$NON-NLS-1$
		assertTrue("Allow start link with acceptedLinkKind", //$NON-NLS-1$ 
				canStartLinkFrom(getRefGenLink(), sourceContainerNode));		
				
		assertNull("Do not create link to node with different linkKind", //$NON-NLS-1$ 
				createLink(getRefGenLink(), sourceContainerNode, targetNode));		
		// set the same link kind to target node
		setBusinessElementStructuralFeature(targetNode, "acceptLinkKind", linkKind); //$NON-NLS-1$
		Edge link = createLink(getRefGenLink(), sourceContainerNode, targetNode);
		assertNotNull("Link start should be allowed", link); //$NON-NLS-1$		
		// once create, refect 2nd link creation due to multiplicity 0..1
		assertNull("Do not create already existing link", //$NON-NLS-1$ 
				createLink(getRefGenLink(), sourceContainerNode, targetNode));
		assertFalse("Do allow start for 2nd link", //$NON-NLS-1$ 
				canStartLinkFrom(getRefGenLink(), sourceContainerNode));

		// test link with Class
		assertNotNull("Should create link for nodes with equal acceptLinkKind", //$NON-NLS-1$ 
				createLink(getClassGenLink(), sourceContainerNode, targetNode));
		// set different acceptLinkKind
		setBusinessElementStructuralFeature(sourceContainerNode, "acceptLinkKind", null); //$NON-NLS-1$		
		assertTrue("Should start link with no restriction", //$NON-NLS-1$ 
				canStartLinkFrom(getClassGenLink(), sourceContainerNode));
		assertNull("Should not create link for nodes with different acceptLinkKind", //$NON-NLS-1$
				createLink(getClassGenLink(), sourceContainerNode, targetNode));
		// set the same acceptLinkKind to target node
		setBusinessElementStructuralFeature(targetNode, "acceptLinkKind", "kind1"); //$NON-NLS-1$ //$NON-NLS-2$
		setBusinessElementStructuralFeature(sourceContainerNode, "acceptLinkKind", "kind1"); //$NON-NLS-1$ //$NON-NLS-2$
		assertTrue(canStartLinkFrom(getClassGenLink(), sourceContainerNode));
		assertNotNull("Should create link for nodes with equal acceptLinkKind", //$NON-NLS-1$ 
				createLink(getClassGenLink(), sourceContainerNode, targetNode));		
	}

	private GenLink getRefGenLink() {
		return getGenModel().getLinkD();
	}

	private GenNode getSourceGenNode() {
		return getGenModel().getNodeA();
	}

	private GenLink getClassGenLink() {
		return getGenModel().getLinkC();
	}

	private GenNode getTargetGenNode() {
		return getGenModel().getNodeB();
	}

}
