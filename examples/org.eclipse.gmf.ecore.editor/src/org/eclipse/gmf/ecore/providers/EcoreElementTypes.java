/**
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;

import org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin;

/**
 * @generated
 */
public class EcoreElementTypes {

	/**
	 * @generated
	 */
	private EcoreElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

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
			element = ((EStructuralFeature) element).getEContainingClass();
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
			elements = new IdentityHashMap();
			elements.put(EPackage_1000, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EAttribute_3001, EcorePackage.eINSTANCE.getEAttribute());
			elements.put(EOperation_3002, EcorePackage.eINSTANCE.getEOperation());
			elements.put(EAnnotation_3003, EcorePackage.eINSTANCE.getEAnnotation());
			elements.put(EClass_3004, EcorePackage.eINSTANCE.getEClass());
			elements.put(EPackage_3005, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EDataType_3006, EcorePackage.eINSTANCE.getEDataType());
			elements.put(EEnum_3007, EcorePackage.eINSTANCE.getEEnum());
			elements.put(EStringToStringMapEntry_3008, EcorePackage.eINSTANCE.getEStringToStringMapEntry());
			elements.put(EEnumLiteral_3009, EcorePackage.eINSTANCE.getEEnumLiteral());
			elements.put(EClass_2001, EcorePackage.eINSTANCE.getEClass());
			elements.put(EPackage_2002, EcorePackage.eINSTANCE.getEPackage());
			elements.put(EAnnotation_2003, EcorePackage.eINSTANCE.getEAnnotation());
			elements.put(EDataType_2004, EcorePackage.eINSTANCE.getEDataType());
			elements.put(EEnum_2005, EcorePackage.eINSTANCE.getEEnum());
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
	public static final IElementType EPackage_1000 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_1000");

	/**
	 * @generated
	 */
	public static final IElementType EAttribute_3001 = getElementType("org.eclipse.gmf.ecore.editor.EAttribute_3001");

	/**
	 * @generated
	 */
	public static final IElementType EOperation_3002 = getElementType("org.eclipse.gmf.ecore.editor.EOperation_3002");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_3003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_3003");

	/**
	 * @generated
	 */
	public static final IElementType EClass_3004 = getElementType("org.eclipse.gmf.ecore.editor.EClass_3004");

	/**
	 * @generated
	 */
	public static final IElementType EPackage_3005 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_3005");

	/**
	 * @generated
	 */
	public static final IElementType EDataType_3006 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_3006");

	/**
	 * @generated
	 */
	public static final IElementType EEnum_3007 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_3007");

	/**
	 * @generated
	 */
	public static final IElementType EStringToStringMapEntry_3008 = getElementType("org.eclipse.gmf.ecore.editor.EStringToStringMapEntry_3008");

	/**
	 * @generated
	 */
	public static final IElementType EEnumLiteral_3009 = getElementType("org.eclipse.gmf.ecore.editor.EEnumLiteral_3009");

	/**
	 * @generated
	 */
	public static final IElementType EClass_2001 = getElementType("org.eclipse.gmf.ecore.editor.EClass_2001");

	/**
	 * @generated
	 */
	public static final IElementType EPackage_2002 = getElementType("org.eclipse.gmf.ecore.editor.EPackage_2002");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotation_2003 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotation_2003");

	/**
	 * @generated
	 */
	public static final IElementType EDataType_2004 = getElementType("org.eclipse.gmf.ecore.editor.EDataType_2004");

	/**
	 * @generated
	 */
	public static final IElementType EEnum_2005 = getElementType("org.eclipse.gmf.ecore.editor.EEnum_2005");

	/**
	 * @generated
	 */
	public static final IElementType EAnnotationReferences_4001 = getElementType("org.eclipse.gmf.ecore.editor.EAnnotationReferences_4001");

	/**
	 * @generated
	 */
	public static final IElementType EReference_4002 = getElementType("org.eclipse.gmf.ecore.editor.EReference_4002");

