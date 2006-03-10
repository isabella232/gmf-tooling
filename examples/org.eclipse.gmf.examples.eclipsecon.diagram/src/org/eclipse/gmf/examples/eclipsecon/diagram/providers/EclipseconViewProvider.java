package org.eclipse.gmf.examples.eclipsecon.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconVisualIDRegistry;

import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.AssignedViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.ConferenceViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.HandoutViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.PresenterViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Presenter_nameViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.PresentersViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.ResourceUnknownExternalNodeLabelTextViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.ResourceViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Resource_UnknownViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Resource_locationViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Resource_nameViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.ScheduleViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Schedule_dayNoViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.TimeSlotViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.TimeSlot_endViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.TimeSlot_startViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.TutorialViewFactory;
import org.eclipse.gmf.examples.eclipsecon.diagram.view.factories.Tutorial_titleViewFactory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class EclipseconViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if ("Eclipsecon".equals(diagramKind)
				&& EclipseconVisualIDRegistry.INSTANCE
						.getDiagramVisualID(semanticElement) != -1) {
			return ConferenceViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
				containerView, semanticElement, semanticType, semanticHint);

		switch (nodeVID) {
		case 1001:
			return PresenterViewFactory.class;
		case 4001:
			return Presenter_nameViewFactory.class;
		case 1002:
			return TutorialViewFactory.class;
		case 4002:
			return Tutorial_titleViewFactory.class;
		case 1003:
			return ScheduleViewFactory.class;
		case 4005:
			return Schedule_dayNoViewFactory.class;
		case 1004:
			return ResourceViewFactory.class;
		case 4006:
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCEUNKNOWN_4006_LABEL
					.equals(semanticHint)) {
				return Resource_UnknownViewFactory.class;
			} else {
				return ResourceUnknownExternalNodeLabelTextViewFactory.class;
			}
		case 4007:
			return Resource_nameViewFactory.class;
		case 4008:
			return Resource_locationViewFactory.class;
		case 2001:
			return TimeSlotViewFactory.class;
		case 4003:
			return TimeSlot_startViewFactory.class;
		case 4004:
			return TimeSlot_endViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (EclipseconElementTypes.TutorialAssigned_3002.equals(elementType)) {
			return AssignedViewFactory.class;
		}
		if (EclipseconElementTypes.TutorialPresenters_3003.equals(elementType)) {
			return PresentersViewFactory.class;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);

		int linkVID = EclipseconVisualIDRegistry.INSTANCE
				.getLinkWithClassVisualID(semanticElement, semanticType);

		switch (linkVID) {
		case 3001:
			return HandoutViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
