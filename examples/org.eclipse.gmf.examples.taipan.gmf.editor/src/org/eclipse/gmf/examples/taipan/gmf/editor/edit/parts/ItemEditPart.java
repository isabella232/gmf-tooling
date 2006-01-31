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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.ItemItemSemanticEditPolicy;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanStructuralFeaturesParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;

/**
 * @generated
 */
public class ItemEditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public ItemEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ItemItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			List features = new ArrayList(2);
			features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("article"));
			features.add(TaiPanPackage.eINSTANCE.getItem().getEStructuralFeature("quantity"));
			parser = new TaiPanStructuralFeaturesParser(features);
			((TaiPanStructuralFeaturesParser) parser).setViewPattern("- {0} [{1,number,integer}]");
			((TaiPanStructuralFeaturesParser) parser).setEditPattern("{0}:{1,number,integer}");
		}
		return parser;
	}
}
