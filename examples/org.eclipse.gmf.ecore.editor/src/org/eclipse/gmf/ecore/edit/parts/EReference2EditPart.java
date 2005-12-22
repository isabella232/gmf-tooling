package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.Shape;

import org.eclipse.gmf.ecore.edit.policies.EReference2ItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * @generated
 */
public class EReference2EditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public EReference2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EReference2ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected PolylineConnection createConnectionShape() {
		return new PolylineConnectionEx();
	}

	/**
	 * @generated
	 */
	protected void decorateConnectionShape(PolylineConnection shape) {

		shape.setLineStyle(Graphics.LINE_SOLID);
		shape.setLineWidth(1);
		RotatableDecoration sourceDecoration = createSourceDecoration();
		if (sourceDecoration != null) {
			shape.setSourceDecoration(sourceDecoration);
			if (sourceDecoration instanceof Shape) {
				((Shape) sourceDecoration).setLineWidth(shape.getLineWidth());
			}
		}
		RotatableDecoration targetDecoration = createTargetDecoration();
		if (targetDecoration != null) {
			shape.setTargetDecoration(targetDecoration);
			if (targetDecoration instanceof Shape) {
				((Shape) targetDecoration).setLineWidth(shape.getLineWidth());
			}
		}
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		PolylineConnection shape = createConnectionShape();
		decorateConnectionShape(shape);
		return shape;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createSourceDecoration() {

		PolylineDecoration decoration = new PolylineDecoration();
		decoration.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
		return decoration;
	}

	/**
	 * @generated
	 */
	protected RotatableDecoration createTargetDecoration() {

		return null;
	}
}
