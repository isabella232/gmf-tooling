package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands.ChildOfB_ECreateCommand;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
* @generated
*/
public class TopNodeBNodeECompartmentItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public TopNodeBNodeECompartmentItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.TopNodeB_2002);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (CompartmentsElementTypes.ChildOfB_E_3003 == req.getElementType()) {
			return getGEFWrapper(new ChildOfB_ECreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
