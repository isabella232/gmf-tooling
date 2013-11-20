package org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.DiagramCanonicalEditPolicy;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.policies.DiagramItemSemanticEditPolicy;
import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

/**
 * @generated
 */
public class DiagramEditPart extends org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Pins"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public DiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DiagramCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(PinsVisualIDRegistry.TYPED_INSTANCE));
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
