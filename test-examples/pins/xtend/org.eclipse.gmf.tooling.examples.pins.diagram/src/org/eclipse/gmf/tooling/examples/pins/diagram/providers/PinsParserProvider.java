package org.eclipse.gmf.tooling.examples.pins.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.pins.PinsPackage;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.ChangeableColorPinBlueEditPart;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.ChangeableColorPinGreenEditPart;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.ChangeableColorPinRedEditPart;
import org.eclipse.gmf.tooling.examples.pins.diagram.edit.parts.VisiblePinWarningLabelEditPart;
import org.eclipse.gmf.tooling.examples.pins.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.tooling.examples.pins.diagram.part.PinsVisualIDRegistry;

/**
 * @generated
 */
public class PinsParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser visiblePinWarningLabel_5001Parser;

	/**
	 * @generated
	 */
	private IParser getVisiblePinWarningLabel_5001Parser() {
		if (visiblePinWarningLabel_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { PinsPackage.eINSTANCE.getVisiblePin_WarningLabel() };
			MessageFormatParser parser = new MessageFormatParser(features);
			visiblePinWarningLabel_5001Parser = parser;
		}
		return visiblePinWarningLabel_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser changeableColorPinRed_5002Parser;

	/**
	 * @generated
	 */
	private IParser getChangeableColorPinRed_5002Parser() {
		if (changeableColorPinRed_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Red() };
			EAttribute[] editableFeatures = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Red() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			changeableColorPinRed_5002Parser = parser;
		}
		return changeableColorPinRed_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser changeableColorPinGreen_5003Parser;

	/**
	 * @generated
	 */
	private IParser getChangeableColorPinGreen_5003Parser() {
		if (changeableColorPinGreen_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Green() };
			EAttribute[] editableFeatures = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Green() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			changeableColorPinGreen_5003Parser = parser;
		}
		return changeableColorPinGreen_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser changeableColorPinBlue_5004Parser;

	/**
	 * @generated
	 */
	private IParser getChangeableColorPinBlue_5004Parser() {
		if (changeableColorPinBlue_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Blue() };
			EAttribute[] editableFeatures = new EAttribute[] { PinsPackage.eINSTANCE.getChangeableColorPin_Blue() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			changeableColorPinBlue_5004Parser = parser;
		}
		return changeableColorPinBlue_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case VisiblePinWarningLabelEditPart.VISUAL_ID:
			return getVisiblePinWarningLabel_5001Parser();
		case ChangeableColorPinRedEditPart.VISUAL_ID:
			return getChangeableColorPinRed_5002Parser();
		case ChangeableColorPinGreenEditPart.VISUAL_ID:
			return getChangeableColorPinGreen_5003Parser();
		case ChangeableColorPinBlueEditPart.VISUAL_ID:
			return getChangeableColorPinBlue_5004Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PinsVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PinsVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (PinsElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
