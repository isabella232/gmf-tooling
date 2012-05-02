package org.eclipse.gmf.examples.subdiagrams.popup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

public class CreateNewLayerAction extends DiagramAction {

	private final List<EObject> mySemanticElements;

	private final SubDiagramSupport mySupport;

	private final SubDiagramSpec myDiagram;

	public CreateNewLayerAction(IWorkbenchPage workbenchPage, List<EObject> semanticElements, SubDiagramSupport support, SubDiagramSpec diagram) {
		super(workbenchPage);
		mySemanticElements = semanticElements;
		mySupport = support;
		myDiagram = diagram;
		setText("Add To New Layer...");
		setChecked(false);
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
		DiagramEditPart diagramEditPart = getDiagramEditPart();
		if (diagramEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		IEditCommandRequest request = new DomainOnlyEditRequest(diagramEditPart);
		return new ICommandProxy(new CreateNewLayerLayer("Creating New Layer", mySupport, mySemanticElements, myDiagram, request, getWorkbenchPart().getSite().getShell()));
	}

	@Override
	public boolean isEnabled() {
		return getDiagramEditPart() != null && !mySemanticElements.isEmpty();
	}

	public static class CreateNewLayerLayer extends EditElementCommand {

		private final SubDiagramSupport mySupport;

		private final List<EObject> myAssignees;

		private final Shell myShell;

		private final SubDiagramSpec myDiagram;

		protected CreateNewLayerLayer(String label, SubDiagramSupport support, List<EObject> assignees, SubDiagramSpec diagram, IEditCommandRequest request, Shell shell) {
			super(label, support, request);
			myAssignees = assignees;
			mySupport = support;
			myDiagram = diagram;
			myShell = shell;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			UniqueNameValidator validator = new UniqueNameValidator(mySupport);
			InputDialog dialog = new InputDialog(myShell, //
					"Enter The Name", "New Layer's Name:", validator.guessNewLayerName(), validator);

			if (dialog.open() != Window.OK) {
				return CommandResult.newCancelledCommandResult();
			}

			Layer layer = LayersFactory.eINSTANCE.createLayer();
			layer.setName(dialog.getValue());
			mySupport.getLayers().add(layer);
			mySupport.ensureAllSubDiagramsHaveEnablementForAllLayers();
			layer.getParticipants().addAll(myAssignees);
			
			myDiagram.findLayerEnablement(layer).setVisible(true);

			return CommandResult.newOKCommandResult(layer);
		}

		private static class UniqueNameValidator implements IInputValidator {

			private final Set<String> myAllNames = new HashSet<String>();

			public UniqueNameValidator(SubDiagramSupport support) {
				for (Layer next : support.getLayers()) {
					String nextName = next.getName();
					if (nextName != null) {
						myAllNames.add(nextName);
					}
				}
			}

			@Override
			public String isValid(String newText) {
				if (newText == null) {
					return "Empty Name Is Not Allowed";
				}
				newText = newText.trim();
				if (newText.length() == 0) {
					return "Empty Name Is Not Allowed";
				}
				if (myAllNames.contains(newText)) {
					return "This Name Already Exists";
				}
				return null;
			}

			public String guessNewLayerName() {

				String prefix = "Layer ";
				for (int i = 0; i < 26; i++) {
					String nextCandidate = prefix + (char) ('A' + i);
					if (isValid(nextCandidate) == null) {
						return nextCandidate;
					}
				}

				//wow
				int i = 0;
				while (++i < 1000) {
					String nextCandidate = prefix + i;
					if (isValid(nextCandidate) == null) {
						return nextCandidate;
					}
				}

				return "<can't guess -- too many names already>";
			}

		}
	}
}
