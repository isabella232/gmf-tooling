package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapVisualIDRegistry;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MindmapEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry
					.getModelID(view))) {
				return null;
			}

			int viewVisualID = MindmapVisualIDRegistry.getVisualID(view);
			switch (viewVisualID) {
			case TopicEditPart.VISUAL_ID:
				return new TopicEditPart(view);
			case TopicNameEditPart.VISUAL_ID:
				return new TopicNameEditPart(view);
			case ResourceEditPart.VISUAL_ID:
				return new ResourceEditPart(view);
			case ResourceNameEmailEditPart.VISUAL_ID:
				return new ResourceNameEmailEditPart(view);
			case ThreadEditPart.VISUAL_ID:
				return new ThreadEditPart(view);
			case ThreadSubjectEditPart.VISUAL_ID:
				return new ThreadSubjectEditPart(view);
			case ThreadItemEditPart.VISUAL_ID:
				return new ThreadItemEditPart(view);
			case TopicThreadCompartmentEditPart.VISUAL_ID:
				return new TopicThreadCompartmentEditPart(view);
			case ThreadThreadItemCompartmentEditPart.VISUAL_ID:
				return new ThreadThreadItemCompartmentEditPart(view);
			case MapEditPart.VISUAL_ID:
				return new MapEditPart((Diagram) view);
			case TopicSubtopicsEditPart.VISUAL_ID:
				return new TopicSubtopicsEditPart(view);
			case RelationshipEditPart.VISUAL_ID:
				return new RelationshipEditPart(view);
			case RelationshipLabelEditPart.VISUAL_ID:
				return new RelationshipLabelEditPart(view);
			case Relationship2EditPart.VISUAL_ID:
				return new Relationship2EditPart(view);
			case RelationshipLabel2EditPart.VISUAL_ID:
				return new RelationshipLabel2EditPart(view);
			case Relationship3EditPart.VISUAL_ID:
				return new Relationship3EditPart(view);
			case RelationshipLabel3EditPart.VISUAL_ID:
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
