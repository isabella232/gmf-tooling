package org.eclipse.gmf.examples.mindmap.lite.rcp.part;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts.MapEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class MindmapLoadResourceAction implements IObjectActionDelegate {
	/**
	 * @generated
	 */
	private MapEditPart mySelectedElement;

	/**
	 * @generated
	 */
	private Shell myShell;

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myShell = targetPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(
				myShell, getEditingDomain());
		loadResourceDialog.open();
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1
					&& structuredSelection.getFirstElement() instanceof MapEditPart) {
				mySelectedElement = (MapEditPart) structuredSelection
						.getFirstElement();
			}
		}
		action.setEnabled(mySelectedElement != null);
	}

	/**
	 * @generated
	 */
	private EditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(mySelectedElement.getDiagram());
	}
}
