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

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenConstraint;
import org.eclipse.gmf.codegen.gmfgen.GenLanguage;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkConstraints;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelMatcher;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;

public class LinkCreationConstraintsTest extends RuntimeDiagramTestBase {

	public LinkCreationConstraintsTest(String name) {
		super(name);
	}
	
	/*
	 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=148818 
	 */
	public void testEndContexts() {
		GenLink genLinkOrigin = getGenModel().getLinkC();
		GenLink genLink = (GenLink)EcoreUtil.copy(genLinkOrigin);
		assertTrue(genLink.getModelFacet() instanceof TypeLinkModelFacet);
		TypeLinkModelFacet tlModelFacet = (TypeLinkModelFacet)genLink.getModelFacet();
		assertTrue(tlModelFacet.getContainmentMetaFeature() != null && tlModelFacet.getTargetMetaFeature() != null);
		
		GenLinkConstraints constraints = GMFGenFactory.eINSTANCE.createGenLinkConstraints();
		constraints.setSourceEnd(createDummyConstraint());
		constraints.setTargetEnd(createDummyConstraint());
		genLink.setCreationConstraints(constraints);
		
		assertSame("Target end context must be the containment feature owner", //$NON-NLS-1$
				tlModelFacet.getContainmentMetaFeature().getGenClass(),
				constraints.getSourceEndContextClass());
		
		assertSame("Source end context must be the target feature type", //$NON-NLS-1$
				tlModelFacet.getTargetMetaFeature().getTypeGenClass(),
				constraints.getTargetEndContextClass());
		
		GenModelMatcher genModelMatcher = new GenModelMatcher(getGenModel().getGenDiagram().getDomainDiagramElement().getGenModel());
		
		GenFeature sourceFeature = genModelMatcher.findGenFeature(tlModelFacet.getMetaClass().getEcoreClass().getEStructuralFeature("source")); //$NON-NLS-1$
		assertNotNull("Link element's source feature not found", sourceFeature); //$NON-NLS-1$
		tlModelFacet.setSourceMetaFeature(sourceFeature);
		
		assertSame("Source end context with source feature must the feature's owner class", //$NON-NLS-1$
				sourceFeature.getTypeGenClass(), constraints.getSourceEndContextClass()); 
	}
	
	private static GenConstraint createDummyConstraint() {
		GenConstraint constraint = GMFGenFactory.eINSTANCE.createGenConstraint();
		constraint.setLanguage(GenLanguage.OCL_LITERAL);
		constraint.setBody("true"); //$NON-NLS-1$
		return constraint;
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
