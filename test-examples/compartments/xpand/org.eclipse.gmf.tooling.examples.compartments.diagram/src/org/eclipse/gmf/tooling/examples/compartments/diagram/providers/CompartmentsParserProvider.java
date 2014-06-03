package org.eclipse.gmf.tooling.examples.compartments.diagram.providers;

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
import org.eclipse.gmf.tooling.examples.compartments.CompartmentsPackage;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_CNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfA_DNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfAffixedEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_ENameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_FNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.ChildOfB_GNumberEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeANameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.edit.parts.TopNodeBNameEditPart;
import org.eclipse.gmf.tooling.examples.compartments.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.tooling.examples.compartments.diagram.part.CompartmentsVisualIDRegistry;

/**
 * @generated
 */
public class CompartmentsParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser topNodeAName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getTopNodeAName_5003Parser() {
		if (topNodeAName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getTopNodeA_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			topNodeAName_5003Parser = parser;
		}
		return topNodeAName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser topNodeBName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getTopNodeBName_5007Parser() {
		if (topNodeBName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getTopNodeB_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			topNodeBName_5007Parser = parser;
		}
		return topNodeBName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfA_CName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfA_CName_5001Parser() {
		if (childOfA_CName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfA_C_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			childOfA_CName_5001Parser = parser;
		}
		return childOfA_CName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfA_DName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfA_DName_5002Parser() {
		if (childOfA_DName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfA_D_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			childOfA_DName_5002Parser = parser;
		}
		return childOfA_DName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfB_EName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfB_EName_5004Parser() {
		if (childOfB_EName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfB_E_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			childOfB_EName_5004Parser = parser;
		}
		return childOfB_EName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfB_GNumber_5005Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfB_GNumber_5005Parser() {
		if (childOfB_GNumber_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfB_G_Number() };
			EAttribute[] editableFeatures = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfB_G_Number() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			childOfB_GNumber_5005Parser = parser;
		}
		return childOfB_GNumber_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfAffixed_3005Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfAffixed_3005Parser() {
		if (childOfAffixed_3005Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfAffixed_Description() };
			MessageFormatParser parser = new MessageFormatParser(features);
			childOfAffixed_3005Parser = parser;
		}
		return childOfAffixed_3005Parser;
	}

	/**
	 * @generated
	 */
	private IParser childOfB_FName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getChildOfB_FName_5006Parser() {
		if (childOfB_FName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { CompartmentsPackage.eINSTANCE.getChildOfB_F_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			childOfB_FName_5006Parser = parser;
		}
		return childOfB_FName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case TopNodeANameEditPart.VISUAL_ID:
			return getTopNodeAName_5003Parser();
		case TopNodeBNameEditPart.VISUAL_ID:
			return getTopNodeBName_5007Parser();
		case ChildOfA_CNameEditPart.VISUAL_ID:
			return getChildOfA_CName_5001Parser();
		case ChildOfA_DNameEditPart.VISUAL_ID:
			return getChildOfA_DName_5002Parser();
		case ChildOfB_ENameEditPart.VISUAL_ID:
			return getChildOfB_EName_5004Parser();
		case ChildOfB_GNumberEditPart.VISUAL_ID:
			return getChildOfB_GNumber_5005Parser();
		case ChildOfAffixedEditPart.VISUAL_ID:
			return getChildOfAffixed_3005Parser();
		case ChildOfB_FNameEditPart.VISUAL_ID:
			return getChildOfB_FName_5006Parser();
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
			return getParser(CompartmentsVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(CompartmentsVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (CompartmentsElementTypes.getElement(hint) == null) {
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
