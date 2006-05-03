package org.eclipse.gmf.ecore.part;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_detailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_source2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_attributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_classannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass_operationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_datatypeannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_enumannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_literalsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_classesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_datatypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_enumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packageannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packagesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class EcoreVisualIDRegistry {

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EPackageEditPart.MODEL_ID.equals(view.getType())) {
				return EPackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			EcoreDiagramEditorPlugin.getInstance().logInfo("Unable to parse view type as a visualID number: " + type);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass) && isDiagramEPackage_79((EPackage) domainElement)) {
			return EPackageEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!EPackageEditPart.MODEL_ID.equals(containerModelID) && !"ecore".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (EPackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EPackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = getVisualID(semanticHint);
		switch (containerVisualID) {
		case EClassEditPart.VISUAL_ID:
			if (EClass_nameEditPart.VISUAL_ID == nodeVisualID) {
				return EClass_nameEditPart.VISUAL_ID;
			}
			if (EClass_attributesEditPart.VISUAL_ID == nodeVisualID) {
				return EClass_attributesEditPart.VISUAL_ID;
			}
			if (EClass_operationsEditPart.VISUAL_ID == nodeVisualID) {
				return EClass_operationsEditPart.VISUAL_ID;
			}
			if (EClass_classannotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EClass_classannotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEClass_1001ChildNodeID(domainElement, semanticHint);
		case EPackage2EditPart.VISUAL_ID:
			if (EPackage_name2EditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_name2EditPart.VISUAL_ID;
			}
			if (EPackage_classesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_classesEditPart.VISUAL_ID;
			}
			if (EPackage_packagesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_packagesEditPart.VISUAL_ID;
			}
			if (EPackage_datatypesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_datatypesEditPart.VISUAL_ID;
			}
			if (EPackage_enumsEditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_enumsEditPart.VISUAL_ID;
			}
			if (EPackage_packageannotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EPackage_packageannotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackage_1002ChildNodeID(domainElement, semanticHint);
		case EAnnotation2EditPart.VISUAL_ID:
			if (EAnnotation_source2EditPart.VISUAL_ID == nodeVisualID) {
				return EAnnotation_source2EditPart.VISUAL_ID;
			}
			if (EAnnotation_detailsEditPart.VISUAL_ID == nodeVisualID) {
				return EAnnotation_detailsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEAnnotation_1003ChildNodeID(domainElement, semanticHint);
		case EDataType2EditPart.VISUAL_ID:
			if (EDataType_name2EditPart.VISUAL_ID == nodeVisualID) {
				return EDataType_name2EditPart.VISUAL_ID;
			}
			if (EDataType_datatypeannotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EDataType_datatypeannotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEDataType_1004ChildNodeID(domainElement, semanticHint);
		case EEnum2EditPart.VISUAL_ID:
			if (EEnum_name2EditPart.VISUAL_ID == nodeVisualID) {
				return EEnum_name2EditPart.VISUAL_ID;
			}
			if (EEnum_literalsEditPart.VISUAL_ID == nodeVisualID) {
				return EEnum_literalsEditPart.VISUAL_ID;
			}
			if (EEnum_enumannotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EEnum_enumannotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEEnum_1005ChildNodeID(domainElement, semanticHint);
		case EAttributeEditPart.VISUAL_ID:
			return getUnrecognizedEAttribute_2001ChildNodeID(domainElement, semanticHint);
		case EOperationEditPart.VISUAL_ID:
			return getUnrecognizedEOperation_2002ChildNodeID(domainElement, semanticHint);
		case EAnnotationEditPart.VISUAL_ID:
			return getUnrecognizedEAnnotation_2003ChildNodeID(domainElement, semanticHint);
		case EClass2EditPart.VISUAL_ID:
			return getUnrecognizedEClass_2004ChildNodeID(domainElement, semanticHint);
		case EPackage3EditPart.VISUAL_ID:
			return getUnrecognizedEPackage_2005ChildNodeID(domainElement, semanticHint);
		case EDataTypeEditPart.VISUAL_ID:
			return getUnrecognizedEDataType_2006ChildNodeID(domainElement, semanticHint);
		case EEnumEditPart.VISUAL_ID:
			return getUnrecognizedEEnum_2007ChildNodeID(domainElement, semanticHint);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getUnrecognizedEStringToStringMapEntry_2008ChildNodeID(domainElement, semanticHint);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getUnrecognizedEEnumLiteral_2009ChildNodeID(domainElement, semanticHint);
		case EClass_attributesEditPart.VISUAL_ID:
			if ((semanticHint == null || EAttributeEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAttribute().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAttribute_2001((EAttribute) domainElement))) {
				return EAttributeEditPart.VISUAL_ID;
			}
			return getUnrecognizedAttributes_5001ChildNodeID(domainElement, semanticHint);
		case EClass_operationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EOperationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEOperation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEOperation_2002((EOperation) domainElement))) {
				return EOperationEditPart.VISUAL_ID;
			}
			return getUnrecognizedOperations_5002ChildNodeID(domainElement, semanticHint);
		case EClass_classannotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			return getUnrecognizedClass_annotations_5003ChildNodeID(domainElement, semanticHint);
		case EPackage_classesEditPart.VISUAL_ID:
			if ((semanticHint == null || EClass2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEClass_2004((EClass) domainElement))) {
				return EClass2EditPart.VISUAL_ID;
			}
			return getUnrecognizedClasses_5004ChildNodeID(domainElement, semanticHint);
		case EPackage_packagesEditPart.VISUAL_ID:
			if ((semanticHint == null || EPackage3EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEPackage_2005((EPackage) domainElement))) {
				return EPackage3EditPart.VISUAL_ID;
			}
			return getUnrecognizedPackages_5005ChildNodeID(domainElement, semanticHint);
		case EPackage_datatypesEditPart.VISUAL_ID:
			if ((semanticHint == null || EDataTypeEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEDataType_2006((EDataType) domainElement))) {
				return EDataTypeEditPart.VISUAL_ID;
			}
			return getUnrecognizedData_types_5006ChildNodeID(domainElement, semanticHint);
		case EPackage_enumsEditPart.VISUAL_ID:
			if ((semanticHint == null || EEnumEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnum_2007((EEnum) domainElement))) {
				return EEnumEditPart.VISUAL_ID;
			}
			return getUnrecognizedEnums_5007ChildNodeID(domainElement, semanticHint);
		case EPackage_packageannotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			return getUnrecognizedPackage_annotations_5008ChildNodeID(domainElement, semanticHint);
		case EAnnotation_detailsEditPart.VISUAL_ID:
			if ((semanticHint == null || EStringToStringMapEntryEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEStringToStringMapEntry().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEStringToStringMapEntry_2008((Entry) domainElement))) {
				return EStringToStringMapEntryEditPart.VISUAL_ID;
			}
			return getUnrecognizedDetails_5009ChildNodeID(domainElement, semanticHint);
		case EDataType_datatypeannotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			return getUnrecognizedData_type_annotations_5010ChildNodeID(domainElement, semanticHint);
		case EEnum_literalsEditPart.VISUAL_ID:
			if ((semanticHint == null || EEnumLiteralEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnumLiteral().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnumLiteral_2009((EEnumLiteral) domainElement))) {
				return EEnumLiteralEditPart.VISUAL_ID;
			}
			return getUnrecognizedLiterals_5011ChildNodeID(domainElement, semanticHint);
		case EEnum_enumannotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			return getUnrecognizedEnum_annotations_5012ChildNodeID(domainElement, semanticHint);
		case EPackageEditPart.VISUAL_ID:
			if ((semanticHint == null || EClassEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEClass_1001((EClass) domainElement))) {
				return EClassEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EPackage2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEPackage_1002((EPackage) domainElement))) {
				return EPackage2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_1003((EAnnotation) domainElement))) {
				return EAnnotation2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EDataType2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEDataType_1004((EDataType) domainElement))) {
				return EDataType2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EEnum2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnum_1005((EEnum) domainElement))) {
				return EEnum2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackage_79ChildNodeID(domainElement, semanticHint);
		case EReferenceEditPart.VISUAL_ID:
			if (EReference_nameEditPart.VISUAL_ID == nodeVisualID) {
				return EReference_nameEditPart.VISUAL_ID;
			}
			return getUnrecognizedEReference_3002LinkLabelID(semanticHint);
		case EReference2EditPart.VISUAL_ID:
			if (EReference_name2EditPart.VISUAL_ID == nodeVisualID) {
				return EReference_name2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEReference_3003LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (EcorePackage.eINSTANCE.getEReference().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassEReference_3002((EReference) domainElement))) {
			return EReferenceEditPart.VISUAL_ID;
		} else if (EcorePackage.eINSTANCE.getEReference().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClassEReference_3003((EReference) domainElement))) {
			return EReference2EditPart.VISUAL_ID;
		} else {
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramEPackage_79(EPackage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEClass_1001(EClass element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEPackage_1002(EPackage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEAnnotation_1003(EAnnotation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEDataType_1004(EDataType element) {
		return EDataType_1004.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEEnum_1005(EEnum element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEAttribute_2001(EAttribute element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEOperation_2002(EOperation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEAnnotation_2003(EAnnotation element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEClass_2004(EClass element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEPackage_2005(EPackage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEDataType_2006(EDataType element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEEnum_2007(EEnum element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEStringToStringMapEntry_2008(Entry element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeEEnumLiteral_2009(EEnumLiteral element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEClass_1001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEPackage_1002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEAnnotation_1003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEDataType_1004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEEnum_1005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEAttribute_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEOperation_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEAnnotation_2003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEClass_2004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEPackage_2005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEDataType_2006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEEnum_2007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEStringToStringMapEntry_2008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEEnumLiteral_2009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedAttributes_5001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedOperations_5002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedClass_annotations_5003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedClasses_5004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPackages_5005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedData_types_5006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEnums_5007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPackage_annotations_5008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDetails_5009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedData_type_annotations_5010ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLiterals_5011ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEnum_annotations_5012ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEPackage_79ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEReference_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedEReference_3003LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassEReference_3002(EReference element) {
		return EReference_3002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isLinkWithClassEReference_3003(EReference element) {
		return EReference_3003.matches(element);
	}

	/**
	 * @generated
	 */
	private static final Matcher EDataType_1004 = new Matcher(EcoreOCLFactory.getExpression("not oclIsKindOf(ecore::EEnum)", //$NON-NLS-1$
			EcorePackage.eINSTANCE.getEDataType()));

	/**
	 * @generated
	 */
	private static final Matcher EReference_3002 = new Matcher(EcoreOCLFactory.getExpression("not containment and not container", //$NON-NLS-1$
			EcorePackage.eINSTANCE.getEReference()));

	/**
	 * @generated
	 */
	private static final Matcher EReference_3003 = new Matcher(EcoreOCLFactory.getExpression("containment", //$NON-NLS-1$
			EcorePackage.eINSTANCE.getEReference()));

	/**
	 * @generated	
	 */
	static class Matcher {

		/**
		 * @generated	
		 */
		private EcoreAbstractExpression condition;

		/**
		 * @generated	
		 */
		Matcher(EcoreAbstractExpression conditionExpression) {
			this.condition = conditionExpression;
		}

		/**
		 * @generated	
		 */
		boolean matches(EObject object) {
			Object result = condition.evaluate(object);
			return result instanceof Boolean && ((Boolean) result).booleanValue();
		}
	}// Matcher
}
