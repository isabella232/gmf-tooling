package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ConferenceCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.ConferenceItemSemanticEditPolicy;

/**
 * @generated
 */
public class ConferenceEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public ConferenceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ConferenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ConferenceCanonicalEditPolicy());
	}
}
