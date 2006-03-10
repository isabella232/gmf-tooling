package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.Presenter;
import org.eclipse.gmf.examples.eclipsecon.Resource;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.TimeSlot;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconSemanticHints;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class EclipseconVisualIDRegistry {

	public static final EclipseconVisualIDRegistry INSTANCE = new EclipseconVisualIDRegistry();

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (EclipseconPackage.eINSTANCE.getConference().equals(
				domainElementMetaclass)
				&& (domainElement != null ? isDiagramConference_79((Conference) domainElement)
						: true)) {
			return 79;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement,
			String semanticHint) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, semanticHint);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement,
			EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!"Eclipsecon".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if ("Eclipsecon".equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = 79;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case 1001:
			if (EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001_TEXT
					.equals(semanticHint)) {
				return 4001;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedPresenter_1001ChildNodeID(semanticHint);
			}
			return getUnrecognizedPresenter_1001ChildNodeID(domainElement);
		case 1002:
			if (EclipseconSemanticHints.Tutorial_1002Labels.TUTORIALTITLE_4002_TEXT
					.equals(semanticHint)) {
				return 4002;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedTutorial_1002ChildNodeID(semanticHint);
			}
			return getUnrecognizedTutorial_1002ChildNodeID(domainElement);
		case 1003:
			if (EclipseconSemanticHints.Schedule_1003Labels.SCHEDULEDAYNO_4005_TEXT
					.equals(semanticHint)) {
				return 4005;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedSchedule_1003ChildNodeID(semanticHint);
			}
			if (EclipseconPackage.eINSTANCE.getTimeSlot().equals(
					domainElementMetaclass)
					&& (domainElement != null ? isNodeTimeSlot_2001((TimeSlot) domainElement)
							: true)) {
				return 2001;
			}
			return getUnrecognizedSchedule_1003ChildNodeID(domainElement);
		case 1004:
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCEUNKNOWN_4006_LABEL
					.equals(semanticHint)) {
				return 4006;
			}
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCENAME_4007_TEXT
					.equals(semanticHint)) {
				return 4007;
			}
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCELOCATION_4008_TEXT
					.equals(semanticHint)) {
				return 4008;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedResource_1004ChildNodeID(semanticHint);
			}
			return getUnrecognizedResource_1004ChildNodeID(domainElement);
		case 4006:
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCEUNKNOWN_4006_TEXT
					.equals(semanticHint)) {
				return 4006;
			}
			return -1;
		case 2001:
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTSTART_4003_TEXT
					.equals(semanticHint)) {
				return 4003;
			}
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTEND_4004_TEXT
					.equals(semanticHint)) {
				return 4004;
			}
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedTimeSlot_2001ChildNodeID(semanticHint);
			}
			return getUnrecognizedTimeSlot_2001ChildNodeID(domainElement);
		case 79:
			if (semanticHint != null && !"".equals(semanticHint)) {
				return getUnrecognizedConference_79ChildNodeID(semanticHint);
			}
			if (EclipseconPackage.eINSTANCE.getPresenter().equals(
					domainElementMetaclass)
					&& (domainElement != null ? isNodePresenter_1001((Presenter) domainElement)
							: true)) {
				return 1001;
			}
			if (EclipseconPackage.eINSTANCE.getTutorial().equals(
					domainElementMetaclass)
					&& (domainElement != null ? isNodeTutorial_1002((Tutorial) domainElement)
							: true)) {
				return 1002;
			}
			if (EclipseconPackage.eINSTANCE.getSchedule().equals(
					domainElementMetaclass)
					&& (domainElement != null ? isNodeSchedule_1003((Schedule) domainElement)
							: true)) {
				return 1003;
			}
			if (EclipseconPackage.eINSTANCE.getResource().equals(
					domainElementMetaclass)
					&& (domainElement != null ? isNodeResource_1004((Resource) domainElement)
							: true)) {
				return 1004;
			}
			return getUnrecognizedConference_79ChildNodeID(domainElement);
		case 3001:
			return getUnrecognizedHandout_3001LinkLabelID(semanticHint);
		case 3002:
			return getUnrecognizedTutorialAssigned_3002LinkLabelID(semanticHint);
		case 3003:
			return getUnrecognizedTutorialPresenters_3003LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (EclipseconPackage.eINSTANCE.getHandout().equals(
				domainElementMetaclass)
				&& (domainElement != null ? isLinkWithClassHandout_3001((Handout) domainElement)
						: true)) {
			return 3001;
		} else {
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isDiagramConference_79(Conference element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodePresenter_1001(Presenter element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeTutorial_1002(Tutorial element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeSchedule_1003(Schedule element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeResource_1004(Resource element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeTimeSlot_2001(TimeSlot element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPresenter_1001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPresenter_1001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTutorial_1002ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTutorial_1002ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedSchedule_1003ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedSchedule_1003ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedResource_1004ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedResource_1004ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTimeSlot_2001ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTimeSlot_2001ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedConference_79ChildNodeID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedConference_79ChildNodeID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedHandout_3001LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTutorialAssigned_3002LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedTutorialPresenters_3003LinkLabelID(
			String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassHandout_3001(Handout element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

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
	private static class ElementSelectors {

		/**
		 * @generated
		 */
		private ElementSelectors() {
		}

		/**
		 * @generated
		 */
		static class AcceptAllMatcher {
			/**
			 * @generated
			 */
			static final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();

			/**
			 * @generated
			 */
			boolean matches(Object element) {
				return true;
			}
		}

		/**
		 * @generated
		 */
		static AcceptAllMatcher acceptAllMatcher() {
			return AcceptAllMatcher.INSTANCE;
		}
	} // end of ElementSelectors
}
