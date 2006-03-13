package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

/**
 * @generated
 */
public class EclipseconEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public static final String EXTERNAL_NODE_LABELS_LAYER = "External Node Labels";

	/**
	 * @generated
	 */
	private String getModelID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return null;
		}
		return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private static int getVisualID(View containerView) {
		EAnnotation annotation = containerView.getEAnnotation("ViewIdentifier"); //$NON-NLS-1$
		if (annotation == null) {
			return -1;
		}
		String visualID = (String) annotation.getDetails().get("visualID"); //$NON-NLS-1$
		if (visualID == null) {
			return -1;
		}
		try {
			return Integer.parseInt(visualID);
		} catch (NumberFormatException e) {
			EclipseconDiagramEditorPlugin.getInstance().logError(
					"Unable to parse \"visualID\" annotation: " + visualID, e);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			if (!"Eclipsecon".equals(getModelID(view))) {
				return null;
			}

			int viewVisualID = getVisualID(view);
			switch (viewVisualID) {
			case 1001:
				return new PresenterEditPart(view);
			case 4001:
				return new Presenter_nameEditPart(view);
			case 1002:
				return new TutorialEditPart(view);
			case 4002:
				return new Tutorial_titleEditPart(view);
			case 1003:
				return new ScheduleEditPart(view);
			case 4005:
				return new Schedule_dayNoEditPart(view);
			case 1004:
				return new ResourceEditPart(view);
			case 4006:
					return new Resource_UnknownEditPart(view);
			case 4007:
				return new Resource_nameEditPart(view);
			case 4008:
				return new Resource_locationEditPart(view);
			case 2001:
				return new TimeSlotEditPart(view);
			case 4003:
				return new TimeSlot_startEditPart(view);
			case 4004:
				return new TimeSlot_endEditPart(view);
			case 79:
				return new ConferenceEditPart(view);
			case 3001:
				return new HandoutEditPart(view);
			case 3002:
				return new AssignedEditPart(view);
			case 3003:
				return new PresentersEditPart(view);
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
