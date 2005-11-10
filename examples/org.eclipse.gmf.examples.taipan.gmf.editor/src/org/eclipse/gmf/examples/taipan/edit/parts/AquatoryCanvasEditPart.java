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
package org.eclipse.gmf.examples.taipan.edit.parts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Aquatory;

import org.eclipse.gmf.examples.taipan.edit.policies.AquatoryDiagramItemSemanticEditPolicy;

import org.eclipse.gmf.examples.taipan.editor.VisualIDRegistry;

/**
 * @generated
 */
public class AquatoryCanvasEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public AquatoryCanvasEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AquatoryDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new AquatoryCanvasEditPartCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	private class AquatoryCanvasEditPartCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

		/**
		 * @generated
		 */
		protected List getSemanticChildrenList() {
			Aquatory modelElement = (Aquatory) ((View) getHost().getModel()).getElement();
			List result = new LinkedList();
			result.addAll(modelElement.getPorts());
			result.addAll(modelElement.getShips());
			return result;
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
					if (VisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {
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
			int vID = VisualIDRegistry.INSTANCE.getLinkWithClassVisualID(relationship);
			switch (vID) {
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
		protected boolean shouldIncludeConnection(Edge connector, List children) {
			return super.shouldIncludeConnection(connector, children) && connector.getElement() != null;
		}

	}

}
