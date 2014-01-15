package org.eclipse.gmf.example.lesscode.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.example.lesscode.diagram.edit.policies.ElementBasedLinkItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ElementBasedLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public ElementBasedLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ElementBasedLinkItemSemanticEditPolicy());
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
		return new ElementBasedConnection();
	}

	/**
	 * @generated
	 */
	public ElementBasedConnection getPrimaryShape() {
		return (ElementBasedConnection) getFigure();
	}

	/**
	 * @generated
	 */
	public class ElementBasedConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ElementBasedConnection() {
			this.setForegroundColor(ColorConstants.red);

		}

	}

}
