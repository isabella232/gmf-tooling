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

import org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicSubtopicsEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicSubtopicsViewFactory implements IViewDecorator {
	/**
	 * @generated
	 */
	public static TopicSubtopicsViewFactory INSTANCE = new TopicSubtopicsViewFactory();

	/**
	 * @generated
	 */
	public void decorateView(View view) {
		if (view.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
			return;
		}
		view.setType(MindmapVisualIDRegistry
				.getType(TopicSubtopicsEditPart.VISUAL_ID));
	}
}
