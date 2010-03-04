/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
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

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationReferencesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassESuperTypesEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackageEditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class EcoreElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private EcoreElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType EPackage_1000 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EClass_2001 = getElementType("org.eclipse.gmf.ecore.editor.EClass_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EPackage_2002 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_2003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EDataType_2004 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EEnum_2005 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EAttribute_3001 = getElementType("org.eclipse.gmf.ecore.editor.EAttribute_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EOperation_3002 = getElementType("org.eclipse.gmf.ecore.editor.EOperation_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_3003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EClass_3004 = getElementType("org.eclipse.gmf.ecore.editor.EClass_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EPackage_3005 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EDataType_3006 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EEnum_3007 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EStringToStringMapEntry_3008 = getElementType("org.eclipse.gmf.ecore.editor.EStringToStringMapEntry_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EEnumLiteral_3009 = getElementType("org.eclipse.gmf.ecore.editor.EEnumLiteral_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EAnnotationReferences_4001 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotationReferences_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EReference_4002 = getElementType("org.eclipse.gmf.ecore.editor.EReference_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EReference_4003 = getElementType("org.eclipse.gmf.ecore.editor.EReference_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EClassESuperTypes_4004 = getElementType("org.eclipse.gmf.ecore.editor.EClassESuperTypes_4004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EcoreDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(EPackage_1000, EcorePackage.eINSTANCE.getEPackage());

			elements.put(EClass_2001, EcorePackage.eINSTANCE.getEClass());

			elements.put(EPackage_2002, EcorePackage.eINSTANCE.getEPackage());

			elements.put(EAnnotation_2003, EcorePackage.eINSTANCE.getEAnnotation());

			elements.put(EDataType_2004, EcorePackage.eINSTANCE.getEDataType());

			elements.put(EEnum_2005, EcorePackage.eINSTANCE.getEEnum());

			elements.put(EAttribute_3001, EcorePackage.eINSTANCE.getEAttribute());

			elements.put(EOperation_3002, EcorePackage.eINSTANCE.getEOperation());

			elements.put(EAnnotation_3003, EcorePackage.eINSTANCE.getEAnnotation());

			elements.put(EClass_3004, EcorePackage.eINSTANCE.getEClass());

			elements.put(EPackage_3005, EcorePackage.eINSTANCE.getEPackage());

			elements.put(EDataType_3006, EcorePackage.eINSTANCE.getEDataType());

			elements.put(EEnum_3007, EcorePackage.eINSTANCE.getEEnum());

			elements.put(EStringToStringMapEntry_3008, EcorePackage.eINSTANCE.getEStringToStringMapEntry());

			elements.put(EEnumLiteral_3009, EcorePackage.eINSTANCE.getEEnumLiteral());

			elements.put(EAnnotationReferences_4001, EcorePackage.eINSTANCE.getEAnnotation_References());

			elements.put(EReference_4002, EcorePackage.eINSTANCE.getEReference());

			elements.put(EReference_4003, EcorePackage.eINSTANCE.getEReference());

			elements.put(EClassESuperTypes_4004, EcorePackage.eINSTANCE.getEClass_ESuperTypes());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(EPackage_1000);
			KNOWN_ELEMENT_TYPES.add(EClass_2001);
			KNOWN_ELEMENT_TYPES.add(EPackage_2002);
			KNOWN_ELEMENT_TYPES.add(EAnnotation_2003);
			KNOWN_ELEMENT_TYPES.add(EDataType_2004);
			KNOWN_ELEMENT_TYPES.add(EEnum_2005);
			KNOWN_ELEMENT_TYPES.add(EAttribute_3001);
			KNOWN_ELEMENT_TYPES.add(EOperation_3002);
			KNOWN_ELEMENT_TYPES.add(EAnnotation_3003);
			KNOWN_ELEMENT_TYPES.add(EClass_3004);
			KNOWN_ELEMENT_TYPES.add(EPackage_3005);
			KNOWN_ELEMENT_TYPES.add(EDataType_3006);
			KNOWN_ELEMENT_TYPES.add(EEnum_3007);
			KNOWN_ELEMENT_TYPES.add(EStringToStringMapEntry_3008);
			KNOWN_ELEMENT_TYPES.add(EEnumLiteral_3009);
			KNOWN_ELEMENT_TYPES.add(EAnnotationReferences_4001);
			KNOWN_ELEMENT_TYPES.add(EReference_4002);
			KNOWN_ELEMENT_TYPES.add(EReference_4003);
			KNOWN_ELEMENT_TYPES.add(EClassESuperTypes_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case EPackageEditPart.VISUAL_ID:
			return EPackage_1000;
		case EClassEditPart.VISUAL_ID:
			return EClass_2001;
		case EPackage2EditPart.VISUAL_ID:
			return EPackage_2002;
		case EAnnotationEditPart.VISUAL_ID:
			return EAnnotation_2003;
		case EDataTypeEditPart.VISUAL_ID:
			return EDataType_2004;
		case EEnumEditPart.VISUAL_ID:
			return EEnum_2005;
		case EAttributeEditPart.VISUAL_ID:
			return EAttribute_3001;
		case EOperationEditPart.VISUAL_ID:
			return EOperation_3002;
		case EAnnotation2EditPart.VISUAL_ID:
			return EAnnotation_3003;
		case EClass2EditPart.VISUAL_ID:
			return EClass_3004;
		case EPackage3EditPart.VISUAL_ID:
			return EPackage_3005;
		case EDataType2EditPart.VISUAL_ID:
			return EDataType_3006;
		case EEnum2EditPart.VISUAL_ID:
			return EEnum_3007;
		case EStringToStringMapEntryEditPart.VISUAL_ID:
			return EStringToStringMapEntry_3008;
		case EEnumLiteralEditPart.VISUAL_ID:
			return EEnumLiteral_3009;
		case EAnnotationReferencesEditPart.VISUAL_ID:
			return EAnnotationReferences_4001;
		case EReferenceEditPart.VISUAL_ID:
			return EReference_4002;
		case EReference2EditPart.VISUAL_ID:
			return EReference_4003;
		case EClassESuperTypesEditPart.VISUAL_ID:
			return EClassESuperTypes_4004;
		}
		return null;
	}

}
