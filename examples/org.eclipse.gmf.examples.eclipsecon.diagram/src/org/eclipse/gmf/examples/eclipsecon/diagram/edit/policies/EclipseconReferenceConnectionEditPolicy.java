package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;

/**
 * @generated
 */
public class EclipseconReferenceConnectionEditPolicy extends
		ConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected boolean shouldDeleteSemantic() {
		return false;
	};

	/**
	 * @generated
	 */
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(super.createDeleteViewCommand(deleteRequest));
		cmd.add(createDeleteSemanticCommand(deleteRequest));
		return cmd;
	}
}
