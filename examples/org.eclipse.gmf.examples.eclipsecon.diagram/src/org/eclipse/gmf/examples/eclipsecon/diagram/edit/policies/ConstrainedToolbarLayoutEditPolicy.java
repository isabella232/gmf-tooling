package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.TextSelectionEditPolicy;

/**
 * @generated
 */
public class ConstrainedToolbarLayoutEditPolicy
		extends
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy {

	/**
	 * @generated
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ITextAwareEditPart)
				return new TextSelectionEditPolicy();
		}
		return super.createChildEditPolicy(child);
	}
}
