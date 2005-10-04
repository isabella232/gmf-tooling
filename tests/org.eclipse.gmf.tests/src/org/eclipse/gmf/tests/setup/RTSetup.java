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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.diagramrt.DiagramCanvas;
import org.eclipse.gmf.diagramrt.DiagramLink;
import org.eclipse.gmf.diagramrt.DiagramNode;
import org.eclipse.gmf.diagramrt.DiagramRTFactory;

/**
 * Simple implementation that creates simple diagram with few elements
 * @author artem
 */
public class RTSetup implements RTSource {

	private DiagramCanvas myCanvas;
	private DiagramNode myNode;
	private DiagramLink myLink;

	public RTSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public final RTSetup init(DiaGenSource genSource) {
		myCanvas = DiagramRTFactory.eINSTANCE.createDiagramCanvas();
		myNode = DiagramRTFactory.eINSTANCE.createDiagramNode();
		myLink = DiagramRTFactory.eINSTANCE.createDiagramLink();
		myCanvas.getNodes().add(myNode);
		myCanvas.getLinks().add(myLink);

		EObject diagramElement = createInstance(genSource.getGenDiagram().getDomainDiagramElement());
		myCanvas.setDomainContainerObject(diagramElement);
		EObject nodeElement = createInstance(genSource.getGenNode().getDomainMetaClass());
		myNode.setDomainModelElement(nodeElement);
		myNode.setVisualID(genSource.getGenNode().getVisualID());
		EObject linkElement = createInstance(genSource.getGenLink().getDomainMetaClass());
		myLink.setDomainModelElement(linkElement);
		myLink.setVisualID(genSource.getGenLink().getVisualID());

		Object nc = diagramElement.eGet(genSource.getGenNode().getContainmentMetaFeature().getEcoreFeature());
		assert nc instanceof EList;
		((EList) nc).add(nodeElement);
		Object lc = nodeElement.eGet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature());
		if (lc instanceof EList) {
			((EList) lc).add(linkElement);
		} else {
			nodeElement.eSet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature(), linkElement);
		}
		return this;
	}

	private EObject createInstance(GenClass genClass) {
		return createInstance(genClass.getEcoreClass());
	}

	private EObject createInstance(EClass eClass) {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	public final DiagramCanvas getCanvas() {
		return myCanvas;
	}

	public final DiagramNode getNode() {
		return myNode;
	}

	public DiagramLink getLink() {
		return myLink;
	}

}
