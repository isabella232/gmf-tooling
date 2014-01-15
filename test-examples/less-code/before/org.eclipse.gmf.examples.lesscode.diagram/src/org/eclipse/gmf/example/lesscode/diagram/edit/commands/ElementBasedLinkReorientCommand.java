package org.eclipse.gmf.example.lesscode.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.example.lesscode.ElementBasedLink;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;
import org.eclipse.gmf.example.lesscode.diagram.edit.policies.LesscodeBaseItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class ElementBasedLinkReorientCommand extends EditElementCommand {

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
	public ElementBasedLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof ElementBasedLink) {
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
		if (!(oldEnd instanceof Subject && newEnd instanceof Subject)) {
			return false;
		}
		Subject target = getLink().getLinkTarget();
		if (!(getLink().eContainer() instanceof RootContainer)) {
			return false;
		}
		RootContainer container = (RootContainer) getLink().eContainer();
		return LesscodeBaseItemSemanticEditPolicy.getLinkConstraints().canExistElementBasedLink_4001(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Subject && newEnd instanceof Subject)) {
			return false;
		}
		Subject source = getLink().getLinkSource();
		if (!(getLink().eContainer() instanceof RootContainer)) {
			return false;
		}
		RootContainer container = (RootContainer) getLink().eContainer();
		return LesscodeBaseItemSemanticEditPolicy.getLinkConstraints().canExistElementBasedLink_4001(container, getLink(), source, getNewTarget());
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
		getLink().setLinkSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setLinkTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected ElementBasedLink getLink() {
		return (ElementBasedLink) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Subject getOldSource() {
		return (Subject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Subject getNewSource() {
		return (Subject) newEnd;
	}

	/**
	 * @generated
	 */
	protected Subject getOldTarget() {
		return (Subject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Subject getNewTarget() {
		return (Subject) newEnd;
	}
}
