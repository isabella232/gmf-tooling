package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_C;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_E;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.CompartmentsBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ChildOfB_ECNodeRelationReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public ChildOfB_ECNodeRelationReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof ChildOfB_E) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ChildOfA_C && newEnd instanceof ChildOfB_E)) {
			return false;
		}
		return CompartmentsBaseItemSemanticEditPolicy.getLinkConstraints().canExistChildOfB_ECNodeRelation_4001(getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ChildOfA_C && newEnd instanceof ChildOfA_C)) {
			return false;
		}
		return CompartmentsBaseItemSemanticEditPolicy.getLinkConstraints().canExistChildOfB_ECNodeRelation_4001(getOldSource(), getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().setCNodeRelation(null);
		getNewSource().setCNodeRelation(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setCNodeRelation(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected ChildOfB_E getOldSource() {
		return (ChildOfB_E) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected ChildOfB_E getNewSource() {
		return (ChildOfB_E) newEnd;
	}

	/**
	 * @generated
	 */
	protected ChildOfA_C getOldTarget() {
		return (ChildOfA_C) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ChildOfA_C getNewTarget() {
		return (ChildOfA_C) newEnd;
	}

}
