package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfA_D;
import org.eclipse.gmf.tooling.examples.compartments.ChildOfB_F;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.policies.CompartmentsBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ChildOfB_FDNodeRelationReorientCommand extends EditElementCommand {

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
	public ChildOfB_FDNodeRelationReorientCommand(ReorientReferenceRelationshipRequest request) {
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
		if (false == referenceOwner instanceof ChildOfB_F) {
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
		if (!(oldEnd instanceof ChildOfA_D && newEnd instanceof ChildOfB_F)) {
			return false;
		}
		return CompartmentsBaseItemSemanticEditPolicy.getLinkConstraints().canExistChildOfB_FDNodeRelation_4002(getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof ChildOfA_D && newEnd instanceof ChildOfA_D)) {
			return false;
		}
		return CompartmentsBaseItemSemanticEditPolicy.getLinkConstraints().canExistChildOfB_FDNodeRelation_4002(getOldSource(), getNewTarget());
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
		getOldSource().setDNodeRelation(null);
		getNewSource().setDNodeRelation(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setDNodeRelation(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected ChildOfB_F getOldSource() {
		return (ChildOfB_F) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected ChildOfB_F getNewSource() {
		return (ChildOfB_F) newEnd;
	}

	/**
	 * @generated
	 */
	protected ChildOfA_D getOldTarget() {
		return (ChildOfA_D) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ChildOfA_D getNewTarget() {
		return (ChildOfA_D) newEnd;
	}

}
