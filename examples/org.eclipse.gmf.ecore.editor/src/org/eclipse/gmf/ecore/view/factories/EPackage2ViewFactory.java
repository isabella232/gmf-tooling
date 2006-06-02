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
package org.eclipse.gmf.ecore.view.factories;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_classesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_datatypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_enumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packageannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packagesEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackage2ViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = EcoreVisualIDRegistry.getType(org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", EPackageEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_nameEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_classesEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_packagesEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_datatypesEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_enumsEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, EcoreVisualIDRegistry.getType(EPackage_packageannotationsEditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}
}
