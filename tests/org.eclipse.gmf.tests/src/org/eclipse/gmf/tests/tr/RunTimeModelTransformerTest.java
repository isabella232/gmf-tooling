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
package org.eclipse.gmf.tests.tr;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.gmfgraph.Node;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelTransformer;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.tests.setup.DiaDefSetup;

public class RunTimeModelTransformerTest extends AbstractMappingTransformerTest {
	public RunTimeModelTransformerTest(String name) {
		super(name);
	}
	
	protected DiaDefSetup createDiaDefSetup() {
		return new DiaDefSetup(){
			protected void setupNodeDef(Node nodeDef) {
				super.setupNodeDef(nodeDef);
//				RunTimeProperty rtp = DiagramDefinitionFactory.eINSTANCE.createRunTimeProperty();
//				rtp.setName("someProp");
//				nodeDef.getProperties().add(rtp);
//				rtp = DiagramDefinitionFactory.eINSTANCE.createRunTimeProperty();
//				rtp.setName("prop1");
//				nodeDef.getProperties().add(rtp);
			}
		};
	}

	public void testRunTimeModelTransform() {
		DiagramRunTimeModelTransformer drtModelTransformer = new DiagramRunTimeModelTransformer("pack11", "uri://eclipse/gmf/tests");
		assertNotNull("Mapping is initialized", getMapping());
		drtModelTransformer.transform(getMapping());
		EPackage drtModel = drtModelTransformer.getResult();
		// make sure there's class for canvas, node and link and that they extend appropriate class from basicDRT
		EClass c = findEClass(drtModel, getCanvasDef().getName());
		assertNotNull("There's no rt model class for canvas definition", c);
		assertTrue("rt model class for canvas definition should extend appropiate class from basic RT model", checkSuperclass(c, NotationPackage.eINSTANCE.getDiagram()));

		c = findEClass(drtModel, getNodeDef().getName());
		assertNotNull("There's no rt model class for node definition", c);
		assertTrue("rt model class for node definition should extend appropiate class from basic RT model", checkSuperclass(c, NotationPackage.eINSTANCE.getNode()));
		doTestRunTimeModelPropertiesTransform(c);

		c = findEClass(drtModel, getLinkDef().getName());
		assertNotNull("There's no rt model class for link definition", c);
		assertTrue("rt model class for link definition should extend appropiate class from basic RT model", checkSuperclass(c, NotationPackage.eINSTANCE.getEdge()));
	}

	private void doTestRunTimeModelPropertiesTransform(EClass nodeRTClass) {
		EStructuralFeature sf = nodeRTClass.getEStructuralFeature("prop1");
		assertNotNull("There should be 'prop1' structural feature in generated diagramNode EClass", sf);
		assertTrue("StructuralFeature 'prop1' should be attribute", sf instanceof EAttribute);
		org.eclipse.gmf.runtime.notation.Node rtInstance = (org.eclipse.gmf.runtime.notation.Node) nodeRTClass.getEPackage().getEFactoryInstance().create(nodeRTClass);
		rtInstance.eSet(sf, "abc");
		assertEquals("Not possible to access rtProperty in EMF way", rtInstance.eGet(sf), "abc");
		fail("Fix runtime properties in new runtime/notation model");
//		assertEquals("Not possible to get rtProperty using our 'generic' API", rtInstance.getProperty("prop1"), "abc");
//		assertFalse("[TENTATIVE] Specific RT should not use runTimeProperties", rtInstance.getRunTimeProperties().contains("prop1"));

		// FIXME make sure properties are persisted

//		assertNull(rtInstance.getProperty("prop3"));
//		assertNull(rtInstance.getRunTimeProperties().get("prop1"));
//		assertFalse(rtInstance.getRunTimeProperties().contains("prop3"));
	}

	private static EClass findEClass(EPackage model, String name) {
		for (TreeIterator<EObject> it = model.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			if (next instanceof EClassifier) {
				if (name.equals(((EClassifier) next).getName()) && next instanceof EClass) {
					return (EClass) next;
				}
				it.prune();
			}
		}
		return null;
	}

	private static boolean checkSuperclass(EClass eClass, EClass eSuperClass) {
		return eSuperClass.isSuperTypeOf(eClass) || EcoreUtil.equals(eClass, eSuperClass);
	}
}
