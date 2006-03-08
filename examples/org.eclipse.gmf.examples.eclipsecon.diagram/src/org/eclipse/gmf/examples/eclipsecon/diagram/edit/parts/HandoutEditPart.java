package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.HandoutItemSemanticEditPolicy;

/**
 * @generated
 */
public class HandoutEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public HandoutEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new HandoutItemSemanticEditPolicy());
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
		return new SolidLineSquareDec();
	}

	/**
	 * @generated
	 */
	public class SolidLineSquareDec extends
			org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SolidLineSquareDec() {

			setSourceDecoration(createSourceDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolygonDecoration createSourceDecoration() {
			org.eclipse.draw2d.PolygonDecoration df = new org.eclipse.draw2d.PolygonDecoration();
			// dispatchNext?
			df.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(0, 1);
			pl.addPoint(-1, -1);
			pl.addPoint(-1, 0);
			pl.addPoint(0, 0);
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));

			return df;
		}

	}
}
