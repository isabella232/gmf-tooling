package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.ChildOfA_DCreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
 * @generated
 */
public class TopNodeANodeDCompartmentItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TopNodeANodeDCompartmentItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.TopNodeA_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.ChildOfA_D_3002 == req.getElementType()) {
			return getGEFWrapper(new ChildOfA_DCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
