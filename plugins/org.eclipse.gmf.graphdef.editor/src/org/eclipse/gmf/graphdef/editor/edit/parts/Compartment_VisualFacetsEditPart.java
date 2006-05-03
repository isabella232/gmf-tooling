package org.eclipse.gmf.graphdef.editor.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.gmf.graphdef.editor.edit.policies.Compartment_VisualFacetsItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;

/**
 * @generated
 */
public class Compartment_VisualFacetsEditPart extends ListCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5001;

	/**
	 * @generated
	 */
	public Compartment_VisualFacetsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return "VisualFacets";
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Compartment_VisualFacetsItemSemanticEditPolicy());
	}
}
