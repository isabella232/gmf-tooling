package org.eclipse.gmf.examples.subdiagrams.popup;

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
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.ui.IWorkbenchPage;

public class AssignToLayerAction extends DiagramAction {

	protected static final String EMPTY_LAYER_NAME = "<empty-name>";

	private final Layer myLayerToAssign;

	private final EObject mySemanticElement;

	public AssignToLayerAction(IWorkbenchPage workbenchPage, EObject semanticElement, Layer layer) {
		super(workbenchPage);
		myLayerToAssign = layer;
		mySemanticElement = semanticElement;
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
		IEditCommandRequest request = new EditRequestWithoutEditHelperContext(editingDomain);
		boolean addNotRemove = !isAssignedToLayer(mySemanticElement, myLayerToAssign);
		return new ICommandProxy(new AssignToLayer("Changing Layer Assignments", myLayerToAssign, mySemanticElement, addNotRemove, request));
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
		return isAssignedToLayer(mySemanticElement, myLayerToAssign);
	}

	private boolean isAssignedToLayer(EObject semanticElement, Layer layer) {
		return layer.getParticipants().contains(semanticElement);
	}

	protected class AssignToLayer extends EditElementCommand {

		private final Layer myLayer;

		private final EObject myAssignee;

		private final boolean myAddNotRemove;

		protected AssignToLayer(String label, Layer layer, EObject assignee, boolean addNotRemove, IEditCommandRequest request) {
			super(label, layer, request);
			myAssignee = assignee;
			myLayer = layer;
			myAddNotRemove = addNotRemove;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if (myAddNotRemove) {
				myLayer.getParticipants().add(myAssignee);
			} else {
				myLayer.getParticipants().remove(myAssignee);
			}
			return CommandResult.newOKCommandResult(myLayer);
		}

	}

	private static class EditRequestWithoutEditHelperContext extends AbstractEditCommandRequest {

		protected EditRequestWithoutEditHelperContext(TransactionalEditingDomain editingDomain) {
			super(editingDomain);
		}

		@Override
		public Object getEditHelperContext() {
			return null;
		}
	}
}
