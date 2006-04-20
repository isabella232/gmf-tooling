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

import org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition;

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
import org.eclipse.gmf.ecore.edit.parts.EReference_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

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
	public static final EcoreVisualIDRegistry INSTANCE = new EcoreVisualIDRegistry();

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EPackageEditPart.MODEL_ID.equals(view.getType())) {
				return 79;
			} else {
				return -1;
			}
		}
		try {
			return Integer.parseInt(view.getType());
		} catch (NumberFormatException e) {
			EcoreDiagramEditorPlugin.getInstance().logInfo("Unable to parse view type as a visualID number: " + view.getType());
		}
		return -1;
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
	public int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (EcorePackage.eINSTANCE.getEPackage().equals(domainElementMetaclass) && (domainElement == null || isDiagramEPackage_79((EPackage) domainElement))) {
			return 79;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!EPackageEditPart.MODEL_ID.equals(containerModelID) && !"ecore".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (EPackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = 79;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case 1001:
			if (EClass_nameEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4004;
			}
			if (EClass_attributesEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5001;
			}
			if (EClass_operationsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5002;
			}
			if (EClass_classannotationsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5003;
			}
			return getUnrecognizedEClass_1001ChildNodeID(domainElement, semanticHint);
		case 1002:
			if (EPackage_name2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4009;
			}
			if (EPackage_classesEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5004;
			}
			if (EPackage_packagesEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5005;
			}
			if (EPackage_datatypesEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5006;
			}
			if (EPackage_enumsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5007;
			}
			if (EPackage_packageannotationsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5008;
			}
			return getUnrecognizedEPackage_1002ChildNodeID(domainElement, semanticHint);
		case 1003:
			if (EAnnotation_source2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4011;
			}
			if (EAnnotation_detailsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5009;
			}
			return getUnrecognizedEAnnotation_1003ChildNodeID(domainElement, semanticHint);
		case 1004:
			if (EDataType_name2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4012;
			}
			if (EDataType_datatypeannotationsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5010;
			}
			return getUnrecognizedEDataType_1004ChildNodeID(domainElement, semanticHint);
		case 1005:
			if (EEnum_name2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4014;
			}
			if (EEnum_literalsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5011;
			}
			if (EEnum_enumannotationsEditPart.VISUAL_ID.equals(semanticHint)) {
				return 5012;
			}
			return getUnrecognizedEEnum_1005ChildNodeID(domainElement, semanticHint);
		case 2001:
			return getUnrecognizedEAttribute_2001ChildNodeID(domainElement, semanticHint);
		case 2002:
			return getUnrecognizedEOperation_2002ChildNodeID(domainElement, semanticHint);
		case 2003:
			return getUnrecognizedEAnnotation_2003ChildNodeID(domainElement, semanticHint);
		case 2004:
			return getUnrecognizedEClass_2004ChildNodeID(domainElement, semanticHint);
		case 2005:
			return getUnrecognizedEPackage_2005ChildNodeID(domainElement, semanticHint);
		case 2006:
			return getUnrecognizedEDataType_2006ChildNodeID(domainElement, semanticHint);
		case 2007:
			return getUnrecognizedEEnum_2007ChildNodeID(domainElement, semanticHint);
		case 2008:
			return getUnrecognizedEStringToStringMapEntry_2008ChildNodeID(domainElement, semanticHint);
		case 2009:
			return getUnrecognizedEEnumLiteral_2009ChildNodeID(domainElement, semanticHint);
		case 5001:
			if ((semanticHint == null || EAttributeEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAttribute().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAttribute_2001((EAttribute) domainElement))) {
				return 2001;
			}
			return getUnrecognizedAttributes_5001ChildNodeID(domainElement, semanticHint);
		case 5002:
			if ((semanticHint == null || EOperationEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEOperation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEOperation_2002((EOperation) domainElement))) {
				return 2002;
			}
			return getUnrecognizedOperations_5002ChildNodeID(domainElement, semanticHint);
		case 5003:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAnnotation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return 2003;
			}
			return getUnrecognizedClass_annotations_5003ChildNodeID(domainElement, semanticHint);
		case 5004:
			if ((semanticHint == null || EClass2EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEClass().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEClass_2004((EClass) domainElement))) {
				return 2004;
			}
			return getUnrecognizedClasses_5004ChildNodeID(domainElement, semanticHint);
		case 5005:
			if ((semanticHint == null || EPackage3EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEPackage().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEPackage_2005((EPackage) domainElement))) {
				return 2005;
			}
			return getUnrecognizedPackages_5005ChildNodeID(domainElement, semanticHint);
		case 5006:
			if ((semanticHint == null || EDataTypeEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEDataType().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEDataType_2006((EDataType) domainElement))) {
				return 2006;
			}
			return getUnrecognizedData_types_5006ChildNodeID(domainElement, semanticHint);
		case 5007:
			if ((semanticHint == null || EEnumEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEEnum().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnum_2007((EEnum) domainElement))) {
				return 2007;
			}
			return getUnrecognizedEnums_5007ChildNodeID(domainElement, semanticHint);
		case 5008:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAnnotation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return 2003;
			}
			return getUnrecognizedPackage_annotations_5008ChildNodeID(domainElement, semanticHint);
		case 5009:
			if ((semanticHint == null || EStringToStringMapEntryEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEStringToStringMapEntry().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEStringToStringMapEntry_2008((Entry) domainElement))) {
				return 2008;
			}
			return getUnrecognizedDetails_5009ChildNodeID(domainElement, semanticHint);
		case 5010:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAnnotation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return 2003;
			}
			return getUnrecognizedData_type_annotations_5010ChildNodeID(domainElement, semanticHint);
		case 5011:
			if ((semanticHint == null || EEnumLiteralEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEEnumLiteral().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnumLiteral_2009((EEnumLiteral) domainElement))) {
				return 2009;
			}
			return getUnrecognizedLiterals_5011ChildNodeID(domainElement, semanticHint);
		case 5012:
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAnnotation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_2003((EAnnotation) domainElement))) {
				return 2003;
			}
			return getUnrecognizedEnum_annotations_5012ChildNodeID(domainElement, semanticHint);
		case 79:
			if ((semanticHint == null || EClassEditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEClass().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEClass_1001((EClass) domainElement))) {
				return 1001;
			}
			if ((semanticHint == null || EPackage2EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEPackage().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEPackage_1002((EPackage) domainElement))) {
				return 1002;
			}
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEAnnotation().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEAnnotation_1003((EAnnotation) domainElement))) {
				return 1003;
			}
			if ((semanticHint == null || EDataType2EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEDataType().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEDataType_1004((EDataType) domainElement))) {
				return 1004;
			}
			if ((semanticHint == null || EEnum2EditPart.VISUAL_ID.equals(semanticHint)) && EcorePackage.eINSTANCE.getEEnum().equals(domainElementMetaclass)
					&& (domainElement == null || isNodeEEnum_1005((EEnum) domainElement))) {
				return 1005;
			}
			return getUnrecognizedEPackage_79ChildNodeID(domainElement, semanticHint);
		case 3001:
			return getUnrecognizedEAnnotationReferences_3001LinkLabelID(semanticHint);
		case 3002:
			if (EReference_nameEditPart.VISUAL_ID.equals(semanticHint)) {
				return 4015;
			}
			return getUnrecognizedEReference_3002LinkLabelID(semanticHint);
		case 3003:
			if (EReference_name2EditPart.VISUAL_ID.equals(semanticHint)) {
				return 4016;
			}
			return getUnrecognizedEReference_3003LinkLabelID(semanticHint);
		case 3004:
			return getUnrecognizedEClassESuperTypes_3004LinkLabelID(semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement) {
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (EcorePackage.eINSTANCE.getEReference().equals(domainElementMetaclass) && (domainElement == null || isLinkWithClassEReference_3002((EReference) domainElement))) {
			return 3002;
		} else if (EcorePackage.eINSTANCE.getEReference().equals(domainElementMetaclass) && (domainElement == null || isLinkWithClassEReference_3003((EReference) domainElement))) {
			return 3003;
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
	private boolean isDiagramEPackage_79(EPackage element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEClass_1001(EClass element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEPackage_1002(EPackage element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEAnnotation_1003(EAnnotation element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEDataType_1004(EDataType element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEEnum_1005(EEnum element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEAttribute_2001(EAttribute element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEOperation_2002(EOperation element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEAnnotation_2003(EAnnotation element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEClass_2004(EClass element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEPackage_2005(EPackage element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEDataType_2006(EDataType element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEEnum_2007(EEnum element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEStringToStringMapEntry_2008(Entry element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isNodeEEnumLiteral_2009(EEnumLiteral element) {
		return ElementSelectors.acceptAllMatcher().matches(element);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEClass_1001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEPackage_1002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEAnnotation_1003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEDataType_1004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEEnum_1005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEAttribute_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEOperation_2002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEAnnotation_2003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEClass_2004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEPackage_2005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEDataType_2006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEEnum_2007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEStringToStringMapEntry_2008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEEnumLiteral_2009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedAttributes_5001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedOperations_5002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedClass_annotations_5003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedClasses_5004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPackages_5005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedData_types_5006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEnums_5007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedPackage_annotations_5008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedDetails_5009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedData_type_annotations_5010ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedLiterals_5011ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEnum_annotations_5012ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEPackage_79ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEAnnotationReferences_3001LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEReference_3002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEReference_3003LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedEClassESuperTypes_3004LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassEReference_3002(EReference element) {
		return ElementSelectors.EReference_3002.matches(element);
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private boolean isLinkWithClassEReference_3003(EReference element) {
		return ElementSelectors.EReference_3003.matches(element);
	}

	/**
	 * @generated
	 */
	private static class ElementSelectors {

		/**
		 * Element matching condition for EReference_3002.
		 * <pre>language: ocl</pre>	
		 * <pre>body    : not containment</pre>
		 * @generated
		 */
		private static final Matcher EReference_3002 = new Matcher("not containment");

		/**
		 * Element matching condition for EReference_3003.
		 * <pre>language: ocl</pre>	
		 * <pre>body    : containment</pre>
		 * @generated
		 */
		private static final Matcher EReference_3003 = new Matcher("containment");

		/**
		 * @generated
		 */
		private ElementSelectors() {
		}

		/**
		 * @generated	
		 */
		static class Matcher {

			/**
			 * @generated	
			 */
			private EClass evalContext;

			/**
			 * @generated	
			 */
			private OCLConstraintCondition condition;

			/**
			 * @generated	
			 */
			private String body;

			/**
			 * @generated	
			 */
			Matcher(String expressionBody) {
				body = expressionBody;
			}

			/**
			 * @generated	
			 */
			boolean matches(EObject object) {
				try {
					Boolean result = (object != null) ? evaluate(object) : Boolean.FALSE;
					return result.booleanValue();
				} catch (IllegalArgumentException e) {
					EcoreDiagramEditorPlugin.getInstance().logError(null, e);
					return false;
				}
			}

			/**
			 * @generated	
			 */
			private Boolean evaluate(EObject context) {
				this.evalContext = context.eClass();
				if (condition == null) {
					condition = new OCLConstraintCondition(body, evalContext);
				}
				if (condition != null) {
					return booleanCast(condition.evaluate(context));
				}
				return Boolean.FALSE;
			}

			/**
			 * @generated	
			 */
			private static Boolean booleanCast(Object value) {
				if (value == null) {
					return null;
				} else if (value instanceof Boolean) {
					return (Boolean) value;
				}
				return Boolean.FALSE;
			}
		} // end of Matcher		

		/**
		 * @generated
		 */
		static class AcceptAllMatcher {

			/**
			 * @generated
			 */
			static final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();

			/**
			 * @generated
			 */
			boolean matches(Object element) {
				return true;
			}
		}

		/**
		 * @generated
		 */
		static AcceptAllMatcher acceptAllMatcher() {
			return AcceptAllMatcher.INSTANCE;
		}
	} // end of ElementSelectors
}
