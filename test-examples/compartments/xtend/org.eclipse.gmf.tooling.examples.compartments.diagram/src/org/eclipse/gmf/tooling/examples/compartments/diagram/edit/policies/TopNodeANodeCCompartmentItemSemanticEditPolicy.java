package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.ChildOfA_CCreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
 * @generated
 */
public class TopNodeANodeCCompartmentItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TopNodeANodeCCompartmentItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.TopNodeA_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.ChildOfA_C_3001 == req.getElementType()) {
			return getGEFWrapper(new ChildOfA_CCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
