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
package org.eclipse.gmf.tests.tr;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference;
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorReferenceType;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.internal.codegen.util.GenModelGraphAnalyzer;

public class GenModelGraphAnalyzerTest extends TestCase {

	private static final String ECLASS_NAME_PREFIX = "EClass";

	private GenTopLevelNode myStartNode;

	private GenNodeLabel myStartNodeLabel;

	private GenCompartment myStartNodeCompartment;

	private GenDiagram myDiagram;

	private EPackage myDomainModelPackage;

	private GenPackage myDomainModelGenPackage;

	private int myClassCounter;

	private GenNavigator myNavigator;

	private GenNavigatorChildReference myNavigatorChildReference;

	protected void setUp() throws Exception {
		super.setUp();
		initGenModel();
		myClassCounter = 0;

		myDiagram = GMFGenFactory.eINSTANCE.createGenDiagram();
		GMFGenFactory.eINSTANCE.createGenEditorGenerator().setDiagram(myDiagram);
		myNavigator = GMFGenFactory.eINSTANCE.createGenNavigator();
		myDiagram.getEditorGen().setNavigator(myNavigator);
		myNavigatorChildReference = GMFGenFactory.eINSTANCE.createGenNavigatorChildReference();
		myNavigator.getChildReferences().add(myNavigatorChildReference);


		myStartNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		myStartNodeLabel = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		myStartNode.getLabels().add(myStartNodeLabel);
		myStartNodeCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		myStartNode.getCompartments().add(myStartNodeCompartment);
		initializeMF(myStartNode);
		myDiagram.getTopLevelNodes().add(myStartNode);
	}

	private void initGenModel() {
		myDomainModelPackage = EcoreFactory.eINSTANCE.createEPackage();
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		myDomainModelGenPackage = GenModelFactory.eINSTANCE.createGenPackage();
		genModel.getGenPackages().add(myDomainModelGenPackage);
		myDomainModelGenPackage.setEcorePackage(myDomainModelPackage);
	}

	private void initializeMF(GenNode node) {
		TypeModelFacet nodeMF = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		node.setModelFacet(nodeMF);
		nodeMF.setMetaClass(createGenClass());
	}

	private GenClass createGenClass() {
		GenClass genClass = GenModelFactory.eINSTANCE.createGenClass();
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(getUniqueEClassName());
		myDomainModelPackage.getEClassifiers().add(eClass);
		genClass.setEcoreClass(eClass);
		myDomainModelGenPackage.getGenClasses().add(genClass);
		return genClass;
	}

	private String getUniqueEClassName() {
		return ECLASS_NAME_PREFIX + (myClassCounter++);
	}

