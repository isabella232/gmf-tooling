/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.tr;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.TopNodeReference;
import org.eclipse.gmf.tests.ConfiguredTestCase;

public class QvtGenModelTransformerVisualIDWithTraceTest extends ConfiguredTestCase {

	public QvtGenModelTransformerVisualIDWithTraceTest(String name) {
		super(name);
	}
	
//	@Override
//	protected Mapping loadMapping() {
//		Mapping mapping = GMFMapFactory.eINSTANCE.createMapping();
//		CanvasMapping cmap = GMFMapFactory.eINSTANCE.createCanvasMapping();
//		cmap.setDiagramCanvas(getCanvas());
//		mapping.setDiagram(cmap);
//		
//		EPackage ePackage = getGenModel().getGenPackages().get(0).getEcorePackage();
//		EClass container = (EClass) ePackage.getEClassifier("UltimateContainer");
//		EReference containment = (EReference) container.getEStructuralFeature("all");
//		EClass srcA = (EClass) ePackage.getEClassifier("NodeSrcA");
//		cmap.setDomainMetaElement(container);
//		cmap.setDomainModel(ePackage);
//		
//		TopNodeReference top1 = GMFMapFactory.eINSTANCE.createTopNodeReference();
//		top1.setContainmentFeature(containment);
//		
//		NodeMapping nmap = GMFMapFactory.eINSTANCE.createNodeMapping();
//		nmap.setDomainMetaElement(srcA);
//		nmap.setDiagramNode(getCanvas().getNodes().get(0));
//		top1.setOwnedChild(nmap);
//		
//		mapping.getNodes().add(top1);
//		
//		return mapping;
//	}
	
//	protected TopNodeReference createTopNode(String name) {
//		TopNodeReference existing = getMapping().getNodes().get(0);
//		EPackage ePackage = existing.getOwnedChild().getDomainMetaElement().getEPackage();
//		EClass eClass = (EClass) ePackage.getEClassifier(name);
//		
//		TopNodeReference node = GMFMapFactory.eINSTANCE.createTopNodeReference();
//		node.setContainmentFeature(existing.getContainmentFeature());
//		
//		NodeMapping nmap = GMFMapFactory.eINSTANCE.createNodeMapping();
//		nmap.setDomainMetaElement(eClass);
//		nmap.setDiagramNode(existing.getChild().getDiagramNode());
//		node.setOwnedChild(nmap);
//		
//		return node;
//	}
//	
//	public void testVisualIDWithNoTrace() {
//		Transformation java = getJavaTransformation(false);
//		Transformation qvt = getQvtTransformation(false);
//		
//		GenEditorGenerator expected = java.execute();
//		GenEditorGenerator actual = qvt.execute();
//		
//		EList<GenTopLevelNode> expNodes = expected.getDiagram().getTopLevelNodes();
//		EList<GenTopLevelNode> actNodes = actual.getDiagram().getTopLevelNodes();
//		
//		assertEquals(1, expNodes.size());
//		assertEquals(expNodes.size(), actNodes.size());
//		
//		assertEquals(2001, expNodes.get(0).getVisualID());
//		
//		for (int i=0;i<expNodes.size();i++){
//			GenTopLevelNode expNode = expNodes.get(i);
//			GenTopLevelNode actNode = actNodes.get(i);
//			
//			assertEquals(expNode.getVisualID(), actNode.getVisualID());
//		}
//		
//		java.saveGenEditor("java");
//		java.getDispencer().saveState();
//		
//		qvt.getDispencer().saveState();
//		qvt.saveGenEditor("qvt");
//		
//		TopNodeReference node = createTopNode("NodeTargetB");
//		getMapping().getNodes().add(node);
//		
//		expected = java.execute();
//		actual = qvt.execute();
//		
//		expNodes = expected.getDiagram().getTopLevelNodes();
//		actNodes = actual.getDiagram().getTopLevelNodes();
//		
//		assertEquals(2, expNodes.size());
//		assertEquals(expNodes.size(), actNodes.size());
//		
//		assertEquals(2001, expNodes.get(0).getVisualID());
//		assertEquals(2002, expNodes.get(1).getVisualID());
//		
//		for (int i=0;i<expNodes.size();i++){
//			GenTopLevelNode expNode = expNodes.get(i);
//			GenTopLevelNode actNode = actNodes.get(i);
//			
//			assertEquals(expNode.getVisualID(), actNode.getVisualID());
//		}
//		
//		node = createTopNode("NodeTargetC");
//		getMapping().getNodes().add(0, node);
//		
//		java.saveGenEditor("java");
//		java.getDispencer().saveState();
//		
//		qvt.saveGenEditor("qvt");
//		qvt.getDispencer().saveState();
//		
//		expected = java.execute();
//		actual = qvt.execute();
//		
//		expNodes = expected.getDiagram().getTopLevelNodes();
//		actNodes = actual.getDiagram().getTopLevelNodes();
//		
//		assertEquals(3, expNodes.size());
//		assertEquals(expNodes.size(), actNodes.size());
//		
//		assertEquals(2003, expNodes.get(0).getVisualID());
//		assertEquals(2001, expNodes.get(1).getVisualID());
//		assertEquals(2002, expNodes.get(2).getVisualID());
//		
//		for (int i=0;i<expNodes.size();i++){
//			GenTopLevelNode expNode = expNodes.get(i);
//			GenTopLevelNode actNode = actNodes.get(i);
//			
//			assertEquals(expNode.getVisualID(), actNode.getVisualID());
//		}
//		
//		java.saveGenEditor("java");
//		java.getDispencer().saveState();
//		
//		qvt.saveGenEditor("qvt");
//		qvt.getDispencer().saveState();
//	}
	
}
