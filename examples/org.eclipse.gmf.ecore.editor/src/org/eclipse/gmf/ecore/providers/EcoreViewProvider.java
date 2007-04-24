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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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
		if (elementType != null && !EcoreElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = EcoreVisualIDRegistry.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
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
		if (elementType != null && !EcoreElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		if (EcoreElementTypes.EAnnotationReferences_4001.equals(elementType)) {
			return EAnnotationReferencesViewFactory.class;
		}
		if (EcoreElementTypes.EClassESuperTypes_4004.equals(elementType)) {
			return EClassESuperTypesViewFactory.class;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = EcoreVisualIDRegistry.getLinkWithClassVisualID(semanticElement, semanticType);
		switch (linkVID) {
		case EReferenceEditPart.VISUAL_ID:
			return EReferenceViewFactory.class;
		case EReference2EditPart.VISUAL_ID:
			return EReference2ViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);
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

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
