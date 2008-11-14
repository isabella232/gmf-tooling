package org.eclipse.gmf.examples.mindmap.diagram.commands;

import org.eclipse.amalgam.examples.mindmap.Topic;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

public class SubtopicCreateCommand extends EditElementCommand {

	private final EObject source;
	private final EObject target;

	public SubtopicCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
	}

	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof Topic)) {
			return false;
		}
		if (target != null && !(target instanceof Topic)) {
			return false;
		}
		if (target == source) {
			return false;
		}
		return true;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if (getSource() != null && getTarget() != null) {
			getSource().getSubtopics().add(getTarget());
		}
		return CommandResult.newOKCommandResult();
	}

	protected Topic getSource() {
		return (Topic) source;
	}

	protected Topic getTarget() {
		return (Topic) target;
	}
}
