package org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.policies.CommunicationItemSemanticEditPolicy;

/**
 * @generated
 */
public class CommunicationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public CommunicationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CommunicationItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	/**
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new CommunicationFigure();
	}

	/**
	 * @generated
	 */
	public CommunicationFigure getPrimaryShape() {
		return (CommunicationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class CommunicationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public CommunicationFigure() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		* @generated
		*/
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			PointList pl = new PointList();
			pl.addPoint(-5, 5);
			pl.addPoint(0, 0);
			pl.addPoint(-5, -5);
			df.setTemplate(pl);
			df.setScale(7, 3);
			return df;
		}

	}

}
