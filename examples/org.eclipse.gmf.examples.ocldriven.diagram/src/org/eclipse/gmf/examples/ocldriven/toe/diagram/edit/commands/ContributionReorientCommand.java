package org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.AllHolder;
import org.eclipse.gmf.examples.ocldriven.toe.Contribution;
import org.eclipse.gmf.examples.ocldriven.toe.Employee;
import org.eclipse.gmf.examples.ocldriven.toe.Project;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.policies.TOEBaseItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class ContributionReorientCommand extends EditElementCommand {

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
	public ContributionReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Contribution) {
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
		if (!(oldEnd instanceof Employee && newEnd instanceof Employee)) {
			return false;
		}
		Project target = getLink().getProject();
		if (!(getLink().eContainer() instanceof AllHolder)) {
			return false;
		}
		AllHolder container = (AllHolder) getLink().eContainer();
		return TOEBaseItemSemanticEditPolicy.getLinkConstraints().canExistContribution_4003(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Project && newEnd instanceof Project)) {
			return false;
		}
		Employee source = getLink().getEmployee();
		if (!(getLink().eContainer() instanceof AllHolder)) {
			return false;
		}
		AllHolder container = (AllHolder) getLink().eContainer();
		return TOEBaseItemSemanticEditPolicy.getLinkConstraints().canExistContribution_4003(container, getLink(), source, getNewTarget());
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
		getLink().setEmployee(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setProject(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected Contribution getLink() {
		return (Contribution) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Employee getOldSource() {
		return (Employee) oldEnd;
	}

	/**
	* @generated
	*/
	protected Employee getNewSource() {
		return (Employee) newEnd;
	}

	/**
	* @generated
	*/
	protected Project getOldTarget() {
		return (Project) oldEnd;
	}

	/**
	* @generated
	*/
	protected Project getNewTarget() {
		return (Project) newEnd;
	}
}
