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
	private IParser eAttributeEATTRIBUTENAME_4001_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEATTRIBUTENAME_4001_TEXTParser() {
		if (eAttributeEATTRIBUTENAME_4001_TEXTParser == null) {
			eAttributeEATTRIBUTENAME_4001_TEXTParser = createEAttributeEATTRIBUTENAME_4001_TEXTParser();
		}
		return eAttributeEATTRIBUTENAME_4001_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEATTRIBUTENAME_4001_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAttribute().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOPERATIONNAME_4002_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOPERATIONNAME_4002_TEXTParser() {
		if (eOperationEOPERATIONNAME_4002_TEXTParser == null) {
			eOperationEOPERATIONNAME_4002_TEXTParser = createEOperationEOPERATIONNAME_4002_TEXTParser();
		}
		return eOperationEOPERATIONNAME_4002_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOPERATIONNAME_4002_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEOperation().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4003_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4003_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4003_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4003_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4003_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4003_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4003_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4005_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4005_TEXTParser() {
		if (eClassECLASSNAME_4005_TEXTParser == null) {
			eClassECLASSNAME_4005_TEXTParser = createEClassECLASSNAME_4005_TEXTParser();
		}
		return eClassECLASSNAME_4005_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4005_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4006_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4006_TEXTParser() {
		if (ePackageEPACKAGENAME_4006_TEXTParser == null) {
			ePackageEPACKAGENAME_4006_TEXTParser = createEPackageEPACKAGENAME_4006_TEXTParser();
		}
		return ePackageEPACKAGENAME_4006_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4006_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4007_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4007_TEXTParser() {
		if (eDataTypeEDATATYPENAME_4007_TEXTParser == null) {
			eDataTypeEDATATYPENAME_4007_TEXTParser = createEDataTypeEDATATYPENAME_4007_TEXTParser();
		}
		return eDataTypeEDATATYPENAME_4007_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4007_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4008_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4008_TEXTParser() {
		if (eEnumEENUMNAME_4008_TEXTParser == null) {
			eEnumEENUMNAME_4008_TEXTParser = createEEnumEENUMNAME_4008_TEXTParser();
		}
		return eEnumEENUMNAME_4008_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4008_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnum().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4009_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4009_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4009_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4009_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4009_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4009_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4009_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser() {
		if (eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser == null) {
			eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser = createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser();
		}
		return eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4013_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4013_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4013_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4013_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4013_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4013_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4013_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEENUMLITERALNAME_4015_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEENUMLITERALNAME_4015_TEXTParser() {
		if (eEnumLiteralEENUMLITERALNAME_4015_TEXTParser == null) {
			eEnumLiteralEENUMLITERALNAME_4015_TEXTParser = createEEnumLiteralEENUMLITERALNAME_4015_TEXTParser();
		}
		return eEnumLiteralEENUMLITERALNAME_4015_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEENUMLITERALNAME_4015_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnumLiteral().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4016_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4016_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4016_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4016_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4016_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4016_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4016_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4004_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4004_TEXTParser() {
		if (eClassECLASSNAME_4004_TEXTParser == null) {
			eClassECLASSNAME_4004_TEXTParser = createEClassECLASSNAME_4004_TEXTParser();
		}
		return eClassECLASSNAME_4004_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4004_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4010_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4010_TEXTParser() {
		if (ePackageEPACKAGENAME_4010_TEXTParser == null) {
			ePackageEPACKAGENAME_4010_TEXTParser = createEPackageEPACKAGENAME_4010_TEXTParser();
		}
		return ePackageEPACKAGENAME_4010_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4010_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4012_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4012_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4012_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4012_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4012_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4012_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4012_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4014_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4014_TEXTParser() {
		if (eDataTypeEDATATYPENAME_4014_TEXTParser == null) {
			eDataTypeEDATATYPENAME_4014_TEXTParser = createEDataTypeEDATATYPENAME_4014_TEXTParser();
		}
		return eDataTypeEDATATYPENAME_4014_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4014_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4017_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4017_TEXTParser() {
		if (eEnumEENUMNAME_4017_TEXTParser == null) {
			eEnumEENUMNAME_4017_TEXTParser = createEEnumEENUMNAME_4017_TEXTParser();
		}
		return eEnumEENUMNAME_4017_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4017_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnum().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEREFERENCENAME_4018_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4018_TEXTParser() {
		if (eReferenceEREFERENCENAME_4018_TEXTParser == null) {
			eReferenceEREFERENCENAME_4018_TEXTParser = createEReferenceEREFERENCENAME_4018_TEXTParser();
		}
		return eReferenceEREFERENCENAME_4018_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4018_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEReference().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eReferenceEREFERENCENAME_4019_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4019_TEXTParser() {
		if (eReferenceEREFERENCENAME_4019_TEXTParser == null) {
			eReferenceEREFERENCENAME_4019_TEXTParser = createEReferenceEREFERENCENAME_4019_TEXTParser();
		}
		return eReferenceEREFERENCENAME_4019_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4019_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEReference().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType) {
		if (EcoreElementTypes.EAttribute_2001 == type) {
			return getEAttributeEATTRIBUTENAME_4001_TEXTParser();
		}
		if (EcoreElementTypes.EOperation_2002 == type) {
			return getEOperationEOPERATIONNAME_4002_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2003 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4003_TEXTParser();
		}
		if (EcoreElementTypes.EClass_2004 == type) {
			return getEClassECLASSNAME_4005_TEXTParser();
		}
		if (EcoreElementTypes.EPackage_2005 == type) {
			return getEPackageEPACKAGENAME_4006_TEXTParser();
		}
		if (EcoreElementTypes.EDataType_2006 == type) {
			return getEDataTypeEDATATYPENAME_4007_TEXTParser();
		}
		if (EcoreElementTypes.EEnum_2007 == type) {
			return getEEnumEENUMNAME_4008_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2008 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4009_TEXTParser();
		}
		if (EcoreElementTypes.EStringToStringMapEntry_2009 == type) {
			return getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4011_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2010 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4013_TEXTParser();
		}
		if (EcoreElementTypes.EEnumLiteral_2011 == type) {
			return getEEnumLiteralEENUMLITERALNAME_4015_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2012 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4016_TEXTParser();
		}
		if (EcoreElementTypes.EClass_1001 == type) {
			if (EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4004_TEXT.equals(viewType)) {
				return getEClassECLASSNAME_4004_TEXTParser();
			}
		}
		if (EcoreElementTypes.EPackage_1002 == type) {
			if (EcoreSemanticHints.EPackage_1002Labels.EPACKAGENAME_4010_TEXT.equals(viewType)) {
				return getEPackageEPACKAGENAME_4010_TEXTParser();
			}
		}
		if (EcoreElementTypes.EAnnotation_1003 == type) {
			if (EcoreSemanticHints.EAnnotation_1003Labels.EANNOTATIONSOURCE_4012_TEXT.equals(viewType)) {
				return getEAnnotationEANNOTATIONSOURCE_4012_TEXTParser();
			}
		}
		if (EcoreElementTypes.EDataType_1004 == type) {
			if (EcoreSemanticHints.EDataType_1004Labels.EDATATYPENAME_4014_TEXT.equals(viewType)) {
				return getEDataTypeEDATATYPENAME_4014_TEXTParser();
			}
		}
		if (EcoreElementTypes.EEnum_1005 == type) {
			if (EcoreSemanticHints.EEnum_1005Labels.EENUMNAME_4017_TEXT.equals(viewType)) {
				return getEEnumEENUMNAME_4017_TEXTParser();
			}
		}
		if (EcoreElementTypes.EReference_3002 == type) {
			if (EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_TEXT.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4018_TEXTParser();
			}
		}
		if (EcoreElementTypes.EReference_3003 == type) {
			if (EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4019_TEXT.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4019_TEXTParser();
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
