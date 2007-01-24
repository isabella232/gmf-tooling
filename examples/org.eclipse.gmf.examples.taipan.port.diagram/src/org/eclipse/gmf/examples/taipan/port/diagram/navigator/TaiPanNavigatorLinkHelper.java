/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.navigator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import org.eclipse.ui.navigator.ILinkHelper;

/**
 * @generated
 */
public class TaiPanNavigatorLinkHelper implements ILinkHelper {

	/**
	 * @generated
	 */
	public IStructuredSelection findSelection(IEditorInput anInput) {
		return StructuredSelection.EMPTY;
	}

	/**
	 * @generated
	 */
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (false == aSelection.getFirstElement() instanceof TaiPanAbstractNavigatorItem) {
			return;
		}

		TaiPanAbstractNavigatorItem navigatorItem = (TaiPanAbstractNavigatorItem) aSelection.getFirstElement();
		View navigatorView = null;
		if (navigatorItem instanceof TaiPanNavigatorItem) {
			navigatorView = ((TaiPanNavigatorItem) navigatorItem).getView();
		} else if (navigatorItem instanceof TaiPanNavigatorGroup) {
			TaiPanNavigatorGroup group = (TaiPanNavigatorGroup) navigatorItem;
			if (group.getParent() instanceof TaiPanNavigatorItem) {
				navigatorView = ((TaiPanNavigatorItem) group.getParent()).getView();
			}
		}
		if (navigatorView == null) {
			return;
		}
		DiagramEditorInput editorInput = new DiagramEditorInput(navigatorView.getDiagram());
		IEditorPart editor = aPage.findEditor(editorInput);
		if (editor == null) {
			return;
		}
		aPage.bringToTop(editor);
		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			Resource diagramResource = diagramEditor.getDiagram().eResource();

			EObject selectedView = diagramResource.getEObject(navigatorView.eResource().getURIFragment(navigatorView));
			if (selectedView == null) {
				return;
			}
			EditPart selectedEditPart = (EditPart) diagramEditor.getDiagramGraphicalViewer().getEditPartRegistry().get(selectedView);
			if (selectedEditPart != null) {
				diagramEditor.getDiagramGraphicalViewer().select(selectedEditPart);
			}
		}
	}

}
