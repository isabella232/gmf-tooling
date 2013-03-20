package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ContributionConnectionPinForeground4003Policy;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.ContributionItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ContributionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4003;

	/**
	* @generated
	*/
	public ContributionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ContributionItemSemanticEditPolicy());
		installEditPolicy(ContributionConnectionPinForeground4003Policy.KEY, new ContributionConnectionPinForeground4003Policy());
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
		return new ContributionConnection();
	}

	/**
	* @generated
	*/
	public ContributionConnection getPrimaryShape() {
		return (ContributionConnection) getFigure();
	}

	/**
	 * @generated
	 */
	public class ContributionConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ContributionConnection() {

		}

	}

}
