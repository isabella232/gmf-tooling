/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.navigator;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditor;

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
public class EcoreNavigatorLinkHelper implements ILinkHelper {

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
		if (aSelection.getFirstElement() instanceof EcoreAbstractNavigatorItem) {
			EcoreAbstractNavigatorItem navigatorItem = (EcoreAbstractNavigatorItem) aSelection.getFirstElement();
			if (!EPackageEditPart.MODEL_ID.equals(navigatorItem.getModelID())) {
				return;
			}
			Object parentFile = navigatorItem.getParent();
			while (parentFile instanceof EcoreAbstractNavigatorItem) {
				parentFile = ((EcoreAbstractNavigatorItem) parentFile).getParent();
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
			if (editor instanceof EcoreDiagramEditor) {
				EcoreDiagramEditor diagramEditor = (EcoreDiagramEditor) editor;
				Resource diagramResource = diagramEditor.getDiagram().eResource();

				View navigatorView = null;
				if (navigatorItem instanceof EcoreNavigatorItem) {
					navigatorView = ((EcoreNavigatorItem) navigatorItem).getView();
				} else if (navigatorItem instanceof EcoreNavigatorGroup) {
					EcoreNavigatorGroup group = (EcoreNavigatorGroup) navigatorItem;
					if (group.getParent() instanceof EcoreNavigatorItem) {
						navigatorView = ((EcoreNavigatorItem) group.getParent()).getView();
					}
				}

				if (navigatorView == null) {
					return;
				}
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

}
