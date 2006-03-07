/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanSemanticHints;

/**
 * @generated
 */
public class Route_reliabilityViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("ViewIdentifier"); //$NON-NLS-1$
		view.getEAnnotations().add(annotation);
		annotation.getDetails().put("modelID", "TaiPan"); //$NON-NLS-1$
		annotation.getDetails().put("visualID", "4006"); //$NON-NLS-1$
		getViewService().createNode(semanticAdapter, view, TaiPanSemanticHints.Route_3002Labels.ROUTERELIABILITY_4006_TEXT, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
}
