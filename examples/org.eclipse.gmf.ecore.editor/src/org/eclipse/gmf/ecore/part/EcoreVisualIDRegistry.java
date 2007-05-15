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
package org.eclipse.gmf.ecore.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassAttributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassClassAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassOperationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeDataTypeAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEnumAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageClassesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageDataTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEnumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageNameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackageAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackagePackagesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceLowerBoundUpperBound2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceLowerBoundUpperBoundEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceName2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceNameEditPart;
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
	private static final String DEBUG_KEY = EcoreDiagramEditorPlugin.getInstance().getBundle().getSymbolicName() + "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static final EcoreAbstractExpression EDataType_2004_Constraint = EcoreOCLFactory.getExpression("not oclIsKindOf(ecore::EEnum)", EcorePackage.eINSTANCE.getEDataType());

	/**
	 * @generated
	 */
	private static final EcoreAbstractExpression EDataType_3006_Constraint = EcoreOCLFactory.getExpression("not oclIsKindOf(ecore::EEnum)", EcorePackage.eINSTANCE.getEDataType());

	/**
	 * @generated
	 */
	private static final EcoreAbstractExpression EReference_4002_Constraint = EcoreOCLFactory.getExpression("not containment and not container", EcorePackage.eINSTANCE.getEReference());

	/**
	 * @generated
	 */
	private static final EcoreAbstractExpression EReference_4003_Constraint = EcoreOCLFactory.getExpression("containment", EcorePackage.eINSTANCE.getEReference());

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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				EcoreDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
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
		if (EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass) && isDiagram((EPackage) domainElement)) {
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
		String containerModelID = org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry.getModelID(containerView);
		if (!EPackageEditPart.MODEL_ID.equals(containerModelID) && !"ecore".equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (EPackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = 1000;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry.getVisualID(semanticHint) : -1;
		switch (containerVisualID) {
		case EClassEditPart.VISUAL_ID:
			if (EClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return EClassNameEditPart.VISUAL_ID;
			}
			if (EClassAttributesEditPart.VISUAL_ID == nodeVisualID) {
				return EClassAttributesEditPart.VISUAL_ID;
			}
			if (EClassOperationsEditPart.VISUAL_ID == nodeVisualID) {
				return EClassOperationsEditPart.VISUAL_ID;
			}
			if (EClassClassAnnotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EClassClassAnnotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEClass_2001ChildNodeID(domainElement, semanticHint);
		case EPackage2EditPart.VISUAL_ID:
			if (EPackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return EPackageNameEditPart.VISUAL_ID;
			}
			if (EPackageClassesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackageClassesEditPart.VISUAL_ID;
			}
			if (EPackagePackagesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackagePackagesEditPart.VISUAL_ID;
			}
			if (EPackageDataTypesEditPart.VISUAL_ID == nodeVisualID) {
				return EPackageDataTypesEditPart.VISUAL_ID;
			}
			if (EPackageEnumsEditPart.VISUAL_ID == nodeVisualID) {
				return EPackageEnumsEditPart.VISUAL_ID;
			}
			if (EPackagePackageAnnotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EPackagePackageAnnotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackage_2002ChildNodeID(domainElement, semanticHint);
		case EAnnotationEditPart.VISUAL_ID:
			if (EAnnotationSourceEditPart.VISUAL_ID == nodeVisualID) {
				return EAnnotationSourceEditPart.VISUAL_ID;
			}
			if (EAnnotationDetailsEditPart.VISUAL_ID == nodeVisualID) {
				return EAnnotationDetailsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEAnnotation_2003ChildNodeID(domainElement, semanticHint);
		case EDataTypeEditPart.VISUAL_ID:
			if (EDataTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return EDataTypeNameEditPart.VISUAL_ID;
			}
			if (EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEDataType_2004ChildNodeID(domainElement, semanticHint);
		case EEnumEditPart.VISUAL_ID:
			if (EEnumNameEditPart.VISUAL_ID == nodeVisualID) {
				return EEnumNameEditPart.VISUAL_ID;
			}
			if (EEnumLiteralsEditPart.VISUAL_ID == nodeVisualID) {
				return EEnumLiteralsEditPart.VISUAL_ID;
			}
			if (EEnumEnumAnnotationsEditPart.VISUAL_ID == nodeVisualID) {
				return EEnumEnumAnnotationsEditPart.VISUAL_ID;
			}
			return getUnrecognizedEEnum_2005ChildNodeID(domainElement, semanticHint);
		case EAttributeEditPart.VISUAL_ID:
			return getUnrecognizedEAttribute_3001ChildNodeID(domainElement, semanticHint);
		case EOperationEditPart.VISUAL_ID:
			return getUnrecognizedEOperation_3002ChildNodeID(domainElement, semanticHint);
		case EAnnotation2EditPart.VISUAL_ID:
			return getUnrecognizedEAnnotation_3003ChildNodeID(domainElement, semanticHint);
		case EClass2EditPart.VISUAL_ID:
			return getUnrecognizedEClass_3004ChildNodeID(domainElement, semanticHint);
		case EPackage3EditPart.VISUAL_ID:
			return getUnrecognizedEPackage_3005ChildNodeID(domainElement, semanticHint);
		case EDataType2EditPart.VISUAL_ID:
			return getUnrecognizedEDataType_3006ChildNodeID(domainElement, semanticHint);
		case EEnum2EditPart.VISUAL_ID:
			return getUnrecognizedEEnum_3007ChildNodeID(domainElement, semanticHint);
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return getUnrecognizedEStringToStringMapEntry_3008ChildNodeID(domainElement, semanticHint);
		case EEnumLiteralEditPart.VISUAL_ID:
			return getUnrecognizedEEnumLiteral_3009ChildNodeID(domainElement, semanticHint);
		case EClassAttributesEditPart.VISUAL_ID:
			if ((semanticHint == null || EAttributeEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAttribute().isSuperTypeOf(domainElementMetaclass)) {
				return EAttributeEditPart.VISUAL_ID;
			}
			return getUnrecognizedEClassAttributes_7001ChildNodeID(domainElement, semanticHint);
		case EClassOperationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EOperationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEOperation().isSuperTypeOf(domainElementMetaclass)) {
				return EOperationEditPart.VISUAL_ID;
			}
			return getUnrecognizedEClassOperations_7002ChildNodeID(domainElement, semanticHint);
		case EClassClassAnnotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)) {
				return EAnnotation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEClassClassAnnotations_7003ChildNodeID(domainElement, semanticHint);
		case EPackageClassesEditPart.VISUAL_ID:
			if ((semanticHint == null || EClass2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElementMetaclass)) {
				return EClass2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackageClasses_7004ChildNodeID(domainElement, semanticHint);
		case EPackagePackagesEditPart.VISUAL_ID:
			if ((semanticHint == null || EPackage3EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass)) {
				return EPackage3EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackagePackages_7005ChildNodeID(domainElement, semanticHint);
		case EPackageDataTypesEditPart.VISUAL_ID:
			if ((semanticHint == null || EDataType2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || evaluate(EDataType_3006_Constraint, domainElement))) {
				return EDataType2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackageDataTypes_7006ChildNodeID(domainElement, semanticHint);
		case EPackageEnumsEditPart.VISUAL_ID:
			if ((semanticHint == null || EEnum2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElementMetaclass)) {
				return EEnum2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackageEnums_7007ChildNodeID(domainElement, semanticHint);
		case EPackagePackageAnnotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)) {
				return EAnnotation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackagePackageAnnotations_7008ChildNodeID(domainElement, semanticHint);
		case EAnnotationDetailsEditPart.VISUAL_ID:
			if ((semanticHint == null || EStringToStringMapEntryEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEStringToStringMapEntry().isSuperTypeOf(domainElementMetaclass)) {
				return EStringToStringMapEntryEditPart.VISUAL_ID;
			}
			return getUnrecognizedEAnnotationDetails_7009ChildNodeID(domainElement, semanticHint);
		case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)) {
				return EAnnotation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEDataTypeDataTypeAnnotations_7010ChildNodeID(domainElement, semanticHint);
		case EEnumLiteralsEditPart.VISUAL_ID:
			if ((semanticHint == null || EEnumLiteralEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnumLiteral().isSuperTypeOf(domainElementMetaclass)) {
				return EEnumLiteralEditPart.VISUAL_ID;
			}
			return getUnrecognizedEEnumLiterals_7011ChildNodeID(domainElement, semanticHint);
		case EEnumEnumAnnotationsEditPart.VISUAL_ID:
			if ((semanticHint == null || EAnnotation2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)) {
				return EAnnotation2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEEnumEnumAnnotations_7012ChildNodeID(domainElement, semanticHint);
		case EPackageEditPart.VISUAL_ID:
			if ((semanticHint == null || EClassEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEClass().isSuperTypeOf(domainElementMetaclass)) {
				return EClassEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EPackage2EditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEPackage().isSuperTypeOf(domainElementMetaclass)) {
				return EPackage2EditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EAnnotationEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEAnnotation().isSuperTypeOf(domainElementMetaclass)) {
				return EAnnotationEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EDataTypeEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEDataType().isSuperTypeOf(domainElementMetaclass)
					&& (domainElement == null || evaluate(EDataType_2004_Constraint, domainElement))) {
				return EDataTypeEditPart.VISUAL_ID;
			}
			if ((semanticHint == null || EEnumEditPart.VISUAL_ID == nodeVisualID) && EcorePackage.eINSTANCE.getEEnum().isSuperTypeOf(domainElementMetaclass)) {
				return EEnumEditPart.VISUAL_ID;
			}
			return getUnrecognizedEPackage_1000ChildNodeID(domainElement, semanticHint);
		case EReferenceEditPart.VISUAL_ID:
			if (EReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return EReferenceNameEditPart.VISUAL_ID;
			}
			if (EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID == nodeVisualID) {
				return EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID;
			}
			return getUnrecognizedEReference_4002LinkLabelID(semanticHint);
		case EReference2EditPart.VISUAL_ID:
			if (EReferenceName2EditPart.VISUAL_ID == nodeVisualID) {
				return EReferenceName2EditPart.VISUAL_ID;
			}
			if (EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID == nodeVisualID) {
				return EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID;
			}
			return getUnrecognizedEReference_4003LinkLabelID(semanticHint);
		}
		return getUnrecognizedNodeID(containerView, domainElement);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {
		if (EcorePackage.eINSTANCE.getEReference().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || evaluate(EReference_4002_Constraint, domainElement))) {
			return EReferenceEditPart.VISUAL_ID;
		}
		if (EcorePackage.eINSTANCE.getEReference().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || evaluate(EReference_4003_Constraint, domainElement))) {
			return EReference2EditPart.VISUAL_ID;
		}
		return getUnrecognizedLinkWithClassID(domainElement);
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(EPackage element) {
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
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedNodeID(View containerView, EObject domainElement) {
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
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEClass_2001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackage_2002ChildNodeID(EObject domainElement, String semanticHint) {
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
	private static int getUnrecognizedEDataType_2004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEEnum_2005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEAttribute_3001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEOperation_3002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEAnnotation_3003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEClass_3004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackage_3005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEDataType_3006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEEnum_3007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEStringToStringMapEntry_3008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEEnumLiteral_3009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEClassAttributes_7001ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEClassOperations_7002ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEClassClassAnnotations_7003ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackageClasses_7004ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackagePackages_7005ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackageDataTypes_7006ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackageEnums_7007ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackagePackageAnnotations_7008ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEAnnotationDetails_7009ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEDataTypeDataTypeAnnotations_7010ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEEnumLiterals_7011ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEEnumEnumAnnotations_7012ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEPackage_1000ChildNodeID(EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEReference_4002LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static int getUnrecognizedEReference_4003LinkLabelID(String semanticHint) {
		return -1;
	}

	/**
	 * @generated
	 */
	private static boolean evaluate(EcoreAbstractExpression expression, Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
