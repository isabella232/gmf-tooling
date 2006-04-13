package org.eclipse.gmf.ecore.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation_source2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_nameEditPart;

/**
 * @generated
 */
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eAttributeEAttributeName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEAttributeName_4001Parser() {
		if (eAttributeEAttributeName_4001Parser == null) {
			eAttributeEAttributeName_4001Parser = createEAttributeEAttributeName_4001Parser();
		}
		return eAttributeEAttributeName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEAttributeName_4001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOperationName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOperationName_4002Parser() {
		if (eOperationEOperationName_4002Parser == null) {
			eOperationEOperationName_4002Parser = createEOperationEOperationName_4002Parser();
		}
		return eOperationEOperationName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOperationName_4002Parser() {
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
	private IParser eClassEClassName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClassName_4005Parser() {
		if (eClassEClassName_4005Parser == null) {
			eClassEClassName_4005Parser = createEClassEClassName_4005Parser();
		}
		return eClassEClassName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClassName_4005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackageName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackageName_4006Parser() {
		if (ePackageEPackageName_4006Parser == null) {
			ePackageEPackageName_4006Parser = createEPackageEPackageName_4006Parser();
		}
		return ePackageEPackageName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackageName_4006Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataTypeName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataTypeName_4007Parser() {
		if (eDataTypeEDataTypeName_4007Parser == null) {
			eDataTypeEDataTypeName_4007Parser = createEDataTypeEDataTypeName_4007Parser();
		}
		return eDataTypeEDataTypeName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataTypeName_4007Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnumName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnumName_4008Parser() {
		if (eEnumEEnumName_4008Parser == null) {
			eEnumEEnumName_4008Parser = createEEnumEEnumName_4008Parser();
		}
		return eEnumEEnumName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnumName_4008Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryEStringToStringMapEntryKey_4010Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryEStringToStringMapEntryKey_4010Parser() {
		if (eStringToStringMapEntryEStringToStringMapEntryKey_4010Parser == null) {
			eStringToStringMapEntryEStringToStringMapEntryKey_4010Parser = createEStringToStringMapEntryEStringToStringMapEntryKey_4010Parser();
		}
		return eStringToStringMapEntryEStringToStringMapEntryKey_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryEStringToStringMapEntryKey_4010Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEEnumLiteralName_4013Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEEnumLiteralName_4013Parser() {
		if (eEnumLiteralEEnumLiteralName_4013Parser == null) {
			eEnumLiteralEEnumLiteralName_4013Parser = createEEnumLiteralEEnumLiteralName_4013Parser();
		}
		return eEnumLiteralEEnumLiteralName_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEEnumLiteralName_4013Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassEClassName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getEClassEClassName_4004Parser() {
		if (eClassEClassName_4004Parser == null) {
			eClassEClassName_4004Parser = createEClassEClassName_4004Parser();
		}
		return eClassEClassName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassEClassName_4004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPackageName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPackageName_4009Parser() {
		if (ePackageEPackageName_4009Parser == null) {
			ePackageEPackageName_4009Parser = createEPackageEPackageName_4009Parser();
		}
		return ePackageEPackageName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPackageName_4009Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEAnnotationSource_4011Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEAnnotationSource_4011Parser() {
		if (eAnnotationEAnnotationSource_4011Parser == null) {
			eAnnotationEAnnotationSource_4011Parser = createEAnnotationEAnnotationSource_4011Parser();
		}
		return eAnnotationEAnnotationSource_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEAnnotationSource_4011Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDataTypeName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDataTypeName_4012Parser() {
		if (eDataTypeEDataTypeName_4012Parser == null) {
			eDataTypeEDataTypeName_4012Parser = createEDataTypeEDataTypeName_4012Parser();
		}
		return eDataTypeEDataTypeName_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDataTypeName_4012Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEEnumName_4014Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEEnumName_4014Parser() {
		if (eEnumEEnumName_4014Parser == null) {
			eEnumEEnumName_4014Parser = createEEnumEEnumName_4014Parser();
		}
		return eEnumEEnumName_4014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEEnumName_4014Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_4015Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_4015Parser() {
		if (eReferenceEReferenceName_4015Parser == null) {
			eReferenceEReferenceName_4015Parser = createEReferenceEReferenceName_4015Parser();
		}
		return eReferenceEReferenceName_4015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_4015Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEReferenceName_4016Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEReferenceName_4016Parser() {
		if (eReferenceEReferenceName_4016Parser == null) {
			eReferenceEReferenceName_4016Parser = createEReferenceEReferenceName_4016Parser();
		}
		return eReferenceEReferenceName_4016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEReferenceName_4016Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (EcoreElementTypes.EAttribute_2001 == type) {
			return getEAttributeEAttributeName_4001Parser();
		}
		if (EcoreElementTypes.EOperation_2002 == type) {
			return getEOperationEOperationName_4002Parser();
		}
		if (EcoreElementTypes.EAnnotation_2003 == type) {
			return getEAnnotationEAnnotationSource_4003Parser();
		}
		if (EcoreElementTypes.EClass_2004 == type) {
			return getEClassEClassName_4005Parser();
		}
		if (EcoreElementTypes.EPackage_2005 == type) {
			return getEPackageEPackageName_4006Parser();
		}
		if (EcoreElementTypes.EDataType_2006 == type) {
			return getEDataTypeEDataTypeName_4007Parser();
		}
		if (EcoreElementTypes.EEnum_2007 == type) {
			return getEEnumEEnumName_4008Parser();
		}
		if (EcoreElementTypes.EStringToStringMapEntry_2008 == type) {
			return getEStringToStringMapEntryEStringToStringMapEntryKey_4010Parser();
		}
		if (EcoreElementTypes.EEnumLiteral_2009 == type) {
			return getEEnumLiteralEEnumLiteralName_4013Parser();
		}
		if (EcoreElementTypes.EClass_1001 == type) {
			if (EClass_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getEClassEClassName_4004Parser();
			}
		}
		if (EcoreElementTypes.EPackage_1002 == type) {
			if (EPackage_name2EditPart.VISUAL_ID.equals(viewType)) {
				return getEPackageEPackageName_4009Parser();
			}
		}
		if (EcoreElementTypes.EAnnotation_1003 == type) {
			if (EAnnotation_source2EditPart.VISUAL_ID.equals(viewType)) {
				return getEAnnotationEAnnotationSource_4011Parser();
			}
		}
		if (EcoreElementTypes.EDataType_1004 == type) {
			if (EDataType_name2EditPart.VISUAL_ID.equals(viewType)) {
				return getEDataTypeEDataTypeName_4012Parser();
			}
		}
		if (EcoreElementTypes.EEnum_1005 == type) {
			if (EEnum_name2EditPart.VISUAL_ID.equals(viewType)) {
				return getEEnumEEnumName_4014Parser();
			}
		}
		if (EcoreElementTypes.EReference_3002 == type) {
			if (EReference_nameEditPart.VISUAL_ID.equals(viewType)) {
				return getEReferenceEReferenceName_4015Parser();
			}
		}
		if (EcoreElementTypes.EReference_3003 == type) {
			if (EReference_name2EditPart.VISUAL_ID.equals(viewType)) {
				return getEReferenceEReferenceName_4016Parser();
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
