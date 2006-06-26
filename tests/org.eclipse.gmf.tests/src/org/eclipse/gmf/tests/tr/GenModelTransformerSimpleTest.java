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
package org.eclipse.gmf.tests.tr;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediator;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapDefWithReuseSetup;

/**
 * @author artem
 */
public class GenModelTransformerSimpleTest extends AbstractMappingTransformerTest {
	private GenEditorGenerator transformationResult; 

	public GenModelTransformerSimpleTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(new BasicDiagramRunTimeModelHelper(), new GenModelNamingMediator.Empty());
		t.setEMFGenModel(Utils.createGenModel(getCanvasMapping().getDomainModel(), Utils.createUniquePluginID()));
		t.transform(getMapping());
		transformationResult = t.getResult();
		assertNotNull(transformationResult);
	}

	protected MapDefSource initMapModel(DiaDefSource graphDef) {
		return new MapDefWithReuseSetup().init(graphDef);
	}

	public void testNoReuseForTopLevelReference() {
		GenNode nodeA = getGenNodeA();

		final GenChildNode childA = (GenChildNode) nodeA.getChildNodes().get(0);
		// dumb check, although makes me believe DGMT set attributes
		// of the node that is actually a duplicate of top-level node
		assertEquals(nodeA.getDomainMetaClass(), childA.getDomainMetaClass());
		assertEquals(nodeA.getDiagramRunTimeClass(), childA.getDiagramRunTimeClass());
		assertTrue(childA.getChildNodes().contains(childA));
	}
	
	public void testReuseForChildReference() {
		GenNode nodeB = getGenNodeB();

		// B1 is child of Btop
		final GenChildNode bFirstLevelChild = (GenChildNode) nodeB.getChildNodes().get(0);
		final GenChildNode bSecondLevelChild = (GenChildNode) bFirstLevelChild.getChildNodes().get(0);
		assertFalse("B2 can't be the same as Btop", bFirstLevelChild == nodeB);
		assertTrue("Actually, B2 should be the same as B1", bFirstLevelChild == bSecondLevelChild);
		assertTrue("B1 is child of B2 (and, of course, itself)", bSecondLevelChild.getChildNodes().contains(bFirstLevelChild));
	}

	public void testNoChildReferenceReuseWithDistinctContainments() {
		GenNode nodeB = getGenNodeB();

		final GenChildNode cFirstLevelChild = (GenChildNode) nodeB.getChildNodes().get(1); // note '1'
		final GenChildNode cSecondLevelChild = (GenChildNode) cFirstLevelChild.getChildNodes().get(0);
		assertFalse("C2 should not reuse C1 because of different containment", cSecondLevelChild.getChildNodes().contains(cFirstLevelChild));
		assertTrue("C2 IS a child of itself", cSecondLevelChild.getChildNodes().contains(cSecondLevelChild));
		
	}

	public void testNoChildReferenceReuseWithDistinctChildrenFeature() {
		GenNode nodeB = getGenNodeB();

		// this one has containment only
		final GenChildNode c1FirstLevelChild = (GenChildNode) nodeB.getChildNodes().get(1); // note '1'
		assertSame(c1FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c1FirstLevelChild.getModelFacet().getChildMetaFeature());

		// this one has same containment, but different childrenMetaFeature
		final GenChildNode c2FirstLevelChild = (GenChildNode) nodeB.getChildNodes().get(2); // note '2'
		assertNotSame(c2FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c2FirstLevelChild.getModelFacet().getChildMetaFeature());
		assertSame(c1FirstLevelChild.getModelFacet().getContainmentMetaFeature(), c2FirstLevelChild.getModelFacet().getContainmentMetaFeature());

		assertFalse("Just [in]sanity check", c1FirstLevelChild == c2FirstLevelChild);
		final GenChildNode c2SecondLevelChild = (GenChildNode) c2FirstLevelChild.getChildNodes().get(0);
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
		return ((TopNodeReference) getMapping().getNodes().get(idx)).getOwnedChild().getDomainMetaElement();
	}

	private GenNode findTopNode(EClass eClass) {
		for (Iterator it = transformationResult.getDiagram().getTopLevelNodes().iterator(); it.hasNext();) {
			GenTopLevelNode next = (GenTopLevelNode) it.next();
			if (next.getDomainMetaClass().getEcoreClass() == eClass) {
				return next;
			}
		}
		return null;
	}
}
