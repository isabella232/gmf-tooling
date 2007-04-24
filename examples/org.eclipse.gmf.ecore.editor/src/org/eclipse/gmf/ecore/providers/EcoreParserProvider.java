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
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import java.util.ArrayList;
import java.util.List;

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

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eAttributeEAttribute_3001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEAttribute_3001Parser() {
		if (eAttributeEAttribute_3001Parser == null) {
			eAttributeEAttribute_3001Parser = createEAttributeEAttribute_3001Parser();
		}
		return eAttributeEAttribute_3001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEAttribute_3001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOperation_3002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOperation_3002Parser() {
		if (eOperationEOperation_3002Parser == null) {
			eOperationEOperation_3002Parser = createEOperationEOperation_3002Parser();
		}
		return eOperationEOperation_3002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOperation_3002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEAnnotation_3003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEAnnotation_3003Parser() {
		if (eAnnotationEAnnotation_3003Parser == null) {
			eAnnotationEAnnotation_3003Parser = createEAnnotationEAnnotation_3003Parser();
		}
		return eAnnotationEAnnotation_3003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEAnnotation_3003Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation_Source());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassEClass_3004Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClass_3004Parser() {
		if (eClassEClass_3004Parser == null) {
			eClassEClass_3004Parser = createEClassEClass_3004Parser();
		}
		return eClassEClass_3004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClass_3004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackage_3005Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackage_3005Parser() {
		if (ePackageEPackage_3005Parser == null) {
			ePackageEPackage_3005Parser = createEPackageEPackage_3005Parser();
		}
		return ePackageEPackage_3005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackage_3005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataType_3006Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataType_3006Parser() {
		if (eDataTypeEDataType_3006Parser == null) {
			eDataTypeEDataType_3006Parser = createEDataTypeEDataType_3006Parser();
		}
		return eDataTypeEDataType_3006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataType_3006Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnum_3007Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnum_3007Parser() {
		if (eEnumEEnum_3007Parser == null) {
			eEnumEEnum_3007Parser = createEEnumEEnum_3007Parser();
		}
		return eEnumEEnum_3007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnum_3007Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryEStringToStringMapEntry_3008Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryEStringToStringMapEntry_3008Parser() {
		if (eStringToStringMapEntryEStringToStringMapEntry_3008Parser == null) {
			eStringToStringMapEntryEStringToStringMapEntry_3008Parser = createEStringToStringMapEntryEStringToStringMapEntry_3008Parser();
		}
		return eStringToStringMapEntryEStringToStringMapEntry_3008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryEStringToStringMapEntry_3008Parser() {
		List features = new ArrayList(2);
		features.add(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key());
		features.add(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value());
		EcoreStructuralFeaturesParser parser = new EcoreStructuralFeaturesParser(features);
		parser.setViewPattern("{0} : {1}");
		parser.setEditPattern("{0} : {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEEnumLiteral_3009Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEEnumLiteral_3009Parser() {
		if (eEnumLiteralEEnumLiteral_3009Parser == null) {
			eEnumLiteralEEnumLiteral_3009Parser = createEEnumLiteralEEnumLiteral_3009Parser();
		}
		return eEnumLiteralEEnumLiteral_3009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEEnumLiteral_3009Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassEClassName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClassName_5001Parser() {
		if (eClassEClassName_5001Parser == null) {
			eClassEClassName_5001Parser = createEClassEClassName_5001Parser();
		}
		return eClassEClassName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClassName_5001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackageName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackageName_5002Parser() {
		if (ePackageEPackageName_5002Parser == null) {
			ePackageEPackageName_5002Parser = createEPackageEPackageName_5002Parser();
		}
		return ePackageEPackageName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackageName_5002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEAnnotationSource_5003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEAnnotationSource_5003Parser() {
		if (eAnnotationEAnnotationSource_5003Parser == null) {
			eAnnotationEAnnotationSource_5003Parser = createEAnnotationEAnnotationSource_5003Parser();
		}
		return eAnnotationEAnnotationSource_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEAnnotationSource_5003Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation_Source());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataTypeName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataTypeName_5004Parser() {
		if (eDataTypeEDataTypeName_5004Parser == null) {
			eDataTypeEDataTypeName_5004Parser = createEDataTypeEDataTypeName_5004Parser();
		}
		return eDataTypeEDataTypeName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataTypeName_5004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnumName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnumName_5005Parser() {
		if (eEnumEEnumName_5005Parser == null) {
			eEnumEEnumName_5005Parser = createEEnumEEnumName_5005Parser();
		}
		return eEnumEEnumName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnumName_5005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_6001Parser() {
		if (eReferenceEReferenceName_6001Parser == null) {
			eReferenceEReferenceName_6001Parser = createEReferenceEReferenceName_6001Parser();
		}
		return eReferenceEReferenceName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_6001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceLowerBoundUpperBound_6003Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceLowerBoundUpperBound_6003Parser() {
		if (eReferenceEReferenceLowerBoundUpperBound_6003Parser == null) {
			eReferenceEReferenceLowerBoundUpperBound_6003Parser = createEReferenceEReferenceLowerBoundUpperBound_6003Parser();
		}
		return eReferenceEReferenceLowerBoundUpperBound_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceLowerBoundUpperBound_6003Parser() {
		List features = new ArrayList(2);
		features.add(EcorePackage.eINSTANCE.getETypedElement_LowerBound());
		features.add(EcorePackage.eINSTANCE.getETypedElement_UpperBound());
		EcoreStructuralFeaturesParser parser = new EcoreStructuralFeaturesParser(features);
		parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditPattern("{0}..{1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_6002Parser() {
		if (eReferenceEReferenceName_6002Parser == null) {
			eReferenceEReferenceName_6002Parser = createEReferenceEReferenceName_6002Parser();
		}
		return eReferenceEReferenceName_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_6002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement_Name());
		parser.setViewPattern("{0}");
		parser.setEditPattern("{0}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceLowerBoundUpperBound_6004Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceLowerBoundUpperBound_6004Parser() {
		if (eReferenceEReferenceLowerBoundUpperBound_6004Parser == null) {
			eReferenceEReferenceLowerBoundUpperBound_6004Parser = createEReferenceEReferenceLowerBoundUpperBound_6004Parser();
		}
		return eReferenceEReferenceLowerBoundUpperBound_6004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceLowerBoundUpperBound_6004Parser() {
		List features = new ArrayList(2);
		features.add(EcorePackage.eINSTANCE.getETypedElement_LowerBound());
		features.add(EcorePackage.eINSTANCE.getETypedElement_UpperBound());
		EcoreStructuralFeaturesParser parser = new EcoreStructuralFeaturesParser(features);
		parser.setViewPattern("{0}..{1,choice,-1#*|-1<{1}}");
		parser.setEditPattern("{0}..{1}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EAttributeEditPart.VISUAL_ID:
			return getEAttributeEAttribute_3001Parser();
		case EOperationEditPart.VISUAL_ID:
			return getEOperationEOperation_3002Parser();
		case EAnnotation2EditPart.VISUAL_ID:
			return getEAnnotationEAnnotation_3003Parser();
		case EClass2EditPart.VISUAL_ID:
			return getEClassEClass_3004Parser();
		case EPackage3EditPart.VISUAL_ID:
			return getEPackageEPackage_3005Parser();
		case EDataType2EditPart.VISUAL_ID:
			return getEDataTypeEDataType_3006Parser();
		case EEnum2EditPart.VISUAL_ID:
			return getEEnumEEnum_3007Parser();
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntryEStringToStringMapEntry_3008Parser();
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteralEEnumLiteral_3009Parser();
		case EClassNameEditPart.VISUAL_ID:
			return getEClassEClassName_5001Parser();
		case EPackageNameEditPart.VISUAL_ID:
			return getEPackageEPackageName_5002Parser();
		case EAnnotationSourceEditPart.VISUAL_ID:
			return getEAnnotationEAnnotationSource_5003Parser();
		case EDataTypeNameEditPart.VISUAL_ID:
			return getEDataTypeEDataTypeName_5004Parser();
		case EEnumNameEditPart.VISUAL_ID:
			return getEEnumEEnumName_5005Parser();
		case EReferenceNameEditPart.VISUAL_ID:
			return getEReferenceEReferenceName_6001Parser();
		case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
			return getEReferenceEReferenceLowerBoundUpperBound_6003Parser();
		case EReferenceName2EditPart.VISUAL_ID:
			return getEReferenceEReferenceName_6002Parser();
		case EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID:
			return getEReferenceEReferenceLowerBoundUpperBound_6004Parser();
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
}
