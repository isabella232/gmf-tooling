package org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.part.ShortcutVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class ShortcutEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ShortcutVisualIDRegistry.getVisualID(view)) {

			case DiagramEditPart.VISUAL_ID:
				return new DiagramEditPart(view);

			case DiagramNodeEditPart.VISUAL_ID:
				return new DiagramNodeEditPart(view);

			case DiagramNodeNameEditPart.VISUAL_ID:
				return new DiagramNodeNameEditPart(view);

			case DiagramLinkEditPart.VISUAL_ID:
				return new DiagramLinkEditPart(view);

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
