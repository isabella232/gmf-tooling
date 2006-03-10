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
	private IParser timeSlotTIMESLOTSTART_4003_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getTimeSlotTIMESLOTSTART_4003_TEXTParser() {
		if (timeSlotTIMESLOTSTART_4003_TEXTParser == null) {
			timeSlotTIMESLOTSTART_4003_TEXTParser = createTimeSlotTIMESLOTSTART_4003_TEXTParser();
		}
		return timeSlotTIMESLOTSTART_4003_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createTimeSlotTIMESLOTSTART_4003_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTimeSlot()
						.getEStructuralFeature("start"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser timeSlotTIMESLOTEND_4004_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getTimeSlotTIMESLOTEND_4004_TEXTParser() {
		if (timeSlotTIMESLOTEND_4004_TEXTParser == null) {
			timeSlotTIMESLOTEND_4004_TEXTParser = createTimeSlotTIMESLOTEND_4004_TEXTParser();
		}
		return timeSlotTIMESLOTEND_4004_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createTimeSlotTIMESLOTEND_4004_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTimeSlot()
						.getEStructuralFeature("end"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser presenterPRESENTERNAME_4001_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getPresenterPRESENTERNAME_4001_TEXTParser() {
		if (presenterPRESENTERNAME_4001_TEXTParser == null) {
			presenterPRESENTERNAME_4001_TEXTParser = createPresenterPRESENTERNAME_4001_TEXTParser();
		}
		return presenterPRESENTERNAME_4001_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createPresenterPRESENTERNAME_4001_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getParticipant()
						.getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser tutorialTUTORIALTITLE_4002_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getTutorialTUTORIALTITLE_4002_TEXTParser() {
		if (tutorialTUTORIALTITLE_4002_TEXTParser == null) {
			tutorialTUTORIALTITLE_4002_TEXTParser = createTutorialTUTORIALTITLE_4002_TEXTParser();
		}
		return tutorialTUTORIALTITLE_4002_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createTutorialTUTORIALTITLE_4002_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getTutorial()
						.getEStructuralFeature("title"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser scheduleSCHEDULEDAYNO_4005_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getScheduleSCHEDULEDAYNO_4005_TEXTParser() {
		if (scheduleSCHEDULEDAYNO_4005_TEXTParser == null) {
			scheduleSCHEDULEDAYNO_4005_TEXTParser = createScheduleSCHEDULEDAYNO_4005_TEXTParser();
		}
		return scheduleSCHEDULEDAYNO_4005_TEXTParser;
	}

	/**
	 * @generated
	 */
protected IParser createScheduleSCHEDULEDAYNO_4005_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(EclipseconPackage.eINSTANCE.getSchedule().getEStructuralFeature("dayNo"));
		parser.setViewPattern("{0,choice,'-1#XX|0#Sun|1#Mon|2#Tue|3#Wed|4#Thu|5#Fri|6#Sat|7#XX'}");
		parser.setEditPattern("{0,number}");
		return parser;
	}
	/**
	 * @generated
	 */
	private IParser resourceRESOURCENAME_4007_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCENAME_4007_TEXTParser() {
		if (resourceRESOURCENAME_4007_TEXTParser == null) {
			resourceRESOURCENAME_4007_TEXTParser = createResourceRESOURCENAME_4007_TEXTParser();
		}
		return resourceRESOURCENAME_4007_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCENAME_4007_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getResource()
						.getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceRESOURCELOCATION_4008_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCELOCATION_4008_TEXTParser() {
		if (resourceRESOURCELOCATION_4008_TEXTParser == null) {
			resourceRESOURCELOCATION_4008_TEXTParser = createResourceRESOURCELOCATION_4008_TEXTParser();
		}
		return resourceRESOURCELOCATION_4008_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCELOCATION_4008_TEXTParser() {
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
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTSTART_4003_TEXT
					.equals(viewType)) {
			return getTimeSlotTIMESLOTSTART_4003_TEXTParser();
		}
			if (EclipseconSemanticHints.TimeSlot_2001Labels.TIMESLOTEND_4004_TEXT
					.equals(viewType)) {
				return getTimeSlotTIMESLOTEND_4004_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Presenter_1001 == type) {
			if (EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001_TEXT
					.equals(viewType)) {
				return getPresenterPRESENTERNAME_4001_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Tutorial_1002 == type) {
			if (EclipseconSemanticHints.Tutorial_1002Labels.TUTORIALTITLE_4002_TEXT
					.equals(viewType)) {
				return getTutorialTUTORIALTITLE_4002_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Schedule_1003 == type) {
			if (EclipseconSemanticHints.Schedule_1003Labels.SCHEDULEDAYNO_4005_TEXT
					.equals(viewType)) {
				return getScheduleSCHEDULEDAYNO_4005_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Resource_1004 == type) {
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCENAME_4007_TEXT
					.equals(viewType)) {
				return getResourceRESOURCENAME_4007_TEXTParser();
			}
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCELOCATION_4008_TEXT
					.equals(viewType)) {
				return getResourceRESOURCELOCATION_4008_TEXTParser();
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
