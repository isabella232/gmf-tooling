package org.eclipse.gmf.ecore.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.ecore.edit.policies.ESuperTypesItemSemanticEditPolicy;
import org.eclipse.gmf.ecore.edit.policies.EcoreReferenceConnectionEditPolicy;

/**
 * @generated
 */
public class ESuperTypesEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static String VISUAL_ID = "3004";

	/**
	 * @generated
	 */
	public ESuperTypesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new EcoreReferenceConnectionEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ESuperTypesItemSemanticEditPolicy());
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
		return new SolidLineWDstClosedArrow();
	}

	/**
	 * @generated
	 */
	public class SolidLineWDstClosedArrow extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SolidLineWDstClosedArrow() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.PolygonDecoration createTargetDecoration() {
			org.eclipse.draw2d.PolygonDecoration df = new org.eclipse.draw2d.PolygonDecoration();
			// dispatchNext?

			df.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(0, 0);
			pl.addPoint(-2, 2);
			pl.addPoint(-2, -2);
			pl.addPoint(0, 0);
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));

			return df;
		}
	}
}
