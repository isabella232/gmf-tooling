package org.eclipse.gmf.ecore.edit.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.ecore.editor.EcoreVisualIDRegistry;

import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation3ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation4ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation5ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotationViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation_detailsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAnnotation_source3ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EAttributeViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClass2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClassViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClass_attributesViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClass_classannotationsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClass_nameViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EClass_operationsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EDataType2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EDataTypeViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EDataType_datatypeannotationsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EDataType_name2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnum2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnumLiteralViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnumViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnum_enumannotationsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnum_literalsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EEnum_name2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EOperationViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage3ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackageViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_classesViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_datatypesViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_enumsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_nameViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_packageannotationsViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EPackage_packagesViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReference2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReferenceViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReference_name2TextViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReference_name2ViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReference_nameTextViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EReference_nameViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.EStringToStringMapEntryViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.ESuperTypesViewFactory;
import org.eclipse.gmf.ecore.editor.view.factories.ReferencesViewFactory;

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
		if ("Ecore".equals(diagramKind) && EcoreVisualIDRegistry.INSTANCE.getDiagramVisualID(semanticElement) != -1) { //$NON-NLS-1$
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

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(containerView, semanticElement, semanticType, semanticHint);

		switch (nodeVID) {
		case 1001:
			return EClassViewFactory.class;
		case 4001:
			return EClass_nameViewFactory.class;
		case 1002:
			return EPackage2ViewFactory.class;
		case 4005:
			return EPackage_nameViewFactory.class;
		case 1003:
			return EAnnotation3ViewFactory.class;
		case 4011:
			return EAnnotation_source3ViewFactory.class;
		case 1004:
			return EDataType2ViewFactory.class;
		case 4013:
			return EDataType_name2ViewFactory.class;
		case 1005:
			return EEnum2ViewFactory.class;
		case 4015:
			return EEnum_name2ViewFactory.class;
		case 2001:
			return EAttributeViewFactory.class;
		case 2002:
			return EOperationViewFactory.class;
		case 2003:
			return EAnnotationViewFactory.class;
		case 2004:
			return EClass2ViewFactory.class;
		case 2005:
			return EPackage3ViewFactory.class;
		case 2006:
			return EDataTypeViewFactory.class;
		case 2007:
			return EEnumViewFactory.class;
		case 2008:
			return EAnnotation2ViewFactory.class;
		case 2009:
			return EStringToStringMapEntryViewFactory.class;
		case 2010:
			return EAnnotation4ViewFactory.class;
		case 2011:
			return EEnumLiteralViewFactory.class;
		case 2012:
			return EAnnotation5ViewFactory.class;
		case 5001:
			return EClass_attributesViewFactory.class;
		case 5002:
			return EClass_operationsViewFactory.class;
		case 5003:
			return EClass_classannotationsViewFactory.class;
		case 5004:
			return EPackage_classesViewFactory.class;
		case 5005:
			return EPackage_packagesViewFactory.class;
		case 5006:
			return EPackage_datatypesViewFactory.class;
		case 5007:
			return EPackage_enumsViewFactory.class;
		case 5008:
			return EPackage_packageannotationsViewFactory.class;
		case 5009:
			return EAnnotation_detailsViewFactory.class;
		case 5010:
			return EDataType_datatypeannotationsViewFactory.class;
		case 5011:
			return EEnum_literalsViewFactory.class;
		case 5012:
			return EEnum_enumannotationsViewFactory.class;
		case 4018:
			if (EcoreSemanticHints.EReference_3002Labels.EREFERENCENAME_4018_LABEL.equals(semanticHint)) {
				return EReference_nameViewFactory.class;
			} else {
				return EReference_nameTextViewFactory.class;
			}
		case 4019:
			if (EcoreSemanticHints.EReference_3003Labels.EREFERENCENAME_4019_LABEL.equals(semanticHint)) {
				return EReference_name2ViewFactory.class;
			} else {
				return EReference_name2TextViewFactory.class;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		IElementType elementType = (IElementType) semanticAdapter.getAdapter(IElementType.class);
		if (EcoreElementTypes.EAnnotationReferences_3001.equals(elementType)) {
			return ReferencesViewFactory.class;
		}
		if (EcoreElementTypes.EClassESuperTypes_3004.equals(elementType)) {
			return ESuperTypesViewFactory.class;
		}

		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);

		int linkVID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(semanticElement, semanticType);

		switch (linkVID) {
		case 3002:
			return EReferenceViewFactory.class;
		case 3003:
			return EReference2ViewFactory.class;
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter, containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
