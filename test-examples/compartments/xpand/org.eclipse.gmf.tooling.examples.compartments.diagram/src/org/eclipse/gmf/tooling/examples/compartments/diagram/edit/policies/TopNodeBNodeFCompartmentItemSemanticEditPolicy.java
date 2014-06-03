package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.ChildOfB_FCreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
 * @generated
 */
public class TopNodeBNodeFCompartmentItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TopNodeBNodeFCompartmentItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.TopNodeB_2002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.ChildOfB_F_3006 == req.getElementType()) {
			return getGEFWrapper(new ChildOfB_FCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
