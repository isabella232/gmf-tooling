package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class LinklfEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (LinklfVisualIDRegistry.getVisualID(view)) {

			case CanvasEditPart.VISUAL_ID:
				return new CanvasEditPart(view);

			case CircleEditPart.VISUAL_ID:
				return new CircleEditPart(view);

			case RectangleEditPart.VISUAL_ID:
				return new RectangleEditPart(view);

			case ContainerEditPart.VISUAL_ID:
				return new ContainerEditPart(view);

			case ContainerNameEditPart.VISUAL_ID:
				return new ContainerNameEditPart(view);

			case RhombusEditPart.VISUAL_ID:
				return new RhombusEditPart(view);

			case Circle2EditPart.VISUAL_ID:
				return new Circle2EditPart(view);

			case Container2EditPart.VISUAL_ID:
				return new Container2EditPart(view);

			case ContainerName2EditPart.VISUAL_ID:
				return new ContainerName2EditPart(view);

			case Rectangle2EditPart.VISUAL_ID:
				return new Rectangle2EditPart(view);

			case Rhombus2EditPart.VISUAL_ID:
				return new Rhombus2EditPart(view);

			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);

			case ContainerContainerCompartmentEditPart.VISUAL_ID:
				return new ContainerContainerCompartmentEditPart(view);

			case ContainerContainerCompartment2EditPart.VISUAL_ID:
				return new ContainerContainerCompartment2EditPart(view);

			case LinkEditPart.VISUAL_ID:
				return new LinkEditPart(view);

			case LabeledLinkEditPart.VISUAL_ID:
				return new LabeledLinkEditPart(view);

			case LabeledLinkSourceNameEditPart.VISUAL_ID:
				return new LabeledLinkSourceNameEditPart(view);

			case LabeledLinkTargetNameEditPart.VISUAL_ID:
				return new LabeledLinkTargetNameEditPart(view);

			case LabeledLinkLinkNameEditPart.VISUAL_ID:
				return new LabeledLinkLinkNameEditPart(view);

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
