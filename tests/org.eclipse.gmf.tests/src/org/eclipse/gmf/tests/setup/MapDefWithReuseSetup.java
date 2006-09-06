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
 * IMPORTANT: {@link GenModelTransformerSimpleTest} havily relies on the structure of this setup. 
 * You may use this setup for your needs unless you modify it.
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
	 * and child's children should point to itself.
	 *  
	 * NOTE, gmfgen structures for both NodeA and NodeB will be similar, the difference is
	 * in the mapping declaration and in the DGMT code we actually check. The only difference
	 * between genNodeAChild and genNodeBChild would be different viewmap allowed for latter 
	 * (due to additional, bNodeFirstLevel, mapping that may reference another graphdef figure.   
	 *  
	 * (*) Top NodeB has another child, NodeC (via bOwnsC), that references itself, but with 
	 * containment feature (cOwnsC) that is (of course) different from bOwnsC. We use this 
	 * to check case from https://bugs.eclipse.org/bugs/show_bug.cgi?id=129552 - same node 
	 * but different containments doesn't allow us to reuse GenChildNode (which has single ModelFacet 
	 * attached to it, with single containment feature)
	 */
	public MapDefWithReuseSetup init(DiaDefSource ddSource) {
		final EPackage domainPack = EcoreFactory.eINSTANCE.createEPackage();
		domainPack.setName("DomainPack");
		final EClass domainA = EcoreFactory.eINSTANCE.createEClass();
		domainA.setName("DomainA");
		final EClass domainB = EcoreFactory.eINSTANCE.createEClass();
		domainB.setName("DomainB");
		final EClass domainC = EcoreFactory.eINSTANCE.createEClass();
		domainC.setName("DomainC");

		final EReference aOwnsA = newContainment("aOwnsA", domainA);
		domainA.getEStructuralFeatures().add(aOwnsA);
		final EReference aOwnsB = newContainment("aOwnsB", domainB);
		domainA.getEStructuralFeatures().add(aOwnsB);
		final EReference bOwnsB = newContainment("bOwnsB", domainB);
		domainB.getEStructuralFeatures().add(bOwnsB);
		final EReference bOwnsC = newContainment("bOwnsC", domainC);
		domainB.getEStructuralFeatures().add(bOwnsC);
		final EReference cOwnsC = newContainment("cOwnsC", domainC);
		domainC.getEStructuralFeatures().add(cOwnsC);
		final EReference bRefsC = newContainment("bRefsC", domainC);
		bRefsC.setContainment(false);
		domainB.getEStructuralFeatures().add(bRefsC);

		domainPack.getEClassifiers().add(domainA);
		domainPack.getEClassifiers().add(domainB);
		domainPack.getEClassifiers().add(domainC);

		myMap = GMFMapFactory.eINSTANCE.createMapping();
		CanvasMapping cme = GMFMapFactory.eINSTANCE.createCanvasMapping();
		cme.setDiagramCanvas(ddSource.getCanvasDef());
		cme.setDomainModel(domainPack);
		myMap.setDiagram(cme);

		myNodeA = GMFMapFactory.eINSTANCE.createNodeMapping();
		myNodeA.setDiagramNode(ddSource.getNodeDef());
		myNodeA.setDomainMetaElement(domainA);
		myNodeA.getChildren().add(newChildReference(aOwnsA, myNodeA, false));

		myNodeB = GMFMapFactory.eINSTANCE.createNodeMapping();
		myNodeB.setDiagramNode(ddSource.getNodeDef());
		myNodeB.setDomainMetaElement(domainB);
		
		NodeMapping bNodeFirstLevel = GMFMapFactory.eINSTANCE.createNodeMapping();
		bNodeFirstLevel.setDiagramNode(ddSource.getNodeDef());
		bNodeFirstLevel.setDomainMetaElement(domainB);

		// cycle to bFirstLevel itself
		bNodeFirstLevel.getChildren().add(newChildReference(bOwnsB, bNodeFirstLevel, false));

		// nodeB owns bFirstLevel
		myNodeB.getChildren().add(newChildReference(bOwnsB, bNodeFirstLevel, true));

		NodeMapping cNodeFirstLevel = GMFMapFactory.eINSTANCE.createNodeMapping();
		cNodeFirstLevel.setDiagramNode(ddSource.getNodeDef());
		cNodeFirstLevel.setDomainMetaElement(domainC);
		
		myNodeB.getChildren().add(newChildReference(bOwnsC, cNodeFirstLevel, true));
		
		// cycle, NodeC from second level reuses NodeC from first level, but with different containment feature
		cNodeFirstLevel.getChildren().add(newChildReference(cOwnsC, cNodeFirstLevel, false));

		// render some C child of B (namely, those references with bRefsC)
		// as separate children. There should be separate GenChildNode because
		// distinct childrenFeature is in use
		ChildReference dd = newChildReference(bOwnsC, cNodeFirstLevel, false);
		dd.setChildrenFeature(bRefsC);
		myNodeB.getChildren().add(dd);

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

	private ChildReference newChildReference(final EReference containmentRef, NodeMapping reusedNode, boolean own) {
		ChildReference childRef;
		childRef = GMFMapFactory.eINSTANCE.createChildReference();
		childRef.setContainmentFeature(containmentRef);
		if (own) {
			childRef.setOwnedChild(reusedNode);
		} else {
			childRef.setReferencedChild(reusedNode);
		}
		return childRef;
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
