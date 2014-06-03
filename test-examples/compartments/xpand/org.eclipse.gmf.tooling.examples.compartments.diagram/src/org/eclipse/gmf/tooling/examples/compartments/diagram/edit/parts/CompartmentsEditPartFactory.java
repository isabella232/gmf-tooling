package org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class CompartmentsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (CompartmentsVisualIDRegistry.getVisualID(view)) {

			case CanvasEditPart.VISUAL_ID:
				return new CanvasEditPart(view);

			case TopNodeAEditPart.VISUAL_ID:
				return new TopNodeAEditPart(view);

			case TopNodeANameEditPart.VISUAL_ID:
				return new TopNodeANameEditPart(view);

			case TopNodeBEditPart.VISUAL_ID:
				return new TopNodeBEditPart(view);

			case TopNodeBNameEditPart.VISUAL_ID:
				return new TopNodeBNameEditPart(view);

			case ChildOfA_CEditPart.VISUAL_ID:
				return new ChildOfA_CEditPart(view);

			case ChildOfA_CNameEditPart.VISUAL_ID:
				return new ChildOfA_CNameEditPart(view);

			case ChildOfA_DEditPart.VISUAL_ID:
				return new ChildOfA_DEditPart(view);

			case ChildOfA_DNameEditPart.VISUAL_ID:
				return new ChildOfA_DNameEditPart(view);

			case ChildOfB_EEditPart.VISUAL_ID:
				return new ChildOfB_EEditPart(view);

			case ChildOfB_ENameEditPart.VISUAL_ID:
				return new ChildOfB_ENameEditPart(view);

			case ChildOfB_GEditPart.VISUAL_ID:
				return new ChildOfB_GEditPart(view);

			case ChildOfB_GNumberEditPart.VISUAL_ID:
				return new ChildOfB_GNumberEditPart(view);

			case ChildOfAffixedEditPart.VISUAL_ID:
				return new ChildOfAffixedEditPart(view);

			case ChildOfB_FEditPart.VISUAL_ID:
				return new ChildOfB_FEditPart(view);

			case ChildOfB_FNameEditPart.VISUAL_ID:
				return new ChildOfB_FNameEditPart(view);

			case TopNodeANodeCCompartmentEditPart.VISUAL_ID:
				return new TopNodeANodeCCompartmentEditPart(view);

			case TopNodeANodeDCompartmentEditPart.VISUAL_ID:
				return new TopNodeANodeDCompartmentEditPart(view);

			case TopNodeBNodeECompartmentEditPart.VISUAL_ID:
				return new TopNodeBNodeECompartmentEditPart(view);

			case TopNodeBNodeFCompartmentEditPart.VISUAL_ID:
				return new TopNodeBNodeFCompartmentEditPart(view);

			case ChildOfB_GAffixedChildrenCompartmentEditPart.VISUAL_ID:
				return new ChildOfB_GAffixedChildrenCompartmentEditPart(view);

			case ChildOfB_ECNodeRelationEditPart.VISUAL_ID:
				return new ChildOfB_ECNodeRelationEditPart(view);

			case ChildOfB_FDNodeRelationEditPart.VISUAL_ID:
				return new ChildOfB_FDNodeRelationEditPart(view);

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

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
