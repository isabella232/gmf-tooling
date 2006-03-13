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

/**
 * @generated
 */
public class EcoreParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser eAttributeEATTRIBUTENAME_4001Parser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEATTRIBUTENAME_4001Parser() {
		if (eAttributeEATTRIBUTENAME_4001Parser == null) {
			eAttributeEATTRIBUTENAME_4001Parser = createEAttributeEATTRIBUTENAME_4001Parser();
		}
		return eAttributeEATTRIBUTENAME_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEATTRIBUTENAME_4001Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOPERATIONNAME_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOPERATIONNAME_4002Parser() {
		if (eOperationEOPERATIONNAME_4002Parser == null) {
			eOperationEOPERATIONNAME_4002Parser = createEOperationEOPERATIONNAME_4002Parser();
		}
		return eOperationEOPERATIONNAME_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOPERATIONNAME_4002Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4003Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4003Parser() {
		if (eAnnotationEANNOTATIONSOURCE_4003Parser == null) {
			eAnnotationEANNOTATIONSOURCE_4003Parser = createEAnnotationEANNOTATIONSOURCE_4003Parser();
		}
		return eAnnotationEANNOTATIONSOURCE_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4003Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4005Parser() {
		if (eClassECLASSNAME_4005Parser == null) {
			eClassECLASSNAME_4005Parser = createEClassECLASSNAME_4005Parser();
		}
		return eClassECLASSNAME_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4005Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4006Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4006Parser() {
		if (ePackageEPACKAGENAME_4006Parser == null) {
			ePackageEPACKAGENAME_4006Parser = createEPackageEPACKAGENAME_4006Parser();
		}
		return ePackageEPACKAGENAME_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4006Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4007Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4007Parser() {
		if (eDataTypeEDATATYPENAME_4007Parser == null) {
			eDataTypeEDATATYPENAME_4007Parser = createEDataTypeEDATATYPENAME_4007Parser();
		}
		return eDataTypeEDATATYPENAME_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4007Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4008Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4008Parser() {
		if (eEnumEENUMNAME_4008Parser == null) {
			eEnumEENUMNAME_4008Parser = createEEnumEENUMNAME_4008Parser();
		}
		return eEnumEENUMNAME_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4008Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser() {
		if (eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser == null) {
			eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser = createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser();
		}
		return eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEENUMLITERALNAME_4013Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEENUMLITERALNAME_4013Parser() {
		if (eEnumLiteralEENUMLITERALNAME_4013Parser == null) {
			eEnumLiteralEENUMLITERALNAME_4013Parser = createEEnumLiteralEENUMLITERALNAME_4013Parser();
		}
		return eEnumLiteralEENUMLITERALNAME_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEENUMLITERALNAME_4013Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4004Parser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4004Parser() {
		if (eClassECLASSNAME_4004Parser == null) {
			eClassECLASSNAME_4004Parser = createEClassECLASSNAME_4004Parser();
		}
		return eClassECLASSNAME_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4004Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4009Parser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4009Parser() {
		if (ePackageEPACKAGENAME_4009Parser == null) {
			ePackageEPACKAGENAME_4009Parser = createEPackageEPACKAGENAME_4009Parser();
		}
		return ePackageEPACKAGENAME_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4009Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4011Parser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4011Parser() {
		if (eAnnotationEANNOTATIONSOURCE_4011Parser == null) {
			eAnnotationEANNOTATIONSOURCE_4011Parser = createEAnnotationEANNOTATIONSOURCE_4011Parser();
		}
		return eAnnotationEANNOTATIONSOURCE_4011Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4011Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4012Parser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4012Parser() {
		if (eDataTypeEDATATYPENAME_4012Parser == null) {
			eDataTypeEDATATYPENAME_4012Parser = createEDataTypeEDATATYPENAME_4012Parser();
		}
		return eDataTypeEDATATYPENAME_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4012Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4014Parser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4014Parser() {
		if (eEnumEENUMNAME_4014Parser == null) {
			eEnumEENUMNAME_4014Parser = createEEnumEENUMNAME_4014Parser();
		}
		return eEnumEENUMNAME_4014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4014Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEREFERENCENAME_4015Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4015Parser() {
		if (eReferenceEREFERENCENAME_4015Parser == null) {
			eReferenceEREFERENCENAME_4015Parser = createEReferenceEREFERENCENAME_4015Parser();
		}
		return eReferenceEREFERENCENAME_4015Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4015Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEREFERENCENAME_4016Parser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4016Parser() {
		if (eReferenceEREFERENCENAME_4016Parser == null) {
			eReferenceEREFERENCENAME_4016Parser = createEReferenceEREFERENCENAME_4016Parser();
		}
		return eReferenceEREFERENCENAME_4016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4016Parser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getENamedElement().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (EcoreElementTypes.EAttribute_2001 == type) {
			return getEAttributeEATTRIBUTENAME_4001Parser();
		}
		if (EcoreElementTypes.EOperation_2002 == type) {
			return getEOperationEOPERATIONNAME_4002Parser();
		}
		if (EcoreElementTypes.EAnnotation_2003 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4003Parser();
		}
		if (EcoreElementTypes.EClass_2004 == type) {
			return getEClassECLASSNAME_4005Parser();
		}
		if (EcoreElementTypes.EPackage_2005 == type) {
			return getEPackageEPACKAGENAME_4006Parser();
		}
		if (EcoreElementTypes.EDataType_2006 == type) {
			return getEDataTypeEDATATYPENAME_4007Parser();
		}
		if (EcoreElementTypes.EEnum_2007 == type) {
			return getEEnumEENUMNAME_4008Parser();
		}
		if (EcoreElementTypes.EStringToStringMapEntry_2008 == type) {
			return getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4010Parser();
		}
		if (EcoreElementTypes.EEnumLiteral_2009 == type) {
			return getEEnumLiteralEENUMLITERALNAME_4013Parser();
		}
		if (EcoreElementTypes.EClass_1001 == type) {
			if (EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4004.equals(viewType)) {
				return getEClassECLASSNAME_4004Parser();
			}
		}
		if (EcoreElementTypes.EPackage_1002 == type) {
			if (EcoreSemanticHints.EPackage_1002Labels.EPACKAGENAME_4009.equals(viewType)) {
				return getEPackageEPACKAGENAME_4009Parser();
			}
		}
		if (EcoreElementTypes.EAnnotation_1003 == type) {
			if (EcoreSemanticHints.EAnnotation_1003Labels.EANNOTATIONSOURCE_4011.equals(viewType)) {
				return getEAnnotationEANNOTATIONSOURCE_4011Parser();
			}
		}
		if (EcoreElementTypes.EDataType_1004 == type) {
			if (EcoreSemanticHints.EDataType_1004Labels.EDATATYPENAME_4012.equals(viewType)) {
				return getEDataTypeEDATATYPENAME_4012Parser();
			}
		}
		if (EcoreElementTypes.EEnum_1005 == type) {
			if (EcoreSemanticHints.EEnum_1005Labels.EENUMNAME_4014.equals(viewType)) {
				return getEEnumEENUMNAME_4014Parser();
			}
		}
		if (EcoreElementTypes.EReference_3002 == type) {
			if (EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4015.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4015Parser();
			}
		}
		if (EcoreElementTypes.EReference_3003 == type) {
			if (EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4016.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4016Parser();
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
