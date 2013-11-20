package org.eclipse.gmf.tooling.examples.affixednode.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.affixednode.diagram.part.AffixednodeVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class AffixednodeEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (AffixednodeVisualIDRegistry.getVisualID(view)) {

			case CanvasEditPart.VISUAL_ID:
				return new CanvasEditPart(view);

			case BundleEditPart.VISUAL_ID:
				return new BundleEditPart(view);

			case BundleNameEditPart.VISUAL_ID:
				return new BundleNameEditPart(view);

			case IncomingCommunicatorEditPart.VISUAL_ID:
				return new IncomingCommunicatorEditPart(view);

			case OutcomingCommunicatorEditPart.VISUAL_ID:
				return new OutcomingCommunicatorEditPart(view);

			case CommunicationEditPart.VISUAL_ID:
				return new CommunicationEditPart(view);

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
