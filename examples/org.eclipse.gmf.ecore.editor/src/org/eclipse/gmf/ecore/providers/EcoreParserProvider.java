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

import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_sourceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

/**
 * @generated
 */
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eAttributeEAttribute_2001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEAttribute_2001Parser() {
		if (eAttributeEAttribute_2001Parser == null) {
			eAttributeEAttribute_2001Parser = createEAttributeEAttribute_2001Parser();
		}
		return eAttributeEAttribute_2001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEAttribute_2001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOperation_2002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOperation_2002Parser() {
		if (eOperationEOperation_2002Parser == null) {
			eOperationEOperation_2002Parser = createEOperationEOperation_2002Parser();
		}
		return eOperationEOperation_2002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOperation_2002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEAnnotation_2003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEAnnotation_2003Parser() {
		if (eAnnotationEAnnotation_2003Parser == null) {
			eAnnotationEAnnotation_2003Parser = createEAnnotationEAnnotation_2003Parser();
		}
		return eAnnotationEAnnotation_2003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEAnnotation_2003Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassEClass_2004Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClass_2004Parser() {
		if (eClassEClass_2004Parser == null) {
			eClassEClass_2004Parser = createEClassEClass_2004Parser();
		}
		return eClassEClass_2004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClass_2004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackage_2005Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackage_2005Parser() {
		if (ePackageEPackage_2005Parser == null) {
			ePackageEPackage_2005Parser = createEPackageEPackage_2005Parser();
		}
		return ePackageEPackage_2005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackage_2005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataType_2006Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataType_2006Parser() {
		if (eDataTypeEDataType_2006Parser == null) {
			eDataTypeEDataType_2006Parser = createEDataTypeEDataType_2006Parser();
		}
		return eDataTypeEDataType_2006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataType_2006Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnum_2007Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnum_2007Parser() {
		if (eEnumEEnum_2007Parser == null) {
			eEnumEEnum_2007Parser = createEEnumEEnum_2007Parser();
		}
		return eEnumEEnum_2007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnum_2007Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryEStringToStringMapEntry_2008Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryEStringToStringMapEntry_2008Parser() {
		if (eStringToStringMapEntryEStringToStringMapEntry_2008Parser == null) {
			eStringToStringMapEntryEStringToStringMapEntry_2008Parser = createEStringToStringMapEntryEStringToStringMapEntry_2008Parser();
		}
		return eStringToStringMapEntryEStringToStringMapEntry_2008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryEStringToStringMapEntry_2008Parser() {
		List features = new ArrayList(2);
		features.add(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		features.add(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("value"));
		EcoreStructuralFeaturesParser parser = new EcoreStructuralFeaturesParser(features);
		parser.setViewPattern("{0} : {1}");
		parser.setEditPattern("{0} : {1}");
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEEnumLiteral_2009Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEEnumLiteral_2009Parser() {
		if (eEnumLiteralEEnumLiteral_2009Parser == null) {
			eEnumLiteralEEnumLiteral_2009Parser = createEEnumLiteralEEnumLiteral_2009Parser();
		}
		return eEnumLiteralEEnumLiteral_2009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEEnumLiteral_2009Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassEClassName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClassName_4001Parser() {
		if (eClassEClassName_4001Parser == null) {
			eClassEClassName_4001Parser = createEClassEClassName_4001Parser();
		}
		return eClassEClassName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClassName_4001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackageName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackageName_4002Parser() {
		if (ePackageEPackageName_4002Parser == null) {
			ePackageEPackageName_4002Parser = createEPackageEPackageName_4002Parser();
		}
		return ePackageEPackageName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackageName_4002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEAnnotationSource_4003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEAnnotationSource_4003Parser() {
		if (eAnnotationEAnnotationSource_4003Parser == null) {
			eAnnotationEAnnotationSource_4003Parser = createEAnnotationEAnnotationSource_4003Parser();
		}
		return eAnnotationEAnnotationSource_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEAnnotationSource_4003Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataTypeName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataTypeName_4004Parser() {
		if (eDataTypeEDataTypeName_4004Parser == null) {
			eDataTypeEDataTypeName_4004Parser = createEDataTypeEDataTypeName_4004Parser();
		}
		return eDataTypeEDataTypeName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataTypeName_4004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnumName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnumName_4005Parser() {
		if (eEnumEEnumName_4005Parser == null) {
			eEnumEEnumName_4005Parser = createEEnumEEnumName_4005Parser();
		}
		return eEnumEEnumName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnumName_4005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_4006Parser() {
		if (eReferenceEReferenceName_4006Parser == null) {
			eReferenceEReferenceName_4006Parser = createEReferenceEReferenceName_4006Parser();
		}
		return eReferenceEReferenceName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_4006Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_4007Parser() {
		if (eReferenceEReferenceName_4007Parser == null) {
			eReferenceEReferenceName_4007Parser = createEReferenceEReferenceName_4007Parser();
		}
		return eReferenceEReferenceName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_4007Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EAttributeEditPart.VISUAL_ID:
			return getEAttributeEAttribute_2001Parser();
		case EOperationEditPart.VISUAL_ID:
			return getEOperationEOperation_2002Parser();
		case EAnnotationEditPart.VISUAL_ID:
			return getEAnnotationEAnnotation_2003Parser();
		case EClass2EditPart.VISUAL_ID:
			return getEClassEClass_2004Parser();
		case EPackage3EditPart.VISUAL_ID:
			return getEPackageEPackage_2005Parser();
		case EDataTypeEditPart.VISUAL_ID:
			return getEDataTypeEDataType_2006Parser();
		case EEnumEditPart.VISUAL_ID:
			return getEEnumEEnum_2007Parser();
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getEStringToStringMapEntryEStringToStringMapEntry_2008Parser();
		case EEnumLiteralEditPart.VISUAL_ID:
			return getEEnumLiteralEEnumLiteral_2009Parser();
		case EClass_nameEditPart.VISUAL_ID:
			return getEClassEClassName_4001Parser();
		case EPackage_nameEditPart.VISUAL_ID:
			return getEPackageEPackageName_4002Parser();
		case EAnnotation_sourceEditPart.VISUAL_ID:
			return getEAnnotationEAnnotationSource_4003Parser();
		case EDataType_nameEditPart.VISUAL_ID:
			return getEDataTypeEDataTypeName_4004Parser();
		case EEnum_nameEditPart.VISUAL_ID:
			return getEEnumEEnumName_4005Parser();
		case EReference_nameEditPart.VISUAL_ID:
			return getEReferenceEReferenceName_4006Parser();
		case EReference_name2EditPart.VISUAL_ID:
			return getEReferenceEReferenceName_4007Parser();
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