	public void testEmptyPaths() {
		GenChildNode notConnectedNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		myDiagram.getChildNodes().add(notConnectedNode);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.CHILDREN_LITERAL);
		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(notConnectedNode);

		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.IN_SOURCE_LITERAL);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.OUT_TARGET_LITERAL);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());
	}

	public void testDirectChildPaths() {
		GenChildNode directChildNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		myStartNode.getChildNodes().add(directChildNode);
		myDiagram.getChildNodes().add(directChildNode);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.CHILDREN_LITERAL);

		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(directChildNode);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, directChildNode });

		myNavigatorChildReference.setChild(myStartNodeLabel);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, myStartNodeLabel });

		myNavigatorChildReference.setChild(myStartNodeCompartment);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, myStartNodeCompartment });

		myNavigatorChildReference.setParent(myDiagram);
		myNavigatorChildReference.setChild(myStartNode);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myDiagram, myStartNode });
		
		GenLink link = GMFGenFactory.eINSTANCE.createGenLink();
		GenLinkLabel linkLabel = GMFGenFactory.eINSTANCE.createGenLinkLabel();
		link.getLabels().add(linkLabel);
		myDiagram.getLinks().add(link);
		
		myNavigatorChildReference.setChild(link);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myDiagram, link });

		myNavigatorChildReference.setParent(link);
		myNavigatorChildReference.setChild(linkLabel);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { link, linkLabel });
	}

	public void testDirectLinkPaths() {
		GenNode node = createGenNode();
		GenLink link = createGenLink(myStartNode, node);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.OUT_TARGET_LITERAL);

		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(link);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, link });

		myNavigatorChildReference.setParent(link);
		myNavigatorChildReference.setChild(node);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { link, node });

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.IN_SOURCE_LITERAL);
		myNavigatorChildReference.setParent(node);
		myNavigatorChildReference.setChild(link);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { node, link });

		myNavigatorChildReference.setParent(link);
		myNavigatorChildReference.setChild(myStartNode);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { link, myStartNode });
	}

	private GenNode createGenNode() {
		GenChildNode node = GMFGenFactory.eINSTANCE.createGenChildNode();
		myDiagram.getChildNodes().add(node);
		initializeMF(node);
		return node;
	}

	private GenLink createGenLink(GenNode source, GenNode target) {
		GenLink link = GMFGenFactory.eINSTANCE.createGenLink();
		myDiagram.getLinks().add(link);
		TypeLinkModelFacet linkMF = GMFGenFactory.eINSTANCE.createTypeLinkModelFacet();
		link.setModelFacet(linkMF);
		linkMF.setMetaClass(createGenClass());
		linkMF.setContainmentMetaFeature(createGenFeature(source.getDomainMetaClass(), linkMF.getMetaClass(), true));
		linkMF.setTargetMetaFeature(createGenFeature(linkMF.getMetaClass(), target.getDomainMetaClass(), false));
		return link;
	}

	private GenFeature createGenFeature(GenClass sourceGenClass, GenClass targetGenClass, boolean isContainment) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setContainment(isContainment);
		sourceGenClass.getEcoreClass().getEStructuralFeatures().add(eReference);
		eReference.setEType(targetGenClass.getEcoreClass());
		GenFeature genFeature = GenModelFactory.eINSTANCE.createGenFeature();
		genFeature.setEcoreFeature(eReference);
		sourceGenClass.getGenFeatures().add(genFeature);
		return genFeature;
	}

	public void testIndirectChildPaths() {
		GenChildNode indirectChildNode = createIndirectChildNode();
		GenCompartment indirectChildNodeCompartment = createIndirectChildNodeCompartment(indirectChildNode);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.CHILDREN_LITERAL);

		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(indirectChildNode);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, myStartNodeCompartment, indirectChildNode });

		myNavigatorChildReference.setParent(indirectChildNode);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { indirectChildNode, indirectChildNodeCompartment, indirectChildNode });
	}

	public void testIndirectLinkPaths() {
		GenNode node1 = createGenNode();
		GenLink link1 = createGenLink(myStartNode, node1);
		GenLink link2 = createGenLink(node1, node1);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.OUT_TARGET_LITERAL);

		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(node1);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, link1, node1 });

		myNavigatorChildReference.setParent(link1);
		myNavigatorChildReference.setChild(link2);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

		myNavigatorChildReference.setParent(node1);
		myNavigatorChildReference.setChild(node1);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { node1, link2, node1 });

		myNavigatorChildReference.setParent(link2);
		myNavigatorChildReference.setChild(link2);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.IN_SOURCE_LITERAL);
		myNavigatorChildReference.setParent(node1);
		myNavigatorChildReference.setChild(myStartNode);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { node1, link1, myStartNode });

		myNavigatorChildReference.setParent(link2);
		myNavigatorChildReference.setChild(link1);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

		myNavigatorChildReference.setParent(node1);
		myNavigatorChildReference.setChild(node1);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { node1, link2, node1 });

		myNavigatorChildReference.setParent(link2);
		myNavigatorChildReference.setChild(link2);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertEquals("No paths should be found", 0, paths.size());

	}

	private GenCompartment createIndirectChildNodeCompartment(GenChildNode indirectChildNode) {
		GenCompartment indirectChildNodeCompartment = GMFGenFactory.eINSTANCE.createGenCompartment();
		indirectChildNode.getCompartments().add(indirectChildNodeCompartment);
		indirectChildNodeCompartment.getChildNodes().add(indirectChildNode);
		return indirectChildNodeCompartment;
	}

	private GenChildNode createIndirectChildNode() {
		GenChildNode indirectChildNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		myStartNodeCompartment.getChildNodes().add(indirectChildNode);
		myDiagram.getChildNodes().add(indirectChildNode);
		return indirectChildNode;
	}

	public void testSeveralChildPaths() {
		GenChildNode indirectChildNode = createIndirectChildNode();
		GenCompartment indirectChildNodeCompartment = createIndirectChildNodeCompartment(indirectChildNode);
		GenChildNode doublePathChildNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		myDiagram.getChildNodes().add(doublePathChildNode);
		myStartNodeCompartment.getChildNodes().add(doublePathChildNode);
		indirectChildNodeCompartment.getChildNodes().add(doublePathChildNode);
		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.CHILDREN_LITERAL);

		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(doublePathChildNode);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		GenCommonBase[] truePath1 = new GenCommonBase[] { myStartNode, myStartNodeCompartment, doublePathChildNode };
		GenCommonBase[] truePath2 = new GenCommonBase[] { myStartNode, myStartNodeCompartment, indirectChildNode, indirectChildNodeCompartment, doublePathChildNode };
		assertTwoPaths(paths, truePath1, truePath2);
	}

	public void testOneLinkPathsUsed() {
		GenNode node1 = createGenNode();
		GenNode node2 = createGenNode();
		node1.getDomainMetaClass().getEcoreClass().getESuperTypes().add(node2.getDomainMetaClass().getEcoreClass());

		GenLink link1 = createGenLink(myStartNode, node2);
		createGenLink(node2, node1);

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.OUT_TARGET_LITERAL);

		// Check only one path returned - paths through 2 links should be
		// skipped
		myNavigatorChildReference.setParent(myStartNode);
		myNavigatorChildReference.setChild(node1);
		List<List<GenCommonBase>> paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { myStartNode, link1, node1 });

		myNavigatorChildReference.setReferenceType(GenNavigatorReferenceType.IN_SOURCE_LITERAL);
		myNavigatorChildReference.setParent(node1);
		myNavigatorChildReference.setChild(myStartNode);
		paths = GenModelGraphAnalyzer.getConnectionPaths(myNavigatorChildReference);
		assertOnePath(paths, new GenCommonBase[] { node1, link1, myStartNode });
	}

	private void assertOnePath(List<List<GenCommonBase>> paths, GenCommonBase[] truePath) {
		assertEquals("Only one path should be found", 1, paths.size());
		List<GenCommonBase> path = paths.get(0);
		assertEquals("Incorrect size path found", truePath.length, path.size());
		assertPath(path, truePath);
	}

	private void assertTwoPaths(List<List<GenCommonBase>> paths, GenCommonBase[] truePath1, GenCommonBase[] truePath2) {
		assertEquals("Incorrect number of paths returned", 2, paths.size());
		List<GenCommonBase> path1 = paths.get(0);
		List<GenCommonBase> path2 = paths.get(1);
		if (path1.size() == truePath1.length) {
			assertPath(path1, truePath1);
			assertPath(path2, truePath2);
		} else {
			assertPath(path1, truePath2);
			assertPath(path2, truePath1);
		}
	}

	private void assertPath(List<GenCommonBase> path, GenCommonBase[] truePath) {
		for (int i = 0; i < path.size(); i++) {
			assertEquals("Path contains incorrect element N " + i, truePath[i], path.get(i));
		}
	}

}
