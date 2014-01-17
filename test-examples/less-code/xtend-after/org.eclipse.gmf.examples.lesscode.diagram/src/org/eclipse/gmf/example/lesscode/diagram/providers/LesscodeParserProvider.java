package org.eclipse.gmf.example.lesscode.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class LesscodeParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser subjectName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getSubjectName_5002Parser() {
		if (subjectName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { LesscodePackage.eINSTANCE.getWithSomeAttributes_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			subjectName_5002Parser = parser;
		}
		return subjectName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser oneContainmentGroupName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getOneContainmentGroupName_5004Parser() {
		if (oneContainmentGroupName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { LesscodePackage.eINSTANCE.getWithSomeAttributes_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			oneContainmentGroupName_5004Parser = parser;
		}
		return oneContainmentGroupName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiContainmentGroupName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getMultiContainmentGroupName_5007Parser() {
		if (multiContainmentGroupName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { LesscodePackage.eINSTANCE.getWithSomeAttributes_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			multiContainmentGroupName_5007Parser = parser;
		}
		return multiContainmentGroupName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SubjectNameEditPart.VISUAL_ID:
			return getSubjectName_5002Parser();
		case OneContainmentGroupNameEditPart.VISUAL_ID:
			return getOneContainmentGroupName_5004Parser();
		case MultiContainmentGroupNameEditPart.VISUAL_ID:
			return getMultiContainmentGroupName_5007Parser();
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
			return getParser(LesscodeVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(LesscodeVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (LesscodeElementTypes.getElement(hint) == null) {
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
