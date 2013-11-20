package org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.tooling.examples.shortcut.Diagram;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramLink;
import org.eclipse.gmf.tooling.examples.shortcut.DiagramNode;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.policies.ShortcutBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class DiagramLinkReorientCommand extends EditElementCommand {

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
	public DiagramLinkReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof DiagramLink) {
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
		if (!(oldEnd instanceof DiagramNode && newEnd instanceof DiagramNode)) {
			return false;
		}
		DiagramNode target = getLink().getTargetNode();
		if (!(getLink().eContainer() instanceof Diagram)) {
			return false;
		}
		Diagram container = (Diagram) getLink().eContainer();
		return ShortcutBaseItemSemanticEditPolicy.getLinkConstraints().canExistDiagramLink_4001(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof DiagramNode && newEnd instanceof DiagramNode)) {
			return false;
		}
		DiagramNode source = getLink().getSourceNode();
		if (!(getLink().eContainer() instanceof Diagram)) {
			return false;
		}
		Diagram container = (Diagram) getLink().eContainer();
		return ShortcutBaseItemSemanticEditPolicy.getLinkConstraints().canExistDiagramLink_4001(container, getLink(), source, getNewTarget());
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
		getLink().setSourceNode(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTargetNode(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected DiagramLink getLink() {
		return (DiagramLink) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected DiagramNode getOldSource() {
		return (DiagramNode) oldEnd;
	}

	/**
	* @generated
	*/
	protected DiagramNode getNewSource() {
		return (DiagramNode) newEnd;
	}

	/**
	* @generated
	*/
	protected DiagramNode getOldTarget() {
		return (DiagramNode) oldEnd;
	}

	/**
	* @generated
	*/
	protected DiagramNode getNewTarget() {
		return (DiagramNode) newEnd;
	}
}
