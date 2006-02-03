package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.ecore.edit.policies.EAnnotation4ItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EAnnotation4EditPart extends ListItemEditPart {

	/**
	 * @generated
	 */
	public EAnnotation4EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EAnnotation4ItemSemanticEditPolicy());
	}

}
