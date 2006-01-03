/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;

import org.eclipse.gmf.examples.taipan.Route;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class AquatoryCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		Aquatory modelElement = (Aquatory) ((View) getHost().getModel()).getElement();
		List result = new LinkedList();
		EObject nextValue;
		int nodeVID;
		for (Iterator it = modelElement.getPorts().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1001 == nodeVID) {
				result.add(nextValue);
			}
		}
		for (Iterator it = modelElement.getShips().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (1002 == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.getElement() != ((View) getHost().getModel()).getElement() && super.shouldDeleteView(view);
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		Diagram diagram = (Diagram) getHost().getModel();
		Aquatory modelElement = (Aquatory) diagram.getElement();
		List result = new LinkedList();
		for (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements.hasNext();) {
			EObject nextDiagramElement = (EObject) diagramElements.next();
			for (Iterator childElements = nextDiagramElement.eContents().iterator(); childElements.hasNext();) {
				EObject nextChild = (EObject) childElements.next();
				if (TaiPanVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {
					result.add(nextChild);
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return relationship.eContainer();
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		int vID = TaiPanVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(relationship);
		switch (vID) {
		case 3002:
			return ((Route) relationship).getDestination();
		}
		return null;
	}

	/**
	 * For now we are skipping links which was generated based on "GenLinkReferenceOnly" classes
	 * since they do not handle any domain model objects inside, so we can not process them using
	 * CanonicalConnectionEditPolicy class
	 *
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return super.shouldIncludeConnection(connector, children) && connector.getElement() != null;
	}
}
