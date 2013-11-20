package borders.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import borders.diagram.part.BordersVisualIDRegistry;

/**
 * @generated
 */
public class BordersEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (BordersVisualIDRegistry.getVisualID(view)) {

			case DiagramEditPart.VISUAL_ID:
				return new DiagramEditPart(view);

			case MarginBorderEditPart.VISUAL_ID:
				return new MarginBorderEditPart(view);

			case CustomBorderEditPart.VISUAL_ID:
				return new CustomBorderEditPart(view);

			case CompoundBorderEditPart.VISUAL_ID:
				return new CompoundBorderEditPart(view);

			case LineBorderEditPart.VISUAL_ID:
				return new LineBorderEditPart(view);
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
