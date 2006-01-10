package org.eclipse.gmf.ecore.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileEditorInputProxy;
import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;
import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class EcoreCreateShortcutAction implements IObjectActionDelegate {

	private FileEditorInputProxy mySelectedElement;

	private Shell myShell;

	private DiagramEditor myDiagramEditor;

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myDiagramEditor = targetPart instanceof DiagramEditor ? (DiagramEditor) targetPart : null;
		myShell = targetPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		EcoreElementChooserDialog elementChooser = new EcoreElementChooserDialog(myShell);
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
				Node shortcutNode = ViewService.createNode(myDiagramEditor.getDiagram(), selectedElement, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

				Collection allNodes = new ArrayList();
				getAllNodes(allNodes, shortcutNode);
				for (Iterator it = allNodes.iterator(); it.hasNext();) {
					Node nextNode = (Node) it.next();
					EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
					annotation.setSource("Shortcutted"); //$NON-NLS-1$
					nextNode.getEAnnotations().add(annotation);
				}
				return null;
			}
		});

	}

	/**
	 * @generated
	 */
	private void getAllNodes(Collection initial, Node node) {
		initial.add(node);
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			getAllNodes(initial, (Node) it.next());
		}
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof FileEditorInputProxy) {
				mySelectedElement = (FileEditorInputProxy) structuredSelection.getFirstElement();
			}
		}
		action.setEnabled(isEnabled());
	}

	/**
	 * @generated
	 */
	private boolean isEnabled() {
		return myDiagramEditor != null && mySelectedElement != null;
	}

}
