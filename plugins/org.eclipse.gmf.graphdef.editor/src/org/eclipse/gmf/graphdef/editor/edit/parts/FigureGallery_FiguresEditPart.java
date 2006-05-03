package org.eclipse.gmf.graphdef.editor.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.graphdef.editor.edit.policies.FigureGallery_FiguresCanonicalEditPolicy;
import org.eclipse.gmf.graphdef.editor.edit.policies.FigureGallery_FiguresItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;

/**
 * @generated
 */
public class FigureGallery_FiguresEditPart extends ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5004;

	/**
	 * @generated
	 */
	public FigureGallery_FiguresEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected String getTitleName() {
		return "Figures";
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FigureGallery_FiguresItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new FigureGallery_FiguresCanonicalEditPolicy());
	}
}
