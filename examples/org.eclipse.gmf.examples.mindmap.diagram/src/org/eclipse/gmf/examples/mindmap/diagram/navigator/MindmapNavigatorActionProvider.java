package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditor;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * @generated
 */
public class MindmapNavigatorActionProvider extends CommonActionProvider {

	/**
	 * @generated
	 */
	private boolean myContribute;

	/**
	 * @generated
	 */
	private OpenDiagramAction myOpenDiagramAction;

	/**
	 * @generated
	 */
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			myContribute = true;
			makeActions((ICommonViewerWorkbenchSite) aSite.getViewSite());
		} else {
			myContribute = false;
		}
	}

	/**
	 * @generated
	 */
	private void makeActions(ICommonViewerWorkbenchSite viewerSite) {
		myOpenDiagramAction = new OpenDiagramAction(viewerSite);
	}

	/**
	 * @generated
	 */
	public void fillActionBars(IActionBars actionBars) {
		if (!myContribute) {
			return;
		}
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();
		myOpenDiagramAction.selectionChanged(selection);
		if (myOpenDiagramAction.isEnabled()) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
					myOpenDiagramAction);
		}
	}

	/**
	 * @generated
	 */
	public void fillContextMenu(IMenuManager menu) {
	}

	/**
	 * @generated
	 */
	private class OpenDiagramAction extends Action {

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		/**
		 * @generated
		 */
		private ICommonViewerWorkbenchSite myViewerSite;

		/**
		 * @generated
		 */
		public OpenDiagramAction(ICommonViewerWorkbenchSite viewerSite) {
			super("Open Diagram");
			myViewerSite = viewerSite;
		}

		/**
		 * @generated
		 */
		public final void selectionChanged(IStructuredSelection selection) {
			myDiagram = null;
			if (selection.size() == 1) {
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof MindmapNavigatorItem) {
					selectedElement = ((MindmapNavigatorItem) selectedElement)
							.getView();
				} else if (selectedElement instanceof IAdaptable) {
					selectedElement = ((IAdaptable) selectedElement)
							.getAdapter(View.class);
				}
				if (selectedElement instanceof Diagram) {
					Diagram diagram = (Diagram) selectedElement;
					if (MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry
							.getModelID(diagram))) {
						myDiagram = diagram;
					}
				}
			}
			setEnabled(myDiagram != null);
		}

		/**
		 * @generated
		 */
		public void run() {
			if (myDiagram == null) {
				return;
			}
			DiagramEditorInput editorInput = new DiagramEditorInput(myDiagram);
			IWorkbenchPage page = myViewerSite.getPage();
			try {
				page.openEditor(editorInput, MindmapDiagramEditor.ID);
			} catch (PartInitException e) {
				MindmapDiagramEditorPlugin.getInstance().logError(
						"Exception while openning diagram", e);
			}
		}

	}

}
