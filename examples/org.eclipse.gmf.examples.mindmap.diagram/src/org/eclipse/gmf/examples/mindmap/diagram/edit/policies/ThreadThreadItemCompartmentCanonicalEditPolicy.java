/*
 *
 * Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Richard Gronback (Borland) - initial API and implementation
 
 */
package org.eclipse.gmf.examples.mindmap.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Set;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Thread;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.ThreadItemEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramUpdater;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapNodeDescriptor;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

/**
 * @generated
 */
public class ThreadThreadItemCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = MindmapDiagramUpdater
				.getThreadThreadItemCompartment_7002SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((MindmapNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = MindmapVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ThreadItemEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement())
					|| visualID != MindmapVisualIDRegistry.getNodeVisualID(
							(View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(MindmapPackage.eINSTANCE
					.getThread_Items());
		}
		return myFeaturesToSynchronize;
	}

}
