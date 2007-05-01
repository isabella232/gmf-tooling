/*
 * Copyright (c) 2006, 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.ecore.part.EcoreDiagramUpdater;
import org.eclipse.gmf.ecore.part.EcoreNodeDescriptor;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EEnumLiteralsCanonicalEditPolicy extends CanonicalEditPolicy {

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
		for (Iterator it = EcoreDiagramUpdater.getEEnumLiterals_7011SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((EcoreNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = EcoreVisualIDRegistry.getVisualID(view);
		return EcoreDiagramUpdater.isEEnumLiterals_7011DomainMetaChild(visualID)
				&& (!semanticChildren.contains(view.getElement()) || visualID != EcoreVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement()));
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
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEEnum_ELiterals());
		}
		return myFeaturesToSynchronize;
	}

}
