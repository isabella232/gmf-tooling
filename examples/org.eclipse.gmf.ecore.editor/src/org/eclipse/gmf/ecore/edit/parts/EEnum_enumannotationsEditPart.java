package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.ScrollPane;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.gmf.ecore.edit.policies.EEnum_enumannotationsCanonicalEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EEnum_enumannotationsItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ListScrollBar;

import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * @generated
 */
public class EEnum_enumannotationsEditPart extends ListCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5012;

	/**
	 * @generated
	 */
	public EEnum_enumannotationsEditPart(View view) {
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
		return "enum annotations";
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EEnum_enumannotationsItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EEnum_enumannotationsCanonicalEditPolicy());
	}
}
