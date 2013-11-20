package org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class PinsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (PinsVisualIDRegistry.getVisualID(view)) {

			case DiagramEditPart.VISUAL_ID:
				return new DiagramEditPart(view);

			case CustomPinEditPart.VISUAL_ID:
				return new CustomPinEditPart(view);

			case VisiblePinEditPart.VISUAL_ID:
				return new VisiblePinEditPart(view);

			case VisiblePinWarningLabelEditPart.VISUAL_ID:
				return new VisiblePinWarningLabelEditPart(view);

			case ColorPinEditPart.VISUAL_ID:
				return new ColorPinEditPart(view);

			case ChangeableColorPinEditPart.VISUAL_ID:
				return new ChangeableColorPinEditPart(view);

			case ChangeableColorPinRedEditPart.VISUAL_ID:
				return new ChangeableColorPinRedEditPart(view);

			case ChangeableColorPinGreenEditPart.VISUAL_ID:
				return new ChangeableColorPinGreenEditPart(view);

			case ChangeableColorPinBlueEditPart.VISUAL_ID:
				return new ChangeableColorPinBlueEditPart(view);

			case PinsChildEditPart.VISUAL_ID:
				return new PinsChildEditPart(view);

			case PinsChild2EditPart.VISUAL_ID:
				return new PinsChild2EditPart(view);

			case PinsChild3EditPart.VISUAL_ID:
				return new PinsChild3EditPart(view);
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
