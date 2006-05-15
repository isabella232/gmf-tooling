package org.eclipse.gmf.ecore.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_detailsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation_sourceEditPart;
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
import org.eclipse.gmf.ecore.edit.parts.EDataType_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_enumannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_literalsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_classesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_datatypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_enumsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packageannotationsEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage_packagesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_name2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference_nameEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;

import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;

import org.eclipse.gmf.ecore.view.factories.EAnnotation2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotationViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotation_detailsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAnnotation_sourceViewFactory;
import org.eclipse.gmf.ecore.view.factories.EAttributeViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClassViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass_attributesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass_classannotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass_nameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EClass_operationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataType2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataTypeViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataType_datatypeannotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EDataType_nameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnum2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumLiteralViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnumViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnum_enumannotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnum_literalsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EEnum_nameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EOperationViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage3ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackageViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_classesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_datatypesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_enumsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_nameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_packageannotationsViewFactory;
import org.eclipse.gmf.ecore.view.factories.EPackage_packagesViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReference2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReferenceViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReference_name2ViewFactory;
import org.eclipse.gmf.ecore.view.factories.EReference_nameViewFactory;
import org.eclipse.gmf.ecore.view.factories.EStringToStringMapEntryViewFactory;
import org.eclipse.gmf.ecore.view.factories.ESuperTypesViewFactory;
import org.eclipse.gmf.ecore.view.factories.ReferencesViewFactory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

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
		if (semanticAdapter.getAdapter(IElementType.class) != null && EcoreElementTypes.getElement(semanticAdapter) == null) {
			return null;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = EcoreVisualIDRegistry.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);

		switch (nodeVID) {
		case EClassEditPart.VISUAL_ID:
			return EClassViewFactory.class;
		case EClass_nameEditPart.VISUAL_ID:
			return EClass_nameViewFactory.class;
		case EPackage2EditPart.VISUAL_ID:
			return EPackage2ViewFactory.class;
		case EPackage_nameEditPart.VISUAL_ID:
			return EPackage_nameViewFactory.class;
		case EAnnotation2EditPart.VISUAL_ID:
			return EAnnotation2ViewFactory.class;
		case EAnnotation_sourceEditPart.VISUAL_ID:
			return EAnnotation_sourceViewFactory.class;
		case EDataType2EditPart.VISUAL_ID:
			return EDataType2ViewFactory.class;
		case EDataType_nameEditPart.VISUAL_ID:
			return EDataType_nameViewFactory.class;
		case EEnum2EditPart.VISUAL_ID:
			return EEnum2ViewFactory.class;
		case EEnum_nameEditPart.VISUAL_ID:
			return EEnum_nameViewFactory.class;
		case EAttributeEditPart.VISUAL_ID:
			return EAttributeViewFactory.class;
		case EOperationEditPart.VISUAL_ID:
			return EOperationViewFactory.class;
		case EAnnotationEditPart.VISUAL_ID:
			return EAnnotationViewFactory.class;
		case EClass2EditPart.VISUAL_ID:
			return EClass2ViewFactory.class;
		case EPackage3EditPart.VISUAL_ID:
			return EPackage3ViewFactory.class;
		case EDataTypeEditPart.VISUAL_ID:
			return EDataTypeViewFactory.class;
		case EEnumEditPart.VISUAL_ID:
			return EEnumViewFactory.class;
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return EStringToStringMapEntryViewFactory.class;
		case EEnumLiteralEditPart.VISUAL_ID:
			return EEnumLiteralViewFactory.class;
		case EClass_attributesEditPart.VISUAL_ID:
			return EClass_attributesViewFactory.class;
		case EClass_operationsEditPart.VISUAL_ID:
			return EClass_operationsViewFactory.class;
		case EClass_classannotationsEditPart.VISUAL_ID:
			return EClass_classannotationsViewFactory.class;
		case EPackage_classesEditPart.VISUAL_ID:
			return EPackage_classesViewFactory.class;
		case EPackage_packagesEditPart.VISUAL_ID:
			return EPackage_packagesViewFactory.class;
		case EPackage_datatypesEditPart.VISUAL_ID:
			return EPackage_datatypesViewFactory.class;
		case EPackage_enumsEditPart.VISUAL_ID:
			return EPackage_enumsViewFactory.class;
		case EPackage_packageannotationsEditPart.VISUAL_ID:
			return EPackage_packageannotationsViewFactory.class;
		case EAnnotation_detailsEditPart.VISUAL_ID:
			return EAnnotation_detailsViewFactory.class;
		case EDataType_datatypeannotationsEditPart.VISUAL_ID:
			return EDataType_datatypeannotationsViewFactory.class;
		case EEnum_literalsEditPart.VISUAL_ID:
			return EEnum_literalsViewFactory.class;
		case EEnum_enumannotationsEditPart.VISUAL_ID:
			return EEnum_enumannotationsViewFactory.class;
		case EReference_nameEditPart.VISUAL_ID:
			return EReference_nameViewFactory.class;
		case EReference_name2EditPart.VISUAL_ID:
			return EReference_name2ViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (semanticAdapter.getAdapter(IElementType.class) != null && EcoreElementTypes.getElement(semanticAdapter) == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (EcoreElementTypes.EAnnotationReferences_3001.equals(elementType)) {
			return ReferencesViewFactory.class;
		}
		if (EcoreElementTypes.EClassESuperTypes_3004.equals(elementType)) {
			return ESuperTypesViewFactory.class;
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
