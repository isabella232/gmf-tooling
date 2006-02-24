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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;

/**
 * @author artem
 */
public class MapDefWithReuseSetup implements MapDefSource {
	private Mapping myMap;
	private NodeMapping myNodeA;
	private NodeMapping myNodeB;

	public MapDefWithReuseSetup() {
	}

	/**
	 * (*) Top NodeA has single child that references NodeA. 
	 * DGMT in it's current state can't reuse GenTopLevelNode for GenChildNode, thus
	 * creating separate child node with same attributes as top-level one.
	 * (*) Top NodeB has child that references itself. DGMT should reuse child's mapping,
	 * and child's children should point to itself (?)
	 */
	public MapDefWithReuseSetup init(DiaDefSource ddSource) {
		final EPackage domainPack = EcoreFactory.eINSTANCE.createEPackage();
		final EClass domainA = EcoreFactory.eINSTANCE.createEClass();
		domainA.setName("DomainA");
		final EClass domainB = EcoreFactory.eINSTANCE.createEClass();
		domainB.setName("DomainB");

		final EReference aOwnsA = newContainment("aOwnsA", domainA);
		domainA.getEStructuralFeatures().add(aOwnsA);
		final EReference aOwnsB = newContainment("aOwnsB", domainB);
		domainA.getEStructuralFeatures().add(aOwnsB);
		final EReference bOwnsB = newContainment("bOwnsB", domainB);
		domainB.getEStructuralFeatures().add(bOwnsB);

		domainPack.getEClassifiers().add(domainA);
		domainPack.getEClassifiers().add(domainB);

		myMap = GMFMapFactory.eINSTANCE.createMapping();
		CanvasMapping cme = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cme.setDiagramCanvas(ddSource.getCanvasDef());
		cme.setDomainModel(domainPack);
		myMap.setDiagram(cme);

		myNodeA = GMFMapFactory.eINSTANCE.createNodeMapping();
		myNodeA.setDiagramNode(ddSource.getNodeDef());
		myNodeA.setDomainMetaElement(domainA);
		ChildReference childRef = GMFMapFactory.eINSTANCE.createChildReference();
		childRef.setContainmentFeature(aOwnsA);
		childRef.setReferencedChild(myNodeA);
		myNodeA.getChildren().add(childRef);

		myNodeB = GMFMapFactory.eINSTANCE.createNodeMapping();
		myNodeB.setDiagramNode(ddSource.getNodeDef());
		myNodeB.setDomainMetaElement(domainB);
		
		NodeMapping bFirstLevel = GMFMapFactory.eINSTANCE.createNodeMapping();
		bFirstLevel.setDiagramNode(ddSource.getNodeDef());
		bFirstLevel.setDomainMetaElement(domainB);

		// cycle to bFirstLevel itself
		childRef = GMFMapFactory.eINSTANCE.createChildReference();
		childRef.setContainmentFeature(bOwnsB);
		childRef.setReferencedChild(bFirstLevel);
		bFirstLevel.getChildren().add(childRef);

		// nodeB owns bFirstLevel
		childRef = GMFMapFactory.eINSTANCE.createChildReference();
		childRef.setContainmentFeature(bOwnsB);
		childRef.setOwnedChild(bFirstLevel);
		myNodeB.getChildren().add(childRef);

		TopNodeReference tnr = GMFMapFactory.eINSTANCE.createTopNodeReference();
		tnr.setOwnedChild(myNodeA);
		tnr.setContainmentFeature(aOwnsA);
		myMap.getNodes().add(tnr);

		tnr = GMFMapFactory.eINSTANCE.createTopNodeReference();
		tnr.setOwnedChild(myNodeB);
		tnr.setContainmentFeature(aOwnsB);
		myMap.getNodes().add(tnr);

		return this;
	}

	private static EReference newContainment(String name, final EClass domainClass) {
		final EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName(name);
		ref.setContainment(true);
		ref.setUpperBound(-1);
		ref.setEType(domainClass);
		return ref;
	}

	public final Mapping getMapping() {
		return myMap;
	}

	public final CanvasMapping getCanvas() {
		return getMapping().getDiagram();
	}

	public NodeMapping getNodeA() {
		return myNodeA;
	}

	public NodeMapping getNodeB() {
		return myNodeB;
	}

	public LinkMapping getClassLink() {
		throw new UnsupportedOperationException();
	}

	public LinkMapping getReferenceLink() {
		throw new UnsupportedOperationException();
	}
}
