package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.policies.EPackageCanonicalEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EPackageItemSemanticEditPolicy;

/**
 * @generated
 */
public class EPackageEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public EPackageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EPackageItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EPackageCanonicalEditPolicy());
	}
}
