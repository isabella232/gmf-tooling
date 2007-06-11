package org.eclipse.gmf.examples.mindmap.lite.rcp.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.ResourceEditPart;
import org.eclipse.gmf.runtime.lite.edit.policies.ListLayoutEditPolicy;

/**
 * @generated
 */
public class ResourceLayoutEditPolicy extends ListLayoutEditPolicy {
	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EditPolicy createChildEditPolicy(EditPart child) {
		EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (result != null) {
			return result;
		}
		if (((ResourceEditPart) getHost()).isExternalLabel(child)) {
			return new ResizableEditPolicy() {
				public EditPart getTargetEditPart(Request request) {
					if (RequestConstants.REQ_SELECTION
							.equals(request.getType())) {
						return ResourceLayoutEditPolicy.this.getHost();
					}
					return super.getTargetEditPart(request);
				}
			};
		}
		return super.createChildEditPolicy(child);
	}
}
