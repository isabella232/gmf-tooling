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
package org.eclipse.gmf.tests.setup;

import java.util.Calendar;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * TODO:
 * ADD: 
 *  - link label feature
 *  - more nodes
 *  - child nodes
 */
public class DomainModelSetup implements DomainModelSource {
	private EPackage myModelPackage;
	private NodeData myNodeA;
	private LinkData myLinkA2C;
	private EReference myLinkAsRef;
	private EClass myDiagramElement;
	private NodeData myNodeB;

	public DomainModelSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public DomainModelSetup init() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName("SampleModel");
		p.setNsPrefix("gmftest");
		Calendar c = Calendar.getInstance();
		p.setNsURI("uri://eclipse/gmf/tests/sample/" + c.get(Calendar.HOUR_OF_DAY) + '/' + c.get(Calendar.MINUTE) + '/');

		EClass superNode = EcoreFactory.eINSTANCE.createEClass();
		superNode.setName("CommonBaseClass");
		superNode.setAbstract(true);

		EClass containmentNode = EcoreFactory.eINSTANCE.createEClass();
		containmentNode.setName("UltimateContainer");
		EReference r0 = EcoreFactory.eINSTANCE.createEReference();
		r0.setContainment(true);
		r0.setName("all");
		r0.setEType(superNode);
		r0.setUpperBound(-1);
		containmentNode.getEStructuralFeatures().add(r0);

		EClass nodeA = EcoreFactory.eINSTANCE.createEClass();
		nodeA.setName("NodeSrcA");
		nodeA.getESuperTypes().add(superNode);
		EClass nodeB = EcoreFactory.eINSTANCE.createEClass();
		nodeB.setName("NodeTargetB");
		nodeB.getESuperTypes().add(superNode);
		EClass nodeC = EcoreFactory.eINSTANCE.createEClass();
		nodeC.setName("NodeTargetC");
		EClass nodeLinkA2C = EcoreFactory.eINSTANCE.createEClass();
		nodeLinkA2C.setName("LinkAtoC");

		EAttribute a1 = EcoreFactory.eINSTANCE.createEAttribute();
		a1.setName("label");
		a1.setEType(EcorePackage.eINSTANCE.getEString());
		nodeA.getEStructuralFeatures().add(a1);

		EAttribute a2 = EcoreFactory.eINSTANCE.createEAttribute();
		a2.setName("title");
		a2.setEType(EcorePackage.eINSTANCE.getEString());
		nodeB.getEStructuralFeatures().add(a2);
		nodeC.getESuperTypes().add(nodeB);

		EReference linkToB = EcoreFactory.eINSTANCE.createEReference();
		linkToB.setName("refLinkToB");
		linkToB.setEType(nodeB);
		linkToB.setUpperBound(-1);
		nodeA.getEStructuralFeatures().add(linkToB);

		EReference linkToC = EcoreFactory.eINSTANCE.createEReference();
		linkToC.setName("classLinkToC");
		linkToC.setEType(nodeLinkA2C);
		linkToC.setUpperBound(-1);
		linkToC.setContainment(true);
		nodeA.getEStructuralFeatures().add(linkToC);

		EReference refCfromLink = EcoreFactory.eINSTANCE.createEReference();
		refCfromLink.setName("trg");
		refCfromLink.setEType(nodeC);
		nodeLinkA2C.getEStructuralFeatures().add(refCfromLink);

		p.getEClassifiers().add(superNode);
		p.getEClassifiers().add(containmentNode);
		p.getEClassifiers().add(nodeA);
		p.getEClassifiers().add(nodeB);
		p.getEClassifiers().add(nodeC);
		p.getEClassifiers().add(nodeLinkA2C);

		confineInResource(p);

		myModelPackage = p;
		myNodeA = new NodeData(nodeA, null/*FIXME a1*/, r0);
		myLinkA2C = new LinkData(nodeLinkA2C, refCfromLink, linkToC);
		myNodeB = new NodeData(nodeC, null, r0);
		myLinkAsRef = linkToB;
		myDiagramElement = containmentNode;
		return this;
	}

	private void confineInResource(Object p) {
		new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/DomainModelSetup")).getContents().add(p);
	}

	public final EPackage getModel() {
		return myModelPackage;
	}

	public final NodeData getNodeA() {
		return myNodeA;
	}

	public NodeData getNodeB() {
		return myNodeB;
	}

	public final LinkData getLinkAsClass() {
		return myLinkA2C;
	}

	public final EReference getLinkAsRef() {
		return myLinkAsRef;
	}

	public EClass getDiagramElement() {
		return myDiagramElement;
	}
}
