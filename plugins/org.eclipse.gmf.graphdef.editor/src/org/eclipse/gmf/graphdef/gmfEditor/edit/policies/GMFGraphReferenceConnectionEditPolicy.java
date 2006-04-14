package org.eclipse.gmf.graphdef.gmfEditor.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;

/**
 * @generated
 */
public class GMFGraphReferenceConnectionEditPolicy extends ConnectionEditPolicy {

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
