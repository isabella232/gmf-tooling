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

package org.eclipse.gmf.examples.mindmap.rcp.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart.MODEL_ID
					.equals(MindmapVisualIDRegistry.getModelID(view))) {
				return null;
			}

			int viewVisualID = MindmapVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicEditPart.VISUAL_ID:
				return new TopicEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicNameEditPart.VISUAL_ID:
				return new TopicNameEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ResourceEditPart.VISUAL_ID:
				return new ResourceEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ResourceNameEmailEditPart.VISUAL_ID:
				return new ResourceNameEmailEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadEditPart.VISUAL_ID:
				return new ThreadEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadSubjectEditPart.VISUAL_ID:
				return new ThreadSubjectEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadItemEditPart.VISUAL_ID:
				return new ThreadItemEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicThreadCompartmentEditPart.VISUAL_ID:
				return new TopicThreadCompartmentEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.ThreadThreadItemCompartmentEditPart.VISUAL_ID:
				return new ThreadThreadItemCompartmentEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.MapEditPart.VISUAL_ID:
				return new MapEditPart((Diagram) view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.TopicSubtopicsEditPart.VISUAL_ID:
				return new TopicSubtopicsEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipEditPart.VISUAL_ID:
				return new RelationshipEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipLabelEditPart.VISUAL_ID:
				return new RelationshipLabelEditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship2EditPart.VISUAL_ID:
				return new Relationship2EditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipLabel2EditPart.VISUAL_ID:
				return new RelationshipLabel2EditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.Relationship3EditPart.VISUAL_ID:
				return new Relationship3EditPart(view);
			case org.eclipse.gmf.examples.mindmap.rcp.edit.parts.RelationshipLabel3EditPart.VISUAL_ID:
				return new RelationshipLabel3EditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

}
