package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.CompartmentsBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ChildOfB_ECNodeRelationCreateCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final EObject source;

	/**
	* @generated
	*/
	private final EObject target;

	/**
	* @generated
	*/
	public ChildOfB_ECNodeRelationCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof ChildOfB_E) {
			return false;
		}
		if (target != null && false == target instanceof ChildOfA_C) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return CompartmentsBaseItemSemanticEditPolicy.getLinkConstraints().canCreateChildOfB_ECNodeRelation_4001(getSource(), getTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		if (getSource() != null && getTarget() != null) {
			getSource().setCNodeRelation(getTarget());
		}
		return CommandResult.newOKCommandResult();

	}

	/**
	* @generated
	*/
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	* @generated
	*/
	protected ChildOfB_E getSource() {
		return (ChildOfB_E) source;
	}

	/**
	* @generated
	*/
	protected ChildOfA_C getTarget() {
		return (ChildOfA_C) target;
	}
}
