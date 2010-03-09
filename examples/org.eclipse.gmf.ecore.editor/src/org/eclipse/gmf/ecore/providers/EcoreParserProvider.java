/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceLowerBoundUpperBound2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceLowerBoundUpperBoundEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceName2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.ecore.parsers.EAttributeExpressionLabelParser;
import org.eclipse.gmf.ecore.parsers.MessageFormatParser;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
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
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eClassName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getEClassName_5001Parser() {
		if (eClassName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eClassName_5001Parser = parser;
		}
		return eClassName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageName_5002Parser() {
		if (ePackageName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			ePackageName_5002Parser = parser;
		}
		return ePackageName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationSource_5003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationSource_5003Parser() {
		if (eAnnotationSource_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEAnnotation_Source() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eAnnotationSource_5003Parser = parser;
		}
		return eAnnotationSource_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeName_5004Parser() {
		if (eDataTypeName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eDataTypeName_5004Parser = parser;
		}
		return eDataTypeName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumName_5005Parser() {
		if (eEnumName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnumName_5005Parser = parser;
		}
		return eEnumName_5005Parser;
	}

	/**
	 * @generated
	 */
	private EAttributeExpressionLabelParser eAttribute_3001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttribute_3001Parser() {
		if (eAttribute_3001Parser == null) {
			eAttribute_3001Parser = new EAttributeExpressionLabelParser();
		}
		return eAttribute_3001Parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperation_3002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperation_3002Parser() {
		if (eOperation_3002Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eOperation_3002Parser = parser;
		}
		return eOperation_3002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotation_3003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotation_3003Parser() {
		if (eAnnotation_3003Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEAnnotation_Source() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eAnnotation_3003Parser = parser;
		}
		return eAnnotation_3003Parser;
	}

	/**
	 * @generated
	 */
	private IParser eClass_3004Parser;

	/**
	 * @generated
	 */
	private IParser getEClass_3004Parser() {
		if (eClass_3004Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eClass_3004Parser = parser;
		}
		return eClass_3004Parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackage_3005Parser;

	/**
	 * @generated
	 */
	private IParser getEPackage_3005Parser() {
		if (ePackage_3005Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			ePackage_3005Parser = parser;
		}
		return ePackage_3005Parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataType_3006Parser;

	/**
	 * @generated
	 */
	private IParser getEDataType_3006Parser() {
		if (eDataType_3006Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eDataType_3006Parser = parser;
		}
		return eDataType_3006Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnum_3007Parser;

	/**
	 * @generated
	 */
	private IParser getEEnum_3007Parser() {
		if (eEnum_3007Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnum_3007Parser = parser;
		}
		return eEnum_3007Parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntry_3008Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntry_3008Parser() {
		if (eStringToStringMapEntry_3008Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key(), EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} : {1}"); //$NON-NLS-1$
			eStringToStringMapEntry_3008Parser = parser;
		}
		return eStringToStringMapEntry_3008Parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteral_3009Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteral_3009Parser() {
		if (eEnumLiteral_3009Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eEnumLiteral_3009Parser = parser;
		}
		return eEnumLiteral_3009Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceName_6001Parser() {
		if (eReferenceName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eReferenceName_6001Parser = parser;
		}
		return eReferenceName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceLowerBoundUpperBound_6003Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceLowerBoundUpperBound_6003Parser() {
		if (eReferenceLowerBoundUpperBound_6003Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getETypedElement_LowerBound(), EcorePackage.eINSTANCE.getETypedElement_UpperBound() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1,choice,-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			eReferenceLowerBoundUpperBound_6003Parser = parser;
		}
		return eReferenceLowerBoundUpperBound_6003Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceName_6002Parser() {
		if (eReferenceName_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eReferenceName_6002Parser = parser;
		}
		return eReferenceName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceLowerBoundUpperBound_6004Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceLowerBoundUpperBound_6004Parser() {
		if (eReferenceLowerBoundUpperBound_6004Parser == null) {
			EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getETypedElement_LowerBound(), EcorePackage.eINSTANCE.getETypedElement_UpperBound() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1,choice,-1#*|-1<{1}}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			eReferenceLowerBoundUpperBound_6004Parser = parser;
		}
		return eReferenceLowerBoundUpperBound_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EClassNameEditPart.VISUAL_ID:
			return getEClassName_5001Parser();
		case EPackageNameEditPart.VISUAL_ID:
			return getEPackageName_5002Parser();
		case EAnnotationSourceEditPart.VISUAL_ID:
			return getEAnnotationSource_5003Parser();
		case EDataTypeNameEditPart.VISUAL_ID:
			return getEDataTypeName_5004Parser();
		case EEnumNameEditPart.VISUAL_ID:
			return getEEnumName_5005Parser();
		case EAttributeEditPart.VISUAL_ID:
			return getEAttribute_3001Parser();
		case EOperationEditPart.VISUAL_ID:
			return getEOperation_3002Parser();
		case EAnnotation2EditPart.VISUAL_ID:
			return getEAnnotation_3003Parser();
		case EClass2EditPart.VISUAL_ID:
			return getEClass_3004Parser();
		case EPackage3EditPart.VISUAL_ID:
			return getEPackage_3005Parser();
		case EDataType2EditPart.VISUAL_ID:
			return getEDataType_3006Parser();
		case EEnum2EditPart.VISUAL_ID:
			return getEEnum_3007Parser();
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntry_3008Parser();
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteral_3009Parser();
		case EReferenceNameEditPart.VISUAL_ID:
			return getEReferenceName_6001Parser();
		case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
			return getEReferenceLowerBoundUpperBound_6003Parser();
		case EReferenceName2EditPart.VISUAL_ID:
			return getEReferenceName_6002Parser();
		case EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID:
			return getEReferenceLowerBoundUpperBound_6004Parser();
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
			return getParser(EcoreVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EcoreVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EcoreElementTypes.getElement(hint) == null) {
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
