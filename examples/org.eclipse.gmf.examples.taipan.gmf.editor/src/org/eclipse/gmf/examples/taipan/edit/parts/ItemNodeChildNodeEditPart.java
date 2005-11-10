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

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.providers.StructuralFeatureParser;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.edit.policies.ItemChildNodeItemSemanticEditPolicy;

/**
 * @generated
 */
public class ItemNodeChildNodeEditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public ItemNodeChildNodeEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = new StructuralFeatureParser(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ItemChildNodeItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ItemNodeChildNodeEditPartCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	private class ItemNodeChildNodeEditPartCanonicalEditPolicy extends CanonicalEditPolicy {

		/**
		 * @generated
		 */
		protected List getSemanticChildrenList() {
			return Collections.EMPTY_LIST;
		}

	}

}
