package org.eclipse.gmf.example.lesscode.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.example.lesscode.diagram.edit.policies.OneContainmentGroupInGroupOneCanonicalEditPolicy;
import org.eclipse.gmf.example.lesscode.diagram.edit.policies.OneContainmentGroupInGroupOneItemSemanticEditPolicy;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.example.lesscode.diagram.part.Messages;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

/**
 * @generated
 */
public class OneContainmentGroupInGroupOneEditPart extends ShapeCompartmentEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 7003;

	/**
	* @generated
	*/
	public OneContainmentGroupInGroupOneEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	public String getCompartmentName() {
		return Messages.OneContainmentGroupInGroupOneEditPart_title;
	}

	/**
	* @generated
	*/
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OneContainmentGroupInGroupOneItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(LesscodeVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OneContainmentGroupInGroupOneCanonicalEditPolicy());
	}

	/**
	* @generated
	*/
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
