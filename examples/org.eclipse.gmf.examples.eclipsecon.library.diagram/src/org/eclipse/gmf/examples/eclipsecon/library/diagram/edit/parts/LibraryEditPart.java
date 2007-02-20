package org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.parts;

import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.policies.LibraryCanonicalEditPolicy;
import org.eclipse.gmf.examples.eclipsecon.library.diagram.edit.policies.LibraryItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class LibraryEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Library07"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

	/**
	 * @generated
	 */
	public LibraryEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LibraryItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new LibraryCanonicalEditPolicy());
	}
}
