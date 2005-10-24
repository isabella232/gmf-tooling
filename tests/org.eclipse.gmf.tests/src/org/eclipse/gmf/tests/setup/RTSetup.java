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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;

/**
 * Simple implementation that creates simple diagram with few elements
 * @author artem
 */
public class RTSetup implements RTSource {

	private Diagram myCanvas;
	private Node myNode;
	private Edge myLink;

	public RTSetup() {
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public final RTSetup init(DiaGenSource genSource) {
		myCanvas = NotationFactory.eINSTANCE.createDiagram();
		myNode = NotationFactory.eINSTANCE.createNode();
		myLink = NotationFactory.eINSTANCE.createEdge();
		myCanvas.getPersistedChildren().add(myNode);
		myCanvas.getPersistedEdges().add(myLink);

		EObject diagramElement = createInstance(genSource.getGenDiagram().getDomainDiagramElement());
		myCanvas.setElement(diagramElement);
		EObject nodeElement = createInstance(genSource.getGenNode().getDomainMetaClass());
		myNode.setElement(nodeElement);
		//myNode.setVisualID(genSource.getGenNode().getVisualID());
		TypeLinkModelFacet mf = (TypeLinkModelFacet) genSource.getGenLink().getModelFacet();
		EObject linkElement = createInstance(mf.getMetaClass());
		myLink.setElement(linkElement);
		//myLink.setVisualID(genSource.getGenLink().getVisualID());

		/*
		Object nc = diagramElement.eGet(genSource.getGenNode().getContainmentMetaFeature().getEcoreFeature());
		assert nc instanceof EList;
		((EList) nc).add(nodeElement);
		Object lc = nodeElement.eGet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature());
		if (lc instanceof EList) {
			((EList) lc).add(linkElement);
		} else {
			nodeElement.eSet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature(), linkElement);
		}
		*/
		return this;
	}

	private EObject createInstance(GenClass genClass) {
		return createInstance(genClass.getEcoreClass());
	}

	private EObject createInstance(EClass eClass) {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	public final Diagram getCanvas() {
		return myCanvas;
	}

	public final Node getNode() {
		return myNode;
	}

	public Edge getLink() {
		return myLink;
	}

}
