package org.eclipse.gmf.examples.taipan.gmf.editor.part;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;
import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;

/**
 * @generated
 */
public class TaiPanCreateShortcutAction implements IObjectActionDelegate {

	/**
	 * @generated
	 */
	private AquatoryEditPart mySelectedElement;

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
		final View view = (View) mySelectedElement.getModel();
		TaiPanElementChooserDialog elementChooser = new TaiPanElementChooserDialog(myShell, view);
		int result = elementChooser.open();
		if (result != Window.OK) {
			return;
		}
		final EObject selectedElement = elementChooser.getSelectedModelElement();
		if (selectedElement == null) {
			return;
		}

		OperationUtil.runAsUnchecked(new MRunnable() {

			public Object run() {
				Node shortcutNode = ViewService.createNode(view, selectedElement, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
				annotation.setSource("Shortcutted"); //$NON-NLS-1$
				shortcutNode.getEAnnotations().add(annotation);
				return null;
			}
		});

	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof AquatoryEditPart) {
				mySelectedElement = (AquatoryEditPart) structuredSelection.getFirstElement();
			}
		}
		action.setEnabled(isEnabled());
	}

	/**
	 * @generated
	 */
	private boolean isEnabled() {
		return mySelectedElement != null;
	}

}
