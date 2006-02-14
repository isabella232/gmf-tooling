package org.eclipse.gmf.ecore.providers;

import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
	private Map eAttributeEATTRIBUTENAME_4002_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAttributeEATTRIBUTENAME_4002_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAttributeEATTRIBUTENAME_4002_TEXTParsers == null) {
			eAttributeEATTRIBUTENAME_4002_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAttributeEATTRIBUTENAME_4002_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAttributeEATTRIBUTENAME_4002_TEXTParser(editingDomain);
			eAttributeEATTRIBUTENAME_4002_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAttributeEATTRIBUTENAME_4002_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAttribute().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eOperationEOPERATIONNAME_4003_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEOperationEOPERATIONNAME_4003_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eOperationEOPERATIONNAME_4003_TEXTParsers == null) {
			eOperationEOPERATIONNAME_4003_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eOperationEOPERATIONNAME_4003_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEOperationEOPERATIONNAME_4003_TEXTParser(editingDomain);
			eOperationEOPERATIONNAME_4003_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEOperationEOPERATIONNAME_4003_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEOperation().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eAnnotationEANNOTATIONSOURCE_4004_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4004_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAnnotationEANNOTATIONSOURCE_4004_TEXTParsers == null) {
			eAnnotationEANNOTATIONSOURCE_4004_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAnnotationEANNOTATIONSOURCE_4004_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAnnotationEANNOTATIONSOURCE_4004_TEXTParser(editingDomain);
			eAnnotationEANNOTATIONSOURCE_4004_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4004_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eClassECLASSNAME_4006_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4006_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eClassECLASSNAME_4006_TEXTParsers == null) {
			eClassECLASSNAME_4006_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eClassECLASSNAME_4006_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEClassECLASSNAME_4006_TEXTParser(editingDomain);
			eClassECLASSNAME_4006_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4006_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map ePackageEPACKAGENAME_4007_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4007_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (ePackageEPACKAGENAME_4007_TEXTParsers == null) {
			ePackageEPACKAGENAME_4007_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) ePackageEPACKAGENAME_4007_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEPackageEPACKAGENAME_4007_TEXTParser(editingDomain);
			ePackageEPACKAGENAME_4007_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4007_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eDataTypeEDATATYPENAME_4008_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4008_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eDataTypeEDATATYPENAME_4008_TEXTParsers == null) {
			eDataTypeEDATATYPENAME_4008_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eDataTypeEDATATYPENAME_4008_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEDataTypeEDATATYPENAME_4008_TEXTParser(editingDomain);
			eDataTypeEDATATYPENAME_4008_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4008_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eEnumEENUMNAME_4009_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4009_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eEnumEENUMNAME_4009_TEXTParsers == null) {
			eEnumEENUMNAME_4009_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eEnumEENUMNAME_4009_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEEnumEENUMNAME_4009_TEXTParser(editingDomain);
			eEnumEENUMNAME_4009_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4009_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnum().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eAnnotationEANNOTATIONSOURCE_4010_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4010_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAnnotationEANNOTATIONSOURCE_4010_TEXTParsers == null) {
			eAnnotationEANNOTATIONSOURCE_4010_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAnnotationEANNOTATIONSOURCE_4010_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAnnotationEANNOTATIONSOURCE_4010_TEXTParser(editingDomain);
			eAnnotationEANNOTATIONSOURCE_4010_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4010_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParsers == null) {
			eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser(editingDomain);
			eStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEStringToStringMapEntry().getEStructuralFeature("key"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eAnnotationEANNOTATIONSOURCE_4014_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4014_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAnnotationEANNOTATIONSOURCE_4014_TEXTParsers == null) {
			eAnnotationEANNOTATIONSOURCE_4014_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAnnotationEANNOTATIONSOURCE_4014_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAnnotationEANNOTATIONSOURCE_4014_TEXTParser(editingDomain);
			eAnnotationEANNOTATIONSOURCE_4014_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4014_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eEnumLiteralEENUMLITERALNAME_4016_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEEnumLiteralEENUMLITERALNAME_4016_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eEnumLiteralEENUMLITERALNAME_4016_TEXTParsers == null) {
			eEnumLiteralEENUMLITERALNAME_4016_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eEnumLiteralEENUMLITERALNAME_4016_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEEnumLiteralEENUMLITERALNAME_4016_TEXTParser(editingDomain);
			eEnumLiteralEENUMLITERALNAME_4016_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumLiteralEENUMLITERALNAME_4016_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnumLiteral().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eAnnotationEANNOTATIONSOURCE_4017_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4017_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAnnotationEANNOTATIONSOURCE_4017_TEXTParsers == null) {
			eAnnotationEANNOTATIONSOURCE_4017_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAnnotationEANNOTATIONSOURCE_4017_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAnnotationEANNOTATIONSOURCE_4017_TEXTParser(editingDomain);
			eAnnotationEANNOTATIONSOURCE_4017_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4017_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eClassECLASSNAME_4001_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEClassECLASSNAME_4001_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eClassECLASSNAME_4001_TEXTParsers == null) {
			eClassECLASSNAME_4001_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eClassECLASSNAME_4001_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEClassECLASSNAME_4001_TEXTParser(editingDomain);
			eClassECLASSNAME_4001_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEClassECLASSNAME_4001_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEClass().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map ePackageEPACKAGENAME_4005_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEPackageEPACKAGENAME_4005_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (ePackageEPACKAGENAME_4005_TEXTParsers == null) {
			ePackageEPACKAGENAME_4005_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) ePackageEPACKAGENAME_4005_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEPackageEPACKAGENAME_4005_TEXTParser(editingDomain);
			ePackageEPACKAGENAME_4005_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPackageEPACKAGENAME_4005_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEPackage().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eAnnotationEANNOTATIONSOURCE_4011_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEAnnotationEANNOTATIONSOURCE_4011_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eAnnotationEANNOTATIONSOURCE_4011_TEXTParsers == null) {
			eAnnotationEANNOTATIONSOURCE_4011_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eAnnotationEANNOTATIONSOURCE_4011_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEAnnotationEANNOTATIONSOURCE_4011_TEXTParser(editingDomain);
			eAnnotationEANNOTATIONSOURCE_4011_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEAnnotationEANNOTATIONSOURCE_4011_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEAnnotation().getEStructuralFeature("source"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eDataTypeEDATATYPENAME_4013_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEDataTypeEDATATYPENAME_4013_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eDataTypeEDATATYPENAME_4013_TEXTParsers == null) {
			eDataTypeEDATATYPENAME_4013_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eDataTypeEDATATYPENAME_4013_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEDataTypeEDATATYPENAME_4013_TEXTParser(editingDomain);
			eDataTypeEDATATYPENAME_4013_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEDataTypeEDATATYPENAME_4013_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEDataType().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eEnumEENUMNAME_4015_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEEnumEENUMNAME_4015_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eEnumEENUMNAME_4015_TEXTParsers == null) {
			eEnumEENUMNAME_4015_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eEnumEENUMNAME_4015_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEEnumEENUMNAME_4015_TEXTParser(editingDomain);
			eEnumEENUMNAME_4015_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEEnumEENUMNAME_4015_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEEnum().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eReferenceEREFERENCENAME_4018_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4018_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eReferenceEREFERENCENAME_4018_TEXTParsers == null) {
			eReferenceEREFERENCENAME_4018_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eReferenceEREFERENCENAME_4018_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEReferenceEREFERENCENAME_4018_TEXTParser(editingDomain);
			eReferenceEREFERENCENAME_4018_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4018_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEReference().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	private Map eReferenceEREFERENCENAME_4019_TEXTParsers;

	/**
	 * @generated
	 */
	private IParser getEReferenceEREFERENCENAME_4019_TEXTParser(TransactionalEditingDomain editingDomain) {
		if (eReferenceEREFERENCENAME_4019_TEXTParsers == null) {
			eReferenceEREFERENCENAME_4019_TEXTParsers = new WeakHashMap();
		}
		IParser parser = (IParser) eReferenceEREFERENCENAME_4019_TEXTParsers.get(editingDomain);
		if (parser == null) {
			parser = createEReferenceEREFERENCENAME_4019_TEXTParser(editingDomain);
			eReferenceEREFERENCENAME_4019_TEXTParsers.put(editingDomain, parser);
		}
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEReferenceEREFERENCENAME_4019_TEXTParser(TransactionalEditingDomain editingDomain) {
		EcoreStructuralFeatureParser parser = new EcoreStructuralFeatureParser(EcorePackage.eINSTANCE.getEReference().getEStructuralFeature("name"));
		parser.setEditingDomain(editingDomain);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(IElementType type, String viewType, TransactionalEditingDomain editingDomain) {
		if (EcoreElementTypes.EAttribute_2001 == type) {
			return getEAttributeEATTRIBUTENAME_4002_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EOperation_2002 == type) {
			return getEOperationEOPERATIONNAME_4003_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EAnnotation_2003 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4004_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EClass_2004 == type) {
			return getEClassECLASSNAME_4006_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EPackage_2005 == type) {
			return getEPackageEPACKAGENAME_4007_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EDataType_2006 == type) {
			return getEDataTypeEDATATYPENAME_4008_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EEnum_2007 == type) {
			return getEEnumEENUMNAME_4009_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EAnnotation_2008 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4010_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EStringToStringMapEntry_2009 == type) {
			return getEStringToStringMapEntryESTRINGTOSTRINGMAPENTRYKEY_4012_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EAnnotation_2010 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4014_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EEnumLiteral_2011 == type) {
			return getEEnumLiteralEENUMLITERALNAME_4016_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EAnnotation_2012 == type) {
			return getEAnnotationEANNOTATIONSOURCE_4017_TEXTParser(editingDomain);
		}
		if (EcoreElementTypes.EClass_1001 == type) {
			if (EcoreSemanticHints.EClass_1001Labels.ECLASSNAME_4001_TEXT.equals(viewType)) {
				return getEClassECLASSNAME_4001_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EPackage_1002 == type) {
			if (EcoreSemanticHints.EPackage_1002Labels.EPACKAGENAME_4005_TEXT.equals(viewType)) {
				return getEPackageEPACKAGENAME_4005_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EAnnotation_1003 == type) {
			if (EcoreSemanticHints.EAnnotation_1003Labels.EANNOTATIONSOURCE_4011_TEXT.equals(viewType)) {
				return getEAnnotationEANNOTATIONSOURCE_4011_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EDataType_1004 == type) {
			if (EcoreSemanticHints.EDataType_1004Labels.EDATATYPENAME_4013_TEXT.equals(viewType)) {
				return getEDataTypeEDATATYPENAME_4013_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EEnum_1005 == type) {
			if (EcoreSemanticHints.EEnum_1005Labels.EENUMNAME_4015_TEXT.equals(viewType)) {
				return getEEnumEENUMNAME_4015_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EReference_3002 == type) {
			if (EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_TEXT.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4018_TEXTParser(editingDomain);
			}
		}
		if (EcoreElementTypes.EReference_3003 == type) {
			if (EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4019_TEXT.equals(viewType)) {
				return getEReferenceEREFERENCENAME_4019_TEXTParser(editingDomain);
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
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) hint.getAdapter(TransactionalEditingDomain.class);
		return getParser(type, viewType, editingDomain);
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
