package org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.tooling.examples.affixednode.Canvas;
import org.eclipse.gmf.tooling.examples.affixednode.Communication;
import org.eclipse.gmf.tooling.examples.affixednode.IncomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.OutcomingCommunicator;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.policies.AffixednodeBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class CommunicationReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

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
	public CommunicationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Communication) {
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
		if (!(oldEnd instanceof OutcomingCommunicator && newEnd instanceof OutcomingCommunicator)) {
			return false;
		}
		IncomingCommunicator target = getLink().getIncomingCommunicator();
		if (!(getLink().eContainer() instanceof Canvas)) {
			return false;
		}
		Canvas container = (Canvas) getLink().eContainer();
		return AffixednodeBaseItemSemanticEditPolicy.getLinkConstraints().canExistCommunication_4001(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof IncomingCommunicator && newEnd instanceof IncomingCommunicator)) {
			return false;
		}
		OutcomingCommunicator source = getLink().getOutcomingCommunicator();
		if (!(getLink().eContainer() instanceof Canvas)) {
			return false;
		}
		Canvas container = (Canvas) getLink().eContainer();
		return AffixednodeBaseItemSemanticEditPolicy.getLinkConstraints().canExistCommunication_4001(container, getLink(), source, getNewTarget());
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
		getLink().setOutcomingCommunicator(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setIncomingCommunicator(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Communication getLink() {
		return (Communication) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected OutcomingCommunicator getOldSource() {
		return (OutcomingCommunicator) oldEnd;
	}

	/**
	 * @generated
	 */
	protected OutcomingCommunicator getNewSource() {
		return (OutcomingCommunicator) newEnd;
	}

	/**
	 * @generated
	 */
	protected IncomingCommunicator getOldTarget() {
		return (IncomingCommunicator) oldEnd;
	}

	/**
	 * @generated
	 */
	protected IncomingCommunicator getNewTarget() {
		return (IncomingCommunicator) newEnd;
	}
}
