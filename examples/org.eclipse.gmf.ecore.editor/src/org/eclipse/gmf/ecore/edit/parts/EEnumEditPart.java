package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.ecore.edit.policies.EEnumItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EEnumEditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public EEnumEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EEnumItemSemanticEditPolicy());
	}

}
