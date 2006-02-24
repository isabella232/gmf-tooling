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
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
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

	public void testHistoryTracking() {
		GenNode nodeA = getGenNodeA();
		assertNotNull(nodeA);
		GenNode nodeB = getGenNodeB();
		assertNotNull(nodeB);
		final GenChildNode childA = (GenChildNode) nodeA.getChildNodes().get(0);
		// dumb check, although makes me believe DGMT set attributes
		// of the node that is actually a duplicate of top-level node
		assertEquals(nodeA.getDomainMetaClass(), childA.getDomainMetaClass());
		assertEquals(nodeA.getDiagramRunTimeClass(), childA.getDiagramRunTimeClass());
		assertTrue(childA.getChildNodes().contains(childA));

		final GenChildNode bFirstLevelChild = (GenChildNode) nodeA.getChildNodes().get(0);
		final GenChildNode bSecondLevelChild = (GenChildNode) bFirstLevelChild.getChildNodes().get(0);
		assertTrue(bSecondLevelChild.getChildNodes().contains(bFirstLevelChild));
	}

	private GenNode getGenNodeA() {
		return findTopNode(getNodeDomainElement(0));
	}

	private GenNode getGenNodeB() {
		return findTopNode(getNodeDomainElement(1));
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
