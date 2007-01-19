package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.MapEditPart;

import org.eclipse.jface.action.IAction;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * @generated
 */
public class MindmapInitDiagramFileAction extends WorkbenchWindowActionDelegate {
	/**
	 * @generated
	 */
	private URI mySelectedModelFileURI;

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		mySelectedModelFileURI = null;
		if (selection instanceof IStructuredSelection == false
				|| selection.isEmpty()) {
			return;
		}
		Object firstElement = ((IStructuredSelection) selection)
				.getFirstElement();
		if (firstElement instanceof URI) {
			mySelectedModelFileURI = (URI) firstElement;
		} else if (firstElement instanceof IAdaptable) {
			mySelectedModelFileURI = (URI) ((IAdaptable) firstElement)
					.getAdapter(URI.class);
		}
		if (mySelectedModelFileURI != null) {
			mySelectedModelFileURI = mySelectedModelFileURI.trimFragment();
		}
		action.setEnabled(true);
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		EObject diagramRoot = null;
		TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE
				.createEditingDomain();
		if (mySelectedModelFileURI != null) {
			ResourceSet resourceSet = editingDomain.getResourceSet();
			try {
				Resource resource = resourceSet.getResource(
						mySelectedModelFileURI, true);
				diagramRoot = (EObject) resource.getContents().get(0);
			} catch (WrappedException ex) {
				MindmapDiagramEditorPlugin
						.getInstance()
						.logError(
								"Unable to load resource: " + mySelectedModelFileURI.toString(), ex); //$NON-NLS-1$
				MessageDialog.openError(getWindow().getShell(), "Error",
						"Model file loading failed");
				return;
			}
		}
		Wizard wizard = new MindmapNewDiagramFileWizard(mySelectedModelFileURI,
				diagramRoot, editingDomain);
		IDialogSettings pluginDialogSettings = MindmapDiagramEditorPlugin
				.getInstance().getDialogSettings();
		IDialogSettings initDiagramFileSettings = pluginDialogSettings
				.getSection("InisDiagramFile"); //$NON-NLS-1$
		if (initDiagramFileSettings == null) {
			initDiagramFileSettings = pluginDialogSettings
					.addNewSection("InisDiagramFile"); //$NON-NLS-1$
		}
		wizard.setDialogSettings(initDiagramFileSettings);
		wizard.setForcePreviousAndNextButtons(mySelectedModelFileURI != null);
		wizard.setWindowTitle("Initialize new " + MapEditPart.MODEL_ID
				+ " diagram file");

		WizardDialog dialog = new WizardDialog(getWindow().getShell(), wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x),
				500);
		dialog.open();
	}

}
