/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.tr;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapDefWithReuseSetup;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class QvtGenModelTransformerSimpleTest extends AbstractMappingTransformerTest {
	private GenEditorGenerator transformationResult; 

	public QvtGenModelTransformerSimpleTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		transformationResult = executeQVT();
		assertNotNull(transformationResult);
	}
	
	protected GenEditorGenerator executeQVT() throws IOException {
		GenModel genModel = Utils.createGenModel(getCanvasMapping().getDomainModel());
		Mapping mapping = getMapping();
		
		ResourceSet resourceSet = genModel.eResource().getResourceSet();
		
		TransformationExecutor executor = new TransformationExecutor(URI.createURI("platform:/plugin/org.eclipse.gmf.bridge/transforms/Map2Gen.qvto"));
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("rcp", false);
		context.setConfigProperty("useMapMode", false);
		context.setConfigProperty("useFullRunTime", false);
		context.setConfigProperty("useInTransformationCodeGen", true);
		
		EList<EObject> mapObjects = new BasicEList<EObject>();
		mapObjects.add(mapping);
		ModelExtent inMap = new BasicModelExtent(mapObjects);
		EList<EObject> genObjects = new BasicEList<EObject>();
		genObjects.add(genModel);
		ModelExtent inGen = new BasicModelExtent(genObjects);
		Resource res = resourceSet.createResource(URI.createURI("platform:/plugin/org.eclipse.gmf.runtime.notation/model/notation.genmodel"));
		res.load(null);
		ModelExtent inNotation = new BasicModelExtent(res.getContents());
		
		ModelExtent output = new BasicModelExtent();
		
		ExecutionDiagnostic result = executor.execute(context, inMap, inGen, inNotation, output);
		if(result.getSeverity() == Diagnostic.OK) {
			
			List<EObject> outObjects = output.getContents();
			assertEquals(1, outObjects.size());
			assertTrue(outObjects.get(0) instanceof GenEditorGenerator);
			
			return (GenEditorGenerator) outObjects.get(0);
		}
		
		return null;
	}
	
	protected MapDefSource initMapModel(DiaDefSource graphDef) {
		return new MapDefWithReuseSetup().init(graphDef);
	}

	public void testNoReuseForTopLevelReference() {
		GenNode nodeA = getGenNodeA();

		final GenChildNode childA = nodeA.getChildNodes().get(0);
		// dumb check, although makes me believe DGMT set attributes
		// of the node that is actually a duplicate of top-level node
		assertEquals(nodeA.getDomainMetaClass(), childA.getDomainMetaClass());
		assertEquals(nodeA.getDiagramRunTimeClass(), childA.getDiagramRunTimeClass());
		assertTrue(childA.getChildNodes().contains(childA));
	}
	
	public void testReuseForChildReference() {
		GenNode nodeB = getGenNodeB();

		// B1 is child of Btop
		final GenChildNode bFirstLevelChild = nodeB.getChildNodes().get(0);
		final GenChildNode bSecondLevelChild = bFirstLevelChild.getChildNodes().get(0);
		assertFalse("B2 can't be the same as Btop", bFirstLevelChild == nodeB);
//		assertTrue("Actually, B2 should be the same as B1", bFirstLevelChild == bSecondLevelChild);
		assertTrue("B1 is child of B2 (and, of course, itself)", bSecondLevelChild.getChildNodes().contains(bFirstLevelChild));
	}

	public void testNoChildReferenceReuseWithDistinctContainments() {
		GenNode nodeB = getGenNodeB();

		final GenChildNode cFirstLevelChild = nodeB.getChildNodes().get(1); // note '1'
		final GenChildNode cSecondLevelChild = cFirstLevelChild.getChildNodes().get(0);
		assertFalse("C2 should not reuse C1 because of different containment", cSecondLevelChild.getChildNodes().contains(cFirstLevelChild));
		assertTrue("C2 IS a child of itself", cSecondLevelChild.getChildNodes().contains(cSecondLevelChild));
		
	}

	public void testNoChildReferenceReuseWithDistinctChildrenFeature() {
		GenNode nodeB = getGenNodeB();

		// this one has containment only
		final GenChildNode c1FirstLevelChild = nodeB.getChildNodes().get(1); // note '1'
		assertSame(c1FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c1FirstLevelChild.getModelFacet().getChildMetaFeature());

		// this one has same containment, but different childrenMetaFeature
		final GenChildNode c2FirstLevelChild = nodeB.getChildNodes().get(2); // note '2'
		assertNotSame(c2FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c2FirstLevelChild.getModelFacet().getChildMetaFeature());
		assertSame(c1FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c2FirstLevelChild.getModelFacet().getContainmentMetaFeature());

		assertFalse("Just [in]sanity check", c1FirstLevelChild == c2FirstLevelChild);
		final GenChildNode c2SecondLevelChild = c2FirstLevelChild.getChildNodes().get(0);
		assertFalse("Although we referenced c1 mapping, childrenFeature was different, hence distinct child", c2FirstLevelChild.getChildNodes().contains(c1FirstLevelChild));
		assertTrue("... with its own cycle to itself", c2SecondLevelChild.getChildNodes().contains(c2SecondLevelChild));
	}

	private GenNode getGenNodeA() {
		GenNode rv = findTopNode(getNodeDomainElement(0));
		assertNotNull(rv);
		return rv;
	}

	private GenNode getGenNodeB() {
		GenNode rv = findTopNode(getNodeDomainElement(1));
		assertNotNull(rv);
		return rv;
	}

	private EClass getNodeDomainElement(int idx) {
		return (getMapping().getNodes().get(idx)).getOwnedChild().getDomainMetaElement();
	}

	private GenNode findTopNode(EClass eClass) {
		for (GenTopLevelNode next : transformationResult.getDiagram().getTopLevelNodes()) {
			if (next.getDomainMetaClass().getEcoreClass() == eClass) {
				return next;
			}
		}
		return null;
	}
}
