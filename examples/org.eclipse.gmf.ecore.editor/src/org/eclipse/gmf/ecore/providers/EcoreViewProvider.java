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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationDetailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationSourceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassAttributesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassClassAnnotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassESuperTypesEditPart;
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
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.ecore.view.factories.EAnnotation2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotationDetailsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotationReferencesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotationSourceViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotationViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAttributeViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassAttributesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassClassAnnotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassESuperTypesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassNameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassOperationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataType2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataTypeDataTypeAnnotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataTypeNameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataTypeViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnum2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumEnumAnnotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumLiteralViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumLiteralsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumNameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumViewFactory;
import org.eclipse.gmf.ecore.view.factories.EOperationViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage3ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageClassesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageDataTypesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageEnumsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageNameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackagePackageAnnotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackagePackagesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReference2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceLowerBoundUpperBound2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceLowerBoundUpperBoundViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceName2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceNameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceViewFactory;
import org.eclipse.gmf.ecore.view.factories.EStringToStringMapEntryViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (EPackageEditPart.MODEL_ID.equals(diagramKind) && EcoreVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return EPackageViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = EcoreVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!EcoreElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!EPackageEditPart.MODEL_ID.equals(EcoreVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case EClassEditPart.VISUAL_ID:
				case EAttributeEditPart.VISUAL_ID:
				case EOperationEditPart.VISUAL_ID:
				case EAnnotation2EditPart.VISUAL_ID:
				case EDataType2EditPart.VISUAL_ID:
				case EEnum2EditPart.VISUAL_ID:
				case EStringToStringMapEntryEditPart.VISUAL_ID:
				case EEnumLiteralEditPart.VISUAL_ID:
				case EPackage2EditPart.VISUAL_ID:
				case EAnnotationEditPart.VISUAL_ID:
				case EDataTypeEditPart.VISUAL_ID:
				case EEnumEditPart.VISUAL_ID:
				case EClass2EditPart.VISUAL_ID:
				case EPackage3EditPart.VISUAL_ID:
					if (domainElement == null || visualID != EcoreVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case EClassNameEditPart.VISUAL_ID:
				case EClassAttributesEditPart.VISUAL_ID:
				case EClassOperationsEditPart.VISUAL_ID:
				case EClassClassAnnotationsEditPart.VISUAL_ID:
					if (EClassEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EPackageNameEditPart.VISUAL_ID:
				case EPackageClassesEditPart.VISUAL_ID:
				case EPackagePackagesEditPart.VISUAL_ID:
				case EPackageDataTypesEditPart.VISUAL_ID:
				case EPackageEnumsEditPart.VISUAL_ID:
				case EPackagePackageAnnotationsEditPart.VISUAL_ID:
					if (EPackage2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EAnnotationSourceEditPart.VISUAL_ID:
				case EAnnotationDetailsEditPart.VISUAL_ID:
					if (EAnnotationEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EDataTypeNameEditPart.VISUAL_ID:
				case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
					if (EDataTypeEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EEnumNameEditPart.VISUAL_ID:
				case EEnumLiteralsEditPart.VISUAL_ID:
				case EEnumEnumAnnotationsEditPart.VISUAL_ID:
					if (EEnumEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EReferenceNameEditPart.VISUAL_ID:
				case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
					if (EReferenceEditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EReferenceName2EditPart.VISUAL_ID:
				case EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID:
					if (EReference2EditPart.VISUAL_ID != EcoreVisualIDRegistry.getVisualID(containerView) || containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null || !EcoreVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case EClassEditPart.VISUAL_ID:
			return EClassViewFactory.class;
		case EClassNameEditPart.VISUAL_ID:
			return EClassNameViewFactory.class;
		case EPackage2EditPart.VISUAL_ID:
			return EPackage2ViewFactory.class;
		case EPackageNameEditPart.VISUAL_ID:
			return EPackageNameViewFactory.class;
		case EAnnotationEditPart.VISUAL_ID:
			return EAnnotationViewFactory.class;
		case EAnnotationSourceEditPart.VISUAL_ID:
			return EAnnotationSourceViewFactory.class;
		case EDataTypeEditPart.VISUAL_ID:
			return EDataTypeViewFactory.class;
		case EDataTypeNameEditPart.VISUAL_ID:
			return EDataTypeNameViewFactory.class;
		case EEnumEditPart.VISUAL_ID:
			return EEnumViewFactory.class;
		case EEnumNameEditPart.VISUAL_ID:
			return EEnumNameViewFactory.class;
		case EAttributeEditPart.VISUAL_ID:
			return EAttributeViewFactory.class;
		case EOperationEditPart.VISUAL_ID:
			return EOperationViewFactory.class;
		case EAnnotation2EditPart.VISUAL_ID:
			return EAnnotation2ViewFactory.class;
		case EClass2EditPart.VISUAL_ID:
			return EClass2ViewFactory.class;
		case EPackage3EditPart.VISUAL_ID:
			return EPackage3ViewFactory.class;
		case EDataType2EditPart.VISUAL_ID:
			return EDataType2ViewFactory.class;
		case EEnum2EditPart.VISUAL_ID:
			return EEnum2ViewFactory.class;
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return EStringToStringMapEntryViewFactory.class;
		case EEnumLiteralEditPart.VISUAL_ID:
			return EEnumLiteralViewFactory.class;
		case EClassAttributesEditPart.VISUAL_ID:
			return EClassAttributesViewFactory.class;
		case EClassOperationsEditPart.VISUAL_ID:
			return EClassOperationsViewFactory.class;
		case EClassClassAnnotationsEditPart.VISUAL_ID:
			return EClassClassAnnotationsViewFactory.class;
		case EPackageClassesEditPart.VISUAL_ID:
			return EPackageClassesViewFactory.class;
		case EPackagePackagesEditPart.VISUAL_ID:
			return EPackagePackagesViewFactory.class;
		case EPackageDataTypesEditPart.VISUAL_ID:
			return EPackageDataTypesViewFactory.class;
		case EPackageEnumsEditPart.VISUAL_ID:
			return EPackageEnumsViewFactory.class;
		case EPackagePackageAnnotationsEditPart.VISUAL_ID:
			return EPackagePackageAnnotationsViewFactory.class;
		case EAnnotationDetailsEditPart.VISUAL_ID:
			return EAnnotationDetailsViewFactory.class;
		case EDataTypeDataTypeAnnotationsEditPart.VISUAL_ID:
			return EDataTypeDataTypeAnnotationsViewFactory.class;
		case EEnumLiteralsEditPart.VISUAL_ID:
			return EEnumLiteralsViewFactory.class;
		case EEnumEnumAnnotationsEditPart.VISUAL_ID:
			return EEnumEnumAnnotationsViewFactory.class;
		case EReferenceNameEditPart.VISUAL_ID:
			return EReferenceNameViewFactory.class;
		case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
			return EReferenceLowerBoundUpperBoundViewFactory.class;
		case EReferenceName2EditPart.VISUAL_ID:
			return EReferenceName2ViewFactory.class;
		case EReferenceLowerBoundUpperBound2EditPart.VISUAL_ID:
			return EReferenceLowerBoundUpperBound2ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!EcoreElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = EcoreVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null && visualID != EcoreVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return EAnnotationReferencesViewFactory.class;
		case EReferenceEditPart.VISUAL_ID:
			return EReferenceViewFactory.class;
		case EReference2EditPart.VISUAL_ID:
			return EReference2ViewFactory.class;
		case EClassESuperTypesEditPart.VISUAL_ID:
			return EClassESuperTypesViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

}
