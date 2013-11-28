package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.ChildOfAffixedCreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
 * @generated
 */
public class ChildOfB_GAffixedChildrenCompartmentItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChildOfB_GAffixedChildrenCompartmentItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.ChildOfB_G_3004);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.ChildOfAffixed_3005 == req.getElementType()) {
			return getGEFWrapper(new ChildOfAffixedCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
