/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.*;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

/**
 * @generated
 */
public class ShipViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("VisualID");
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("value", "1002");
		getViewService().createNode(semanticAdapter, view, TaiPanSemanticHints.Ship_1002Labels.SHIPNAME_4002_TEXT,
				ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(semanticAdapter, view, TaiPanSemanticHints.Ship_1002Compartments.CARGOCOMPARTMENT_5001,
				ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
