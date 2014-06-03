package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.tooling.examples.compartments.diagram.providers.CompartmentsElementTypes;

/**
 * @generated
 */
public class ChildOfB_FDNodeRelationItemSemanticEditPolicy extends CompartmentsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ChildOfB_FDNodeRelationItemSemanticEditPolicy() {
		super(CompartmentsElementTypes.ChildOfB_FDNodeRelation_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
