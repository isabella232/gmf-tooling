/*
 * Copyright (c) 2006 Borland Software Corporation
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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public class RouteReliabilityViewFactory extends AbstractLabelViewFactory {

	/**
	 * @generated
	 */
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node view = (Node) super.createView(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		return view;
	}

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		return styles;
	}
}
