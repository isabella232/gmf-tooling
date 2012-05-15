package org.eclipse.gmf.examples.layers.subdiagrams.popup;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.ui.IWorkbenchPage;

public class OpenSubDiagramAction extends SubDiagramActionBase {

	private final SubDiagramSpec mySpec;

	public OpenSubDiagramAction(IWorkbenchPage workbenchPage, SubDiagramSpec spec) {
		super(workbenchPage);
		mySpec = spec;
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
		
		return new ICommandProxy(createOpenCommand("Opening Diagram", mySpec));
	}

	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	protected String calculateText() {
		return safeGetSubDiagramName(mySpec);
	}

	protected boolean calculateChecked() {
		return false;
	}

}
