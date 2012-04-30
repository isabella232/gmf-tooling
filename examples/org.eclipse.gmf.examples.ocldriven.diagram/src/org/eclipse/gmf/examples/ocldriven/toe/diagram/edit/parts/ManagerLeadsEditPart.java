package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.LeadsProjectConnectionPinForeground4002Policy;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.LeadsProjectConnectionPinLineWidth4002Policy;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ManagerLeadsItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ManagerLeadsEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4002;

	/**
	* @generated
	*/
	public ManagerLeadsEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ManagerLeadsItemSemanticEditPolicy());
		installEditPolicy(LeadsProjectConnectionPinForeground4002Policy.KEY, new LeadsProjectConnectionPinForeground4002Policy());
		installEditPolicy(LeadsProjectConnectionPinLineWidth4002Policy.KEY, new LeadsProjectConnectionPinLineWidth4002Policy());
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
		return new LeadsProjectConnection();
	}

	/**
	* @generated
	*/
	public LeadsProjectConnection getPrimaryShape() {
		return (LeadsProjectConnection) getFigure();
	}

	/**
	 * @generated
	 */
	public class LeadsProjectConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public LeadsProjectConnection() {
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

}
