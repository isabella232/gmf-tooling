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
				EclipseconPackage.eINSTANCE.getPresenter()
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
	private IParser resourceRESOURCENAME_4003_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCENAME_4003_TEXTParser() {
		if (resourceRESOURCENAME_4003_TEXTParser == null) {
			resourceRESOURCENAME_4003_TEXTParser = createResourceRESOURCENAME_4003_TEXTParser();
		}
		return resourceRESOURCENAME_4003_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCENAME_4003_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getResource()
						.getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser resourceRESOURCELOCATION_4004_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getResourceRESOURCELOCATION_4004_TEXTParser() {
		if (resourceRESOURCELOCATION_4004_TEXTParser == null) {
			resourceRESOURCELOCATION_4004_TEXTParser = createResourceRESOURCELOCATION_4004_TEXTParser();
		}
		return resourceRESOURCELOCATION_4004_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createResourceRESOURCELOCATION_4004_TEXTParser() {
		EclipseconStructuralFeatureParser parser = new EclipseconStructuralFeatureParser(
				EclipseconPackage.eINSTANCE.getResource()
						.getEStructuralFeature("location"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (EclipseconElementTypes.Presenter_1001 == type) {
			if (EclipseconSemanticHints.Presenter_1001Labels.PRESENTERNAME_4001_TEXT
					.equals(viewType)) {
				return getPresenterPRESENTERNAME_4001_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Tutorial_1003 == type) {
			if (EclipseconSemanticHints.Tutorial_1003Labels.TUTORIALTITLE_4002_TEXT
					.equals(viewType)) {
				return getTutorialTUTORIALTITLE_4002_TEXTParser();
			}
		}
		if (EclipseconElementTypes.Resource_1004 == type) {
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCENAME_4003_TEXT
					.equals(viewType)) {
				return getResourceRESOURCENAME_4003_TEXTParser();
			}
			if (EclipseconSemanticHints.Resource_1004Labels.RESOURCELOCATION_4004_TEXT
					.equals(viewType)) {
				return getResourceRESOURCELOCATION_4004_TEXTParser();
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
