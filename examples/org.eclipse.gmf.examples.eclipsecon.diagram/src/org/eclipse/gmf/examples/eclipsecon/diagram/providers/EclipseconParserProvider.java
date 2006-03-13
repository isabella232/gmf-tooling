package org.eclipse.gmf.examples.eclipsecon.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;

/**
 * @generated
 */
public class EclipseconParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser timeSlotTIMESLOTSTART_4003Parser;

	/**
	 * @generated
	 */
	private IParser getTimeSlotTIMESLOTSTART_4003Parser() {
		if (timeSlotTIMESLOTSTART_4003Parser == null) {
			timeSlotTIMESLOTSTART_4003Parser = createTimeSlotTIMESLOTSTART_4003Parser();
		}
		return timeSlotTIMESLOTSTART_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTimeSlotTIMESLOTSTART_4003Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTimeSlot()
						.getEStructuralFeature("start"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser timeSlotTIMESLOTEND_4004Parser;

	/**
	 * @generated
	 */
	private IParser getTimeSlotTIMESLOTEND_4004Parser() {
		if (timeSlotTIMESLOTEND_4004Parser == null) {
			timeSlotTIMESLOTEND_4004Parser = createTimeSlotTIMESLOTEND_4004Parser();
		}
		return timeSlotTIMESLOTEND_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTimeSlotTIMESLOTEND_4004Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTimeSlot()
						.getEStructuralFeature("end"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser presenterPRESENTERNAME_4001Parser;

	/**
	 * @generated
	 */
	private IParser getPresenterPRESENTERNAME_4001Parser() {
		if (presenterPRESENTERNAME_4001Parser == null) {
			presenterPRESENTERNAME_4001Parser = createPresenterPRESENTERNAME_4001Parser();
		}
		return presenterPRESENTERNAME_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPresenterPRESENTERNAME_4001Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getParticipant()
						.getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser tutorialTUTORIALTITLE_4002Parser;

	/**
	 * @generated
	 */
	private IParser getTutorialTUTORIALTITLE_4002Parser() {
		if (tutorialTUTORIALTITLE_4002Parser == null) {
			tutorialTUTORIALTITLE_4002Parser = createTutorialTUTORIALTITLE_4002Parser();
		}
		return tutorialTUTORIALTITLE_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTutorialTUTORIALTITLE_4002Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTutorial()
						.getEStructuralFeature("title"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser scheduleSCHEDULEDAYNO_4005Parser;

	/**
	 * @generated
	 */
	private IParser getScheduleSCHEDULEDAYNO_4005Parser() {
		if (scheduleSCHEDULEDAYNO_4005Parser == null) {
			scheduleSCHEDULEDAYNO_4005Parser = createScheduleSCHEDULEDAYNO_4005Parser();
		}
		return scheduleSCHEDULEDAYNO_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createScheduleSCHEDULEDAYNO_4005Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getSchedule()
						.getEStructuralFeature("dayNo"));
		parser
				.setViewPattern("{0,choice,-1#XX|0#Sun|1#Mon|2#Tue|3#Wed|4#Thu|5#Fri|6#Sat|7#XX}");
		parser.setEditPattern("{0,number}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceRESOURCENAME_4007Parser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCENAME_4007Parser() {
		if (resourceRESOURCENAME_4007Parser == null) {
			resourceRESOURCENAME_4007Parser = createResourceRESOURCENAME_4007Parser();
		}
		return resourceRESOURCENAME_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCENAME_4007Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getResource()
						.getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceRESOURCELOCATION_4008Parser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCELOCATION_4008Parser() {
		if (resourceRESOURCELOCATION_4008Parser == null) {
			resourceRESOURCELOCATION_4008Parser = createResourceRESOURCELOCATION_4008Parser();
		}
		return resourceRESOURCELOCATION_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCELOCATION_4008Parser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getResource()
						.getEStructuralFeature("location"));
		parser.setViewPattern("uri: {0}");
		parser.setEditPattern("uri: {0}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (EclipseconElementTypes.TimeSlot_2001 == type) {
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTSTART_4003
					.equals(viewType)) {
				return getTimeSlotTIMESLOTSTART_4003Parser();
			}
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTEND_4004
					.equals(viewType)) {
				return getTimeSlotTIMESLOTEND_4004Parser();
			}
		}
		if (EclipseconElementTypes.Presenter_1001 == type) {
			if (EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001
					.equals(viewType)) {
				return getPresenterPRESENTERNAME_4001Parser();
			}
		}
		if (EclipseconElementTypes.Tutorial_1002 == type) {
			if (EclipseconSemanticHints.Tutorial_1002Labels.TUTORIALTITLE_4002
					.equals(viewType)) {
				return getTutorialTUTORIALTITLE_4002Parser();
			}
		}
		if (EclipseconElementTypes.Schedule_1003 == type) {
			if (EclipseconSemanticHints.Schedule_1003Labels.SCHEDULEDAYNO_4005
					.equals(viewType)) {
				return getScheduleSCHEDULEDAYNO_4005Parser();
			}
		}
		if (EclipseconElementTypes.Resource_1004 == type) {
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCENAME_4007
					.equals(viewType)) {
				return getResourceRESOURCENAME_4007Parser();
			}
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCELOCATION_4008
					.equals(viewType)) {
				return getResourceRESOURCELOCATION_4008Parser();
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String viewType = (String) hint.getAdapter(String.class);
		IElementType type = (IElementType) hint.getAdapter(IElementType.class);
		if (type == null) {
			EObject element = (EObject) hint.getAdapter(EObject.class);
			type = ElementTypeRegistry.getInstance().getElementType(element);
		}
		return getParser(type, viewType);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			return getParser(((GetParserOperation) operation).getHint()) != null;
		}
		return false;
	}
}
