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
	private IParser eAttributeEATTRIBUTENAME_4002_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAttributeEATTRIBUTENAME_4002_TEXTParser() {
		if (eAttributeEATTRIBUTENAME_4002_TEXTParser == null) {
			eAttributeEATTRIBUTENAME_4002_TEXTParser = createEAttributeEATTRIBUTENAME_4002_TEXTParser();
		}
		return eAttributeEATTRIBUTENAME_4002_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEATTRIBUTENAME_4002_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAttribute().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eOperationEOPERATIONNAME_4003_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEOperationEOPERATIONNAME_4003_TEXTParser() {
		if (eOperationEOPERATIONNAME_4003_TEXTParser == null) {
			eOperationEOPERATIONNAME_4003_TEXTParser = createEOperationEOPERATIONNAME_4003_TEXTParser();
		}
		return eOperationEOPERATIONNAME_4003_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOPERATIONNAME_4003_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEOperation().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4004_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4004_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4004_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4004_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4004_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4004_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4004_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4006_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4006_TEXTParser() {
		if (eClassECLASSNAME_4006_TEXTParser == null) {
			eClassECLASSNAME_4006_TEXTParser = createEClassECLASSNAME_4006_TEXTParser();
		}
		return eClassECLASSNAME_4006_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4006_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4007_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4007_TEXTParser() {
		if (ePackageEPACKAGENAME_4007_TEXTParser == null) {
			ePackageEPACKAGENAME_4007_TEXTParser = createEPackageEPACKAGENAME_4007_TEXTParser();
		}
		return ePackageEPACKAGENAME_4007_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4007_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4008_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4008_TEXTParser() {
		if (eDataTypeEDATATYPENAME_4008_TEXTParser == null) {
			eDataTypeEDATATYPENAME_4008_TEXTParser = createEDataTypeEDATATYPENAME_4008_TEXTParser();
		}
		return eDataTypeEDATATYPENAME_4008_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4008_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4009_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4009_TEXTParser() {
		if (eEnumEENUMNAME_4009_TEXTParser == null) {
			eEnumEENUMNAME_4009_TEXTParser = createEEnumEENUMNAME_4009_TEXTParser();
		}
		return eEnumEENUMNAME_4009_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4009_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnum().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4010_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4010_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4010_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4010_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4010_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4010_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4010_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser() {
		if (eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser == null) {
			eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser = createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser();
		}
		return eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4014_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4014_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4014_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4014_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4014_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4014_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4014_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumLiteralEENUMLITERALNAME_4016_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEENUMLITERALNAME_4016_TEXTParser() {
		if (eEnumLiteralEENUMLITERALNAME_4016_TEXTParser == null) {
			eEnumLiteralEENUMLITERALNAME_4016_TEXTParser = createEEnumLiteralEENUMLITERALNAME_4016_TEXTParser();
		}
		return eEnumLiteralEENUMLITERALNAME_4016_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEENUMLITERALNAME_4016_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnumLiteral().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4017_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4017_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4017_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4017_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4017_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4017_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4017_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eClassECLASSNAME_4001_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4001_TEXTParser() {
		if (eClassECLASSNAME_4001_TEXTParser == null) {
			eClassECLASSNAME_4001_TEXTParser = createEClassECLASSNAME_4001_TEXTParser();
		}
		return eClassECLASSNAME_4001_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4001_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePackageEPACKAGENAME_4005_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4005_TEXTParser() {
		if (ePackageEPACKAGENAME_4005_TEXTParser == null) {
			ePackageEPACKAGENAME_4005_TEXTParser = createEPackageEPACKAGENAME_4005_TEXTParser();
		}
		return ePackageEPACKAGENAME_4005_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4005_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eAnnotationEANNOTATIONSOURCE_4011_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4011_TEXTParser() {
		if (eAnnotationEANNOTATIONSOURCE_4011_TEXTParser == null) {
			eAnnotationEANNOTATIONSOURCE_4011_TEXTParser = createEAnnotationEANNOTATIONSOURCE_4011_TEXTParser();
		}
		return eAnnotationEANNOTATIONSOURCE_4011_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4011_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eDataTypeEDATATYPENAME_4013_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4013_TEXTParser() {
		if (eDataTypeEDATATYPENAME_4013_TEXTParser == null) {
			eDataTypeEDATATYPENAME_4013_TEXTParser = createEDataTypeEDATATYPENAME_4013_TEXTParser();
		}
		return eDataTypeEDATATYPENAME_4013_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4013_TEXTParser() {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eEnumEENUMNAME_4015_TEXTParser;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4015_TEXTParser() {
		if (eEnumEENUMNAME_4015_TEXTParser == null) {
			eEnumEENUMNAME_4015_TEXTParser = createEEnumEENUMNAME_4015_TEXTParser();
		}
		return eEnumEENUMNAME_4015_TEXTParser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4015_TEXTParser() {
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
			return getEAttributeEATTRIBUTENAME_4002_TEXTParser();
		}
		if (EcoreElementTypes.EOperation_2002 == type) {
			return getEOperationEOPERATIONNAME_4003_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2003 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4004_TEXTParser();
		}
		if (EcoreElementTypes.EClass_2004 == type) {
			return getEClassECLASSNAME_4006_TEXTParser();
		}
		if (EcoreElementTypes.EPackage_2005 == type) {
			return getEPackageEPACKAGENAME_4007_TEXTParser();
		}
		if (EcoreElementTypes.EDataType_2006 == type) {
			return getEDataTypeEDATATYPENAME_4008_TEXTParser();
		}
		if (EcoreElementTypes.EEnum_2007 == type) {
			return getEEnumEENUMNAME_4009_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2008 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4010_TEXTParser();
		}
		if (EcoreElementTypes.EStringToStringMapEntry_2009 == type) {
			return getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2010 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4014_TEXTParser();
		}
		if (EcoreElementTypes.EEnumLiteral_2011 == type) {
			return getEEnumLiteralEENUMLITERALNAME_4016_TEXTParser();
		}
		if (EcoreElementTypes.EAnnotation_2012 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4017_TEXTParser();
		}
		if (EcoreElementTypes.EClass_1001 == type) {
			if (EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4001_TEXT.equals(viewType)) {
				return getEClassECLASSNAME_4001_TEXTParser();
			}
		}
		if (EcoreElementTypes.EPackage_1002 == type) {
			if (EcoreSemanticHints.EPackage_1002Labels.EPACKAGENAME_4005_TEXT.equals(viewType)) {
				return getEPackageEPACKAGENAME_4005_TEXTParser();
			}
		}
		if (EcoreElementTypes.EAnnotation_1003 == type) {
			if (EcoreSemanticHints.EAnnotation_1003Labels.EANNOTATIONSOURCE_4011_TEXT.equals(viewType)) {
				return getEAnnotationEANNOTATIONSOURCE_4011_TEXTParser();
			}
		}
		if (EcoreElementTypes.EDataType_1004 == type) {
			if (EcoreSemanticHints.EDataType_1004Labels.EDATATYPENAME_4013_TEXT.equals(viewType)) {
				return getEDataTypeEDATATYPENAME_4013_TEXTParser();
			}
		}
		if (EcoreElementTypes.EEnum_1005 == type) {
			if (EcoreSemanticHints.EEnum_1005Labels.EENUMNAME_4015_TEXT.equals(viewType)) {
				return getEEnumEENUMNAME_4015_TEXTParser();
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
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			String viewType = (String) hint.getAdapter(String.class);
			IElementType type = (IElementType) hint.getAdapter(IElementType.class);
			if (type == null) {
				EObject element = (EObject) hint.getAdapter(EObject.class);
				type = ElementTypeRegistry.getInstance().getElementType(element);
			}
			return getParser(type, viewType) != null;
		}
		return false;
	}
}
