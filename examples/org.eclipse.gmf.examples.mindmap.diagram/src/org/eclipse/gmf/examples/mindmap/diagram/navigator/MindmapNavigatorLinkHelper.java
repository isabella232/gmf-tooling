package org.eclipse.gmf.examples.mindmap.diagram.navigator;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.MapEditPart;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditor;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.ui.navigator.ILinkHelper;

import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
public class MindmapNavigatorLinkHelper implements ILinkHelper {

	/**
	 * @generated
	 */
	public IStructuredSelection findSelection(IEditorInput anInput) {
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated
	 */
	public void activateEditor(IWorkbenchPage aPage,
			IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (aSelection.getFirstElement() instanceof MindmapAbstractNavigatorItem) {
			MindmapAbstractNavigatorItem navigatorItem = (MindmapAbstractNavigatorItem) aSelection
					.getFirstElement();
			if (!MapEditPart.MODEL_ID.equals(navigatorItem.getModelID())) {
				return;
			}
			Object parentFile = navigatorItem.getParent();
			while (parentFile instanceof MindmapAbstractNavigatorItem) {
				parentFile = ((MindmapAbstractNavigatorItem) parentFile)
						.getParent();
			}
			if (false == parentFile instanceof IFile) {
				return;
			}
			IEditorInput fileInput = new FileEditorInput((IFile) parentFile);
			IEditorPart editor = aPage.findEditor(fileInput);
			if (editor == null) {
				return;
			}
			aPage.bringToTop(editor);
			if (editor instanceof MindmapDiagramEditor) {
				MindmapDiagramEditor diagramEditor = (MindmapDiagramEditor) editor;
				Resource diagramResource = diagramEditor.getDiagram()
						.eResource();

				View navigatorView = null;
				if (navigatorItem instanceof MindmapNavigatorItem) {
					navigatorView = ((MindmapNavigatorItem) navigatorItem)
							.getView();
				} else if (navigatorItem instanceof MindmapNavigatorGroup) {
					MindmapNavigatorGroup group = (MindmapNavigatorGroup) navigatorItem;
					if (group.getParent() instanceof MindmapNavigatorItem) {
						navigatorView = ((MindmapNavigatorItem) group
								.getParent()).getView();
					}
				}

				if (navigatorView == null) {
					return;
				}
				EObject selectedView = diagramResource.getEObject(navigatorView
						.eResource().getURIFragment(navigatorView));
				if (selectedView == null) {
					return;
				}
				EditPart selectedEditPart = (EditPart) diagramEditor
						.getDiagramGraphicalViewer().getEditPartRegistry().get(
								selectedView);
				if (selectedEditPart != null) {
					diagramEditor.getDiagramGraphicalViewer().select(
							selectedEditPart);
				}
			}
		}
	}

}
