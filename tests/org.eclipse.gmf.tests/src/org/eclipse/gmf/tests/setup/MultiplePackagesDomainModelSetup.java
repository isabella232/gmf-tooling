/*
 * Copyright (c) 2006 Borland Software Corporation
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * TODO separate setup for case with subpackages
 * @author artem
 */
public class MultiplePackagesDomainModelSetup implements DomainModelSource {
	private EPackage myPrimaryPackage;
	private NodeData myNodeFirstPackage;
	private NodeData myNodeSecondPackage;
	private EClass myDiagramElement;
	private LinkData myLinkThirdPackage;
	private EReference myLinkFromFirstToSecond;

	public MultiplePackagesDomainModelSetup() {
	}

	public MultiplePackagesDomainModelSetup init() {
		myPrimaryPackage = createPackage("prim");
		final EClass iElement = createEClass("IElement", null, false, true);
		myPrimaryPackage.getEClassifiers().add(iElement);
		final EClass iDiagramContainer = createEClass("IDiagramContainer", null, true, false);
		final EReference cr = createERef("all", true, iElement);
		iDiagramContainer.getEStructuralFeatures().add(cr);
		myPrimaryPackage.getEClassifiers().add(iDiagramContainer);

		final EPackage p2 = createPackage("first");
		final EClass node1 = createEClass("Node1", iElement);
		p2.getEClassifiers().add(node1);

		final EPackage p3 = createPackage("second");
		final EClass node2 = createEClass("Node2", iElement);
		p3.getEClassifiers().add(node2);

		final EPackage p4 = createPackage("third");
		final EClass link = createEClass("Link", null);
		final EReference target = createERef("targetToN1", false, node1);
		link.getEStructuralFeatures().add(target);
		final EClass someShitToContain = createEClass("SomeShitToContain", null, false, true);
		final EClass diagramContainerImpl = createEClass("DiagramContainerImpl", iDiagramContainer, false, false);
		p4.getEClassifiers().add(link);
		p4.getEClassifiers().add(someShitToContain);
		p4.getEClassifiers().add(diagramContainerImpl);

		final EReference linkCont = createERef("links", true, link);
		node2.getEStructuralFeatures().add(linkCont);
		node1.getEStructuralFeatures().add(createERef("someShit", true, someShitToContain));
		final EReference lnkNode2 = createERef("lnkNode2", false, node2);
		node1.getEStructuralFeatures().add(lnkNode2);

		// make sure p1 references p4 - just for fun
		iDiagramContainer.getEStructuralFeatures().add(createERef("anotherShit", true, someShitToContain));

		// init fields
		myNodeFirstPackage = new NodeData(node1, null, cr);
		myNodeSecondPackage = new NodeData(node2, null, cr);
		myLinkFromFirstToSecond = lnkNode2;
		myLinkThirdPackage = new LinkData(link, target, linkCont);
		myDiagramElement = diagramContainerImpl;

		confineInResource("r1", Collections.singletonList(myPrimaryPackage));
		confineInResource("r2", Arrays.asList(new Object[] {p2, p3, p4}));

		return this;
	}

	private static EClass createEClass(String name, EClass superClass) {
		return createEClass(name, superClass, false, false);
	}

	private static EClass createEClass(String name, EClass superClass, boolean isA, boolean isI) {
		EClass rv = EcoreFactory.eINSTANCE.createEClass();
		rv.setInterface(isI);
		rv.setAbstract(isA);
		rv.setName(name);
		if (superClass != null) {
			rv.getESuperTypes().add(superClass);
		}
		return rv;
	}

	private static EPackage createPackage(String name) {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName(name);
		p.setNsPrefix("ns" + name);
		p.setNsURI("uri:/gmf/tests/multi/" + name);
		return p;
	}

	private static EReference createERef(String name, boolean isCont, EClass toContain) {
		EReference cr = EcoreFactory.eINSTANCE.createEReference();
		cr.setContainment(isCont);
		cr.setName(name);
		cr.setEType(toContain);
		return cr;
	}

	private void confineInResource(String name, List toConfine) {
		new ResourceImpl(URI.createURI("uri://org.eclipse.gmf/tests/MultiPackSetup/" + name)).getContents().addAll(toConfine);
	}

	public EPackage getModel() {
		return myPrimaryPackage;
	}

	public NodeData getNodeA() {
		return myNodeSecondPackage;
	}

	public NodeData getNodeB() {
		return myNodeFirstPackage;
	}

	public LinkData getLinkAsClass() {
		return myLinkThirdPackage;
	}

	public EReference getLinkAsRef() {
		return myLinkFromFirstToSecond;
	}

	public EClass getDiagramElement() {
		return myDiagramElement;
	}
}
