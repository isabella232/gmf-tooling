package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gef.EditPolicy;

import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.EclipseconReferenceConnectionEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies.PresentersItemSemanticEditPolicy;

/**
 * @generated
 */
public class PresentersEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public PresentersEditPart(View view) {
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
				new PresentersItemSemanticEditPolicy());
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
		return new DotLineNoDecorations();
	}

	/**
	 * @generated
	 */
	public class DotLineNoDecorations extends
			org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public DotLineNoDecorations() {

			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_DOT);
		}

	}
}