	/**
	 * @generated
	 */
	public static final IElementType EReference_4003 = getElementType("org.eclipse.gmf.ecore.editor.EReference_4003");

	/**
	 * @generated
	 */
	public static final IElementType EClassESuperTypes_4004 = getElementType("org.eclipse.gmf.ecore.editor.EClassESuperTypes_4004");

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(EPackage_1000);
			KNOWN_ELEMENT_TYPES.add(EAttribute_3001);
			KNOWN_ELEMENT_TYPES.add(EOperation_3002);
			KNOWN_ELEMENT_TYPES.add(EAnnotation_3003);
			KNOWN_ELEMENT_TYPES.add(EClass_3004);
			KNOWN_ELEMENT_TYPES.add(EPackage_3005);
			KNOWN_ELEMENT_TYPES.add(EDataType_3006);
			KNOWN_ELEMENT_TYPES.add(EEnum_3007);
			KNOWN_ELEMENT_TYPES.add(EStringToStringMapEntry_3008);
			KNOWN_ELEMENT_TYPES.add(EEnumLiteral_3009);
			KNOWN_ELEMENT_TYPES.add(EClass_2001);
			KNOWN_ELEMENT_TYPES.add(EPackage_2002);
			KNOWN_ELEMENT_TYPES.add(EAnnotation_2003);
			KNOWN_ELEMENT_TYPES.add(EDataType_2004);
			KNOWN_ELEMENT_TYPES.add(EEnum_2005);
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
	public static class Initializers {

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_4002 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(EcoreOCLFactory.getExpression("false", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference()), EcorePackage.eINSTANCE.getEReference_Containment()) });

		/**
		 * @generated
		 */
		public static final ObjectInitializer EReference_4003 = new ObjectInitializer(new FeatureInitializer[] { new FeatureInitializer(EcoreOCLFactory.getExpression("true", //$NON-NLS-1$
				EcorePackage.eINSTANCE.getEReference()), EcorePackage.eINSTANCE.getEReference_Containment()) });

		/** 
		 * @generated
		 */
		private Initializers() {
		}

		/** 
		 * @generated
		 */
		public static class ObjectInitializer {

			/** 
			 * @generated
			 */
			private FeatureInitializer[] initExpressions;

			/** 
			 * @generated
			 */
			ObjectInitializer(FeatureInitializer[] initExpressions) {
				this.initExpressions = initExpressions;
			}

			/** 
			 * @generated
			 */
			public void init(EObject instance) {
				for (int i = 0; i < initExpressions.length; i++) {
					FeatureInitializer nextExpr = initExpressions[i];
					try {
						nextExpr.init(instance);
					} catch (RuntimeException e) {
						EcoreDiagramEditorPlugin.getInstance().logError("Feature initialization failed", e); //$NON-NLS-1$						
					}
				}
			}
		} // end of ObjectInitializer

		/** 
		 * @generated
		 */
		static class FeatureInitializer {

			/** 
			 * @generated
			 */
			private EStructuralFeature sFeature;

			/** 
			 * @generated
			 */
			private EcoreAbstractExpression expression;

			/**
			 * @generated
			 */
			FeatureInitializer(EcoreAbstractExpression expression, EStructuralFeature sFeature) {
				this.sFeature = sFeature;
				this.expression = expression;
			}

			/** 
			 * @generated
			 */
			void init(EObject contextInstance) {
				Object value = expression.evaluate(contextInstance);
				if (sFeature.getEType() instanceof EEnum && value instanceof EEnumLiteral) {
					value = ((EEnumLiteral) value).getInstance();
				} else if (sFeature.isMany() && value instanceof Collection) {
					Collection destCollection = (Collection) contextInstance.eGet(sFeature);
					destCollection.clear();
					Collection valueCollection = (Collection) value;
					for (Iterator it = valueCollection.iterator(); it.hasNext();) {
						destCollection.add(it.next());
					}
					return;
				}
				contextInstance.eSet(sFeature, value);
			}
		} // end of FeatureInitializer
	} // end of Initializers
}
