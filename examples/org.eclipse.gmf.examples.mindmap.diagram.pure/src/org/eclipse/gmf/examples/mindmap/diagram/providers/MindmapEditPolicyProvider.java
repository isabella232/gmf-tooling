package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.policies.TopicSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

public class MindmapEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof TopicEditPart) {
			editPart.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new TopicSemanticEditPolicy());
		}
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation op = (CreateEditPoliciesOperation) operation;
			if (op.getEditPart() instanceof TopicEditPart) {
				return true;
			}
		}
		return false;
	}
}
