package org.eclipse.gmf.examples.subdiagrams.popup;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.ui.IWorkbenchPage;

public class AssignToLayerAction extends DiagramAction {

	protected static final String EMPTY_LAYER_NAME = "<empty-name>";

	private final Layer myLayerToAssign;

	private final List<EObject> mySemanticElements;

	public AssignToLayerAction(IWorkbenchPage workbenchPage, List<EObject> semanticElements, Layer layer) {
		super(workbenchPage);
		mySemanticElements = semanticElements;
		myLayerToAssign = layer;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	protected Command getCommand() {
		DiagramEditPart packageEditPart = getDiagramEditPart();
		if (packageEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = packageEditPart.getEditingDomain();
		IEditCommandRequest request = new DomainOnlyEditRequest(editingDomain);
		boolean addNotRemove = !isAssignedToLayer(mySemanticElements, myLayerToAssign);
		return new ICommandProxy(new AssignToLayer("Changing Layer Assignments", myLayerToAssign, mySemanticElements, addNotRemove, request));
	}

	@Override
	public boolean isEnabled() {
		return getDiagramEditPart() != null;
	}

	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	protected String calculateText() {
		String name = myLayerToAssign.getName();
		return name != null ? name : EMPTY_LAYER_NAME;
	}

	protected boolean calculateChecked() {
		return isAssignedToLayer(mySemanticElements, myLayerToAssign);
	}

	private boolean isAssignedToLayer(List<EObject> semanticElements, Layer layer) {
		return layer.getParticipants().containsAll(semanticElements);
	}

	protected class AssignToLayer extends EditElementCommand {

		private final Layer myLayer;

		private final List<EObject> myAssignees;

		private final boolean myAddNotRemove;

		protected AssignToLayer(String label, Layer layer, List<EObject> assignees, boolean addNotRemove, IEditCommandRequest request) {
			super(label, layer, request);
			myAssignees = assignees;
			myLayer = layer;
			myAddNotRemove = addNotRemove;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if (myAddNotRemove) {
				myLayer.getParticipants().addAll(myAssignees);
			} else {
				myLayer.getParticipants().removeAll(myAssignees);
			}
			return CommandResult.newOKCommandResult(myLayer);
		}

	}
}
