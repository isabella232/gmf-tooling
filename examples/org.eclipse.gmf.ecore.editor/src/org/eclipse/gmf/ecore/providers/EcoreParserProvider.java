/*
 * Copyright (c) 2006, 2007 Borland Software Corp.
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
import org.eclipse.gmf.ecore.parsers.MessageFormatParser;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
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
			eClassName_5001Parser = createEClassName_5001Parser();
		}
		return eClassName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassName_5001Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			ePackageName_5002Parser = createEPackageName_5002Parser();
		}
		return ePackageName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageName_5002Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eAnnotationSource_5003Parser = createEAnnotationSource_5003Parser();
		}
		return eAnnotationSource_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationSource_5003Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEAnnotation_Source(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eDataTypeName_5004Parser = createEDataTypeName_5004Parser();
		}
		return eDataTypeName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeName_5004Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eEnumName_5005Parser = createEEnumName_5005Parser();
		}
		return eEnumName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumName_5005Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAttribute_3001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttribute_3001Parser() {
		if (eAttribute_3001Parser == null) {
			eAttribute_3001Parser = createEAttribute_3001Parser();
		}
		return eAttribute_3001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttribute_3001Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eOperation_3002Parser = createEOperation_3002Parser();
		}
		return eOperation_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperation_3002Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eAnnotation_3003Parser = createEAnnotation_3003Parser();
		}
		return eAnnotation_3003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotation_3003Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEAnnotation_Source(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eClass_3004Parser = createEClass_3004Parser();
		}
		return eClass_3004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClass_3004Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			ePackage_3005Parser = createEPackage_3005Parser();
		}
		return ePackage_3005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackage_3005Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eDataType_3006Parser = createEDataType_3006Parser();
		}
		return eDataType_3006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataType_3006Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eEnum_3007Parser = createEEnum_3007Parser();
		}
		return eEnum_3007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnum_3007Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eStringToStringMapEntry_3008Parser = createEStringToStringMapEntry_3008Parser();
		}
		return eStringToStringMapEntry_3008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntry_3008Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key(), EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0} : {1}");
		parser.setEditorPattern("{0} : {1}");
		parser.setEditPattern("{0} : {1}");
		return parser;
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
			eEnumLiteral_3009Parser = createEEnumLiteral_3009Parser();
		}
		return eEnumLiteral_3009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteral_3009Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eReferenceName_6001Parser = createEReferenceName_6001Parser();
		}
		return eReferenceName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceName_6001Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eReferenceLowerBoundUpperBound_6003Parser = createEReferenceLowerBoundUpperBound_6003Parser();
		}
		return eReferenceLowerBoundUpperBound_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceLowerBoundUpperBound_6003Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getETypedElement_LowerBound(), EcorePackage.eINSTANCE.getETypedElement_UpperBound(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditorPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditPattern("{0}..{1}");
		return parser;
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
			eReferenceName_6002Parser = createEReferenceName_6002Parser();
		}
		return eReferenceName_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceName_6002Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getENamedElement_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}");
		parser.setEditorPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
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
			eReferenceLowerBoundUpperBound_6004Parser = createEReferenceLowerBoundUpperBound_6004Parser();
		}
		return eReferenceLowerBoundUpperBound_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceLowerBoundUpperBound_6004Parser() {
		EAttribute[] features = new EAttribute[] { EcorePackage.eINSTANCE.getETypedElement_LowerBound(), EcorePackage.eINSTANCE.getETypedElement_UpperBound(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditorPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditPattern("{0}..{1}");
		return parser;
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
	public static class HintAdapter extends ParserHintAdapter {

		private final IElementType elementType;

		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
