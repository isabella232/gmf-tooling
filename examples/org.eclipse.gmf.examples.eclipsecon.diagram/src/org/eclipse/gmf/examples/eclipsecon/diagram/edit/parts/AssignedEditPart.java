package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.AssignedItemSemanticEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.EclipseconReferenceConnectionEditPolicy;

/**
 * @generated
 */
public class AssignedEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public AssignedEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new EclipseconReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssignedItemSemanticEditPolicy());
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
		return new DashLineNoDecorations();
	}

	/**
	 * @generated
	 */
	public class DashLineNoDecorations extends
			org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public DashLineNoDecorations() {

			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_DASH);
			setSourceDecoration(createSourceDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolygonDecoration createSourceDecoration() {
			org.eclipse.draw2d.PolygonDecoration df = new org.eclipse.draw2d.PolygonDecoration();
			// dispatchNext?
			df.setFill(true);
			df.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(1, 0);
			pl.addPoint(1, 1);
			pl.addPoint(0, 1);
			pl.addPoint(0, 0);
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));

			return df;
		}

	}
}
