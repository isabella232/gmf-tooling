/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */

package org.eclipse.gmf.examples.mindmap.rcp.view.factories;

import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ThreadViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static ThreadViewFactory INSTANCE = new ThreadViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry.getType(ThreadEditPart.VISUAL_ID));
		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		view.getStyles().add(style);
		create5001Label(view);
		create7002Compartment(view);
	}

	/**
	 * @generated
	 */
	private void create5001Label(View view) {
		Node label = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(label);
		ThreadSubjectViewFactory.INSTANCE.decorateView(label);
	}

	/**
	 * @generated
	 */
	private void create7002Compartment(View view) {
		Node compartment = NotationFactory.eINSTANCE.createNode();
		view.getPersistedChildren().add(compartment);
		ThreadThreadItemCompartmentViewFactory.INSTANCE
				.decorateView(compartment);
	}
}
