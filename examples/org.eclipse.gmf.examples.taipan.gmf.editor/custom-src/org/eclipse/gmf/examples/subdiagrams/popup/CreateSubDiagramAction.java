package org.eclipse.gmf.examples.subdiagrams.popup;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.layers.LayersPackage;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

public class CreateSubDiagramAction extends SubDiagramActionBase {

	private final SubDiagramSpec mySpec;

	private final SubDiagramSupport mySupport;

	public CreateSubDiagramAction(IWorkbenchPage workbenchPage, SubDiagramSpec spec, SubDiagramSupport support) {
		super(workbenchPage);
		mySpec = spec;
		mySupport = support;
	}

	@Override
	protected Command getCommand() {
		DiagramEditPart diagramEditPart = getDiagramEditPart();
		if (diagramEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (mySpec == null) {
			return UnexecutableCommand.INSTANCE;
		}

		String label = "Creating New Sub Diagram";
		Ref<SubDiagramSpec> gateBetweenCommands = new Ref<SubDiagramSpec>();
		CompositeTransactionalCommand composite = new CompositeTransactionalCommand(getDiagramEditPart().getEditingDomain(), label);
		composite.add(new CreateNewSubDiagram(label, mySupport, mySpec, gateBetweenCommands, new DomainOnlyEditRequest(diagramEditPart), getShell()));
		composite.add(createOpenCommand("Opening New Diagram", gateBetweenCommands));

		return new ICommandProxy(composite);
	}

	private Shell getShell() {
		return getWorkbenchPart().getSite().getShell();
	}

	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	protected String calculateText() {
		return "New...";
	}

	protected boolean calculateChecked() {
		return false;
	}

	private static class CreateNewSubDiagram extends EditElementCommand {

		private final SubDiagramSupport mySupport;

		private final SubDiagramSpec myTemplate;

		private final Ref<SubDiagramSpec> myResultRef;

		private final Shell myShell;

		protected CreateNewSubDiagram(String label, SubDiagramSupport support, SubDiagramSpec template, Ref<SubDiagramSpec> result, IEditCommandRequest request, Shell shell) {
			super(label, support, request);
			mySupport = support;
			myTemplate = template;
			myResultRef = result;
			myShell = shell;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			UniqueNameValidator validator = new UniqueNameValidator(mySupport.getAllDiagrams(), LayersPackage.eINSTANCE.getSubDiagramSpec_Name());
			InputDialog dialog = new InputDialog(myShell, //
					"Enter The Name", "New Sub Diagram' Name:", validator.guessNewName("Sub Diagram "), validator);

			if (dialog.open() != Window.OK) {
				return CommandResult.newCancelledCommandResult();
			}

			Diagram clone = EcoreUtil.copy(myTemplate.getDiagram());
			SubDiagramSpec result = EcoreUtil.copy(myTemplate);
			result.setDiagram(clone);
			result.setName(dialog.getValue());

			mySupport.getSubDiagrams().add(result);
			mySupport.eResource().getContents().add(clone);

			myResultRef.set(result);

			return CommandResult.newOKCommandResult(result);
		}
	}
}
