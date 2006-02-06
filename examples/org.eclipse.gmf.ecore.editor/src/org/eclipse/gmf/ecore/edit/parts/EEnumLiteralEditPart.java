package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.policies.EEnumLiteralItemSemanticEditPolicy;

/**
 * @generated
 */
public class EEnumLiteralEditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public EEnumLiteralEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EEnumLiteralItemSemanticEditPolicy());
	}

}
